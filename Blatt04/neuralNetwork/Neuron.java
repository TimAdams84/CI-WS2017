package neuralNetwork;

import java.util.ArrayList;

public class Neuron {
	
	double input;
	double output;
	ActivationFunction activationFunction;
	double error;
	double delta;
	
	ArrayList<Connection> inConnections;
	ArrayList<Connection> outConnections;
	
	
	public Neuron(double input, double output,
			ActivationFunction activationFunction) {
		super();
		this.input = input;
		this.output = output;
		this.activationFunction = activationFunction;
	}
	
	
	public void addInConnection(Neuron from,double weight){
		this.inConnections.add(new Connection(from , this, weight));
	}
	
	public void addOutConnection(Neuron to, double weight){
		this.inConnections.add(new Connection(this, to, weight));
	}
	
	public void calculateOuput(){
		input = 0;
		for (Connection connection : inConnections) {
			input += connection.from.output*connection.weight;
		}
		output = activationFunction.calculate(input);
	}
	
	public void backpropagate(double learningRate){
		double temp= 0;
		for (Connection connection : outConnections) {
			temp = connection.weight*connection.to.delta;
		}
		delta = activationFunction.differentiate(input) * temp;
	}
	
	public void refresh(double learningRate){
		for (Connection connection : inConnections) {
			connection.weight -= learningRate * input * delta;
		}
	}
	
	
}
