import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import javafx.scene.chart.NumberAxis;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.annotations.XYAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.event.RendererChangeListener;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.labels.XYSeriesLabelGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CrosshairState;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRendererState;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.*;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.data.Range;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.Layer;


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
		
		
		double [][] A = {{1,2,5},{3,4,0}};

		DefaultXYDataset dataset = new DefaultXYDataset();
		dataset.addSeries("xy", A);    // A wird unter dem Namen xy abgespeichert
		
		// series2 enthaelt Punkte, die verbunden werden
		XYSeries series1 = new XYSeries("Punkte1");
		series1.add(0, 0);
		series1.add(1, 1);
		series1.add(2, 1);
		series1.add(3, 2);

		XYSeries series2 = new XYSeries("Punkte2");
		series2.add(1, 2);
		series2.add(2, 3);
		series2.add(3, 4);

		// Hinzufuegen von series1 und series2 zu der Datenmenge dataset
		XYSeriesCollection dataset2 = new XYSeriesCollection();
		dataset2.addSeries(series1);
		dataset2.addSeries(series2);
		
		
		JChartfactory
		
		dot.setDotHeight(5);
		dot.setDotWidth(5);
		
		NumberAxis xax = new NumberAxis("x",-10,10,1);
		NumberAxis yax = new NumberAxis("y",0,10,1);
		
		XYPlot plot = new XYPlot(dataset,xax,);

		JFreeChart chart2 = new JFreeChart(plot);
		
		// Erstellen eines Ausgabefensters
		ApplicationFrame punkteframe = new ApplicationFrame("Punkte"); //"Punkte" entspricht der Ueberschrift des Fensters

		ChartPanel chartPanel2 = new ChartPanel(chart2);
		punkteframe.setContentPane(chartPanel2);
		punkteframe.pack();
		punkteframe.setVisible(true);
		
		
		
	}
	
	
	
	
	
}
