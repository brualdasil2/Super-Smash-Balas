public class SmashPlayer extends Player {
	
	
	private int percent;
	private int leftBlastzone = -100;
	private int rightBlastzone = 1380;
	private int topBlastzone = -200;
	private int bottomBlastzone = 920;
	
	public SmashPlayer(Game game, int playerNumb, Character character, double x, double y, String name) {
		super(game, playerNumb, character, x, y, name);
		this.percent = 0;
	}
	
	
	protected void checkInput() {
		
		//PRESS JUMP
		if (pressingJump) {
			
			if (freezeFrames == 0) {
				if (!jumpClicked) {
				
					if (!shielding) {
						if (!attacking) {
							
							if (hitstunFrames == 0) {
								if (jumps > 0) {
									
									ySpeed = -jumpSpeed;
									jumpClicked = true;
									fastFalling = false;
									jumps--;

									
								}
							}
						}
					}
				}
			}
		}
		else {
			jumpClicked = false;

		}
		
		//PRESS RIGHT
		if (pressingRight && !pressingLeft) {
			
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0) {
						if (!onAir) {
						
							if (!attacking) {
								
								if (frozen)
									x += (character.getGroundSpeed()/2);
								else
									x += character.getGroundSpeed();
								
								lookDirection = 1;
								character.walk(this);
							}
						}
						else {
							
							if (!(sideSpecialing || upSpecialing || neutralSpecialing)) {
								

								if (xSpeed < 0) {
									if (frozen)
										xSpeed += character.getAirSpeed()/2;
									else;
										xSpeed += character.getAirSpeed();
									if (xSpeed > 0) {
										xSpeed = 0;
									}
								}
								else {
									if (frozen)
										x += character.getAirSpeed();
									else
										x += character.getAirSpeed();
								}
							}
						}
					}
				}
			}
		}
		
		
		
		//PRESS LEFT
		if (pressingLeft && !pressingRight) {
			
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0) {
						if (!onAir) {
							
							if (!attacking) {
								
								if (frozen)
									x -= (character.getGroundSpeed()/2);
								else
									x -= character.getGroundSpeed();
								
								
								lookDirection = 0;
								character.walk(this);
							}
						}
						else {
							
							if (!(sideSpecialing || upSpecialing || neutralSpecialing)) {
								
								if (xSpeed > 0) {
									if (frozen)
										xSpeed -= character.getAirSpeed()/2;
									else;
										xSpeed -= character.getAirSpeed();
									if (xSpeed < 0) {
										xSpeed = 0;
									}
								}
								else {
									if (frozen)
										x -= character.getAirSpeed();
									else
										x -= character.getAirSpeed();
								}
							}
							
						}
					}
				}
			}
		}
		
	
		
		//PRESS ATTACK
		if (pressingAttack) {
			
			
			
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0) {
						if (!attacking) {
							if (!pressingSpecial) {
							
								if (!onAir) {
									if (pressingRight || pressingLeft) {
										
										dashing = true;
									}
									
									else {
			
										
										if (pressingUp) {
											
											upTilting = true;
										}
										else {
										
											jabbing = true;
										}
									}
									
									
								}
								
								else if (onAir) {
									
									if (pressingUp) {
										
										upAiring = true;
									}
									
									else {
										
										if (lookDirection == 1) {
											
											if (pressingLeft) {
												
												bairing = true;
											}
											else {
												
												fairing = true;
											}
										}
										
										else if (lookDirection == 0) {
											
											if (pressingRight) {
												
												bairing = true;
											}
											else{
												
												fairing = true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		//PRESS SPECIAL
		if (pressingSpecial) {
			
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0) {
						if (!attacking) {
							if (!pressingAttack) {
							
								if (pressingRight || pressingLeft) {
									
									if (magic >= character.getSideSpecialMagic()) {
										
										sideSpecialing = true;
										
										
										if (pressingRight) {
											
											lookDirection = 1;
										}
										
										else if (pressingLeft) {
											
											lookDirection = 0;
										}
									}
								}
								
								else {
									
									if (pressingUp) {
										
										if (magic >= character.getUpSpecialMagic()) {
											
											upSpecialing = true;
										}
										
									}
									else {
										
										if (magic >= character.getNeutralSpecialMagic()) {
											
											neutralSpecialing = true;
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
		
		//PRESS SHIELD
		if (pressingShield && !pressingJump && !pressingAttack && !pressingSpecial) {
			
			if (shield > 0) {
				if (freezeFrames == 0) {
					if (hitstunFrames == 0) {
						
						if (!attacking) {
							if (!onAir) {
								
								if (!shielding) {
									
									parryCounter = 5;
								}
								
								shielding = true;
								shield--;
								
								if (lookDirection == 1) {
									currentFrame = character.getShieldingRight().getFrames()[0];
									currentAttack = character.getShieldingRight();
								}
								
								else if (lookDirection == 0) {
									currentFrame = character.getShieldingLeft().getFrames()[0];
									currentAttack = character.getShieldingLeft();
								}
								
							}
							else {
								
								shielding = false;
							}
						}
	
						if (onAir) {
								
							if (ySpeed > 0) {
									
								if (!fastFalling) {
										
									fastFalling = true;
									ySpeed += 12;
								}		
							}
						}
					}
					else {
						
						shielding = false;
					}
				}
			}
			else {
				
				dropShield();
			}
		}
		else {
			
			dropShield();
		}
	}
	
	
	public void hitDetection() {
		
		if (opponent.getCurrentFrame().getHitboxes() != null) {
			
			if (currentFrame.getHurtboxes() != null) {
			
				if(checkHit()) {
					
					
					if (!insideHitbox) {
						
						if (shielding && !((opponent.character instanceof Obino) && opponent.sideSpecialing)) {
							
							//parry
							if (parryCounter > 0) {
								
								if (character instanceof Lacerda) {
									
									increaseMagic(1);
									if (magic > 10)
										magic = 10;
								}
								
								insideHitbox = true;
								shield = 100;
								GameState.setParryFreezeCounter(30);
								parried = true;
								shielding = false;
								invincibleCounter = 15;
								
								if (lookDirection == 1) {
									
									currentFrame = character.getParryRight();
								}
								else if (lookDirection == 0) {
									
									currentFrame = character.getParryLeft();
								}
								
								SoundManager.play("sounds/Parry.wav", false);
							}
							
							else {
								
								freezeFrames = GameState.shieldStunFrames;
								insideHitbox = true;
								shieldStun = true;
								shield += 30;
								defended = true;
								
								if (shield > 100) {
									shield = 100;
								}
								SoundManager.play("sounds/PunchShield.wav", false);
							}
						}
						
						else {
							
							if (invincibleCounter == 0) {
								
								percent += opponent.getCurrentAttack().getDamage();
								ySpeed = opponent.getCurrentAttack().getKnockbackYspeed();
								xSpeed = opponent.getCurrentAttack().getKnockbackXspeed();
								hitstunFrames = opponent.getCurrentAttack().getHitstunFrames();
								freezeFrames = opponent.getCurrentAttack().getFreezeFrames();
								shielding = false;
								SoundManager.play("sounds/PunchHit.wav", false);
							}
							
							insideHitbox = true;
							
							
						}
					}
					
				}
				
				else {
					
					insideHitbox = false;
				}
			}
		}
		
		else {
			
			insideHitbox = false;
		}
		
	}
	
	protected void projectileHitDetection() {
		
		
			
		if (!GameState.projectiles.isEmpty()) {
			if (currentFrame.getHurtboxes() != null) {
							
				for (Hurtbox hurtbox: currentFrame.getHurtboxes()) {
								
					for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
									
						if (GameState.projectiles.get(i).getOwner().equals(opponent)) {
							
							if (GameState.projectiles.get(i).getHitboxes() != null) {
										
								for (Hitbox hitbox: GameState.projectiles.get(i).getHitboxes()) {
										
									if ((Math.pow((double) ((hitbox.getX() + GameState.projectiles.get(i).getX()) - (hurtbox.getX() + x)), 2) + Math.pow((double) ((hitbox.getY() + GameState.projectiles.get(i).getY()) - (hurtbox.getY() + y)), 2)) < Math.pow((double) (hitbox.getR() + hurtbox.getR()), 2)) {
													
													
										if (shielding) {
														
											if (!(GameState.projectiles.get(i) instanceof Rosa && ((Rosa)(GameState.projectiles.get(i))).getFrameCounter() < 899)) {
												
												//parry
												if (parryCounter > 0) {
													
													if (character instanceof Lacerda) {
														
														increaseMagic(1);
														if (magic > 10)
															magic = 10;
													}
													shield = 100;
													GameState.setParryFreezeCounter(30);
													parried = true;
													shielding = false;
													
													if (lookDirection == 1) {
														
														currentFrame = character.getParryRight();
													}
													else if (lookDirection == 0) {
														
														currentFrame = character.getParryLeft();
													}
													
													GameState.projectiles.get(i).reflect(this);
													
													SoundManager.play("sounds/Parry.wav", false);
													
													break;
												}
												
												else {
													freezeFrames = GameState.shieldStunFrames;
													insideHitbox = true;
													shieldStun = true;
													shield += 30;
																
													if (shield > 100) {
														shield = 100;
													}
													
													if (!(GameState.projectiles.get(i) instanceof BearTrap)) {
														
														GameState.projectiles.get(i).updateImage();
														GameState.projectiles.remove(i);
													}
													
													
													SoundManager.play("sounds/PunchShield.wav", false);
													break;
												}
											}
										}
													
										else {
														
											GameState.hitEffect.startHitEffect((int) x + hurtbox.getX() - GameState.hitEffect.getWidth()/2, (int) y + hurtbox.getY() - GameState.hitEffect.getHeight()/2);
														
											percent += GameState.projectiles.get(i).getDamage();
											ySpeed = GameState.projectiles.get(i).getKnockbackYspeed();
											xSpeed = (GameState.projectiles.get(i).getXSpeed() > 0) ? GameState.projectiles.get(i).getKnockbackXspeed() : -GameState.projectiles.get(i).getKnockbackXspeed();
											hitstunFrames = GameState.projectiles.get(i).getHitstunFrames();
											freezeFrames = GameState.projectiles.get(i).getFreezeFrames();
											
											
											if (GameState.projectiles.get(i) instanceof BearTrap) {
												
												((BearTrap)(GameState.projectiles.get(i))).disableHitbox();
												((BearTrap)(GameState.projectiles.get(i))).setFrameCounter(120);
											}
											else {
												
												if (GameState.projectiles.get(i) instanceof SnowBall) {
													
													frozen = true;
													frozenCounter = 1200;
													SoundManager.play("sounds/Freeze.wav", false);
												}
												GameState.projectiles.get(i).updateImage();
												GameState.projectiles.remove(i);
											}
											
											
											SoundManager.play("sounds/PunchHit.wav", false);
											break;
										}
													
									}
								}
							}
						}
					}
				}
			}
		}
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
	
	private void checkBlastzoneCollision() {
		double MyCollisionRightX = x + currentAttack.getCollisionbox().getX() + currentAttack.getCollisionbox().getWidth();
		double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
		double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
		double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY() + currentAttack.getCollisionbox().getHeight();
		double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX)/2;
		
		
		if (MyCollisionRightX < leftBlastzone || MyCollisionLeftX > rightBlastzone || MyCollisionBottomY < topBlastzone || MyCollisionTopY > bottomBlastzone) {
			System.out.println("Col Rx: " + MyCollisionRightX);
			System.out.println("Col Lx: " + MyCollisionLeftX);
			System.out.println("Col By: " + MyCollisionBottomY);
			System.out.println("Col Ty: " + MyCollisionTopY);
			health = 0;
		}
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
		checkBlastzoneCollision();
		
		
		
		//HIT DETECTION
		
		if (opponent != null) {

			magicGrabDetection();
		}
		
		
		

		
	}
	
	public int getPercent() {
		
		return percent;
	}
}