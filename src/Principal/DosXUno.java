package Principal;

import java.awt.image.BufferedImage;

public class DosXUno extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;

	public DosXUno (BufferedImage img1,BufferedImage img2)
	{
	
		this.imagen1 = img1;
		this.imagen2 = img2;

	}
	public BufferedImage CopiarImg1()
	{
		
	
		Collage.CopiarImagen(0,300, imagen2);
		Collage.CopiarImagen(0,0,imagen1);
	
		BufferedImage iFinal = this.getiFinal();
		
		return iFinal;
	}

}
