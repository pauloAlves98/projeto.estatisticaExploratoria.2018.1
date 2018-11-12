package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.Backup;
import model.Base;
import model.Pesquisa;
import view.TelaCriarPesquisa;

public class ControllerCriarPesquisa implements ActionListener{
	TelaCriarPesquisa telaCriarPesquisa;
	ArrayList<String>estratificada = new ArrayList<String>();
	ArrayList<JComboBox>pesq;
	private static boolean invalida;
	public ControllerCriarPesquisa(TelaCriarPesquisa telaCriarPesquisa,ArrayList<JComboBox>pesq){
		this.telaCriarPesquisa = telaCriarPesquisa;
		this.telaCriarPesquisa.salvarPesquisaButton.addActionListener(this);
		//this.telaCriarPesquisa.nao.addItemListener(this);
		this.telaCriarPesquisa.tipoPesqCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				telaCriarPesquisa.listaPrevia.setText("");
			}
		});
		this.pesq = pesq;
		atualizarPesq();
	}
	private void atualizarPesq(){
		for(int i = 0;i<pesq.size();i++){
			if(pesq.get(i).getModel().getSize()>0)
				pesq.get(i).removeAllItems();
			for(int j = 0;j<Base.base.size();j++){
				pesq.get(i).addItem(Base.base.get(j).getNomePesquisa());
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == telaCriarPesquisa.salvarPesquisaButton){
			if(telaCriarPesquisa.nomePesquisaField.getText().trim().length()<=0){
				JOptionPane.showMessageDialog(null,"Preencha o campo nome");
				return;
			}
			else if(telaCriarPesquisa.listaPrevia.getText().trim().replace(" ","").replace(",",".").replace("\n","").replace("@","").length()<=0){
				JOptionPane.showMessageDialog(null,"Insira Dados!");
				return;
			}else if(telaCriarPesquisa.tipoPesqCombo.getSelectedIndex() == 0){
				//Guarda dados qualitativos
				ArrayList<String> dados = new ArrayList<String>();
				boolean ehQuali = true;
				String dadosArea = telaCriarPesquisa.listaPrevia.getText().trim().replace("  ","").replace(",",".").replace("\n","");
				String dadosVetor[] = dadosArea.split("@");
				for(int i = 0;i<dadosVetor.length;i++){
					dados.add(dadosVetor[i]);
				}
				Pesquisa p = new Pesquisa(telaCriarPesquisa.nomePesquisaField.getText(),
						dados,ehQuali);
				Base.base.add(p);
				Backup.gravar(Base.base,"base.xml");
				telaCriarPesquisa.nomePesquisaField.setText("");
				telaCriarPesquisa.listaPrevia.setText("");
				JOptionPane.showMessageDialog(null,"Salva");
				atualizarPesq();
			}
			else{
				//verificar se  so contem numeros
				ArrayList<String> dados = new ArrayList<String>();
				boolean ehQuali = false;
				String dadosArea = telaCriarPesquisa.listaPrevia.getText().trim().replace(" ","").replace(",",".").replace("\n","");
				String dadosVetor[] = dadosArea.split("@");
				//se só conter numeros
				for(int i = 0;i<dadosVetor.length;i++){
					dados.add(dadosVetor[i]);
				}
				invalida  = false;
				Collections.sort(dados,new Comparator(){
					public int compare(Object o1, Object o2) {
						double um = 0;
						double dois = 0;
						try{
							 um = Double.parseDouble((String) o1);
							 dois =  Double.parseDouble((String) o2);
						}catch(Exception e1){
							invalida = true;
							JOptionPane.showMessageDialog(null,"A pesquisa contém valores Invalidos!!!");
						}
						if(um>dois)
							return 1;
						else if(dois>um)
							return -1;
						return 0;
					}
				});//ordena!
				//verificar se so contem numeros
				//se não return;
				if(invalida == false){
				Pesquisa p = new Pesquisa(telaCriarPesquisa.nomePesquisaField.getText(),
						dados,ehQuali);
				Base.base.add(p);
				Backup.gravar(Base.base,"base.xml");
				telaCriarPesquisa.nomePesquisaField.setText("");
				telaCriarPesquisa.listaPrevia.setText("");
				JOptionPane.showMessageDialog(null,"Salva");
				atualizarPesq();
				}
					
					
			}
			
		}
	}
	public static boolean soContemNumeros(String texto) {
		if(texto == null)
			return false;
		for (char letra : texto.toCharArray())
			if(letra < '0' || letra > '9')
				return false;
		return true;

	}
}
