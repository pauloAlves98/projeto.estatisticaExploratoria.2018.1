package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import imagens.CarregadorDeImagem;
import model.Cor;

public class InformacoesPanel extends JGradientePanel {

	/**
	 * Create the panel.
	 */
	public InformacoesPanel() {
		super(Color.black,Cor.cor1);
		setBackground(Cor.cor1);
		setLayout(null);
		
		JLabel lblPacoteEstatstico = new JLabel("Pacote Estat\u00EDstico");
		lblPacoteEstatstico.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblPacoteEstatstico.setForeground(Cor.cor2);
		lblPacoteEstatstico.setBounds(10, 85, 284, 29);
		add(lblPacoteEstatstico);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblAutor.setBounds(136, 184, 98, 20);
		add(lblAutor);
		
		JLabel lblNewLabel = new JLabel("Paulo Alves da Silva");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblNewLabel.setBounds(136, 202, 211, 44);
		add(lblNewLabel);
		
		JLabel lblLogoUast = new JLabel(new ImageIcon(CarregadorDeImagem.carregarImagem("uast.png")));
		lblLogoUast.setBackground(new Color(51, 204, 204));
		lblLogoUast.setBounds(468, 151, 350, 199);
		add(lblLogoUast);
		
		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblProfessor.setBounds(136, 246, 95, 20);
		add(lblProfessor);
		
		JLabel lblWelligton = new JLabel("Wellington Jorge Cavalcanti Lundgren");
		lblWelligton.setForeground(Color.WHITE);
		lblWelligton.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblWelligton.setBounds(136, 269, 284, 29);
		add(lblWelligton);
		
		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Agency FB", Font.PLAIN, 24));
		lblDisciplina.setBounds(136, 299, 72, 29);
		add(lblDisciplina);
		
		JLabel lblEstatsticaExploratria = new JLabel("Estat\u00EDstica Explorat\u00F3ria");
		lblEstatsticaExploratria.setForeground(Color.WHITE);
		lblEstatsticaExploratria.setFont(new Font("Agency FB", Font.PLAIN, 22));
		lblEstatsticaExploratria.setBounds(136, 328, 237, 29);
		add(lblEstatsticaExploratria);
		setBackground(TelaGraficos.violeta);
		JLabel lblVo = new JLabel("v 1.0 2018.1");
		lblVo.setForeground(Color.WHITE);
		lblVo.setFont(new Font("Agency FB", Font.PLAIN, 15));
		lblVo.setBounds(136, 385, 133, 14);
		add(lblVo);
		setPreferredSize(new Dimension(900,600));
		
	}
}
