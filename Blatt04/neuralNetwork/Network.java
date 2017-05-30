package neuralNetwork;

import java.util.ArrayList;

public class Network {

	ArrayList<Layer> layer = new ArrayList<Layer>();
	double learningRate;
	
	public void addLayer(Layer l){
		layer.add(l);
	}
	
	public void feedForward(){
		for(int i = 1; i<layer.size(); i++){
			for (Neuron neuron : layer.get(i).getNeuronen()) {
				neuron.calculateOuput();
			}
		}
	}
	

	
	
	public double getSingleOutput(){
		return layer.get(layer.size()-1).getNeuronen().get(0).output;
	}
	
	
}
