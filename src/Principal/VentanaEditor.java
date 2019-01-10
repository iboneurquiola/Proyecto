package Principal;

import static marvin.MarvinPluginCollection.crop;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;


public class VentanaEditor extends JFrame 
{ 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MarvinImagePanel     imagePanel; 
    private static MarvinImage         backupImage,image; 
    private static String path;
    private JPanel             panelBottom; 
    private JMenuItem btnMosaico, btnTelevision, btnFixedCamera, btnSceneBack, btnGaussian, btnPixelize, btnAlpha, 
	btnBlackAndWhite, btnBrightness, btnColorChannel, btnEmboss, btnGrey, btnInvert, btnSepia, btnSkinColorDetection, 
	btnThresholding, btnNeig, btnMask, btnTransparency, btnMerge, btnConvultion, btnHarris, btnMoravec, btnSusan, 
	btnDifColor, btnDifGrey, btnDifRegions, btnEdge, btnPrewitt, btnRoberts, btnSobel, btnEqualization, btnFill, btnCircles, 
	btnDithering, btnErrorDiffusion, btnRylanders, btnColorHistogram, btnGrayHistogram, btnInterfaceTest, btnBoundary, 
	btnClosing, btnDilation, btnErosion, btnOpening, btnGrayScaleQuantization, btnColorQuantization, btnGrayGradient,
	btnIterated, btnJulia, btnLindenmayer, btnManderbrot, btnText, btnRestoration, btnCrop, btnFloodFill, 
	btnImageSlicer, btnMaximum, btnMedian, btnMinimum, btnMode, btnSteganography, btnSubtract, btnTexture, 
	btnFlip, btnRotate, btnScale, btnSkew, btnWaterShed;

