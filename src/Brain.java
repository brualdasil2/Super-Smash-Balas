import basicneuralnetwork.NeuralNetwork;

public class Brain {
	private NeuralNetwork network;
	private int fitness;
	
	public Brain(NeuralNetwork network) {
		this.network = network;
		fitness = 0;
	}
	
	public void incrementFitness(int fitness) {
		this.fitness += fitness;
	}
	public int getFitness() {
		return fitness;
	}
	
	public NeuralNetwork getNetwork() {
		return network;
	}
}
