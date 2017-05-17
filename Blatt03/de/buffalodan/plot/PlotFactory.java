package de.buffalodan.plot;

import org.jfree.data.xy.DefaultXYDataset;

public class PlotFactory {
	
	public static DefaultXYDataset createSimpleXYDataset(double[] xs, double[] ys) {
		DefaultXYDataset dataset = new DefaultXYDataset();
		double[][] data = new double[2][0];
		data[0] = xs;
		data[1] = ys;
		dataset.addSeries(0, data);
		return dataset;
	}

}
