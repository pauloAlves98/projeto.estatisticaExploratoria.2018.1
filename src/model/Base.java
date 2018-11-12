package model;

import java.util.ArrayList;
import java.util.Random;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Base {
	@XStreamAlias("Dados")
	public static ArrayList<Pesquisa> base = new ArrayList<Pesquisa>();
}
