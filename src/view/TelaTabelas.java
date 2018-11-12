package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import app.App;
import model.Cor;

public class TelaTabelas extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel escolhaPesquisaLabel,quantidadeAmostrasLabel,tipoAmostraLabel,fontLabel,
	tituloTabelaLabel,colunaIndicadora,colunaNumerica;
	private JPanel painel;
	public PanelTabela painelTabela;
	public JComboBox escolhaPesquisaBox;
	private JComboBox tipoAmostrasBox;
	private JButton gerarTabelaButton;
	public JTextField quantField,tituloTabelaField,fontField,colunaIndicadoraField,
	colunaNumericaField;
	public JTable tabela;
	public JPopupMenu menu;
	public JMenuItem item1,exportarItem;
	public static TelaMedidas telaMedidas = new TelaMedidas();
	public JFileChooser seletorFiles;
	//Tabelas são criardas no Controler
	public TelaTabelas(){
		//Instancias
		setLayout(new BorderLayout());
		menu = new JPopupMenu();
		item1 = new JMenuItem("MEDIDAS DE DISPERSÃO");
		exportarItem = new JMenuItem("EXPORTAR XLS");
		menu.add(item1);
		menu.add(exportarItem);
		App.lookWindows();
		seletorFiles = new JFileChooser();
		App.lookPadrao();
		colunaIndicadora = new JLabel("COLUNA INDICADORA");
		colunaNumerica = new JLabel("COLUNA NÚMERICA");
		tituloTabelaLabel = new JLabel("TÍTULO");
		fontLabel = new JLabel("FONTE");
		colunaIndicadoraField = new JTextField(4);
		colunaNumericaField = new JTextField(4);
		fontField = new JTextField(4);
		tituloTabelaField = new JTextField(4);
		painel = new JPanel(new GridLayout(7,2));
		painel.setOpaque(false);
		painelTabela = new PanelTabela();
		//painelTabela.setLayout(new BoxLayout(painelTabela,BoxLayout.Y_AXIS));
	    tabela = new JTable();

		escolhaPesquisaLabel = new JLabel("PESQUISA");
		gerarTabelaButton = new JButton("GERAR TABELA");
		tipoAmostraLabel = new JLabel("AMOSTRA/POPULAÇÃO");
		quantidadeAmostrasLabel = new JLabel("QUANTIDADE");
		quantField = new JTextField(4);
		String amostras[] ={"ALEATORIA","SISTEMÁTICA","ESTRATIFICADA","COMPLETA"};
		tipoAmostrasBox = new JComboBox(amostras);
		escolhaPesquisaBox = new JComboBox();
		escolhaPesquisaBox.addItem("Clubes de Futebol");
		//Config extas
		gerarTabelaButton.setFont(TelaGraficos.font);
		gerarTabelaButton.setBackground(Color.BLACK);
		gerarTabelaButton.setForeground(Color.WHITE);
		escolhaPesquisaLabel.setFont(TelaGraficos.font);
		escolhaPesquisaLabel.setForeground(Color.BLACK);
		colunaNumerica.setFont(TelaGraficos.font);
		colunaNumerica.setForeground(Color.BLACK);
		fontLabel.setFont(TelaGraficos.font);
		fontLabel.setForeground(Color.BLACK);
		tituloTabelaLabel.setFont(TelaGraficos.font);
		tituloTabelaLabel.setForeground(Color.BLACK);
		colunaIndicadora.setFont(TelaGraficos.font);
		colunaIndicadora.setForeground(Color.BLACK);
		escolhaPesquisaBox.setFont(TelaGraficos.font);
		escolhaPesquisaBox.setBackground(Color.white);
		escolhaPesquisaBox.setPreferredSize(new Dimension(168,50));
		tipoAmostrasBox.setFont(TelaGraficos.font);
		tipoAmostrasBox.setForeground(Color.BLACK);
		tipoAmostrasBox.setFont(TelaGraficos.font);
		tipoAmostrasBox.setBackground(Color.white);
		tipoAmostrasBox.setPreferredSize(new Dimension(168,50));
		quantidadeAmostrasLabel.setForeground(Color.black);
		quantidadeAmostrasLabel.setFont(TelaGraficos.font);
		tipoAmostraLabel.setForeground(Color.black);
		tipoAmostraLabel.setFont(TelaGraficos.font);
		gerarTabelaButton.setBackground(TelaGraficos.violeta);
		painel.setPreferredSize(new Dimension(330,300));
		painel.setBackground(Color.white);
		//painelTabela.setLayout(new BorderLayout());
		painelTabela.setBackground(Color.white);
		//
		tabela.setFont(new Font("Arial",Font.BOLD,11));
		tabela.setBorder(new LineBorder(Color.black,1,false));
		//tabela.setShowGrid(false);
		
		painel.add(escolhaPesquisaLabel);
		painel.add(escolhaPesquisaBox);
		painel.add(tipoAmostraLabel);
		painel.add(tipoAmostrasBox);
		painel.add(quantidadeAmostrasLabel);
		painel.add(quantField);
		painel.add(tituloTabelaLabel);
		painel.add(tituloTabelaField);
		painel.add(fontLabel);
		painel.add(fontField);
		painel.add(colunaIndicadora);
		painel.add(colunaIndicadoraField);
		painel.add(colunaNumerica);
		painel.add(colunaNumericaField);
		
		
		
		//pra deixar gerar no meio
		JPanel aux = new JGradientePanel(Cor.cor2,Cor.cor1);
		aux.add(painel,BorderLayout.NORTH);
		aux.setPreferredSize(new Dimension(335,250));
		aux.add(gerarTabelaButton,BorderLayout.SOUTH);
		aux.setBackground(Color.white);
		painelTabela.setOpaque(false);
		add(aux,BorderLayout.WEST);
		add(painelTabela,BorderLayout.CENTER);
	}
	public JComboBox getEscolhaPesquisaBox() {
		return escolhaPesquisaBox;
	}
	public void setEscolhaPesquisaBox(JComboBox escolhaPesquisaBox) {
		this.escolhaPesquisaBox = escolhaPesquisaBox;
	}
	public JComboBox getTipoAmostrasBox() {
		return tipoAmostrasBox;
	}
	public void setTipoAmostrasBox(JComboBox tipoAmostrasBox) {
		this.tipoAmostrasBox = tipoAmostrasBox;
	}
	public JButton getGerarTabelaButton() {
		return gerarTabelaButton;
	}
	public void setGerarTabelaButton(JButton gerarTabelaButton) {
		this.gerarTabelaButton = gerarTabelaButton;
	}
	public JTextField getQuantField() {
		return quantField;
	}
	public void setQuantField(JTextField quantField) {
		this.quantField = quantField;
	}
	public PanelTabela getPainelTabela() {
		return painelTabela;
	}
	public void setPainelTabela(PanelTabela painelTabela) {
		this.painelTabela = painelTabela;
	}
	public JPanel getPainel() {
		return painel;
	}
	public void setPainel(JPanel painel) {
		this.painel = painel;
	}

}
