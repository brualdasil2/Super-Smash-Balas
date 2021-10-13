import java.awt.Graphics;

public class Halls extends Projectile {

	public Halls(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		image = Assets.halls;
		width = 32;
		height = 32;
		
		collisionbox = new Collisionbox(0, 9, 32, 18);
		hitboxes = new Hitbox[] {new Hitbox(16, 16, 9),
				 				 new Hitbox(24, 16, 9),
				 				 new Hitbox(8, 16, 9)};
		
		damage = 5;
		knockbackXspeed = 2;
		knockbackYspeed = -5;
		freezeFrames = 15;
		hitstunFrames = 25;	
	}
	
	@Override
	public void reflect(Player player) {
		
		xSpeed = -xSpeed;
		ySpeed = 0;
		owner = player;
	}
	

	@Override
	public void tick() {
		
		updateImage();
		
		x += xSpeed;
		y += ySpeed;
		
		ySpeed += GameState.GRAVITY;
		
		if (x + collisionbox.getX() + collisionbox.getWidth() > GameState.rightWall || x + collisionbox.getX() < GameState.leftWall || (y + collisionbox.getY() + collisionbox.getHeight() > GameState.floorY && ((x + collisionbox.getX() < GameState.smashStageRight && x + collisionbox.getX() + collisionbox.getWidth() > GameState.smashStageLeft)))) {
			
			GameState.projectiles.remove(GameState.projectiles.indexOf(this));
		}
		
		
		
	}

	@Override
	public void render(Graphics g, boolean showBoxes) {
		
		g.drawImage(image, (int) x, (int) y, width, height, null);
		
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
	}

}
