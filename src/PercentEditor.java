import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PercentEditor {
	
	private int percent;
	private Button smallPlusButton, bigPlusButton, smallMinusButton, bigMinusButton;
	private Game game;
	
	public PercentEditor(Game game) {
		this.game = game;
		percent = 0;
		smallPlusButton = new Button(game, 1080, 25, 30, 30, Color.DARK_GRAY, ">", Assets.font15, null, true);
		bigPlusButton = new Button(game, 1110, 25, 30, 30, Color.DARK_GRAY, ">>", Assets.font15, null, true);
		smallMinusButton = new Button(game, 990, 25, 30, 30, Color.DARK_GRAY, "<", Assets.font15, null, true);
		bigMinusButton = new Button(game, 960, 25, 30, 30, Color.DARK_GRAY, "<<", Assets.font15, null, true);
		
				//Game game, int x, int y, int width, int height, Color c, String name, Font font, BufferedImage image, boolean outline) {
	}
	
	private SmashPlayer getBotPlayer() {
		return ((GameState)(game.getGameState())).getSmashPlayer2();
	}
	
	public void resetBotPercent() {
		getBotPlayer().setPercent(percent);
	}
	
	public void tick() {
		if (smallPlusButton.buttonPressed()) {
			percent += 1;
			GameState.screenRefreshManager.setChange(900, 20, 200, 70);
			getBotPlayer().setPercent(percent);
		}
		if (bigPlusButton.buttonPressed()) {
			percent += 10;
			GameState.screenRefreshManager.setChange(900, 20, 200, 70);
			getBotPlayer().setPercent(percent);
		}
		if (percent > 0) {
			if (smallMinusButton.buttonPressed()) {
				percent -= 1;
				GameState.screenRefreshManager.setChange(900, 20, 200, 70);
				getBotPlayer().setPercent(percent);
			}
		}
		if (percent > 9) {
			if (bigMinusButton.buttonPressed()) {
				percent -= 10;
				GameState.screenRefreshManager.setChange(900, 20, 200, 70);
				getBotPlayer().setPercent(percent);
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(950, 15, 200, 50);
		Text.drawString(g, percent + "%", 1050, 40, true, Color.black, Assets.font25);
		smallPlusButton.drawButton(g);
		bigPlusButton.drawButton(g);
		smallMinusButton.drawButton(g);
		bigMinusButton.drawButton(g);
	}
	
	public int getPercent() {
		return percent;
	}
}
