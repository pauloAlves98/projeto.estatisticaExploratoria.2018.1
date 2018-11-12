package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Cor;

public class TelaCriarPesquisa extends JGradientePanel {
	public JTextField nomePesquisaField;
	public JLabel tipoPesquisaLabel;
	public JComboBox tipoPesqCombo;
	public JLabel nomePesquisaLabel ;
	public 	JButton salvarPesquisaButton;
	public JTextArea listaPrevia;
	/**
	 * Create the panel.
	 */
	public TelaCriarPesquisa() {
		super(Cor.cor1,Color.BLACK);
		setBackground(Cor.cor2);
		setPreferredSize(new Dimension(900,600));
		setLayout(null);
		
	    tipoPesquisaLabel = new JLabel("Tipo da Pesquisa");
		tipoPesquisaLabel.setFont(new Font("Agency FB", Font.BOLD, 26));
		tipoPesquisaLabel.setForeground(Cor.cor2);
		tipoPesquisaLabel.setForeground(Color.black);
		tipoPesquisaLabel.setBounds(56, 11, 257, 33);
		add(tipoPesquisaLabel);
		
		tipoPesqCombo = new JComboBox();
		tipoPesqCombo.setBackground(Cor.cor2);
		tipoPesqCombo.setForeground(Cor.cor1);
		tipoPesqCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		tipoPesqCombo.setModel(new DefaultComboBoxModel(new String[] {"QUALITATIVA","QUANTITATIVA"}));
		tipoPesqCombo.setBounds(56, 55, 157, 33);
		add(tipoPesqCombo);
		
		nomePesquisaLabel = new JLabel("Nome da Pesquisa");
		nomePesquisaLabel.setForeground(Color.BLACK);
		nomePesquisaLabel.setFont(new Font("Agency FB", Font.BOLD, 22));
		nomePesquisaLabel.setBounds(56, 118, 157, 23);
		add(nomePesquisaLabel);
		
		nomePesquisaField = new JTextField();
		nomePesquisaField.setBounds(56, 141, 147, 33);
		add(nomePesquisaField);
		nomePesquisaField.setColumns(10);
		


		
		JLabel dadoLabel = new JLabel("Dado");
		dadoLabel.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		dadoLabel.setBounds(56, 239, 46, 14);
		//add(dadoLabel);
		salvarPesquisaButton = new JButton("Salvar Pesquisa");
		salvarPesquisaButton.setBounds(56, 420, 157, 33);
		add(salvarPesquisaButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(56, 185, 448, 226);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane visualizadorPane = new JScrollPane();
		panel.add(visualizadorPane, BorderLayout.CENTER);
		
		listaPrevia = new JTextArea();
		visualizadorPane.setViewportView(listaPrevia);
		listaPrevia.setEditable(true);
		listaPrevia.setLineWrap(true);
		listaPrevia.setWrapStyleWord(true);
		listaPrevia.setFont(new Font("Arial",Font.PLAIN,12));
		listaPrevia.setBorder(new LineBorder(Cor.cor1,2,true));
		JLabel lblInformaes = new JLabel("INFORMA\u00C7\u00D5ES");
	
		lblInformaes.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblInformaes.setForeground(	Color.BLACK);
		
		lblInformaes.setBounds(557, 142, 133, 23);
		add(lblInformaes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(525, 185, 157, 226);
		add(scrollPane);
		
		JTextArea txtrAteno = new JTextArea();
		
		txtrAteno.setForeground(Cor.cor2);
		txtrAteno.setBackground(Cor.cor1);
		txtrAteno.setBorder(new LineBorder(Cor.cor2,2,true));
		txtrAteno.setFont(new Font("Agency FB", Font.PLAIN, 23));
		txtrAteno.setText("Aten\u00E7\u00E3o: os dados devem ser inseridos  separados pelo car\u00E1cter especial '@' Ex: dado1@dado2@...@dadoN.");
		txtrAteno.setEditable(false);
		txtrAteno.setLineWrap(true);
		txtrAteno.setWrapStyleWord(true);
		scrollPane.setViewportView(txtrAteno);
		salvarPesquisaButton.setBackground(TelaGraficos.violeta);
		salvarPesquisaButton.setForeground(Color.white);
		salvarPesquisaButton.setFont(TelaGraficos.font);
	}
}
