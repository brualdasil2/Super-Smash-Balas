import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Projectile {
	
	protected double x, y;
	protected BufferedImage image;
	protected int width, height;
	protected Collisionbox collisionbox;
	protected int damage;
	protected int xSpeed, ySpeed;
	protected Hitbox[] hitboxes;
	protected Player owner;
	protected int knockbackXspeed, knockbackYspeed;
	protected int hitstunFrames, freezeFrames;

	
	
	public Projectile(Player owner, double x, double y, int xSpeed, int ySpeed) {
		
		this.owner = owner;
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	protected abstract void tick();
	
	protected abstract void render(Graphics g, boolean showBoxes);
	
	
	protected void drawCollisionbox(Graphics g) {
		
		g.fillRect((int) x + collisionbox.getX(), (int) y + collisionbox.getY(), collisionbox.getWidth(), collisionbox.getHeight());
	}
	
	protected void showCollisionboxes(boolean show, Graphics g) {
		
		if (show) {
			if (collisionbox != null) {
				g.setColor(new Color(0, 0, 255, 100));
				drawCollisionbox(g);
			}
		}
	}
	
	
	protected void drawHitbox(Graphics g, int centerX, int centerY, int r) {
		
		g.fillOval((int) x + centerX - r, (int) y + centerY - r, 2*r, 2*r);
	}	
	
	protected void drawHitboxes(Graphics g, Hitbox[] hitboxes) {
		
		for (Hitbox hitbox: hitboxes) {
			
			drawHitbox(g, hitbox.getX(), hitbox.getY(), hitbox.getR());
		}
	}

	protected void showHitboxes(boolean show, Graphics g) {
		
		if (show) {
			
			if (hitboxes != null) {
				g.setColor(new Color(255, 0, 0, 100));
				drawHitboxes(g, hitboxes);
			}
		}
		
			
	}
	
	public void updateImage() {
		
		GameState.screenRefreshManager.setChange((int) x - 10, (int) y - 10, width + 20, height + 20);
	}
	
	protected abstract void reflect(Player player);
	
	public double getX() {
		return x;
	}


	public double getY() {
		return y;
	}


	public BufferedImage getImage() {
		return image;
	}


	public int getWidth() {
		return width;
	}


	public int getHeight() {
		return height;
	}


	public Collisionbox getCollisionbox() {
		return collisionbox;
	}


	public int getDamage() {
		return damage;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		
		this.owner = owner;
	}
	
	public Hitbox[] getHitboxes() {
		return hitboxes;
	}
	
	public int getKnockbackXspeed() {
		return knockbackXspeed;
	}
	
	public int getKnockbackYspeed() {
		return knockbackYspeed;
	}
	
	public int getFreezeFrames() {
		return freezeFrames;
	}
	
	public int getHitstunFrames() {
		return hitstunFrames;
	}
	
	public int getXSpeed() {
		return xSpeed;
	}
	





	
	
	
	
}
