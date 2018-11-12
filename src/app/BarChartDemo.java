package app;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


	public class BarChartDemo extends ApplicationFrame {

	    /**
	     * Creates a new demo instance.
	     *
	     * @param title  the frame title.
	     */
	    public BarChartDemo(final String title) {
	        super(title);
	        final CategoryDataset dataset = createDataset();
	        final JFreeChart chart = createChart(dataset);
	        

	        // add the chart to a panel...
	        final ChartPanel chartPanel = new ChartPanel(chart);
	        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	        setContentPane(chartPanel);

	    }

	    /**
	     * Creates a sample dataset.
	     * 
	     * @return A dataset.
	     */
	    private CategoryDataset createDataset() { 
	        final double[][] data = new double[][] {
	            {1.0, 43.0, 35.0, 58.0, 54.0, 77.0, 71.0, 89.0},
	            {1.0, 45.0, 55.0, 53.0, 54.0, 77.0, 71.0, 89.0}
	          
	        };
	        return DatasetUtilities.createCategoryDataset("Series ", "A ", data);
	    }

	    /**
	     * Creates a chart.
	     * 
	     * @param dataset  the dataset.
	     * 
	     * @return A chart.
	     */
	    private JFreeChart createChart(final CategoryDataset dataset) {
	        
	        final JFreeChart chart = ChartFactory.createBarChart(
	            "Bar Chart Demo 2",         // chart title
	            "Category",                 // domain axis label
	            "Score (%)",                // range axis label
	            dataset,                    // data
	            PlotOrientation.HORIZONTAL, // orientation
	            true,                       // include legend
	            true,
	            false
	        );

	        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

	        // set the background color for the chart...
	        chart.setBackgroundPaint(Color.lightGray);
	        //JFreeChart chart = ChartFactory.createPolarChart(, dataset, legend, tooltips, urls)
	        // get a reference to the plot for further customisation...
	        final CategoryPlot plot = chart.getCategoryPlot();
	        plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
	        
	        // change the auto tick unit selection to integer units only...
	        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
	        rangeAxis.setRange(0.0, 100.0);
	        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
	        
	        // OPTIONAL CUSTOMISATION COMPLETED.
	        
	        return chart;
	        
	    }
	    
	    // ****************************************************************************
	    // * JFREECHART DEVELOPER GUIDE                                               *
	    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
	    // * to purchase from Object Refinery Limited:                                *
	    // *                                                                          *
	    // * http://www.object-refinery.com/jfreechart/guide.html                     *
	    // *                                                                          *
	    // * Sales are used to provide funding for the JFreeChart project - please    * 
	    // * support us so that we can continue developing free software.             *
	    // ****************************************************************************
	    
	    /**
	     * Starting point for the demonstration application.
	     *
	     * @param args  ignored.
	     */
	    public static void main(final String[] args) {
//	    	JFrame jf = new JFrame();
//	    	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//	    	jf.setSize( 500, 500 );
//	    	DefaultCategoryDataset ds = new DefaultCategoryDataset();
//	    	XYSeries c 
//	    	ds.addValue( 0, "a", "x" );
//	    	ds.addValue( 1, "a", "y" );
//	    	ds.addValue( 2, "b", "x" );
//	    	ds.addValue( 3, "b", "y" );
//	    	ds.addValue( 4, "c", "x" );
//	    	ds.addValue( 7, "c", "y" );
//	    	JFreeChart chart = ChartFactory.createLineChart(
//	    	        "Teste",
//	    	        "Categorias",
//	    	        "Valores", ds,
//	    	        PlotOrientation.HORIZONTAL, true, true, true );
//	    	CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();
//	    	renderer.setSeriesPaint( 0, new Color( 0, 255, 0 ) );
//	    	renderer.setSeriesPaint( 1, Color.YELLOW );
//	    	renderer.setSeriesPaint( 2, new Color( 0, 100, 155 ) );
//	    	ChartPanel panel = new ChartPanel( chart );
//	    	jf.add( panel, BorderLayout.CENTER );
//	    	jf.setVisible( true );
	        final BarChartDemo demo = new BarChartDemo("Bar Chart Demo 2");
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);

	    }

	}

