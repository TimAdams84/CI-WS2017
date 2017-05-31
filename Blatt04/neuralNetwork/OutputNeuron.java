package neuralNetwork;

public class OutputNeuron extends Neuron {
	
	double error;
	
	public OutputNeuron(double input, double output,
			ActivationFunction activationFunction) {
		super(activationFunction);
		// TODO Auto-generated constructor stub
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
		delta = activationFunction.differentiate(input)*(expected - output);
	}
	
	

}
