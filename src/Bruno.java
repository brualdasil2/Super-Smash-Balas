
public class Bruno extends Character{
	
	public Bruno (int skin) {
		
		super(skin);
		standingRight = AttackCreator.getBrunoStandingRight(skin);
		standingLeft = AttackCreator.getBrunoStandingLeft(skin);
		walkingRight = AttackCreator.getBrunoWalkingRight(skin);
		walkingLeft = AttackCreator.getBrunoWalkingLeft(skin);
		jabRight = AttackCreator.getBrunoJabRight(skin);
		jabLeft = AttackCreator.getBrunoJabLeft(skin);
		dashRight = AttackCreator.getBrunoDashRight(skin);
		dashLeft = AttackCreator.getBrunoDashLeft(skin);
		shieldingRight = AttackCreator.getBrunoShieldingRight(skin);
		shieldHitRight = AttackCreator.getBrunoShieldHitRight(skin);
		shieldingLeft = AttackCreator.getBrunoShieldingLeft(skin);
		shieldHitLeft = AttackCreator.getBrunoShieldHitLeft(skin);
		upTiltRight = AttackCreator.getBrunoUpTiltRight(skin);
		upTiltLeft = AttackCreator.getBrunoUpTiltLeft(skin);
		bairRight = AttackCreator.getBrunoBairRight(skin);
		bairLeft = AttackCreator.getBrunoBairLeft(skin);
		fairRight = AttackCreator.getBrunoFairRight(skin);
		fairLeft = AttackCreator.getBrunoFairLeft(skin);
		upAirRight = AttackCreator.getBrunoUpAirRight(skin);
		upAirLeft = AttackCreator.getBrunoUpAirLeft(skin);
		sideSpecialRight = AttackCreator.getBrunoSideSpecialRight(skin);
		sideSpecialLeft = AttackCreator.getBrunoSideSpecialLeft(skin);
		neutralSpecialRight = AttackCreator.getBrunoNeutralSpecialRight(skin);
		neutralSpecialLeft = AttackCreator.getBrunoNeutralSpecialLeft(skin);
		upSpecialRight = AttackCreator.getBrunoUpSpecialRight(skin);
		upSpecialLeft = AttackCreator.getBrunoUpSpecialLeft(skin);
		parryRight = AttackCreator.getBrunoParryRightFrames(skin);
		parryLeft = AttackCreator.getBrunoParryLeftFrames(skin);
		
		sideSpecialMagic = 2;
		neutralSpecialMagic = 2;
		upSpecialMagic = 4;
		
		jumpSpeed = 17;
		groundSpeed = 10;
		airSpeed = 5;
		jumps = 2;
		weight = 1;
		
		stockIcon = Assets.brunoStockIcon;
		
	}

	@Override
	public void walk(Player player) {
		
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
	public void useJab(Player player) {
		
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
	
	public void useDash(Player player) {
		
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
				
				if (attackUF <= 3) {
					player.increaseX(15);
				}			
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(dashLeft.getFrames()[attackUF]);
				player.setCurrentAttack(dashLeft);
				
				if (attackUF <= 3) {
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
	public void useUpTilt(Player player) {
		
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
	public void useBair(Player player) {
		
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
	public void useFair(Player player) {
		
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
	public void useUpAir(Player player) {
		
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
	public void useSideSpecial(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		
		if (attackIF > sideSpecialRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF == 0) {
			
			if (attackIF == 1) {
				
				player.decreaseMagic(sideSpecialMagic);
			}
		}
		
		if (attackUF == 1) {
			
			if (attackIF == 1) {
				
				if (player.getLookDirection() == 1) {
					
					GameState.projectiles.add(new Bala(player, player.getX() + 100, player.getY(), 30, 0));
				}
				else if (player.getLookDirection() == 0) {
					
					GameState.projectiles.add(new Bala(player, player.getX() + 36, player.getY(), -30, 0));
				}
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
	public void useNeutralSpecial(Player player) {
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		
		if (attackIF > neutralSpecialRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF == 0) {
			
			if (attackIF == 1) {
				
				player.decreaseMagic(neutralSpecialMagic);
				SoundManager.play("sounds/Eating.wav", false);
			}
		}
		
		if (attackUF == 6) {
			
			if (attackIF == 1) {
				
				player.restoreShield();
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
	
	@Override
	public void useUpSpecial(Player player) {
		
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
		
		if (attackUF == 0) {
			
			if (attackIF % 5 == 0 && attackIF <= 50) {
				
				if (attackIF % 10 == 0) {
					
					GameState.projectiles.add(new Halls(player, player.getX() + 84, player.getY() - 20, -2, -15));
				}
				
				else {
					
					GameState.projectiles.add(new Halls(player, player.getX() + 84, player.getY() - 20, 2, -15));
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
