package app;

import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class LineGenerator extends JFrame{
	public LineGenerator(final String title) {

	    //super(title);
		
	    final XYDataset dataset = createDataset();
	    final JFreeChart chart = createChart(dataset);
	    final ChartPanel chartPanel = new ChartPanel(chart);


	    chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	    setContentPane(chartPanel);
	    setVisible(true);
	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */
	private XYDataset createDataset() {

	    final XYSeries series1 = new XYSeries("First");
	    series1.add(0, 0);
	    series1.add(0, 2);
	    series1.add(1, 2);
	    series1.add(1, 5);
	    series1.add(2, 5);
	    series1.add(2, 8);
	    series1.add(3, 8);
	    series1.add(3, 5);
	    series1.add(4,5);
	    series1.add(4,3);
	    series1.add(5,3);
	    series1.add(5,13);
	    series1.add(6,13);
	    series1.add(6,4);
	    series1.add(7,4);
	    series1.add(7,0);
	    final XYSeries series2 = new XYSeries("Second");
	    series2.add(1.0, 5.0);
	    series2.add(2.0, 7.0);
	    series2.add(3.0, 6.0);
	    series2.add(4.0, 8.0);
	    series2.add(5.0, 4.0);
	    series2.add(6.0, 4.0);
	    series2.add(7.0, 2.0);
	    series2.add(8.0, 1.0);

	    final XYSeries series3 = new XYSeries("Third");
	    series3.add(3.0, 4.0);
	    series3.add(4.0, 3.0);
	    series3.add(5.0, 2.0);
	    series3.add(6.0, 3.0);
	    series3.add(7.0, 6.0);
	    series3.add(8.0, 3.0);
	    series3.add(9.0, 4.0);
	    series3.add(10.0, 3.0);

	    final XYSeriesCollection dataset = new XYSeriesCollection();
	    dataset.addSeries(series1);
//	    dataset.addSeries(series2);
//	    dataset.addSeries(series3);

	    return dataset;

	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset  the data for the chart.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(final XYDataset dataset) {
	    // create the chart...
	    final JFreeChart chart = ChartFactory.createXYLineChart(
	        "Line Chart Demo 6",      // chart title
	        "X",                      // x axis label
	        "Y",                      // y axis label
	        dataset,                  // data
	        PlotOrientation.VERTICAL,
	        true,                     // include legend
	        true,                     // tooltips
	        false                     // urls
	    );

	    // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
	    chart.setBackgroundPaint(Color.white);
	    chart.getPlot().setBackgroundPaint(Color.white);
//      final StandardLegend legend = (StandardLegend) chart.getLegend();
//      legend.setDisplaySeriesShapes(true);
      
      // get a reference to the plot for further customisation...
      final XYPlot plot = chart.getXYPlot();
      //plot.setBackgroundPaint(Color.lightGray);
      // plot.setAxisOffset(new RectangleInsets( 5.0, 5.0, 5.0, 5.0));
      plot.setDomainGridlinePaint(Color.white);
      plot.setRangeGridlinePaint(Color.white);
      
      final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
      renderer.setSeriesLinesVisible(0, true);
      renderer.setSeriesShapesVisible(1, true);
      plot.setRenderer(renderer);

      // change the auto tick unit selection to integer units only...
      final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	   return chart;
	}
	public static void main(String[] args) {
		new LineGenerator("");
	}
}
