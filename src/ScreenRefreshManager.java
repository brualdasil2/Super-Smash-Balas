import java.awt.Graphics;

public class ScreenRefreshManager {
	
	private boolean[][] grid = new boolean[80][45];
	private boolean update = true;
	
	public ScreenRefreshManager() {
		
	}
	
	public void setChange(int x, int y, int width, int height) {
		
		update = true;
		
		int leftSquare = (x >= 0)? x/16: 0;
		int rightSquare = (x + width < 1280)? (x + width)/16: 79;
		int topSquare = (y >= 0)? y/16: 0;
		int bottomSquare = (y + height < 720)? (y + height)/16: 44;
		
		
		
		
		for (int i = leftSquare; i <= rightSquare; i++) {
			
			for (int j = topSquare; j <= bottomSquare; j++) {
				
				grid[i][j] = true;
			}
		}
		
	}
	
	public void reset() {
		
		update = true;
		
		for (int i = 0; i <= 79; i++) {
			
			for (int j = 0; j <= 44; j++) {
				
				grid[i][j] = true;
			}
		}
	}
	
	public void render(Graphics g, int map) {
		
		if (update) {
			
			update = false;
			
			for (int i = 0; i <= 79; i++) {
				
				for (int j = 0; j <= 44; j++) {
					
					if (grid[i][j]) {
						
						grid[i][j] = false;
						g.clearRect(i*16, j*16, 16, 16);
						
						switch(map) {
						
						case 1: 
							g.drawImage(Assets.candyLand[i][j], i*16, j*16, null); 
							break;
						case 2:
							g.drawImage(Assets.enchantedForest[i][j], i*16, j*16, null); 
							break;
						case 3:
							g.drawImage(Assets.dojo[i][j], i*16, j*16, null); 
							break;
						case 4:
							g.drawImage(Assets.ship[i][j], i*16, j*16, null); 
						}
							
					}
				}
			}
			
		}
	}
	
	
}
