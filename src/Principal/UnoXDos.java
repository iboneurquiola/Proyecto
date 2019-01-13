package Principal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class UnoXDos extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;

	private BufferedImage iFinal;


	public UnoXDos (BufferedImage img1,BufferedImage img2)
	{
		this.imagen1 = img1;
		this.imagen2 = img2;

	}
	public BufferedImage HacerCollage()
	{
		
		iFinal = Collage.CopiarImagen(0,0, imagen1, iFinal);
	
		iFinal = Collage.CopiarImagen(300,0,imagen2, iFinal);
	
		return iFinal;
	}
	

}
