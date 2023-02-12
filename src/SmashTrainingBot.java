
public class SmashTrainingBot extends SmashPlayer {
	
	private int state, rand, frameCounter = 0, escapeOption = 0, behaviorOption = 0, mashShieldAfterCounter = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter, gotHit = false;
	
	private int hitsToEscape = 1, hitsToEscapeCounter = 0, resetHitsEscapeCounter = 0;
	int prevComboCounter = 0;
	
	//private LacerdaCombos combos = new LacerdaCombos(this);
	
	public SmashTrainingBot(Game game, int playerNumb, Character character, double x, double y) {
		
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
	
	private void ijadFair() {
		setFrames(90);
	
		if (frameCounter == 29) {
			pressingJump = true;
			turnToOpponent();
		}
		else if (frameCounter == 28) {
			pressingAirdash = true;
			turnToOpponent();
			pressingAttack = true;
		}
	}
	private void ijadUpair() {
		setFrames(90);
	
		if (frameCounter == 29) {
			pressingJump = true;
			turnToOpponent();
		}
		else if (frameCounter == 28) {
			pressingAirdash = true;
			turnToOpponent();
			pressingAttack = true;
			pressingUp = true;
		}
	}
	
	private void mashAdRight() {
		pressingRight = true;
		pressingAirdash = true;
	}
	private void mashAdLeft() {
		pressingLeft = true;
		pressingAirdash = true;
	}
	private void mashAdUp() {
		pressingUp = true;
		pressingAirdash = true;
	}
	private void mashAdDown() {
		pressingShield = true;
		pressingAirdash = true;
	}
	
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			pressingLeft = true;	
		if (opponentOnRight)
			pressingRight = true;
	}
	
	
	private void escapeOptions() {
		int comboCounter = ((GameState)(game.getGameState())).comboCounter.getCount();
		if (hitstunFrames > 0) {
			if (!gotHit || comboCounter > prevComboCounter) {
				hitsToEscapeCounter++;
			}
			gotHit = true;
		}
		if (mashShieldAfterCounter > 0) {
			mashShieldAfterCounter--;
		}
		if (hitstunFrames == 0) {
			resetHitsEscapeCounter++;
			if (resetHitsEscapeCounter == 30) {
				hitsToEscapeCounter = 0;
				resetHitsEscapeCounter = 0;
			}
		}

		
		prevComboCounter = comboCounter;
		if (gotHit) {
			if (hitsToEscapeCounter >= hitsToEscape) {
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
				else if (escapeOption == 6) {
					mashAdRight();
				}
				else if (escapeOption == 7) {
					mashAdLeft();
				}
				else if (escapeOption == 8) {
					mashAdUp();
				}
				else if (escapeOption == 9) {
					mashAdDown();
				}
			}
			
			if (hitstunFrames == 0) {
				gotHit = false;
				mashShieldAfterCounter = 20;
				if (hitsToEscapeCounter == hitsToEscape) {
					hitsToEscapeCounter = 0;
				}
			}
		}
		else if (escapeOption == 5) {
			if (opponentAttacking) {
				pressingShield = true;
			}
		}
		else if (escapeOption == 9) {
			if (mashShieldAfterCounter > 0) {
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
			else if (behaviorOption == 5) {
				ijadFair();
			}
			else if (behaviorOption == 6) {
				ijadUpair();
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
	
		
		
		pressingJump = game.getKeyManager(playerNumb).jump;
		pressingAttack = game.getKeyManager(playerNumb).attack;
		pressingSpecial = game.getKeyManager(playerNumb).special;
		pressingUp = game.getKeyManager(playerNumb).up;
		pressingShield = game.getKeyManager(playerNumb).shield;
		pressingLeft = game.getKeyManager(playerNumb).left;
		pressingRight = game.getKeyManager(playerNumb).right;
		pressingAirdash = game.getKeyManager(playerNumb).airdash;
		

			
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
	
	public void setHitsToEscape(int hits) {
		this.hitsToEscape = hits;
	}
	
	
}

