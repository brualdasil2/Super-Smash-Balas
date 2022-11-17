import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	
	protected double x, y, ySpeed, xSpeed;
	protected Game game;
	protected int playerNumb;
	protected boolean attacking = false;
	protected boolean jabbing = false;
	protected boolean dashing = false;
	protected boolean upTilting = false;
	protected boolean bairing = false;
	protected boolean fairing = false;
	protected boolean upAiring = false;
	protected boolean sideSpecialing = false;
	protected boolean upSpecialing = false;
	protected boolean neutralSpecialing = false;
	protected boolean shielding = false;
	protected boolean insideHitbox = false;
	protected boolean onAir = false;
	protected boolean jumpClicked = false;
	protected boolean shieldStun = false;
	protected boolean fastFalling = false;
	protected Character character;
	protected AttackFrame currentFrame;
	protected Attack currentAttack;
	protected int lookDirection;
	protected Player opponent;
	protected int jumpSpeed;
	protected int health = 150;
	protected int shield = 100;
	protected int magic = 10;
	protected int hitstunFrames = 0; //feels gravity, used in knockback
	protected int freezeFrames = 0; //no gravity, used on hit
	protected int jumps;
	protected int shieldRecoverCounter = 0;
	protected int score;
	protected int parryCounter = 0;
	protected int invincibleCounter = 0;
	protected String name;
	protected boolean pressingJump;
	protected boolean pressingAttack;
	protected boolean pressingSpecial;
	protected boolean pressingUp;
	protected boolean pressingShield;
	protected boolean pressingLeft;
	protected boolean pressingRight;
	protected boolean parried = false, defended = false;
	protected double OpCollisionRightX;
	protected double OpCollisionLeftX;
	protected double OpCollisionTopY;
	protected double OpCollisionBottomY;
	protected double OpCollisionCenterX;
	protected boolean frozen = false;
	protected int frozenCounter = 0;
	protected boolean wasTipper = false;
	
	protected Hurtbox killSparkHurtbox;
	

	
	public Player(Game game, int playerNumb, Character character, double x, double y, String name) {
		
		this.x = x;
		this.y = y;
		this.game = game;
		this.playerNumb = playerNumb;
		this.character = character;
		this.jumpSpeed = character.getJumpSpeed();
		this.jumps = character.getJumps();
		this.name = name;
		
		score = 0;
		health = 150;
		shield = 100;
		magic = 10;
		
		if (playerNumb == 1)
			lookDirection = 1;
		else {
			lookDirection = 0;
		}
		
		setStanding();
		
		}
	
	protected void getInput() {
		
		pressingJump = game.getKeyManager(playerNumb).jump;
		pressingAttack = game.getKeyManager(playerNumb).attack;
		pressingSpecial = game.getKeyManager(playerNumb).special;
		pressingUp = game.getKeyManager(playerNumb).up;
		pressingShield = game.getKeyManager(playerNumb).shield;
		pressingLeft = game.getKeyManager(playerNumb).left;
		pressingRight = game.getKeyManager(playerNumb).right;
		
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
										x += character.getAirSpeed()/2;
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
										x -= character.getAirSpeed()/2;
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
	
	protected void dropShield() {
		
		if (shielding) {
			
			if (freezeFrames == 0){
				
				shielding = false;
				shieldStun = false;
				freezeFrames = GameState.shieldDropFrames;
				setStanding();
			}
		}
	}
	
	
	
	protected void gravity() {
		
		
		ySpeed += GameState.GRAVITY;
		
		
	}
	
	protected void setStanding() {
		
		if (lookDirection == 1) {
			
			currentFrame = character.getStandingRight().getFrames()[0];
			currentAttack = character.getStandingRight();
		}
		else if (lookDirection == 0) {
			
			currentFrame = character.getStandingLeft().getFrames()[0];
			currentAttack = character.getStandingLeft();
		}
	}
	
	protected boolean checkHit() {
		
		
		
		for (Hitbox hitbox: opponent.getCurrentFrame().getHitboxes()) {
			
			for (Hurtbox hurtbox: currentFrame.getHurtboxes()) {
				
				if ((Math.pow((double) ((hitbox.getX() + opponent.getX()) - (hurtbox.getX() + x)), 2) + Math.pow((double) ((hitbox.getY() + opponent.getY()) - (hurtbox.getY() + y)), 2)) < Math.pow((double) (hitbox.getR() + hurtbox.getR()), 2)) {
				
					if (!insideHitbox && !shielding && invincibleCounter == 0) {
						GameState.hitEffect.startHitEffect((int) x + hurtbox.getX() - GameState.hitEffect.getWidth()/2, (int) y + hurtbox.getY() - GameState.hitEffect.getHeight()/2);
						killSparkHurtbox = hurtbox;
						//opponent.setFreezeFrames(5);
					}
					wasTipper = hitbox.isTipper();
					//System.out.println(wasTipper);
					return true;
					
				}
			}
		}
		
		return false;
		
		
		
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
								health -= opponent.getCurrentAttack().getDamage();
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
														
											if (!(GameState.projectiles.get(i) instanceof Rosa && ((Rosa)(GameState.projectiles.get(i))).getFrameCounter() < 478)) {
												
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
														
											health -= GameState.projectiles.get(i).getDamage();
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
			
		/*	
	protected void magicGrabDetection() {
		
		if (currentFrame.getHurtboxes() != null) {
			
			if (GameState.magicBall != null) {
				if (GameState.magicBall.getGrabbable()) {
					
					for(Hurtbox hurtbox: currentFrame.getHurtboxes()) {
						
						if ((Math.pow((double) ((GameState.magicBall.getX()) - (hurtbox.getX() + x)), 2) + Math.pow((double) ((GameState.magicBall.getY()) - (hurtbox.getY() + y)), 2)) < Math.pow((double) (GameState.magicBall.getR() + hurtbox.getR()), 2)) {
							
							increaseMagic(3);
							if (magic > 10) {
								
								magic = 10;
							}
							GameState.magicBall.grab();
							SoundManager.play("sounds/Magic.wav", false);
							break;
						}
					}
				}
			}
		}
	}*/
	
	protected void measureCollision() {
		
		if (opponent != null) {
			OpCollisionRightX = opponent.getX() + opponent.getCurrentAttack().getCollisionbox().getX() + opponent.getCurrentAttack().getCollisionbox().getWidth();
			OpCollisionLeftX = opponent.getX() + opponent.getCurrentAttack().getCollisionbox().getX();
			OpCollisionTopY = opponent.getY() + opponent.getCurrentAttack().getCollisionbox().getY();
			OpCollisionBottomY = opponent.getY() + opponent.getCurrentAttack().getCollisionbox().getY() + opponent.getCurrentAttack().getCollisionbox().getHeight();
			OpCollisionCenterX = (OpCollisionRightX + OpCollisionLeftX)/2;
			//System.out.println(OpCollisionBottomY);
		}
	}
	
	
/*	protected void updateCollision(double rx, double lx, double tx, double bx, double cx) {
		
		OpCollisionRightX = rx
		OpCollisionLeftX = opponent.getX() + opponent.getCurrentAttack().getCollisionbox().getX();
		OpCollisionTopY = opponent.getY() + opponent.getCurrentAttack().getCollisionbox().getY();
		OpCollisionBottomY = opponent.getY() + opponent.getCurrentAttack().getCollisionbox().getY() + opponent.getCurrentAttack().getCollisionbox().getHeight();
		OpCollisionCenterX = (OpCollisionRightX + OpCollisionLeftX)/2;
	}*/
		
		

	
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
			//collision with walls
			
			
			if (MyCollisionLeftX < GameState.leftWall) {
						
				if (xSpeed == 0) {
							
					x = GameState.leftWall - currentAttack.getCollisionbox().getX();
				}
				else {
							
					xSpeed = -xSpeed;
					x = GameState.leftWall - currentAttack.getCollisionbox().getX() + 1;
				}
			}
					
			if (MyCollisionRightX > GameState.rightWall) {
						
				if (xSpeed == 0) {
					x = GameState.rightWall - currentAttack.getCollisionbox().getWidth() - currentAttack.getCollisionbox().getX();
				}
				else {
							
					xSpeed = -xSpeed;
					x = GameState.rightWall - currentAttack.getCollisionbox().getWidth() - currentAttack.getCollisionbox().getX() - 1;
				}
			}
			
		}
	}
	
	
	
	protected void countHitstun() {
		
		if (hitstunFrames > 0)
			hitstunFrames--;
	}
	
	protected void countFreezeFrames() {
		
		if (freezeFrames > 0) {
			
			freezeFrames--;
			if (shieldStun) {
				
				if (lookDirection == 1) {
					currentFrame = character.getShieldiHitRight().getFrames()[0];
				}
				else if (lookDirection == 0) {
					currentFrame = character.getShieldHitLeft().getFrames()[0];
				}
			}
		}
		else {
			
			shieldStun = false;
		}
	}
	
	protected void countParryFrames() {
		
		if (parryCounter > 0) {
			
			parryCounter--;
		}
	}
	
	protected void countInvincibleFrames() {
		
		if (invincibleCounter > 0) {
			
			invincibleCounter--;
		}
	}
	
	protected void countFrozenFrames() {
		
		if (frozenCounter > 0) {
			
			frozenCounter--;
		}
		else {
			
			frozen = false;
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

		

		checkInput();
		
		
			
		//GRAVITY AND KNOCKBACK
		
		
		if (freezeFrames == 0) {
			
			if (onAir) {
				
				gravity();
				
			}
			
			y += ySpeed; //gravity
			x += xSpeed; //knockback only
		}
		
		onAir = (y + currentFrame.getHeight() < GameState.floorY);
		
		//if on ground
		if (!onAir) {
			
			jumps = character.getJumps(); 
			//if fell on ground
			if (ySpeed != 0) {
				
				if (hitstunFrames == 0) {
					
					ySpeed = 0;
					xSpeed = 0;
					y = GameState.floorY - currentFrame.getHeight();
					fastFalling = false;
					
					if (!(sideSpecialing || upSpecialing || neutralSpecialing)) {
						if (!attacking) {
							
							freezeFrames = GameState.landingLag;
						}
						else {
							
							freezeFrames = GameState.aerialLandingLag;
						}
						
						setStanding();
					}
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
			
			//hitDetection();
			//projectileHitDetection();
			//magicGrabDetection();
		}
		
	//	currentFrame = character.getUpSpecialRight().getFrames()[7];
		double centerX = x + 100;
		double distToFrontWall = getLookDirection() == 0 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		double distToBackWall = getLookDirection() == 1 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		//if (playerNumb == 2)
			//System.out.println(distToBackWall);
			//System.out.println(freezeFrames);

		
	}
	
	
	
	
	public void render(Graphics g, boolean showBoxes) {
		
		g.drawImage(currentFrame.getImage(), (int) x + currentFrame.getXOffset(), (int) y + currentFrame.getYOffset(), currentFrame.getWidth(), currentFrame.getHeight(), null);

		showHurtboxes(showBoxes, g);
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
		
	}
	
	
	
	
	protected void showHurtboxes(boolean show, Graphics g) {
		
		if (show) {
			
			if (currentFrame.getHurtboxes() != null) {
				g.setColor(new Color(255, 255, 0, 170));
				drawHurtboxes(g, currentFrame.getHurtboxes());
			}
		}
	}
	
	protected void showHitboxes(boolean show, Graphics g) {
		
		if (show) {
			
			if (currentFrame.getHitboxes() != null) {
				drawHitboxes(g, currentFrame.getHitboxes());
			}
		}
		
			
	}
	
	protected void showCollisionboxes(boolean show, Graphics g) {
		
		if (show) {
			if (currentAttack.getCollisionbox() != null) {
				g.setColor(new Color(0, 0, 255, 100));
				drawCollisionbox(g);
			}
		}
	}
	
	protected void drawHurtbox(Graphics g, int centerX, int centerY, int r) {
		
		g.fillOval((int) x + centerX - r, (int) y + centerY - r, 2*r, 2*r);
	}
	
	protected void drawHurtboxes(Graphics g, Hurtbox[] hurtboxes) {
		
		for (Hurtbox hurtbox: hurtboxes) {
			
			drawHurtbox(g, hurtbox.getX(), hurtbox.getY(), hurtbox.getR());
		}
	}
	
	protected void drawCollisionbox(Graphics g) {
		
		g.fillRect((int) x + currentAttack.getCollisionbox().getX(), (int) y + currentAttack.getCollisionbox().getY(), currentAttack.getCollisionbox().getWidth(), currentAttack.getCollisionbox().getHeight());
	}
	
	protected void drawHitbox(Graphics g, int centerX, int centerY, int r) {
		
		g.fillOval((int) x + centerX - r, (int) y + centerY - r, 2*r, 2*r);
	}	
	
	protected void drawHitboxes(Graphics g, Hitbox[] hitboxes) {
		
		for (Hitbox hitbox: hitboxes) {
			if (hitbox.isTipper()) {
				g.setColor(new Color(255, 0, 0, 200));
			}
			else {
				g.setColor(new Color(255, 0, 0, 100));
			}
			drawHitbox(g, hitbox.getX(), hitbox.getY(), hitbox.getR());
		}
	}
	
	public void updateImage() {
		
		GameState.screenRefreshManager.setChange((int) x + currentFrame.getXOffset() - 50, (int) y + currentFrame.getYOffset() - 90, currentFrame.getWidth() + 100, currentFrame.getHeight() + 180);
	}
	
	public void increaseX(double x) {
		
		this.x += x;
	}
	
	public void increaseY(double y) {
		
		this.y += y;
	}
	
	public void setCurrentFrame(AttackFrame frame) {
		
		currentFrame = frame;
	}
	
	public void setAttacking(boolean attacking) {
		
		this.attacking = attacking;
	}
	
	public void setJabbing(boolean jabbing) {
		
		this.jabbing = jabbing;
	}
	
	public void setDashing(boolean dashing) {
		
		this.dashing = dashing;
	}
	
	public void setUpTilting(boolean upTilting) {
		
		this.upTilting = upTilting;
	}
	
	public void setBairing(boolean bairing) {
		
		this.bairing = bairing;
	}
	
	public void setFairing(boolean fairing) {
		
		this.fairing = fairing;
	}
	
	public void setUpAiring(boolean upAiring) {
		
		this.upAiring = upAiring;
	}
	
	public void setSideSpecialing(boolean sideSpecialing) {
		
		this.sideSpecialing = sideSpecialing;
	}
	
	public void setUpSpecialing(boolean upSpecialing) {
		
		this.upSpecialing = upSpecialing;
	}
	
	public void setNeutralSpecialing(boolean neutralSpecialing) {
		
		this.neutralSpecialing = neutralSpecialing;
	}
	
	public void setShielding(boolean shielding) {
		
		this.shielding = shielding;
	}
	
	public void setCurrentAttack(Attack attack) {
		
		this.currentAttack = attack;
	}
	
	public void setOpponent(Player opponent) {
		
		this.opponent = opponent;
	}
	
	public AttackFrame getCurrentFrame() {
		
		return currentFrame;
	}
	
	public Attack getCurrentAttack() {
		
		return currentAttack;
	}
	
	public boolean getOnAir() {
		
		return onAir;
	}
	
	public double getX() {
		
		return x;
	}
	
	public double getY() {
		
		return y;
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public int getHealth() {
		
		return health;
	}
	
	 public int getShield() {
		
		return shield;
	}
	 
	 public int getMagic() {
		 
		 return magic;
	 }
	
	public int getHitstunFrames() {
		
		return hitstunFrames;
	}
	
	public int getLookDirection() {
		
		return lookDirection;
	}
	
	public int getScore() {
		
		return score;
	}
	
	public boolean getFrozen() {
		
		return frozen;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void increaseScore() {
		
		score++;
	}
	
	public void increaseMagic(int increment) {
		
		magic += increment;
		if (magic > 10) {
			magic = 10;
		}
	}
	
	public void decreaseMagic(int decrement) {
		
		magic -= decrement;
	}
	
	public void maxMagic() {
		
		magic = 10;
	}
	
	public void maxHP() {
		
		health = 150;
	}
	
	public void increaseHP(int increment) {
		
		health += increment;
	}
	
	public void setSurvivalHP() {
		
		health = 50;
	}
	
	public void setLookDirection(int direction) {
		
		this.lookDirection = direction;
	}
	
	public void increaseHealth(int increment) {
		
		health += increment;
	}
	
	public void setHistun(int frames) {
		
		this.hitstunFrames = frames;
	}
	
	public void setFreezeFrames(int frames) {
		
		this.freezeFrames = frames;
	}
	
	public void setYSpeed(int speed) {
		
		ySpeed = speed;
	}
	
	public void maxShield() {
		
		shield = 100;
	}
	
	public void restoreShield() {
		
		shield = 100;
	}
	
	public void restoreRound() {
		
		health = 150;
		shield = 100;
		
		attacking = false;
		jabbing = false;
		dashing = false;
		upTilting = false;
		bairing = false;
		fairing = false;
		upAiring = false;
		sideSpecialing = false;
		upSpecialing = false;
		neutralSpecialing = false;
		shielding = false;
		insideHitbox = false;
		onAir = false;
		jumpClicked = false;
		shieldStun = false;
		fastFalling = false;
		hitstunFrames = 0; 
		freezeFrames = 0; 
		shieldRecoverCounter = 0;
		parryCounter = 0;
		frozen = false;
		frozenCounter = 0;
		xSpeed = 0;
		ySpeed = 0;
		character.resetAttackCounters();
		
		
		y = GameState.floorY - 200;
		
		if (playerNumb == 1) {
			
			x = 240;
			lookDirection = 1;
		}
		else if (playerNumb == 2) {
			
			x = 840;
			lookDirection = 0;
		}
		
		setStanding();
		
		
	}
	
	public void setSuddenDeath() {
		
		health = 1;
		shield = 100;
		
		attacking = false;
		jabbing = false;
		dashing = false;
		upTilting = false;
		bairing = false;
		fairing = false;
		upAiring = false;
		sideSpecialing = false;
		upSpecialing = false;
		neutralSpecialing = false;
		shielding = false;
		insideHitbox = false;
		onAir = false;
		jumpClicked = false;
		shieldStun = false;
		fastFalling = false;
		hitstunFrames = 0; 
		freezeFrames = 0; 
		shieldRecoverCounter = 0;
		parryCounter = 0;
		xSpeed = 0;
		ySpeed = 0;
		character.resetAttackCounters();
		
		y = GameState.floorY - 200;
		
		if (playerNumb == 1) {
			
			x = 240;
			lookDirection = 1;
		}
		else if (playerNumb == 2) {
			
			x = 840;
			lookDirection = 0;
		}
		
		setStanding();
	}
	
	
	
	
}
