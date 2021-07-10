import java.awt.image.BufferedImage;

public class HitEffect {
	
	

	private BufferedImage image;
	private int x, y, width = 64, height = 64;
	private int frameCounter;
	
	public HitEffect(BufferedImage image) {
		
		this.image = image;
	}
	
	
	public void startHitEffect(int x, int y) {
		
		this.frameCounter = 10;
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
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
	}

	
}
