
public class Lacerda extends Character {

	private boolean chargingBomb = false;
	private int bombKnockback = 15;
	private int chargeBombKnockback = 15;
	private boolean countering = false;
	private int counterProjectileDamage = 0;
	private int counterProjectileKnockbackXSpeed = 0;
	private int counterProjectileKnockbackYSpeed = 0;
	private int upBdistance = 400;
	
	public Lacerda(int skin) {
		
		super(skin);
		standingRight = AttackCreator.getLacerdaStandingRight(skin);
		standingLeft = AttackCreator.getLacerdaStandingLeft(skin);
		walkingRight = AttackCreator.getLacerdaWalkingRight(skin);
		walkingLeft = AttackCreator.getLacerdaWalkingLeft(skin);
		jabRight = AttackCreator.getLacerdaJabRight(skin);
		jabLeft = AttackCreator.getLacerdaJabLeft(skin);
		dashRight = AttackCreator.getLacerdaDashRight(skin);
		dashLeft = AttackCreator.getLacerdaDashLeft(skin);
		shieldingRight = AttackCreator.getLacerdaShieldingRight(skin);
		shieldHitRight = AttackCreator.getLacerdaShieldHitRight(skin);
		shieldingLeft = AttackCreator.getLacerdaShieldingLeft(skin);
		shieldHitLeft = AttackCreator.getLacerdaShieldHitLeft(skin);
		upTiltRight = AttackCreator.getLacerdaUpTiltRight(skin);
		upTiltLeft = AttackCreator.getLacerdaUpTiltLeft(skin);
		bairRight = AttackCreator.getLacerdaBairRight(skin);
		bairLeft = AttackCreator.getLacerdaBairLeft(skin);
		fairRight = AttackCreator.getLacerdaFairRight(skin);
		fairLeft = AttackCreator.getLacerdaFairLeft(skin);
		upAirRight = AttackCreator.getLacerdaUpAirRight(skin);
		upAirLeft = AttackCreator.getLacerdaUpAirLeft(skin);
		sideSpecialRight = AttackCreator.getLacerdaSideSpecial1Right(skin);
		sideSpecialLeft = AttackCreator.getLacerdaSideSpecial1Left(skin);
		neutralSpecialRight = AttackCreator.getLacerdaNeutralSpecial1Right(skin);
		neutralSpecialLeft = AttackCreator.getLacerdaNeutralSpecial1Left(skin);
		upSpecialRight = AttackCreator.getLacerdaUpSpecialRight(skin);
		upSpecialLeft = AttackCreator.getLacerdaUpSpecialLeft(skin);
		parryRight = AttackCreator.getLacerdaParryRightFrames(skin);
		parryLeft = AttackCreator.getLacerdaParryLeftFrames(skin);
		
		sideSpecialMagic = 3;
		neutralSpecialMagic = 1;
		upSpecialMagic = 2;
		
		jumpSpeed = 17;
		groundSpeed = 13;
		airSpeed = 6;
		jumps = 2;
		weight = 0.85;
		
		stockIcon = Assets.lacerdaStockIcon;
	}
	
	public void resetBomb() {
		
		bombKnockback = 15;
		chargeBombKnockback = 15;
		sideSpecialRight = AttackCreator.getLacerdaSideSpecial1Right(skin);
		sideSpecialLeft = AttackCreator.getLacerdaSideSpecial1Left(skin);
		sideSpecialRight.setKnockbackXSpeed(bombKnockback);
		sideSpecialRight.setKnockbackYSpeed(-bombKnockback);
		sideSpecialLeft.setKnockbackXSpeed(-bombKnockback);
		sideSpecialLeft.setKnockbackYSpeed(-bombKnockback);
	}
	
	private int calculateCounterKnockbackComponent(int knockbackX, int knockbackY) {
		int opponentKnockbackX = knockbackX;
		int opponentKnockbackY = knockbackY;
		
		double opponentKnockbackModule = Math.sqrt((double)opponentKnockbackX*opponentKnockbackX + (double)opponentKnockbackY*opponentKnockbackY);
		return (int)Math.ceil(1.2*Math.sqrt(2)*opponentKnockbackModule/2); 
	}
	
