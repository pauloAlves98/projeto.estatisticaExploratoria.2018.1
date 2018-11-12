package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.text.MaskFormatter;

public class Gui extends JFrame {
	JList lista;
	
	JLabel quantidadeLabel;
	JFormattedTextField quantField;
	JButton pesquisarButton,limparButton;
	JPanel painel;
	JTabbedPane p;
	public Gui(){
		setSize(430,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		p = new JTabbedPane();
		painel = new JPanel(new FlowLayout());
		painel.setPreferredSize(new Dimension(100,150));
		pesquisarButton = new  JButton("Pesquisar");
		limparButton = new JButton("Limpar");
		quantField = new JFormattedTextField();
		maskLetter(quantField);
		quantidadeLabel = new JLabel("Quantidade");
		 quantidadeLabel.setForeground(Color.WHITE);
		 
		lista = new JList();
		lista.setFont(new Font("Arial",Font.BOLD,38));
		painel.add(quantidadeLabel);
		painel.add(quantField);
		painel.add(pesquisarButton);
		painel.add(limparButton);
		painel.setOpaque(false);
		add(painel);
		
		JScrollPane pane = new JScrollPane(lista);
		pane.setPreferredSize(new Dimension(300, 150));//crucial;
		add(pane);
		
		super.getContentPane().setBackground(Color.BLACK);
		setVisible(true);
	}
	public void maskLetter(JFormattedTextField jtf) {
		//simula consume()
		MaskFormatter formatoDois;
		try {
			formatoDois = new MaskFormatter("**********");
			formatoDois.setValidCharacters("1234567890");
			formatoDois.install(jtf);
			jtf.setCaretPosition(0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public JList getLista() {
		return lista;
	}
	public void setLista(JList lista) {
		this.lista = lista;
	}
	public JFormattedTextField getQuantField() {
		return quantField;
	}
	public void setQuantField(JFormattedTextField quantField) {
		this.quantField = quantField;
	}
	public JButton getPesquisarButton() {
		return pesquisarButton;
	}
	public void setPesquisarButton(JButton pesquisarButton) {
		this.pesquisarButton = pesquisarButton;
	}
	public JButton getLimparButton() {
		return limparButton;
	}
	public void setLimparButton(JButton limparButton) {
		this.limparButton = limparButton;
	}
}
