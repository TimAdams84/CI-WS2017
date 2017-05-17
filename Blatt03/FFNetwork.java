import java.util.ArrayList;

public class FFNetwork {

	private ArrayList<Schicht> schichten;

	public FFNetwork() {
		schichten = new ArrayList<Schicht>();
	}

	public void addSchicht(Schicht s) {
		schichten.add(s);
	}

	public double calculateOutput(double input) {
		ArrayList<Double> outputs = new ArrayList<Double>();
		outputs.add(input);
		for (int i = 0; i < schichten.size(); i++) {
			Schicht schicht = schichten.get(i);
			for (Neuron n : schicht.getNeuronen()) {
				for (Double output : outputs) {
					n.forwardPropagation(output);					
				}
			}
			outputs.clear();
			for (Neuron n : schicht.getNeuronen()) {
				outputs.add(n.getOutput());
			}
		}

		return outputs.get(0);
	}

}
