import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import basicneuralnetwork.NeuralNetwork;

public class NeuralTrainer {
	private SimulationState simulator;
	//private NeuralBot p1, p2;
	private Game game;
	
	public NeuralTrainer(Game game) {
		simulator = new SimulationState(game);
		this.game = game;
	}

	
	private int p1FitnessSimulatedN(NeuralBot p1, NeuralBot p2, int nGames) {
		int p1Wins = 0;
		int p2Wins = 0;
		int p1Fitness = 0;
		int totalTicks = 0;
		int biggestTicks = 0;
		for (int i = 0; i < nGames; i++) {
			//System.out.println("Simulating game " + i);
			//p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200);
			//p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200);
			simulator.init(p1, p2);
			int ticksAtStart = totalTicks;
			while(simulator.isFighting()) {
				simulator.tick();
				totalTicks++;
				if (totalTicks - ticksAtStart > 30000) {
					break;
				}
			}
			int ticksAtEnd = totalTicks;
			int ticksInThisGame = ticksAtEnd - ticksAtStart;
			if (ticksInThisGame > biggestTicks) {
				biggestTicks = ticksInThisGame;
			}
			int winner = simulator.getWinner();
			//System.out.println("Winner: " + winner);
			if (winner == 1) {
				p1Wins++;
			}
			else if (winner == 2) {
				p2Wins++;
			}
			p1Fitness += simulator.getP1DamageDealt() - simulator.getP2DamageDealt();
			p1Fitness += (p1.getScore() - p2.getScore())*50;
		}
		//System.out.println("P1 wins: " + p1Wins);
		//System.out.println("P2 wins: " + p2Wins);
		//System.out.println("Average ticks: " + (double)totalTicks/nGames);
		//System.out.println("Most ticks: " + biggestTicks);
		return p1Fitness;
	}
	
	private int p1FitnessSimulatedVsBot(NeuralBot p1, SmashPlayer p2, int nGames) {
		int p1Wins = 0;
		int p2Wins = 0;
		int p1Fitness = 0;
		int totalTicks = 0;
		int biggestTicks = 0;
		for (int i = 0; i < nGames; i++) {
			//System.out.println("Simulating game " + i);
			//p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200);
			//p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200);
			simulator.init(p1, p2);
			int ticksAtStart = totalTicks;
			while(simulator.isFighting()) {
				simulator.tick();
				totalTicks++;
				if (totalTicks - ticksAtStart > 30000) {
					break;
				}
			}
			int ticksAtEnd = totalTicks;
			int ticksInThisGame = ticksAtEnd - ticksAtStart;
			if (ticksInThisGame > biggestTicks) {
				biggestTicks = ticksInThisGame;
			}
			int winner = simulator.getWinner();
			//System.out.println("Winner: " + winner);
			if (winner == 1) {
				p1Wins++;
			}
			else if (winner == 2) {
				p2Wins++;
			}
			p1Fitness += simulator.getP1DamageDealt() - simulator.getP2DamageDealt();
			p1Fitness += (p1.getScore() - p2.getScore())*50;
		}
		//System.out.println("P1 wins: " + p1Wins);
		//System.out.println("P2 wins: " + p2Wins);
		//System.out.println("Average ticks: " + (double)totalTicks/nGames);
		//System.out.println("Most ticks: " + biggestTicks);
		return p1Fitness;
	}
	
