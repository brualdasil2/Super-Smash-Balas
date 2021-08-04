
public class TrainingBot extends Player {
	
	private int state, rand, frameCounter = 0, escapeOption = 0, behaviorOption = 0;
	private boolean opponentNear, opponentOnAir, opponentOnTop, opponentOnLeft, opponentOnRight, opponentAttacking, opponentShielding, opponentCandyComing,
					onCenter, gotHit = false;
	
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
	
	private void pressNothing() {
		
		pressingJump = false;
		pressingAttack = false;
		pressingSpecial = false;
		pressingUp = false;
		pressingShield = false;
		pressingLeft = false;
		pressingRight = false;
	}
	
	private void setState(int state) {
		
		if (this.state != state) {			
			this.state = state;
			frameCounter = 0;
		}
	}
	
	private void setFrames(int frames) {
		
		if (frameCounter == 0)
			frameCounter = frames;
		
		frameCounter--;
	}
	
	private void randomize(int max) {
		
		if (frameCounter == 0)
			rand = (int)(1 + Math.random()*max);
	}
	
	private void slowShield() {
		
		setFrames(40);
		
		if (frameCounter < 26) {
			
			pressingShield = true;
		}
		
		
	}
	
	private void mashJump() {
		
		pressingJump = true;
	}
	
	private void mashShield() {
		
		
		pressingShield = true;
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
	
	
	
	
	
	
	
	private void stand() {
		
		setFrames(30);
	}
	
	private void dashAway() {
		
		setFrames(20);
		
		if (opponentOnLeft)
			pressingRight = true;
		if (opponentOnRight)
			pressingLeft = true;
	}
	
	private void dashRight() {
		
		setFrames(20);
		pressingRight = true;	
	}
	
	private void dashLeft() {
		
		setFrames(20);
		pressingLeft = true;
	}
	
	private void goToCenter() {
		
		setFrames(30);
		
		if (x + currentFrame.getWidth()/2 > 640) {
			
			pressingLeft = true;
		}
		
		if (x + currentFrame.getWidth()/2 < 640) {
			
			pressingRight = true;
		}
	}
	
	private void goToOpponent() {
		
		setFrames(60);
		
		if (opponentOnLeft) {
			
			pressingLeft = true;
		}
		
		if (opponentOnRight) {
			
			pressingRight = true;
		}
	}
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			pressingLeft = true;	
		if (opponentOnRight)
			pressingRight = true;
	}
	
	private void turnAway() {
		
		if (opponentOnLeft)
			pressingRight = true;	
		if (opponentOnRight)
			pressingLeft = true;
	}
	
	
	private void jab() {
		
		setFrames(4);
		
		if (frameCounter == 3) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
			
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void dashAttack() {
		
		setFrames(3);
		
		if (frameCounter == 2) {
			turnToOpponent();
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void upTilt() {
		
		setFrames(4);
		
		if (frameCounter == 3) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
			pressingUp = true;
			pressingAttack = true;
		}
		
		if (frameCounter == 0) {
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
		
	}
	
	private void jumpFair() {
		
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 8) {
			
			pressingJump = true;
			turnToOpponent();
		}
		
		if (frameCounter == 7) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 6) {
			
			turnToOpponent();
		}
		
		if (frameCounter == 2) {
		
			if (defended)
				defended = false;
			if (parried)
				parried = false;
		}
	}
	
	private void jumpBair() {
		
		setFrames(20);
		
		if (frameCounter == 19) {
			
			turnAway();
		}
		
		if (frameCounter == 18) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 17) {
			
			pressingAttack = true;
			turnToOpponent();
		}
		
		if (frameCounter <= 16) {
			
			turnToOpponent();
		}
	}
	
	private void jumpUpAir() {
		
		setFrames(2);
		
		if (frameCounter == 1) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 0) {
			
			pressingUp = true;
			pressingAttack = true;
		}
	}
	
	private void sideSpecial() {
		
		turnToOpponent();
		pressingSpecial = true;
	}
	
	private void jumpSideSpecial() {
		
		setFrames(10);
		
		if (frameCounter == 9) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 0) {
			
			turnToOpponent();
			pressingSpecial = true;
		}
	}
	
	private void upSpecial() {
		
		setFrames(30);
		
		if (frameCounter == 29) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	
	private void jumpUpSpecial() {
		
		setFrames(30);
		
		if (frameCounter == 29) {
			
			pressingJump = true;
		}
		
		if (frameCounter == 20) {
			
			pressingUp = true;
			pressingSpecial = true;
		}
	}
	
	private void neutralSpecial() {
		
		pressingSpecial = true;
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

