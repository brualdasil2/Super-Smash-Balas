
public class SimulationState {
	private Game game;
	private SmashPlayer player1, player2;
	private int winner;
	private int p1DamageDealt, p2DamageDealt;
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
				p2DamageDealt += player1.percent;
				player1.restoreRound();
				player2.increaseScore();
			}
			if (player2.getHealth() <= 0) {
				p1DamageDealt += player2.percent;
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
		}
	}
	
	public int getWinner() {
		return winner;
	}
	public int getP1DamageDealt() {
		return p1DamageDealt;
	}
	public int getP2DamageDealt() {
		return p2DamageDealt;
	}
	public boolean isFighting() {
		return fighting;
	}
}
