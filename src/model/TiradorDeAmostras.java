package model;

import java.util.ArrayList;
import java.util.Random;

import controller.Controller;

public class TiradorDeAmostras {
	//escolher qual aostra quer  tirar
	public static void retiraAleatoria(int quantidadeAmostras,ArrayList<String>nomesAnteriores,ArrayList<Integer>quantidade,ArrayList<String>dados){
		ArrayList<Integer>jaFoi = new ArrayList<Integer>();
		Random random = new Random();
		int aleatorio = random.nextInt(dados.size());
		for(int i = 0;i < quantidadeAmostras;i++){
			int cont = 0;
			while(Controller.verificaSeJafoi(jaFoi,aleatorio)){//evita numeros aleatorios repitidos
				aleatorio = random.nextInt(dados.size());
			}
			for(int j = 0;j<nomesAnteriores.size();j++){//verifica se o dado já saiu
				if(nomesAnteriores.get(j).equalsIgnoreCase(dados.get(aleatorio))){
					quantidade.set(j,quantidade.get(j)+1);
					cont++;
					break;	
				}
			}
			if(cont == 0){//eh pq o nome nao existe ainda
				nomesAnteriores.add(dados.get(aleatorio));	
				quantidade.add(1);
			}
			jaFoi.add(aleatorio);
			aleatorio = random.nextInt(dados.size());
		}
	}
	public static void retiraSistematica(int quantidadeAmostras,ArrayList<String>nomesAnteriores,ArrayList<Integer>quantidade,ArrayList<String>dados){
		int pulo = (int)(dados.size()/quantidadeAmostras),cont = 0;
		int primeira = new Random().nextInt(pulo);
		System.out.println("Primeira"+primeira);
		for(int i = 0;i < quantidadeAmostras;i++){
			cont = 0;
			for(int j = 0;j<nomesAnteriores.size();j++){//verifica se o dado já saiu
				if(nomesAnteriores.get(j).equalsIgnoreCase(dados.get(i*pulo + primeira))){
					quantidade.set(j,quantidade.get(j)+1);
					System.out.println("+1::"+dados.get(i*pulo + primeira));
					cont++;
					break;	
				}
			}
			if(cont == 0){//eh pq o nome nao existe ainda
				nomesAnteriores.add(dados.get(i*pulo + primeira));	
				System.out.println("Novo:"+dados.get(i*pulo + primeira));
				quantidade.add(1);
			}
		}
	}
	public static void retiraEstratificada(int quantidadeAmostras,ArrayList<String>nomesAnteriores,ArrayList<Integer>quantidade,ArrayList<String>dados){
		//assumindo que ja receba uma base com permissão estratificada.
		float porcentagem = (float)quantidadeAmostras/dados.size();
		ArrayList<String>nomesAnterioresAux = new ArrayList<String>();
		ArrayList<Integer>quantidadeAux = new ArrayList<Integer>();
		//separar os dados e suas quantidades
		for(int i = 0;i < dados.size();i++){
			int cont = 0;
			for(int j = 0;j<nomesAnterioresAux .size();j++){//verifica se o dado já saiu
				if(nomesAnterioresAux .get(j).equalsIgnoreCase(dados.get(i))){
					quantidadeAux.set(j,quantidadeAux.get(j)+1);
					cont++;
					break;	
				}
			}
			if(cont == 0){//eh pq o nome nao existe ainda
				nomesAnterioresAux.add(dados.get(i));	
				quantidadeAux.add(1);
			}
		}
		//colocar nas porcentagens
		if(nomesAnterioresAux.size() -  quantidadeAmostras !=0){
			quantidadeAux.set(nomesAnterioresAux.size()-1,quantidadeAux.get(nomesAnterioresAux.size()-1)-1);
			if(quantidadeAux.get(nomesAnterioresAux.size()-1)==0){
				nomesAnterioresAux.remove(nomesAnterioresAux.size()-1);
				quantidadeAux.remove(nomesAnterioresAux.size()-1);
			}
		}
		int total = 0;
		for(int i = 0;i<nomesAnterioresAux .size();i++){
			nomesAnteriores.add(nomesAnterioresAux.get(i));
			quantidade.add(Math.round(quantidadeAux.get(i)*porcentagem));
			System.out.println("TOTAL:"+nomesAnterioresAux.get(i)+" "+quantidadeAux.get(i));
			System.out.println("Porcentagem:"+porcentagem);
			System.out.println("AMOSTRA:"+nomesAnteriores.get(i)+" "+quantidade.get(i));
		total+=quantidade.get(i);
		}
		System.out.println("Soma:"+total+" Quant A:"+quantidadeAmostras);
	}
	
}
