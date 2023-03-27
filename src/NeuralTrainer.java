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

	
	private int playGameToLearn(NeuralBot p1, NeuralBot p2, int nGames) {
		int p1Fitness = 0;
		int totalTicks = 0;
		int biggestTicks = 0;
		for (int i = 0; i < nGames; i++) {
			simulator.init(p1, p2);
			int ticksAtStart = totalTicks;
			while(simulator.isFighting()) {
				int currentState = p1.getCurrentState();
				simulator.tick();
				int newState = p1.getCurrentState();
				//int reward = XX.
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
	
	private int p1FitnessSimulatedVsPool(NeuralBot p1, NeuralBot p2, String type) {
		int p1Wins = 0;
		int p2Wins = 0;
		int p1Fitness = 0;
		int totalTicks = 0;
		int biggestTicks = 0;
		boolean timedOut = false;
		for (int i = 0; i < 1; i++) {
			simulator.init(p1, p2);
			int ticksAtStart = totalTicks;
			while(simulator.isFighting()) {
				simulator.tick();
				totalTicks++;
				if (totalTicks - ticksAtStart > 30000) {
					timedOut = true;
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
			int damageWeight = 1;
			int comboWeight = 1;
			int punishWeight = 1;
			int shieldWeight = 1;
			int centerWeight = 1;
			int closeWeight = 1;
			
			switch(type) {
				case "ATK":
					damageWeight = 3;
					comboWeight = 15;
					punishWeight = 10;
					shieldWeight = 1;
					closeWeight = 200;
					centerWeight = 50;
					break;
				case "DEF":
					damageWeight = 1;
					comboWeight = 5;
					punishWeight = 15;
					shieldWeight = 15;
					closeWeight = 50;
					centerWeight = 200;
					break;
				case "NEU":
					damageWeight = 1;
					comboWeight = 8;
					punishWeight = 5;
					shieldWeight = 3;
					closeWeight = 100;
					centerWeight = 100;
					break;
			}
			p1Fitness += simulator.getP1DamageDealt()*damageWeight +
					     simulator.getP1DamageOnCombo()*comboWeight +
					     simulator.getP1DamageOnPunish()*punishWeight +
					     simulator.getP1DamageShielded()*shieldWeight +
					     (double)simulator.getCloseTicks()/(totalTicks - ticksAtStart)*closeWeight;
			p1Fitness += (p1.getScore() - p2.getScore())*50;
			p1Fitness += (double)simulator.getP1CenterTicks()/(totalTicks - ticksAtStart)*centerWeight;
			if (timedOut) {
				p1Fitness -= 2000;
			}
		}
		//System.out.println("P1 wins: " + p1Wins);
		//System.out.println("P2 wins: " + p2Wins);
		//System.out.println("Average ticks: " + (double)totalTicks/nGames);
		//System.out.println("Most ticks: " + biggestTicks);
		return p1Fitness;
	}
	
	private int randomRecentGen(int thisGen) {
		return thisGen - ((int)(Math.random()*(5)) + 2);
	}
	private int randomOldGen(int thisGen) {
		return (int)(Math.random()*(thisGen-1-4)) + 1;
	}
	private int randomGen(int thisGen) {
		return (int)(Math.random()*(thisGen-1)) + 1;
	}
	private int randomRank(int populationSize) {
		return (int)(Math.random()*populationSize) + 1;
	}
	private String randomType() {
		int typeNumb = (int)(Math.random()*3);
		switch (typeNumb) {
			case 0:
				return "ATK";
			case 1:
				return "DEF";
			case 2:
				return "NEU";
		}
		return "NEU";
	}
	
	private NeuralNetwork getFromPool(int thisGen, int populationSize) {
		int randGen;
		if (thisGen > 10) {
			double chanceOfRecent;
			if (thisGen < 50) {
				chanceOfRecent = 0.5;
			}
			if (thisGen < 200) {
				chanceOfRecent = 0.4;
			}
			else if (thisGen < 1000) {
				chanceOfRecent = 0.2;
			}
			else {
				chanceOfRecent = 0.1;
			}
			if (Math.random() < chanceOfRecent) {
				randGen = randomRecentGen(thisGen);
			}
			else {
				randGen = randomOldGen(thisGen);
			}
		}
		else {
			randGen = randomGen(thisGen);
		}
		int randRank = randomRank(populationSize);
		String randType = randomType();
		System.out.println("Random gen from pool: " + randGen + " " + randType);
		return NeuralNetwork.readFromFile("./neural_networks/" + randType + "/gen" + randGen + "/rank" + randRank + ".json");
	}
	
	private void calculateFitnessVsPool(Brain[] population, int thisGeneration, String type) {
		int totalGames = 0;
		for (int j = 0; j < 10; j++) {
			NeuralNetwork p2Network = getFromPool(thisGeneration, population.length);
			for (int i = 0; i < population.length; i++) {
				NeuralBot p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200, population[i]);
				Brain p2Brain = new Brain(p2Network);
				NeuralBot p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200, p2Brain);
				int p1Fitness = p1FitnessSimulatedVsPool(p1, p2, type);
				population[i].incrementFitness(p1Fitness);
				totalGames++;
				if (totalGames%10 == 0) {
					System.out.println("Total games: " + totalGames);
				}
			}
		}
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
	
	private void calculateFitness(Brain[] population, String type) {
		int totalGames = 0;
		for (int i = 0; i < population.length; i++) {
			for (int j = i+1; j < population.length; j++) {
				NeuralBot p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200, population[i]);
				NeuralBot p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200, population[j]);
				int p1Fitness = p1FitnessSimulatedVsPool(p1, p2, type);
				population[i].incrementFitness(p1Fitness);
				//population[j].incrementFitness(-p1Fitness);
				totalGames++;
				if (totalGames%100 == 0) {
					System.out.println("Total games: " + totalGames);
				}
			}
		}
	}
	
	private void initRandomPopulation(Brain[] population) {
		for (int i = 0; i < population.length; i++) {
			NeuralNetwork randomNetwork = new NeuralNetwork(11, 3, 20, 27);
			population[i] = new Brain(randomNetwork);
		}
	}
	
	private void initPopulationFromFile(Brain[] population, int generation, String type) {
		for (int i = 0; i < population.length; i++) {
			NeuralNetwork fileNetwork = NeuralNetwork.readFromFile("./neural_networks/" + type + "/gen" + generation + "/rank" + (i+1) + ".json");
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
	
	public void genetic3Types(int nGenerations, int startGeneration) {
		int populationSize = 100;
		Brain[] populationATK = new Brain[populationSize];
		Brain[] populationDEF = new Brain[populationSize];
		Brain[] populationNEU = new Brain[populationSize];
		Brain[][] populations = {
				populationATK,
				populationDEF,
				populationNEU
		};
		ArrayList<Brain> newPopulation;
		int genNumber = startGeneration + 1;
		String types[] = {"ATK", "DEF", "NEU"};
		
		if (startGeneration == 0) {			
			initRandomPopulation(populationATK);
			initRandomPopulation(populationDEF);
			initRandomPopulation(populationNEU);
		}
		else {
			initPopulationFromFile(populationATK, startGeneration, "ATK");
			initPopulationFromFile(populationDEF, startGeneration, "DEF");
			initPopulationFromFile(populationNEU, startGeneration, "NEU");
		}
		
		for (int i = startGeneration; i < nGenerations; i++) {
			for (int p = 0; p < 3; p++) {		
				if (i == 0) {
					calculateFitness(populations[p], types[p]); 
					QuickSort.quickSort(populations[p], 0, populationSize-1);
					Brain originalBestBrain = populations[p][0];
					Brain originalWorstBrain = populations[p][populationSize-1];
					System.out.println("Gen " + genNumber + " best fitness: " + originalBestBrain.getFitness());
					System.out.println("Gen " + genNumber + " worst fitness: " + originalWorstBrain.getFitness());
					int totalFitness = 0;
					for (Brain b : populations[p]) {
						totalFitness += b.getFitness();
					}
					System.out.println("Gen " + genNumber + " average fitness: " + (double)totalFitness/populationSize);
					for (int k = 0; k < populations[p].length; k++) {
						populations[p][k].getNetwork().writeToFile("./neural_networks/" + types[p] + "/gen" + genNumber + "/rank" + (k+1));
					}
				}
				if (i != startGeneration) {				
					calculateFitnessVsPool(populations[p], genNumber, types[p]); 
					QuickSort.quickSort(populations[p], 0, populationSize-1);
					Brain originalBestBrain = populations[p][0];
					Brain originalWorstBrain = populations[p][populationSize-1];
					System.out.println("Gen " + genNumber + " best fitness: " + originalBestBrain.getFitness());
					System.out.println("Gen " + genNumber + " worst fitness: " + originalWorstBrain.getFitness());
					int totalFitness = 0;
					for (Brain b : populations[p]) {
						totalFitness += b.getFitness();
					}
					System.out.println("Gen " + genNumber + " average fitness: " + (double)totalFitness/populationSize);
					for (int k = 0; k < populations[p].length; k++) {
						populations[p][k].getNetwork().writeToFile("./neural_networks/" + types[p] + "/gen" + genNumber + "/rank" + (k+1));
					}
				}
				
				newPopulation = new ArrayList<Brain>();
				while(newPopulation.size() < populationSize) {
					Brain[] selected = new Brain[2];
					selected = selectIndividuals(populations[p]);
					Brain[] sons = new Brain[2];
					sons = doubleCrossover(selected[0], selected[1]);
					double mutationRate;
					if (genNumber < 20) {
						mutationRate = 0.3;
					}
					else if (genNumber < 50) {
						mutationRate = 0.25;
					}
					else if (genNumber < 100) {
						mutationRate = 0.2;
					}
					else {
						mutationRate = 0.1;
					}
					sons[0].getNetwork().mutate(mutationRate);
					sons[1].getNetwork().mutate(mutationRate);
					newPopulation.add(sons[0]);
					newPopulation.add(sons[1]);
					//System.out.println("New pop is: " + newPopulation.size());
				}
				Brain[] newPopArray = new Brain[populationSize];
				for (int j = 0; j < populationSize; j++) {
					newPopArray[j] = newPopulation.get(j);
				}
				populations[p] = newPopArray;
			}
			genNumber++;
		
		}
		
		//p1 = new NeuralBot(game, 1, new Bruno(0), 240, GameState.floorY - 200);
		//p2 = new NeuralBot(game, 2, new Bruno(1), 840, GameState.floorY - 200);
		//int p1Fitness = p1FitnessSimulatedN(p1, p2, 5);
		//System.out.println("P1 final fitness: " + p1Fitness);
	}
	/*
	public void genetic(int nGenerations, int startGeneration) {
		int populationSize = 100;
		Brain[] population = new Brain[populationSize];	
		ArrayList<Brain> newPopulation;
		int genNumber = startGeneration + 1;
		
		if (startGeneration == 0) {			
			initRandomPopulation(population);
		}
		else {
			//initPopulationFromFile(population, startGeneration);
		}
		
		for (int i = startGeneration; i < nGenerations; i++) {
			if (i == 0) {
				//calculateFitness(population); 
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
			if (i != startGeneration) {				
				calculateFitnessVsPool(population, genNumber); 
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
	}*/
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
