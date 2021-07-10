import java.awt.*;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.awt.color.*;

public class Game implements Runnable {
	
	private Display display;
	private int height, width;
	private String title;
	private boolean running = false;
	
	private boolean slow = false;
	
	private Thread gameThread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState, menuState, characterSelectState, keyEditState, chooseBotState, minigamesState, targetState, survivalState;
	
	private KeyManager keyManager1;
	private KeyManager keyManager2;
	
	private MouseManager mouseManager;
	
	
	public Game (String title, int width, int height) {
		
		this.height = height;
		this.width = width;
		this.title = title;
				
		keyManager1 = new KeyManager(1);
		keyManager2 = new KeyManager(2);
		
		mouseManager = new MouseManager();
			
		

	}
	
	
	
	private void init() {
		
		display = new Display(title, width, height);
		
		display.getFrame().addKeyListener(keyManager1);
		display.getFrame().addKeyListener(keyManager2);
		
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		AttackCreator.createAttacks1();
		AttackCreator.createAttacks2();
		
	
		gameState = new GameState(this);
		menuState = new MenuState(this);
		characterSelectState = new CharacterSelectState(this);
		keyEditState = new KeyEditState(this);
		chooseBotState = new ChooseBotState(this);
		minigamesState = new MinigamesState(this);
		targetState = new TargetState(this);
		survivalState = new SurvivalState(this);
		
		((KeyEditState)(keyEditState)).init();
		((KeyEditState)(keyEditState)).saveControls();
		
		State.setState(menuState);
		((MenuState)(menuState)).init();
		
		//State.setState(gameState);
		//((GameState)(gameState)).init(1, 4, false);
		
		
	}
	
	//Update variables
	private void tick() {
		
		keyManager1.tick();
		keyManager2.tick();
		if (State.getState() != null)
			State.getState().tick();
		
		
		
	}
	
	//Print on screen
	private void render() {
		
		//sets buffers
		
		bs = display.getCanvas().getBufferStrategy();

		if (bs == null) {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    GraphicsDevice gs = ge.getDefaultScreenDevice();
		    GraphicsConfiguration gc = gs.getDefaultConfiguration();
		    
		    
		    display.getCanvas().createBufferStrategy(2);
		    
			return;
		}
		
		
		
		g = bs.getDrawGraphics();
		
		
		//clears screen
		
		
		
		//Start Draw
		
		
		if (State.getState() != null)
			State.getState().render(g);
		
		
		
		//End Draw
		
		g.dispose();
		bs.show();
		
		//Toolkit.getDefaultToolkit().sync();
		
	}
	
	public void run() {
		
		init();
		
		int tickFPS = 60;
		int renderFPS = 60;
		double timePerTick = 1000000000 / tickFPS;
		double timePerRender = 1000000000/renderFPS;
		long now;
		long lastTick = System.nanoTime();
		long lastRender = System.nanoTime();
		
		boolean skipTick = false;
		boolean skipRender = false;
		
		
		while(running) {
			
			try {
				now = System.nanoTime();
				
				if (now - lastTick >= timePerTick) {
					
					if (slow) {
						
						if (!skipTick) {
							
							tick();
							skipTick = true;
						}
						else {
							
							skipTick = false;
						}
					}
					else {
						
						tick();
					}
					
					lastTick = now;
				}
				
				if (now - lastRender >= timePerRender) {
					
					//long realRenderFPS = 1000000000/(System.nanoTime() - lastRender);
					//System.out.println("FPS: " + realRenderFPS);
					
					//display.getFrame().repaint();
					
					if (slow) {
						
						if (!skipRender) {
							
							render();
							skipRender = true;
						}
						else {
							
							skipRender = false;
						}
					}
					else {
						
						render();
					}
					
					lastRender = now;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(int playerNumb) {
		
		if (playerNumb == 1)
			return keyManager1;
		else if (playerNumb == 2)
			return keyManager2;
		else 
			return null;
	}
	
	public MouseManager getMouseManager() {
		
		return mouseManager;
	}
	
	public Display getDisplay() {
		
		return display;
	}
	
	public State getGameState() {
		
		return gameState;
	}
	
	public State getMenuState() {
		
		return menuState;
	}
	
	public State getCharacterSelectState() {
		
		return characterSelectState;
	}
	
	public State getKeyEditState() {
		
		return keyEditState;
	}
	
	public State getChooseBotState() {
		
		return chooseBotState;
	}
	
	public State getMinigamesState() {
		
		return minigamesState;
	}
	
	public State getTargetState() {
		
		return targetState;
	}
	
	public State getSurvivalState() {
		
		return survivalState;
	}
	
	public void setSlow(boolean slow) {
		
		this.slow = slow;
	}
	
	//Starts thread
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		gameThread = new Thread(this);
		gameThread.start(); //Goes to "run()"
	}
	
	//Ends thread
	public synchronized void stop() {
		if (!running)
			return;
		
		running = false;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
