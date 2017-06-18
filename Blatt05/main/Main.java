package main;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;


public class Main {
	
	public static void main(String[] args){
	
		double[][] data = new double[2][1001];
		double u = 0;
		
		//Rauschen mit Varianz = 1
		for(int i=0; i<1001;i++){
			java.util.Random r = new java.util.Random();
			data[0][i]= 2*(3+Math.sqrt(u)*Math.sin(u))+ r.nextGaussian() * Math.sqrt(1);
			data[1][i]= 3*(3+Math.sqrt(u)*Math.cos(u))+ r.nextGaussian() * Math.sqrt(1);
			u += 0.02;
		}
		
		//5.2 Ansatz mit Arrays
		//Visualisierung von Verbindungen zwischen den SOM-Units fehlt
		
		double [][] units = new double [2][100];
		
		for(int i=0; i<100;i++){
			int rnd = new Random().nextInt(data[0].length);
			units[0][i] = data[0][rnd];
			units[1][i] = data[1][rnd];
			System.out.println(units[0][i]);
			
		}
		
		//ordne Soms nach x-Werten aufsteigend, momentan Selection Sort
		//sollte evtl als Merge Sort implementiert werden je nach Laufzeit
		double tempx;
		double tempy;
		for(int i=0;i<99;i++){
			for(int j=i+1; j<100;j++){
				if (units[0][i]>units[0][j]){
					tempx = units[0][i];
					tempy = units[1][i];
					units[0][i] = units[0][j];
					units[1][i] = units[0][j];
					units[0][j] = tempx;
					units[1][j] = tempy;
				}
			}
		}
		//Visualisierung
		
		DefaultXYDataset dataset = new DefaultXYDataset();
		dataset.addSeries("SOM-Units", units);
		dataset.addSeries("2D-Datenpunkte", data);
		
		JFreeChart chart = ChartFactory.createScatterPlot("Übung 5", "x", "y", dataset);

		ChartFrame frame = new ChartFrame("Plotter", chart);
		
		XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesLinesVisible(1, false);
        plot.setRenderer(renderer);
        
		frame.setVisible(true);
		frame.setSize(800, 600);	
	}

	
}
