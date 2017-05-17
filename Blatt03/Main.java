import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import de.buffalodan.plot.PlotFactory;


public class Main {

	public static void main(String[] args) {
		
		
		//Punkte initialisieren
		
		double[] xWerte = new double[1001];
		double[] yWerte = new double[1001];
		
		for(int i=0;i<1001;i++){
			double x = -10 + 0.02*i;
			xWerte[i]= x;
			yWerte[i]= -4*Math.cos(Math.toRadians(x/3))+Math.sin(Math.toRadians(15/(Math.abs(0.5*x+2)+1)))+0.2*x;
		}
			
		
		//Graph
		//https://www.mathematik.hu-berlin.de/~ccafm/teachingBasic/allg/JAVA_Pakete/JFreeChart/JFreeChart-Tutorial.html#Schritt2
		
		
		JFreeChart chart = ChartFactory.createXYLineChart("Plot", "X", "Y", PlotFactory.createSimpleXYDataset(xWerte, yWerte));
		ChartFrame frame = new ChartFrame("Plotter", chart);
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		// Ist jetzt nur irgendwie alles andere als eine Sinuskurve :D
	}
	
	
	
	
	
}
