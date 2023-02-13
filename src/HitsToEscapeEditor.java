import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HitsToEscapeEditor {
	
	private int hits;
	private Button smallPlusButton, smallMinusButton;
	private Game game;
	private int x = 10, y = 360;
	
	public HitsToEscapeEditor(Game game) {
		this.game = game;
		hits = 1;
		smallPlusButton = new Button(game, x+100, y+10, 30, 30, Color.DARK_GRAY, ">", Assets.font15, null, true);
		smallMinusButton = new Button(game, x+10, y+10, 30, 30, Color.DARK_GRAY, "<", Assets.font15, null, true);
		
				//Game game, int x, int y, int width, int height, Color c, String name, Font font, BufferedImage image, boolean outline) {
	}
	
	private SmashPlayer getBotPlayer() {
		return ((GameState)(game.getGameState())).getSmashPlayer2();
	}

	
	public void tick() {
		if (smallPlusButton.buttonPressed()) {
			hits += 1;
			GameState.screenRefreshManager.setChange(x-50, y-10, 200, 70);
			((SmashTrainingBot)(getBotPlayer())).setHitsToEscape(hits);
		}
		if (hits > 1) {
			if (smallMinusButton.buttonPressed()) {
				hits -= 1;
				GameState.screenRefreshManager.setChange(x-50, y-10, 200, 70);
				((SmashTrainingBot)(getBotPlayer())).setHitsToEscape(hits);
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, 140, 50);
		Text.drawString(g, "" + hits, x+70, y+25, true, Color.black, Assets.font25);
		Text.drawString(g, "Hits para escapar", x, y+80, false, Color.black, Assets.font20);
		smallPlusButton.drawButton(g);
		smallMinusButton.drawButton(g);
	}
}
