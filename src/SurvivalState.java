import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class SurvivalState extends State {
	
	private Player player, bot;
	private boolean fighting;
	private int countdownTimer = 0;
	private Button menuButton, resumeButton, endMenuButton, retryButton, restartButton;
	private boolean paused;
	private boolean mapRendered;
	private boolean pausePressed;
	private static int score;
	private int playerChar, playAs;
	private int respawnCounter = 120;
	private int breakCounter = 0;
	
	public SurvivalState(Game game) {
		
		super(game);
	}
	
	public void init(int playerChar, int playAs) {
		
		this.playerChar = playerChar;
		this.playAs = playAs;
		
		if (playAs == 1) {
		
			if (playerChar == 1)
				player = new Player (game, 1, new Bruno(0), 240, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 2)
				player = new Player (game, 1, new Carol(0), 240, GameState.floorY - 200, "JOGADOR");	
			else if (playerChar == 3)
				player = new Player (game, 1, new Lacerda(0), 240, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 4)
				player = new Player (game, 1, new Obino(0), 240, GameState.floorY - 200, "JOGADOR");
			
			bot = new BrunoBotEasy(game, 2, new Bruno(1), 840, GameState.floorY - 200);
		}
		else if (playAs == 2) {
			
			if (playerChar == 1)
				player = new Player (game, 2, new Bruno(1), 840, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 2)
				player = new Player (game, 2, new Carol(1), 840, GameState.floorY - 200, "JOGADOR");	
			else if (playerChar == 3)
				player = new Player (game, 2, new Lacerda(1), 840, GameState.floorY - 200, "JOGADOR");
			else if (playerChar == 4)
				player = new Player (game, 2, new Obino(1), 840, GameState.floorY - 200, "JOGADOR");
			
			bot = new BrunoBotEasy(game, 1, new Bruno(0), 240, GameState.floorY - 200);
		}
		
		resumeButton = new Button(game, 540, 300, 200, 50, Color.darkGray, "SEGUIR JOGANDO", Assets.font20, null, true);
		menuButton = new Button(game, 540, 440, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
		endMenuButton = new Button(game, 430, 520, 200, 50, Color.darkGray, "VOLTAR AO MENU", Assets.font20, null, true);
		retryButton = new Button(game, 650, 520, 200, 50, Color.darkGray, "TENTAR NOVAMENTE", Assets.font17, null, true);
		restartButton = new Button(game, 540, 370, 200, 50, Color.darkGray, "RECOMEÇAR", Assets.font20, null, true);
		
		
		player.setOpponent(bot);
		bot.setOpponent(player);
		
		paused = false;
		pausePressed = false;
		fighting = false;
		score = 0;
		countdownTimer = 0;
		respawnCounter = 120;
		breakCounter = 0;
		mapRendered = false;
		GameState.hitEffectActive = false;
		GameState.hitEffect.resetFrameCounter();
		
		bot.setSurvivalHP();
		
		GameState.magicBall = new MagicBall();
		
	}
	
	private void newBot() {
		
		respawnCounter--;
		
		if (respawnCounter == 119) {
			
			GameState.screenRefreshManager.setChange(1190, 0, 70, 80);
			score++;
			
			for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
				
				if (GameState.projectiles.get(i).getOwner() == bot) {
					
					GameState.projectiles.get(i).updateImage();
					GameState.projectiles.remove(i);
				}
			}
			
			if (score <= 2) {
			
				switch((int)(1 + Math.random()*4)) {
				
					case 1: bot = new BrunoBotEasy(game, 3 - playAs, new Bruno(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 2: bot = new CarolBotEasy(game, 3 - playAs, new Carol(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 3: bot = new LacerdaBotEasy(game, 3 - playAs, new Lacerda(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 4: bot = new ObinoBotEasy(game, 3 - playAs, new Obino(2 - playAs), 200 + (Math.random()*1080), -200); break;
				}
			}
			
			else if (score > 2 && score <= 5) {
				
				switch((int)(1 + Math.random()*4)) {
				
					case 1: bot = new BrunoBotMedium(game, 3 - playAs, new Bruno(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 2: bot = new CarolBotMedium(game, 3 - playAs, new Carol(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 3: bot = new LacerdaBotMedium(game, 3 - playAs, new Lacerda(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 4: bot = new ObinoBotMedium(game, 3 - playAs, new Obino(2 - playAs), 200 + (Math.random()*1080), -200); break;
				}
			}
			
			else if (score >= 6) {
				
				switch((int)(1 + Math.random()*4)) { 
				
					case 1: bot = new BrunoBotHard(game, 3 - playAs, new Bruno(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 2: bot = new CarolBotHard(game, 3 - playAs, new Carol(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 3: bot = new LacerdaBotHard(game, 3 - playAs, new Lacerda(2 - playAs), 200 + (Math.random()*1080), -200); break;
					case 4: bot = new ObinoBotHard(game, 3 - playAs, new Obino(2 - playAs), 200 + (Math.random()*1080), -200); break;
				}
			}
			
			bot.setOpponent(player);
			bot.setSurvivalHP();
			bot.setHistun(20);
			
			player.setOpponent(bot);
			
			if (score == 3) {
				
				player.increaseMagic(3);
				if (player.getMagic() > 10)
					player.maxMagic();
			}
			
			if (score == 6) {
				
				player.increaseMagic(5);
				if (player.getMagic() > 10)
					player.maxMagic();
				player.increaseHealth(75);
				if (player.getHealth() > 150)
					player.maxHP();
			}
		}
		
		if (respawnCounter == 0) {
			
			if ((score == 3 || score == 6) && breakCounter <= 4) {
				
				respawnCounter = 118;
				breakCounter++;
			}
			else {
				
				respawnCounter = 120;
				breakCounter = 0;
				GameState.screenRefreshManager.setChange(300, 150, 680, 500);
			}
		}
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
					
					GameState.hitEffectActive = false;
					GameState.hitEffect.resetFrameCounter();
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
				
				if (GameState.getParryFreezeCounter() == 0) {
				
					GameState.screenRefreshManager.setChange(290, 0, 700, 90);
					
					player.measureCollision();
					if (respawnCounter == 120)
						bot.measureCollision();
					player.getInput();
					if (respawnCounter == 120)
						bot.getInput();
					player.tick();
					if (respawnCounter == 120)
						bot.tick();

					
					for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
						
						GameState.projectiles.get(i).tick();
					}
					
					player.hitDetection();
					player.projectileHitDetection();
					bot.hitDetection();
					bot.projectileHitDetection();
				}
				else {
					
					GameState.decreaseParryFreezeCounter();
				}
				
				if (GameState.hitEffect.getFrameCounter() > 0) {
					
					GameState.hitEffect.decreaseFrameCounter();
					GameState.hitEffectActive = true;
					
					if (GameState.hitEffect.getFrameCounter() == 0) {
						
						GameState.screenRefreshManager.setChange(GameState.hitEffect.getX(), GameState.hitEffect.getY(), GameState.hitEffect.getWidth(), GameState.hitEffect.getHeight());
						if (respawnCounter < 120)
							GameState.screenRefreshManager.setChange(GameState.hitEffect.getX() - 48, GameState.hitEffect.getY() - 48, GameState.hitEffect.getWidth()*3, GameState.hitEffect.getHeight()*3);
						GameState.hitEffectActive = false;
					}
					
				}
				
				else {
					GameState.hitEffectActive = false;
				}
				
				GameState.screenRefreshManager.setChange(600, 0, 80, 80);
				
				
				if (bot.getHealth() <= 0 || respawnCounter < 120) {
					
					newBot();
				}
				
				
				if (player.getHealth() <= 0) {
					
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
					GameState.hitEffectActive = false;
					GameState.hitEffect.resetFrameCounter();
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
		
		g.setColor(Color.black);
		g.fillRect(0, GameState.floorY, game.getDisplay().getWidth(), GameState.floorHeight);
		
		player.render(g, false);
		
		if (respawnCounter == 120)
			bot.render(g, false);
		
		if (!GameState.projectiles.isEmpty()) {
			
			for (Projectile projectile : GameState.projectiles) {
				
				projectile.render(g, false);
			}
		}
		

		
		if (GameState.hitEffectActive) {
			
			g.drawImage(GameState.hitEffect.getImage(), GameState.hitEffect.getX(), GameState.hitEffect.getY(), GameState.hitEffect.getWidth(), GameState.hitEffect.getHeight(), null);
			
			if (respawnCounter < 120)
				g.drawImage(GameState.hitEffect.getImage(), GameState.hitEffect.getX() - 48, GameState.hitEffect.getY() - 48, GameState.hitEffect.getWidth()*3, GameState.hitEffect.getHeight()*3, null);
		}
		
		if (playAs == 1) {
			if (player.getFrozen()) {
				
				g.drawImage(Assets.snowFlake, 300, 50, 50, 50, null);
			}
			
			if (bot.getFrozen()) {
				
				g.drawImage(Assets.snowFlake, 930, 50, 50, 50, null);
			}
		}
		else if (playAs == 2) {
			
			if (bot.getFrozen()) {
				
				g.drawImage(Assets.snowFlake, 300, 50, 50, 50, null);
			}
			
			if (player.getFrozen()) {
				
				g.drawImage(Assets.snowFlake, 930, 50, 50, 50, null);
			}
		}
		
		if (playAs == 1) {
			
			g.setColor(Color.red);
			g.fillRect(290 + (300 - 2*player.getHealth()), 20, 2*player.getHealth(), 20);
			g.fillRect(690, 20, 2*bot.getHealth(), 20);
			
			g.setColor(Color.green);
			g.fillRect(390 + (200 - 2*player.getShield()), 45, 2*player.getShield(), 20);
			g.fillRect(690, 45, 2*bot.getShield(), 20);
			
			g.setColor(Color.decode("2799606"));
			g.fillRect(490 + (100 - 10*player.getMagic()), 70, 10*player.getMagic(), 20);
			g.fillRect(690, 70, 10*bot.getMagic(), 20);
			
			g.setColor(Color.black);
			g.drawRect(290, 20, 300, 20);
			g.drawRect(690, 20, 100, 20);
			
			Text.drawString(g, player.getName(), 590 - g.getFontMetrics(Assets.font15).stringWidth("JOGADOR"), 15, false, Color.black, Assets.font15);
			Text.drawString(g, bot.getName(), 690, 15, false, Color.black, Assets.font15);
		}
		
		else if (playAs == 2) {
			
			g.setColor(Color.red);
			g.fillRect(490 + (100 - 2*bot.getHealth()), 20, 2*bot.getHealth(), 20);
			g.fillRect(690, 20, 2*player.getHealth(), 20);
			
			g.setColor(Color.green);
			g.fillRect(390 + (200 - 2*bot.getShield()), 45, 2*bot.getShield(), 20);
			g.fillRect(690, 45, 2*player.getShield(), 20);
			
			g.setColor(Color.decode("2799606"));
			g.fillRect(490 + (100 - 10*bot.getMagic()), 70, 10*bot.getMagic(), 20);
			g.fillRect(690, 70, 10*player.getMagic(), 20);
			
			g.setColor(Color.black);
			g.drawRect(490, 20, 100, 20);
			g.drawRect(690, 20, 300, 20);
			
			Text.drawString(g, bot.getName(), 590 - g.getFontMetrics(Assets.font15).stringWidth("JOGADOR"), 15, false, Color.black, Assets.font15);
			Text.drawString(g, player.getName(), 690, 15, false, Color.black, Assets.font15);
		}
		
		g.drawRect(390, 45, 200, 20);
		g.drawRect(690, 45, 200, 20);
		
		g.drawRect(490, 70, 100, 20);
		g.drawRect(690, 70, 100, 20);
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(490 + x, 70, 490 + x, 90);
		}
		
		for (int x = 10; x <= 90; x += 10) {
			
			g.drawLine(690 + x, 70, 690 + x, 90);
		}
		

		Text.drawString(g, "PONTOS", 1210, 20, true, Color.black, Assets.font10);
		Text.drawString(g, String.valueOf(score), 1210, 50, true, Color.black, Assets.font30);
		
		if (score == 3 && breakCounter > 0) {
			
			Text.drawString(g, "Parabéns, voc� sobreviveu ao nível Fácil.", 640, 200, true, Color.black, Assets.font30);
			Text.drawString(g, "Bônus:", 640, 250, true, Color.black, Assets.font25);
			Text.drawString(g, "+3 de Magia", 640, 280, true, Color.black, Assets.font25);
			Text.drawString(g, "Prepare-se para o nível Médio...", 640, 330, true, Color.black, Assets.font30);
		}
		
		if (score == 6 && breakCounter > 0) {
			
			Text.drawString(g, "Parabéns, você sobreviveu ao nível Médio.", 640, 200, true, Color.black, Assets.font30);
			Text.drawString(g, "Bônus:", 640, 250, true, Color.black, Assets.font25);
			Text.drawString(g, "+5 de Magia", 640, 280, true, Color.black, Assets.font25);
			Text.drawString(g, "+75 de Vida", 640, 310, true, Color.black, Assets.font25);
			Text.drawString(g, "Esse foi o último bônus.", 640, 350, true, Color.black, Assets.font25);
			Text.drawString(g, "Prepare-se para o nível Difícil...", 640, 390, true, Color.black, Assets.font30);
		}
		
		
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
}
