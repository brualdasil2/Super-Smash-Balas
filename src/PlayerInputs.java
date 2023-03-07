
public class PlayerInputs implements Cloneable {
	private boolean pressingJump;
	private boolean pressingAttack;
	private boolean pressingSpecial;
	private boolean pressingUp;
	private boolean pressingShield;
	private boolean pressingAirdash;
	private boolean pressingLeft;
	private boolean pressingRight;
	private boolean keyPressingLeft;
	private boolean keyPressingRight;
	private Game game;
	
	public Object clone()   
	{  
		//shallow copy  
		try   
		{  
			return super.clone();  
		}   
		catch (CloneNotSupportedException e)   
		{  
			return null;  
		}  
	}  
	
	
	public PlayerInputs(Game game) {
		this.game = game;
	}
	
	public void setPlayerInputs(int playerNumb) {
		pressingJump = game.getKeyManager(playerNumb).jump;
		pressingAttack = game.getKeyManager(playerNumb).attack;
		pressingSpecial = game.getKeyManager(playerNumb).special;
		pressingUp = game.getKeyManager(playerNumb).up;
		pressingShield = game.getKeyManager(playerNumb).shield;
		pressingAirdash = game.getKeyManager(playerNumb).airdash;
		boolean wasPressingLeft = keyPressingLeft;
		boolean wasPressingRight = keyPressingRight;
		keyPressingLeft = game.getKeyManager(playerNumb).left;
		keyPressingRight = game.getKeyManager(playerNumb).right;

		
		if (keyPressingLeft && keyPressingRight) {
			if (wasPressingLeft && !wasPressingRight) {
				pressingRight = true;
				pressingLeft = false;
			}
			else if (wasPressingRight && !wasPressingLeft) {
				pressingLeft = true;
				pressingRight = false;
			}
		}
		else {
			pressingLeft = keyPressingLeft;
			pressingRight = keyPressingRight;
		}
	}

	public void setInputsFalse() {
		pressingJump = false;
		pressingAttack = false;
		pressingSpecial = false;
		pressingUp = false;
		pressingShield = false;
		pressingAirdash = false;
		keyPressingLeft = false;
		keyPressingRight = false;
	}
	public boolean isPressingJump() {
		return pressingJump;
	}
	public boolean isPressingAttack() {
		return pressingAttack;
	}

	public boolean isPressingSpecial() {
		return pressingSpecial;
	}

	public boolean isPressingUp() {
		return pressingUp;
	}

	public boolean isPressingShield() {
		return pressingShield;
	}

	public boolean isPressingAirdash() {
		return pressingAirdash;
	}

	public boolean isPressingLeft() {
		return pressingLeft;
	}

	public boolean isPressingRight() {
		return pressingRight;
	}

}
