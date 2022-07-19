
public class SmashObinoBotEasy extends SmashPlayer{
	
	private int state, rand, frameCounter = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter, offStageOnRight, offStageOnLeft, offStage;
	private boolean trapActive, opponentOnTrap;

	
	public SmashObinoBotEasy(Game game, int playerNumb, Character character, double x, double y) {
		
		super(game, playerNumb, character, x, y, "BOT (F)");
	}
	
	private void checkState() {
		
		if (opponent.character instanceof Carol)
			opponentNear = (Math.abs(opponent.x - x) < 350);
		else
			opponentNear = (Math.abs(opponent.x - x) < 250);
		opponentOnAir = opponent.onAir;
		opponentOnTop = (Math.abs(opponent.x - x) < 50 && opponentOnAir);
		opponentOnLeft = (opponent.x - x < 0);
		opponentOnRight = (opponent.x - x > 0);
		opponentAttacking = opponent.attacking;
		opponentShielding = (opponent.shielding && !opponent.onAir && opponent.shield > 0);
		
		onCenter = (x + currentFrame.getWidth()/2 > 590 && x + currentFrame.getWidth()/2 < 690);
		offStageOnRight = (x + currentFrame.getWidth()/2 > GameState.smashStageRight);
		offStageOnLeft = (x + currentFrame.getWidth()/2 < GameState.smashStageLeft);
		offStage = (offStageOnRight || offStageOnLeft);

		for (int i = 0; i < GameState.projectiles.size(); i++) {
			
			if (GameState.projectiles.get(i) instanceof Bala || GameState.projectiles.get(i) instanceof Nota) {
				
				if (!GameState.projectiles.get(i).getOwner().equals(this)) {
					
					opponentCandyComing = true;
					break;
				}
				else {
					
					opponentCandyComing = false;
				}
			}
			else {
				
				opponentCandyComing = false;
			}
		}
		
		if (GameState.projectiles.isEmpty()) {
			
			opponentCandyComing = false;
		}
		
		trapActive = ((Obino)(character)).trapActive;
		
		for (int i = 0; i < GameState.projectiles.size(); i++) {
			
			if (GameState.projectiles.get(i) instanceof BearTrap) {
				
				if (GameState.projectiles.get(i).getOwner().equals(this)) {
					
					opponentOnTrap = (OpCollisionRightX >= GameState.projectiles.get(i).getX()
								   && OpCollisionLeftX <= GameState.projectiles.get(i).getX() + GameState.projectiles.get(i).getWidth()
								   && OpCollisionBottomY >= 100);
				}
			}
		}
		
		
		
		
	}
		
	
	
	private void pressNothing() {
		
		pressingJump = false;
		pressingAttack = false;
		pressingSpecial = false;
		pressingUp = false;
		pressingShield = false;
		pressingLeft = false;
		pressingRight = false;
		pressingAirdash = false;
	}
	
	private void setState(int state) {
		
		if (this.state != state) {			
			this.state = state;
			frameCounter = 0;
		}
	}
	
	private void setFrames(int frames) {
		
		if (frameCounter == 0)
			frameCounter = frames;
		
		frameCounter--;
	}
	
	private void randomize(int max) {
		
		if (frameCounter == 0)
			rand = (int)(1 + Math.random()*max);
	}
	
	private void slowShield() {
		
		setFrames(40);
		
		if (frameCounter < 26) {
			
			pressingShield = true;
		}
	}
	
	private void shield() {
		
		if (frameCounter == 0)
			frameCounter = 1;
		
		pressingShield = true;
	}
	
	private void stand() {
		
		setFrames(30);
	}
	
	private void dashAway() {
		
		setFrames(20);
		
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	
	private void dashRight() {
		
		setFrames(20);
		pressingRight = true;	
	}
	
	private void dashLeft() {
		
		setFrames(20);
		pressingLeft = true;
	}
	
	private void goToCenter() {
		
		setFrames(30);
		
		if (x + currentFrame.getWidth()/2 > 640) {
			
			pressingLeft = true;
		}
		
		if (x + currentFrame.getWidth()/2 < 640) {
			
			pressingRight = true;
		}
	}
	
	private void goToOpponent() {
		
		setFrames(60);
		
		if (opponentOnLeft) {
			
			pressingLeft = true;
		}
		
		if (opponentOnRight) {
			
			pressingRight = true;
		}
	}
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			pressingLeft = true;	
		if (opponentOnRight)
			pressingRight = true;
	}
	
	private void turnAway() {
		
		if (opponentOnLeft)
			pressingRight = true;	
		if (opponentOnRight)
			pressingLeft = true;
	}
	
	private void jump() {
		
		pressingJump = true;
	}
	
