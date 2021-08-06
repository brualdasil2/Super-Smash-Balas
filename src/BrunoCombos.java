
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
	
	public void tick() {
		
		frameCounter++;
		
		checkState();
		
		switch(combo) {
			case 1:
				risingFairCombo();
				break;
			default:
				endCombo();
		}
		
	}
	
	public boolean isComboing() {
		return comboing;
	}
} 
