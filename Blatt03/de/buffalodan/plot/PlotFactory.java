package de.buffalodan.plot;

import org.jfree.data.xy.DefaultXYDataset;

public class PlotFactory {
	
	public static DefaultXYDataset createSimpleXYDataset(Comparable key, double[] xs, double[] ys) {
		DefaultXYDataset dataset = new DefaultXYDataset();
		double[][] data = new double[2][0];
		data[0] = xs;
		data[1] = ys;
		dataset.addSeries(key, data);
		return dataset;
	}
	
	public static void addToDataset(DefaultXYDataset dataset, Comparable key, double[] xs, double[] ys) {
		double[][] data = new double[2][0];
		data[0] = xs;
		data[1] = ys;
		dataset.addSeries(key, data);
	}

}
