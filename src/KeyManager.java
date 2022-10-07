import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean keys[];
	public boolean up, down, left, right, attack, shield, jump, special, pause, airdash;
	private int playerNumb;
	private static KeyEvent lastKeyPressed;

	
	
	public KeyManager(int playerNumb) {
		
		keys = new boolean[1000];
		this.playerNumb = playerNumb;
	}
	
	public void tick() {
		
		pause = keys[KeyEditState.getPause()];
		
		if (playerNumb == 1) {
			
			up = keys[KeyEditState.getp1Up()];
			left = keys[KeyEditState.getp1Left()];
			right = keys[KeyEditState.getp1Right()];
			attack = keys[KeyEditState.getp1Attack()];
			shield = keys[KeyEditState.getp1Shield()];
			jump = keys[KeyEditState.getp1Jump()];
			special = keys[KeyEditState.getp1Special()];
			airdash = keys[KeyEditState.getp1Airdash()];

		
		}
		
		else if (playerNumb == 2) {
			
			up = keys[KeyEditState.getp2Up()];
			left = keys[KeyEditState.getp2Left()];
			right = keys[KeyEditState.getp2Right()];
			attack = keys[KeyEditState.getp2Attack()];
			shield = keys[KeyEditState.getp2Shield()];
			jump = keys[KeyEditState.getp2Jump()];
			special = keys[KeyEditState.getp2Special()];
			airdash = keys[KeyEditState.getp2Airdash()];
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		keys[e.getKeyCode()] = true;
		lastKeyPressed = e;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		keys[e.getKeyCode()] = false;
		
		
	}
	
	
	public static KeyEvent getLastKeyPressed() {
		return lastKeyPressed;
	}
	public static void clearLastKeyPressed() {
		lastKeyPressed = null;
	}
	

}
