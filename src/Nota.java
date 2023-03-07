import java.awt.Graphics;

public class Nota extends Projectile {
	
	private int yAcceleration;
	
	public Nota(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		super(owner, x, y, xSpeed, ySpeed);
		
		image = Assets.nota[(int)(GameState.random.nextDouble()*5)];
		width = 64;
		height = 64;
		
		collisionbox = new Collisionbox(0, 0, 64, 64);
		hitboxes = new Hitbox[] {new Hitbox(37, 25, 28),
								 new Hitbox(12, 52, 16)};
		
		damage = 4;
		knockbackXspeed = 10;
		knockbackYspeed = -12;
		freezeFrames = 7;
		hitstunFrames = 25;	
		
		yAcceleration = 2;
		
		switch((int)(Math.random()*5)) {
		
		case 0:
			SoundManager.play("sounds/Note1.wav", false);
			break;
		case 1:
			SoundManager.play("sounds/Note2.wav", false);
			break;
		case 2:
			SoundManager.play("sounds/Note3.wav", false);
			break;
		case 3:
			SoundManager.play("sounds/Note4.wav", false);
			break;
		case 4:
			SoundManager.play("sounds/Note5.wav", false);
			break;
		}
		
	}
	
	private void changeYacceleration() {
		
		if (yAcceleration == 2) {
			
			yAcceleration = -2;
		}
		else if (yAcceleration == -2) {
			
			yAcceleration = 2;
		}
	}

	@Override
	protected void tick() {
		
		updateImage();
		
		x += xSpeed;
		y += ySpeed;
		
		
		ySpeed += yAcceleration;
		
		if (ySpeed == 15 || ySpeed == -15) {
			
			changeYacceleration();
		}
		
		if (x + collisionbox.getX() + collisionbox.getWidth() > GameState.rightWall || x + collisionbox.getX() < GameState.leftWall || y + collisionbox.getY() + collisionbox.getHeight() > GameState.floorY) {
			
			GameState.projectiles.remove(GameState.projectiles.indexOf(this));
		}
		
	}

	@Override
	protected void render(Graphics g, boolean showBoxes) {
		
		g.drawImage(image, (int) x, (int) y, width, height, null);
		
		showHitboxes(showBoxes, g);
		showCollisionboxes(false, g);
	}

	@Override
	protected void reflect(Player player) {
		
		xSpeed = -xSpeed;
		owner = player;
	}

}
