
import java.awt.Graphics;

public class Rosa extends Projectile {
	
	private int frameCounter;
	
	public Rosa(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		image = Assets.rosa[owner.character.getSkin()];
		width = 100;
		height = 100;
		
		collisionbox = new Collisionbox(30, 0, 50, 100);
		hitboxes = new Hitbox[] {new Hitbox(55, 30, 35),
								 new Hitbox(50, 60, 20),
								 new Hitbox(45, 80, 20)};
		
		damage = 16;
		knockbackXspeed = 0;
		knockbackYspeed = -12;
		freezeFrames = 7;
		hitstunFrames = 40;	
		frameCounter = 480;
	}
	
	@Override
	public void reflect(Player player) {
		
		GameState.projectiles.remove(GameState.projectiles.indexOf(this));
		
		
	}
	
	@Override
	public void tick() {
		
		updateImage();
		
		if (x + collisionbox.getX() + collisionbox.getWidth() > GameState.smashStageRight) {
			
			x = GameState.smashStageRight - 100;
		}
		
		if (x + collisionbox.getX() < GameState.smashStageLeft) {
			
			x = GameState.smashStageLeft;
		}
		
		if (frameCounter > 0)
			frameCounter--;
		
		if (frameCounter == 0)
			GameState.projectiles.remove(GameState.projectiles.indexOf(this));
			
		
	//	System.out.println(frameCounter);
		
		
		
		
	}
	
	@Override
	public void render(Graphics g, boolean showBoxes) {
		
		g.drawImage(image, (int) x, (int) y, width, height, null);
		
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
	}
	
	public int getFrameCounter() {
		
		return frameCounter;
	}

	
	
	
	
}
