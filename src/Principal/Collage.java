package Principal;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Collage
{

	private static File file;
	public Collage () 
	  {
	    

	  }
	public static BufferedImage CopiarImagen(int posX, int posY,int ancho, int alto, BufferedImage imagen, BufferedImage iFinal)
	{
		iFinal = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
		for (int i= posX; i<ancho; i++)
		{
			for(int l=posY; l<alto; l++)
			{
				int rgb = imagen.getRGB(i, l);
				iFinal.setRGB(i, l, rgb);
				
			}
		}
		
			
		return iFinal;
	  
	
	}
	

	
}
