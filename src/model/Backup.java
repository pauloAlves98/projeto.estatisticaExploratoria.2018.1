package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;

public class Backup {
	public static void gravar(ArrayList<Pesquisa>nomes,String nome){
		File dir = new File("Base");
		if(dir.exists() == false)
			dir.mkdir();
		File arq = new File("Base//"+nome);
		if(arq.exists() == false)
			try {
				arq.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		try {
			FileWriter gravador = new FileWriter(arq);
			XStream stream = new XStream();
			stream.alias("BASE_NOMES",ArrayList.class);
			gravador.write(stream.toXML(nomes));
			gravador.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{}

	}
	public static ArrayList<Pesquisa> carregar(String nome){
		File arq = new File("Base//"+nome);
		FileReader leitor = null;
		try {
			leitor = new FileReader(arq);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		XStream stream = new XStream(new Dom4JDriver());
		stream.alias("BASE_NOMES",ArrayList.class);
		return (ArrayList)stream.fromXML(leitor);
		//leitor.close();
	}
}
