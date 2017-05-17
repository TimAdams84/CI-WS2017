import java.util.ArrayList;


public class Schicht {
	
	public ArrayList<Neuron> neuronen;
	
	public void addNeuron(Neuron n){
		neuronen.add(n);
	}
	public ArrayList<Neuron> getNeuronen() {
		return neuronen;
	}
	
	public void setNeuronen(ArrayList<Neuron> neuronen) {
		this.neuronen = neuronen;
	}
	
}
