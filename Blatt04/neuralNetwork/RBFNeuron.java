package neuralNetwork;

public class RBFNeuron extends Neuron {

	double sigma;
	
	public RBFNeuron(double input, double output, ActivationFunction activationFunction) {
		super(input, output, activationFunction);
		this.sigma = 1;
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

	//sigma initialisiert als 1
	@Override
	public void calculateOuput() {
		output = Math.pow(Math.E, Math.pow(-input, 2)/4);
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
