import java.awt.image.BufferedImage;

public class HitEffect {
	
	

	private BufferedImage image;
	private int x, y, width = 64, height = 64;
	private int frameCounter;
	private boolean big = false;
	
	public HitEffect(BufferedImage image) {
		
		this.image = image;
	}
	
	
	public void startHitEffect(int x, int y) {
		
		this.frameCounter = 10;
		this.x = x;
		this.y = y;
		big = false;
	}
	public void startHitEffect(int x, int y, boolean big) {
		
		this.frameCounter = 10;
		this.x = x;
		this.y = y;
		this.big = big;
	}

	
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public int getWidth() {
		if (big)
			return width*8;
		return width;
	}
	
	public int getHeight() {
		if (big)
			return height*8;
		return height;
	}
	
	public BufferedImage getImage() {
		
		return image;
	}


	public int getFrameCounter() {
		return frameCounter;
	}
	
	public void decreaseFrameCounter() {
		
		frameCounter--;
	}
	
	public void resetFrameCounter() {
		
		frameCounter = 0;
		big = false;
	}

	
}
