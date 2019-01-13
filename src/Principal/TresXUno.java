package Principal;

import java.awt.image.BufferedImage;

public class TresXUno extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;
	private BufferedImage imagen3;


	public TresXUno (BufferedImage img1,BufferedImage img2, BufferedImage img3)
	{
		this.imagen1 = img1;
		this.imagen2 = img2;
		this.imagen3 = img3;

	}
	public BufferedImage HacerCollage()
	{
		
		Collage.CopiarImagen(0,0,imagen1);			
		Collage.CopiarImagen(0,200, imagen2);
		Collage.CopiarImagen(0,400,imagen3);
	
		BufferedImage iFinal = this.getiFinal();
		
		
		return iFinal;
	}
	

}
