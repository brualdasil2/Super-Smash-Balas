
public class Obino extends Character{

	
	protected boolean trapActive = false;
	
	public Obino (int skin) {
		
		super(skin);
		standingRight = AttackCreator.getObinoStandingRight(skin);
		standingLeft = AttackCreator.getObinoStandingLeft(skin);
		walkingRight = AttackCreator.getObinoWalkingRight(skin);
		walkingLeft = AttackCreator.getObinoWalkingLeft(skin);
		jabRight = AttackCreator.getObinoJabRight(skin);
		jabLeft = AttackCreator.getObinoJabLeft(skin);
		dashRight = AttackCreator.getObinoDashRight(skin);
		dashLeft = AttackCreator.getObinoDashLeft(skin);
		shieldingRight = AttackCreator.getObinoShieldingRight(skin);
		shieldHitRight = AttackCreator.getObinoShieldHitRight(skin);
		shieldingLeft = AttackCreator.getObinoShieldingLeft(skin);
		shieldHitLeft = AttackCreator.getObinoShieldHitLeft(skin);
		upTiltRight = AttackCreator.getObinoUpTiltRight(skin);
		upTiltLeft = AttackCreator.getObinoUpTiltLeft(skin);
		bairRight = AttackCreator.getObinoBairRight(skin);
		bairLeft = AttackCreator.getObinoBairLeft(skin);
		fairRight = AttackCreator.getObinoFairRight(skin);
		fairLeft = AttackCreator.getObinoFairLeft(skin);
		upAirRight = AttackCreator.getObinoUpAirRight(skin);
		upAirLeft = AttackCreator.getObinoUpAirLeft(skin);
		sideSpecialRight = AttackCreator.getObinoSideSpecialRight(skin);
		sideSpecialLeft = AttackCreator.getObinoSideSpecialLeft(skin);
		neutralSpecialRight = AttackCreator.getObinoNeutralSpecialRight(skin);
		neutralSpecialLeft = AttackCreator.getObinoNeutralSpecialLeft(skin);
		upSpecialRight = AttackCreator.getObinoUpSpecialRight(skin);
		upSpecialLeft = AttackCreator.getObinoUpSpecialLeft(skin);
		parryRight = AttackCreator.getObinoParryRightFrames(skin);
		parryLeft = AttackCreator.getObinoParryLeftFrames(skin);
		
		sideSpecialMagic = 2;
		neutralSpecialMagic = 3;
		upSpecialMagic = 2;
		
		jumpSpeed = 16;
		groundSpeed = 6;
		airSpeed = 4;
		jumps = 2;
		weight = 1.3;
		
		stockIcon = Assets.obinoStockIcon;
	}
	
	protected void closeTrap(Player player) {
		
		if (trapActive && !player.attacking && player.hitstunFrames == 0 && player.freezeFrames == 0) {
			
			for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
				
				if (GameState.projectiles.get(i) instanceof BearTrap) {
					
					if (GameState.projectiles.get(i).getOwner() == player){
					
						((BearTrap)(GameState.projectiles.get(i))).closeTrap();
						trapActive = false;
						SoundManager.play("sounds/BearTrap.wav", false);
						
						player.setHistun(15);
						attackIF = 0;
						attackUF = 0;
						return;
					}
				}
			}
		}
	}
	
	protected void deactivateTrap() {
		
		trapActive = false;
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
				
				if (attackUF >= 3 && attackUF <= 4) {
					player.increaseX(10);
				}			
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(dashLeft.getFrames()[attackUF]);
				player.setCurrentAttack(dashLeft);
				
				if (attackUF >= 3 && attackUF <= 4) {
					player.increaseX(-10);
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
		
		
		
		
		if (attackIF > sideSpecialRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF == 0) {
			
			if (attackIF == 1) {
				
				player.decreaseMagic(sideSpecialMagic);
				SoundManager.play("sounds/Whip.wav", false);
			}
		}
		
		if (attackUF == 5) {
			
			if (attackIF == 1) {
				
				SoundManager.play("sounds/Chain.wav", false);
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
			
		}
		
		if (player.getHitstunFrames() > 0) {
			
			player.setAttacking(false);
			player.setSideSpecialing(false);
			attackIF = 0;
			attackUF = 0;
			return;
		}
	}

	@Override
	protected void useNeutralSpecial(Player player) {
		
		if (player.onAir) {
			
			player.setAttacking(false);
			player.setNeutralSpecialing(false);
			return;
		}
		
		player.setAttacking(true);
		attackIF++;
		
		
		if (!trapActive) {
			
			if (attackIF > neutralSpecialRight.getFrames()[attackUF].getDuration()) {
				
				attackIF = 0;
				attackUF++;
			}
			
			if (attackUF == 0) {
				
				if (attackIF == 1) {
					
					player.decreaseMagic(neutralSpecialMagic);
				}
			}
			
			if (attackUF == 3) {
				
				if (attackIF == 6) {
					
					trapActive = true;
					
					if (player.getLookDirection() == 1) {
						
						GameState.projectiles.add(new BearTrap(player, player.getX() + 150, player.getY() + 100, 0, 0));
					}
					else if (player.getLookDirection() == 0) {
						
						GameState.projectiles.add(new BearTrap(player, player.getX() -50, player.getY() + 100, 0, 0));
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
				
			}
			
			if (player.getHitstunFrames() > 0) {
				
				player.setAttacking(false);
				player.setNeutralSpecialing(false);
				attackIF = 0;
				attackUF = 0;
				return;
			}
		}
		else {
			
			player.setAttacking(false);
			player.setNeutralSpecialing(false);
			attackIF = 0;
			attackUF = 0;
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
		
		if (attackUF == 6) {
			
			if (attackIF == 1) {
				
				if (player.getLookDirection() == 1) {
					
					GameState.projectiles.add(new SnowBall(player, player.getX() + 84, player.getY() - 30, 3, -15));
				}
				else if (player.getLookDirection() == 0) {
					
					GameState.projectiles.add(new SnowBall(player, player.getX() + 84, player.getY() - 30, -3, -15));
				}
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
		
	
}
