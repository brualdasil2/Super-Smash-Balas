
public class Hitbox {
	
	private int x, y, r;
	private boolean tipper;
	
	public Hitbox(int x, int y, int r) {
		
		this.x = x;
		this.y = y;
		this.r = r;
		this.tipper = false;
	}
	public Hitbox(int x, int y, int r, boolean tipper) {
		
		this.x = x;
		this.y = y;
		this.r = r;
		this.tipper = tipper;
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}

	public int getR() {
	
		return r;
	}
	
	public boolean isTipper() {
		return tipper;
	}
	
}
