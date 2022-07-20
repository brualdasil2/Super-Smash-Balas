
public class Attack {
	
	private AttackFrame frames[];
	private int uniqueFrames;
	private int damage;
	private int knockbackXspeed, knockbackYspeed;
	private int hitstunFrames;
	private int freezeFrames;
	private Collisionbox collisionbox;
	
	public Attack(AttackFrame frames[], int uniqueFrames, int damage, int knockbackXspeed, int knockbackYspeed, int freezeFrames, int hitstunFrames, Collisionbox collisionbox) {
		
		this.frames = frames;
		this.uniqueFrames = uniqueFrames;
		this.damage = damage;
		this.knockbackXspeed = knockbackXspeed;
		this.knockbackYspeed = knockbackYspeed;
		this.freezeFrames = freezeFrames;
		this.hitstunFrames = hitstunFrames;
		this.collisionbox = collisionbox;
	}
	
	
	
	public AttackFrame[] getFrames() {
		
		return frames;
	}
	
	public int getUniqueFrames() {
		
		return uniqueFrames;
	}
	
	public int getDamage() {
		
		return damage;
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
	
	public Collisionbox getCollisionbox() {
		
		return collisionbox;
	}
	
	public void setDamage(int damage) {
		
		this.damage = damage;
	}
	
	public void setKnockbackXSpeed(int xSpeed) {
		this.knockbackXspeed = xSpeed;
	}
	
	public void setKnockbackYSpeed(int ySpeed) {
		this.knockbackYspeed = ySpeed;
	}
}

