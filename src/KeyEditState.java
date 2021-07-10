import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class KeyEditState extends State {

	private Button wLeftButton, wRightButton, aLeftButton, aRightButton, sLeftButton, sRightButton, dLeftButton, dRightButton,
				   capsRightButton, capsLeftButton, shiftRightButton, shiftLeftButton, ctrlRightButton, ctrlLeftButton,
				   iLeftButton, iRightButton, jLeftButton, jRightButton, kLeftButton, kRightButton, lLeftButton, lRightButton,
				   gLeftButton, gRightButton, vLeftButton, vRightButton, bLeftButton, bRightButton;
	
	private Button backButton, saveButton;
	
	private boolean saved = true;
	private boolean controlsOK = true;
	private boolean rendered;
	
	private String[] options = new String[] {"CIMA", "ESQUERDA", "ESCUDO", "DIREITA", "PULO", "ATAQUE", "ESPECIAL"};
	private static int p1keys[] = new int[] {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_CAPS_LOCK, KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL};;
	private static int p2keys[] = new int[] {KeyEvent.VK_I, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L, KeyEvent.VK_G, KeyEvent.VK_V, KeyEvent.VK_B};
	private static int p1tempControls[] = new int[7];
	private static int p2tempControls[] = new int[7];
	private static int p1controls[] = new int[7];
	private static int p2controls[] = new int[7];
	private Button[] p1LeftButtons;
	private Button[] p1RightButtons;
	private Button[] p2LeftButtons;
	private Button[] p2RightButtons;
	
	private static int p1Up, p1Left, p1Shield, p1Right, p1Jump, p1Attack, p1Special;
	private static int p2Up, p2Left, p2Shield, p2Right, p2Jump, p2Attack, p2Special;
	
	
	public KeyEditState(Game game) {
		
		super(game);

		
		p1controls[0] = 0;
		p1controls[1] = 1;
		p1controls[2] = 2;
		p1controls[3] = 3;
		p1controls[4] = 4;
		p1controls[5] = 5;
		p1controls[6] = 6;
		
		p2controls[0] = 0;
		p2controls[1] = 1;
		p2controls[2] = 2;
		p2controls[3] = 3;
		p2controls[4] = 4;
		p2controls[5] = 5;
		p2controls[6] = 6;
		
		

	}

	public void init() {
		
		rendered = false;
		saved = true;
		backButton = new Button(game, 0, 0, 100, 50, Color.black, "<- VOLTAR", Assets.font15, null, false);
		saveButton = new Button(game, 590, 600, 100, 50 ,Color.red, "SALVAR", Assets.font15, null, true);
		wLeftButton = new Button(game, 40, 170, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		wRightButton = new Button(game, 210, 170, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		aLeftButton = new Button(game, 40, 220, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		aRightButton = new Button(game, 210, 220, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		sLeftButton = new Button(game, 40, 270, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		sRightButton = new Button(game, 210, 270, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		dLeftButton = new Button(game, 40, 320, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		dRightButton = new Button(game, 210, 320, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		capsLeftButton = new Button(game, 40, 470, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		shiftLeftButton = new Button(game, 40, 520, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		ctrlLeftButton = new Button(game, 40, 570, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		capsRightButton = new Button(game, 210, 470, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		shiftRightButton = new Button(game, 210, 520, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		ctrlRightButton = new Button(game, 210, 570, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		iLeftButton = new Button(game, 1030, 170, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		jLeftButton = new Button(game, 1030, 220, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		kLeftButton = new Button(game, 1030, 270, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		lLeftButton = new Button(game, 1030, 320, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		iRightButton = new Button(game, 1200, 170, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		jRightButton = new Button(game, 1200, 220, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		kRightButton = new Button(game, 1200, 270, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		lRightButton = new Button(game, 1200, 320, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		gLeftButton = new Button(game, 1030, 470, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		vLeftButton = new Button(game, 1030, 520, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		bLeftButton = new Button(game, 1030, 570, 40, 40, Color.lightGray, null, null, Assets.leftArrow, true);
		gRightButton = new Button(game, 1200, 470, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		vRightButton = new Button(game, 1200, 520, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		bRightButton = new Button(game, 1200, 570, 40, 40, Color.lightGray, null, null, Assets.rightArrow, true);
		
		p1LeftButtons = new Button[] {wLeftButton, aLeftButton, sLeftButton, dLeftButton, capsLeftButton, shiftLeftButton, ctrlLeftButton};
		p1RightButtons = new Button[] {wRightButton, aRightButton, sRightButton, dRightButton, capsRightButton, shiftRightButton, ctrlRightButton};
		p2LeftButtons = new Button[] {iLeftButton, jLeftButton, kLeftButton, lLeftButton, gLeftButton, vLeftButton, bLeftButton};
		p2RightButtons = new Button[] {iRightButton, jRightButton, kRightButton, lRightButton, gRightButton, vRightButton, bRightButton};
		
		p1tempControls[0] = p1controls[0];
		p1tempControls[1] = p1controls[1];
		p1tempControls[2] = p1controls[2];
		p1tempControls[3] = p1controls[3];
		p1tempControls[4] = p1controls[4];
		p1tempControls[5] = p1controls[5];
		p1tempControls[6] = p1controls[6];
		
		p2tempControls[0] = p2controls[0];
		p2tempControls[1] = p2controls[1];
		p2tempControls[2] = p2controls[2];
		p2tempControls[3] = p2controls[3];
		p2tempControls[4] = p2controls[4];
		p2tempControls[5] = p2controls[5];
		p2tempControls[6] = p2controls[6];
	}
	
	@Override
	public void tick() {
		
		if (backButton.buttonPressed()) {
			
			State.setState(game.getMenuState());
			((MenuState)(game.getMenuState())).init();
		}
		
		if (controlsOK) {
			if (saveButton.buttonPressed()) {
				
				rendered = false;
				saved = true;
				saveControls();
			}
		}
		
		for (int i = 0; i <= 6; i++) {
			
			if (p1LeftButtons[i].buttonPressed()) {
				
				rendered = false;
				saved = false;
				p1tempControls[i]--;
				if (p1tempControls[i] < 0)
					p1tempControls[i] = 6;
				
				if (checkControls()) {
					controlsOK = true;
					saveButton.setColor(Color.red);
				}
				else {
					controlsOK = false;
					saveButton.setColor(Color.gray);
				}
					
			}
			if (p1RightButtons[i].buttonPressed()) {
				
				rendered = false;
				saved = false;
				p1tempControls[i]++;
				if (p1tempControls[i] > 6)
					p1tempControls[i] = 0;
				
				if (checkControls()) {
					controlsOK = true;
					saveButton.setColor(Color.red);
				}
				else {
					controlsOK = false;
					saveButton.setColor(Color.gray);
				}
			}
			
			if (p2LeftButtons[i].buttonPressed()) {
				
				rendered = false;
				saved = false;
				p2tempControls[i]--;
				if (p2tempControls[i] < 0)
					p2tempControls[i] = 6;
				
				if (checkControls()) {
					controlsOK = true;
					saveButton.setColor(Color.red);
				}
				else {
					controlsOK = false;
					saveButton.setColor(Color.gray);
				}
			}
			if (p2RightButtons[i].buttonPressed()) {
				
				rendered = false;
				saved = false;
				p2tempControls[i]++;
				if (p2tempControls[i] > 6)
					p2tempControls[i] = 0;
				
				if (checkControls()) {
					controlsOK = true;
					saveButton.setColor(Color.red);
				}
				else {
					controlsOK = false;
					saveButton.setColor(Color.gray);
				}
			}
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		
		if (!rendered) { 
		
			rendered = true;
			g.clearRect(0, 0, 1280, 720);
			
			Text.drawString(g, "CUSTOMIZAR CONTROLES", 640, 50, true, Color.black, Assets.font30);
			Text.drawString(g, "JOGADOR 1", 145, 130, true, Color.black, Assets.font20);
			Text.drawString(g, "JOGADOR 2", 1135, 130, true, Color.black, Assets.font20);
			
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
			
			
			Text.drawString(g, "W = " + options[p1tempControls[0]], 145, 190, true, Color.black, Assets.font13);
			Text.drawString(g, "A = " + options[p1tempControls[1]], 145, 240, true, Color.black, Assets.font13);
			Text.drawString(g, "S = " + options[p1tempControls[2]], 145, 290, true, Color.black, Assets.font13);
			Text.drawString(g, "D = " + options[p1tempControls[3]], 145, 340, true, Color.black, Assets.font13);
			Text.drawString(g, "CAPS = " + options[p1tempControls[4]], 145, 490, true, Color.black, Assets.font13);
			Text.drawString(g, "SHIFT = " + options[p1tempControls[5]], 145, 540, true, Color.black, Assets.font13);
			Text.drawString(g, "CTRL = " + options[p1tempControls[6]], 145, 590, true, Color.black, Assets.font13);
			
			Text.drawString(g, "I = " + options[p2tempControls[0]], 1135, 190, true, Color.black, Assets.font13);
			Text.drawString(g, "J = " + options[p2tempControls[1]], 1135, 240, true, Color.black, Assets.font13);
			Text.drawString(g, "K = " + options[p2tempControls[2]], 1135, 290, true, Color.black, Assets.font13);
			Text.drawString(g, "L = " + options[p2tempControls[3]], 1135, 340, true, Color.black, Assets.font13);
			Text.drawString(g, "G = " + options[p2tempControls[4]], 1135, 490, true, Color.black, Assets.font13);
			Text.drawString(g, "V = " + options[p2tempControls[5]], 1135, 540, true, Color.black, Assets.font13);
			Text.drawString(g, "B = " + options[p2tempControls[6]], 1135, 590, true, Color.black, Assets.font13);
			
			
			g.drawImage(Assets.keys[0], 350, 150, 200, 200, null);
			g.drawImage(Assets.keys[1], 375, 300, 200, 200, null);
			g.drawImage(Assets.keys[2], 375, 500, 200, 200, null);
			
			g.drawImage(Assets.keys[3], 730, 150, 200, 200, null);
			g.drawImage(Assets.keys[4], 730, 450, 200, 200, null);
			
			backButton.drawButton(g);
			if (!saved) {
				saveButton.drawButton(g);
				if (!controlsOK) {
					
					Text.drawString(g, "Configuração não permitida, duas teclas não podem ter a mesma função!", 640, 690, true, Color.red, Assets.font15);
				}
			}
			
			
				
			
			wLeftButton.drawButton(g);
			wRightButton.drawButton(g);
			aLeftButton.drawButton(g);
			aRightButton.drawButton(g);
			sLeftButton.drawButton(g);
			sRightButton.drawButton(g);
			dLeftButton.drawButton(g);
			dRightButton.drawButton(g);
			capsLeftButton.drawButton(g);
			shiftLeftButton.drawButton(g);
			ctrlLeftButton.drawButton(g);
			capsRightButton.drawButton(g);
			shiftRightButton.drawButton(g);
			ctrlRightButton.drawButton(g);
			iLeftButton.drawButton(g);
			jLeftButton.drawButton(g);
			kLeftButton.drawButton(g);
			lLeftButton.drawButton(g);
			iRightButton.drawButton(g);
			jRightButton.drawButton(g);
			kRightButton.drawButton(g);
			lRightButton.drawButton(g);
			gLeftButton.drawButton(g);
			vLeftButton.drawButton(g);
			bLeftButton.drawButton(g);
			gRightButton.drawButton(g);
			vRightButton.drawButton(g);
			bRightButton.drawButton(g);
		
		}
	}
	
	private boolean checkControls() {
		
		for (int i = 0; i <= 5; i++) {
			
			for (int j = 1 + i; j <= 6; j++) {
				
				if (p1tempControls[i] == p1tempControls[j]) 
					return false;
				
				
				if (p2tempControls[i] == p2tempControls[j]) 
					return false;
				
			}
		}
		
		return true;
	}
	
	public void saveControls() {
		
		p1controls[0] = p1tempControls[0];
		p1controls[1] = p1tempControls[1];
		p1controls[2] = p1tempControls[2];
		p1controls[3] = p1tempControls[3];
		p1controls[4] = p1tempControls[4];
		p1controls[5] = p1tempControls[5];
		p1controls[6] = p1tempControls[6];
		
		p2controls[0] = p2tempControls[0];
		p2controls[1] = p2tempControls[1];
		p2controls[2] = p2tempControls[2];
		p2controls[3] = p2tempControls[3];
		p2controls[4] = p2tempControls[4];
		p2controls[5] = p2tempControls[5];
		p2controls[6] = p2tempControls[6];
		
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 0) {
				
				p1Up = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 1) {
				
				p1Left = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 2) {
				
				p1Shield = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 3) {
				
				p1Right = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 4) {
				
				p1Jump = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 5) {
				
				p1Attack = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p1tempControls[i] == 6) {
				
				p1Special = i;
				break;
			}
		}
		
		
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 0) {
				
				p2Up = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 1) {
				
				p2Left = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 2) {
				
				p2Shield = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 3) {
				
				p2Right = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 4) {
				
				p2Jump = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 5) {
				
				p2Attack = i;
				break;
			}
		}
		for (int i = 0; i <= 6; i++) {
			
			if (p2tempControls[i] == 6) {
				
				p2Special = i;
				break;
			}
		}
	}
	
	public static int getp1Up() {
		
		return p1keys[p1Up];
	}
	
	public static int getp1Left() {
		
		return p1keys[p1Left];
	}
	
	public static int getp1Shield() {
		
		return p1keys[p1Shield];
	}
	
	public static int getp1Right() {
		
		return p1keys[p1Right];
	}
	
	public static int getp1Jump() {
		
		return p1keys[p1Jump];
	}
	
	public static int getp1Attack() {
		
		return p1keys[p1Attack];
	}
	
	
	public static int getp1Special() {
		
		return p1keys[p1Special];
	}
	
	public static int getp2Up() {
		
		return p2keys[p2Up];
	}
	
	public static int getp2Left() {
		
		return p2keys[p2Left];
	}
	
	public static int getp2Shield() {
		
		return p2keys[p2Shield];
	}
	
	public static int getp2Right() {
		
		return p2keys[p2Right];
	}
	
	public static int getp2Jump() {
		
		return p2keys[p2Jump];
	}
	
	public static int getp2Attack() {
		
		return p2keys[p2Attack];
	}
	
	
	public static int getp2Special() {
		
		return p2keys[p2Special];
	}

}
