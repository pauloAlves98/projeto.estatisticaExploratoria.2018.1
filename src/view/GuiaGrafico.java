package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Cor;

public class GuiaGrafico extends JFrame {
	private JPanel painel1,painel2,painel3;
	private JFreeChart grafico;
	public GuiaGrafico(ChartPanel g){
		 Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		 grafico = new JFreeChart(g.getChart().getPlot());
		 setLayout(new BorderLayout());
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 int lar =(int)d.width/2,alt = d.height; 
		 setSize(lar,alt);

		 painel2 = new JPanel(new GridLayout(1,1));
		 // painel2.setPreferredSize(new Dimension(lar,(int) ((int)alt * 0.8)));
		 ChartPanel aux = new ChartPanel(grafico);
		 aux.setBackground(Cor.cor2);
		 aux.getChart().setTitle(g.getChart().getTitle());
		 painel2.add(new JScrollPane(aux));
	
		 add(painel2);
		 setVisible(true);
	}
	public GuiaGrafico(JTable tabela){
		//tabela.getModel().get
		 Toolkit tk = Toolkit.getDefaultToolkit();
		 Dimension d = tk.getScreenSize();
		 setLayout(new BorderLayout());
		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 setLocationRelativeTo(null);
		 int lar =(int)d.width/2,alt = d.height; 
		 setSize(lar,alt);

		DefaultCategoryDataset base = new DefaultCategoryDataset();
		for(int i = 0;i<tabela.getModel().getRowCount();i++){
			base.addValue(Integer.parseInt((String) tabela.getModel().getValueAt(i,1)),(String)tabela.getModel().getValueAt(i,0),(String)tabela.getModel().getValueAt(i,0));
		}
		JFreeChart coluna = ChartFactory.createBarChart3D("Coluna","X", "Y", base);
		 CategoryAxis domainAxis = ((CategoryPlot) coluna.getPlot()).getDomainAxis();
	        domainAxis.setCategoryLabelPositions(
	            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 4.0)
	        );
		//telaGrafico.coluna.getCategoryPlot().setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);//deixa a coluna numerica em baixo
		ChartPanel painelG = new ChartPanel(coluna);
		JScrollPane scroll = new JScrollPane(painelG);
		
		//telaGrafico.painelG.getPopupMenu().add(telaGrafico.item1);
		System.gc();
		painel2 = new JPanel(new GridLayout(1,1));
		painel2.add(new JScrollPane(scroll));
	    add(painel2);
	
		setVisible(true);
	}

}
