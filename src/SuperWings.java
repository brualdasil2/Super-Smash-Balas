
import java.awt.Graphics;

public class SuperWings extends Projectile {
	
	private int frameCounter;
	
	public SuperWings(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		frameCounter = 900;
		hitboxes = null;
	}
	
	@Override
	public void reflect(Player player) {
		
	
	}
	
	@Override
	public void tick() {
		

		
		if (frameCounter > 0)
			frameCounter--;
		
		if (frameCounter == 0) {
			
			GameState.projectiles.remove(GameState.projectiles.indexOf(this));
			((Carol)(owner.character)).endSuper();
			owner.jumps = 2;
		}
			

	}
	
	@Override
	public void render(Graphics g, boolean showBoxes) {
		
	
	}

	
	
	
	
}
