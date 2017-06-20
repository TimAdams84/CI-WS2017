package main;
import java.awt.Color;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;


public class Main {
	
	//euklidische Distanz	
	public static double getDistance(double x1, double y1, double x2, double y2){
		return Math.sqrt(Math.pow(x1-x2, 2)+Math.sqrt(Math.pow(y1-y2, 2)));
	}
	
	public static int getWinner(double datax, double datay , double[][] units){
		int winnerIndex = 0;
		double minDistance =  Double.POSITIVE_INFINITY;
		for (int i = 0; i < units[0].length; i++) {
			double currentDistance = getDistance(datax, datay, units[0][i],units[1][i]);
			if (currentDistance< minDistance) {
				winnerIndex = i;
				minDistance = currentDistance;
			}	
		}
		return winnerIndex;
	}
	
	public static double sigma(int currentIteration, int finalIteration){
		double start = 0.9;
		double end = 0.1;
		return start*Math.pow((end/start),((double)currentIteration/finalIteration));
	}
			
	public static double[][] training(double[][] data,double[][] units,int iterations, double learningrate){
		for(int i=0;i<iterations;i++){
			for(int j=0; j<data[0].length;j++){
			int winner=getWinner(data[0][j],data[1][j],units);
			double tempx = units[0][winner];
			double tempy = units[1][winner];
				for(int k=0;k<3;k++){
					double temp = learningrate*Math.exp(-1*Math.pow(Math.abs(winner-k),2)/2*Math.pow(sigma(i, iterations),2));
					System.out.println("vorher: "+units[0][k]);
					units[0][k]+= temp*(tempx-units[0][k]);
					units[1][k]+= temp*(tempy-units[1][k]);
					System.out.println("nachher: "+units[0][k]);
				}
			}
		}
		return units;
	}
	
	
	public static void main(String[] args){
	
		double[][] data = new double[2][1001];
		double u = 0;
		
		//Rauschen mit Varianz = 1
		for(int i=0; i<1001;i++){
			java.util.Random r = new java.util.Random();
			data[0][i]= 2*(3+Math.sqrt(u)*Math.sin(u))+ r.nextGaussian() * Math.sqrt(0.1*u);
			data[1][i]= 3*(3+Math.sqrt(u)*Math.cos(u))+ r.nextGaussian() * Math.sqrt(0.15*u);
			u += 0.02;
		}
		
		//5.2 Ansatz mit Arrays
		//Visualisierung von Verbindungen zwischen den SOM-Units fehlt
		
		double [][] units = new double [2][100];
		
		for(int i=0; i<100;i++){
			int rnd = new Random().nextInt(data[0].length);
			units[0][i] = data[0][rnd];
			units[1][i] = data[1][rnd];
			
		}
		
		//ordne Soms nach x-Werten aufsteigend, momentan Selection Sort
		//sollte evtl als Merge Sort implementiert werden je nach Laufzeit
//		double tempx;
//		double tempy;
//		for(int i=0;i<99;i++){
//			for(int j=i+1; j<100;j++){
//				if (units[0][i]>units[0][j]){
//					tempx = units[0][i];
//					tempy = units[1][i];
//					units[0][i] = units[0][j];
//					units[1][i] = units[1][j];
//					units[0][j] = tempx;
//					units[1][j] = tempy;
//				}
//			}
//		}
		
		//Training
		units = training(data,units,3,0.01);			
		
		
		//Visualisierung
		
		DefaultXYDataset dataset = new DefaultXYDataset();
		
		//Punkte 100,...,1000
		double[][] stepdata = new double[2][10];
	
		for (int i = 0; i < 10; i++) {
			stepdata[0][i] = data[0][(i+1)*100];
			stepdata[1][i] = data[1][(i+1)*100];
		}
		
		//Winner Units zu Punkten
		double[][] winners = new double[2][10];
		
		for (int i = 0; i < 10; i++) {
			winners[0][i] = units[0][getWinner(data[0][(i+1)*100],data[1][(i+1)*100],units)];
			winners[1][i] = units[1][getWinner(data[0][(i+1)*100],data[1][(i+1)*100],units)];
		}
		
		dataset.addSeries("Winner-Units",winners);
		dataset.addSeries("SOM-Units", units);
		dataset.addSeries("Daten 100,..,1000", stepdata);
		dataset.addSeries("2D-Datenpunkte", data);


		
		JFreeChart chart = ChartFactory.createScatterPlot("Übung 5", "x", "y", dataset);

		ChartFrame frame = new ChartFrame("Plotter", chart);
		
		XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.YELLOW);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.GREEN);
		renderer.setSeriesPaint(3, Color.BLUE);
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesLinesVisible(1, true);
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesLinesVisible(3, false);
        plot.setRenderer(renderer);
        
		frame.setVisible(true);
		frame.setSize(800, 600);	

	}

	
}
