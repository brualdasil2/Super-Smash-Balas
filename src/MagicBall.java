import java.awt.Graphics;
import java.util.Random;

public class MagicBall {
	
	private double x, y;
	private int r = 16;
	private boolean visible = false, grabbable = false;
	private int frameCounter, spawnCounter;


	
	public MagicBall() {
		frameCounter = (int) (600 + GameState.random.nextDouble()*300);
	}
	
	private void respawnMagicBall() {
		
		x = 640;
		y = (int) (GameState.floorY - 460 + GameState.random.nextDouble() * 444);
	
		 
	}
	
	private boolean isCollidingWithPlayer(SmashPlayer p) {
		boolean isColliding = false;
		if (p.currentFrame.getHurtboxes() == null) {
			return false;
		}
		for(Hurtbox hurtbox: p.currentFrame.getHurtboxes()) {
			
			if ((Math.pow((double) ((GameState.magicBall.getX()) - (hurtbox.getX() + p.x)), 2) + Math.pow((double) ((GameState.magicBall.getY()) - (hurtbox.getY() + p.y)), 2)) < Math.pow((double) (GameState.magicBall.getR() + hurtbox.getR()), 2)) {
				isColliding = true;
			}
		}
		return isColliding;
	}

	private void grabBall(SmashPlayer p) {
		p.increaseMagic(3);
		grab();
		SoundManager.play("sounds/Magic.wav", false);
	}
	
	public void tick(SmashPlayer p1, SmashPlayer p2){
		
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
		
		if (grabbable) {
			boolean p1collide = isCollidingWithPlayer(p1);
			boolean p2collide = isCollidingWithPlayer(p2);
			if (p1collide && !p2collide) {
				grabBall(p1);
			}
			else if (p2collide && !p1collide) {
				grabBall(p2);
			}
			else if (p1collide && p2collide) {
				if (p1.shield >= p2.shield) {
					grabBall(p1);
				}
				else {
					grabBall(p2);
				}
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
		frameCounter = (int) (600 +  GameState.random.nextDouble()*300);
	}
	

}
