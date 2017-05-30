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
	
	public double getOutputError(){
		double sumError = 0;
		for (Neuron neuron :layer.get(layer.size()-1).getNeuronen()){
			sumError += ((OutputNeuron)neuron).error;
		}
	return sumError;
	}
	
	public void backpropagate(double expected){
		for (Neuron neuron :layer.get(layer.size()-1).getNeuronen()){
			sumError += ((OutputNeuron)neuron).error;
		}
	}
	
	public double getSingleOutput(){
		return layer.get(layer.size()-1).getNeuronen().get(0).output;
	}
	
	
}
