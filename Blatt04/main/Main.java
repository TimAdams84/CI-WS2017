package main;
import java.util.ArrayList;
import java.util.List;

import neuralNetwork.Network;

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
		
		
		
		//Netzausgabe #test

		double[][] classoutput1 = new double [2][301*301];
		
		for (int x1=0;x1<301;x1++) {
		    double x1Coord = -15+x1*0.1;
		    for (int x2=0;x2<301;x2++) {
		        double x2Coord = -15+x2*0.1;
		        classoutput1[0][x1*301+x2] = x1Coord;
		        classoutput1[1][x1*301+x2] = x2Coord;
		    }
		}
		
		
		DefaultXYDataset dataset = new DefaultXYDataset();
		dataset.addSeries("Class 1", class1);
		dataset.addSeries("Class 2", class2);
		dataset.addSeries("Centers",centers);
		dataset.addSeries("Class 12", classoutput1);
		
		
		//plottet Datebpunkte und Zentren
		
//		DefaultXYDataset dataset = new DefaultXYDataset();
//		dataset.addSeries("Class 1", class1);
//		dataset.addSeries("Class 2", class2);
//		dataset.addSeries("Centers",centers);


		JFreeChart chart = ChartFactory.createScatterPlot("Plot", "X1", "X2", dataset);

		ChartFrame frame = new ChartFrame("Plotter", chart);
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		
	}
	
}