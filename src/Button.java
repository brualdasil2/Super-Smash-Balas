import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button {
	
	private int x, y, width, height;
	private Game game;
	public static boolean leftPressed;
	private Color c;
	private String name;
	private BufferedImage image;
	private boolean outline;
	private Font font;
	
	public Button(Game game, int x, int y, int width, int height, Color c, String name, Font font, BufferedImage image, boolean outline) {
		
		this.game = game;
		this.c = c;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.name = name;
		this.font = font;
		this.image = image;
		this.outline = outline;
		
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
		
		if (name != null)
			Text.drawString(g, name,x + width/2, y + height/2, true, Color.white, font);
	}
	
	public void setColor(Color c) {
		
		this.c = c;
	}
	
	
	
	
	
}
