
public class BrunoCombos {
	
	private Player player;
	private boolean comboing, opponentOnRight = false, opponentOnLeft = false, droppingShield = false;
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
		if (frameCounter <= 50) {
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
	
	private void risingFair() {
		
		if (droppingShield) {
			dropShield();
		}
		else {
			
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

	
	public void tick() {
		
		frameCounter++;
		
		checkState();
		
		
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
			default:
				endCombo();
		}
		
	}
	
	public boolean isComboing() {
		checkState();
		System.out.println(distToFrontWall);
		return comboing;
	}
} 
