import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Target {
	
	private int x, y;
	private int width;
	private int height;
	private BufferedImage image;
	private Hurtbox hurtbox;
	private Player player;
	private boolean alive = true;
	private int frame;

	
	
	public Target(int x, int y, Player player) {
		
		this.x = x;
		this.y = y;
		width = 75;
		height = 75;
		frame = 0;
		image = Assets.target[0];
		hurtbox = new Hurtbox(37, 37, 38);
		this.player = player;
	}

	
	
	public boolean checkHit() {
		
		if (player.getCurrentFrame().getHitboxes() != null) {
			for (Hitbox hitbox: player.getCurrentFrame().getHitboxes()) {
				
				if ((Math.pow((double) ((hitbox.getX() + player.getX()) - (hurtbox.getX() + x)), 2) + Math.pow((double) ((hitbox.getY() + player.getY()) - (hurtbox.getY() + y)), 2)) < Math.pow((double) (hitbox.getR() + hurtbox.getR()), 2)) {
					
					return true;
				}
			}
		}
		
		if (!GameState.projectiles.isEmpty()) {
			for (int i = GameState.projectiles.size() - 1; i >= 0; i--) {
				if (GameState.projectiles.get(i).getHitboxes() != null) {
					for (Hitbox hitbox: GameState.projectiles.get(i).getHitboxes()) {
						if ((Math.pow((double) ((hitbox.getX() + GameState.projectiles.get(i).getX()) - (hurtbox.getX() + x)), 2) + Math.pow((double) ((hitbox.getY() + GameState.projectiles.get(i).getY()) - (hurtbox.getY() + y)), 2)) < Math.pow((double) (hitbox.getR() + hurtbox.getR()), 2)) {
							
							GameState.projectiles.remove(i);
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	private void respawn() {
		
		x = (int)(Math.random()*1205);
		
		if (player.character instanceof Lacerda)
			y = (int)(Math.random()*575) + 20;
		else if (player.character instanceof Obino)
			y = (int)(Math.random()*460) + 135;
		else
			y = (int)(Math.random()*595);
		frame = 0;
		image = Assets.target[0];
		alive = true;
	}
	
	public void tick() {
		
		GameState.screenRefreshManager.setChange((int) x - 10, (int) y - 10, width + 20, height + 20);
		
		if (checkHit()) {
			
			if (alive) {
				
				alive = false;
				TargetState.hitEffect.startHitEffect((int) x + hurtbox.getX() - GameState.hitEffect.getWidth()/2, (int) y + hurtbox.getY() - GameState.hitEffect.getHeight()/2);
				SoundManager.play("sounds/PunchHit.wav", false);
				TargetState.increaseScore();
				GameState.screenRefreshManager.setChange(1190, 0, 70, 80);
			}
		}
		
		if (!alive) {
			
			frame++;
			
			if (frame/5 <= 3) {
				
				image = Assets.target[frame/5];
			}
			else {
				
				respawn();
			}
		}
		
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(image, x, y, width, height, null);
		
	}
}
