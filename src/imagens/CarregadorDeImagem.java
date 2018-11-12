package imagens;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class CarregadorDeImagem {
	static CarregadorDeImagem c = new CarregadorDeImagem();
	public static Image carregarImagem(String end){
		Image image  = null;
		
		try {
			image = ImageIO.read(c.getClass().getResource(end));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Não Encontrada?"+end);
			e.printStackTrace();
		}
		return image;
	}
}
