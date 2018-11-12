package app;
//Tela Editar Dados/tela Info/Correção/Tratar entradas invalidas.
//verificar se os dados qualitativos so contem numeros
import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.ControllerCriarPesquisa;
import controller.ControllerGraficos;
import controller.ControllerTabela;
import controller.ControllerTelaVerPesquisas;
import model.Backup;
import model.Base;
import view.TelaEntrada;

public class App {

	public static void main(String[] args){
		launch();
		System.out.println(Math.round(2));
	}
	public static void lookPadrao(){
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Passando LookAndFeel padrão do sistema operacional
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println("Nao Pegou");
		}

	}
	public static void lookWindows(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //Passando LookAndFeel padrão do sistema operacional
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.out.println("Nao Pegou");
		}
	}
	public static void lookNimbus(){
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			    if ("Nimbus".equals(info.getName())) {
			        UIManager.setLookAndFeel(info.getClassName());
			        break;
			    }
			}
			} catch (Exception e) {
			   // If Nimbus is not available, you can set the GUI to another look and feel.
			}
}
//	public static void  lookQuaqua(){
public static void launch(){
	DecimalFormat d = new DecimalFormat("0.000");
	d.setRoundingMode(RoundingMode.DOWN);
	System.out.println(d.format(0.5439));
		//lookWindows();
//		TelaIniciaJavaFx t = new TelaIniciaJavaFx();//root
//		Scene cena = new Scene(t.getTela(),400,400);
//		palco.setScene(cena);
//		palco.show();
		if(new File("Base//base.xml").exists() == false){
			Backup.gravar(Base.base,"base.xml");
//			try {
//				java.awt.Desktop.getDesktop().open(new File("Base//base.xml"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}else{
//			try {
//				java.awt.Desktop.getDesktop().open(new File("Base//"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Base.base = Backup.carregar("base.xml");
		}
		if(Base.base.size() == 0){System.out.println("Nao tem Nada");}
		//testar arredondar
//		//((int)medidas[medidas.length/2]) + 1;
//	System.out.println(Collections.min(Base.dadosContinuos,
//				new Comparator<String>(){
//					public int compare(String a1, String a2) {
//						return a1.compareTo(a2);
//					}
//			
//		}));
////	for(int i = 0;i<Base.dadosContinuos.size();i++){
////		System.out.println("Dados:"+Base.dadosContinuos.get(i));
////	}
//	System.out.println(Base.dadosContinuos.get(0)+"  "+Base.dadosContinuos.get(4));
//	
//	
//		//new Controller(new Gui());
//	System.out.println("Testando valores");
//	String a[] = Base.dadosContinuos.toArray(new String[Base.dadosContinuos.size()]);
//	;
//	System.out.println("Media:"+MedidasDeDispersao.mediaNormal(a));
//	System.out.println("Mediana:"+MedidasDeDispersao.medianaNormal(a));
//	System.out.println("Amplitude:"+MedidasDeDispersao.amplitude(a));
//	System.out.println("Variancia:"+MedidasDeDispersao.varianciaPopulacional(a));
//	System.out.println("Variancia Amostral:"+MedidasDeDispersao.varianciaAmostral(a));
//	System.out.println("Desvio Amostral:"+MedidasDeDispersao.desvioPadraoAmostral(a));
//	System.out.println("Cof V:"+MedidasDeDispersao.coeficienteDeVariacaoAmostral(a)+ "%");
//	System.out.println("K"+DadosTabelaFrequencia.numeroClasses(a)+1);
//	System.out.println("Pulo:"+DadosTabelaFrequencia.pulo(a));
//	DadosTabelaFrequencia.frequencia(a);
//	DadosTabelaFrequencia.frequenciaAcumulada();
//	DadosTabelaFrequencia.frequenciaRelativa(a.length);
//	DadosTabelaFrequencia.FrequenciaRelativa();
//	DadosTabelaFrequencia.Xi(a);
//	DadosTabelaFrequencia.XiFi();
//	System.out.println("M "+MedidasDeDispersao.mediaNaTabela(a.length));
//	System.out.println("Moda"+MedidasDeDispersao.modaNaTabela());
//	System.out.println("Mediana "+MedidasDeDispersao.medianaNaTabela(a.length));
//	System.out.println("Quartil "+MedidasDeDispersao.quartilNaTabela(a.length,2));
//	System.out.println("Percentil "+MedidasDeDispersao.percentil(76, a.length));
//	System.out.println("Variancia"+MedidasDeDispersao.varianciaNaTabela(a.length));
//	System.out.println("Desvio "+MedidasDeDispersao.desvioNaTabela(a.length) );
//	System.out.println("Co f "+MedidasDeDispersao.coeficienteDeVariacaoNaTabela(a.length) );
	TelaEntrada tela = new TelaEntrada();

	ArrayList<JComboBox>pesq = new ArrayList<JComboBox>();
		new ControllerTabela(tela.getTelaTabela());
		new ControllerGraficos(tela.getTelaGraficos());
		new ControllerTelaVerPesquisas(tela.panelMostrarDados);
		pesq.add(tela.getTelaGraficos().getEscolhaPesquisaBox());
		pesq.add(tela.getTelaTabela().getEscolhaPesquisaBox());
		pesq.add(tela.panelMostrarDados.pesquisasCombo);
		new ControllerCriarPesquisa(tela.telaCriarPesquisa,pesq);
	}
}
