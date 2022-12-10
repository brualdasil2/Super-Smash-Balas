import java.awt.image.BufferedImage;

public abstract class Character {
	
	
	protected Attack standingRight, standingLeft, walkingRight, walkingLeft, jabRight, jabLeft, dashRight, dashLeft, upTiltRight, upTiltLeft, bairRight, bairLeft, fairRight, fairLeft, upAirRight, upAirLeft, sideSpecialRight, sideSpecialLeft, neutralSpecialRight, neutralSpecialLeft, upSpecialRight, upSpecialLeft, shieldingRight, shieldHitRight, shieldingLeft, shieldHitLeft;
	protected AttackFrame parryRight, parryLeft;
	protected int jumpSpeed;
	protected int groundSpeed;
	protected int airSpeed;
	protected int jumps;
	protected int sideSpecialMagic, neutralSpecialMagic, upSpecialMagic;
	protected int skin;
	protected double weight;
	protected BufferedImage stockIcon;
	
	//"IF" = IndividualFrames (animation counter)
	//"UF" = Unique Frames (animation counter)
	protected int walkIF = 0, attackIF = 0;
	protected int walkUF = 0, attackUF = 0;
	protected int dropIF = 0;
	
	public Character(int skin) {
		
		this.skin = skin;
		walkIF = 0; 
		attackIF = 0;
		walkUF = 0;
		attackUF = 0;
		dropIF = 0;
	}
	
	protected abstract void useJab(Player player);
	
	protected abstract void useDash(Player player);
	
	protected abstract void useUpTilt(Player player);
	
	protected abstract void useBair(Player player);
	
	protected abstract void useFair(Player player);
	
	protected abstract void useUpAir(Player player);
	
	protected abstract void useSideSpecial(Player player);
	
	protected abstract void useNeutralSpecial(Player player);
	
	protected abstract void useUpSpecial(Player player);
	
	protected abstract void walk(Player player);
	
	

	
	public void resetAttackCounters() {
		
		walkIF = 0;
		attackIF = 0;
		walkUF = 0;
		attackUF = 0;
		dropIF = 0;
		
	}
	
	public Attack getShieldingRight() {
		
		return shieldingRight;
	}
	
	public Attack getShieldiHitRight() {
		
		return shieldHitRight;
	}
	
	public Attack getShieldingLeft() {
		
		return shieldingLeft;
	}
	
	public Attack getShieldHitLeft() {
		
		return shieldHitLeft;
	}

	public Attack getJabRight() {
		
		return jabRight;
	}
	
	public Attack getJabLeft() {
		
		return jabLeft;
	}
	
	public Attack getDashRight() {
		
		return dashRight;
	}
	
	public Attack getDashLeft() {
		
		return dashLeft;
	}
	
	public Attack getUpTiltRight() {
		
		return upTiltRight;
	}
	
	public Attack getUpTiltLeft() {
		
		return upTiltLeft;
	}
	
	public Attack getBairRight() {
		
		return bairRight;
	}
	
	public Attack getBairLeft() {
		
		return bairLeft;
	}
	
	public Attack getFairRight() {
		
		return fairRight;
	}
	
	public Attack getFairLeft() {
		
		return fairLeft;
	}
	
	public Attack getUpAirRight() {
		
		return upAirRight;
	}
	
	public Attack getUpAirLeft() {
		
		return upAirLeft;
	}
	
	public Attack getSideSpecialRight() {
		
		return sideSpecialRight;
	}
	
	public Attack getSideSpecialLeft() {
		
		return sideSpecialLeft;
	}
	
	public Attack getNeutralSpecialRight() {
		
		return neutralSpecialRight;
	}
	
	public Attack getNeutralSpecialLeft() {
		
		return neutralSpecialLeft;
	}
	
	public Attack getUpSpecialRight() {
		
		return upSpecialRight;
	}
	
	public Attack getUpSpecialLeft() {
		
		return upSpecialLeft;
	}
	
	public Attack getStandingRight() {
		
		return standingRight;
	}
	
	public Attack getStandingLeft() {
		
		return standingLeft;
	}
	
	public Attack getWalkingRight() {
		
		return walkingRight;
	}
	
	public Attack getWalkingLeft() {
		
		return walkingLeft;
	}
	
	public AttackFrame getParryRight() {
		
		return parryRight;
	}
	
	public AttackFrame getParryLeft() {
		
		return parryLeft;
	}
	
	
	public int getJumpSpeed() {
		
		return jumpSpeed;
	}

	public int getGroundSpeed() {
	
		return groundSpeed;
	}
	
	public int getAirSpeed() {
		
		return airSpeed;
	}
	
	public int getJumps() {
		
		return jumps;
	}
	
	public int getSideSpecialMagic() {
		
		return sideSpecialMagic;
	}
	
	public int getNeutralSpecialMagic() {
		
		return neutralSpecialMagic;
	}
	
	public int getUpSpecialMagic() {
		
		return upSpecialMagic;
	}
	
	public int getSkin() {
		
		return skin;
	}
	
	public int getAttackUF() {
		return attackUF;
	}
	
	public int getAttackIF() {
		return attackIF;
	}
}
