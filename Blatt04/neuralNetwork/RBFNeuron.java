package neuralNetwork;

public class RBFNeuron extends Neuron {

	double sigma;
	
	public RBFNeuron(double input, double output, double sigma, ActivationFunction activationFunction) {
		super(input, output, activationFunction);
		this.sigma = sigma;
	}

	@Override
	public void addInConnection(Neuron from, double weight) {
		// TODO Auto-generated method stub
		super.addInConnection(from, weight);
	}

	@Override
	public void addOutConnection(Neuron to, double weight) {
		// TODO Auto-generated method stub
		super.addOutConnection(to, weight);
	}

	@Override
	public void calculateOuput() {
		// TODO Auto-generated method stub
		super.calculateOuput();
	}

	@Override
	public void backpropagate(double learningRate) {
		// TODO Auto-generated method stub
		super.backpropagate(learningRate);
	}

	@Override
	public void refresh(double learningRate) {
		// TODO Auto-generated method stub
		super.refresh(learningRate);
	}

}
