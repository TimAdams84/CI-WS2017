package neuralNetwork;

public class RBFNeuron extends Neuron {

	double sigma;

	public RBFNeuron(ActivationFunction activationFunction) {
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

	//sigma initialisiert als 1
	@Override
	public void calculateOuput() {
		input = 0;
		for (Connection connection : inConnections) {
			input = Math.pow((connection.from.output-connection.weight),2);
		}
		input = Math.sqrt(input);
		output = Math.pow(Math.E, -Math.pow(input, 2)/4);
	}
}
