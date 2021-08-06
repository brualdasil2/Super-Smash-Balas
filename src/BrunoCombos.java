
public class BrunoCombos {
	
	private Player player;
	private boolean comboing, opponentOnRight = false, opponentOnLeft = false, droppingShield = false;
	private int frameCounter = 0, combo = 0;
	
	public BrunoCombos(Player player) {
		this.player = player;
		this.comboing = false;
	}
	
	private void checkState() {
		droppingShield = player.shieldStun;
		
		opponentOnLeft = (player.opponent.x - player.x < 0);
		opponentOnRight = (player.opponent.x - player.x > 0);
	}
	
	private void endCombo() {
		comboing = false;
		frameCounter = 0;
		combo = 0;
	}
	
	public void startCombo(int combo) {
		comboing = true;
		this.combo = combo;
	}
	
	private void dropShield() {
		if (frameCounter >= 17) {
			frameCounter = 0;
		}
	}
	
	private void turnToOpponent() {
		
		if (opponentOnLeft)
			player.pressingLeft = true;	
		if (opponentOnRight)
			player.pressingRight = true;
	}
	
	private void risingFairCombo() {
		
		if (droppingShield) {
			dropShield();
		}
		else {
			
			if (frameCounter <= 2) {
				player.pressingJump = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 10) {
				turnToOpponent();
			}
			else if (frameCounter <= 33) {
				if (player.opponent.getHitstunFrames() == 0) {
					endCombo();
				}
				
				player.pressingJump = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 60) {
				turnToOpponent();
				player.pressingShield = true;
			}
			else if (frameCounter <= 66) {
				player.pressingJump = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 74) {
				turnToOpponent();
			}
			else if (frameCounter <= 97) {
				player.pressingJump = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 120) {
				turnToOpponent();
				player.pressingShield = true;
			}
			else {
				endCombo();
			}
		}
	}
	
	private void risingFairUairCombo() {
		
		//System.out.println(frameCounter);
		
		if (droppingShield) {
			dropShield();
		}
		else {
			
			if (frameCounter <= 2) {
				player.pressingJump = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 10) {
				turnToOpponent();
			}
			else if (frameCounter <= 33) {
				if (player.opponent.getHitstunFrames() == 0) {
					endCombo();
				}
				
				player.pressingJump = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 50) {
				turnToOpponent();
			}
			else if (frameCounter <= 60) {
				player.pressingUp = true;
				player.pressingAttack = true;
				turnToOpponent();
			}
			else if (frameCounter <= 65) {
				player.pressingShield = true;
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
	}
	
	public void tick() {
		
		frameCounter++;
		
		checkState();
		
		switch(combo) {
			case 1:
				risingFairCombo();
				break;
			case 2:
				risingFairUairCombo();
				break;
			default:
				endCombo();
		}
		
	}
	
	public boolean isComboing() {
		return comboing;
	}
} 
