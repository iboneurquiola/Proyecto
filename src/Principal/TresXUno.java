package Principal;

import java.awt.image.BufferedImage;

public class TresXUno extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;
	private BufferedImage imagen3;

	private BufferedImage iFinal;

	public TresXUno (BufferedImage img1,BufferedImage img2, BufferedImage img3)
	{
		this.imagen1 = img1;
		this.imagen2 = img2;
		this.imagen3 = img3;

	}
	public BufferedImage HacerCollage()
	{
		
		iFinal = Collage.CopiarImagen(0,0,imagen1, iFinal);			
		iFinal = Collage.CopiarImagen(0,200, imagen2, iFinal);
		iFinal = Collage.CopiarImagen(0,400,imagen3, iFinal);
		
		
		
		return iFinal;
	}
	

}
