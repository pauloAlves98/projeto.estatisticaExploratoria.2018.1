package controller;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTick;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarAxisLocation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.TextAnchor;

import model.Base;
import model.DadosTabelaFrequencia;
import model.TiradorDeAmostras;
import view.GuiaGrafico;
import view.TelaGraficos;
//
public class ControllerGraficos implements ActionListener{
	private TelaGraficos telaGrafico;
	public ControllerGraficos(TelaGraficos telaGrafico){
		this.telaGrafico = telaGrafico;
		this.telaGrafico.getGerar().addActionListener(this);
		this.telaGrafico.item1.addActionListener(this);
		telaGrafico.getEscolhaPesquisaBox().removeAllItems();
		for(int i = 0;i<Base.base.size();i++){
			telaGrafico.getEscolhaPesquisaBox().addItem(Base.base.get(i).getNomePesquisa());
		}
		this.telaGrafico.getTipoAmostrasBox().addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(telaGrafico.getTipoAmostrasBox().getSelectedIndex()==3){
					if(telaGrafico.escolhaPesquisaBox.getModel().getSize()<=0){
						JOptionPane.showMessageDialog(null,"CRIE UMA PESQUISA PRIMEIRO!!!");
						return ;
					}
					telaGrafico.quantField.setText(""+Base.base.get(telaGrafico.escolhaPesquisaBox.getSelectedIndex()).getDadosPesquisa().size());
					telaGrafico.quantField.setEditable(false);
				}
				else
					telaGrafico.quantField.setEditable(true);
			}
			
		});
		this.telaGrafico .escolhaPesquisaBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(telaGrafico.escolhaPesquisaBox.getModel().getSize()<=0){
					return ;
				}
				//Base.base.get(telaGrafico.escolhaPesquisaBox.getSelectedIndex()).tipo.equalsIgnoreCase("Qualitativa");
				if(Base.base.get(telaGrafico.escolhaPesquisaBox.getSelectedIndex()).isQualitativa()){
					telaGrafico.escolhaGrafico.setVisible(true);
					telaGrafico.escolhaGraficoBox.setVisible(true);
					telaGrafico.tituloField.setVisible(true);
					telaGrafico.tituloLabel.setVisible(true);
					telaGrafico.xLabel.setVisible(true);
					telaGrafico.yLabel.setVisible(true);
					telaGrafico.xField.setVisible(true);
					telaGrafico.yField.setVisible(true);
					telaGrafico.quantidadeAmostrasLabel.setVisible(true);
					telaGrafico.quantField.setVisible(true);
					telaGrafico.tipoAmostraLabel.setVisible(true);
					telaGrafico.getTipoAmostrasBox().setVisible(true);
					telaGrafico.getGerar().setText("GERAR GRAFICO");

				}else{
					telaGrafico.escolhaGrafico.setVisible(false);
					telaGrafico.escolhaGraficoBox.setVisible(false);
					telaGrafico.tituloField.setVisible(false);
					telaGrafico.tituloLabel.setVisible(false);
					telaGrafico.xLabel.setVisible(false);
					telaGrafico.yLabel.setVisible(false);
					telaGrafico.xField.setVisible(false);
					telaGrafico.yField.setVisible(false);
					telaGrafico.quantidadeAmostrasLabel.setVisible(false);
					telaGrafico.quantField.setVisible(false);
					telaGrafico.quantField.setText("1");
					telaGrafico.tipoAmostraLabel.setVisible(false);
					telaGrafico.getTipoAmostrasBox().setVisible(false);
					telaGrafico.getGerar().setText("GERAR HISTOGRAMA");
				}
			}
		});
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaGrafico.item1){
			new GuiaGrafico(telaGrafico.painelG);//Tratar
			return;
		}
		int quantidadeAmostras = 0;
		try{
			quantidadeAmostras = Integer.parseInt(telaGrafico.getQuantField().getText().replace(" ",""));
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null,"Quantidade Inválida");
			return;
		}
		//indicie pesquisa;
		int indicieP = telaGrafico.getEscolhaPesquisaBox().getSelectedIndex();

		if(Base.base.size()>0){
			if(validaTamanho(quantidadeAmostras,Base.base.get(indicieP).getDadosPesquisa().size())){
				JOptionPane.showMessageDialog(null,"A população não possui a quantidade de amostras nescessárias! ");
				return;
			}
			ArrayList<String> nomesAnteriores = new ArrayList<String>();
			ArrayList<Integer> quantidade = new ArrayList<Integer>();
			if(Base.base.get(indicieP).isQualitativa()){
				if(telaGrafico.getTipoAmostrasBox().getSelectedIndex() == 0){//aleatoria
					TiradorDeAmostras.retiraAleatoria(quantidadeAmostras, nomesAnteriores, quantidade, Base.base.get(indicieP).getDadosPesquisa());
					telaGrafico.getPainelGrafico().removeAll();
					if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==0){
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoColuna(base);
					}else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==1){//pizza
						DefaultPieDataset base = new DefaultPieDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.insertValue(i,nomesAnteriores.get(i),quantidade.get(i));
						}
						criarGraficoPizza(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==2){//barras
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoBarra(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==3){//polar
						criarGraficoPolar(nomesAnteriores,quantidade);
					}
					telaGrafico.updateUI();
					System.gc();
				}
				else if(telaGrafico.getTipoAmostrasBox().getSelectedIndex() == 1){//sistematica
					TiradorDeAmostras.retiraSistematica(quantidadeAmostras, nomesAnteriores, quantidade, Base.base.get(indicieP).getDadosPesquisa());
					telaGrafico.getPainelGrafico().removeAll();
					if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==0){
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoColuna(base);
					}else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==1){//pizza
						DefaultPieDataset base = new DefaultPieDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.insertValue(i,nomesAnteriores.get(i),quantidade.get(i));
						}
						criarGraficoPizza(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==2){//barra
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoBarra(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==3){//Polar
						criarGraficoPolar(nomesAnteriores,quantidade);
					}
					telaGrafico.updateUI();
					System.gc();
				}
				else if(telaGrafico.getTipoAmostrasBox().getSelectedIndex() == 2){//Estratificada
					TiradorDeAmostras.retiraEstratificada(quantidadeAmostras, nomesAnteriores, quantidade, Base.base.get(indicieP).getDadosPesquisa());
					if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==0){
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoColuna(base);
					}else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==1){//pizza
						DefaultPieDataset base = new DefaultPieDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.insertValue(i,nomesAnteriores.get(i),quantidade.get(i));
						}
						criarGraficoPizza(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==2){//barra
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoBarra(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==3){//Polar
						criarGraficoPolar(nomesAnteriores,quantidade);
					}
				}
				else if(telaGrafico.getTipoAmostrasBox().getSelectedIndex() == 3){//população
					quantidadeAmostras = Base.base.get(indicieP).getDadosPesquisa().size();
					TiradorDeAmostras.retiraAleatoria(quantidadeAmostras, nomesAnteriores, quantidade, Base.base.get(indicieP).getDadosPesquisa());
					telaGrafico.getPainelGrafico().removeAll();
					if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==0){
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoColuna(base);
					}else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==1){//pizza
						DefaultPieDataset base = new DefaultPieDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.insertValue(i,nomesAnteriores.get(i),quantidade.get(i));
						}
						criarGraficoPizza(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==2){//barras
						DefaultCategoryDataset base = new DefaultCategoryDataset();
						for(int i = 0;i<nomesAnteriores.size();i++){
							base.addValue(quantidade.get(i),nomesAnteriores.get(i),nomesAnteriores.get(i));
						}
						criarGraficoBarra(base);
					}
					else if(telaGrafico.getEscolhaGraficoBox().getSelectedIndex()==3){//polar
						criarGraficoPolar(nomesAnteriores,quantidade);
					}
					telaGrafico.updateUI();
					System.gc();
				}
				telaGrafico.updateUI();
				System.gc();
			}else{
				DadosTabelaFrequencia.frequencia(Base.base.get(indicieP).getDadosPesquisa().toArray(new String[Base.base.get(indicieP).getDadosPesquisa().size()]));
				DadosTabelaFrequencia.frequenciaRelativa(Base.base.get(indicieP).getDadosPesquisa().size());
				DadosTabelaFrequencia.frequenciaAcumulada();
				DadosTabelaFrequencia.FrequenciaRelativa();
				DadosTabelaFrequencia.Xi(Base.base.get(indicieP).getDadosPesquisa().toArray(new String[Base.base.get(indicieP).getDadosPesquisa().size()]));
				DadosTabelaFrequencia.XiFi();
				//histograma.
				//telaGrafico.getPainelGrafico().removeAll();
				histograma();
				telaGrafico.updateUI();
				System.gc();
			}
		}else{
			JOptionPane.showMessageDialog(null,"Crie Uma Pesquisa Primeiro");
			return;
		}

	}
	private void criarGraficoColuna(DefaultCategoryDataset base){
		telaGrafico.coluna = ChartFactory.createBarChart(telaGrafico.tituloField.getText(),telaGrafico.xField.getText() ,telaGrafico.yField.getText(),base,PlotOrientation.VERTICAL,true,true,false);
		CategoryAxis domainAxis = ((CategoryPlot) telaGrafico.coluna.getPlot()).getDomainAxis();

		//((CategoryPlot) telaGrafico.coluna.getPlot()).getRangeAxis().setAutoRange(true);
		domainAxis.setMinorTickMarksVisible(true);
		domainAxis.setCategoryLabelPositions(
				CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 4.0)
				);//telaGrafico.coluna.getCategoryPlot().setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);//deixa a coluna numerica em baixo

		//telaGrafico.coluna.getPlot().setOutlineVisible(false);
		//		((CategoryPlot) telaGrafico.coluna.getPlot()).setDomainGridlinesVisible(false);
		//		((CategoryPlot) telaGrafico.coluna.getPlot()).setRangeMinorGridlinesVisible(false);
		telaGrafico.coluna.getCategoryPlot().setBackgroundPaint(Color.WHITE);
		telaGrafico.painelG = new ChartPanel(telaGrafico.coluna);
		telaGrafico.scroll.setViewportView(telaGrafico.painelG);
		telaGrafico.getPainelGrafico().add(telaGrafico.scroll);
		telaGrafico.painelG.getPopupMenu().add(telaGrafico.item1);
		//domainAxis.setAxisLineVisible(false);

		System.gc();
	}
	private void criarGraficoPizza(DefaultPieDataset base){

		telaGrafico.pizza = ChartFactory.createPieChart3D(telaGrafico.tituloField.getText(),base);
		telaGrafico.painelG = new ChartPanel(telaGrafico.pizza);
		telaGrafico.scroll.setViewportView(telaGrafico.painelG);
		telaGrafico.getPainelGrafico().add(telaGrafico.scroll);
		telaGrafico.painelG.getPopupMenu().add(telaGrafico.item1);
		telaGrafico.pizza.getPlot().setBackgroundPaint(Color.WHITE);
		System.gc();
	}
	private void criarGraficoBarra(DefaultCategoryDataset base){
		telaGrafico.coluna = ChartFactory.createBarChart3D(telaGrafico.tituloField.getText(),telaGrafico.yField.getText(), telaGrafico.xField.getText(), base,PlotOrientation.HORIZONTAL,true,true,false);
		telaGrafico.coluna.getCategoryPlot().setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);//deixa a coluna numerica em baixo
		telaGrafico.painelG = new ChartPanel(telaGrafico.coluna);
		telaGrafico.scroll.setViewportView(telaGrafico.painelG); //= new JScrollPane(telaGrafico.painelG);
		telaGrafico.getPainelGrafico().add(telaGrafico.scroll);
		telaGrafico.painelG.getPopupMenu().add(telaGrafico.item1);
		telaGrafico.coluna.getCategoryPlot().setBackgroundPaint(Color.WHITE);
		System.gc();
	}

	private void criarGraficoPolar(ArrayList<String>dados,ArrayList<Integer>quant){
		ordenar(dados,quant);
		XYSeriesCollection categoria = new XYSeriesCollection();
		double salto =(double)360/(double)dados.size();
		XYSeries categoriaAux = new XYSeries("Não sei Pra que serve");
		for(int i = 0;i<dados.size();i++){
			double quantidade1 = quant.get(i);
			if(i+1>=dados.size()){//caso seja o ultimo elemento
				double quantidade2 = quant.get(0);
				categoriaAux.add(i*salto,quantidade1);//crio o ultimo ponto
				categoriaAux.add(0,quantidade2);//ligo o ultimo ponto ao primeiro
			}
			else{
				double quantidade2 = quant.get(i+1);//pego a quatidade da posicao seguinte
				categoriaAux.add(i*salto,quantidade1);//crio  ponto da posicao atual
				categoriaAux.add((i+1)*salto,quantidade2);//ligo ao ponto da posiçao seguinte
			}
		}
		categoria.addSeries(categoriaAux);
		ValueAxis radiusAxis = new NumberAxis();
		radiusAxis.setLabelFont(TelaGraficos.font);
		radiusAxis.setTickLabelsVisible(true);
		DefaultPolarItemRenderer renderer = new DefaultPolarItemRenderer();
		renderer.setFillComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));	
		PolarPlot polar = new PolarPlot(categoria,radiusAxis,renderer){
			protected List refreshAngleTicks(){
				List<NumberTick>ticks = new ArrayList<NumberTick>();
				NumberTick n ;
				for(int i = 0;i<dados.size();i++){
					if(i<dados.size()/2){
						n = new NumberTick(i*salto, dados.get(i)+","+quant.get(i),TextAnchor.BASELINE_LEFT,TextAnchor.TOP_CENTER,0.0);
						
						ticks.add(n);
					}
					else{
						ticks.add(n = new NumberTick(i*salto,""+dados.get(i)+","+quant.get(i),
								TextAnchor.TOP_RIGHT,TextAnchor.TOP_CENTER,0.0));
					}
					renderer.setSeriesFilled(i,true);
				}
				return ticks;
			}
		};
		polar.setBackgroundPaint(Color.white);
		polar.setAngleGridlinePaint(Color.blue);
		polar.setRadiusMinorGridlinesVisible(false);
		polar.setRadiusGridlinePaint(Color.black);
		polar.setAxisLocation(PolarAxisLocation.NORTH_LEFT);
		telaGrafico.polar = new JFreeChart
				(telaGrafico.tituloField.getText(),JFreeChart.DEFAULT_TITLE_FONT,polar,false);
		telaGrafico.polar.setBackgroundPaint(TelaGraficos.violeta);
		telaGrafico.painelG = new ChartPanel(telaGrafico.polar);
		telaGrafico.painelG.setMouseZoomable(false);
		telaGrafico.scroll.setViewportView(telaGrafico.painelG);
		telaGrafico.getPainelGrafico().add(telaGrafico.scroll);
		telaGrafico.painelG.getPopupMenu().add(telaGrafico.item1);
	}
	private XYDataset criarDataHistograma(){
		XYSeriesCollection dataset = new XYSeriesCollection();

		float pulo = DadosTabelaFrequencia.pulo;
		for(int i=0;i<DadosTabelaFrequencia.frequencia.length;i++){
			XYSeries serie1 = new XYSeries(i+"");
			float ant = DadosTabelaFrequencia.inferior.get(i);
			float prox = (float)DadosTabelaFrequencia.superior.get(i);
			if(i==0){
				serie1.add(ant,0);//lI
				serie1.add(ant,(float)DadosTabelaFrequencia.frequencia[i]);//lI
				serie1.add(prox,(float)DadosTabelaFrequencia.frequencia[i]);//LI
				serie1.add(prox,0);
			}
			if(i>0){
				serie1.add(ant,DadosTabelaFrequencia.frequencia[i-1]);
				serie1.add(ant,(float)DadosTabelaFrequencia.frequencia[i]);//lI
				serie1.add(prox,(float)DadosTabelaFrequencia.frequencia[i]);//LI
				serie1.add(prox,0);
				System.out.println((float)DadosTabelaFrequencia.inferior.get(i)+" "+(float)DadosTabelaFrequencia.superior.get(i)+" "+DadosTabelaFrequencia.frequencia[i]);

			}

			if((i+1)>=DadosTabelaFrequencia.frequencia.length)
				serie1.add(prox,0);
			dataset.addSeries(serie1);
		}

		//dataset.addSeries(serie1);
		return dataset;
	}
	private void histograma() {
		// create the chart...
		XYDataset dataset = criarDataHistograma();
		final JFreeChart chart = ChartFactory.createXYLineChart(
				"Histograma",      // chart title
				"Classes",                      // x axis label
				"f",                      // y axis label
				dataset,                  // data
				PlotOrientation.VERTICAL,
				false,                     // include legend
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
		plot.setRenderer(renderer);
		for(int i=0;i<DadosTabelaFrequencia.frequencia.length;i++){
			plot.getRenderer().setSeriesPaint(i,Color.BLACK);
			renderer.setSeriesLinesVisible(i, true);//linhas
			renderer.setSeriesShapesVisible(i, false);//pontos
		}

		// change the auto tick unit selection to integer units only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		telaGrafico.histograma = chart;
	
		//telaGrafico.coluna.getCategoryPlot().setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);//deixa a coluna numerica em baixo
		telaGrafico.painelG = new ChartPanel(telaGrafico.histograma);
		telaGrafico.scroll.setViewportView(telaGrafico.painelG); //= new JScrollPane(telaGrafico.painelG);
		telaGrafico.getPainelGrafico().add(telaGrafico.scroll);
		telaGrafico.painelG.getPopupMenu().add(telaGrafico.item1);
		System.gc();
	}
	private void ordenar(ArrayList<String>dados,ArrayList<Integer>quant){
		System.out.println("Antes");
		System.out.println(dados.toString());
		System.out.println(quant.toString());
		for(int i = 0;i<quant.size();i++){//ordenar do > para o <
			for(int j=i+1;j<quant.size();j++){
				if(quant.get(i) > quant.get(j)){
					int auxNumero = quant.get(i);
					String auxNome =  dados.get(i);
					quant.set(i, quant.get(j));
					dados.set(i, dados.get(j));
					quant.set(j,auxNumero);
					dados.set(j,auxNome);
				}
			}
		}
		System.out.println("Depois");
		System.out.println(dados.toString());
		System.out.println(quant.toString());
	}

	public static boolean validaTamanho(int tam,int tamBase){
		if(tam>tamBase)
			return true;
		return false;
	}
}
