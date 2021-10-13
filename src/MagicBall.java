import java.awt.Graphics;

public class MagicBall {
	
	private double x, y;
	private int r = 16;
	private boolean visible = false, grabbable = false;
	private int frameCounter, spawnCounter;
	
	public MagicBall() {
		
		frameCounter = (int) (600 + Math.random()*300);
	}
	
	
	
	
	private void respawnMagicBall() {
		
		x = 640;
		y = (int) (GameState.floorY - 460 + Math.random() * 444);
	
		 
	}
	

	
	public void tick(){
		
		if (frameCounter > 0) {
			
			frameCounter--;
		}
		if (frameCounter == 0) {
			
			if (!visible) {
				
				respawnMagicBall();
				visible = true;
				spawnCounter = 180;
			}
			
			if (spawnCounter > 0) {
				
				spawnCounter--;
			}
			else {
				
				grabbable = true;
			}
			
		}
		
	}
	
	public void render(Graphics g){
		
		if (visible) {
			
			if ((spawnCounter > 30 && spawnCounter <= 60) || (spawnCounter > 90 && spawnCounter <= 120) || (spawnCounter > 150)) {
				
				g.drawImage(Assets.magicBall[1], (int) x - r, (int) y - r, 2*r, 2*r, null);
				GameState.screenRefreshManager.setChange((int) x - r, (int) y - r, 2*r, 2*r);
			}
			
			if (spawnCounter == 0) {
				
				g.drawImage(Assets.magicBall[0], (int) x - r, (int) y - r, 2*r, 2*r, null);
				GameState.screenRefreshManager.setChange((int) x - r, (int) y - r, 2*r, 2*r);
			}
		}
		
	}
	
	public boolean getGrabbable() {
		
		return grabbable;
	}
	
	public double getX() {
		
		return x;
	}
	
	public double getY() {
		
		return y;
	}
	
	public double getR() {
		
		return r;
	}
	
	public void grab() {
		
		grabbable = false;
		visible = false;
		frameCounter = (int) (600 + Math.random()*300);
	}
	

}