	private void jab() {
		
		setFrames(4);
		
		if (frameCounter == 3 || frameCounter == 2) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 1) {
			
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void dashAttack() {
		
		setFrames(3);
		
		if (frameCounter == 2 || frameCounter == 1) {
			turnToOpponent();
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	
	private void upTilt() {
		
		setFrames(4);
		
		if (frameCounter == 3) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
			pressingUp = true;
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
		
	}
	

	
	private void jumpFair() {
		
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 8) {
			
			pressingJump = true;
			turnToOpponent();
		}
		
		if (frameCounter == 7) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 6) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
		
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void delayedJumpFair() {
		
		
		setFrames(20);
		
		if (frameCounter == 19) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 18) {
			
			pressingJump = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 17 && frameCounter >= 5) {
			
			turnToOpponent();
		}
		
		if (frameCounter < 5) {
			
			turnToOpponent();
			pressingAttack = true;
		}
		
	}
	
	private void jumpBair() {
		
		setFrames(20);
		
		if (frameCounter == 19) {
			
			turnAway();
		}
		
		if (frameCounter == 18) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 17) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 16) {
			
			turnToOpponent();
		}
	}
	
	private void jumpUpAir() {
		
		setFrames(2);
		
		if (frameCounter == 1) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 0) {
			
			pressingUp = true;
			pressingAttack = true;
		}
	}
	
	private void sideSpecial() {
		
		turnToOpponent();
		pressingSpecial = true;
		
		if (parried)
			parried = false;
	}
	
	private void jumpSideSpecial() {
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 0) {
			
			turnToOpponent();
			pressingSpecial = true;
		}
	}
	
	private void upSpecial() {
		
		setFrames(30);
		
		if (frameCounter == 29) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	
	private void jumpUpSpecial() {
		
		setFrames(30);
		
		if (frameCounter == 29) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 20) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	
	private void neutralSpecial() {
		
		pressingSpecial = true;
	}

	private void doNothing() {
		
	}
	private void jumpToCenter() {
		
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			turnToOpponent();
			pressingJump = true;
		}
		
		if (frameCounter <= 8) {
			
			turnToOpponent();
		}
	}
	
	private void airdashToCenter() {
		
		setFrames(15);
		
		if (frameCounter == 14) {
			pressingAirdash = true;
			goToCenter();
		}
		
	}
	
	

	protected void getInput() {
		
		checkState();
		pressNothing();
		
		if (trapActive && opponentOnTrap && !opponentShielding) {
			
			setState(0);	
			randomize(8);
			
			if (rand <= 1)
				neutralSpecial();
			if (rand > 1 && rand <= 8)
				stand();
			
		}
		else {
		
			


if (offStage) {
			setState(-1);
			randomize(10);
			
			if (rand <= 1)
				doNothing();
			if (rand > 1 && rand <= 4)
				goToCenter();
			if (rand > 4 && rand <= 7)
				jumpToCenter();
			if (rand > 7 && rand <= 10)
				airdashToCenter();
			
		}
		else if (opponentNear) {
				
				if (opponentAttacking) {
					
					if (!shieldStun && freezeFrames == 0 && (defended || parried)) {
						
						setState(1);
						randomize(10);
	
						
						if (rand <= 2)
							jab();
						if (rand > 2 && rand <= 3)
							dashAttack();
						if (rand > 3 && rand <= 5)
							stand();
						if (rand > 5 && rand <= 8)
							dashAway();
						if (rand > 8 && rand <= 10)
							jump();
						
					}
					
					else if (!(defended || parried)) {
						
			
						setState(2);
						randomize(10);
	
						if (rand <= 1) 
							shield();
						if (rand > 1 && rand <= 4)
							slowShield();
						if (rand > 4 && rand <= 6)
							dashAway();
						if (rand > 6 && rand <= 8)
							jump();
						if (rand > 8 && rand <= 9)
							jumpFair();
						if (rand > 9 && rand <= 10)
							upTilt();
						
					}
				}
				
				else if (!opponentAttacking) {
					
					if (opponent.getHitstunFrames() >= 30) {
						
						if (hitstunFrames == 0) {
							setState(3);
							randomize(5);
							
							if (rand <= 1)
								jab();
							if (rand > 1 && rand <= 2)
								dashAway();
							if (rand > 2 && rand <= 3)
								stand();
						}
					}
					else {
					
					
						if (!opponentOnTop) {
							
							if (!opponentShielding) {
								
								if (magic >= 3) {
									
									setState(4);
									randomize(21);
									
									if (rand <= 2)
										jab();
									if (rand > 2 && rand <= 3)
										dashAttack();
									if (rand > 3 && rand <= 5)
										upTilt();
									if (rand > 5 && rand <= 6)
										jumpFair();
									if (rand > 8 && rand <= 10)
										jumpBair();
									if (rand > 10 && rand <= 14)
										dashAway();
									if (rand > 14 && rand <= 18)
										jump();
									if (rand > 18 && rand <= 19)
										sideSpecial();
									if (rand > 19 && rand <= 21)
										upSpecial();
								}
								
								if (magic == 2) {
									
									setState(5);
									randomize(19);
									
									if (rand <= 2)
										jab();
									if (rand > 2 && rand <= 3)
										dashAttack();
									if (rand > 3 && rand <= 5)
										upTilt();
									if (rand > 5 && rand <= 6)
										jumpFair();
									if (rand > 8 && rand <= 10)
										jumpBair();
									if (rand > 10 && rand <= 14)
										dashAway();
									if (rand > 14 && rand <= 18)
										jump();
									if (rand > 18 && rand <= 19)
										sideSpecial();
								}
								
								if (magic < 2) {
									
									setState(6);
									randomize(18);
									
									if (rand <= 2)
										jab();
									if (rand > 2 && rand <= 3)
										dashAttack();
									if (rand > 3 && rand <= 5)
										upTilt();
									if (rand > 5 && rand <= 6)
										jumpFair();
									if (rand > 8 && rand <= 10)
										jumpBair();
									if (rand > 10 && rand <= 14)
										dashAway();
									if (rand > 14 && rand <= 18)
										jump();
								}
							}

						}
						
						else if (opponentOnTop) {
							
							
							setState(9);
							randomize(6);
							
							if (rand == 1)
								upTilt();
							if (rand == 2)
								jumpUpAir();
							if (rand == 3)
								dashLeft();
							if (rand == 4)
								dashRight();
							if (rand > 4 && rand <= 6)
								stand();
						
						}
					}
				}
			}
			else if (!opponentNear) {
				
				if (opponent.getHitstunFrames() >= 30) {
					
					if (hitstunFrames == 0) {
						setState(10);
						randomize(3);
						
						if (rand <= 1)
							jab();
						if (rand > 1 && rand <= 2)
							dashAway();
						if (rand > 2 && rand <= 3)
							stand();
					}
				}
				
				if (opponentCandyComing) {
				
					setState(11);
					
					randomize(10);
					
					if (rand <= 1)
						shield();
					if (rand > 1 && rand <= 8)
						slowShield();
					if (rand > 8 && rand <= 10)
						stand();
				}
				else if (!opponentCandyComing) {
					
					if (!onCenter) {
						
						
						if (magic >= 3) {
							
							if (!trapActive) {
									
								setState(12);
								randomize(13);
								
								if (rand <= 2)
									goToCenter();
								if (rand > 2 && rand <= 4)
									dashLeft();
								if (rand > 4 && rand <= 6)
									dashRight();
								if (rand > 6 && rand <= 8)
									jump();
								if (rand > 8 && rand <= 10)
									goToOpponent();
								if (rand > 10 && rand <= 11)
									neutralSpecial();
								if (rand > 11 && rand <= 13)
									upSpecial();
							}
							else if (trapActive) {
								
								setState(13);
								randomize(12);
								
								if (rand <= 2)
									goToCenter();
								if (rand > 2 && rand <= 4)
									dashLeft();
								if (rand > 4 && rand <= 6)
									dashRight();
								if (rand > 6 && rand <= 8)
									jump();
								if (rand > 8 && rand <= 10)
									goToOpponent();
								if (rand > 10 && rand <= 12)
									upSpecial();
							}
						}
						
						
						if (magic < 3) {
							
							setState(14);
							randomize(12);
							
							if (rand <= 2)
								goToCenter();
							if (rand > 2 && rand <= 4)
								dashLeft();
							if (rand > 4 && rand <= 6)
								dashRight();
							if (rand > 6 && rand <= 8)
								jump();
							if (rand > 8 && rand <= 10)
								goToOpponent();
						}
						
					}
					
					else if (onCenter) {
						
						if (GameState.magicBall.getGrabbable()) {
							
							setState(15);
							randomize(10);
							
							if (rand <= 2)
								jump();
							if (rand > 2 && rand <= 5)
								dashLeft();
							if (rand > 5 && rand <= 8)
								dashRight();
							if (rand > 8 && rand <= 10)
								stand();
						}
						
						else if (!GameState.magicBall.getGrabbable()) {
							
								if (magic >= 3) {
									
									setState(16);
									randomize(20);
									
									if (rand <= 3)
										stand();
									if (rand > 3 && rand <= 5)
										dashLeft();
									if (rand > 5 && rand <= 7)
										dashRight();
									if (rand > 7 && rand <= 8)
										jump();
									if (rand > 8 && rand <= 9)
										goToOpponent();
									if (rand > 9 && rand <= 10)
										dashAttack();
									if (rand > 10 && rand <= 13)
										neutralSpecial();
									if (rand > 13 && rand <= 15)
										upSpecial();
									
								}
								
								if (magic < 3) {
									
									setState(17);
									randomize(10);
									
									if (rand <= 3)
										stand();
									if (rand > 3 && rand <= 5)
										dashLeft();
									if (rand > 5 && rand <= 7)
										dashRight();
									if (rand > 7 && rand <= 8)
										jump();
									if (rand > 8 && rand <= 9)
										goToOpponent();
									if (rand > 9 && rand <= 10)
										dashAttack();
								}
							}
						}
					}
				}
			}
		}
	}




