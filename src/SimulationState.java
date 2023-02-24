
public class SimulationState {
	private Game game;
	private SmashPlayer player1, player2;
	private int winner;
	private int p1DamageDealt, p2DamageDealt, p1CenterTicks, p2CenterTicks, p1DamageOnCombo, p2DamageOnCombo, p1DamageOnPunish, p2DamageOnPunish, p1DamageShielded, p2DamageShielded;

	private int maxScore = 4;
	private MagicBall magicBall;
	private boolean fighting;
	
	public SimulationState(Game game) {
		this.game = game;
	}
	
	public void init(SmashPlayer player1, SmashPlayer player2) {
		((GameState)(game.getGameState())).initForSimulator();
		this.player1 = player1;
		this.player2 = player2;
		player1.setOpponent(player2);
		player2.setOpponent(player1);
		magicBall = new MagicBall();
		fighting = true;
		winner = 0;
		p1DamageDealt = 0;
		p2DamageDealt = 0;
		p1CenterTicks = 0;
		p2CenterTicks = 0;
		p1DamageShielded = 0;
		p2DamageShielded = 0;
		p1DamageOnPunish = 0;
		p2DamageOnPunish = 0;
		p1DamageOnCombo = 0;
		p2DamageOnCombo = 0;
	}
	
	public int distanceToCenter(SmashPlayer p) {
		return Math.abs((int)((p.x + p.currentAttack.getCollisionbox().getX() + p.currentAttack.getCollisionbox().getWidth()/2) - 640));
	}
	
	public void tick() {
		player1.measureCollision();
		player2.measureCollision();
		player1.getInput();
		player2.getInput();
		player1.tick();
		player2.tick();
		magicBall.tick(player1, player2);
		for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
			GameState.projectiles.get(i).tick();
		}
		player1.hitDetection();
		player1.projectileHitDetection();
		player2.hitDetection();
		player2.projectileHitDetection();
		if (player1.getHealth() <= 0 && player2.getHealth() <= 0 && player1.score == maxScore-1 && player2.score == maxScore-1) {		
			fighting = false;
			winner = -1;			
		}
		else {
			if (player1.getHealth() <= 0) {
				player1.restoreRound();
				player2.increaseScore();
			}
			if (player2.getHealth() <= 0) {
				player2.restoreRound();
				player1.increaseScore();
			}
			if (player1.getScore() == maxScore) {
				winner = 1;
				fighting = false;
			}
			else if (player2.getScore() == maxScore) {
				winner = 2;
				fighting = false;
			}
			
			if (distanceToCenter(player1) < distanceToCenter(player2)) {
				p1CenterTicks++;
			}
			else if (distanceToCenter(player1) > distanceToCenter(player2)) {
				p2CenterTicks++;
			}
		}
	}
	
	public int getWinner() {
		return winner;
	}
	public int getP1DamageDealt() {
		return player1.getDamageDealt();
	}
	public int getP2DamageDealt() {
		return player2.getDamageDealt();
	}
	public int getP1CenterTicks() {
		return p1CenterTicks;
	}
	public int getP2CenterTicks() {
		return p2CenterTicks;
	}
	public int getP1DamageOnCombo() {
		return player1.getDamageOnCombo();
	}

	public int getP2DamageOnCombo() {
		return player2.getDamageOnCombo();
	}

	public int getP1DamageOnPunish() {
		return player1.getDamageOnPunish();
	}

	public int getP2DamageOnPunish() {
		return player2.getDamageOnPunish();
	}

	public int getP1DamageShielded() {
		return player1.getDamageShielded();
	}

	public int getP2DamageShielded() {
		return player2.getDamageShielded();
	}
	public boolean isFighting() {
		return fighting;
	}
}
