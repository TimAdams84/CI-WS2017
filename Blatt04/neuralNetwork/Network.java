package neuralNetwork;

import java.util.ArrayList;

public class Network {

	ArrayList<Layer> layers = new ArrayList<Layer>();
	double learningRate;
	
	
	
	public Network(double learningRate) {
		super();
		this.learningRate = learningRate;
	}

	public double getLearningRate() {
		return learningRate;
	}

	public void setLearningRate(double learningRate) {
		this.learningRate = learningRate;
	}

	public void addLayer(Layer l){
		layers.add(l);
	}
	
	public Layer getLayer(int i){
		Layer l = layers.get(i);
		return l;
	}
	
	public void feedForward(){
		for(int i = 1; i<layers.size(); i++){
			for (Neuron neuron : layers.get(i).getNeuronen()) {
				neuron.calculateOuput();
			}
		}
	}
	
	public void setInput(double[] input){		
		int counter = 0;
		for (Neuron neuron : layers.get(0).getNeuronen()) {
			neuron.input = input[counter];
			counter ++;
		}
	}
	
	
	public double getOutputError(){
		double sumError = 0;
		for (Neuron neuron :layers.get(layers.size()-1).getNeuronen()){
			sumError += 1/2*Math.pow(((OutputNeuron)neuron).error,2);
		}
	return sumError;
	}
	
	public void backpropagate(double expected){
		for (Neuron neuron :layers.get(layers.size()-1).getNeuronen()){
			if(neuron instanceof InputNeuron) continue;
			neuron.backpropagate(expected);
		}
	}

	
	public double getSingleOutput(){
		return layers.get(layers.size()-1).getNeuronen().get(0).output;
	}
	
	
}
