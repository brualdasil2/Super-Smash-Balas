import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class TargetState extends State {

	private Player player;
	private boolean fighting;
	private int countdownTimer;
	private Button menuButton, resumeButton, endMenuButton, retryButton, restartButton;
	private boolean paused;
	private boolean pausePressed;
	private Target target;
	public static HitEffect hitEffect = new HitEffect(Assets.hitEffect);
	private boolean hitEffectActive = false;
	private static int score;
	private static int time;
	private boolean mapRendered;
	private int playerChar, playAs;
	
	public TargetState(Game game) {
		super(game);
		
	}

	public void init(int playerChar, int playAs) {
		
		this.playerChar = playerChar;
		this.playAs = playAs;
		
		if (playAs == 1) {
			
			if (playerChar == 1)
				player = new Player (game, 1, new Bruno(0), 540, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 2)
				player = new Player (game, 1, new Carol(0), 540, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 3)
				player = new Player (game, 1, new Lacerda(0), 540, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 4)
				player = new Player (game, 1, new Obino(0), 540, GameState.floorY - 200, "JOGADOR");
		}
		else if (playAs == 2) {
			
			if (playerChar == 1)
				player = new Player (game, 2, new Bruno(1), 540, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 2)
				player = new Player (game, 2, new Carol(1), 540, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 3)
				player = new Player (game, 2, new Lacerda(1), 540, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 4)
				player = new Player (game, 2, new Obino(1), 540, GameState.floorY - 200, "JOGADOR");
		}
		
		player.setOpponent(null);
		target = new Target(603, 323, player);
		
		resumeButton = new Button(game, 540, 300, 200, 50, Color.darkGray, "SEGUIR JOGANDO", Assets.font20, null, true);
		menuButton = new Button(game, 540, 440, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
		endMenuButton = new Button(game, 430, 520, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
		retryButton = new Button(game, 650, 520, 200, 50, Color.darkGray, "TENTAR NOVAMENTE", Assets.font17, null, true);
		restartButton = new Button(game, 540, 370, 200, 50, Color.darkGray, "RECOMEÇAR", Assets.font20, null, true);
		
		paused = false;
		pausePressed = false;
		fighting = false;
		score = 0;
		time = 3600;
		countdownTimer = 0;
		mapRendered = false;
		hitEffectActive = false;
		hitEffect.resetFrameCounter();
	}
	
	
	@Override
	public void tick() {
		
		if (fighting) {
			
			if (game.getKeyManager(1).pause) {
				
				if (!pausePressed) {
					
					pausePressed = true;
					
					if (!paused) {
						
						paused = true;
						GameState.screenRefreshManager.reset();
					}
					else {
						
						paused = false;
						GameState.screenRefreshManager.reset();
					}
				}
			}
			else {
				
				pausePressed = false;
			}
			
			if (paused) {
				
				GameState.screenRefreshManager.reset();
				
				if (resumeButton.buttonPressed()) {
					
					paused = false;
					
				}
				
				if (menuButton.buttonPressed()) {
					
					hitEffectActive = false;
					hitEffect.resetFrameCounter();
					countdownTimer = 0;
					fighting = false;
					State.setState(game.getMenuState());
					((MenuState)(game.getMenuState())).init();
				}
				
				if (restartButton.buttonPressed()) {
					
					GameState.projectiles.clear();
					init(playerChar, playAs);
				}
			}
			else {
				
				GameState.screenRefreshManager.setChange(290, 20, 310, 70);
				
				player.measureCollision();
				player.getInput();
				player.tick();
				
				for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
					
					GameState.projectiles.get(i).tick();
				}
				
				target.tick();
				
				if (hitEffect.getFrameCounter() > 0) {
					
					hitEffect.decreaseFrameCounter();
					hitEffectActive = true;
					
					if (hitEffect.getFrameCounter() == 0) {
						
						GameState.screenRefreshManager.setChange(hitEffect.getX(), hitEffect.getY(), hitEffect.getWidth(), hitEffect.getHeight());
						hitEffectActive = false;
					}
					
				}
				
				else {
					hitEffectActive = false;
				}
				
				time--;
				GameState.screenRefreshManager.setChange(600, 0, 80, 80);
				
				if (time == 0) {
					
					fighting = false;
				}
			}
		
		}
		else {
			
			GameState.screenRefreshManager.setChange(490, 210, 300, 300);
			
			if (countdownTimer < 210) {
				
				countdownTimer++;
				if (countdownTimer == 210) {
					
					fighting = true;
				}
			}
			
			else if (countdownTimer >= 210) {
				
				if (endMenuButton.buttonPressed()) {
					
					GameState.projectiles.clear();
					hitEffectActive = false;
					hitEffect.resetFrameCounter();
					countdownTimer = 0;
					fighting = false;
					State.setState(game.getMenuState());
					((MenuState)(game.getMenuState())).init();
				}
				
				if (retryButton.buttonPressed()) {
					
					GameState.projectiles.clear();
					init(playerChar, playAs);
				}
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		
		
		if (!mapRendered) {
			
			g.clearRect(0, 0, 1280, 720);
			GameState.screenRefreshManager.reset();
			mapRendered = true;	
		}
		
		GameState.screenRefreshManager.render(g, 0);
		
		if (fighting)
			target.render(g);
		
		g.setColor(Color.black);
		g.fillRect(0, GameState.floorY, game.getDisplay().getWidth(), GameState.floorHeight);
		
		player.render(g, false);
		
		if (!GameState.projectiles.isEmpty()) {
			
			for (Projectile projectile : GameState.projectiles) {
				
				projectile.render(g, false);
			}
		}
		
	
		
		if (hitEffectActive) {
			
			g.drawImage(hitEffect.getImage(), hitEffect.getX(), hitEffect.getY(), hitEffect.getWidth(), hitEffect.getHeight(), null);
		}
		
		g.setColor(Color.green);
		g.fillRect(390 + (200 - 2*player.getShield()), 20, 2*player.getShield(), 20);
		
		g.setColor(Color.decode("2799606"));
		g.fillRect(490 + (100 - 10*player.getMagic()), 45, 10*player.getMagic(), 20);
		
		g.setColor(Color.black);
		g.drawRect(390, 20, 200, 20);
		g.drawRect(490, 45, 100, 20);
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(490 + x, 45, 490 + x, 65);
		}
		
		Text.drawString(g, player.getName(), 590 - g.getFontMetrics(Assets.font15).stringWidth("JOGADOR"), 15, false, Color.black, Assets.font15);

		Text.drawString(g, "PONTOS", 1210, 20, true, Color.black, Assets.font10);
		Text.drawString(g, String.valueOf(score), 1210, 50, true, Color.black, Assets.font30);
		Text.drawString(g, "TEMPO", 640, 20, true, Color.black, Assets.font10);
		Text.drawString(g, String.valueOf(time/60), 640, 50, true, Color.black, Assets.font30);
		
		if (paused) {
			
			g.setColor(new Color(0, 0, 0, 100));
			g.fillRect(0, 0, 1280, 720);
			Text.drawString(g, "JOGO PAUSADO", 640, 200, true, Color.white, Assets.font30);
			
			resumeButton.drawButton(g);
			menuButton.drawButton(g);
			restartButton.drawButton(g);
		}
		
		if (!fighting) {
			
			if (countdownTimer < 60) {
				
				g.drawImage(Assets.countdown[0], 540, 260, 200, 200, null);
			}
			
			else if (countdownTimer >= 60 && countdownTimer < 120) {
				
				g.drawImage(Assets.countdown[1], 540, 260, 200, 200, null);
			}
			
			else if (countdownTimer >= 120 && countdownTimer < 180) {
				
				g.drawImage(Assets.countdown[2], 540, 260, 200, 200, null);
			}
			
			else if (countdownTimer < 210) {
				
				g.drawImage(Assets.fight, 490, 210, 300, 300, null);
			}
			
			else if (countdownTimer >= 210) {
				
				g.drawImage(Assets.fim, 490, 190, 300, 300, null);
				Text.drawString(g, "Pontos: " + score, 640, 460, true, Color.black, Assets.font30);
				endMenuButton.drawButton(g);
				retryButton.drawButton(g);
			}
		}
		
		
	
	}
	
	public static void increaseScore() {
		
		score++;
	}

}
