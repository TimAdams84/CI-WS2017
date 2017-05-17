import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;

import de.buffalodan.plot.PlotFactory;

public class Main {

	public static void main(String[] args) {

		// Punkte initialisieren

		double[] xWerte = new double[1001];
		double[] yWerte = new double[1001];
		double[] yWerteNetwork = new double[1001];

		for (int i = 0; i < 1001; i++) {
			double x = -10 + 0.02 * i;
			xWerte[i] = x;
			yWerte[i] = -4 * Math.cos(x / 3) + Math.sin(15 / (Math.abs(0.5 * x + 2) + 1)) + 0.2 * x;
		}

		// Graph
		// https://www.mathematik.hu-berlin.de/~ccafm/teachingBasic/allg/JAVA_Pakete/JFreeChart/JFreeChart-Tutorial.html#Schritt2

		FFNetwork network = new FFNetwork();
		Random r = new Random(System.currentTimeMillis());
		ActivationFunction fermi = new ActivationFunction() {
			
			public double calculate(double input) {
				return 1/(1+Math.pow(Math.E, -input));
			}
		};
		
		Schicht hidden = new Schicht();
		double inputWeight = r.nextDouble() - 0.5;
		double outputWeight = r.nextDouble() - 0.5;
		Neuron bias = new Neuron(inputWeight, outputWeight, ActivationFunction.BIAS);
		//hidden.addNeuron(bias);

		for (int i = 0; i < 10; i++) {
			inputWeight = r.nextDouble() - 0.5;
			outputWeight = r.nextDouble() - 0.5;
			Neuron n = new Neuron(inputWeight, outputWeight, fermi);
			hidden.addNeuron(n);
		}
		network.addSchicht(hidden);
		for (int i = 0; i < 1001; i++) {
			double output = network.calculateOutput(xWerte[i]);
			yWerteNetwork[i] = output;
		}
		Schicht output = new Schicht();
		output.addNeuron(new Neuron(1, 1, fermi));

		DefaultXYDataset dataset = PlotFactory.createSimpleXYDataset("funtion", xWerte, yWerte);
		PlotFactory.addToDataset(dataset, 1, xWerte, yWerteNetwork);
		JFreeChart chart = ChartFactory.createXYLineChart("Plot", "X", "Y", dataset);

		ChartFrame frame = new ChartFrame("Plotter", chart);
		frame.setVisible(true);
		frame.setSize(800, 600);
	}

}
