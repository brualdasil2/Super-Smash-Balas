
public class Carol extends Character {
	
	
	
	public Carol (int skin) {
		
		super(skin);
		standingRight = AttackCreator.getCarolStandingRight(skin);
		standingLeft = AttackCreator.getCarolStandingLeft(skin);
		walkingRight = AttackCreator.getCarolWalkingRight(skin);
		walkingLeft = AttackCreator.getCarolWalkingLeft(skin);
		jabRight = AttackCreator.getCarolJabRight(skin);
		jabLeft = AttackCreator.getCarolJabLeft(skin);
		dashRight = AttackCreator.getCarolDashRight(skin);
		dashLeft = AttackCreator.getCarolDashLeft(skin);
		upTiltRight = AttackCreator.getCarolUpTiltRight(skin);
		upTiltLeft = AttackCreator.getCarolUpTiltLeft(skin);
		bairRight = AttackCreator.getCarolBairRight(skin);
		bairLeft = AttackCreator.getCarolBairLeft(skin);
		fairRight = AttackCreator.getCarolFairRight(skin);
		fairLeft = AttackCreator.getCarolFairLeft(skin);
		upAirRight = AttackCreator.getCarolUpAirRight(skin);
		upAirLeft = AttackCreator.getCarolUpAirLeft(skin);
		sideSpecialRight = AttackCreator.getCarolSideSpecialRight(skin);
		sideSpecialLeft = AttackCreator.getCarolSideSpecialLeft(skin);
		neutralSpecialRight = AttackCreator.getCarolNeutralSpecialRight(skin);
		neutralSpecialLeft = AttackCreator.getCarolNeutralSpecialLeft(skin);
		upSpecialRight = AttackCreator.getCarolUpSpecialRight(skin);
		upSpecialLeft = AttackCreator.getCarolUpSpecialLeft(skin);
		shieldingRight = AttackCreator.getCarolShieldingRight(skin);
		shieldHitRight = AttackCreator.getCarolShieldHitRight(skin);
		shieldingLeft = AttackCreator.getCarolShieldingLeft(skin);
		shieldHitLeft = AttackCreator.getCarolShieldHitLeft(skin);
		parryRight = AttackCreator.getCarolParryRightFrames(skin);
		parryLeft = AttackCreator.getCarolParryLeftFrames(skin);
		
		
		sideSpecialMagic = 1;
		neutralSpecialMagic = 2;
		upSpecialMagic = 6;
		
		jumpSpeed = 18;
		groundSpeed = 7;
		airSpeed = 7; 
		jumps = 2;
		weight = 0.75;
		
		stockIcon = Assets.carolStockIcon;
	}
	
	public void setSuper() {
		
		jumps = 4;
		airSpeed = 12;
		
		standingRight = AttackCreator.getCarolStandingRight(skin + 2);
		standingLeft = AttackCreator.getCarolStandingLeft(skin + 2);
		walkingRight = AttackCreator.getCarolWalkingRight(skin + 2);
		walkingLeft = AttackCreator.getCarolWalkingLeft(skin + 2);
		jabRight = AttackCreator.getCarolJabRight(skin + 2);
		jabLeft = AttackCreator.getCarolJabLeft(skin + 2);
		dashRight = AttackCreator.getCarolDashRight(skin + 2);
		dashLeft = AttackCreator.getCarolDashLeft(skin + 2);
		upTiltRight = AttackCreator.getCarolUpTiltRight(skin + 2);
		upTiltLeft = AttackCreator.getCarolUpTiltLeft(skin + 2);
		bairRight = AttackCreator.getCarolBairRight(skin + 2);
		bairLeft = AttackCreator.getCarolBairLeft(skin + 2);
		fairRight = AttackCreator.getCarolFairRight(skin + 2);
		fairLeft = AttackCreator.getCarolFairLeft(skin + 2);
		upAirRight = AttackCreator.getCarolUpAirRight(skin + 2);
		upAirLeft = AttackCreator.getCarolUpAirLeft(skin + 2);
		sideSpecialRight = AttackCreator.getCarolSideSpecialRight(skin + 2);
		sideSpecialLeft = AttackCreator.getCarolSideSpecialLeft(skin + 2);
		neutralSpecialRight = AttackCreator.getCarolNeutralSpecialRight(skin + 2);
		neutralSpecialLeft = AttackCreator.getCarolNeutralSpecialLeft(skin + 2);
		upSpecialRight = AttackCreator.getCarolUpSpecialRight(skin + 2);
		upSpecialLeft = AttackCreator.getCarolUpSpecialLeft(skin + 2);
		shieldingRight = AttackCreator.getCarolShieldingRight(skin + 2);
		shieldHitRight = AttackCreator.getCarolShieldHitRight(skin + 2);
		shieldingLeft = AttackCreator.getCarolShieldingLeft(skin + 2);
		shieldHitLeft = AttackCreator.getCarolShieldHitLeft(skin + 2);
		parryRight = AttackCreator.getCarolParryRightFrames(skin + 2);
		parryLeft = AttackCreator.getCarolParryLeftFrames(skin + 2);
	}
	
