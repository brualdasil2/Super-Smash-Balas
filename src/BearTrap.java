
import java.awt.Graphics;

public class BearTrap extends Projectile {
	
	private boolean open;
	private int frameCounter;
	private boolean hitting;
	
	public BearTrap(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		image = Assets.bearTrapOpen[owner.character.getSkin()];
		width = 175;
		height = 175;
		
		collisionbox = new Collisionbox(0, 174, 175, 1);
		hitboxes = null;
		
		damage = 10;
		knockbackXspeed = 0;
		knockbackYspeed = 0;
		freezeFrames = 120;
		hitstunFrames = 120;	
		frameCounter = 0;
		open = true;
		hitting = false;
	}
	
	@Override
	public void reflect(Player player) {
	
		
		
	}
	
	@Override
	public void tick() {
		
		updateImage();
		
		if (x + collisionbox.getX() + collisionbox.getWidth() > GameState.smashStageRight) {
			
			x = GameState.smashStageRight - 175;
		}
		
		if (x + collisionbox.getX() < GameState.smashStageLeft) {
			
			x = GameState.smashStageLeft;
		}
		
		if (hitting) {
			
			hitting = false;
		}
		else {
			
			hitboxes = null;
		}
		
		if (!open) {
			
			if (frameCounter > 0) {
				frameCounter--;
			}
			else {
				GameState.projectiles.remove(GameState.projectiles.indexOf(this));
			}
		}
		
		
	
		
	}
	
	@Override
	public void render(Graphics g, boolean showBoxes) {
		
		g.drawImage(image, (int) x, (int) y, width, height, null);
		
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
	}
	
	public boolean getOpen() {
		
		return open;
	}
	
	public void closeTrap() {
		
		image = Assets.bearTrapClosed[owner.character.getSkin()];
		open = false;
		hitboxes = new Hitbox[] {new Hitbox(86, 100, 87)};
		hitting = true;
		frameCounter = 30;
	}
	
	public void disableHitbox() {
		
		hitboxes = null;
	}
	
	public void setFrameCounter(int frames) {
		
		frameCounter = frames;
	}
	
}
