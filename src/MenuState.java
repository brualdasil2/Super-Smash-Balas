import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State{

	
	private Button pVpButton, botButton, keysButton, minigamesButton;
	private boolean rendered;
	
	public MenuState(Game game) {
		
		super(game);
		
	}
	

	public void init() {
		
		pVpButton = new Button(game, 550, 500, 80, 40, Color.black, "P vs P", Assets.font15, null, false);
		botButton = new Button(game, 650, 500, 80, 40, Color.black, "P vs BOT", Assets.font15, null, false);
		keysButton = new Button(game, 510, 560, 120, 40, Color.black, "CONTROLES", Assets.font15, null, false);
		minigamesButton = new Button(game, 650, 560, 120, 40, Color.black, "MINIGAMES", Assets.font15, null, false);
		
		rendered = false;
		SoundManager.play("sounds/Nothing.wav", false);
		
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
		
		if (minigamesButton.buttonPressed()) {
			
			State.setState(game.getMinigamesState());
			((MinigamesState)(game.getMinigamesState())).init();
		}
	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) {
			
			rendered = true;
			g.clearRect(0, 0, 1280, 720);
			//Text.drawString(g, "SUPER SMASH BALAS", 640, 300, true, Color.black, Assets.font30);
			g.drawImage(Assets.logo, 440, 100, 400, 400, null);
			Text.drawString(g, "Ver. 10.0", 10, 710, false, Color.black, Assets.font15);
			pVpButton.drawButton(g);
			botButton.drawButton(g);
			keysButton.drawButton(g);
			minigamesButton.drawButton(g);
		}
	}

	
}
