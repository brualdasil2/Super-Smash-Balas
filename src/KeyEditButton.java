import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class KeyEditButton {
	
	private int x, y, width, height;
	private Game game;
	public static boolean leftPressed;
	private Color c;
	private String key;
	private int keyCode;
	private BufferedImage image;
	private boolean outline;
	private Font font;
	private boolean waitingKey;
	
	private String convertKeyToChar(int key) {
		switch(key) {
			case KeyEvent.VK_SPACE:
				return "ESPAÇO";
			case KeyEvent.VK_RIGHT:
				return ">";
			case KeyEvent.VK_LEFT:
				return "<";
			case KeyEvent.VK_UP:
				return "^";
			case KeyEvent.VK_DOWN:
				return "v";
			default:
				return "NO_DISPLAY";
		}
	}
	
	public KeyEditButton(Game game, int x, int y, int width, int height, String initialKey, int initialKeyCode) {
		
		this.game = game;
		this.c = Color.gray;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.key = initialKey;
		this.font = Assets.font15;
		this.outline = true;
		this.waitingKey = false;
		this.keyCode = initialKeyCode;
	}

	
	public void tick() {
		if (buttonPressed()) {
			if (!waitingKey) {
				waitingKey = true;
				setColor(Color.LIGHT_GRAY);
				KeyEditState.rerender();
				KeyManager.clearLastKeyPressed();
			}
			else {
				waitingKey = false;
				setColor(Color.gray);
				KeyEditState.rerender();
				
			}
			
		}
		if (waitingKey) {
			if (KeyManager.getLastKeyPressed() != null)
				if (KeyManager.getLastKeyPressed().getKeyChar() + "" != key) {
					keyCode = KeyManager.getLastKeyPressed().getKeyCode();
					String keyText = convertKeyToChar(keyCode);
					if (keyText == "NO_DISPLAY") {
						key = ("" + KeyManager.getLastKeyPressed().getKeyChar()).toUpperCase();
					}
					else {
						key = keyText;
					}
					KeyEditState.rerender();
					waitingKey = false;
					setColor(Color.gray);
				}
		}
	}
	
	
	public boolean buttonPressed() {
		
	
		if (!game.getMouseManager().getLeftPressed()){
			
			leftPressed = false;
		}
		
		if (game.getMouseManager().getMouseX() >= x && game.getMouseManager().getMouseX() <= x + width) {
			
			if (game.getMouseManager().getMouseY() >= y && game.getMouseManager().getMouseY() <= y + height) {
				
				if (!leftPressed) {
					
					if (game.getMouseManager().getLeftPressed()) {
						
						leftPressed = true;
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
	public void drawButton(Graphics g) {
		
		if (c != null) {
			
			g.setColor(c);
			g.fillRect(x, y, width, height);
		}
		
		if (image != null)
			g.drawImage(image, x, y, width, height, null);
		
		if (outline) {
			g.setColor(Color.black);
			g.drawRect(x, y, width, height);
		}
		
		if (key != null)
			Text.drawString(g, key,x + width/2, y + height/2, true, Color.white, font);
	}
	
	public void setColor(Color c) {
		
		this.c = c;
	}
	
	public int getKeyCode() {
		return keyCode;
	}

	
}
