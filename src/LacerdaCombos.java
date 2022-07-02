
public class LacerdaCombos {
	
	private Player player;
	private boolean comboing, opponentOnRight = false, opponentOnLeft = false, droppingShield = false, opponentHoldingAway;
	private int frameCounter = 0, combo = 0;
	private double centerX, distToFrontWall, distToBackWall;
	
	public LacerdaCombos(Player player) {
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
				jab();
				break;
			case 2:
				doubleFairUpAir();
				break;
			case 3:
				dashAttack();
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
	
	private void doubleFairUpAir() {
		System.out.println(frameCounter);
		if (frameCounter <= 3) {
			turnToOpponent();
			player.pressingAttack = true;
			player.pressingJump = true;
		}
		else if (frameCounter <= 17) {
			turnToOpponent();
		}
		else if (frameCounter <= 40) {
			turnToOpponent();
			player.pressingAttack = true;
			player.pressingJump = true;
		}
		else if (frameCounter <= 55) {
			player.pressingShield = true;
			if (!(player.opponent.character instanceof Lacerda)) {
				turnToOpponent();
			}
		}
		else if (frameCounter <= 60) {
			turnToOpponent();
		}
		else if (frameCounter <= 80) {
			turnToOpponent();
			player.pressingAttack = true;
			player.pressingJump = true;
			player.pressingUp = true;
		}
		else {
			endCombo();
		}
		
	}
	
	private void jab() {
		if (waitLag())
			return;
		if (frameCounter <= 1) {
			turnToOpponent();
		}
		else if (frameCounter <= 10) {
			player.pressingAttack = true;
		}
		else if (frameCounter <= 27) {
			player.pressingAttack = false;
		}
		else {
			frameCounter = 0;
			startCombo(2); //double fair upair
		}
	}
	
	private void dashAttack() {
		if (waitLag())
			return;
		if (frameCounter <= 36) {
			turnToOpponent();
			player.pressingAttack = true;
		}
		else {
			frameCounter = 1;
			startCombo(2); //double fair up air
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
