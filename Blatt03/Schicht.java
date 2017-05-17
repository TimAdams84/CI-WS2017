import java.util.ArrayList;

public class Schicht {
	
	private ArrayList<Neuron> neuronen;
	
	public Schicht() {
		neuronen = new ArrayList<Neuron>();
	}
	
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
