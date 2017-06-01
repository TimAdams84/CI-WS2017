package main;
import java.util.ArrayList;
import java.util.List;

//import neuralNetwork.Network;
import neuralNetwork.*;
import org.apache.commons.math3.ml.clustering.CentroidCluster;
import org.apache.commons.math3.ml.clustering.DoublePoint;
import org.apache.commons.math3.ml.clustering.KMeansPlusPlusClusterer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;


public class Main {

	
	public static void main(String[] args) {
		

//initialisieren der target values; initialisierung der Zentren mit k-means		
		
		double[][] class1 = new double [2][100];
		double[][] class2 = new double [2][100];	
		double[][] centers = new double [2][30];	
		
		ArrayList<DoublePoint> points = new ArrayList<DoublePoint>();		
		
			for (int j=0;j<100;j++){
				class1[0][j] = 2+Math.sin(0.2*(j+1)+8)*Math.sqrt(j+1+10);
				class1[1][j] = -1+Math.cos(0.2*(j+1)+8)*Math.sqrt(j+1+10);
				class2[0][j] = 2+Math.sin(0.2*(j+1)-8)*Math.sqrt(j+1+10);
				class2[1][j] = -1+Math.cos(0.2*(j+1)-8)*Math.sqrt(j+1+10);
				points.add(new DoublePoint(new double[] { class1[0][j],class1[1][j] }));
				points.add(new DoublePoint(new double[] { class2[0][j],class2[1][j] }));
			}
						
		KMeansPlusPlusClusterer<DoublePoint> clusterer = new KMeansPlusPlusClusterer<DoublePoint>(30);
		List<CentroidCluster<DoublePoint>> results = clusterer.cluster(points);
		
		int center = 0;
		for (CentroidCluster<DoublePoint> centroidCluster : results) {
			centers[0][center] = centroidCluster.getCenter().getPoint()[0];
			centers[1][center] = centroidCluster.getCenter().getPoint()[1];
			center++;
		}
			
		
		
		// initialisieren des RBF Netzes
		
		Network network = new Network(0.03);
		
		//input,hidden,output Layer
		
		for(int i=0; i<3; i++){
			network.addLayer(new Layer());
		}
		//x1 x2 inputneuronen
		network.getLayer(0).addNeuron(new InputNeuron(null));
		network.getLayer(0).addNeuron(new InputNeuron(null));
		
		//hidden Layer
		for(int i=0; i<30; i++){
			network.getLayer(1).addNeuron(new RBFNeuron(null));
		}
		
		//output
		network.getLayer(2).addNeuron(new OutputNeuron(ActivationFunction.LINEAR));
		
		//weights input->hidden
		for(int i=0; i<30; i++){
			network.getLayer(0).getNeuron(0).addOutConnection(network.getLayer(1).getNeuron(i), centers[0][i]);
			network.getLayer(0).getNeuron(1).addOutConnection(network.getLayer(1).getNeuron(i), centers[1][i]);
		}
		//weights hidden->output
		for(int i=0; i<30; i++){
			network.getLayer(1).getNeuron(i).addOutConnection(network.getLayer(2).getNeuron(0),1);
		}
		//Netzausgabe #test
		
//		double[][] classoutput1 = new double [2][301*301];
//		
//		for (int x1=0;x1<301;x1++) {
//		    double x1Coord = -15+x1*0.1;
//		    for (int x2=0;x2<301;x2++) {
//		        double x2Coord = -15+x2*0.1;
//		        classoutput1[0][x1*301+x2] = x1Coord;
//		        classoutput1[1][x1*301+x2] = x2Coord;
//		    }
//		}
		
		
		//Training
		for (int x=0;x<10000;x++){
			for (int i=0;i<100;i++){
				network.setInput(new double[]{class1[0][i],class1[1][i]});
				network.feedForward();
				network.backpropagate(1);
				network.setInput(new double[]{class2[0][i],class2[1][i]});
				network.feedForward();
				network.backpropagate(-1);	;
			}
		}
		
		// Klassifikation nach Training

		ArrayList<Double> toclass1x1  = new ArrayList<Double>();
		ArrayList<Double> toclass1x2  = new ArrayList<Double>();
		ArrayList<Double> toclass2x1  = new ArrayList<Double>();
		ArrayList<Double> toclass2x2  = new ArrayList<Double>();
		
		for (int i = 0; i < 301; i++) {
			for (int j = 0; j < 301; j++) {
				double[] input = new double[]{-15+(i*0.1),-15+(j*0.1)};
				network.setInput(input);
				network.feedForward();
				if (network.getSingleOutput() > 0){
					toclass1x1.add(input[0]);
					toclass1x2.add(input[1]);
				}
				else{
					toclass2x1.add(input[0]);
					toclass2x2.add(input[1]);
				}			
			}			
		}
		System.out.println(toclass1x1.size());
		System.out.println(toclass2x1.size());
		double[][] class1c1out = new double[2][toclass1x1.size()];
		double[][] class2c1out = new double[2][toclass2x1.size()];	
		
		for (int i=0;i<toclass1x1.size();i++) {
            class1c1out[0][i] = toclass1x1.get(i);
            class1c1out[1][i] = toclass1x2.get(i);
        }
        for (int i=0;i<toclass2x1.size();i++) {
            class2c1out[0][i] = toclass2x1.get(i);
            class2c1out[1][i] = toclass2x2.get(i);
        }
		

	 		
		//plot
		DefaultXYDataset dataset = new DefaultXYDataset();
		dataset.addSeries("Class 1", class1);
		dataset.addSeries("Class 2", class2);
		dataset.addSeries("Centers",centers);
		dataset.addSeries("Class 1 Prediction", class1c1out);
		dataset.addSeries("Class 2 Prediction", class2c1out);
		

		JFreeChart chart = ChartFactory.createScatterPlot("Plot", "X1", "X2", dataset);

		ChartFrame frame = new ChartFrame("Plotter", chart);
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		
	}
	
}