package app;



import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * @author imssbora
 *
 */
public class PolarLineChartExample extends JFrame {

   private static final long serialVersionUID = 1L;

   public PolarLineChartExample(String title) {
      super(title);
      
      // Create dataset
      XYDataset dataset = getXYDataset();
    
      // Create chart
      JFreeChart chart = ChartFactory.createPolarChart(
            "Polar Chart Example | WWW.BORAJI.COM", // Chart title
            dataset,
            true,
            true,
            false
            );

      ChartPanel panel = new ChartPanel(chart);
      panel.setMouseZoomable(false);
      setContentPane(panel);
   }

   private XYDataset getXYDataset() {
     
      XYSeriesCollection dataset = new XYSeriesCollection();

      XYSeries series1 = new XYSeries("Series1");
      series1.add(37, 21);
      series1.add(37*2,23);
      //series1.add(37*3, 36);
      
      XYSeries series2= new XYSeries("Series2");
//      series2.add(20, 45);
//      series2.add(0,40);
//      series2.add(0,80);
      
      
      dataset.addSeries(series1);
      dataset.addSeries(series2);
      return dataset;
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         PolarLineChartExample example = new PolarLineChartExample("Gantt Chart Example");
         example.setSize(800, 400);
         example.setLocationRelativeTo(null);
         example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         example.setVisible(true);
      });
   }
}