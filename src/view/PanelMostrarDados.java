package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import model.Cor;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelMostrarDados extends JGradientePanel {

	/**
	 * Create the panel.
	 */
	public JComboBox pesquisasCombo ;
	public JTextArea dadosArea;
	public PanelMostrarDados() {
		super(Cor.cor1,Color.BLACK);
		this.setPreferredSize(new Dimension(900,600));
		setBackground(Cor.cor2);
		setLayout(null);
		
		pesquisasCombo = new JComboBox();
		pesquisasCombo.setFont(new Font("Agency FB", Font.PLAIN, 18));
		pesquisasCombo.setBounds(46, 71, 220, 34);
		add(pesquisasCombo);
		
		JScrollPane scrollArea = new JScrollPane();
		scrollArea.setBounds(46, 127, 582, 317);
		add(scrollArea);
		
	    dadosArea = new JTextArea();
		dadosArea.setFont(new Font("Agency FB", Font.BOLD, 18));
		dadosArea.setWrapStyleWord(true);
		dadosArea.setLineWrap(true);
		scrollArea.setViewportView(dadosArea);
		pesquisasCombo.setBackground(Cor.cor1);
		pesquisasCombo.setForeground(Cor.cor2);
		JLabel lblSelecioneAPesquisa = new JLabel("Selecione a Pesquisa");
		lblSelecioneAPesquisa.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblSelecioneAPesquisa.setBackground(Color.BLACK);
		lblSelecioneAPesquisa.setBounds(46, 11, 311, 49);
		add(lblSelecioneAPesquisa);
		

	}
}
