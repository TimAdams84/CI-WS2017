package main06;

import java.awt.Color;
import java.util.Random;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;

public class Main {
	
	public static double getAbsoluteError(double[][] f1, double[][] f2){
		double error = 0;
		for (int i = 0; i < f2[0].length-1; i++) {
			error += Math.abs(f1[1][i]-f2[1][i]);
		}
		error = error / 1001;
		return error;
	}
	
	//initialisiert Polynom mit neuen Variablen
	public static double[][] reloadPoly(double[] variables){
		double[][] fx = new double [2][1001];
		for (int i = 0; i < fx[0].length-1; i++) {
			double x = -10+0.02*i;
			fx[0][i] = x;
			fx[1][i] = variables[0] + variables[1]*x + variables[2]*Math.pow(x, 2) + variables[3]*Math.pow(x, 3) + variables[4]*Math.pow(x, 4) + variables[5]*Math.pow(x, 5) + variables[6]*Math.pow(x, 6);
		}
		return fx;
		
	}

	public static void main(String[] args) {
		
		double[][] function = new double [2][1001];
		double[][] approx = new double [2][1001];
		double[] variables = new double[7];
		variables[0] = 1.0*-1/2;
		variables[1] = 1.0*1/4;
		variables[2] = 1.0*-1/8;
		variables[3] = 1.0*1/16;
		variables[4] = 1.0*-1/32;
		variables[5] = 1.0*1/64;
		variables[6] = 1.0*-1/128;
		
		
		
						
		//6.2

		for (int i = 0; i < function[0].length-1; i++) {
			double x = -10+0.02*i;
			function[0][i] = x;
			function[1][i] = -4*Math.cos((x)/3)+Math.sin(15/(Math.abs(0.5*(x)+2)+1))+0.2*(x);
			approx = reloadPoly(variables);
		}
		double error = getAbsoluteError(function,approx);
		System.out.println("6.2 Error: "+error);
		
		//VISUALISIERUNG
		DefaultXYDataset dataset = new DefaultXYDataset();
		
		dataset.addSeries("f(x)",function);
		dataset.addSeries("g(x)", approx);		
		JFreeChart chart = ChartFactory.createScatterPlot("Aufgabe 6.2", "x", "y", dataset);
		ChartFrame frame = new ChartFrame("Übung 6", chart);	
        
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		
		//6.3
		
		double[] tempVariables = new double[7];		
		double[][] tempApprox = new double[2][1001];
		error = Double.POSITIVE_INFINITY;
		
		for (int i = 0; i < 1000; i++) {
			//variablen anpassen
			tempVariables = variables;	
			for (int j = 0; j < 7; j++) {
				double random = -3 + new Random().nextDouble()*6;	
				tempVariables[j] = random;
			}
			//Funktion mit neuen variablen plotten
			tempApprox = reloadPoly(tempVariables);		
			//falls Error sich verbessert, Variablen und Polynom aktualisieren			
			if(error>getAbsoluteError(function,tempApprox)){
				approx = tempApprox;
				variables = tempVariables;
				error = getAbsoluteError(function,tempApprox);
				System.out.println("New Error: "+error);
			}
		}
		
		error = getAbsoluteError(function,approx);
		System.out.println("6.3 Error: "+error);
		for (int i = 0; i < variables.length; i++) {
			System.out.println("Variable a"+i+": "+variables[i]);
			
		}
		
		//VISUALISIERUNG
		DefaultXYDataset dataset2 = new DefaultXYDataset();
		
		dataset2.addSeries("f(x)",function);
//		dataset2.addSeries("g(x)", approx);		
		JFreeChart chart2 = ChartFactory.createScatterPlot("Aufgabe 6.3", "x", "y", dataset2);
		ChartFrame frame2 = new ChartFrame("Übung 6", chart2);		

		frame2.setVisible(true);
		frame2.setSize(800, 600);
		
		
		//6.4
		
		error = Double.POSITIVE_INFINITY;
		double [] tempVariables2 = new double[7];
		double [][] tempApprox2 = new double[2][1001];
		
		for (int i = 0; i < 100; i++) {

			tempVariables = variables;	
			for (int j = 0; j < 7; j++) {
				double random = -3 + new Random().nextDouble()*6;	
				tempVariables[j] = random;
			}	
		
			for (int j = 0; j < 1000; j++) {
				
				tempVariables2 = tempVariables;
				for (int k = 0; k < 7; k++) {
					double random = -0.1 + new Random().nextDouble()*0.2;
					tempVariables2[k] += random;					
				}
				tempApprox2 = reloadPoly(tempVariables2);
				if(getAbsoluteError(function, tempApprox2)<error){
					tempApprox = tempApprox2;
					tempVariables = tempVariables2;
					error = getAbsoluteError(function, tempApprox2);
					System.out.println(getAbsoluteError(function, tempApprox2));
					}
				
			} 
			//Funktion mit neuen variablen plotten
			tempApprox = reloadPoly(tempVariables);		
			//falls Error sich verbessert, Variablen und Polynom aktualisieren			
			if(error>getAbsoluteError(function,tempApprox)){
				approx = tempApprox;
				variables = tempVariables;
				error = getAbsoluteError(function,tempApprox);
				System.out.println("New Error: "+error);
			}
			System.out.println(i+"%");
		}
		
		error = getAbsoluteError(function,approx);
		System.out.println("6.4 Error: "+error);
		for (int i = 0; i < variables.length; i++) {
			System.out.println("Variable a"+i+": "+variables[i]);
			
		}
		
	
		
		
		
		
	}

}