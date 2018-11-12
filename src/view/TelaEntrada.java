package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import app.App;
import imagens.CarregadorDeImagem;
import model.Cor;

public class TelaEntrada extends JFrame{
	private JLabel nome;
	private JTabbedPane abas;
	private TelaTabelas telaTabela;
	private TelaGraficos telaGraficos;
	public TelaCriarPesquisa telaCriarPesquisa;
	public PanelMostrarDados panelMostrarDados;
	public TelaEntrada(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		//App.lookNimbus();
		panelMostrarDados = new PanelMostrarDados();
		telaTabela = new TelaTabelas();
		telaGraficos = new TelaGraficos();
		telaCriarPesquisa = new TelaCriarPesquisa();
		//App.lookPadrao();
		//adiconar tab info
		nome = new JLabel("PACOTE ESTATÍSTICA EXPLORATÓRIA 2018.1",new ImageIcon(CarregadorDeImagem.carregarImagem("pacote.png")),2);
		nome.setFont(TelaGraficos.font);
		nome.setForeground(Color.orange);
		abas = new JTabbedPane();
		abas.addTab("Informações",new ImageIcon(CarregadorDeImagem.carregarImagem("info.png")),
				new InformacoesPanel());
		abas.addTab("Gráficos",new ImageIcon(CarregadorDeImagem.carregarImagem("graficos.png")),
		telaGraficos);
		abas.addTab("Tabelas",new ImageIcon(CarregadorDeImagem.carregarImagem("tabelas.png")),
		telaTabela);
		abas.addTab("Criar Pesquisa",new ImageIcon(CarregadorDeImagem.carregarImagem("criar.png")),
				telaCriarPesquisa);
		abas.addTab("Ver Pesquisas",new ImageIcon(CarregadorDeImagem.carregarImagem("verPesquisa.png")),
		panelMostrarDados);
		
		abas.setBackground(Cor.cor1);
		abas.setForeground(Cor.cor2);
		abas.setFont(TelaGraficos.font);
		add(nome,BorderLayout.NORTH);
		add(abas);
		
		super.getContentPane().setBackground(Color.DARK_GRAY);
		
		
		setVisible(true);
	}
	public TelaTabelas getTelaTabela() {
		return telaTabela;
	}
	public void setTelaTabela(TelaTabelas telaTabela) {
		this.telaTabela = telaTabela;
	}
	public TelaGraficos getTelaGraficos() {
		return telaGraficos;
	}
	public void setTelaGraficos(TelaGraficos telaGraficos) {
		this.telaGraficos = telaGraficos;
	}
	
}
