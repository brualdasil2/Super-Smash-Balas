import java.awt.Graphics;

public class Bala extends Projectile {
	
	public Bala(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		image = Assets.bala;
		width = 64;
		height = 64;
		
		collisionbox = new Collisionbox(0, 18, 64, 28);
		hitboxes = new Hitbox[] {new Hitbox(32, 32, 15),
								 new Hitbox(55, 32, 10),
								 new Hitbox(9, 32, 10)};
		
		damage = 15;
		knockbackXspeed = 10;
		knockbackYspeed = -10;
		freezeFrames = 7;
		hitstunFrames = 20;	
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
