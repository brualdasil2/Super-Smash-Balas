import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class InputDelayEditor {
	
	private int delay;
	private Button smallPlusButton, smallMinusButton;
	private Game game;
	private SmashPlayer player;
	private int x = 10, y = 360;
	
	public InputDelayEditor(Game game, SmashPlayer player) {
		this.game = game;
		this.player = player;
		delay = 0;
		smallPlusButton = new Button(game, x+100, y+10, 30, 30, Color.DARK_GRAY, ">", Assets.font15, null, true);
		smallMinusButton = new Button(game, x+10, y+10, 30, 30, Color.DARK_GRAY, "<", Assets.font15, null, true);
		
				//Game game, int x, int y, int width, int height, Color c, String name, Font font, BufferedImage image, boolean outline) {
	}


	
	public void tick() {
		if (smallPlusButton.buttonPressed()) {
			delay += 1;
			GameState.screenRefreshManager.setChange(x-50, y-10, 200, 70);

		}
		if (delay > 0) {
			if (smallMinusButton.buttonPressed()) {
				delay -= 1;
				GameState.screenRefreshManager.setChange(x-50, y-10, 200, 70);

			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, 140, 50);
		Text.drawString(g, "" + delay, x+70, y+25, true, Color.black, Assets.font25);
		smallPlusButton.drawButton(g);
		smallMinusButton.drawButton(g);
	}
}
