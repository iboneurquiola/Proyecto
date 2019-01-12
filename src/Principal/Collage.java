package Principal;

import java.awt.image.BufferedImage;

public class Collage
{

	
	public static BufferedImage CopiarImagen(int posX, int posY,int ancho, int alto, BufferedImage image, BufferedImage iFinal)
	{
		
	    iFinal= new BufferedImage(400, 400, BufferedImage.TYPE_3BYTE_BGR);
	    iFinal.getGraphics().drawImage(image, posX, posY, null);
	     for(int y = posX; y < image.getHeight(); y++){
	            for(int x = posY; x < image.getWidth(); x++)
	            {
	                iFinal.setRGB(x,y, image.getRGB(x,y));
	            }
	     }
	     for(int y = posX; y < image.getHeight(); y++){
	            for(int x = posY; x < image.getWidth(); x++)
	            {
	                iFinal.setRGB(x,y, image.getRGB(x,y));
	            }
	     }
			
		return iFinal;
	  
	
	}
	

	
}