	private boolean checkCounterHit(Player player) {
		
		if (player.getLookDirection() == 1) {
			
			if (player.opponent.getCurrentFrame().getHitboxes() != null) {
				
				for (Hitbox hitbox: player.opponent.getCurrentFrame().getHitboxes()) {
					
					for (Counterbox counterbox: neutralSpecialRight.getFrames()[1].getCounterboxes()) {
						
						if ((Math.pow((double) ((hitbox.getX() + player.opponent.getX()) - (counterbox.getX() + player.x)), 2) + Math.pow((double) ((hitbox.getY() + player.opponent.getY()) - (counterbox.getY() + player.y)), 2)) < Math.pow((double) (hitbox.getR() + counterbox.getR()), 2)) {
					
							return true;
						}
					}
				}
			}
		}
		else if (player.getLookDirection() == 0) {
			
			if (player.opponent.getCurrentFrame().getHitboxes() != null) {
				
				for (Hitbox hitbox: player.opponent.getCurrentFrame().getHitboxes()) {
					
					for (Counterbox counterbox: neutralSpecialLeft.getFrames()[1].getCounterboxes()) {
						
						if ((Math.pow((double) ((hitbox.getX() + player.opponent.getX()) - (counterbox.getX() + player.x)), 2) + Math.pow((double) ((hitbox.getY() + player.opponent.getY()) - (counterbox.getY() + player.y)), 2)) < Math.pow((double) (hitbox.getR() + counterbox.getR()), 2)) {
					
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean checkCounterProjectileHit(Player player) {
		
		if (player.getLookDirection() == 1) {
			
			if (!GameState.projectiles.isEmpty()) {
								
				for (Counterbox counterbox: neutralSpecialRight.getFrames()[1].getCounterboxes()) {
								
					for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
									
						if (GameState.projectiles.get(i).getOwner().equals(player.opponent)) {
							
							if (GameState.projectiles.get(i).getHitboxes() != null) {
										
								for (Hitbox hitbox: GameState.projectiles.get(i).getHitboxes()) {
										
									if ((Math.pow((double) ((hitbox.getX() + GameState.projectiles.get(i).getX()) - (counterbox.getX() + player.x)), 2) + Math.pow((double) ((hitbox.getY() + GameState.projectiles.get(i).getY()) - (counterbox.getY() + player.y)), 2)) < Math.pow((double) (hitbox.getR() + counterbox.getR()), 2)) {
										
										counterProjectileDamage = GameState.projectiles.get(i).getDamage();
										counterProjectileKnockbackXSpeed = calculateCounterKnockbackComponent(GameState.projectiles.get(i).getKnockbackXspeed(), GameState.projectiles.get(i).getKnockbackYspeed());
										counterProjectileKnockbackYSpeed = counterProjectileKnockbackXSpeed;
										if (!(GameState.projectiles.get(i) instanceof BearTrap)) {
											
											GameState.projectiles.get(i).updateImage();
											GameState.projectiles.remove(i);
										}

										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		else if (player.getLookDirection() == 0) {
			
			if (!GameState.projectiles.isEmpty()) {
				
				for (Counterbox counterbox: neutralSpecialLeft.getFrames()[1].getCounterboxes()) {
								
					for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
									
						if (GameState.projectiles.get(i).getOwner().equals(player.opponent)) {
							
							if (GameState.projectiles.get(i).getHitboxes() != null) {
										
								for (Hitbox hitbox: GameState.projectiles.get(i).getHitboxes()) {
										
									if ((Math.pow((double) ((hitbox.getX() + GameState.projectiles.get(i).getX()) - (counterbox.getX() + player.x)), 2) + Math.pow((double) ((hitbox.getY() + GameState.projectiles.get(i).getY()) - (counterbox.getY() + player.y)), 2)) < Math.pow((double) (hitbox.getR() + counterbox.getR()), 2)) {
										
										counterProjectileDamage = GameState.projectiles.get(i).getDamage();
										counterProjectileKnockbackXSpeed = calculateCounterKnockbackComponent(GameState.projectiles.get(i).getKnockbackXspeed(), GameState.projectiles.get(i).getKnockbackYspeed());
										counterProjectileKnockbackYSpeed = counterProjectileKnockbackXSpeed;
										
										if (!(GameState.projectiles.get(i) instanceof BearTrap)) {
											
											GameState.projectiles.get(i).updateImage();
											GameState.projectiles.remove(i);
										}
										return true;
									}
								}
							}
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private void resetCounter() {
		
		countering = false;
		neutralSpecialRight = AttackCreator.getLacerdaNeutralSpecial1Right(skin);
		neutralSpecialLeft = AttackCreator.getLacerdaNeutralSpecial1Left(skin);
	}

	@Override
	protected void useJab(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		if (attackIF > jabRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF < jabRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(jabRight.getFrames()[attackUF]);
				player.setCurrentAttack(jabRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(jabLeft.getFrames()[attackUF]);
				player.setCurrentAttack(jabLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setJabbing(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setJabbing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
		
		if (player.getOnAir()) {
			
			player.setAttacking(false);
			player.setJabbing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useDash(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		if (attackIF > dashRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF < dashRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(dashRight.getFrames()[attackUF]);
				player.setCurrentAttack(dashRight);
				
				if (attackUF < 3) {
					player.increaseX(15);
				}			
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(dashLeft.getFrames()[attackUF]);
				player.setCurrentAttack(dashLeft);
				
				if (attackUF < 3) {
					player.increaseX(-15);
				}
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setDashing(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setDashing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
		
		if (player.getOnAir()) {
			
			player.setAttacking(false);
			player.setDashing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useUpTilt(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		if (attackIF > upTiltRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF < upTiltRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(upTiltRight.getFrames()[attackUF]);
				player.setCurrentAttack(upTiltRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(upTiltLeft.getFrames()[attackUF]);
				player.setCurrentAttack(upTiltLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setUpTilting(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setUpTilting(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
		
		if (player.getOnAir()) {
			
			player.setAttacking(false);
			player.setUpTilting(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useBair(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		if (attackIF > bairRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF < bairRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(bairRight.getFrames()[attackUF]);
				player.setCurrentAttack(bairRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(bairLeft.getFrames()[attackUF]);
				player.setCurrentAttack(bairLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setBairing(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setBairing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
		
		if (!player.getOnAir()) {
			
			player.setAttacking(false);
			player.setBairing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useFair(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		if (attackIF > fairRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF < fairRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(fairRight.getFrames()[attackUF]);
				player.setCurrentAttack(fairRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(fairLeft.getFrames()[attackUF]);
				player.setCurrentAttack(fairLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setFairing(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setFairing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
		
		if (!player.getOnAir()) {
			
			player.setAttacking(false);
			player.setFairing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useUpAir(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		if (attackIF > upAirRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF < upAirRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(upAirRight.getFrames()[attackUF]);
				player.setCurrentAttack(upAirRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(upAirLeft.getFrames()[attackUF]);
				player.setCurrentAttack(upAirLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setUpAiring(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setUpAiring(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
		
		if (!player.getOnAir()) {
			
			player.setAttacking(false);
			player.setUpAiring(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useSideSpecial(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		if (!chargingBomb) {
			
			//System.out.println(attackUF);
			
		
			if (attackIF > sideSpecialRight.getFrames()[attackUF].getDuration()) {
				
				attackIF = 0;
				attackUF++;
			}
			
			if (attackUF == 0) {
				
				if (attackIF == 1) {
					
					player.decreaseMagic(sideSpecialMagic);
					if (bombKnockback < 20) {
						
						sideSpecialRight = AttackCreator.getLacerdaSideSpecial1Right(skin);
						sideSpecialLeft = AttackCreator.getLacerdaSideSpecial1Left(skin);
						chargeBombKnockback = bombKnockback;
					}
					
				}
				
				if (attackIF == 3) {
					
					if (player.pressingSpecial) {
						
						chargingBomb = true;
					}
				}
			}
			
			if (attackUF == 3) {
				
				if (attackIF == 1) {
					
					if (chargeBombKnockback >= 25) {
						
						SoundManager.play("sounds/Explosion3.wav", false);
					}
					else if (chargeBombKnockback >= 20) {
						
						SoundManager.play("sounds/Explosion2.wav", false);
					}
					else {
						
						SoundManager.play("sounds/Explosion1.wav", false);
					}
				}
			}
		
		}
		
		if (chargingBomb) {
			
			//System.out.println(bombKnockback);
			
			if (attackIF % 3 == 0) {
				
				bombKnockback++;
				
				if (bombKnockback < 20) {
					
					sideSpecialRight = AttackCreator.getLacerdaSideSpecial1Right(skin);
					sideSpecialLeft = AttackCreator.getLacerdaSideSpecial1Left(skin);
				}
				
				if (bombKnockback == 20) {
					
					sideSpecialRight = AttackCreator.getLacerdaSideSpecial2Right(skin);
					sideSpecialLeft = AttackCreator.getLacerdaSideSpecial2Left(skin);
				}
				
				if (bombKnockback == 25) {
					
					sideSpecialRight = AttackCreator.getLacerdaSideSpecial3Right(skin);
					sideSpecialLeft = AttackCreator.getLacerdaSideSpecial3Left(skin);
				}
				
				chargeBombKnockback = bombKnockback;
				
				if (bombKnockback >= 30) {
					
					chargingBomb = false;
					sideSpecialRight.setKnockbackXSpeed(bombKnockback);
					sideSpecialRight.setKnockbackYSpeed(-bombKnockback);
					sideSpecialLeft.setKnockbackXSpeed(-bombKnockback);
					sideSpecialLeft.setKnockbackYSpeed(-bombKnockback);
					bombKnockback = 15;
				}
			}
			
			if (!player.pressingSpecial) {
				
				chargingBomb = false;
				sideSpecialRight.setKnockbackXSpeed(bombKnockback);
				sideSpecialRight.setKnockbackYSpeed(-bombKnockback);
				sideSpecialLeft.setKnockbackXSpeed(-bombKnockback);
				sideSpecialLeft.setKnockbackYSpeed(-bombKnockback);
				bombKnockback = 15;
			}
		}
		

		
		if (attackUF < sideSpecialRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(sideSpecialRight.getFrames()[attackUF]);
				player.setCurrentAttack(sideSpecialRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(sideSpecialLeft.getFrames()[attackUF]);
				player.setCurrentAttack(sideSpecialLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setSideSpecialing(false);
			attackUF = 0;
			resetBomb();
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setSideSpecialing(false);
			attackIF = 0;
			attackUF = 0;
			resetBomb();
			return;
		}
	}

	@Override
	protected void useNeutralSpecial(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		
		if (attackIF > neutralSpecialRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF == 0 && !countering) {
			
			if (attackIF == 1) {
				
				player.decreaseMagic(neutralSpecialMagic);
			}
		}
		
		if (attackUF == 1 && !countering) {
			
			if (attackIF == 0) {
				
				SoundManager.play("sounds/Counter.wav", false);
			}
				
			if (checkCounterHit(player)) {

				if (attackIF >= 1) {
					
					if (player.opponent.character instanceof Obino && player.opponent.sideSpecialing) {
						
						player.setAttacking(false);
						player.setNeutralSpecialing(false);
						attackIF = 0;
						attackUF = 0;
						resetCounter();
						return;
					}
					else {
					
						GameState.setParryFreezeCounter(15);
						player.opponent.setFreezeFrames(15);
						player.setHistun(0);
						player.setFreezeFrames(0);
						attackUF = 0;
						attackIF = 0;
						neutralSpecialRight = AttackCreator.getLacerdaNeutralSpecial2Right(skin);
						neutralSpecialLeft = AttackCreator.getLacerdaNeutralSpecial2Left(skin);
						countering = true;
						neutralSpecialRight.setDamage((int)(1.5*(player.opponent.getCurrentAttack().getDamage())));
						neutralSpecialLeft.setDamage((int)(1.5*(player.opponent.getCurrentAttack().getDamage())));
						int counterKnockbackComponent = calculateCounterKnockbackComponent(player.opponent.getCurrentAttack().getKnockbackXspeed(), player.opponent.getCurrentAttack().getKnockbackYspeed());
						neutralSpecialRight.setKnockbackXSpeed(counterKnockbackComponent);
						neutralSpecialRight.setKnockbackYSpeed(-counterKnockbackComponent);
						neutralSpecialLeft.setKnockbackXSpeed(-counterKnockbackComponent);
						neutralSpecialLeft.setKnockbackYSpeed(-counterKnockbackComponent);

						
						if (player.x >= player.opponent.getX()) {
							
							player.setLookDirection(0);
						}
						else {
							
							player.setLookDirection(1);
						}
					}
				}
			}
			else if (checkCounterProjectileHit(player)) {
				
				GameState.setParryFreezeCounter(15);
				attackUF = 0;
				attackIF = 0;
				neutralSpecialRight = AttackCreator.getLacerdaNeutralSpecial2Right(skin);
				neutralSpecialLeft = AttackCreator.getLacerdaNeutralSpecial2Left(skin);
				countering = true;
				neutralSpecialRight.setDamage((int)(1.5*(counterProjectileDamage)));
				neutralSpecialLeft.setDamage((int)(1.5*(counterProjectileDamage)));
				
				
				if (player.x >= player.opponent.getX()) {
					
					player.setLookDirection(0);
					neutralSpecialRight.setKnockbackXSpeed(-counterProjectileKnockbackXSpeed);
					neutralSpecialRight.setKnockbackYSpeed(-counterProjectileKnockbackYSpeed);
				}
				else {
					
					player.setLookDirection(1);
					neutralSpecialRight.setKnockbackXSpeed(counterProjectileKnockbackXSpeed);
					neutralSpecialRight.setKnockbackYSpeed(-counterProjectileKnockbackYSpeed);
				}
			}
		}
		
		
		if (attackUF < neutralSpecialRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(neutralSpecialRight.getFrames()[attackUF]);
				player.setCurrentAttack(neutralSpecialRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(neutralSpecialLeft.getFrames()[attackUF]);
				player.setCurrentAttack(neutralSpecialLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setNeutralSpecialing(false);
			attackUF = 0;
			resetCounter();
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setNeutralSpecialing(false);
			attackIF = 0;
			attackUF = 0;
			resetCounter();
			return;
		}
	}

	@Override
	protected void useUpSpecial(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		
		if (attackIF > upSpecialRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF == 0) {
			
			if (attackIF == 1) {
				
				player.decreaseMagic(upSpecialMagic);
			}
		}
		if (attackUF == 7 && attackIF == 1) {
			player.xSpeed = 0;
			player.ySpeed = 0;
			
		}
		if (attackUF == 9 && attackIF == 1) {
			
			SoundManager.play("sounds/SmokeBomb.wav", false);
			
			((SmashPlayer)(player)).tpCounter = 2;
			if (player.pressingRight && !(player.pressingLeft || player.pressingShield)) {
				
				player.increaseX(upBdistance);
				player.setYSpeed(0);
			}
			else if (player.pressingLeft && !(player.pressingRight || player.pressingShield)) {
				
				player.increaseX(-upBdistance);
				player.setYSpeed(0);
			}
			else if (player.pressingShield && !(player.pressingRight || player.pressingLeft)) {
				
				player.increaseY(upBdistance);
				player.setYSpeed(0);
			}
			else if (player.pressingUp && !(player.pressingRight || player.pressingLeft)){
				
				player.increaseY(-upBdistance);
				player.setYSpeed(0);
			}
			else {
				player.setYSpeed(0);
			}
			
		}
		
		if (attackUF < upSpecialRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(upSpecialRight.getFrames()[attackUF]);
				player.setCurrentAttack(upSpecialRight);
				
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(upSpecialLeft.getFrames()[attackUF]);
				player.setCurrentAttack(upSpecialLeft);
				
			}
		}
		
		else {
			
			player.setAttacking(false);
			player.setUpSpecialing(false);
			attackUF = 0;
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setUpSpecialing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void walk(Player player) {
		
		walkIF++;
		
		if (walkIF > walkingRight.getFrames()[walkUF].getDuration()) {
			
			walkIF = 0;
			walkUF++;
		}
		
		if (walkUF < walkingRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(walkingRight.getFrames()[walkUF]);
				player.setCurrentAttack(walkingRight);
			}
			
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(walkingLeft.getFrames()[walkUF]);
				player.setCurrentAttack(walkingLeft);
			}
		}
		
		else {
			
			walkUF = 0;
		}
	}
	
}
