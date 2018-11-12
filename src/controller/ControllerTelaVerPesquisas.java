package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.Base;
import view.PanelMostrarDados;

public class ControllerTelaVerPesquisas {
	private PanelMostrarDados painelVerDados;
	public  ControllerTelaVerPesquisas(PanelMostrarDados painelVerDados){
		this.painelVerDados = painelVerDados;
		carregarDados();
		if(painelVerDados.pesquisasCombo.getModel().getSize()>0){
			painelVerDados.dadosArea.setText(Base.base.get(painelVerDados.pesquisasCombo.getSelectedIndex()).getDadosPesquisa().toString().replace(",","\t").replace("[","INICIO DADOS\n ").replace("]","\nFIM DADOS"));
		}
		painelVerDados.pesquisasCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if(painelVerDados.pesquisasCombo.getModel().getSize()>0){
					painelVerDados.dadosArea.setText(Base.base.get(painelVerDados.pesquisasCombo.getSelectedIndex()).getDadosPesquisa().toString().replace(",","\t").replace("[","INICIO DADOS\n ").replace("]","\nFIM DADOS"));
				}
			}	
		});
	}
	private void carregarDados(){
		for(int i = 0;i<Base.base.size();i++){
			this.painelVerDados.pesquisasCombo.addItem(Base.base.get(i).getNomePesquisa());
		}
	}
}