	private void calculateFitnessVsBot(Brain[] population) {
		int totalGames = 0;
		for (int i = 0; i < population.length; i++) {
			NeuralBot p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200, population[i]);
			SmashPlayer p2 = new SmashBrunoBotHard(game, 2, new Bruno(1), 840, GameState.floorY - 200);
			int p1Fitness = p1FitnessSimulatedVsBot(p1, p2, 5);
			population[i].incrementFitness(p1Fitness);
			totalGames++;
			if (totalGames%10 == 0) {
				System.out.println("Total games: " + totalGames);
			}
		}
	}
	
	private void calculateFitness(Brain[] population) {
		int totalGames = 0;
		for (int i = 0; i < population.length; i++) {
			for (int j = i+1; j < population.length; j++) {
				NeuralBot p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200, population[i]);
				NeuralBot p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200, population[j]);
				int p1Fitness = p1FitnessSimulatedN(p1, p2, 1);
				population[i].incrementFitness(p1Fitness);
				population[j].incrementFitness(-p1Fitness);
				totalGames++;
				if (totalGames%100 == 0) {
					System.out.println("Total games: " + totalGames);
				}
			}
		}
	}
	
	private void initRandomPopulation(Brain[] population) {
		for (int i = 0; i < population.length; i++) {
			NeuralNetwork randomNetwork = new NeuralNetwork(45, 2, 16, 8);
			population[i] = new Brain(randomNetwork);
		}
	}
	
	private void initPopulationFromFile(Brain[] population, int generation) {
		for (int i = 0; i < population.length; i++) {
			NeuralNetwork fileNetwork = NeuralNetwork.readFromFile("./neural_networks/gen" + generation + "/rank" + (i+1) + ".json");
			population[i] = new Brain(fileNetwork);
		}
	}
	
	private int randomIndexGaussian(int n) {
        Random rand = new Random();
        double gaussianSum = 0;
        double[] probabilities = new double[n];
        
        // calculate probabilities for each integer from 0 to n-1
        for (int i = 0; i < n; i++) {
            double x = (double)i / (double)n;
            probabilities[i] = Math.exp(-Math.pow(x, 2) / 0.08);
            gaussianSum += probabilities[i];
        }
        
        // normalize probabilities to add up to 1
        for (int i = 0; i < n; i++) {
            probabilities[i] /= gaussianSum;
        }
        
        // choose a random integer based on the probabilities
        double r = rand.nextDouble();
        double cumulativeProbability = 0;
        for (int i = 0; i < n; i++) {
            cumulativeProbability += probabilities[i];
            if (r <= cumulativeProbability) {
                return i;
            }
        }
        
        // in case of rounding errors, return the last index
        return n - 1;
    }
	
	private Brain[] selectIndividuals(Brain[] population) {
		int index1 = randomIndexGaussian(population.length);
		int index2 = randomIndexGaussian(population.length);
		Brain[] selected = new Brain[2];
		selected[0] = population[index1];
		selected[1] = population[index2];
		return selected;
	}
	
	private Brain[] doubleCrossover(Brain brain1, Brain brain2) {
		NeuralNetwork son1, son2;
		son1 = brain1.getNetwork().merge(brain2.getNetwork());
		Brain son1Brain = new Brain(son1);
		son2 = brain2.getNetwork().merge(brain1.getNetwork());
		Brain son2Brain = new Brain(son2);
		Brain[] sons = new Brain[2];
		sons[0] = son1Brain;
		sons[1] = son2Brain;
		return sons;
	}
	
	public void genetic(int nGenerations, int startGeneration) {
		int populationSize = 100;
		Brain[] population = new Brain[populationSize];	
		ArrayList<Brain> newPopulation;
		int genNumber = startGeneration + 1;
		
		if (startGeneration == 0) {			
			initRandomPopulation(population);
		}
		else {
			initPopulationFromFile(population, startGeneration);
		}
		
		for (int i = startGeneration; i < nGenerations; i++) {
			if (i != startGeneration) {				
				calculateFitnessVsBot(population); 
				QuickSort.quickSort(population, 0, populationSize-1);
				Brain originalBestBrain = population[0];
				Brain originalWorstBrain = population[populationSize-1];
				System.out.println("Gen " + genNumber + " best fitness: " + originalBestBrain.getFitness());
				System.out.println("Gen " + genNumber + " worst fitness: " + originalWorstBrain.getFitness());
				int totalFitness = 0;
				for (Brain b : population) {
					totalFitness += b.getFitness();
				}
				System.out.println("Gen " + genNumber + " average fitness: " + (double)totalFitness/populationSize);
				for (int k = 0; k < population.length; k++) {
					population[k].getNetwork().writeToFile("./neural_networks/gen" + genNumber + "/rank" + (k+1));
				}
			}
			
			newPopulation = new ArrayList<Brain>();
			while(newPopulation.size() < populationSize) {
				Brain[] selected = new Brain[2];
				selected = selectIndividuals(population);
				Brain[] sons = new Brain[2];
				sons = doubleCrossover(selected[0], selected[1]);
				sons[0].getNetwork().mutate(0.05);
				sons[1].getNetwork().mutate(0.05);
				newPopulation.add(sons[0]);
				newPopulation.add(sons[1]);
				//System.out.println("New pop is: " + newPopulation.size());
			}
			Brain[] newPopArray = new Brain[populationSize];
			for (int j = 0; j < populationSize; j++) {
				newPopArray[j] = newPopulation.get(j);
			}
			population = newPopArray;
			genNumber++;
		
		}
		
		//p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200);
		//p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200);
		//int p1Fitness = p1FitnessSimulatedN(p1, p2, 5);
		//System.out.println("P1 final fitness: " + p1Fitness);
	}
	/*
	public void runGames() {
		int nGames = 10;
		int p1Wins = 0;
		int p2Wins = 0;
		int totalTicks = 0;
		int biggestTicks = 0;
		for (int i = 0; i < nGames; i++) {
			System.out.println("Simulating game " + i);
			p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200);
			p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200);
			simulator.init(p1, p2);
			int ticksAtStart = totalTicks;
			while(simulator.isFighting()) {
				simulator.tick();
				totalTicks++;
				if (totalTicks - ticksAtStart > 30000) {
					break;
				}
			}
			int ticksAtEnd = totalTicks;
			int ticksInThisGame = ticksAtEnd - ticksAtStart;
			if (ticksInThisGame > biggestTicks) {
				biggestTicks = ticksInThisGame;
			}
			int winner = simulator.getWinner();
			System.out.println("Winner: " + winner);
			if (winner == 1) {
				p1Wins++;
			}
			else if (winner == 2) {
				p2Wins++;
			}
		}
		System.out.println("P1 wins: " + p1Wins);
		System.out.println("P2 wins: " + p2Wins);
		System.out.println("Average ticks: " + (double)totalTicks/nGames);
		System.out.println("Most ticks: " + biggestTicks);
	}
	*/
}
