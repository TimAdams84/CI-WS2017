package neuralNetwork;

public class InputNeuron extends Neuron {

	public InputNeuron(ActivationFunction activationFunction) {
		super(activationFunction);
	}

	public void calculateOuput() {
		output = input;
	}

	@Override
	public void backpropagate(double learningRate) {
		//super.backpropagate(learningRate);
	}

	@Override
	public void refresh(double learningRate) {
		//super.refresh(learningRate);
	}

	public void setInput(double input) {
		this.input = input;
	}
	
}
