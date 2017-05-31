package neuralNetwork;

import java.util.ArrayList;

public class Layer {

	ArrayList<Neuron> neuronen = new ArrayList<Neuron>();

	public ArrayList<Neuron> getNeuronen() {
		return neuronen;
	}

	public void addNeuron(Neuron n) {
		neuronen.add(n);
	}
	
	public Neuron getNeuron(int i){
		Neuron neuron = neuronen.get(i);
		return neuron;
	}

}
