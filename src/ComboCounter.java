import java.awt.Color;
import java.awt.Graphics;

public class ComboCounter {
	
	private int comboCounter = 0;
	private int p1Health = 0, p2Health = 0;
	private int playerComboed = 0;
	private int comboDamage = 0;
	private int delayFramesCounter = 0;
	private int displayComboCounter = 0;
	private int displayComboDamage = 0;
	
	public ComboCounter() {

	}
	
	private void countDelayFrames() {
		if (delayFramesCounter > 0) {
			delayFramesCounter--;
			if (delayFramesCounter == 0) {
				displayComboDamage = 0;
				displayComboCounter = 0;
				GameState.screenRefreshManager.setChange(1180, 0, 70, 120);
			}
		}
	}
	
	private void endCombo() {
		comboCounter = 0;
		playerComboed = 0;
		comboDamage = 0;
		delayFramesCounter = 120;
		GameState.screenRefreshManager.setChange(1180, 0, 70, 120);
	}
	
	public void tick(Player p1, Player p2) {
		
		countDelayFrames();
		
		if (playerComboed != 0) {
			if (playerComboed == 1) {
				if (p1.getHitstunFrames() == 0) {
					endCombo();
				}
			}
			else if (playerComboed == 2) {
				if (p2.getHitstunFrames() == 0) {
					endCombo();
				}
			}
		}
		
		if (p1.getHealth() < p1Health) {
			GameState.screenRefreshManager.setChange(1180, 0, 70, 120);
			playerComboed = 1;
			comboDamage += (p1Health - p1.getHealth()); 
			comboCounter++;
		}
		else if (p2.getHealth() < p2Health) {
			GameState.screenRefreshManager.setChange(1180, 0, 70, 120);
			playerComboed = 2;
			comboDamage += (p2Health - p2.getHealth()); 
			displayComboDamage = comboDamage;
			comboCounter++;
			displayComboCounter = comboCounter;
		}

		
		p1Health = p1.getHealth();
		p2Health = p2.getHealth();
		
	}
	
	public void render(Graphics g) {
		
		Text.drawString(g, "COMBO:", 1210, 20, true, Color.black, Assets.font10);
		if (delayFramesCounter > 0) {
			Text.drawString(g, String.valueOf(displayComboCounter), 1210, 50, true, Color.black, Assets.font30);
			Text.drawString(g, "DANO: " + String.valueOf(displayComboDamage), 1210, 80, true, Color.black, Assets.font15);
		}
		else {
			Text.drawString(g, String.valueOf(comboCounter), 1210, 50, true, Color.black, Assets.font30);
			if (comboDamage > 0) {
				Text.drawString(g, "DANO: " + String.valueOf(displayComboDamage), 1210, 80, true, Color.black, Assets.font15);
			}
		}

	}
}
