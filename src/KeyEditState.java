import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEditState extends State {

	private Button wLeftButton, wRightButton, aLeftButton, aRightButton, sLeftButton, sRightButton, dLeftButton, dRightButton,
				   capsRightButton, capsLeftButton, shiftRightButton, shiftLeftButton, ctrlRightButton, ctrlLeftButton,
				   iLeftButton, iRightButton, jLeftButton, jRightButton, kLeftButton, kRightButton, lLeftButton, lRightButton,
				   gLeftButton, gRightButton, vLeftButton, vRightButton, bLeftButton, bRightButton;
	
	private Button backButton, saveButton;
	
	private boolean saved = true;
	private boolean controlsOK = true;
	private static boolean rendered;
	
	private String[] options = new String[] {"CIMA", "ESQUERDA", "ESCUDO", "DIREITA", "PULO", "ATAQUE", "ESPECIAL"};
	private static int p1keys[] = new int[] {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL};;
	private static int p2keys[] = new int[] {KeyEvent.VK_I, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_G, KeyEvent.VK_V, KeyEvent.VK_B};
	private static int p1tempControls[] = new int[7];
	private static int p2tempControls[] = new int[7];
	private static int p1controls[] = new int[7];
	private static int p2controls[] = new int[7];
	private static KeyEditButton p1leftButton, p1rightButton, p1upButton, p1shieldButton, p1jumpButton, p1attackButton, p1specialButton,
	p2leftButton, p2rightButton, p2upButton, p2shieldButton, p2jumpButton, p2attackButton, p2specialButton,
	pauseButton;
	
	private static int p1Up, p1Left, p1Shield, p1Right, p1Jump, p1Attack, p1Special;
	private static int p2Up, p2Left, p2Shield, p2Right, p2Jump, p2Attack, p2Special;
	
	
	public KeyEditState(Game game) {
		
		super(game);	
		p1leftButton = new KeyEditButton(game, 300, 170, 100, 40, "A", KeyEvent.VK_A);
		p1rightButton = new KeyEditButton(game, 300, 220, 100, 40, "D", KeyEvent.VK_D);
		p1upButton = new KeyEditButton(game, 300, 270, 100, 40, "W", KeyEvent.VK_W);
		p1shieldButton = new KeyEditButton(game, 300, 320, 100, 40, "S", KeyEvent.VK_S);
		p1jumpButton = new KeyEditButton(game, 300, 470, 100, 40, "CAPS", KeyEvent.VK_CAPS_LOCK);
		p1attackButton = new KeyEditButton(game, 300, 520, 100, 40, "SHIFT", KeyEvent.VK_SHIFT);
		p1specialButton = new KeyEditButton(game, 300, 570, 100, 40, "CTRL", KeyEvent.VK_CONTROL);

		p2leftButton = new KeyEditButton(game, 890, 170, 100, 40, "J", KeyEvent.VK_J);
		p2rightButton = new KeyEditButton(game, 890, 220, 100, 40, "L", KeyEvent.VK_L);
		p2upButton = new KeyEditButton(game, 890, 270, 100, 40, "I", KeyEvent.VK_I);
		p2shieldButton = new KeyEditButton(game, 890, 320, 100, 40, "K", KeyEvent.VK_K);
		p2jumpButton = new KeyEditButton(game, 890, 470, 100, 40, "G", KeyEvent.VK_G);
		p2attackButton = new KeyEditButton(game, 890, 520, 100, 40, "V", KeyEvent.VK_V);
		p2specialButton = new KeyEditButton(game, 890, 570, 100, 40, "B", KeyEvent.VK_B);
		
		pauseButton = new KeyEditButton(game, 590, 370, 100, 40, "P", KeyEvent.VK_P);

	}

	public void init() {
		
		rendered = false;
		saved = true;


		backButton = new Button(game, 0, 0, 100, 50, Color.black, "<- VOLTAR", Assets.font15, null, false);
		saveButton = new Button(game, 590, 600, 100, 50 ,Color.red, "SALVAR", Assets.font15, null, true);
		
	}
	
	@Override
	public void tick() {
		
		if (backButton.buttonPressed()) {
			
			State.setState(game.getMenuState());
			((MenuState)(game.getMenuState())).init();
		}
		
		
		
		p1leftButton.tick();
		p1rightButton.tick();
		p1upButton.tick();
		p1shieldButton.tick();
		p1jumpButton.tick();
		p1attackButton.tick();
		p1specialButton.tick();
		
		p2leftButton.tick();
		p2rightButton.tick();
		p2upButton.tick();
		p2shieldButton.tick();
		p2jumpButton.tick();
		p2attackButton.tick();
		p2specialButton.tick();
		
		pauseButton.tick();
		
	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) { 
		
			rendered = true;
			g.clearRect(0, 0, 1280, 720);
			
			Text.drawString(g, "CUSTOMIZAR CONTROLES", 640, 50, true, Color.black, Assets.font30);
			Text.drawString(g, "JOGADOR 1", 145, 130, true, Color.black, Assets.font20);
			Text.drawString(g, "JOGADOR 2", 1135, 130, true, Color.black, Assets.font20);
			Text.drawString(g, "PAUSE", 640, 350, true, Color.black, Assets.font20);
			
			g.setColor(Color.gray);
			g.fillRoundRect(20, 150, 250, 230, 20, 20);
			g.fillRoundRect(20, 450, 250, 180, 20, 20);
			
			g.fillRoundRect(1010, 150, 250, 230, 20, 20);
			g.fillRoundRect(1010, 450, 250, 180, 20, 20);
			
			g.setColor(Color.white);
			g.fillRect(40, 170, 210, 40);
			g.fillRect(40, 220, 210, 40);
			g.fillRect(40, 270, 210, 40);
			g.fillRect(40, 320, 210, 40);
			
			g.fillRect(40, 470, 210, 40);
			g.fillRect(40, 520, 210, 40);
			g.fillRect(40, 570, 210, 40);
			
			
			g.fillRect(1030, 170, 210, 40);
			g.fillRect(1030, 220, 210, 40);
			g.fillRect(1030, 270, 210, 40);
			g.fillRect(1030, 320, 210, 40);
			
			g.fillRect(1030, 470, 210, 40);
			g.fillRect(1030, 520, 210, 40);
			g.fillRect(1030, 570, 210, 40);
			
			
			Text.drawString(g, "ESQUERDA", 145, 190, true, Color.black, Assets.font13);
			Text.drawString(g, "DIREITA", 145, 240, true, Color.black, Assets.font13);
			Text.drawString(g, "CIMA", 145, 290, true, Color.black, Assets.font13);
			Text.drawString(g, "ESCUDO", 145, 340, true, Color.black, Assets.font13);
			Text.drawString(g, "PULO", 145, 490, true, Color.black, Assets.font13);
			Text.drawString(g, "ATAQUE", 145, 540, true, Color.black, Assets.font13);
			Text.drawString(g, "ESPECIAL", 145, 590, true, Color.black, Assets.font13);
			
			Text.drawString(g, "ESQUERDA", 1135, 190, true, Color.black, Assets.font13);
			Text.drawString(g, "DIREITA", 1135, 240, true, Color.black, Assets.font13);
			Text.drawString(g, "CIMA", 1135, 290, true, Color.black, Assets.font13);
			Text.drawString(g, "ESCUDO", 1135, 340, true, Color.black, Assets.font13);
			Text.drawString(g, "PULO", 1135, 490, true, Color.black, Assets.font13);
			Text.drawString(g, "ATAQUE", 1135, 540, true, Color.black, Assets.font13);
			Text.drawString(g, "ESPECIAL", 1135, 590, true, Color.black, Assets.font13);
			

			
			backButton.drawButton(g);
			p1leftButton.drawButton(g);
			p1rightButton.drawButton(g);
			p1upButton.drawButton(g);
			p1shieldButton.drawButton(g);
			p1jumpButton.drawButton(g);
			p1attackButton.drawButton(g);
			p1specialButton.drawButton(g);
			
			p2leftButton.drawButton(g);
			p2rightButton.drawButton(g);
			p2upButton.drawButton(g);
			p2shieldButton.drawButton(g);
			p2jumpButton.drawButton(g);
			p2attackButton.drawButton(g);
			p2specialButton.drawButton(g);
			
			pauseButton.drawButton(g);
	
		}
	}
	

	public void saveControls() {
		
	}
	
	public static int getp1Up() {
		
		return p1upButton.getKeyCode();
	}
	
	public static int getp1Left() {
		
		return p1leftButton.getKeyCode();
	}
	
	public static int getp1Shield() {
		
		return p1shieldButton.getKeyCode();
	}
	
	public static int getp1Right() {
		
		return p1rightButton.getKeyCode();
	}
	
	public static int getp1Jump() {
		
		return p1jumpButton.getKeyCode();
	}
	
	public static int getp1Attack() {
		
		return p1attackButton.getKeyCode();
	}
	
	
	public static int getp1Special() {
		
		return p1specialButton.getKeyCode();
	}
	
	public static int getp2Up() {
		
		return p2upButton.getKeyCode();
	}
	
	public static int getp2Left() {
		
		return p2leftButton.getKeyCode();
	}
	
	public static int getp2Shield() {
		
		return p2shieldButton.getKeyCode();
	}
	
	public static int getp2Right() {
		
		return p2rightButton.getKeyCode();
	}
	
	public static int getp2Jump() {
		
		return p2jumpButton.getKeyCode();
	}
	
	public static int getp2Attack() {
		
		return p2attackButton.getKeyCode();
	}
	
	
	public static int getp2Special() {
		
		return p2specialButton.getKeyCode();
	}
	
	public static int getPause() {
		return pauseButton.getKeyCode();
	}

	public static void rerender() {
		rendered = false;
	}

}
