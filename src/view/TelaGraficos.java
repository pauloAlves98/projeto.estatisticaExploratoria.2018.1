package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import imagens.CarregadorDeImagem;
import model.Cor;
import model.Fonte;

public class TelaGraficos extends JGradientePanel {
	
	public JFreeChart coluna,pizza,polar,histograma;
	public JLabel xLabel,yLabel,tituloLabel;
	public JTextField xField,yField,tituloField;
	public JScrollPane scroll;
	public ChartPanel painelG;
	public JMenuItem item1;
	public static Color violeta = new Color(0,206,209);
	public  JLabel escolhaGrafico,escolhaPesquisa,tipoAmostraLabel,quantidadeAmostrasLabel;
	public JComboBox escolhaGraficoBox,escolhaPesquisaBox,tipoAmostrasBox;
	private JButton gerar;
	private JPanel painelOpcoes,painelGrafico;
	public JTextField quantField;
	public static Font font = Fonte.AGENCY18;
	public TelaGraficos(){
		super(Cor.cor2,Cor.cor1);
		setBackground(Cor.cor2);
		setLayout(new BorderLayout());
		//instancias

		xLabel = new JLabel("NOME EIXO X");
		yLabel = new JLabel("NOME EIXO Y");
		tituloLabel = new JLabel("TÍTULO");
		tituloField = new JTextField(4);
		xField = new JTextField(4);
		yField = new JTextField(4);
		scroll = new JScrollPane();
		scroll.setPreferredSize(new Dimension(400,400));
		
		item1 = new JMenuItem("GERAR GRÁFICO EM NOVA GUIA");
		tipoAmostraLabel = new JLabel("AMOSTRA/POPULAÇÃO");
		quantidadeAmostrasLabel = new JLabel("QUANTIDADE");
		quantField = new JTextField(4);
		painelOpcoes = new JPanel(new GridLayout(7,2,1,0));
		painelOpcoes.setOpaque(false);
		escolhaGrafico = new JLabel("GRÁFICO");
		escolhaPesquisa = new JLabel("PESQUISA");
		gerar = new JButton("GERAR GRÁFICO");
		painelGrafico = new JPanel(new BorderLayout());
		String amostras[] ={"ALEATORIA","SISTEMÁTICA","ESTRATIFICADA","COMPLETA"};
		tipoAmostrasBox = new JComboBox(amostras);
		//Configurações extras
		xLabel.setForeground(Color.BLACK);
		xLabel.setFont(TelaGraficos.font);
		yLabel.setForeground(Color.BLACK);
		yLabel.setFont(TelaGraficos.font);
		tituloLabel.setForeground(Color.BLACK);
		tituloLabel.setFont(TelaGraficos.font);
		tipoAmostrasBox.setFont(TelaGraficos.font);
		tipoAmostrasBox.setForeground(Color.BLACK);
		tipoAmostrasBox.setFont(TelaGraficos.font);
		tipoAmostrasBox.setBackground(Cor.cor2);
		quantidadeAmostrasLabel.setForeground(Color.black);
		quantidadeAmostrasLabel.setFont(TelaGraficos.font);
		escolhaGrafico.setFont(font);
		escolhaGrafico.setForeground(Color.BLACK);
		escolhaPesquisa.setFont(font);
		escolhaPesquisa.setForeground(Color.BLACK);
		tipoAmostraLabel.setForeground(Color.black);
		tipoAmostraLabel.setFont(TelaGraficos.font);
		gerar.setFont(font);
		painelOpcoes.setPreferredSize(new Dimension(330,300));
		gerar.setBackground(Cor.cor1);
		gerar.setForeground(Cor.cor2)
		;
		gerar.setFocusPainted(false);
		ImageIcon []itens ={
				new ImageIcon(CarregadorDeImagem.carregarImagem("graficoColuna.jpg")),
				new ImageIcon(CarregadorDeImagem.carregarImagem("graficoPizza.jpg")),
				new ImageIcon(CarregadorDeImagem.carregarImagem("barra.jpg")),
				new ImageIcon(CarregadorDeImagem.carregarImagem("polar1.jpg"))
		};
		escolhaGraficoBox = new JComboBox(itens);
		escolhaGraficoBox.setBackground(Cor.cor2);
		escolhaGraficoBox.setPreferredSize(new Dimension(168,50));
		
		escolhaPesquisaBox = new JComboBox();
		escolhaPesquisaBox.addItem("Clubes de Futebol");
		escolhaPesquisaBox.setPreferredSize(new Dimension(168,50));
		escolhaPesquisaBox.setBackground(Cor.cor2);
		escolhaPesquisaBox.setForeground(Color.black);
		escolhaPesquisaBox.setFont(font);
		
		painelOpcoes.add(escolhaGrafico);
		painelOpcoes.add(escolhaGraficoBox);
		painelOpcoes.add(escolhaPesquisa);
		painelOpcoes.add(escolhaPesquisaBox);
		painelOpcoes.add(tipoAmostraLabel);
		painelOpcoes.add(tipoAmostrasBox);
		painelOpcoes.add(quantidadeAmostrasLabel);
		painelOpcoes.add(quantField);
		painelOpcoes.add(tituloLabel);
		painelOpcoes.add(tituloField);
		painelOpcoes.add(xLabel);
		painelOpcoes.add(xField);
		painelOpcoes.add(yLabel);
		painelOpcoes.add(yField);
		//painelOpcoes.add(gerar);
		painelOpcoes.setBackground(Cor.cor2);
		//Deixar Gerar no meio
		JGradientePanel aux = new JGradientePanel(Cor.cor2,Cor.cor1);
		aux.add(painelOpcoes,BorderLayout.NORTH);
		aux.setPreferredSize(new Dimension(340,250));
		aux.add(gerar,BorderLayout.SOUTH);
		aux.setBackground(Cor.cor2);
		
		add(aux,BorderLayout.WEST);
		painelGrafico.setBackground(Color.WHITE);
		//painelGrafico.add(scroll);
		//scroll.setVisible(false);
		add(painelGrafico);
		System.out.println(painelGrafico.getWidth());
		System.out.println(painelGrafico.getHeight());
		
	}
	public JComboBox getEscolhaGraficoBox() {
		return escolhaGraficoBox;
	}
	public void setEscolhaGraficoBox(JComboBox escolhaGraficoBox) {
		this.escolhaGraficoBox = escolhaGraficoBox;
	}
	public JComboBox getEscolhaPesquisaBox() {
		return escolhaPesquisaBox;
	}
	public void setEscolhaPesquisaBox(JComboBox escolhaPesquisaBox) {
		this.escolhaPesquisaBox = escolhaPesquisaBox;
	}
	public JButton getGerar() {
		return gerar;
	}
	public void setGerar(JButton gerar) {
		this.gerar = gerar;
	}
	public JPanel getPainelGrafico() {
		return painelGrafico;
	}
	public void setPainelGrafico(JPanel painelGrafico) {
		this.painelGrafico = painelGrafico;
	}
	public JComboBox getTipoAmostrasBox() {
		return tipoAmostrasBox;
	}
	public void setTipoAmostrasBox(JComboBox tipoAmostrasBox) {
		this.tipoAmostrasBox = tipoAmostrasBox;
	}
	public JTextField getQuantField() {
		return quantField;
	}
	public void setQuantField(JTextField quantField) {
		this.quantField = quantField;
	}
	
}
