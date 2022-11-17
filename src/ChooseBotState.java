import java.awt.Color;
import java.awt.Graphics;

public class ChooseBotState extends State {

	private Button playerBrunoButton, playerCarolButton, playerLacerdaButton, playerObinoButton, botBrunoButton, botCarolButton, botLacerdaButton, botObinoButton, easyButton, mediumButton, hardButton, expertButton, backButton, player1Button, player2Button, suddenDeathYesButton, suddenDeathNoButton;
	private boolean rendered;
	private int playAs;
	private int playerChar, botChar;
	private SmashPlayer player, bot;
	private boolean suddenDeath;
	
	public ChooseBotState(Game game) {
		super(game);
	
	}
	
	
	public void init() {
		
		playerBrunoButton = new Button(game, 300, 100, 120, 40, Color.black, "BRUNO BALAS", Assets.font15, null, true);
		playerCarolButton = new Button(game, 440, 100, 120, 40, Color.black, "CAROL", Assets.font15, null, true);
		playerLacerdaButton = new Button(game, 300, 160, 120, 40, Color.black, "LACERDA", Assets.font15, null, true);
		playerObinoButton = new Button(game, 440, 160, 120, 40, Color.black, "OBINO", Assets.font15, null, true);
		botBrunoButton = new Button(game, 720, 100, 120, 40, Color.black, "BRUNO BALAS", Assets.font15, null, true);
		botCarolButton = new Button(game, 860, 100, 120, 40, Color.black, "CAROL", Assets.font15, null, true);
		botLacerdaButton = new Button(game, 720, 160, 120, 40, Color.black, "LACERDA", Assets.font15, null, true);
		botObinoButton = new Button(game, 860, 160, 120, 40, Color.black, "OBINO", Assets.font15, null, true);
		easyButton = new Button(game, 440, 600, 80, 40, Color.black, "FÁCIL", Assets.font15, null, true);
		mediumButton = new Button(game, 540, 600, 80, 40, Color.black, "MÉDIO", Assets.font15, null, true);
		hardButton = new Button(game, 640, 600, 80, 40, Color.black, "DIFÍCIL", Assets.font15, null, true);
		expertButton = new Button(game, 740, 600, 80, 40, Color.gray, "EXPERT", Assets.font15, null, true);
		backButton = new Button(game, 0, 0, 100, 50, Color.black, "<- VOLTAR", Assets.font15, null, false);
		player1Button = new Button(game, 525, 300, 100, 40, Color.black, "JOGADOR 1", Assets.font15, null, false);
		player2Button = new Button(game, 660, 300, 100, 40, Color.black, "JOGADOR 2", Assets.font15, null, false);
		suddenDeathYesButton = new Button(game, 550, 440, 80, 40, Color.black, "SIM", Assets.font15, null, false);
		suddenDeathNoButton = new Button(game, 650, 440, 80, 40, Color.black, "NÃO", Assets.font15, null, false);
		playAs = 1;
		playerChar = 1;
		botChar = 1;
		rendered = false;
		suddenDeath = false;
	}
	


