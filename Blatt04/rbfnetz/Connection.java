package rbfnetz;

public class Connection {
	
	double weight;
	Neuron from;
	Neuron to;
	
	Connection(Neuron from,Neuron to,double weigth){
		this.from = from;
		this.to = to;
		this.weight = weigth;
	}
	
	
	public double getWeigth() {
		return weight;
	}

	public void setWeigth(double weigth) {
		this.weight = weigth;
	}

}
