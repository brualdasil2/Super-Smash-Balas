
public class Attack {
	
	private AttackFrame frames[];
	private int uniqueFrames;
	private int damage;
	private int knockbackXspeed, knockbackYspeed;
	private int hitstunFrames;
	private int freezeFrames;
	private Collisionbox collisionbox;
	private int baseKnockbackXspeed, baseKnockbackYspeed;
	private int tipperKnockbackXspeed, tipperKnockbackYspeed, tipperDamage;
	
	public Attack(AttackFrame frames[], int uniqueFrames, int damage, int knockbackXspeed, int knockbackYspeed, int freezeFrames, int hitstunFrames, Collisionbox collisionbox) {
		
		this.frames = frames;
		this.uniqueFrames = uniqueFrames;
		this.damage = damage;
		this.knockbackXspeed = knockbackXspeed;
		this.knockbackYspeed = knockbackYspeed;
		this.freezeFrames = freezeFrames;
		this.hitstunFrames = hitstunFrames;
		this.collisionbox = collisionbox;
		this.baseKnockbackXspeed = 0;
		this.baseKnockbackYspeed = 0;
		this.tipperDamage = 0;
		this.tipperKnockbackXspeed = 0;
		this.tipperKnockbackYspeed = 0;
	}
	
	public Attack(AttackFrame frames[], int uniqueFrames, int damage, int knockbackXspeed, int knockbackYspeed, int freezeFrames, int hitstunFrames, Collisionbox collisionbox, int tipperDamage, int tipperKnockbackXspeed, int tipperKnockbackYspeed) {
		
		this.frames = frames;
		this.uniqueFrames = uniqueFrames;
		this.damage = damage;
		this.knockbackXspeed = knockbackXspeed;
		this.knockbackYspeed = knockbackYspeed;
		this.freezeFrames = freezeFrames;
		this.hitstunFrames = hitstunFrames;
		this.collisionbox = collisionbox;
		this.baseKnockbackXspeed = 0;
		this.baseKnockbackYspeed = 0;
		this.tipperDamage = tipperDamage;
		this.tipperKnockbackXspeed = tipperKnockbackXspeed;
		this.tipperKnockbackYspeed = tipperKnockbackYspeed;
	}
	
	public Attack(AttackFrame frames[], int uniqueFrames, int damage, int knockbackXspeed, int knockbackYspeed, int freezeFrames, int hitstunFrames, Collisionbox collisionbox, int baseKnockbackXspeed, int baseKnockbackYspeed) {
		
		this.frames = frames;
		this.uniqueFrames = uniqueFrames;
		this.damage = damage;
		this.knockbackXspeed = knockbackXspeed;
		this.knockbackYspeed = knockbackYspeed;
		this.freezeFrames = freezeFrames;
		this.hitstunFrames = hitstunFrames;
		this.collisionbox = collisionbox;
		this.baseKnockbackXspeed = baseKnockbackXspeed;
		this.baseKnockbackYspeed = baseKnockbackYspeed;
		this.tipperDamage = 0;
		this.tipperKnockbackXspeed = 0;
		this.tipperKnockbackYspeed = 0;
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
	
	public int getTipperDamage() {
		
		return tipperDamage;
	}
	
	public int getTipperKnockbackXspeed() {
		
		return tipperKnockbackXspeed;
	}

	public int getTipperKnockbackYspeed() {
	
		return tipperKnockbackYspeed;
	}
	
	public int getBaseKnockbackXspeed() {
		
		return baseKnockbackXspeed;
	}

	public int getBaseKnockbackYspeed() {
	
		return baseKnockbackYspeed;
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
