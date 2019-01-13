package Principal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Collage
{
	private static int ancho;
	private static int alto;
	private static BufferedImage iFinal;

	
	
	public Collage()
	{
		this.ancho = 600;
		this.alto = 600;
		this.iFinal = new BufferedImage(ancho, alto, BufferedImage.TYPE_3BYTE_BGR);

	}
	
	public static void CopiarImagen(int posX, int posY, BufferedImage image)
	{
		
	   
	    iFinal.getGraphics().drawImage(image, posX, posY, null);
	   
	    for(int x = posX; x < image.getWidth(); x++){
	           for(int y = posY; y < image.getHeight(); y++)
	           {
	               iFinal.setRGB(x,y, image.getRGB(x,y));
	           }
	     }
		
	   
	 
	}
	
	 public BufferedImage getiFinal() {
		return iFinal;
	}



	
	
}
