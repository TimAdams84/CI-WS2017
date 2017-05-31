package neuralNetwork;

public class OutputNeuron extends Neuron {
	
	double error;
	
	public OutputNeuron(ActivationFunction activationFunction) {
		super(activationFunction);
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

	public void backpropagate(double expected, double learningRate) {
		error = 1/2 * Math.pow((expected - output),2);
		delta = (expected - output);
		refresh(learningRate);
	}
	
	

}
