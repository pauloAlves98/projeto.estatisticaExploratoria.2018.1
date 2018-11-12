package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import model.Cor;



public class PanelTabela extends JPanel{
	public JLabel tituloLabel;
	public JLabel fontLabel;
	public JScrollPane scrollPane;
	public  JPanel panel;
	public PanelTabela() {
		setBackground(Cor.cor2);
		setLayout(new BorderLayout());


		tituloLabel = new JLabel("T\u00EDtulo");
		tituloLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		tituloLabel.setFont(new Font("Agency FB", Font.BOLD, 28));
		add(tituloLabel, BorderLayout.NORTH);


		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300,100));
		scrollPane.setBorder(null);
		add(scrollPane, BorderLayout.CENTER);
	
		fontLabel = new JLabel("Font");
		fontLabel.setFont(new Font("Agency FB", Font.BOLD, 28));
		fontLabel.setVerticalAlignment(SwingConstants.TOP);
		add(fontLabel, BorderLayout.SOUTH);

		panel = new JPanel(/*new GridLayout(1,1)*/);
		panel.setBackground(Cor.cor2);
		panel.setForeground(Cor.cor2);
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
	}

}
