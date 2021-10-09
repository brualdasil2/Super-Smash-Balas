public class SmashPlayer extends Player {
	
	
	public SmashPlayer(Game game, int playerNumb, Character character, double x, double y, String name) {
		super(game, playerNumb, character, x, y, name);
	}
	
	protected boolean checkOnAir() {
		if (currentAttack.getCollisionbox() != null) {
			
			double MyCollisionRightX = x + currentAttack.getCollisionbox().getX() + currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY() + currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX)/2;
			
			if (y + currentFrame.getHeight() < GameState.floorY || MyCollisionRightX < GameState.smashStageLeft || MyCollisionLeftX > GameState.smashStageRight) {
				return true;
			}
			return false;
		}
		
		
		return false;
	}
	
	protected void checkCollision() {
		
		if (currentAttack.getCollisionbox() != null) {
			
			double MyCollisionRightX = x + currentAttack.getCollisionbox().getX() + currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY() + currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX)/2;
			
			
			
				
			if (opponent != null) {
				
				
				//collision with opponent
				
				if (MyCollisionBottomY >= OpCollisionTopY && MyCollisionTopY <= OpCollisionBottomY) {
					
					if (Math.abs(OpCollisionCenterX - MyCollisionCenterX) <= currentAttack.getCollisionbox().getWidth()/2 + opponent.getCurrentAttack().getCollisionbox().getWidth()/2){
						
						if (OpCollisionCenterX - MyCollisionCenterX > 0) {
							
							if (MyCollisionLeftX != GameState.leftWall)
								x = OpCollisionLeftX - currentAttack.getCollisionbox().getWidth() - currentAttack.getCollisionbox().getX(); //tp left
						}
						
						else if (OpCollisionCenterX - MyCollisionCenterX < 0) {
							
							if (MyCollisionRightX != GameState.rightWall)
								x = OpCollisionRightX - currentAttack.getCollisionbox().getX(); //tp right
						}
						
						else {
							
							if (MyCollisionLeftX == GameState.leftWall) {
								if (MyCollisionTopY < OpCollisionTopY)
									x = OpCollisionRightX - currentAttack.getCollisionbox().getX(); //tp right
							}
							
							else {
								if (MyCollisionTopY < OpCollisionTopY)
									x = OpCollisionLeftX - currentAttack.getCollisionbox().getWidth() - currentAttack.getCollisionbox().getX(); //tp left
								
							}
		
		
						}
						
						opponent.measureCollision();
					}
					
				}
			}

		}
	}
	
	private void checkStageCollision() {
		if (currentAttack.getCollisionbox() != null) {
			
			double MyCollisionRightX = x + currentAttack.getCollisionbox().getX() + currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY() + currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX)/2;
			//collision with stage
			
			
			if (MyCollisionLeftX < GameState.smashStageRight && MyCollisionBottomY > GameState.floorY && MyCollisionLeftX > GameState.smashStageRight - 100) {
						
				x = GameState.smashStageRight - currentAttack.getCollisionbox().getX() + 1;
			}
					
			else if (MyCollisionRightX > GameState.smashStageLeft && MyCollisionBottomY > GameState.floorY && MyCollisionRightX < GameState.smashStageLeft + 100) {
				
				x = GameState.smashStageLeft - currentAttack.getCollisionbox().getWidth() - currentAttack.getCollisionbox().getX() - 1;
			//	x = GameState.rightWall - currentAttack.getCollisionbox().getWidth() - currentAttack.getCollisionbox().getX() - 1;
			}
			
			
		}
	}
	
	public void tick() {
		
		updateImage();
		
		setStanding();
		
		countHitstun();
		
		countFreezeFrames();
		
		countParryFrames();
		
		countInvincibleFrames();
		
		if (frozen)
			countFrozenFrames();

		
		onAir = checkOnAir();
		checkInput();
		
		
			
		//GRAVITY AND KNOCKBACK
		
		
		if (freezeFrames == 0) {
			
			if (onAir) {
				
				gravity();
				
			}
			
			y += ySpeed; 
			x += xSpeed; 
		}
		
		checkStageCollision();
		onAir = checkOnAir();
		System.out.println(onAir);
		
		
		//if on ground
		if (!onAir) {
			
			jumps = character.getJumps(); 
			//if fell on ground
			if (ySpeed != 0 && y + currentFrame.getHeight() < GameState.floorY + ySpeed + 20) {
				
				if (hitstunFrames == 0) {
					
					ySpeed = 0;
					xSpeed = 0;
					y = GameState.floorY - currentFrame.getHeight();
					fastFalling = false;
					
					if (!attacking) {
						
						freezeFrames = GameState.landingLag;
					}
					else {
						
						freezeFrames = GameState.aerialLandingLag;
					}
					
					setStanding();
				}
				else {
					
					y = GameState.floorY - currentFrame.getHeight();
					ySpeed = -ySpeed;
				}
			}
		}
		
		//shield recover
		if (!shielding && (!pressingShield || onAir)) {
			
			shieldRecoverCounter++;
			if (shieldRecoverCounter == 10) {
				
				shieldRecoverCounter = 0;
				
				if (shield < 100) {
	
					shield++;
				}
			}
			
		}
		
		//USING ATTACKS
		
		if (jabbing) {
				
			character.useJab(this);
		}
				
		if (dashing) {
					
			character.useDash(this);
		}
		
		if (upTilting) {
			
			character.useUpTilt(this);
		}
		
		if (bairing) {
			
			character.useBair(this);
		}
		
		if (fairing) {
			
			character.useFair(this);
		}
		
		if (upAiring) {
			
			character.useUpAir(this);
		}
		
		if (sideSpecialing) {
			
			character.useSideSpecial(this);
		}
		
		if (neutralSpecialing) {
			
			character.useNeutralSpecial(this);
		}
		
		if (upSpecialing) {
			
			character.useUpSpecial(this);
		}
		
		if (character instanceof Obino) {
			if (pressingSpecial && !pressingRight && !pressingLeft && !pressingUp)
				((Obino)(character)).closeTrap(this);
		}

			
				
		//COLLISION DETECTION
		

			
		checkCollision();
		
		
		
		
		//HIT DETECTION
		
		if (opponent != null) {

			magicGrabDetection();
		}
		


		
	}
}