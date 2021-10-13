import java.awt.Graphics;

public class SnowBall extends Projectile {
	
	int bounceCounter = 0;
	
	public SnowBall(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		image = Assets.snowBall;
		width = 32;
		height = 32;
		
		collisionbox = new Collisionbox(0, 0, 32, 32);
		hitboxes = new Hitbox[] {new Hitbox(15, 16, 16)};
		
		damage = 5;
		knockbackXspeed = 0;
		knockbackYspeed = 0;
		freezeFrames = 7;
		hitstunFrames = 20;	
	}
	
	@Override
	public void reflect(Player player) {
		
		xSpeed = -xSpeed;
		owner = player;
	}
	
	@Override
	public void tick() {
		
		updateImage();
		
		x += xSpeed;
		y += ySpeed;
		
		
		
		if (x + collisionbox.getX() + collisionbox.getWidth() > GameState.rightWall || x + collisionbox.getX() < GameState.leftWall) {
			
			xSpeed = -xSpeed;
		}
		
		if (y + collisionbox.getY() + collisionbox.getHeight() > GameState.floorY && ((x + collisionbox.getX() < GameState.smashStageRight && x + collisionbox.getX() + collisionbox.getWidth() > GameState.smashStageLeft))) {
			
			ySpeed = -ySpeed;
			bounceCounter++;
		}
		
		ySpeed += GameState.GRAVITY;
		
		if (bounceCounter == 6) {
			
			GameState.projectiles.remove(GameState.projectiles.indexOf(this));
		}
		
		
		

		/*
		if (x + collisionbox.getX() + collisionbox.getWidth() > GameState.rightWall || x + collisionbox.getX() < GameState.leftWall || y + collisionbox.getY() + collisionbox.getHeight() > GameState.floorY) {
			
			
		}*/
		
		
		
		
	}
	
	@Override
	public void render(Graphics g, boolean showBoxes) {
		
		g.drawImage(image, (int) x, (int) y, width, height, null);
		
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
	}

	
	
	
	
}
