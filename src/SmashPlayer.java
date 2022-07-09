import java.awt.Color;
import java.awt.Graphics;

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

	public SmashPlayer(Game game, int playerNumb, Character character, double x, double y, String name) {
		super(game, playerNumb, character, x, y, name);
		this.percent = 0;
		this.health = 1000;
	}

	private double knockbackMultiplier() {
		return (0.6 + 0.00004524 * Math.pow(percent, 2) + 0.002548 * percent)/character.weight;
	}

	private double hitstunMultiplier() {
		return (0.7 + 0.00001310 * Math.pow(percent, 2) + 0.003369 * percent);
	}

	protected void getInput() {

		pressingJump = game.getKeyManager(playerNumb).jump;
		pressingAttack = game.getKeyManager(playerNumb).attack;
		pressingSpecial = game.getKeyManager(playerNumb).special;
		pressingUp = game.getKeyManager(playerNumb).up;
		pressingShield = game.getKeyManager(playerNumb).shield;
		pressingLeft = game.getKeyManager(playerNumb).left;
		pressingRight = game.getKeyManager(playerNumb).right;
		pressingAirdash = game.getKeyManager(playerNumb).airdash;
	}

	protected void checkInput() {

		// PRESS JUMP
		if (pressingJump) {

			if (freezeFrames == 0) {
				if (!jumpClicked) {

					if (!shielding) {
						if (!attacking) {

							if (hitstunFrames == 0 && airdashCounter == 0) {
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
		} else {
			jumpClicked = false;

		}

		// PRESS RIGHT
		if (pressingRight && !pressingLeft) {
			if (freezeFrames == 0) {
				if (!shielding) {
					if (hitstunFrames == 0 && airdashCounter == 0) {
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

							if (!(sideSpecialing || upSpecialing || neutralSpecialing)) {

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
					if (hitstunFrames == 0 && airdashCounter == 0) {
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

							if (!(sideSpecialing || upSpecialing || neutralSpecialing)) {

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

		// PRESS ATTACK
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

									} else {

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

		// PRESS SHIELD
		if (pressingShield && !pressingJump && !pressingAttack && !pressingSpecial) {

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

			dropShield();
		}

		// AIRDASH
		if (pressingAirdash) {
			if (airdashCounter == 0) {
				if (onAir) {
					if (freezeFrames == 0) {
						if (!attacking) {
							if (hitstunFrames == 0) {
								if (airdashes > 0) {
									if (shield >= 10) {
									shield -= 10;
									airdashCounter = airdashDuration;
									//hitstunFrames = airdashDuration;
									SoundManager.play("sounds/Airdash.wav", false);

									if (pressingRight) {
										airdashingRight = true;
										airdashingLeft = false;
										airdashingDown = false;
										airdashingUp = false;
									} else if (pressingLeft) {
										airdashingRight = false;
										airdashingLeft = true;
										airdashingDown = false;
										airdashingUp = false;
									} else if (pressingShield) {
										airdashingRight = false;
										airdashingLeft = false;
										airdashingDown = true;
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

	public void hitDetection() {

		if (opponent.getCurrentFrame().getHitboxes() != null) {

			if (currentFrame.getHurtboxes() != null) {

				if (checkHit()) {

					if (!insideHitbox) {

						if (shielding && !((opponent.character instanceof Obino) && opponent.sideSpecialing)) {

							// parry
							if (parryCounter > 0) {

								if (character instanceof Lacerda) {

									increaseMagic(1);
									if (magic > 10)
										magic = 10;
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

								ySpeed = opponent.getCurrentAttack().getKnockbackYspeed() * knockbackMultiplier();
								xSpeed = opponent.getCurrentAttack().getKnockbackXspeed() * knockbackMultiplier();
								int hSf = (int) (opponent.getCurrentAttack().getHitstunFrames() * hitstunMultiplier());
								hitstunFrames = hSf < MIN_HITSTUN ? MIN_HITSTUN : hSf;
								if (hitstunFrames == MIN_HITSTUN) {
									System.out.println("MIN HITSTUN");
								}
								freezeFrames = opponent.getCurrentAttack().getFreezeFrames();
								percent += opponent.getCurrentAttack().getDamage();
								health -= opponent.getCurrentAttack().getDamage();
								shielding = false;
								airdashCounter = 0;
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
															.getFrameCounter() < 899)) {

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

											GameState.hitEffect.startHitEffect(
													(int) x + hurtbox.getX() - GameState.hitEffect.getWidth() / 2,
													(int) y + hurtbox.getY() - GameState.hitEffect.getHeight() / 2);

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

			if (MyCollisionLeftX < GameState.smashStageRight && MyCollisionBottomY > GameState.floorY
					&& MyCollisionLeftX > GameState.smashStageRight - 100) {

				x = GameState.smashStageRight - currentAttack.getCollisionbox().getX() + 1;
			}

			else if (MyCollisionRightX > GameState.smashStageLeft && MyCollisionBottomY > GameState.floorY
					&& MyCollisionRightX < GameState.smashStageLeft + 100) {

				x = GameState.smashStageLeft - currentAttack.getCollisionbox().getWidth()
						- currentAttack.getCollisionbox().getX() - 1;
				// x = GameState.rightWall - currentAttack.getCollisionbox().getWidth() -
				// currentAttack.getCollisionbox().getX() - 1;
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

		// GRAVITY AND KNOCKBACK

		if (freezeFrames == 0) {

			if (onAir) {
				if (airdashCounter == 0)
					gravity();

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
			if ((ySpeed != 0 && y + currentFrame.getHeight() < GameState.floorY + ySpeed + 20) || airdashCounter > 0) {

				if (hitstunFrames == 0 && airdashCounter == 0) {

					ySpeed = 0;
					xSpeed = 0;
					y = GameState.floorY - currentFrame.getHeight();
					fastFalling = false;

					if (!attacking) {

						freezeFrames = GameState.landingLag;
					} else {

						freezeFrames = GameState.aerialLandingLag;
					}

					setStanding();
				} else {

					y = GameState.floorY - currentFrame.getHeight();
					ySpeed = -ySpeed;
				}
				airdashCounter = 0;
				if (airdashingDown) {
					airdashingDown = false;
					ySpeed = -20;
				}
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

		if (freezeFrames > 0) {
			airdashCounter = 0;
		}

		//System.out.println(hitstunFrames);
		//System.out.println(attacking);
		if (airdashCounter > 0) {
			if (airdashingRight) {
				x += 20;
			} else if (airdashingLeft) {
				x -= 20;
			} else if (airdashingDown) {
				y += 20;
			} else if (airdashingUp) {
				y -= 20;
			}
			airdashCounter--;
		} else {
			airdashingRight = false;
			airdashingLeft = false;
			airdashingUp = false;
			airdashingDown = false;
		}

		// COLLISION DETECTION

		checkCollision();
		checkBlastzoneCollision();

		// HIT DETECTION

		if (opponent != null) {

			magicGrabDetection();
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
		
		g.drawImage(currentFrame.getImage(), (int) x + currentFrame.getXOffset(), (int) y + currentFrame.getYOffset(), currentFrame.getWidth(), currentFrame.getHeight(), null);

		showHurtboxes(showBoxes, g);
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
		airdashLines(g);
	}

	public int getPercent() {

		return percent;
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
		freezeFrames = 30;
		invincibleCounter = 120;
		shieldRecoverCounter = 0;
		parryCounter = 0;
		frozen = false;
		frozenCounter = 0;
		xSpeed = 0;
		ySpeed = 0;
		character.resetAttackCounters();

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