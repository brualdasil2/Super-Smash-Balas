
public class CarolCombos {
	
	private Player player;
	private boolean comboing, superCarol = false, opponentOnRight = false, opponentOnLeft = false, droppingShield = false, opponentHoldingAway;
	private int frameCounter = 0, combo = 0;
	private double centerX, distToFrontWall, distToBackWall;
	
	public CarolCombos(Player player) {
		this.player = player;
		this.comboing = false;
	}
	
	private void checkState() {
		droppingShield = player.shieldStun;
		centerX = player.x + 100;
		distToFrontWall = player.getLookDirection() == 0 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		distToBackWall = player.getLookDirection() == 1 ? Math.abs(centerX - GameState.leftWall) : Math.abs(centerX - GameState.rightWall);
		
		opponentOnLeft = (player.opponent.x - player.x < 0);
		opponentOnRight = (player.opponent.x - player.x > 0);
		opponentHoldingAway = ((player.lookDirection == 0 && player.opponent.pressingRight) || player.lookDirection == 1 && player.opponent.pressingLeft);
		
		superCarol = player.character.airSpeed == 12;
	}
	
	private void selectCombo() {
		switch(combo) {
			case 1:
				risingFair();
				break;
			case 2:
				singleJumpFallingFair(false);
				break;
			case 3:
				superRisingFairKill();
				break;
			case 4:
				normalRisingFairExtension();
				break;
			case 5:
				risingBair();
				break;
			case 6:
				singleJumpFallingFair(true);
				break;
			case 7:
				superNoteToDeath();
				break;
			default:
				endCombo();
		}
	}
	
	private void endCombo() {
		comboing = false;
		frameCounter = 0;
		combo = 0;
		player.defended = false;
		player.parried = false;
	}
	
	public void startCombo(int combo) {
		comboing = true;
		this.combo = combo;
		selectCombo();
	}
	
	private boolean waitLag() {
		if (player.freezeFrames <= 1) {
			return false;
		}
		if (frameCounter <= 5)
			frameCounter = 0;
		return true;
	}
	
	private void turnAwayFromOpponent() {
		
		if (opponentOnLeft)
			player.pressingRight = true;	
		if (opponentOnRight)
			player.pressingLeft = true;
	}
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			player.pressingLeft = true;	
		if (opponentOnRight)
			player.pressingRight = true;
	}
	
	private void superRisingFairKill() {
		if (player.opponent.getHitstunFrames() == 0) {
			endCombo();
		}
		if (distToFrontWall > 150)
			turnToOpponent();
		if (frameCounter <= 21) {
			player.pressingShield = true;
		}
		else if (frameCounter <= 36) {
			player.pressingJump = true;
			player.pressingAttack = true;
		}
		else if (frameCounter <= 48) {
			player.pressingShield = true;
		}
		else if (frameCounter <= 62) {
			player.pressingJump = true;
			player.pressingAttack = true;
		}
		else if (frameCounter <= 74) {
			player.pressingShield = true;
		}
		else if (frameCounter <= 89) {
			player.pressingJump = true;
			player.pressingAttack = true;
		}
		else if (frameCounter <= 101) {
			player.pressingShield = true;
		}
		else if (frameCounter <= 116) {
			player.pressingJump = true;
			player.pressingAttack = true;
		}
		else {
			endCombo();
		}
	}
	
	private void normalRisingFairExtension() {
		if (frameCounter <= 28) {
			if (player.opponent.getHitstunFrames() == 0) {
				endCombo();
			}
			
			player.pressingJump = true;
			player.pressingAttack = true;
			if (distToFrontWall > 150)
				turnToOpponent();
		}
		else if (frameCounter <= 38) {
			if (distToFrontWall > 150)
				turnToOpponent();
		}
		else if (frameCounter <= 58) {
			player.pressingUp = true;
			player.pressingAttack = true;
			if (distToFrontWall > 150)
				turnToOpponent();
		}
		else if (frameCounter <= 65) {
			player.pressingShield = true;
		}
		else {
			endCombo();
		}
	}
		
	private void risingFair() {
		if (!waitLag()) {
			if (frameCounter <= 2) {
				player.pressingJump = true;
				player.pressingAttack = true;
				if (distToFrontWall > 150)
					turnToOpponent();
			}
		}
		if (frameCounter <= 18) {
			if (distToFrontWall > 150)
				turnToOpponent();
		}
		else {
			if (superCarol) {
				startCombo(3); //super kill
			}
			else {
				startCombo(4); //normal rf
			}
		}
	
		
	}
	
	private void singleJumpFallingFair(boolean delayed) {
		if (frameCounter <= 1) {
			player.pressingJump = true;
			turnToOpponent();
		}
		else if (frameCounter <= 14) {
			turnAwayFromOpponent();
		}
		else if (frameCounter <= 19) {
			turnToOpponent();
			if (!delayed)
				player.pressingAttack = true;
		}
		else if (frameCounter <= 20) {
			turnToOpponent();
			player.pressingAttack = true;
		}
		else if (frameCounter <= 32) {
			turnToOpponent();
			player.pressingShield = true;
		}
		else if (superCarol) {
			if (player.opponent.getHitstunFrames() == 0) {
				endCombo();
			}
			if (frameCounter <= 42) {
				turnToOpponent();
				player.pressingAttack = true;
				player.pressingJump = true;
			}
			else if (frameCounter <= 76) {
				turnToOpponent();
				player.pressingAttack = true;
			}
			else {
				frameCounter = 1;
				startCombo(1);	
			}
			
		}
		else if (frameCounter <= 42) {
			if (player.opponent.getHitstunFrames() == 0) {
				endCombo();
			}
			turnToOpponent();
			player.pressingSpecial = true;
		}
		else {
			if (distToFrontWall <= 300) {
				if (frameCounter <= 60) {
					turnToOpponent();
					player.pressingSpecial = true;
				}
				else {
					frameCounter = 1;
					startCombo(1);
					
				}
			}
			else {
				endCombo();
			}	
		}
	}
	
	private void risingBair() {
		if (waitLag())
			return;
		if (frameCounter <= 1) {
			turnAwayFromOpponent();
			player.pressingJump = true;
		}
		else if (frameCounter <= 2) {
			turnToOpponent();
			player.pressingAttack = true;
		}
		else if (frameCounter <= 15) {
			if (distToBackWall >= 200)
				turnToOpponent();
			else
				turnAwayFromOpponent();
		}
		else if (frameCounter <= 20) {
			if (distToBackWall > 400) {
				endCombo();
			}
			if (distToBackWall >= 200)
				turnToOpponent();
			else
				turnAwayFromOpponent();
		}
		else if (frameCounter <= 70) {

			turnToOpponent();
			player.pressingSpecial = true;
		}
		else {
			frameCounter = 1;
			startCombo(1); //rf
		}
		
		
		
	}
	
	private void superNoteToDeath() {
		System.out.println(frameCounter);
		if (waitLag())
			return;
		if (frameCounter <= 18) {
			turnToOpponent();
			player.pressingSpecial = true;
		}
		else {
			if (frameCounter <= 28) {
				turnToOpponent();
				player.pressingAttack = true;
				player.pressingJump = true;
			}
			else if (frameCounter <= 62) {
				turnToOpponent();
				player.pressingAttack = true;
			}
			else {
				frameCounter = 1;
				startCombo(1);	
			}
		}
	}
	
	public void tick() {
		
		frameCounter++;
		
		checkState();
		
		selectCombo();
		
		
		
	}
	
	public boolean isComboing() {
		checkState();
		//System.out.println(player.opponent.getY());
		return comboing;
	}
} 
