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
	private int spareFrames = 1;
	private int prevHitstun = 1;
	private int displaySpareFrames = 0;
	
	public ComboCounter() {

	}
	public void reset() {
		comboCounter = 0;
		playerComboed = 0;
		comboDamage = 0;
		delayFramesCounter = 0;
		displayComboCounter = 0;
		displayComboDamage = 0;
		spareFrames = 1;
		prevHitstun = 1;
		displaySpareFrames = 0;
		GameState.screenRefreshManager.setChange(1180, 0, 70, 150);
	}
	
	private void countDelayFrames() {
		if (delayFramesCounter > 0) {
			delayFramesCounter--;
			if (delayFramesCounter == 0) {
				displayComboDamage = 0;
				displayComboCounter = 0;
				GameState.screenRefreshManager.setChange(1180, 0, 70, 150);
			}
		}
	}
	private void countSpareFrames() {
		if (spareFrames <= 0 && spareFrames > -30) {
			spareFrames--;
		}
	}
	
	private void endCombo() {
		comboCounter = 0;
		playerComboed = 0;
		comboDamage = 0;
		delayFramesCounter = 120;
		spareFrames = 0;
		prevHitstun = 0;
		GameState.screenRefreshManager.setChange(1180, 0, 70, 150);
	}
	
	private void checkIfHit(Player player) {
		int playerHealth;
		if (player.playerNumb == 1)
			playerHealth = p1Health;
		else
			playerHealth = p2Health;
		
		if (playerHealth - player.getHealth() > 1000) {
			endCombo();
			return;
		}
		if (player.getHealth() < playerHealth) {
			GameState.screenRefreshManager.setChange(1180, 0, 70, 150);
			playerComboed = (player.playerNumb);
			comboDamage += (playerHealth - player.getHealth());
			displayComboDamage = comboDamage;
			comboCounter++;
			displayComboCounter = comboCounter;
			delayFramesCounter = 0;
			if (prevHitstun > 0) {
				spareFrames = prevHitstun - 1;
			}
			if (spareFrames > -30) {
				displaySpareFrames = spareFrames;
			}
			else {
				displaySpareFrames = 0;
			}
				
		}
	}
	
	public void tick(Player p1, Player p2) {
		
		countDelayFrames();
		countSpareFrames();
		
		checkIfHit(p1);
		checkIfHit(p2);
		
		//System.out.println(spareFrames);

		if (playerComboed != 0) {
			if (playerComboed == 1) {
				prevHitstun = p1.getHitstunFrames();
				if (p1.getHitstunFrames() == 1) {
					endCombo();
				}
			}
			else if (playerComboed == 2) {
				prevHitstun = p2.getHitstunFrames();
				if (p2.getHitstunFrames() == 1) {
					endCombo();
				}
			}
		}
		
		p1Health = p1.getHealth();
		p2Health = p2.getHealth();
	}
	
	public void render(Graphics g) {
		
		Text.drawString(g, "COMBO:", 1210, 20, true, Color.black, Assets.font10);
		if (delayFramesCounter > 0) {
			Text.drawString(g, String.valueOf(displayComboCounter), 1210, 50, true, Color.black, Assets.font30);
			Text.drawString(g, "DANO: " + String.valueOf(displayComboDamage), 1210, 80, true, Color.black, Assets.font15);
			if (displaySpareFrames != 0) {			
				Text.drawString(g, "" + (displaySpareFrames > 0 ? "+" : "") + displaySpareFrames, 1210, 100, true, Color.black, Assets.font15);
			}
		}
		else {
			Text.drawString(g, String.valueOf(comboCounter), 1210, 50, true, Color.black, Assets.font30);
			if (comboDamage > 0) {
				Text.drawString(g, "DANO: " + String.valueOf(displayComboDamage), 1210, 80, true, Color.black, Assets.font15);
				if (displaySpareFrames != 0) {			
					Text.drawString(g, "" + (displaySpareFrames > 0 ? "+" : "") + displaySpareFrames, 1210, 100, true, Color.black, Assets.font15);
				}
			}
		}
		
		
	}
	
	public int getCount() {
		return comboCounter;
	}
}
