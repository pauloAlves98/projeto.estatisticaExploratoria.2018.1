package model;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Pesquisa")
public class Pesquisa {
	private String nomePesquisa;
	private ArrayList<String>dadosPesquisa = new ArrayList<String>();
	private ArrayList<String>estratificada = new ArrayList<String>();
	private boolean isEstratificada = false,isQualitativa;//String tipo 	remover estratificada
	public Pesquisa(){}
	
	public Pesquisa(String nome,ArrayList<String>dado,boolean qualitativa){
		this.nomePesquisa = nome;
		this.dadosPesquisa = dado;
		this.isQualitativa = qualitativa;
	}
	
	public String getNomePesquisa() {
		return nomePesquisa;
	}
	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
	public ArrayList<String> getDadosPesquisa() {
		return dadosPesquisa;
	}
	public void setDadosPesquisa(ArrayList<String> dadosPesquisa) {
		this.dadosPesquisa = dadosPesquisa;
	}
	public ArrayList<String> getEstratificada() {
		return estratificada;
	}
	public void setEstratificada(ArrayList<String> estratificada) {
		this.estratificada = estratificada;
	}
	public boolean isEstratificada() {
		return isEstratificada;
	}
	public void setEstratificada(boolean isEstratificada) {
		this.isEstratificada = isEstratificada;
	}
	public boolean isQualitativa() {
		return isQualitativa;
	}
	public void setQualitativa(boolean isQualitativa) {
		this.isQualitativa = isQualitativa;
	}
	
}