	public void endSuper() {
		
		jumps = 2;
		airSpeed = 7;

		
		standingRight = AttackCreator.getCarolStandingRight(skin);
		standingLeft = AttackCreator.getCarolStandingLeft(skin);
		walkingRight = AttackCreator.getCarolWalkingRight(skin);
		walkingLeft = AttackCreator.getCarolWalkingLeft(skin);
		jabRight = AttackCreator.getCarolJabRight(skin);
		jabLeft = AttackCreator.getCarolJabLeft(skin);
		dashRight = AttackCreator.getCarolDashRight(skin);
		dashLeft = AttackCreator.getCarolDashLeft(skin);
		upTiltRight = AttackCreator.getCarolUpTiltRight(skin);
		upTiltLeft = AttackCreator.getCarolUpTiltLeft(skin);
		bairRight = AttackCreator.getCarolBairRight(skin);
		bairLeft = AttackCreator.getCarolBairLeft(skin);
		fairRight = AttackCreator.getCarolFairRight(skin);
		fairLeft = AttackCreator.getCarolFairLeft(skin);
		upAirRight = AttackCreator.getCarolUpAirRight(skin);
		upAirLeft = AttackCreator.getCarolUpAirLeft(skin);
		sideSpecialRight = AttackCreator.getCarolSideSpecialRight(skin);
		sideSpecialLeft = AttackCreator.getCarolSideSpecialLeft(skin);
		neutralSpecialRight = AttackCreator.getCarolNeutralSpecialRight(skin);
		neutralSpecialLeft = AttackCreator.getCarolNeutralSpecialLeft(skin);
		upSpecialRight = AttackCreator.getCarolUpSpecialRight(skin);
		upSpecialLeft = AttackCreator.getCarolUpSpecialLeft(skin);
		shieldingRight = AttackCreator.getCarolShieldingRight(skin);
		shieldHitRight = AttackCreator.getCarolShieldHitRight(skin);
		shieldingLeft = AttackCreator.getCarolShieldingLeft(skin);
		shieldHitLeft = AttackCreator.getCarolShieldHitLeft(skin);
		parryRight = AttackCreator.getCarolParryRightFrames(skin);
		parryLeft = AttackCreator.getCarolParryLeftFrames(skin);
		
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
		
		if (attackUF == 2) {
			
			if (attackIF == 0) {
				
				SoundManager.play("sounds/PianoKeys.wav", false);
			}
		}
		
		if (attackUF < dashRight.getUniqueFrames()) {
			
			if (player.getLookDirection() == 1) {
				
				player.setCurrentFrame(dashRight.getFrames()[attackUF]);
				player.setCurrentAttack(dashRight);
				
				if (attackUF == 3) {
					player.increaseX(5);
				}			
			}
			else if (player.getLookDirection() == 0) {
				
				player.setCurrentFrame(dashLeft.getFrames()[attackUF]);
				player.setCurrentAttack(dashLeft);
				
				if (attackUF == 3) {
					player.increaseX(-5);
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
			}
		}
		
		if (attackUF == 2) {
			
			if (attackIF == 1) {
				
				if (player.getLookDirection() == 1) {
					
					GameState.projectiles.add(new Nota(player, player.getX() + 180, player.getY() + 70, 15, -15));
				}
				else if (player.getLookDirection() == 0) {
					
					GameState.projectiles.add(new Nota(player, player.getX() -40, player.getY() + 70, -15, -15));
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
	protected void useNeutralSpecial(Player player) {
		
		if (player.onAir) {
			
			player.setAttacking(false);
			player.setNeutralSpecialing(false);
			return;
		}
		
		player.setAttacking(true);
		attackIF++;
		
		
		
		
		if (attackIF > neutralSpecialRight.getFrames()[attackUF].getDuration()) {
			
			attackIF = 0;
			attackUF++;
		}
		
		if (attackUF == 0) {
			
			if (attackIF == 1) {
				
				player.decreaseMagic(neutralSpecialMagic);
			}
		}
		
		
		if (attackUF == 7) {
			
			if (attackIF == 1) {
				
				if (player.getLookDirection() == 1) {
					
					GameState.projectiles.add(new Rosa(player, player.getX() + 150, player.getY() + 100, 0, 0));
				}
				else if (player.getLookDirection() == 0) {
					
					GameState.projectiles.add(new Rosa(player, player.getX() -50, player.getY() + 100, 0, 0));
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

	private boolean superIsActive() {
		for (Projectile p : GameState.projectiles) {
			if (p instanceof SuperWings) {
				if (p.owner.character == this) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	protected void useUpSpecial(Player player) {
		
		if (superIsActive() && attackUF == 0) {
			player.setAttacking(false);
			player.setUpSpecialing(false);
			return;
		}
		
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
		
		if (attackUF == upSpecialRight.getUniqueFrames()-1) {
			if (attackIF == 2) {
				GameState.projectiles.add(new SuperWings(player, 0, 0, 0, 0));
				setSuper();
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
			attackIF = 0;
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
