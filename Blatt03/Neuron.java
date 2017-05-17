
public class Neuron {

	// input gewichtsvektor
	private double inputWeight;
	private double outputWeight;

	private double tempOutput;

	private ActivationFunction activationFunction;

	public Neuron(double inputWeight, double outputWeight, ActivationFunction activationFunction) {
		this.inputWeight = inputWeight;
		this.outputWeight = outputWeight;
		this.activationFunction = activationFunction;
		tempOutput = 0;
	}

	public void forwardPropagation(double input) {
		input *= inputWeight;
		// funktion
		tempOutput += input;
	}

	public double getInputWeight() {
		return inputWeight;
	}

	public double getOutput() {
		return activationFunction.calculate(tempOutput+1);
	}

	public void setInputWeight(double inputWeight) {
		this.inputWeight = inputWeight;
	}

	public double getOutputWeight() {
		return outputWeight;
	}

	public void setOutputWeight(double outputWeight) {
		this.outputWeight = outputWeight;
	}

}
