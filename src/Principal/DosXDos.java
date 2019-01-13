package Principal;

import java.awt.image.BufferedImage;

public class DosXDos extends Collage
{
	
	private BufferedImage imagen1;
	private BufferedImage imagen2;
	private BufferedImage imagen3;
	private BufferedImage imagen4;


	public DosXDos (BufferedImage img1,BufferedImage img2,BufferedImage img3,BufferedImage img4)
	{
		
		this.imagen1 = img1;
		this.imagen2 = img2;
		this.imagen3 = img3;
		this.imagen4 = img4;
	}
	public BufferedImage HacerCollage()
	{
		
		Collage.CopiarImagen(0,0,imagen1);
		Collage.CopiarImagen(300,0,imagen2);
		Collage.CopiarImagen(0,300,imagen3);
		Collage.CopiarImagen(300,300,imagen4);

		BufferedImage iFinal = this.getiFinal();
		
		return iFinal;
	}
	

}
