package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Cor;
import model.Fonte;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class TelaMedidas extends JDialog {

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
		public JLabel mediaLabel,amplitudeLabel,desvioPadraoLabel,percentilLabel,
		modaLabel,medianaLabel,q1Label,q2Label,q3Label,varianciaLabel,cofLabel;
		public JTextField mediaField,amplitudeField,desvioPadraoField,percentilField,
		modaField,medianaField,q1Field,q2Field,q3Field,varianciaField,cofField,numPerField;
		public JButton calcularPercentilButton;
		private JLabel lblMdiaNormal;
		private JLabel lblMedianaNormal;
		public JTextField mediaNormalField;
		public JTextField medianaNormalField;
		private JLabel lblVarinciaNormal;
		public JLabel lblCoefVarNormal;
		public JLabel lblDesvioPadroNormal;
		public JTextField coefNormalfield;
		public JTextField varianciaNormalField;
		public JTextField desvioNormalField;
		private JPanel panel_5;
		public JSeparator separator_1;
		public  JLabel quartil1NormalLabel;
		public JTextField quartil1NormalField;
		public  JLabel quartil2Normal;
		public  JTextField quartil2NormalField;
		public JLabel quartil3Normal;
		public JTextField quartil3NormalField;
		private JLabel percentilNormal;
		public JTextField reusultadoPercentilNormalField;
		public JTextField numPercentilNormalField;
		private JPanel panel_6;
		public JButton calcularPercentilNormalButton;
		private JLabel maxNormalLabel;
		public JTextField maxNormalField;
		private JLabel minNormalLabel;
		public JTextField minNormalField;
		private JLabel lblModaNormal;
		public JTextField modaNormalField;
		public TelaMedidas(){
			
			setSize(342,555);
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			setLocationRelativeTo(null);
			init();
			getContentPane().setLayout(new GridLayout(1, 2, 0, 0));
			
			JPanel panel = new JPanel();
			panel.setBackground(Cor.cor1);
			getContentPane().add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			JLabel lblMedidasNormal = new JLabel("      MEDIDAS NORMAL");
			panel.add(lblMedidasNormal,BorderLayout.NORTH);
			lblMedidasNormal.setPreferredSize(new Dimension(300,100));
			lblMedidasNormal.setFont(Fonte.AGENCY18);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Cor.cor2);
			panel.add(panel_1);
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			
			lblMdiaNormal = new JLabel("M\u00E9dia Normal");
			panel_1.add(lblMdiaNormal);
			lblMdiaNormal.setFont(Fonte.AGENCY18);
			
			mediaNormalField = new JTextField();
			mediaNormalField .setBackground(Cor.cor1);
			mediaNormalField.setForeground(Cor.cor2);
			mediaNormalField.setFont(Fonte.AGENCY18);
			panel_1.add(mediaNormalField);
			mediaNormalField.setEditable(false);
			mediaNormalField.setColumns(10);
			
			lblModaNormal = new JLabel("Moda Normal");
			lblModaNormal.setFont(Fonte.AGENCY18);
			panel_1.add(lblModaNormal);
			
			modaNormalField = new JTextField();
			modaNormalField .setBackground(Cor.cor1);
			modaNormalField.setForeground(Cor.cor2);
			modaNormalField.setFont(Fonte.AGENCY18);
			modaNormalField.setEditable(false);
			panel_1.add(modaNormalField);
			modaNormalField.setColumns(10);
			
			lblMedianaNormal = new JLabel("Mediana Normal");
			panel_1.add(lblMedianaNormal);
			lblMedianaNormal.setFont(Fonte.AGENCY18);
			
			medianaNormalField = new JTextField();
			panel_1.add(medianaNormalField);
			medianaNormalField.setEditable(false);
			medianaNormalField.setColumns(10);
			medianaNormalField .setBackground(Cor.cor1);
			medianaNormalField.setForeground(Cor.cor2);
			medianaNormalField.setFont(Fonte.AGENCY18);
			amplitudeLabel = new JLabel("Amplitude");
			panel_1.add(amplitudeLabel);
			amplitudeLabel.setFont(Fonte.AGENCY18);
			amplitudeField = new JTextField(7);
			amplitudeField.setEditable(false);
			amplitudeField.setBackground(Cor.cor1);
			amplitudeField.setForeground(Cor.cor2);
			amplitudeField.setFont(Fonte.AGENCY18);
			panel_1.add(amplitudeField);
			
			lblVarinciaNormal = new JLabel("Vari\u00E2ncia Normal");
			panel_1.add(lblVarinciaNormal);
			lblVarinciaNormal.setFont(Fonte.AGENCY18);
			
			varianciaNormalField = new JTextField();
			panel_1.add(varianciaNormalField);
			varianciaNormalField.setEditable(false);
			varianciaNormalField.setColumns(10);
			varianciaNormalField.setBackground(Cor.cor1);
			varianciaNormalField.setForeground(Cor.cor2);
			varianciaNormalField.setFont(Fonte.AGENCY18);
			lblCoefVarNormal = new JLabel("Coef. Varia\u00E7\u00E3o Normal");
			panel_1.add(lblCoefVarNormal);
			lblCoefVarNormal.setFont(Fonte.AGENCY18);
			
			coefNormalfield = new JTextField();
			panel_1.add(coefNormalfield);
			coefNormalfield.setEditable(false);
			coefNormalfield.setColumns(10);
			coefNormalfield.setBackground(Cor.cor1);
			coefNormalfield.setForeground(Cor.cor2);
			coefNormalfield.setFont(Fonte.AGENCY18);
			lblDesvioPadroNormal = new JLabel("Desvio Padr\u00E3o Normal");
			panel_1.add(lblDesvioPadroNormal);
			lblDesvioPadroNormal.setFont(Fonte.AGENCY18);
			
			desvioNormalField = new JTextField();
			desvioNormalField.setBackground(Cor.cor1);
			desvioNormalField.setForeground(Cor.cor2);
			desvioNormalField.setFont(Fonte.AGENCY18);
			panel_1.add(desvioNormalField);
			desvioNormalField.setEditable(false);
			desvioNormalField.setText("");
			desvioNormalField.setColumns(10);
			
			quartil1NormalLabel = new JLabel("Quartil 1 Normal");
			quartil1NormalLabel.setFont(Fonte.AGENCY18);
			panel_1.add(quartil1NormalLabel);
			
			quartil1NormalField = new JTextField();
			quartil1NormalField .setBackground(Cor.cor1);
			quartil1NormalField .setForeground(Cor.cor2);
			quartil1NormalField .setFont(Fonte.AGENCY18);
			quartil1NormalField.setEditable(false);
			panel_1.add(quartil1NormalField);
			quartil1NormalField.setColumns(10);
			
			quartil2Normal = new JLabel("Quartil 2 Normal");
			quartil2Normal.setFont(Fonte.AGENCY18);
			panel_1.add(quartil2Normal);
			
			quartil2NormalField = new JTextField();
			quartil2NormalField .setBackground(Cor.cor1);
			quartil2NormalField .setForeground(Cor.cor2);
			quartil2NormalField .setFont(Fonte.AGENCY18);
			quartil2NormalField.setEditable(false);
			panel_1.add(quartil2NormalField);
			quartil2NormalField.setColumns(10);
			
			quartil3Normal = new JLabel("Quartil 3 Normal");
			quartil3Normal.setFont(Fonte.AGENCY18);
			panel_1.add(quartil3Normal);
			
			quartil3NormalField = new JTextField();
			quartil3NormalField .setBackground(Cor.cor1);
			quartil3NormalField .setForeground(Cor.cor2);
			quartil3NormalField .setFont(Fonte.AGENCY18);
			quartil3NormalField.setEditable(false);
			panel_1.add(quartil3NormalField);
			quartil3NormalField.setColumns(10);
			
			maxNormalLabel = new JLabel("Max");
			maxNormalLabel.setFont(Fonte.AGENCY18);
			panel_1.add(maxNormalLabel);
			
			maxNormalField = new JTextField();
			maxNormalField .setBackground(Cor.cor1);
			maxNormalField .setForeground(Cor.cor2);
			maxNormalField .setFont(Fonte.AGENCY18);
			maxNormalField.setEditable(false);
			panel_1.add(maxNormalField);
			maxNormalField.setColumns(10);
			
			minNormalLabel = new JLabel("Min");
			minNormalLabel.setFont(Fonte.AGENCY18);
			panel_1.add(minNormalLabel);
			
			minNormalField = new JTextField();
			minNormalField .setBackground(Cor.cor1);
			minNormalField  .setForeground(Cor.cor2);
			minNormalField  .setFont(Fonte.AGENCY18);
			minNormalField .setEditable(false);
			panel_1.add(minNormalField);
			minNormalField.setColumns(10);
			
			
			percentilNormal = new JLabel("Percentil Normal");
			percentilNormal.setFont(Fonte.AGENCY18);
			panel_1.add(percentilNormal);
			
			panel_6 = new JPanel();
			panel_1.add(panel_6);
			panel_6.setLayout(new GridLayout(0, 3, 0, 0));
			
			reusultadoPercentilNormalField = new JTextField();
			reusultadoPercentilNormalField.setBackground(Cor.cor1);
			reusultadoPercentilNormalField.setForeground(Cor.cor2);
			reusultadoPercentilNormalField.setFont(Fonte.AGENCY18);
			panel_6.add(reusultadoPercentilNormalField);
			reusultadoPercentilNormalField.setEditable(false);
			reusultadoPercentilNormalField.setColumns(10);
			
			numPercentilNormalField = new JTextField();
			setBackground(Cor.cor1);
			numPercentilNormalField  .setForeground(Cor.cor1);
			numPercentilNormalField.setBackground(Cor.cor2);
			numPercentilNormalField  .setFont(Fonte.AGENCY18);
			panel_6.add(numPercentilNormalField);
			numPercentilNormalField.setColumns(10);
			
			calcularPercentilNormalButton = new JButton("GO");
			calcularPercentilNormalButton.setBackground(Cor.cor2);
			calcularPercentilNormalButton.setForeground(Cor.cor1);
			
			panel_6.add(calcularPercentilNormalButton);
			getContentPane().setBackground(Color.WHITE);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(Cor.cor1);
			getContentPane().add(panel_4);
			panel_4.setLayout(new BorderLayout(0, 0));
			
			panel_5 = new JPanel();
			panel_4.add(panel_5, BorderLayout.NORTH);
			panel_5.setLayout(new BorderLayout(0, 0));
			
			JLabel lblMedidasTabela = new JLabel("       MEDIDAS TABELA");
			panel_5.add(lblMedidasTabela,BorderLayout.CENTER);
			panel_5.setPreferredSize(new Dimension(300,100));
			panel_5.setFont(Fonte.AGENCY18);
			lblMedidasTabela.setPreferredSize(new Dimension(300,100));
			lblMedidasTabela.setFont(Fonte.AGENCY18);
			panel_5.setBackground(Cor.cor1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Cor.cor2);
			panel_4.add(panel_2);
			panel_2.setLayout(new GridLayout(0, 2, 0, 0));
			mediaLabel = new JLabel("M\u00E9dia  Tabela");
			panel_2.add(mediaLabel);
			mediaLabel.setFont(Fonte.AGENCY18);
			
			
			mediaField = new JTextField(7);
			mediaField.setEditable(false);
			mediaField .setBackground(Cor.cor1);
			mediaField .setForeground(Cor.cor2);
			mediaField .setFont(Fonte.AGENCY18);
			panel_2.add(mediaField);
			modaLabel = new JLabel("Moda Tabela");
			panel_2.add(modaLabel);
			modaLabel.setFont(Fonte.AGENCY18);
			
			modaField = new JTextField(7);
			modaField.setEditable(false);
	
			modaField.setEditable(false);
			modaField .setBackground(Cor.cor1);
			modaField .setForeground(Cor.cor2);
			modaField .setFont(Fonte.AGENCY18);
			panel_2.add(modaField);
			medianaLabel = new JLabel("Mediana Tabela");
			panel_2.add(medianaLabel);
			medianaLabel.setFont(Fonte.AGENCY18);
			medianaField = new JTextField(7);
			medianaField .setBackground(Cor.cor1);
			medianaField .setForeground(Cor.cor2);
			medianaField .setFont(Fonte.AGENCY18);
			panel_2.add(medianaField);
			medianaField.setEditable(false);
			varianciaLabel = new JLabel("Vari\u00E2ncia Tabela");
			panel_2.add(varianciaLabel);
			varianciaLabel.setFont(Fonte.AGENCY18);
		
			varianciaField = new JTextField(7);
			varianciaField.setEditable(false);
			varianciaField .setBackground(Cor.cor1);
			varianciaField .setForeground(Cor.cor2);
			varianciaField .setFont(Fonte.AGENCY18);
			panel_2.add(varianciaField);
			desvioPadraoLabel = new JLabel("Desvio Padr\u00E3o Tabela");
			panel_2.add(desvioPadraoLabel);
			desvioPadraoLabel.setFont(Fonte.AGENCY18);
		
			desvioPadraoField = new JTextField(4);
			desvioPadraoField.setEditable(false);
			desvioPadraoField .setBackground(Cor.cor1);
			desvioPadraoField .setForeground(Cor.cor2);
			desvioPadraoField .setFont(Fonte.AGENCY18);
			panel_2.add(desvioPadraoField);
			q1Label = new JLabel("Quartil 1 Tabela");
			panel_2.add(q1Label);
			q1Label.setFont(Fonte.AGENCY18);
			q1Field = new JTextField(7);
			q1Field.setEditable(false);
			q1Field .setBackground(Cor.cor1);
			q1Field .setForeground(Cor.cor2);
			q1Field .setFont(Fonte.AGENCY18);
			panel_2.add(q1Field);
			q2Label = new JLabel("Quartil 2 Tabela");
			panel_2.add(q2Label);
			q2Label.setFont(Fonte.AGENCY18);
			q2Field = new JTextField(7);
			q2Field.setEditable(false);
			q2Field .setBackground(Cor.cor1);
			q2Field .setForeground(Cor.cor2);
			q2Field .setFont(Fonte.AGENCY18);
			panel_2.add(q2Field);
			q3Label = new JLabel("Quartil 3 Tabela");
			panel_2.add(q3Label);
			q3Label.setFont(Fonte.AGENCY18);
			q3Field = new JTextField(7);
			q3Field.setEditable(false);
			q3Field .setBackground(Cor.cor1);
			q3Field .setForeground(Cor.cor2);
			q3Field .setFont(Fonte.AGENCY18);
			panel_2.add(q3Field);
			cofLabel = new JLabel("Coef. de Varia\u00E7\u00E3o Tabela");
			panel_2.add(cofLabel);
			cofLabel.setFont(Fonte.AGENCY18);
			cofField = new JTextField(4);
			cofField.setEditable(false);
			cofField.setBackground(Cor.cor1);
			cofField .setForeground(Cor.cor2);
			cofField .setFont(Fonte.AGENCY18);
			panel_2.add(cofField);
			percentilLabel = new JLabel("Percentil Tabela");
			panel_2.add(percentilLabel);
			percentilLabel .setFont(Fonte.AGENCY18);
			
			JPanel panel_3 = new JPanel();
			panel_2.add(panel_3);
			panel_3.setLayout(new GridLayout(0, 3, 0, 0));
			percentilField= new JTextField(7);
			percentilField.setEditable(false);
			percentilField.setBackground(Cor.cor1);
			percentilField.setForeground(Cor.cor2);
			percentilField.setFont(Fonte.AGENCY18);
			panel_3.add(percentilField);
			numPerField = new JTextField(3);
			numPerField.setBackground(Cor.cor2);
			numPerField.setForeground(Cor.cor1);
			numPerField.setFont(Fonte.AGENCY18);
			panel_3.add(numPerField);
			panel_3.setBackground(Cor.cor1);
			calcularPercentilButton = new JButton("GO");
			panel_3.add(calcularPercentilButton);
			calcularPercentilButton.setBackground(Cor.cor2);
			calcularPercentilButton.setForeground(Cor.cor1);
			
			separator_1 = new JSeparator();
			separator_1.setOrientation(SwingConstants.VERTICAL);
			separator_1.setForeground(Color.WHITE);
			panel_4.add(separator_1, BorderLayout.WEST);
			setModal(true);
			setVisible(false);
			
		}
		private void init(){
			
		}
}
