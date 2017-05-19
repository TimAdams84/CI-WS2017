package ffnetz;

import java.util.ArrayList;

public class Netzwerk {
	
	ArrayList<Schicht> schichten;
	
	public void addSchicht(Schicht s){
		schichten.add(s);
	}
	
	public double calculateOutput(double input){
		//logik fehlt
		return 0; //return output
	}
	
	public double calculateError(double input, double desiredOutput){
		//logik fehlt
		return 0; //return Error
	}
	
	
}
