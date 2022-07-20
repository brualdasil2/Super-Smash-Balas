
public class TrainingBot extends Player {
	
	private int state, rand, frameCounter = 0, escapeOption = 0, behaviorOption = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter, gotHit = false;
	
	private LacerdaCombos combos = new LacerdaCombos(this);
	
	public TrainingBot(Game game, int playerNumb, Character character, double x, double y) {
		
		super(game, playerNumb, character, x, y, "BOT (T)");
		frameCounter = 0;
		escapeOption = 0;
		behaviorOption = 0;
	}

		
	private void checkState() {
		opponentOnLeft = (opponent.x - x < 0);
		opponentOnRight = (opponent.x - x > 0);
		opponentAttacking = opponent.attacking;
	}

	
	private void setFrames(int frames) {
		
		if (frameCounter == 0)
			frameCounter = frames;
		
		frameCounter--;
	}
	
	
	private void mashJump() {
		
		pressingJump = true;
	}
	
	private void mashFair() {
		
		turnToOpponent();
		pressingAttack = true;
	}
	
	private void mashUpAir() {
		
		pressingUp = true;
		pressingAttack = true;
	}
	
	private void mashNeutralSpecial() {
		
		pressingSpecial = true;
	}
	
	private void timedJump() {
		
		setFrames(45);
		
		if (frameCounter == 29) {
			pressingJump = true;
		}
	}
	
	private void mashJab() {
		pressingAttack = true;
	}
	
	private void mashDash() {
		turnToOpponent();
		pressingAttack = true;
	}
	
	private void mashUpTilt() {
		pressingUp = true;
		pressingAttack = true;
	}
	
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			pressingLeft = true;	
		if (opponentOnRight)
			pressingRight = true;
	}
	
	
	private void escapeOptions() {
		if (hitstunFrames > 0) {
			gotHit = true;
		}
		
		if (gotHit) {
			if (escapeOption == 1) {
				mashJump();
			}
			else if (escapeOption == 2) {
				mashFair();
			}
			else if (escapeOption == 3) {
				mashUpAir();
			}
			else if (escapeOption == 4) {
				mashNeutralSpecial();
			}
			
			if (hitstunFrames == 0) {
				gotHit = false;
			}
		}
		else if (escapeOption == 5) {
			if (opponentAttacking) {
				pressingShield = true;
			}
		}
	}
	
	private void normalBehaviorOptions() {
		
		if (!(escapeOption == 5 && opponentAttacking)) {
			if (behaviorOption == 1) {
				timedJump();
			}
			else if (behaviorOption == 2) {
				mashJab();
			}
			else if (behaviorOption == 3) {
				mashDash();
			}
			else if (behaviorOption == 4) {
				mashUpTilt();
			}
		}
	}
	

	

	protected void getInput() {
		
		checkState();
		
		pressingJump = false;
		pressingAttack = false;
		pressingSpecial = false;
		pressingUp = false;
		pressingShield = false;
		pressingLeft = false;
		pressingRight = false;
		
		if (combos.isComboing()) {
			combos.tick();
		}
		
		if (game.getKeyManager(playerNumb).jump) {
			combos.startCombo(1);
		}
		
		
		pressingJump = game.getKeyManager(playerNumb).jump;
		pressingAttack = game.getKeyManager(playerNumb).attack;
		pressingSpecial = game.getKeyManager(playerNumb).special;
		pressingUp = game.getKeyManager(playerNumb).up;
		pressingShield = game.getKeyManager(playerNumb).shield;
		pressingLeft = game.getKeyManager(playerNumb).left;
		pressingRight = game.getKeyManager(playerNumb).right;
		

			
		if (escapeOption > 0) {
			escapeOptions();
		}
		if (!gotHit) {
			if (behaviorOption > 0) {
				normalBehaviorOptions();
			}
		}


		
	}
	
	public void setBehaviorOption(int option) {
		this.behaviorOption = option;
	}
	
	public void setEscapeOption(int option) {
		this.escapeOption = option;
	}
	
	
}