    private JButton volver, seleccionarArchivo, reset, guardar, guardarComo,  compartir;
    private Usuario u;
    private MarvinImagePlugin     imagePlugin; 
  
     
    public VentanaEditor(BufferedImage image, Usuario u)  
    { 
    	
    	
    	this.u=u;
    	
        ButtonHandler buttonHandler = new ButtonHandler(); 
        JMenuBar menu = new JMenuBar();
		JMenu filtros = new JMenu("Filtros");
		menu.add(filtros);

		JMenu editar = new JMenu("Editar");
		menu.add(editar);
	
		JMenu menuArtistico = new JMenu("Artistico");
		filtros.add(menuArtistico);
	
		btnMosaico = new JMenuItem("Mosaico");
		menuArtistico.add(btnMosaico);
		
		btnMosaico.addActionListener(buttonHandler);
	
	
		btnTelevision = new JMenuItem("Television");
		menuArtistico.add(btnTelevision);
		btnTelevision.addActionListener(buttonHandler);
	
		JMenu menuGround = new JMenu("Ground");
		filtros.add(menuGround);
	
		btnFixedCamera = new JMenuItem("Fixed Camera");
		menuGround.add(btnFixedCamera);
		btnFixedCamera.addActionListener(buttonHandler);
	
	
		btnSceneBack = new JMenuItem("Television");
		menuGround.add(btnSceneBack);
		btnSceneBack.addActionListener(buttonHandler);
		
		JMenu menuBlur = new JMenu("Blur");
		filtros.add(menuBlur);
	
		btnGaussian = new JMenuItem("Gaussian Blur");
		menuBlur.add(btnGaussian);
		btnGaussian.addActionListener(buttonHandler);
	
		btnPixelize = new JMenuItem("Pixelize");
		menuBlur.add(btnPixelize);
		btnPixelize.addActionListener(buttonHandler);
	
		JMenu menuColor = new JMenu("Color");
		filtros.add(menuColor);
	
		btnAlpha = new JMenuItem("Alpha Boundary");
		menuColor.add(btnAlpha);
		btnAlpha.addActionListener(buttonHandler);
	
		btnBlackAndWhite = new JMenuItem("Black and White");
		menuColor.add(btnBlackAndWhite);
		btnAlpha.addActionListener(buttonHandler);
	
		btnBrightness = new JMenuItem("Brightness and Contrast");
		editar.add(btnAlpha);
		btnBrightness.addActionListener(buttonHandler);
	
		btnColorChannel = new JMenuItem("Color Channel");
		menuColor.add(btnColorChannel);
		btnColorChannel.addActionListener(buttonHandler);
	
		btnEmboss = new JMenuItem("Emboss");
		menuColor.add(btnEmboss);
		btnEmboss.addActionListener(buttonHandler);
	
		btnGrey = new JMenuItem("Grey");
		menuColor.add(btnGrey);
		btnGrey.addActionListener(buttonHandler);
	
		btnInvert = new JMenuItem("Invert");
		menuColor.add(btnInvert);
		btnInvert.addActionListener(buttonHandler);
	
		btnSepia = new JMenuItem("Sepia");
		menuColor.add(btnSepia);
		btnSepia.addActionListener(buttonHandler);
	
		btnSkinColorDetection = new JMenuItem("Skin Color Detection");
		menuColor.add(btnSkinColorDetection);
		btnSkinColorDetection.addActionListener(buttonHandler);
	
		btnThresholding = new JMenuItem("Thresholding");
		menuColor.add(btnThresholding);
		btnThresholding.addActionListener(buttonHandler);

		btnNeig = new JMenuItem("Thresholding Neighborhood");
		menuColor.add(btnNeig);
		btnNeig.addActionListener(buttonHandler);

		JMenu menuCombine = new JMenu("Combine");
		filtros.add(menuCombine);
	
		btnMask = new JMenuItem("By Mask");
		menuCombine.add(btnMask);
		btnMask.addActionListener(buttonHandler);


		btnTransparency = new JMenuItem("By Transparency");
		menuCombine.add(btnTransparency);
		btnTransparency.addActionListener(buttonHandler);


		btnMerge = new JMenuItem("Merge Photos");
		menuCombine.add(btnMerge);
		btnMerge.addActionListener(buttonHandler);

		btnConvultion = new JMenuItem("Convultion");
		filtros.add(btnConvultion);
		btnConvultion.addActionListener(buttonHandler);

		JMenu menuCorner = new JMenu("Corner");
		filtros.add(menuCorner);

		btnHarris = new JMenuItem("Harris");
		menuCorner.add(btnHarris);
		btnHarris.addActionListener(buttonHandler);

		btnMoravec = new JMenuItem("Moravec");
		menuCorner.add(btnMoravec);
		btnMoravec.addActionListener(buttonHandler);

		btnSusan = new JMenuItem("Susan");
		menuCorner.add(btnSusan);
		btnSusan.addActionListener(buttonHandler);

		JMenu menuDifference = new JMenu("Difference");
		filtros.add(menuDifference);

		btnDifColor = new JMenuItem("Difference Color");
		menuDifference.add(btnDifColor);
		btnDifColor.addActionListener(buttonHandler);

		btnDifGrey = new JMenuItem("Difference Grey");
		menuDifference.add(btnDifGrey);
		btnDifGrey.addActionListener(buttonHandler);

		btnDifRegions = new JMenuItem("Difference Regions");
		menuDifference.add(btnDifRegions);
		btnDifRegions.addActionListener(buttonHandler);

		JMenu menuEdge = new JMenu("Edge");
		filtros.add(menuEdge);

		btnEdge = new JMenuItem("Edge");
		menuEdge.add(btnEdge);
		btnEdge.addActionListener(buttonHandler);


		btnPrewitt = new JMenuItem("Prewitt");
		menuEdge.add(btnPrewitt);
		btnPrewitt.addActionListener(buttonHandler);


		btnRoberts = new JMenuItem("Roberts");
		menuEdge.add(btnRoberts);
		btnRoberts.addActionListener(buttonHandler);

		btnSobel = new JMenuItem("Sobel");
		menuEdge.add(btnSobel);
		btnSobel.addActionListener(buttonHandler);

		btnEqualization = new JMenuItem("Equalization");
		filtros.add(btnEqualization);
		btnEqualization.addActionListener(buttonHandler);

		btnFill = new JMenuItem("Fill");
		filtros.add(btnFill);
		btnFill.addActionListener(buttonHandler);

		JMenu menuHalftone = new JMenu("Halftone");
		filtros.add(menuHalftone);

		btnCircles = new JMenuItem("Circles");
		menuHalftone.add(btnCircles);
		btnCircles.addActionListener(buttonHandler);
	
		btnDithering = new JMenuItem("Dithering");
		menuHalftone.add(btnDithering);
		btnDithering.addActionListener(buttonHandler);

		btnErrorDiffusion = new JMenuItem("Error Diffusion");
		menuHalftone.add(btnErrorDiffusion);
		btnErrorDiffusion.addActionListener(buttonHandler);

		btnRylanders = new JMenuItem("Rylanders");
		menuHalftone.add(btnRylanders);
		btnRylanders.addActionListener(buttonHandler);

		JMenu menuHistogram = new JMenu("Histogram");
		filtros.add(menuHistogram);

		btnColorHistogram = new JMenuItem("Color Histogram");
		menuHistogram.add(btnColorHistogram);
		btnColorHistogram.addActionListener(buttonHandler);

		btnGrayHistogram = new JMenuItem("Gray Histogram");
		menuHistogram.add(btnGrayHistogram);
		btnGrayHistogram.addActionListener(buttonHandler);

		btnInterfaceTest = new JMenuItem("Interface Test");
		filtros.add(btnInterfaceTest);
		btnInterfaceTest.addActionListener(buttonHandler);

		JMenu menuMorphological = new JMenu("Morphological");
		filtros.add(menuMorphological);

		btnBoundary = new JMenuItem("Boundary");
		menuMorphological.add(btnBoundary);
		btnBoundary.addActionListener(buttonHandler);

		btnClosing = new JMenuItem("Closing");
		menuMorphological.add(btnClosing);
		btnClosing.addActionListener(buttonHandler);

		btnDilation = new JMenuItem("Dilation");
		menuMorphological.add(btnDilation);
		btnDilation.addActionListener(buttonHandler);

		btnErosion = new JMenuItem("Erosion");
		menuMorphological.add(btnErosion);
		btnErosion.addActionListener(buttonHandler);

		btnOpening = new JMenuItem("Opening");
		menuMorphological.add(btnOpening);
		btnOpening.addActionListener(buttonHandler);

		JMenu menuQuantization = new JMenu("Quantization");
		filtros.add(menuQuantization);

		btnGrayScaleQuantization = new JMenuItem("Gray Scale Quantization");
		menuQuantization.add(btnGrayScaleQuantization);
		btnGrayScaleQuantization.addActionListener(buttonHandler);

		btnColorQuantization = new JMenuItem("Color Quantization");
		menuQuantization.add(btnColorQuantization);
		btnColorQuantization.addActionListener(buttonHandler);

		JMenu menuRender = new JMenu("Render");
		filtros.add(menuRender);

		btnGrayGradient = new JMenuItem("Gray Gradient");
		menuRender.add(btnGrayGradient);
		btnGrayGradient.addActionListener(buttonHandler);

		btnIterated = new JMenuItem("Iterated Function System");
		menuRender.add(btnIterated);
		btnIterated.addActionListener(buttonHandler);

		btnJulia = new JMenuItem("Julia Set");
		menuRender.add(btnJulia);
		btnJulia.addActionListener(buttonHandler);

		btnLindenmayer = new JMenuItem("Lindenmayer");
		menuRender.add(btnLindenmayer);
		btnLindenmayer.addActionListener(buttonHandler);

		btnManderbrot = new JMenuItem("Manderbrot");
		menuRender.add(btnManderbrot);
		btnManderbrot.addActionListener(buttonHandler);

		btnText = new JMenuItem("Text");
		menuRender.add(btnText);
		btnText.addActionListener(buttonHandler);

		btnRestoration = new JMenuItem("Restoration");
		filtros.add(btnRestoration);
		btnRestoration.addActionListener(buttonHandler);

		JMenu menuSegmentation = new JMenu("Segmentation");
		filtros.add(menuSegmentation);

		btnCrop = new JMenuItem("Crop");
		editar.add(btnCrop);
		btnCrop.addActionListener(buttonHandler);

		btnFloodFill = new JMenuItem("Flood Fill Segmentation");
		menuSegmentation.add(btnFloodFill);
		btnFloodFill.addActionListener(buttonHandler);

		btnImageSlicer = new JMenuItem("Image Slicer");
		menuSegmentation.add(btnImageSlicer);
		btnImageSlicer.addActionListener(buttonHandler);

		JMenu menuStatistical = new JMenu("Statistical");
		filtros.add(menuStatistical);

		btnMaximum = new JMenuItem("Maximum");
		menuStatistical.add(btnMaximum);
		btnMaximum.addActionListener(buttonHandler);

		btnMedian = new JMenuItem("Median");
		menuStatistical.add(btnMedian);
		btnMedian.addActionListener(buttonHandler);

		btnMinimum = new JMenuItem("Minimum");
		menuStatistical.add(btnMinimum);
		btnMinimum.addActionListener(buttonHandler);

		btnMode = new JMenuItem("Mode");
		menuStatistical.add(btnMode);
		btnMode.addActionListener(buttonHandler);

		btnSteganography = new JMenuItem("Steganography");
		filtros.add(btnSteganography);
		btnSteganography.addActionListener(buttonHandler);

		btnSubtract = new JMenuItem("Subtract");
		filtros.add(btnSubtract);
		btnSubtract.addActionListener(buttonHandler);

		btnTexture = new JMenuItem("Texture");
		filtros.add(btnTexture);
		btnTexture.addActionListener(buttonHandler);

		JMenu menuTransform = new JMenu("Transform");
		filtros.add(menuTransform);

		btnFlip = new JMenuItem("Flip");
		editar.add(btnFlip);
		btnFlip.addActionListener(buttonHandler);

		btnRotate = new JMenuItem("Rotate");
		editar.add(btnRotate);
		btnRotate.addActionListener(buttonHandler);

		btnScale = new JMenuItem("Scale");
		editar.add(btnScale);
		btnScale.addActionListener(buttonHandler);


		btnSkew = new JMenuItem("Skew");
		menuTransform.add(btnSkew);
		btnSkew.addActionListener(buttonHandler);

		btnWaterShed = new JMenuItem("Water Shed");
		menuTransform.add(btnWaterShed);
		btnWaterShed.addActionListener(buttonHandler);



        // Create Graphical Interface 
        
		volver = new JButton();
        volver.setBounds(0, 10, 40, 40);
        ImageIcon v = new ImageIcon(getClass().getResource("/images/volver.png"));
        Icon iconoVolver = new ImageIcon(v.getImage().getScaledInstance(volver.getWidth(), volver.getHeight(), Image.SCALE_DEFAULT));
        volver.setIcon(iconoVolver);
        volver.setToolTipText("Volver");
        volver.addActionListener(buttonHandler); 

		reset = new JButton();
        reset.setBounds(300, 10, 40, 40);
        ImageIcon r = new ImageIcon(getClass().getResource("/images/reset.png"));
        Icon iconoReset = new ImageIcon(r.getImage().getScaledInstance(reset.getWidth(), reset.getHeight(), Image.SCALE_DEFAULT));
        reset.setIcon(iconoReset);
        reset.setToolTipText("Reset");
        reset.addActionListener(buttonHandler); 
        
        guardar = new JButton();
        guardar.setBounds(50, 10, 40, 40);
        ImageIcon g = new ImageIcon(getClass().getResource("/images/save.png"));
        Icon iconoGuardar = new ImageIcon(g.getImage().getScaledInstance(guardar.getWidth(), guardar.getHeight(), Image.SCALE_DEFAULT));
        guardar.setIcon(iconoGuardar);
        guardar.setToolTipText("Guardar");
        
        seleccionarArchivo = new JButton();
        seleccionarArchivo.setBounds(100, 10, 40, 40);
        ImageIcon s = new ImageIcon(getClass().getResource("/images/open.png"));
        Icon iconoSeleccionar = new ImageIcon(s.getImage().getScaledInstance(seleccionarArchivo.getWidth(), seleccionarArchivo.getHeight(), Image.SCALE_DEFAULT));
        seleccionarArchivo.setIcon(iconoSeleccionar);
        seleccionarArchivo.setToolTipText("Abrir archivo");
        
        guardarComo = new JButton();
        guardarComo.setBounds(150, 10, 40, 40);
        ImageIcon gc = new ImageIcon(getClass().getResource("/images/saveas.png"));
        Icon iconoGuardarComo = new ImageIcon(gc.getImage().getScaledInstance(guardarComo.getWidth(), guardarComo.getHeight(), Image.SCALE_DEFAULT));
        guardarComo.setIcon(iconoGuardarComo);
        guardarComo.setToolTipText("Guardar como");
    
        guardar.addActionListener(buttonHandler);
        guardarComo.addActionListener(buttonHandler);
        seleccionarArchivo.addActionListener(buttonHandler); 
        

        compartir = new JButton();
        compartir.setBounds(250, 10, 40, 40);
        ImageIcon c = new ImageIcon(getClass().getResource("/images/share.png"));
        Icon iconoCompartir = new ImageIcon(c.getImage().getScaledInstance(compartir.getWidth(), compartir.getHeight(), Image.SCALE_DEFAULT));
        compartir.setIcon(iconoCompartir);
        compartir.setToolTipText("Compartir");
        
        compartir.addActionListener(buttonHandler); 
       
        panelBottom = new JPanel(); 
        panelBottom.add(volver);
        panelBottom.add(seleccionarArchivo);
        panelBottom.add(reset);
        panelBottom.add(guardar);
        panelBottom.add(guardarComo);
        
        panelBottom.add(compartir);

         
        // ImagePanel 
        imagePanel = new MarvinImagePanel(); 
         
        Container l_c = getContentPane(); 
        l_c.setLayout(new BorderLayout()); 
        l_c.add(menu, BorderLayout.NORTH);
        l_c.add(imagePanel, BorderLayout.CENTER); 
        l_c.add(panelBottom, BorderLayout.SOUTH); 
       
         
      	menu.setVisible(true);
         
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);     
    } 
     
    private void loadImage(String path)
    {
    	
        image = MarvinImageIO.loadImage(path);
        backupImage = image.clone(); 
        
        imagePanel.setImage(image); 
        imagePanel.getImage().resize(700, 500);
        imagePanel.setBounds(100, 100, 700, 500);
    } 
   
     
    private class ButtonHandler implements ActionListener
    { 
        public void actionPerformed(ActionEvent a_event){ 
            
            if(a_event.getSource() == btnMosaico){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.artistic.mosaic.jar"); 
                imagePlugin.process(image, image); 
            } 
  	    else if(a_event.getSource() == seleccionarArchivo)
            { 
  	    			File archivoseleccionado =seleccionarArchivo();
					path = archivoseleccionado.getAbsolutePath();
					loadImage(path);
				
            } 
		  	  else if(a_event.getSource() == reset)
		      { 
		  		
				  	loadImage(path);
				  
				 
		      }
		  	 else if(a_event.getSource() == volver)
		      { 
		  		
				  	VentanaPrincipal f = new VentanaPrincipal(u);
				  
				 
		      }
		  	 else if(a_event.getSource() == compartir)
		      { 
		  		
			  	try 
			  	{
					EnvioPorMail env = new EnvioPorMail(u, imagePanel.getImage());
				} 
			  	catch (IOException e) {
		
					e.printStackTrace();
				}
				  	
				 
		      }
		  	  
            else if(a_event.getSource() == btnTelevision){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.artistic.television.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnFixedCamera){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.background.determineFixedCameraBackground.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSceneBack){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.background.determineSceneBackground.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnGaussian){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.blur.gaussianBlur.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnPixelize){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.blur.pixelize.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnAlpha){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.alphaBoundary.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnBlackAndWhite){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.blackAndWhite.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnBrightness){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.brightnessAndContrast.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnColorChannel){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.colorChannel.jar");                  
                imagePlugin.process(image, image); 
            } 
            else if(a_event.getSource() == btnEmboss){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.emboss.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnGrey){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.grayScale.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnInvert){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSepia){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.sepia.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSkinColorDetection){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.skinColorDetection.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnThresholding){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.thresholding.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnNeig){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.thresholdingNeighborhood.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnMask){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.combine.combineByMask.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnTransparency){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.combine.combineByTransparency.jar");                  
                imagePlugin.process(image, image); 
            } 
            else if(a_event.getSource() == btnMerge){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.combine.mergePhotos.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnConvultion){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.convolution.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnHarris){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.corner.harris.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnMoravec){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.corner.moravec.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSusan){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.corner.susan.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnDifColor){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.difference.differenceColor.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnDifGrey){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.difference.differenceGray.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnDifRegions){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.difference.differentRegions.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnEdge){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.edgeDetector.jar");                  
                imagePlugin.process(image, image); 
            } 
            else if(a_event.getSource() == btnPrewitt){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.prewitt.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnRoberts){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.roberts.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSobel){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.edge.sobel.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnEqualization){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.equalization.histogramEqualization.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnFill){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.fill.boundaryFill.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnCircles){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.halftone.circles.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnDithering){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.halftone.dythering.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnErrorDiffusion){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.halftone.errorDiffusion.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnRylanders){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.halftone.rylanders.jar");                  
                imagePlugin.process(image, image); 
            }
            else if(a_event.getSource() == btnColorHistogram){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.histogram.colorHistogram.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnGrayHistogram){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.histogram.grayHistogram.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnInterfaceTest){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.interfaceTest.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnBoundary){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.boundary.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnClosing){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.closing.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnDilation){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.dilation.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnErosion){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.erosion.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnOpening){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.opening.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnGrayScaleQuantization){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.quantization.grayScaleQuantization.jar");                  
                imagePlugin.process(image, image); 
            } 
            else if(a_event.getSource() == btnColorQuantization){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.quantization.colorQuantization.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnGrayGradient){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.render.grayGradient.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnIterated){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.grender.iteratedFunctionSystem.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnJulia){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.render.juliaSet.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnLindenmayer){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.render.lindermayer.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnManderbrot){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.render.manderbrot.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnText){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.render.text.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnRestoration){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.restoration.noiseReduction.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnCrop){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.segmentation.crop.jar");                  
                imagePlugin.process(image, image); 
            }
            else if(a_event.getSource() == btnFloodFill){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.segmentation.floodfillSegmentation.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnImageSlicer){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.segmentation.imageSlicer.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnMaximum){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.statistical.maximum.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnMedian){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.statistical.median.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnMinimum){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.statistical.minimum.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnMode){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.statistical.mode.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSteganography){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.steganography.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSubtract){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.subtract.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnTexture){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.texture.fillTexture.jar");                  
                imagePlugin.process(image, image); 
            } 
            else if(a_event.getSource() == btnFlip){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.transform.flip.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnRotate){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.transform.rotate.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnScale){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.transform.scale.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnSkew){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.transform.skew.jar");                  
                imagePlugin.process(image, image); 
            } 
 		else if(a_event.getSource() == btnWaterShed){ 
                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.transform.watershed.jar");                  
                imagePlugin.process(image, image);
                imagePlugin.setAttribute("hsIntensidade", 50);   
            } 
 		else if (a_event.getSource() == btnCrop)
 		{
 			crop(image.clone(), image, 60, 32, 182, 62);
 		}
 		else if (a_event.getSource() == guardarComo)
 		{
 			File fPath = guardarArchivo(); 
 			if (fPath==null) 
 				return;
			path = fPath.getAbsolutePath();
			if (!path.toUpperCase().endsWith("JPG")|| !path.toUpperCase().endsWith("PNG")) {
				path = path + ".jpg";
				fPath = new File(path);
			}
			if (fPath.exists()) {  // Pide confirmación de sobreescritura
				int conf = JOptionPane.showConfirmDialog( null,
						"¡Atención! El fichero indicado ya existe. ¿Quieres sobreescribirlo?", 
						"Confirmación de fichero ya existente", JOptionPane.YES_NO_OPTION );
				if (conf!=0) return;  // si no hay confirmación no seguimos
			}
			// Intenta salvar la lista al fichero
			try {
				ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(path) );
				MarvinImage img = imagePanel.getImage();
				oos.writeObject( img.getBufferedImage() );
				oos.close();

			} catch (Exception e2) {
				
			}
 		}
            image.update();
			imagePanel.setImage(image);
           
        } 
    }
    private File seleccionarArchivo() {
		File dirActual = new File( System.getProperty("user.home") );
		JFileChooser chooser = new JFileChooser( dirActual );
		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
		chooser.setFileFilter( new FileNameExtensionFilter( 
				"All images", "jpg", "png" ) );
		int returnVal = chooser.showOpenDialog( null );
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile();
		else 
			return null;
	}
    private File guardarArchivo() {
		
    	JFileChooser file=new JFileChooser();
    	file.showOpenDialog(this);
    	File abre=file.getSelectedFile();
    	return abre;
    	  
//    	File dirActual = new File( System.getProperty("user.home") );
//		JFileChooser chooser = new JFileChooser( dirActual );
//		chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
//		int returnVal = chooser.showSaveDialog(null);
//		chooser.get
//		else 
//			return null;
	}
    public static BufferedImage Conversion() 
    {
    	MarvinImage img = imagePanel.getImage();
    	BufferedImage bI = img.getBufferedImage();
    	return bI;
    }
//    public static void Guardar() 
//    {
//    	 MarvinImageIO.saveImage(image, "user.home");
//    	 
//    	 
//    }

  
}