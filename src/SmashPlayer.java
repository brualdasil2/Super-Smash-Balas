import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SmashPlayer extends Player {

	private int percent;
	private int leftBlastzone = -100;
	private int rightBlastzone = 1380;
	private int topBlastzone = -300;
	private int bottomBlastzone = 920;
	protected boolean pressingAirdash;
	private int airdashDuration = 15;
	private int airdashes = 1, airdashCounter = 0;
	private boolean airdashingRight = false, airdashingLeft = false, airdashingDown = false, airdashingUp = false;
	private int MIN_HITSTUN = 20;
	private int invisibleCounter = 0;
	private int shieldDropFrames = 0;
	private boolean jumping = false;
	private double prevX, prevY ;

	private boolean keyPressingLeft = false, keyPressingRight = false, wasPressingShield = false;
	private int airdashSpeed;
	private int wavedashCounter = 0, wavedashSpeed = 0;
	private boolean wavedashingRight = false, wavedashingLeft = false;
	private boolean wasTouchingWall = false;

	protected int tpCounter = 0;
	
	PlayerInputs inputs;
	BufferPlayerInputs delayedInputsBuffer;
	private boolean updatedInputs = false;


	public SmashPlayer(Game game, int playerNumb, Character character, double x, double y, String name) {
		super(game, playerNumb, character, x, y, name);
		this.percent = 0;
		this.health = 1000;
		this.character.resetAttackCounters();

		inputs = new PlayerInputs(game);
		delayedInputsBuffer = new BufferPlayerInputs(0);
	}
	public SmashPlayer(Game game, int playerNumb, Character character, double x, double y, String name, int inputDelay) {
		super(game, playerNumb, character, x, y, name);
		this.percent = 0;
		this.health = 1000;
		this.character.resetAttackCounters();

		inputs = new PlayerInputs(game);
		delayedInputsBuffer = new BufferPlayerInputs(inputDelay);
	}

	private double knockbackMultiplier() {
		return ((0.7 + 0.00004524 * Math.pow(percent, 2) + 0.002548 * percent)/character.weight);
	}

	private double hitstunMultiplier() {
		return (0.7 + 0.00001310 * Math.pow(percent, 2) + 0.003369 * percent);
	}
	
	protected void instantDropShield() {
		
		if (shielding) {
			
			if (freezeFrames == 0){
				
				shielding = false;
				shieldStun = false;
				setStanding();
			}
		}
	}
	
	protected void dropShield() {
		
		if (shielding) {
			
			if (freezeFrames == 0){
				
				shielding = false;
				shieldStun = false;
				freezeFrames = GameState.shieldDropFrames;
				shieldDropFrames = freezeFrames;
				setStanding();
			}
		}
	}


	protected void getInput() {

		inputs.setPlayerInputs(playerNumb);
		PlayerInputs inputsToPlay = delayedInputsBuffer.shiftBuffer(inputs);
		if (inputsToPlay == null) {
			return;
		}
		this.inputs = inputsToPlay; 
		updatedInputs = true;
	}
	
	protected void getReplayInput(byte frameInputs) {
		pressingJump = ((frameInputs & (byte)0x80) != (byte)0x00);
		pressingAttack = ((frameInputs & (byte)0x40) != (byte)0x00);
		pressingSpecial = ((frameInputs & (byte)0x20) != (byte)0x00);
		pressingUp = ((frameInputs & (byte)0x10) != (byte)0x00);
		pressingShield = ((frameInputs & (byte)0x08) != (byte)0x00);
		pressingAirdash = ((frameInputs & (byte)0x04) != (byte)0x00);
		pressingLeft = ((frameInputs & (byte)0x02) != (byte)0x00);
		pressingRight = ((frameInputs & (byte)0x01) != (byte)0x00);
		
	}

	protected void checkInput() {

		// PRESS JUMP
		if (pressingJump) {
			if (freezeFrames == 0 || (shieldDropFrames > 0 && shieldDropFrames == freezeFrames)) {
				
				if (!jumpClicked) {
					if (!attacking) {

						if (hitstunFrames == 0 && airdashCounter == 0) {
							if (jumps > 0) {

								ySpeed = -jumpSpeed;
								jumpClicked = true;
								fastFalling = false;
								jumps--;
								freezeFrames = 0;
								jumping = true;
							}
						}
					}
				}
			}
		} else {
			jumpClicked = false;

		}

		// PRESS RIGHT
		if (pressingRight && !pressingLeft) {
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0 && airdashCounter == 0 && wavedashCounter == 0) {
						if (!onAir) {

							if (!attacking) {

								if (frozen)
									x += (character.getGroundSpeed() / 2);
								else
									x += character.getGroundSpeed();

								lookDirection = 1;
								character.walk(this);
							}
						} else {

							if (!((upSpecialing && character instanceof Lacerda && character.attackUF >= 7) || neutralSpecialing)) {

								if (xSpeed < 0) {
									if (frozen)
										xSpeed += character.getAirSpeed() / 2;
									else
										xSpeed += character.getAirSpeed();
									if (xSpeed > 0) {
										xSpeed = 0;
									}
								} else {
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

		// PRESS LEFT
		if (pressingLeft && !pressingRight) {

			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0 && airdashCounter == 0 && wavedashCounter == 0) {
						if (!onAir) {

							if (!attacking) {

								if (frozen)
									x -= (character.getGroundSpeed() / 2);
								else
									x -= character.getGroundSpeed();

								lookDirection = 0;
								character.walk(this);
							}
						} else {

							if (!((upSpecialing && character instanceof Lacerda && character.attackUF >= 7) || neutralSpecialing)) {

								if (xSpeed > 0) {
									if (frozen)
										xSpeed -= character.getAirSpeed() / 2;
									else
										xSpeed -= character.getAirSpeed();
									if (xSpeed < 0) {
										xSpeed = 0;
									}
								} else {
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

		// PRESS SHIELD
		if (pressingShield) {
			if (!jumping) {
				if (shield > 0) {
					if (freezeFrames == 0) {
						if (hitstunFrames == 0 && airdashCounter == 0) {
	
							if (!attacking) {
								if (!onAir && ySpeed == 0) {
	
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
	
								} else {
	
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
						} else {
	
							shielding = false;
						}
					}
				} else {
	
					dropShield();
				}
			} else {
				instantDropShield();
			}
		} else {
			if (!jumping) {
				dropShield();
			} else {
				instantDropShield();
			}
			
		}
		
		// PRESS ATTACK
		if (pressingAttack) {
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0) {
						if (!attacking) {
							if (!pressingSpecial) {

								if (!onAir && !jumping) {
									if (pressingUp) {

										upTilting = true;
									}

									else {

										if (pressingRight || pressingLeft) {

											dashing = true;
										} else {

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
											} else {

												fairing = true;
											}
										}

										else if (lookDirection == 0) {

											if (pressingRight) {

												bairing = true;
											} else {

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

		// PRESS SPECIAL
		if (pressingSpecial) {

			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0) {
						if (!attacking) {
							if (!pressingAttack && !jumping) {

								if (pressingUp) {

									if (magic >= character.getUpSpecialMagic()) {

										upSpecialing = true;
									}

								}
								else if (pressingRight || pressingLeft) {

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



		// AIRDASH
		if (pressingAirdash) {
			if (airdashCounter == 0) {
				if (onAir) {
					if (freezeFrames == 0) {
						if (!attacking) {
							if (hitstunFrames == 0) {
								if (airdashes > 0) {
									if (shield >= 20) {
									shield -= 20;
									airdashCounter = airdashDuration;
									//hitstunFrames = airdashDuration;
									SoundManager.play("sounds/Airdash.wav", false);

									if (pressingShield) {
										airdashingRight = false;
										airdashingLeft = false;
										airdashingDown = true;
										airdashingUp = false;
									}
									else if (pressingRight) {
										airdashingRight = true;
										airdashingLeft = false;
										airdashingDown = false;
										airdashingUp = false;
									} else if (pressingLeft) {
										airdashingRight = false;
										airdashingLeft = true;
										airdashingDown = false;
										airdashingUp = false;
									} else {
										airdashingRight = false;
										airdashingLeft = false;
										airdashingDown = false;
										airdashingUp = true;
									}

									fastFalling = false;
									airdashes--;
									ySpeed = 0;
									xSpeed = 0;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private boolean wouldBeInBlastzone(double simX, double simY) {
		double MyCollisionRightX = simX + currentAttack.getCollisionbox().getX()
				+ currentAttack.getCollisionbox().getWidth();
		double MyCollisionLeftX = simX + currentAttack.getCollisionbox().getX();
		double MyCollisionTopY = simY + currentAttack.getCollisionbox().getY();
		double MyCollisionBottomY = simY + currentAttack.getCollisionbox().getY()
				+ currentAttack.getCollisionbox().getHeight();
		double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX) / 2;

		return (MyCollisionRightX < leftBlastzone || MyCollisionLeftX > rightBlastzone || MyCollisionBottomY < topBlastzone
				|| MyCollisionTopY > bottomBlastzone);
	}
	
	private boolean checkSimOnAir(double simX, double simY) {
		if (currentAttack.getCollisionbox() != null) {

			double MyCollisionRightX = simX + currentAttack.getCollisionbox().getX()
					+ currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = simX + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = simY + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = simY + currentAttack.getCollisionbox().getY()
					+ currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX) / 2;

			if (simY + currentFrame.getHeight() < GameState.floorY || MyCollisionRightX < GameState.smashStageLeft
					|| MyCollisionLeftX > GameState.smashStageRight) {
				return true;
			}
			return false;
		}

		return false;
	}
	
	private void killEffect(Hurtbox hurtbox) {
		//System.out.println("VAI MORRER!!");
		GameState.setParryFreezeCounter(30);
		GameState.hitEffect.startHitEffect(
				(int)x + hurtbox.getX() - GameState.hitEffect.getWidth()*4/2,
				(int)y + hurtbox.getY() - GameState.hitEffect.getHeight()*4/2,
				false, true);
		SoundManager.play("sounds/PunchKill.wav", false);
	}
	
	private boolean simulateKill() {
		double simX = x;
		double simY = y;
		double simXspeed = xSpeed;
		double simYspeed = ySpeed;
		int simFf = freezeFrames;
		int hsf = hitstunFrames;
		boolean simOnAir = checkSimOnAir(simX, simY);
		while (hsf > 0) {
			//System.out.println("hsf" + hsf);
			if (hsf > 0)
				hsf--;
			if (simFf > 0)
				simFf--;
			else {
				simX += simXspeed;
				simY += simYspeed;
				if (simOnAir)
					simYspeed += GameState.GRAVITY;
				simOnAir = checkSimOnAir(simX, simY);
				if (!simOnAir) {
					simY = GameState.floorY - currentFrame.getHeight();
					simYspeed = -simYspeed;
				}
				//System.out.println("simX" + simX);
				if (wouldBeInBlastzone(simX, simY)) {
					return true;
				}
			}
		}
		return false;
	}

	public void hitDetection() {

		if (opponent.getCurrentFrame().getHitboxes() != null) {

			if (currentFrame.getHurtboxes() != null) {

				if (checkHit()) {

					if (!insideHitbox) {

						if (shielding && !((opponent.character instanceof Obino) && opponent.sideSpecialing)) {

							// parry
							if (parryCounter > 0) {

								if (character instanceof Lacerda) {
									//System.out.println(magic);
									increaseMagic(1);
									if (magic > 10)
										magic = 10;
									//System.out.println(magic);
								}

								insideHitbox = true;
								shield = 100;
								GameState.setParryFreezeCounter(15);
								parried = true;
								shielding = false;
								invincibleCounter = 15;

								if (lookDirection == 1) {

									currentFrame = character.getParryRight();
								} else if (lookDirection == 0) {

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
								int damage, ySp, xSp;
								//System.out.println("NO SP " + wasTipper);
								if (wasTipper) {
									damage = opponent.getCurrentAttack().getTipperDamage();
									ySp = opponent.getCurrentAttack().getTipperKnockbackYspeed();
									xSp = opponent.getCurrentAttack().getTipperKnockbackXspeed();
								}
								else {
									damage = opponent.getCurrentAttack().getDamage();
									ySp = opponent.getCurrentAttack().getKnockbackYspeed();
									xSp = opponent.getCurrentAttack().getKnockbackXspeed();
								}
								ySpeed = (ySp * knockbackMultiplier()) + ((double)opponent.getCurrentAttack().getBaseKnockbackYspeed()/opponent.character.weight);
								xSpeed = (xSp * knockbackMultiplier()) + ((double)opponent.getCurrentAttack().getBaseKnockbackXspeed()/opponent.character.weight);
								int hSf = (int) (opponent.getCurrentAttack().getHitstunFrames() * hitstunMultiplier());
								hitstunFrames = hSf < MIN_HITSTUN ? MIN_HITSTUN : hSf;
								freezeFrames = opponent.getCurrentAttack().getFreezeFrames();
								percent += damage;
								health -= damage;
								shielding = false;
								airdashCounter = 0;
								if (simulateKill()) {
									killEffect(killSparkHurtbox);
								}
								else {
									SoundManager.play("sounds/PunchHit.wav", false);
								}
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
		wasTipper = false;
	}

	protected void projectileHitDetection() {

		if (!GameState.projectiles.isEmpty()) {
			if (currentFrame.getHurtboxes() != null) {

				for (Hurtbox hurtbox : currentFrame.getHurtboxes()) {

					for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {

						if (GameState.projectiles.get(i).getOwner().equals(opponent)) {

							if (GameState.projectiles.get(i).getHitboxes() != null) {

								for (Hitbox hitbox : GameState.projectiles.get(i).getHitboxes()) {

									if ((Math
											.pow((double) ((hitbox.getX() + GameState.projectiles.get(i).getX())
													- (hurtbox.getX() + x)), 2)
											+ Math.pow((double) ((hitbox.getY() + GameState.projectiles.get(i).getY())
													- (hurtbox.getY() + y)), 2)) < Math
															.pow((double) (hitbox.getR() + hurtbox.getR()), 2)) {

										if (shielding) {

											if (!(GameState.projectiles.get(i) instanceof Rosa
													&& ((Rosa) (GameState.projectiles.get(i)))
															.getFrameCounter() < 479)) {

												// parry
												if (parryCounter > 0) {

													if (character instanceof Lacerda) {

														increaseMagic(1);
														if (magic > 10)
															magic = 10;
													}
													shield = 100;
													GameState.setParryFreezeCounter(15);
													parried = true;
													shielding = false;

													if (lookDirection == 1) {

														currentFrame = character.getParryRight();
													} else if (lookDirection == 0) {

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

											if (invincibleCounter == 0) {

												percent += GameState.projectiles.get(i).getDamage();
												health -= GameState.projectiles.get(i).getDamage();
												ySpeed = GameState.projectiles.get(i).getKnockbackYspeed()
														* knockbackMultiplier();
												xSpeed = knockbackMultiplier()
														* ((GameState.projectiles.get(i).getXSpeed() > 0)
																? GameState.projectiles.get(i).getKnockbackXspeed()
																: -GameState.projectiles.get(i).getKnockbackXspeed());
												int hSf = (int) (GameState.projectiles.get(i).getHitstunFrames()
														* hitstunMultiplier());
												hitstunFrames = hSf < MIN_HITSTUN ? MIN_HITSTUN : hSf;
												freezeFrames = GameState.projectiles.get(i).getFreezeFrames();
												
												
	
												if (GameState.projectiles.get(i) instanceof BearTrap) {
	
													((BearTrap) (GameState.projectiles.get(i))).disableHitbox();
													((BearTrap) (GameState.projectiles.get(i))).setFrameCounter(120);
												} else {
	
													if (GameState.projectiles.get(i) instanceof SnowBall) {
	
														frozen = true;
														frozenCounter = 600;
														SoundManager.play("sounds/Freeze.wav", false);
													}
													GameState.projectiles.get(i).updateImage();
													GameState.projectiles.remove(i);
												}
	
												if (simulateKill()) {
													killEffect(hurtbox);
												}
												else {
													GameState.hitEffect.startHitEffect(
															(int) x + hurtbox.getX() - GameState.hitEffect.getWidth() / 2,
															(int) y + hurtbox.getY() - GameState.hitEffect.getHeight() / 2);
													SoundManager.play("sounds/PunchHit.wav", false);
												}
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
	}

	protected boolean checkOnAir() {
		if (currentAttack.getCollisionbox() != null) {

			double MyCollisionRightX = x + currentAttack.getCollisionbox().getX()
					+ currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY()
					+ currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX) / 2;

			if (y + currentFrame.getHeight() < GameState.floorY || MyCollisionRightX < GameState.smashStageLeft
					|| MyCollisionLeftX > GameState.smashStageRight) {
				return true;
			}
			return false;
		}

		return false;
	}

	private void checkBlastzoneCollision() {
		double MyCollisionRightX = x + currentAttack.getCollisionbox().getX()
				+ currentAttack.getCollisionbox().getWidth();
		double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
		double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
		double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY()
				+ currentAttack.getCollisionbox().getHeight();
		double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX) / 2;

		if (MyCollisionRightX < leftBlastzone || MyCollisionLeftX > rightBlastzone || MyCollisionBottomY < topBlastzone
				|| MyCollisionTopY > bottomBlastzone) {

			health = 0;
			int hitEffectX = (int) MyCollisionCenterX;
			int hitEffectY = (int) MyCollisionTopY;
			if (MyCollisionRightX < leftBlastzone) {
				hitEffectX = 0;
			}
			else if (MyCollisionLeftX > rightBlastzone) {
				hitEffectX = 1280;
			}
			else if (MyCollisionBottomY < topBlastzone) {
				hitEffectY = 0;
			}
			else if (MyCollisionTopY > bottomBlastzone) {
				hitEffectY = 720;
			}
			
			
			GameState.hitEffect.startHitEffect(
					hitEffectX - GameState.hitEffect.getWidth()*8/2,
					hitEffectY - GameState.hitEffect.getHeight()*8/2,
					true);

		}
	}

	protected void checkCollision() {

		if (currentAttack.getCollisionbox() != null) {

			double MyCollisionRightX = x + currentAttack.getCollisionbox().getX()
					+ currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY()
					+ currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX) / 2;

			if (opponent != null) {

				// collision with opponent

				if (MyCollisionBottomY >= OpCollisionTopY && MyCollisionTopY <= OpCollisionBottomY) {

					if (Math.abs(OpCollisionCenterX - MyCollisionCenterX) <= currentAttack.getCollisionbox().getWidth()
							/ 2 + opponent.getCurrentAttack().getCollisionbox().getWidth() / 2) {

						if (OpCollisionCenterX - MyCollisionCenterX > 0) {

							if (MyCollisionLeftX != GameState.leftWall)
								x = OpCollisionLeftX - currentAttack.getCollisionbox().getWidth()
										- currentAttack.getCollisionbox().getX(); // tp left
						}

						else if (OpCollisionCenterX - MyCollisionCenterX < 0) {

							if (MyCollisionRightX != GameState.rightWall)
								x = OpCollisionRightX - currentAttack.getCollisionbox().getX(); // tp right
						}

						else {

							if (MyCollisionLeftX == GameState.leftWall) {
								if (MyCollisionTopY < OpCollisionTopY)
									x = OpCollisionRightX - currentAttack.getCollisionbox().getX(); // tp right
							}

							else {
								if (MyCollisionTopY < OpCollisionTopY)
									x = OpCollisionLeftX - currentAttack.getCollisionbox().getWidth()
											- currentAttack.getCollisionbox().getX(); // tp left

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

			double MyCollisionRightX = x + currentAttack.getCollisionbox().getX()
					+ currentAttack.getCollisionbox().getWidth();
			double MyCollisionLeftX = x + currentAttack.getCollisionbox().getX();
			double MyCollisionTopY = y + currentAttack.getCollisionbox().getY();
			double MyCollisionBottomY = y + currentAttack.getCollisionbox().getY()
					+ currentAttack.getCollisionbox().getHeight();
			double MyCollisionCenterX = (MyCollisionRightX + MyCollisionLeftX) / 2;
			// collision with stage

			if (MyCollisionLeftX <= GameState.smashStageRight && MyCollisionBottomY > GameState.floorY
					&& MyCollisionLeftX > GameState.smashStageRight - 100) {

				x = GameState.smashStageRight - currentAttack.getCollisionbox().getX() + 1;
				if (airdashingLeft) {
					airdashingLeft = false;
					jumps = character.getJumps();
					airdashes = 1;
					shield += 10;
					invincibleCounter = 15;
					//airdashCounter = 5;
				}
				//wasTouchingWall = true;
			}

			else if (MyCollisionRightX >= GameState.smashStageLeft && MyCollisionBottomY > GameState.floorY
					&& MyCollisionRightX < GameState.smashStageLeft + 100) {

				x = GameState.smashStageLeft - currentAttack.getCollisionbox().getWidth()
						- currentAttack.getCollisionbox().getX() - 1;
				if (airdashingRight) {
					airdashingRight = false;
					jumps = character.getJumps();
					airdashes = 1;
					shield += 10;
					invincibleCounter = 20;
					//airdashCounter = 5;
				}
				//wasTouchingWall = true;
				// x = GameState.rightWall - currentAttack.getCollisionbox().getWidth() -
				// currentAttack.getCollisionbox().getX() - 1;
			}
			else {
				wasTouchingWall = false;
			}

		}
	}

	public void tick() {
		
		wasPressingShield = pressingShield;
		
		if (updatedInputs) {
			pressingJump = inputs.isPressingJump();
			pressingAttack = inputs.isPressingAttack();
			pressingSpecial = inputs.isPressingSpecial();
			pressingUp = inputs.isPressingUp();
			pressingShield = inputs.isPressingShield();
			pressingAirdash = inputs.isPressingAirdash();
			pressingLeft = inputs.isPressingLeft();
			pressingRight = inputs.isPressingRight();
			
			updatedInputs = false;
		}
		
		updateImage();

		setStanding();

		countHitstun();
		
		//System.out.println(hitstunFrames);

		countFreezeFrames();
		
		if (shieldDropFrames > 0) {
			shieldDropFrames--;
		}


		countParryFrames();

		countInvincibleFrames();
		
		if (tpCounter > 0) {
			tpCounter--;
		}

		if (frozen)
			countFrozenFrames();
		
		if (invisibleCounter > 0) {
			invisibleCounter--;
		}
		
		onAir = checkOnAir();
		checkInput();
		jumping = false; // só pra rising aerial

		// GRAVITY AND KNOCKBACK

		if (freezeFrames == 0) {

			if (onAir) {
				if (airdashCounter == 0) {
					if (!(character instanceof Lacerda && upSpecialing && character.attackUF >= 7 && character.attackUF <= 10)) {
						gravity();
					}
				}

			}

			if (airdashCounter == 0) {
				y += ySpeed;
				x += xSpeed;
			}
		}

		checkStageCollision();
		onAir = checkOnAir();

		// if on ground
		if (!onAir) {
			//System.out.println("Yspeed: " + ySpeed + " adC " + airdashCounter);
			jumps = character.getJumps();
			airdashes = 1;

			y = GameState.floorY - currentFrame.getHeight();

			// if fell on ground
			if (((ySpeed != 0 || tpCounter != 0) && y + currentFrame.getHeight() < GameState.floorY + ySpeed + 20) || airdashCounter > 0) {
				//System.out.println("landed");
				if (hitstunFrames == 0 && airdashCounter == 0) {

					ySpeed = 0;
					xSpeed = 0;
				//	System.out.println(prevY);
					if (prevY > GameState.floorY - currentFrame.getHeight() + 50) {
						if (character instanceof Lacerda && upSpecialing) {
						//	System.out.println("LacerdaTP");
							y = prevY;
							if (prevX < GameState.smashStageLeft) {
								x = GameState.smashStageLeft - currentFrame.getWidth() + currentAttack.getCollisionbox().getX() - 1;
							}
							else {
								x = GameState.smashStageRight - currentAttack.getCollisionbox().getX() + 1;
							}
						}
					}
					else {
						y = GameState.floorY - currentFrame.getHeight();
					}
					fastFalling = false;

					if (!attacking) {

						freezeFrames = GameState.landingLag;
					} else {

						freezeFrames = GameState.aerialLandingLag;
					}

					setStanding();
				} else {
					// GROUNDED SPIKE
					y = GameState.floorY - currentFrame.getHeight();
					ySpeed = -ySpeed;
				}
				if (airdashingDown) {
					airdashingDown = false;
					shield += 10;
					if (pressingShield || wasPressingShield) {
						if (pressingAirdash) {
							if (pressingRight || pressingLeft) {
								// WAVEDASH
								//System.out.println("WAVEDASH");
								wavedashCounter = airdashCounter*3/2;
								wavedashSpeed = airdashSpeed;
								shieldDropFrames = 3;
								freezeFrames = 3;
								if (pressingRight) {
									wavedashingRight = true;
									wavedashingLeft = false;
								}
								else {
									wavedashingLeft = true;
									wavedashingRight = false;
								}
							}
						}
						// NIL / SHIELD
						ySpeed = 0;
					}
					else {
						// BOUNCE
						ySpeed = -20;
					}
				}
				airdashCounter = 0;
			}
		}

		// shield recover
		if (!shielding && (!pressingShield || onAir)) {

			shieldRecoverCounter++;
			if (shieldRecoverCounter == 10) {

				shieldRecoverCounter = 0;

				if (shield < 100) {

					shield++;
				}
			}

		}

		prevX = x;
		prevY = y;
		
		// USING ATTACKS

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
				((Obino) (character)).closeTrap(this);
		}

		if (freezeFrames > 0 && shieldDropFrames == 0) {
			airdashCounter = 0;
			wavedashCounter = 0;
		}

		//System.out.println(hitstunFrames);
		//System.out.println(attacking);
		if (airdashCounter > 0) {
			if (airdashCounter == airdashDuration) {
				airdashSpeed = 25;
			}
			else if (airdashCounter > 10) {
				airdashSpeed -= 1;
			}
			else if (airdashCounter <= 5) {
				airdashSpeed -= 1;
			}
			//int airdashSpeed = frozen ? 10 : 20;
			int localAirdashSpeed = frozen ? airdashSpeed/2 : airdashSpeed;
			if (airdashingRight) {
				x += localAirdashSpeed;
			} else if (airdashingLeft) {
				x -= localAirdashSpeed;
			} else if (airdashingDown) {
				y += localAirdashSpeed;
			} else if (airdashingUp) {
				y -= localAirdashSpeed;
			}
			airdashCounter--;
		} else {
			airdashingRight = false;
			airdashingLeft = false;
			airdashingUp = false;
			airdashingDown = false;
		}
		
		if (wavedashCounter > 0) {
			if (wavedashCounter == airdashDuration*3/2) {
				wavedashSpeed = 25;
			}
			else if (wavedashCounter > 10*3/2) {
				wavedashSpeed -= 2;
			}
			else if (airdashCounter <= 5*3/2) {
				if (wavedashSpeed > 5)
					wavedashSpeed -= 1;
			}
			int localWavedashSpeed = frozen ? wavedashSpeed/2 : wavedashSpeed;
			if (wavedashingRight) {
				x += localWavedashSpeed;
			} else if (wavedashingLeft) {
				x -= localWavedashSpeed;
			}
			wavedashCounter--;
		}
		else {
			wavedashingRight = false;
			wavedashingLeft = false;
		}

		// COLLISION DETECTION

		checkCollision();
		checkBlastzoneCollision();

		// HIT DETECTION

		if (opponent != null) {

			//magicGrabDetection();
		}

	}
	
	private void airdashLines(Graphics g) {
		g.setColor(Color.black);
		if (airdashingRight) {
			g.drawLine((int)x, (int)y, (int)x - 40, (int)y);
			g.drawLine((int)x - 10, (int)y + 30, (int)x - 50, (int)y + 30);
			g.drawLine((int)x, (int)y + 70, (int)x - 40, (int)y + 70);
			g.drawLine((int)x - 10, (int)y + 110, (int)x - 50, (int)y + 110);
			g.drawLine((int)x, (int)y + 150, (int)x - 40, (int)y + 150);
		}
		else if (airdashingLeft) {
			g.drawLine((int)x + 200, (int)y, (int)x + 200 + 40, (int)y);
			g.drawLine((int)x + 200 + 10, (int)y + 30, (int)x + 200 + 50, (int)y + 30);
			g.drawLine((int)x + 200, (int)y + 70, (int)x + 200 + 40, (int)y + 70);
			g.drawLine((int)x + 200 + 10, (int)y + 110, (int)x + 200 + 50, (int)y + 110);
			g.drawLine((int)x + 200, (int)y + 150, (int)x + 200 + 40, (int)y + 150);
		}
		else if (airdashingUp) {
			g.drawLine((int)x + 50, (int)y + 220, (int)x + 50, (int)y + 220 + 40);
			g.drawLine((int)x + 90, (int)y + 220 + 10, (int)x + 90, (int)y + 220 + 50);
			g.drawLine((int)x + 140, (int)y + 220, (int)x + 140, (int)y + 220 + 40);
		}
		else if (airdashingDown) {
			g.drawLine((int)x + 50, (int)y - 20, (int)x + 50, (int)y - 20 - 40);
			g.drawLine((int)x + 90, (int)y - 20 + 10, (int)x + 90, (int)y - 20 - 50);
			g.drawLine((int)x + 140, (int)y - 20, (int)x + 140, (int)y - 20 - 40);
		}
	}
	
	@Override
	public void render(Graphics g, boolean showBoxes) {
		
		if (invisibleCounter == 0) {
			if (invincibleCounter > 0) {
	            AlphaComposite alcomTransp = AlphaComposite.getInstance(
	                    AlphaComposite.SRC_OVER, 0.5f);
	            ((Graphics2D) g).setComposite(alcomTransp);
				g.drawImage(currentFrame.getImage(), (int) x + currentFrame.getXOffset(), (int) y + currentFrame.getYOffset(), currentFrame.getWidth(), currentFrame.getHeight(), null);
				AlphaComposite alcomOpaque = AlphaComposite.getInstance(
	                    AlphaComposite.SRC_OVER, 1.0f);
	            ((Graphics2D) g).setComposite(alcomOpaque);
			}
			else {
				g.drawImage(currentFrame.getImage(), (int) x + currentFrame.getXOffset(), (int) y + currentFrame.getYOffset(), currentFrame.getWidth(), currentFrame.getHeight(), null);
			}
		}
		showHurtboxes(showBoxes, g);
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
		airdashLines(g);
	}

	public int getPercent() {

		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	
	@Override
	public void increaseX(double x) {
		int intX = (int) x;
		if (wavedashingRight || wavedashingLeft) {
			this.x += intX/2;
		}
		else {			
			this.x += x;
		}
	}

	@Override
	public void setSuddenDeath() {
		health = 1500;
		percent = 300;
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
		airdashCounter = 0;
		airdashes = 1;
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
	public void maxHP() {
		
		health = 1500;
		percent = 0;
	}
	public void restoreRound() {

		percent = 0;
		health = 1500;
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
		freezeFrames = 60;
		invisibleCounter = 30;
		invincibleCounter = 120;
		shieldRecoverCounter = 0;
		parryCounter = 0;
		frozen = false;
		frozenCounter = 0;
		xSpeed = 0;
		ySpeed = 0;
		character.resetAttackCounters();
		jumps = character.getJumps();
		airdashes = 1;

		y = GameState.floorY - 500;

		if (playerNumb == 1) {

			x = 540;
			lookDirection = 1;
		} else if (playerNumb == 2) {

			x = 540;
			lookDirection = 0;
		}

		setStanding();

	}
}