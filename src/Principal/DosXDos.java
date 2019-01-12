package Principal;

import java.awt.image.BufferedImage;

public class DosXDos extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;
	private BufferedImage imagen3;
	private BufferedImage imagen4;
	private BufferedImage iFinal;

	public DosXDos (BufferedImage img1,BufferedImage img2,BufferedImage img3,BufferedImage img4)
	{
		this.imagen1 = img1;
		this.imagen2 = img2;
		this.imagen3 = img3;
		this.imagen4 = img4;
	}
	public BufferedImage HacerCollage()
	{
		
		Collage.CopiarImagen(0,0,200,200, imagen1, iFinal);
		Collage.CopiarImagen(200,0,400,200,imagen2, iFinal);
		Collage.CopiarImagen(0,200,200,400, imagen3, iFinal);
		Collage.CopiarImagen(200,200,400,400, imagen4, iFinal);
		
		
		return iFinal;
	}
	

}