	@Override
	public void tick() {

		if (backButton.buttonPressed()) {
			
			State.setState(game.getMenuState());
			((MenuState)(game.getMenuState())).init();
		}
		
		if (easyButton.buttonPressed()) {
			
			
			
			if (playAs == 1) {
				
				if (playerChar == 1)
					player = new SmashPlayer(game, 1, new Bruno(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 2)
					player = new SmashPlayer(game, 1, new Carol(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 3)
					player = new SmashPlayer(game, 1, new Lacerda(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 4)
					player = new SmashPlayer(game, 1, new Obino(0), 240, GameState.floorY - 200, "JOGADOR 1");
				
				
				if (botChar == 1)
					bot = new SmashBrunoBotEasy(game, 2, new Bruno(1), 840, GameState.floorY - 200);
				else if (botChar == 2)
					bot = new SmashCarolBotEasy(game, 2, new Carol(1), 840, GameState.floorY - 200);
				else if (botChar == 3)
					bot = new SmashLacerdaBotEasy(game, 2, new Lacerda(1), 840, GameState.floorY - 200);
				else if (botChar == 4)
					bot = new SmashObinoBotEasy(game, 2, new Obino(1), 840, GameState.floorY - 200);
			}
			
			else if (playAs == 2) {
				
				if (playerChar == 1)
					player = new SmashPlayer(game, 2, new Bruno(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 2)
					player = new SmashPlayer(game, 2, new Carol(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 3)
					player = new SmashPlayer(game, 2, new Lacerda(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 4)
					player = new SmashPlayer(game, 2, new Obino(1), 840, GameState.floorY - 200, "JOGADOR 2");
				
				if (botChar == 1)
					bot = new SmashBrunoBotEasy(game, 1, new Bruno(0), 240, GameState.floorY - 200);
				else if (botChar == 2)
					bot = new SmashCarolBotEasy(game, 1, new Carol(0), 240, GameState.floorY - 200);
				else if (botChar == 3)
					bot = new SmashLacerdaBotEasy(game, 1, new Lacerda(0), 240, GameState.floorY - 200); 
				else if (botChar == 4)
					bot = new SmashObinoBotEasy(game, 1, new Obino(0), 240, GameState.floorY - 200); 
			}
			
			
			
			State.setState(game.getGameState());
			((GameState)(game.getGameState())).init(2 + playAs, botChar, suddenDeath);
		
		}
		
		if (mediumButton.buttonPressed()) {
			
			
			
			if (playAs == 1) {
				
				if (playerChar == 1)
					player = new SmashPlayer(game, 1, new Bruno(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 2)
					player = new SmashPlayer(game, 1, new Carol(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 3)
					player = new SmashPlayer(game, 1, new Lacerda(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 4)
					player = new SmashPlayer(game, 1, new Obino(0), 240, GameState.floorY - 200, "JOGADOR 1");
				
				if (botChar == 1)
					bot = new SmashBrunoBotMedium(game, 2, new Bruno(1), 840, GameState.floorY - 200);
				else if (botChar == 2)
					bot = new SmashCarolBotMedium(game, 2, new Carol(1), 840, GameState.floorY - 200);
				else if (botChar == 3)
					bot = new SmashLacerdaBotMedium(game, 2, new Lacerda(1), 840, GameState.floorY - 200);
				else if (botChar == 4)
					bot = new SmashObinoBotMedium(game, 2, new Obino(1), 840, GameState.floorY - 200);
			}
			
			else if (playAs == 2) {
				
				if (playerChar == 1)
					player = new SmashPlayer(game, 2, new Bruno(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 2)
					player = new SmashPlayer(game, 2, new Carol(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 3)
					player = new SmashPlayer(game, 2, new Lacerda(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 4)
					player = new SmashPlayer(game, 2, new Obino(1), 840, GameState.floorY - 200, "JOGADOR 2");
				
				if (botChar == 1)
					bot = new SmashBrunoBotMedium(game, 1, new Bruno(0), 240, GameState.floorY - 200);
				else if (botChar == 2)
					bot = new SmashCarolBotMedium(game, 1, new Carol(0), 240, GameState.floorY - 200);
				else if (botChar == 3)
					bot = new SmashLacerdaBotMedium(game, 1, new Lacerda(0), 240, GameState.floorY - 200);
				else if (botChar == 4)
					bot = new SmashObinoBotMedium(game, 1, new Obino(0), 240, GameState.floorY - 200);
				
			}
			
			State.setState(game.getGameState());
			((GameState)(game.getGameState())).init(2 + playAs, botChar, suddenDeath);
		}
		
		if (hardButton.buttonPressed()) {
			
			
			
			if (playAs == 1) {
				
				if (playerChar == 1)
					player = new SmashPlayer(game, 1, new Bruno(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 2)
					player = new SmashPlayer(game, 1, new Carol(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 3)
					player = new SmashPlayer(game, 1, new Lacerda(0), 240, GameState.floorY - 200, "JOGADOR 1");
				else if (playerChar == 4)
					player = new SmashPlayer(game, 1, new Obino(0), 240, GameState.floorY - 200, "JOGADOR 1");
				
				if (botChar == 1)
					bot = new SmashBrunoBotHard(game, 2, new Bruno(1), 840, GameState.floorY - 200);
				else if (botChar == 2)
					bot = new SmashCarolBotHard(game, 2, new Carol(1), 840, GameState.floorY - 200);
				else if (botChar == 3)
					bot = new SmashLacerdaBotHard(game, 2, new Lacerda(1), 840, GameState.floorY - 200); 
				else if (botChar == 4)
					bot = new SmashObinoBotHard(game, 2, new Obino(1), 840, GameState.floorY - 200); 
			}
			
			else if (playAs == 2) {
				
				if (playerChar == 1)
					player = new SmashPlayer(game, 2, new Bruno(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 2)
					player = new SmashPlayer(game, 2, new Carol(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 3)
					player = new SmashPlayer(game, 2, new Lacerda(1), 840, GameState.floorY - 200, "JOGADOR 2");
				else if (playerChar == 4)
					player = new SmashPlayer(game, 2, new Obino(1), 840, GameState.floorY - 200, "JOGADOR 2");
				
				if (botChar == 1)
					bot = new SmashBrunoBotHard(game, 1, new Bruno(0), 240, GameState.floorY - 200);
				else if (botChar == 2)
					bot = new SmashCarolBotHard(game, 1, new Carol(0), 240, GameState.floorY - 200);
				else if (botChar == 3)
					bot = new SmashLacerdaBotHard(game, 1, new Lacerda(0), 240, GameState.floorY - 200);
				else if (botChar == 4)
					bot = new SmashObinoBotHard(game, 1, new Obino(0), 240, GameState.floorY - 200);
				
			}
			
			State.setState(game.getGameState());
			((GameState)(game.getGameState())).init(2 + playAs, botChar, suddenDeath);
		}
		/*
		if (false) {
			if (expertButton.buttonPressed()) {
				
				
				
				if (playAs == 1) {
					
					if (playerChar == 1)
						player = new SmashPlayer(game, 1, new Bruno(0), 240, GameState.floorY - 200, "JOGADOR 1");
					else if (playerChar == 2)
						player = new SmashPlayer(game, 1, new Carol(0), 240, GameState.floorY - 200, "JOGADOR 1");
					else if (playerChar == 3)
						player = new SmashPlayer(game, 1, new Lacerda(0), 240, GameState.floorY - 200, "JOGADOR 1");
					else if (playerChar == 4)
						player = new SmashPlayer(game, 1, new Obino(0), 240, GameState.floorY - 200, "JOGADOR 1");
					/*
					if (botChar == 1)
						bot = new BrunoBotExpert(game, 2, new Bruno(1), 840, GameState.floorY - 200);
					else if (botChar == 2)
						bot = new CarolBotExpert(game, 2, new Carol(1), 840, GameState.floorY - 200);
					else if (botChar == 3)
						bot = new LacerdaBotExpert(game, 2, new Lacerda(1), 840, GameState.floorY - 200); 
					else if (botChar == 4)
						bot = new ObinoBotExpert(game, 2, new Obino(1), 840, GameState.floorY - 200); 
			
				}
				
				else if (playAs == 2) {
					
					if (playerChar == 1)
						player = new SmashPlayer(game, 2, new Bruno(1), 840, GameState.floorY - 200, "JOGADOR 2");
					else if (playerChar == 2)
						player = new SmashPlayer(game, 2, new Carol(1), 840, GameState.floorY - 200, "JOGADOR 2");
					else if (playerChar == 3)
						player = new SmashPlayer(game, 2, new Lacerda(1), 840, GameState.floorY - 200, "JOGADOR 2");
					else if (playerChar == 4)
						player = new SmashPlayer(game, 2, new Obino(1), 840, GameState.floorY - 200, "JOGADOR 2");
					
					if (botChar == 1)
						bot = new BrunoBotExpert(game, 1, new Bruno(0), 240, GameState.floorY - 200);
					else if (botChar == 2)
						bot = new CarolBotExpert(game, 1, new Carol(0), 240, GameState.floorY - 200);
					else if (botChar == 3)
						bot = new LacerdaBotExpert(game, 1, new Lacerda(0), 240, GameState.floorY - 200);
					else if (botChar == 4)
						bot = new ObinoBotExpert(game, 1, new Obino(0), 240, GameState.floorY - 200);
				
				}
				
				State.setState(game.getGameState());
				((GameState)(game.getGameState())).init(2 + playAs, botChar, suddenDeath);
			}
		}*/
		
		if (player1Button.buttonPressed()) {
			
			rendered = false;
			playAs = 1;
		}
		
		if (player2Button.buttonPressed()) {
			
			rendered = false;
			playAs = 2;
		}
		
		if (playerBrunoButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 1;
		}
		
		if (playerCarolButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 2;
		}
		
		if (playerLacerdaButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 3;
		}
		
		if (playerObinoButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 4;
		}
		
		if (botBrunoButton.buttonPressed()) {
			
			rendered = false;
			botChar = 1;
			//expertButton.setColor(Color.black);
		}
		
		if (botCarolButton.buttonPressed()) {
			
			rendered = false;
			botChar = 2;
			//expertButton.setColor(Color.black);
		}
		
		if (botLacerdaButton.buttonPressed()) {
			
			rendered = false;
			botChar = 3;
			//expertButton.setColor(Color.gray);
		}
		
		if (botObinoButton.buttonPressed()) {
			
			rendered = false;
			botChar = 4;
			//expertButton.setColor(Color.gray);
		}
		
		if (suddenDeathYesButton.buttonPressed()) {
			
			rendered = false;
			suddenDeath = true;
		}
		
		if (suddenDeathNoButton.buttonPressed()) {
			
			rendered = false;
			suddenDeath = false;
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) {
			
			rendered = true;
			g.clearRect(0, 0, 1280, 720);
			
			Text.drawString(g, "Escolha a dificuldade:", 640, 550, true, Color.black, Assets.font20);
			Text.drawString(g, "Jogar como:", 640, 250, true, Color.black, Assets.font20);
			Text.drawString(g, "Seu personagem:", 430, 50, true, Color.black, Assets.font20);
			Text.drawString(g, "Personagem do BOT:", 860, 50, true, Color.black, Assets.font20);
			Text.drawString(g, "Morte Súbita:", 640, 390, true, Color.black, Assets.font20);
			
			if (playAs == 1) {
				
				g.setColor(Color.red);
				g.fillRect(520, 295, 110, 50);
			}
			
			else if (playAs == 2) {
				
				g.setColor(Color.red);
				g.fillRect(655, 295, 110, 50);
			}
			
			if (playerChar == 1) {
				
				g.setColor(Color.red);
				g.fillRect(295, 95, 130, 50);
			}
			
			else if (playerChar == 2) {
				
				g.setColor(Color.red);
				g.fillRect(435, 95, 130, 50);
			}
			
			else if (playerChar == 3) {
				
				g.setColor(Color.red);
				g.fillRect(295, 155, 130, 50);
			}
			
			else if (playerChar == 4) {
				
				g.setColor(Color.red);
				g.fillRect(435, 155, 130, 50);
			}
			
			if (botChar == 1) {
				
				g.setColor(Color.red);
				g.fillRect(715, 95, 130, 50);
			}
			
			else if (botChar == 2) {
				
				g.setColor(Color.red);
				g.fillRect(855, 95, 130, 50);
			}
			
			else if (botChar == 3) {
				
				g.setColor(Color.red);
				g.fillRect(715, 155, 130, 50);
			}
			
			else if (botChar == 4) {
				
				g.setColor(Color.red);
				g.fillRect(855, 155, 130, 50);
			}
			
			if (suddenDeath) {
				
				g.setColor(Color.red);
				g.fillRect(545, 435, 90, 50);
			}
			else {
				
				g.setColor(Color.red);
				g.fillRect(645, 435, 90, 50);
			}
			
			easyButton.drawButton(g);
			mediumButton.drawButton(g);
			hardButton.drawButton(g);
			expertButton.drawButton(g);
			backButton.drawButton(g);
			player1Button.drawButton(g);
			player2Button.drawButton(g);
			playerBrunoButton.drawButton(g);
			playerCarolButton.drawButton(g);
			playerLacerdaButton.drawButton(g);
			playerObinoButton.drawButton(g);
			botBrunoButton.drawButton(g);
			botCarolButton.drawButton(g);
			botLacerdaButton.drawButton(g);
			botObinoButton.drawButton(g);
			suddenDeathYesButton.drawButton(g);
			suddenDeathNoButton.drawButton(g);
		}
		
	}
	
	public SmashPlayer getPlayer() {
		
		return player;
	}
	
	public SmashPlayer getBot() {
		
		return bot;
	}

}
