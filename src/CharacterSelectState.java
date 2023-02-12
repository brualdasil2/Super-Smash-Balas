import java.awt.Color;
import java.awt.Graphics;

public class CharacterSelectState extends State {
	
	private int playerChoosing;
	private Character p1Char, p2Char;
	private Button brunoButton, carolButton, lacerdaButton, obinoButton, fightButton, trainingButton, suddenDeathButton, backButton, skin0Button, skin1Button, mapLeftButton, mapRightButton;
	private int skinChoice, p1Skin, p2Skin;
	private int map = 0;
	private boolean rendered;
	private InputDelayEditor p1DelayEditor, p2DelayEditor;
	
	
	
	public CharacterSelectState(Game game) {
		super(game);
		
	}

	
	public void init() {
		
		brunoButton = new Button(game, 365, 150, 100, 100, null, null, null, null, true);
		carolButton = new Button(game, 515, 150, 100, 100, null, null, null, null, true);
		lacerdaButton = new Button(game, 665, 150, 100, 100, null, null, null, null, true);
		obinoButton = new Button(game, 815, 150, 100, 100, null, null, null, null, true);
		fightButton = new Button(game, 540, 450, 200, 100, Color.black, "LUTAR!", Assets.font30, null, false);
		trainingButton = new Button(game, 590, 585, 100, 50, Color.black, "TREINAR", Assets.font20, null, false);
		suddenDeathButton = new Button(game, 565, 670, 150, 30, Color.black, "MORTE SÚBITA", Assets.font15, null, false);
		backButton = new Button(game, 0, 0, 100, 50, Color.black, "<- VOLTAR", Assets.font15, null, false);
		skin0Button = new Button(game, 550, 90, 70, 40, Color.black, "SKIN 1", Assets.font15, null, false);
		skin1Button = new Button(game, 660, 90, 70, 40, Color.black, "SKIN 2", Assets.font15, null, false);
		mapLeftButton = new Button(game, 462, 300, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		mapRightButton = new Button(game, 778, 300, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		p1DelayEditor = new InputDelayEditor(game, 290, 665);
		p2DelayEditor = new InputDelayEditor(game, 860, 665);
		playerChoosing = 1;
		skinChoice = 0;
		rendered = false;
	
	}
	
	@Override
	public void tick() {
		
		p1DelayEditor.tick();
		p2DelayEditor.tick();
		
		if (playerChoosing < 3) {
		
			if (skin0Button.buttonPressed()) {
				
				rendered = false;
				skinChoice = 0;
			}
			
			if (skin1Button.buttonPressed()) {
				
				rendered = false;
				skinChoice = 1;
			}
			
			if (brunoButton.buttonPressed()) {
				
				rendered = false;
				if (playerChoosing == 1) {
					
					p1Char = new Bruno(skinChoice);
					p1Skin = skinChoice;
					playerChoosing = 2;
				}
				
				else if (playerChoosing == 2) {
					
					p2Char = new Bruno(skinChoice);
					p2Skin = skinChoice;
					playerChoosing = 3;
				}
				
			}
			
			if (carolButton.buttonPressed()) {
				
				rendered = false;
				if (playerChoosing == 1) {
					
					p1Char = new Carol(skinChoice);
					p1Skin = skinChoice;
					playerChoosing = 2;
				}
				
				else if (playerChoosing == 2) {
					
					p2Char = new Carol(skinChoice);
					p2Skin = skinChoice;
					playerChoosing = 3;
				}
				
			}
			
		if (lacerdaButton.buttonPressed()) {
				
				rendered = false;
				if (playerChoosing == 1) {
					
					p1Char = new Lacerda(skinChoice);
					p1Skin = skinChoice;
					playerChoosing = 2;
				}
				
				else if (playerChoosing == 2) {
					
					p2Char = new Lacerda(skinChoice);
					p2Skin = skinChoice;
					playerChoosing = 3;
				}
				
			}
		}
		
		if (obinoButton.buttonPressed()) {
			
			rendered = false;
			if (playerChoosing == 1) {
				
				p1Char = new Obino(skinChoice);
				p1Skin = skinChoice;
				playerChoosing = 2;
			}
			
			else if (playerChoosing == 2) {
				
				p2Char = new Obino(skinChoice);
				p2Skin = skinChoice;
				playerChoosing = 3;
			}
			
		}
		
		
		
		if (backButton.buttonPressed()) {
			
			playerChoosing = 1;
			State.setState(game.getMenuState());
			((MenuState)(game.getMenuState())).init();
		}
		

		
		if (playerChoosing == 3) {
			
			if (mapLeftButton.buttonPressed()) {
				
				rendered = false;
				map--;
				if (map < 0)
					map = 4;
			}
			
			if (mapRightButton.buttonPressed()) {
				
				rendered = false;
				map++;
				if (map > 4)
					map = 0;
			}
			
			if (fightButton.buttonPressed()) {
				
				State.setState(game.getGameState());
				((GameState)(game.getGameState())).init(1, map, false);
			}
			
			if (trainingButton.buttonPressed()) {
				
				State.setState(game.getGameState());
				((GameState)(game.getGameState())).init(2, map, false);
			}
			
			if (suddenDeathButton.buttonPressed()) {
				
				State.setState(game.getGameState());
				((GameState)(game.getGameState())).init(1, map, true);
			}
		}
	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) {
			
			rendered = true;
			g.clearRect(0, 0, 1280, 720); 

		
			if (playerChoosing == 1) {
				g.setColor(Color.red);
				g.fillRoundRect(-25, 385, 310, 485, 50, 50);
				Text.drawString(g, "Jogador 1, escolha seu personagem:", 640, 60, true, Color.black, Assets.font20);
			}
			
			else if (playerChoosing == 2) {
				
				g.setColor(Color.red);
				g.fillRoundRect(995, 385, 310, 485, 50, 50);
				Text.drawString(g, "Jogador 2, escolha seu personagem:", 640, 60, true, Color.black, Assets.font20);
			}
			
			g.setColor(Color.DARK_GRAY);
			g.fillRoundRect(-25, 395, 300, 475, 50, 50);
			g.fillRoundRect(1005, 395, 300, 475, 50, 50);
			
			g.setColor(Color.white);
			g.fillRect(10, 455, 255, 255);
			g.fillRect(1015, 455, 255, 255);
			
			Text.drawString(g, "JOGADOR 1", 137, 425, true, Color.white, Assets.font20);
			Text.drawString(g, "JOGADOR 2", 1142, 425, true, Color.white, Assets.font20);
			p1DelayEditor.render(g);
			p2DelayEditor.render(g);
	
			
			
			
			
			if (playerChoosing < 3) {
				
				if (skinChoice == 0) {

					
					g.drawImage(Assets.bruno0SelectImageRight, 365, 150, 100, 100, null);
					g.drawImage(Assets.carol0SelectImageRight, 515, 150, 100, 100, null);
					g.drawImage(Assets.lacerda0SelectImageRight, 665, 150, 100, 100, null);
					g.drawImage(Assets.obino0SelectImageRight, 815, 150, 100, 100, null);
					
				}
				else if (skinChoice == 1) {
    
					
					g.drawImage(Assets.bruno1SelectImageRight, 365, 150, 100, 100, null);
					g.drawImage(Assets.carol1SelectImageRight, 515, 150, 100, 100, null);
					g.drawImage(Assets.lacerda1SelectImageRight, 665, 150, 100, 100, null);
					g.drawImage(Assets.obino1SelectImageRight, 815, 150, 100, 100, null);
					
				}
				
				brunoButton.drawButton(g);
				carolButton.drawButton(g);
				lacerdaButton.drawButton(g);
				obinoButton.drawButton(g);
				

				
				Text.drawString(g, "BRUNO BALAS", 415, 250 + g.getFontMetrics(Assets.font15).getHeight(), true, Color.black, Assets.font15);
				Text.drawString(g, "CAROL", 565, 250 + g.getFontMetrics(Assets.font15).getHeight(), true, Color.black, Assets.font15);
				Text.drawString(g, "LACERDA", 715, 250 + g.getFontMetrics(Assets.font15).getHeight(), true, Color.black, Assets.font15);
				Text.drawString(g, "OBINO", 865, 250 + g.getFontMetrics(Assets.font15).getHeight(), true, Color.black, Assets.font15);
				
				
				if (skinChoice == 0) {
					
					g.setColor(Color.red);
					g.fillRect(545, 85, 80, 50);
				}
				
				else if (skinChoice == 1) {
					
					g.setColor(Color.red);
					g.fillRect(655, 85, 80, 50);
				}
				
				skin0Button.drawButton(g);
				skin1Button.drawButton(g);
			}
			
			backButton.drawButton(g);
			
			if (playerChoosing >= 2) {
				
				if (p1Skin == 0) {
					
					if (p1Char instanceof Bruno)
						g.drawImage(Assets.bruno0SelectImageRight, 10, 455, 255, 255, null);
					else if (p1Char instanceof Carol)
						g.drawImage(Assets.carol0SelectImageRight, 10, 455, 255, 255, null);
					else if (p1Char instanceof Lacerda)
						g.drawImage(Assets.lacerda0SelectImageRight, 10, 455, 255, 255, null);
					else if (p1Char instanceof Obino)
						g.drawImage(Assets.obino0SelectImageRight, 10, 455, 255, 255, null);
				}
				else if (p1Skin == 1) {
					
					if (p1Char instanceof Bruno)
						g.drawImage(Assets.bruno1SelectImageRight, 10, 455, 255, 255, null);
					else if (p1Char instanceof Carol)
						g.drawImage(Assets.carol1SelectImageRight, 10, 455, 255, 255, null);
					else if (p1Char instanceof Lacerda)
						g.drawImage(Assets.lacerda1SelectImageRight, 10, 455, 255, 255, null);
					else if (p1Char instanceof Obino)
						g.drawImage(Assets.obino1SelectImageRight, 10, 455, 255, 255, null);
				}
			}
			
			if (playerChoosing == 3) {
	
				Text.drawString(g, "Escolha o mapa:", 640, 50, true, Color.black, Assets.font20);
				g.setColor(Color.darkGray);
				g.fillRect(462, 300, 356, 40);
				g.setColor(Color.black);
				g.drawRect(462, 300, 356, 40);
				
				switch (map) {
				
				case 0: 
					g.setColor(Color.LIGHT_GRAY);
					//462, 100, 356, 200
					int aux = 0;
					for (int i = 100; i < 300; i+=22) {
						g.drawLine(462, i, 462+356, i);
						aux++;
						if (aux%4 == 0) {
							i++;
						}
					}
					aux = 0;
					for (int j = 462; j < 462+356; j+=22) {
						g.drawLine(j, 100, j, 300);
						aux++;
						
						if (aux%4 == 0) {
							j++;
						}
					}
					g.setColor(Color.black);
					g.fillRect(504, 258, 272, 42);
					Text.drawString(g, "Sala de Treino", 640, 320, true, Color.white, Assets.font20);
					break;
				
				case 1:
					g.drawImage(Assets.candyLandSmall, 462, 100, 356, 200, null);
					Text.drawString(g, "Mundo das Balas", 640, 320, true, Color.white, Assets.font20);
					break;
					
				case 2:
					g.drawImage(Assets.enchantedForestSmall, 462, 100, 356, 200, null);
					Text.drawString(g, "Floresta Encantada", 640, 320, true, Color.white, Assets.font20);
					break;
				
				case 3:
					g.drawImage(Assets.dojoSmall, 462, 100, 356, 200, null);
					Text.drawString(g, "Dojô Ninja", 640, 320, true, Color.white, Assets.font20);
					break;
				case 4:
					g.drawImage(Assets.shipSmall, 462, 100, 356, 200, null);
					Text.drawString(g, "Barco Viking", 640, 320, true, Color.white, Assets.font20);
					break;
				}
				
				
				g.setColor(Color.black);
				g.drawRect(462, 100, 356, 200);
				
				mapLeftButton.drawButton(g);
				mapRightButton.drawButton(g);
				
				fightButton.drawButton(g);
				trainingButton.drawButton(g);
				suddenDeathButton.drawButton(g);
				
				if (p2Skin == 0) {
					
					if (p2Char instanceof Bruno)
						g.drawImage(Assets.bruno0SelectImageLeft, 1015, 455, 255, 255, null);
					else if (p2Char instanceof Carol)
						g.drawImage(Assets.carol0SelectImageLeft, 1015, 455, 255, 255, null);
					else if (p2Char instanceof Lacerda)
						g.drawImage(Assets.lacerda0SelectImageLeft, 1015, 455, 255, 255, null);
					else if (p2Char instanceof Obino)
						g.drawImage(Assets.obino0SelectImageLeft, 1015, 455, 255, 255, null);
				}
				else if (p2Skin == 1) {
					
					if (p2Char instanceof Bruno)
						g.drawImage(Assets.bruno1SelectImageLeft, 1015, 455, 255, 255, null);
					else if (p2Char instanceof Carol)
						g.drawImage(Assets.carol1SelectImageLeft, 1015, 455, 255, 255, null);
					else if (p2Char instanceof Lacerda)
						g.drawImage(Assets.lacerda1SelectImageLeft, 1015, 455, 255, 255, null);
					else if (p2Char instanceof Obino)
						g.drawImage(Assets.obino1SelectImageLeft, 1015, 455, 255, 255, null);
				}	
			}
		}
	}
	
	
	
	public Character getPlayer1Char() {
		
		return p1Char;
	}
	
	public Character getPlayer2Char() {
		
		return p2Char;
	}
	
	public int getPlayer1InputDelay() {
		return p1DelayEditor.getDelay();
	}
	
	public int getPlayer2InputDelay() {
		return p2DelayEditor.getDelay();
	}

	public void forceRerender() {
		rendered = false;
	}
	

}
