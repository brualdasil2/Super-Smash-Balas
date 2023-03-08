import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JFrame;

import basicneuralnetwork.NeuralNetwork;

import com.github.chen0040.rl.actionselection.GibbsSoftMaxActionSelectionStrategy;
import com.github.chen0040.rl.learning.qlearn.QAgent;
import com.github.chen0040.rl.learning.qlearn.QLearner;

public class ScreenTesting {
	
	
	public static int frameWidth = 1280;
	 	public static int frameHeight = 720;

	private static boolean closerToGoal(int oldScore, int newScore) {
		return Math.abs(7 - newScore) < Math.abs(7 - oldScore);
	}
	private static boolean fartherFromGoal(int oldScore, int newScore) {
		return Math.abs(7 - newScore) > Math.abs(7 - oldScore);
	}
	 public static String readFromFile(String filePath) throws IOException {
	        StringBuilder sb = new StringBuilder();
	        BufferedReader br = new BufferedReader(new FileReader(filePath));
	        
	        try {
	            String line = br.readLine();
	            while (line != null) {
	                sb.append(line);
	                sb.append(System.lineSeparator());
	                line = br.readLine();
	            }
	        } finally {
	            br.close();
	        }
	        return sb.toString();
	    }
	
	private static void runAgent() {
		
		String jsonContent = "";
		try {
			jsonContent = readFromFile("Qagent.json");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		QLearner agentLearner = QLearner.fromJson(jsonContent);
		System.out.println("========== SECOND RUN ============");
		QLearner agent = agentLearner;
		int score = 9;
		for (int i = 0; i < 1000; i++) {
			int actionChosen = agent.selectAction(score).getIndex();
			System.out.println("In state " + score + " Chose action " + actionChosen);
			int oldScore = score;
			switch(actionChosen) {
			case 0:
				// do nothing
				break;
			case 1:
				// increase state
				if (score < 9)
					score++;
				break;
			case 2:
				// decrease state
				if (score > 0)
					score--;
				break;
			}
			double reward = 0;
			if (closerToGoal(oldScore, score)) {
				reward = 1;
			}
			else if (fartherFromGoal(oldScore, score)) {
				reward = -2;
			}
			System.out.println("New state is " + score);
		}
	}
	private static void testAgent() {
		QAgent agent = new QAgent(10, 3);
		agent.getLearner().setActionSelection(GibbsSoftMaxActionSelectionStrategy.class.getCanonicalName());
		agent.start(0);
		int score = 0;
		for (int i = 0; i < 1000; i++) {
			int actionChosen = agent.selectAction().getIndex();
			System.out.println("In state " + score + " Chose action " + actionChosen);
			int oldScore = score;
			switch(actionChosen) {
			case 0:
				// do nothing
				break;
			case 1:
				// increase state
				if (score < 9)
					score++;
				break;
			case 2:
				// decrease state
				if (score > 0)
					score--;
				break;
			}
			double reward = 0;
			if (closerToGoal(oldScore, score)) {
				reward = 1;
			}
			else if (fartherFromGoal(oldScore, score)) {
				reward = -2;
			}
			System.out.println("New state is " + score + " Reward is " + reward);
			agent.update(actionChosen, score, reward);
		}
		String agentData = agent.getLearner().toJson();
		try {
			PrintWriter out = new PrintWriter("Qagent.json");
			out.print(agentData);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 	
	
	public static void main (String[] args) {
		
		testAgent();
		//runAgent();
		//Launcher
		//Game game = new Game("Project Balas", frameWidth, frameHeight);	
		//game.start(); //Start thread
		//game.init();
		//NeuralTrainer trainer = new NeuralTrainer(game);
		//trainer.genetic3Types(1000, 20);
	
	}
		
	

}


































