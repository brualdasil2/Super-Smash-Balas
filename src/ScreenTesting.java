import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

import basicneuralnetwork.NeuralNetwork;

public class ScreenTesting {
	
	
	public static int frameWidth = 1280;
	 	public static int frameHeight = 720;

	    
	 	
	
	public static void main (String[] args) {
		
		
		//Launcher
		Game game = new Game("Project Balas", frameWidth, frameHeight);	
		game.start(); //Start thread
		//game.init();
		//NeuralTrainer trainer = new NeuralTrainer(game);
		//trainer.genetic3Types(1000, 20);
	
	}
		
	

}


































