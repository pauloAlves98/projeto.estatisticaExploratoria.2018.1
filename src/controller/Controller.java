package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import model.Base;
import view.Gui;

public class Controller {
	Gui tela;
//	public Controller(Gui t){
//		tela = t;
//		tela.getPesquisarButton().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				if(tela.getQuantField().getText().equals("          ")){
//					JOptionPane.showMessageDialog(null,"Digite a quantidade de amostras a serem Mostradas!");
//				}else{
//					Random random = new Random();
//					
//					int quant =  Integer.parseInt(tela.getQuantField().getText().replace(" ",""));
//					ArrayList<Integer>antigos =new ArrayList<Integer>();
//					int atual = 0;
//					String nomes[] = new String[quant];
//					for(int i = 0;i<quant;i++){
//						atual = random.nextInt(Base.nomes.size());
//						while(verificaSeJafoi(antigos,atual)==true){
//							atual = random.nextInt(Base.nomes.size());
//						}
//						nomes[i] = Base.nomes.get(atual);
//						antigos.add(atual);
//					}
//					tela.getLista().setListData(nomes);
//					System.gc();
//				}
//			}
//		});
//		tela.getLimparButton().addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				String []s = new String[1];
//				tela.getLista().setListData(s);
//				System.gc();
//			}
//		});
//	}
	public static boolean verificaSeJafoi(ArrayList<Integer>antigos,int atual){
		for(int j = 0;j<antigos.size();j++){
			if(antigos.get(j) == atual){
				return true;
			}
		}
		return false;
	}
}
