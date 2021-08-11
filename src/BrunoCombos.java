
public class BrunoCombos {
	
	private Player player;
	private boolean comboing, opponentOnRight = false, opponentOnLeft = false, droppingShield = false, opponentHoldingAway;
	private int frameCounter = 0, combo = 0;
	private double centerX, distToFrontWall, distToBackWall;
	
	public BrunoCombos(Player player) {
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
	}
	
	private void selectCombo() {
		switch(combo) {
			case 1:
				risingFair();
				break;
			case 2:
				ffDoubleUpAirFinisher();
				break;
			case 3:
				doubleFairExtension();
				break;
			case 4:
				fallingUpAirFinisher();
				break;
			case 5:
				upBFinisher();
				break;
			case 6:
				risingBair();
				break;
			case 7:
				fallingFair();
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
	
	private void fallingUpAirFinisher() {
		if (frameCounter <= 123) {
			turnToOpponent();
			player.pressingAttack = true;
			player.pressingUp = true;
		}
		else {
			endCombo();
		}
	}
	
	private void risingBair() {

		player.pressingShield = false;
		
		if (frameCounter <= 2) {
			turnAwayFromOpponent();
			player.pressingJump = true;
		}
		else if (frameCounter == 3) {
			turnToOpponent();
			player.pressingAttack = true;
		}
		else if (frameCounter <= 15) {
			turnToOpponent();
			player.pressingShield = true;
		}
		else if (frameCounter <= 30) {
			if (opponentHoldingAway)
				turnToOpponent();
			player.pressingShield = true;
		}
		else if (distToBackWall > 400) {
			if (player.opponent.getHitstunFrames() == 0) {
				endCombo();
				return;
			}
			if (frameCounter <= 50) {
				turnToOpponent();
				player.pressingAttack = true;
			}
			else
				endCombo();
		}
		else {
			if (player.opponent.getHitstunFrames() == 0) {
				endCombo();
				return;
			}
			frameCounter = 55;
			startCombo(3);
		}
		
 	}
	
	private void upBFinisher() {
		if (player.opponent.getHitstunFrames() == 0) {
			endCombo();
		}
		if (frameCounter <= 120) {
			if (distToFrontWall > 100)
				turnToOpponent();
			else {
				player.pressingUp = true;
				if (player.getMagic() >= 4)
					player.pressingSpecial = true;
				else
					player.pressingAttack = true;
			}
				
		}
		else if (frameCounter <= 130) {
			player.pressingUp = true;
			if (player.getMagic() >= 4)
				player.pressingSpecial = true;
			else
				player.pressingAttack = true;
		}
		else {
			endCombo();
		}
	}
	
	private void doubleFairExtension() {
		if (player.opponent.getHitstunFrames() == 0) {
			endCombo();
		}
		
		if (frameCounter <= 60) {
			if (distToFrontWall > 120) {
				turnToOpponent();
				player.pressingShield = true;
			}
			else {
				startCombo(5); //upBFinisher
				frameCounter = 98;
			}
		}
		else if (frameCounter <= 66) {
			player.pressingJump = true;
			player.pressingAttack = true;
			if (distToFrontWall > 120)
				turnToOpponent();
			else {
				startCombo(5); //upBFinisher
				frameCounter = 98;
			}
			
		}
		else if (frameCounter <= 74) {
			if (distToFrontWall > 120)
				turnToOpponent();
		}
		else if (frameCounter <= 97) {
			player.pressingJump = true;
			player.pressingAttack = true;
			if (distToFrontWall > 120)
				turnToOpponent();
		}
		else {
			if (distToFrontWall > 146) {
				startCombo(4); //fallingUpAirFinisher
			}
			else if (distToFrontWall > 0) {
				startCombo(5); //upBFinisher
			}
		}
	}
	
	private void ffDoubleUpAirFinisher() {
		if (player.opponent.getHitstunFrames() == 0) {
			endCombo();
		}
		
		if (frameCounter <= 50) {
			turnToOpponent();
		}
		else if (frameCounter <= 60) {
			player.pressingUp = true;
			player.pressingAttack = true;
			turnToOpponent();
		}
		else if (frameCounter <= 65) {
			if (player.opponent.getY() > 210)
				player.pressingShield = true;
			else 
				endCombo();
			turnToOpponent();
		}
		else if (frameCounter <= 77) {
			turnToOpponent();
			player.pressingJump = true;
		}
		else if (frameCounter <= 79) {
			turnToOpponent();
		}
		else if (frameCounter <= 82) {
			player.pressingAttack = true;
			player.pressingJump = true;
			player.pressingUp = true;
		}
		else if (frameCounter <= 100) {
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
				if (distToFrontWall > 100)
					turnToOpponent();
			}
			else if (frameCounter <= 10) {
				if (distToFrontWall > 100)
					turnToOpponent();
			}
			else if (frameCounter <= 33) {
				if (player.opponent.getHitstunFrames() == 0) {
					endCombo();
				}
				
				player.pressingJump = true;
				player.pressingAttack = true;
				if (distToFrontWall > 100)
					turnToOpponent();
			}
			else {
				if (distToFrontWall > 450 && !(player.opponent.character instanceof Carol)) {
					
					startCombo(2); //ffDoubleUpAirFinisher
				}
				else {
					startCombo(3); //doubleFairExtension
				}
			}
		}
	}
	
	private void fallingFair() {
		if (frameCounter == 1) {
			player.pressingJump = true;
			turnToOpponent();
		}
		else if (frameCounter <= 19) {
			turnToOpponent();
		}
		else if (frameCounter == 20) {
			player.pressingShield = true;
			turnToOpponent();
		}
		else if (frameCounter <= 23) {
			turnToOpponent();
		}
		else if (frameCounter == 24) {
			player.pressingAttack = true;
			turnToOpponent();
		}
		else if (frameCounter <= 37) {
			turnToOpponent();
		}
		else {
			if (player.opponent.getHitstunFrames() == 0) {
				endCombo();
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
