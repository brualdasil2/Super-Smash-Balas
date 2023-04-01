import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MenuState extends State{

	
	private Button pVpButton, botButton, keysButton, minigamesButton, soundButton, replayButton;
	private boolean rendered;
	private boolean replayExists;
	
	public MenuState(Game game) {
		
		super(game);
		
	}
	

	public void init() {
		
		pVpButton = new Button(game, 550, 500, 80, 40, Color.black, "P vs P", Assets.font15, null, false);
		botButton = new Button(game, 650, 500, 80, 40, Color.black, "P vs BOT", Assets.font15, null, false);
		keysButton = new Button(game, 440, 560, 120, 40, Color.black, "CONTROLES", Assets.font15, null, false);
		minigamesButton = new Button(game, 580, 560, 120, 40, Color.gray, "MINIGAMES", Assets.font15, null, false);
		replayButton = new Button(game, 720, 560, 120, 40, Color.black, "REPLAY", Assets.font15, null, false);
		
		rendered = false;
		SoundManager.play("sounds/Nothing.wav", false);
		File f = new File("replays/lastReplay.pbr");
		if(f.exists() && !f.isDirectory()) { 
		    replayExists = true;
		}
		else {
			replayExists = false;
			replayButton.setColor(Color.gray);
		}
	}
	
	@Override
	public void tick() {

		
		if (pVpButton.buttonPressed()) {
			
			State.setState(game.getCharacterSelectState());
			((CharacterSelectState)(game.getCharacterSelectState())).init();
		}
		
		if (botButton.buttonPressed()) {
			
			State.setState(game.getChooseBotState());
			((ChooseBotState)(game.getChooseBotState())).init();
			
		}
		
		if (keysButton.buttonPressed()) {
			
			State.setState(game.getKeyEditState());
			((KeyEditState)(game.getKeyEditState())).init();
		}
		
		/*if (minigamesButton.buttonPressed()) {
			
			State.setState(game.getMinigamesState());
			((MinigamesState)(game.getMinigamesState())).init();
		}*/
		
		if (replayButton.buttonPressed()) {
			
			if (replayExists) {
				State.setState(game.getGameState());
				((GameState)(game.getGameState())).init(5, 0, false);
			}
		}

	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) {
			
			rendered = true;
			g.clearRect(0, 0, 1280, 720);
			//Text.drawString(g, "SUPER SMASH BALAS", 640, 300, true, Color.black, Assets.font30);
			g.drawImage(Assets.logo, 440, 100, 400, 400, null);
			Text.drawString(g, "Ver. 3.2.3", 10, 710, false, Color.black, Assets.font15);
			pVpButton.drawButton(g);
			botButton.drawButton(g);
			keysButton.drawButton(g);
			minigamesButton.drawButton(g);
			replayButton.drawButton(g);
		}
	}

	
}
