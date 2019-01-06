package Principal;

import java.awt.image.BufferedImage;

public class DosXUno extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;

	private BufferedImage iFinal;

	public DosXUno (BufferedImage img1,BufferedImage img2)
	{
		this.imagen1 = img1;
		this.imagen2 = img2;

	}
	public BufferedImage HacerCollage()
	{
		
		iFinal = Collage.CopiarImagen(0,0,400, 200, imagen1, iFinal);
		iFinal = Collage.CopiarImagen(0,200,400,400, imagen2, iFinal);
		
		return iFinal;
	}
	

}
