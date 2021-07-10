import java.awt.Color;
import java.awt.Graphics;

public class MinigamesState extends State {
	
	
	private Button targetsButton, survivalButton, backButton, brunoButton, carolButton, lacerdaButton, obinoButton, player1Button, player2Button;
	private boolean rendered;
	private int playerChar, playAs = 1;
	
	public MinigamesState(Game game) {
		
		super(game);
		
	}
	

	public void init() {
		
		rendered = false;
		playerChar = 1;
		playAs = 1;
		
		targetsButton = new Button(game, 510, 550, 120, 40, Color.black, "ALVOS", Assets.font15, null, false);
		survivalButton = new Button(game, 650, 550, 120, 40, Color.black, "SOBREVIVÊNCIA", Assets.font13, null, false);
		backButton = new Button(game, 0, 0, 100, 50, Color.black, "<- VOLTAR", Assets.font15, null, false);
		brunoButton = new Button(game, 360, 200, 120, 40, Color.black, "BRUNO BALAS", Assets.font15, null, true);
		carolButton = new Button(game, 500, 200, 120, 40, Color.black, "CAROL", Assets.font15, null, true);
		lacerdaButton = new Button(game, 640, 200, 120, 40, Color.black, "LACERDA", Assets.font15, null, true);
		obinoButton = new Button(game, 780, 200, 120, 40, Color.black, "OBINO", Assets.font15, null, true);
		player1Button = new Button(game, 525, 350, 100, 40, Color.black, "JOGADOR 1", Assets.font15, null, false);
		player2Button = new Button(game, 660, 350, 100, 40, Color.black, "JOGADOR 2", Assets.font15, null, false);
		
		
	}
	
	@Override
	public void tick() {
		
		if (backButton.buttonPressed()) {
			
			State.setState(game.getMenuState());
			((MenuState)(game.getMenuState())).init();
		}
		
		if (targetsButton.buttonPressed()) {
			
			State.setState(game.getTargetState());
			((TargetState)(game.getTargetState())).init(playerChar, playAs);
		}
		
		if (survivalButton.buttonPressed()) {
			
			State.setState(game.getSurvivalState());
			((SurvivalState)(game.getSurvivalState())).init(playerChar, playAs);
		}
		
		if (brunoButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 1;
		}
		
		if (carolButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 2;
		}
		
		if (lacerdaButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 3;
		}
		
		
		if (obinoButton.buttonPressed()) {
			
			rendered = false;
			playerChar = 4;
		}
		
		if (player1Button.buttonPressed()) {
			
			rendered = false;
			playAs = 1;
		}
		
		if (player2Button.buttonPressed()) {
			
			rendered = false;
			playAs = 2;
		}
	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) {
			
			rendered = true;
			g.clearRect(0, 0, 1280, 720);
			
			Text.drawString(g, "MINIGAMES", 640, 50, true, Color.black, Assets.font30);
			Text.drawString(g, "Escolha seu personagem:", 640, 150, true, Color.black, Assets.font20);
			Text.drawString(g, "Jogar como:", 640, 300, true, Color.black, Assets.font20);
			Text.drawString(g, "Escolha o minigame:", 640, 500, true, Color.black, Assets.font20);
			
			if (playerChar == 1) {
				
				g.setColor(Color.red);
				g.fillRect(355, 195, 130, 50);
			}
			
			else if (playerChar == 2) {
				
				g.setColor(Color.red);
				g.fillRect(495, 195, 130, 50);
			}
			
			else if (playerChar == 3) {
				
				g.setColor(Color.red);
				g.fillRect(635, 195, 130, 50);
			}
			
			else if (playerChar == 4) {
				
				g.setColor(Color.red);
				g.fillRect(775, 195, 130, 50);
			}
			
			if (playAs == 1) {
				
				g.setColor(Color.red);
				g.fillRect(520, 345, 110, 50);
			}
			
			else if (playAs == 2) {
				
				g.setColor(Color.red);
				g.fillRect(655, 345, 110, 50);
			}
			
			targetsButton.drawButton(g);
			survivalButton.drawButton(g);
			backButton.drawButton(g);
			brunoButton.drawButton(g);
			carolButton.drawButton(g);
			lacerdaButton.drawButton(g);
			obinoButton.drawButton(g);
			player1Button.drawButton(g);
			player2Button.drawButton(g);
		}
	}

}
