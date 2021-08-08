import java.awt.image.BufferedImage;

public class AttackFrame {
	
	private int duration;
	private BufferedImage image;
	private Hitbox hitboxes[];
	private Hurtbox hurtboxes[];
	private Counterbox counterboxes[];
	private int width, height;
	private int xOffset, yOffset;
	
	
	
	public AttackFrame(int duration, BufferedImage image, Hurtbox hurtboxes[], Hitbox hitboxes[], int width, int height) {
		
		this.duration = duration;
		this.image = image;
		this.hurtboxes = hurtboxes;
		this.hitboxes = hitboxes;
		this.width = width;
		this.height = height;
		this.xOffset = 0;
		this.yOffset = 0;
		this.counterboxes = null;
	}
	
	public AttackFrame(int duration, BufferedImage image, Hurtbox hurtboxes[], Hitbox hitboxes[], int width, int height, int xOffset, int yOffset) {
		
		this.duration = duration;
		this.image = image;
		this.hurtboxes = hurtboxes;
		this.hitboxes = hitboxes;
		this.width = width;
		this.height = height;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.counterboxes = null;
	}
	
	public AttackFrame(int duration, BufferedImage image, Hurtbox hurtboxes[], Counterbox counterboxes[], Hitbox hitboxes[], int width, int height) {
		
		this.duration = duration;
		this.image = image;
		this.counterboxes = counterboxes;
		this.hurtboxes = null;
		this.hitboxes = hitboxes;
		this.width = width;
		this.height = height;
		this.xOffset = 0;
		this.yOffset = 0;
	}

	
	public int getDuration() {
		
		return duration;
	}
	
	public BufferedImage getImage() {
		
		return image;
	}
	
	
	
	public Hitbox[] getHitboxes() {
		
		return hitboxes;
	}
	
	public Hurtbox[] getHurtboxes() {
		
		return hurtboxes;
	}
	
	public Counterbox[] getCounterboxes() {
		
		return counterboxes;
	}
	
	public int getWidth() {
		
		return width;
	}
	
	public int getHeight() {
		
		return height;
	}
	
	public int getXOffset() {
		
		return xOffset;
	}
	
	public int getYOffset() {
		
		return yOffset;
	}
}
