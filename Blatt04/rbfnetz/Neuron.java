package rbfnetz;

import java.util.ArrayList;

public class Neuron {
	
	double input;
	double output;
	ActivationFunction activationFunction;
	
	public Neuron(double input, double output,
			ActivationFunction activationFunction) {
		super();
		this.input = input;
		this.output = output;
		this.activationFunction = activationFunction;
	}

	ArrayList<Connection> inConnections;
	ArrayList<Connection> outConnections;
	
	
	
	public void addInConnection(Neuron from,double weight){
		this.inConnections.add(new Connection(from , this, weight));
	}
	
	public void addOutConnection(Neuron to, double weight){
		this.inConnections.add(new Connection(this, to, weight));
	}
	
	public void calculateouput(){
		input = 0;
		for (Connection connection : inConnections) {
			input += connection.from.output*connection.weight;
		}
	}
	
}
