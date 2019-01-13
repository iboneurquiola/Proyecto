package Principal;

import static marvin.MarvinPluginCollection.crop;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

public class EditarCollage extends JFrame
{
	 
		private static MarvinImagePanel     imagePanel; 
	    private static MarvinImage backupImage;
		private MarvinImage image; 

	    private JPanel      panelBottom; 
	    private JMenuItem btnMosaico, btnTelevision, btnGaussian, btnPixelize, btnAlpha, 
		btnBrightness, btnEmboss, btnGrey, btnInvert, btnSepia, btnThresholding, btnNeig, btnEdge, btnPrewitt, btnEqualization, btnCircles, 
		btnErrorDiffusion, btnRylanders, btnColorHistogram, btnGrayHistogram, btnGrayScaleQuantization, btnColorQuantization, btnRestoration, btnCrop, btnMedian, btnFlip, btnRotate, btnScale;
	    private JButton  reset, guardar,volver, guardarComo,compartir;
	    private Usuario u;
	    private MarvinImagePlugin     imagePlugin; 
	    private HiloCollage hilo;
	     
	    public EditarCollage(BufferedImage image, Usuario u)  
	    { 
	    	this.u = u;
	    	
	    	
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
	 	
	 	
	 		btnBrightness = new JMenuItem("Brightness and Contrast");
	 		editar.add(btnAlpha);
	 		btnBrightness.addActionListener(buttonHandler);
	 	
	 		
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
	 	
	 		
	 		btnThresholding = new JMenuItem("Thresholding");
	 		menuColor.add(btnThresholding);
	 		btnThresholding.addActionListener(buttonHandler);

	 		btnNeig = new JMenuItem("Thresholding Neighborhood");
	 		menuColor.add(btnNeig);
	 		btnNeig.addActionListener(buttonHandler);

	 		

	 		JMenu menuEdge = new JMenu("Edge");
	 		filtros.add(menuEdge);

	 		btnEdge = new JMenuItem("Edge");
	 		menuEdge.add(btnEdge);
	 		btnEdge.addActionListener(buttonHandler);


	 		btnPrewitt = new JMenuItem("Prewitt");
	 		menuEdge.add(btnPrewitt);
	 		btnPrewitt.addActionListener(buttonHandler);

	 		btnEqualization = new JMenuItem("Equalization");
	 		filtros.add(btnEqualization);
	 		btnEqualization.addActionListener(buttonHandler);

	 	
	 		JMenu menuHalftone = new JMenu("Halftone");
	 		filtros.add(menuHalftone);

	 		btnCircles = new JMenuItem("Circles");
	 		menuHalftone.add(btnCircles);
	 		btnCircles.addActionListener(buttonHandler);

	 		btnErrorDiffusion = new JMenuItem("Error Diffusion");
	 		menuHalftone.add(btnErrorDiffusion);
	 		btnErrorDiffusion.addActionListener(buttonHandler);

	 		btnRylanders = new JMenuItem("Rylanders");
	 		menuHalftone.add(btnRylanders);
	 		btnRylanders.addActionListener(buttonHandler);

	 		JMenu menuHistogram = new JMenu("Histograma");
	 		editar.add(menuHistogram);

	 		btnColorHistogram = new JMenuItem("Color Histogram");
	 		menuHistogram.add(btnColorHistogram);
	 		btnColorHistogram.addActionListener(buttonHandler);

	 		btnGrayHistogram = new JMenuItem("Gray Histogram");
	 		menuHistogram.add(btnGrayHistogram);
	 		btnGrayHistogram.addActionListener(buttonHandler);

	 		
	 		JMenu menuQuantization = new JMenu("Quantization");
	 		filtros.add(menuQuantization);

	 		btnGrayScaleQuantization = new JMenuItem("Gray Scale Quantization");
	 		menuQuantization.add(btnGrayScaleQuantization);
	 		btnGrayScaleQuantization.addActionListener(buttonHandler);

	 		
	 		btnCrop = new JMenuItem("Crop");
	 		editar.add(btnCrop);
	 		btnCrop.addActionListener(buttonHandler);

	 		
	 		btnMedian = new JMenuItem("Median");
	 		filtros.add(btnMedian);
	 		btnMedian.addActionListener(buttonHandler);

	 		btnFlip = new JMenuItem("Flip");
	 		editar.add(btnFlip);
	 		btnFlip.addActionListener(buttonHandler);

	 		btnRotate = new JMenuItem("Rotate");
	 		editar.add(btnRotate);
	 		btnRotate.addActionListener(buttonHandler);

	 		btnScale = new JMenuItem("Scale");
	 		editar.add(btnScale);
	 		btnScale.addActionListener(buttonHandler);


	        
			volver = new JButton();
	        volver.setBounds(0, 10, 40, 40);
	        ImageIcon v = new ImageIcon(getClass().getResource("/images/volver.png"));
	        Icon iconoVolver = new ImageIcon(v.getImage().getScaledInstance(volver.getWidth(), volver.getHeight(), Image.SCALE_DEFAULT));
	        volver.setIcon(iconoVolver);
	        volver.setToolTipText("Volver");
	        volver.addActionListener(buttonHandler);

			reset = new JButton();
	        reset.setBounds(0, 10, 40, 40);
	        ImageIcon r = new ImageIcon(getClass().getResource("/images/reset.png"));
	        Icon iconoReset = new ImageIcon(r.getImage().getScaledInstance(reset.getWidth(), reset.getHeight(), Image.SCALE_DEFAULT));
	        reset.setIcon(iconoReset);
	        reset.addActionListener(buttonHandler); 
	        reset.setToolTipText("Reset");
	        
	        guardar = new JButton();
	        guardar.setBounds(50, 10, 40, 40);
	        ImageIcon g = new ImageIcon(getClass().getResource("/images/save.png"));
	        Icon iconoGuardar = new ImageIcon(g.getImage().getScaledInstance(guardar.getWidth(), guardar.getHeight(), Image.SCALE_DEFAULT));
	        guardar.setIcon(iconoGuardar);
	        guardar.setToolTipText("Guardar");
	           
	        guardarComo = new JButton();
	        guardarComo.setBounds(150, 10, 40, 40);
	        ImageIcon gc = new ImageIcon(getClass().getResource("/images/saveas.png"));
	        Icon iconoGuardarComo = new ImageIcon(gc.getImage().getScaledInstance(guardarComo.getWidth(), guardarComo.getHeight(), Image.SCALE_DEFAULT));
	        guardarComo.setIcon(iconoGuardarComo);
	        guardarComo.setToolTipText("Guardar como");
	       
	    
	        guardar.addActionListener(buttonHandler);
	        guardarComo.addActionListener(buttonHandler);
	      
	        compartir = new JButton();
	        compartir.setBounds(250, 10, 40, 40);
	        ImageIcon c = new ImageIcon(getClass().getResource("/images/share.png"));
	        Icon iconoCompartir = new ImageIcon(c.getImage().getScaledInstance(compartir.getWidth(), compartir.getHeight(), Image.SCALE_DEFAULT));
	        compartir.setIcon(iconoCompartir);
	        compartir.setToolTipText("Compartir");
	       
	        compartir.addActionListener(buttonHandler);
	        panelBottom = new JPanel(); 
	       
	        panelBottom.add(volver);
	        panelBottom.add(reset);
	        panelBottom.add(guardar);
	        panelBottom.add(guardarComo);
	        panelBottom.add(compartir);

	        loadImage(image);
	         
	        hilo = new HiloCollage();
	        hilo.start();
	        
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
	     
   
	     
	    private class ButtonHandler implements ActionListener
	    { 
	    	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent a_event){ 
	            
	            if(a_event.getSource() == btnMosaico){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.artistic.mosaic.jar"); 
	                imagePlugin.process(image, image); 
	            } 
	  	   
			  	  else if(a_event.getSource() == reset)
			      { 
			  		
					  	imagePanel.setImage(backupImage);
					  
					 
			      }
			  	 else if(a_event.getSource() == volver)
			      { 
			  		
					  	new VentanaPrincipal(u);
					  
					 
			      }
			  	 else if(a_event.getSource() == compartir)
			      { 
			  		
				  	try 
				  	{
						new EnvioPorMail(u, imagePanel.getImage());
					} 
				  	catch (IOException e) {
			
						e.printStackTrace();
					}
					  	
					 
			      }
			  	  
	            else if(a_event.getSource() == btnTelevision){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.artistic.television.jar");                  
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
	 		
	 		else if(a_event.getSource() == btnBrightness){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.brightnessAndContrast.jar");                  
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
	 		
	 		else if(a_event.getSource() == btnThresholding){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.thresholding.jar");                  
	                imagePlugin.process(image, image); 
	            } 
	 		else if(a_event.getSource() == btnNeig){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.thresholdingNeighborhood.jar");                  
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
	 		
	 		else if(a_event.getSource() == btnEqualization){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.equalization.histogramEqualization.jar");                  
	                imagePlugin.process(image, image); 
	            } 
	 		
	 		else if(a_event.getSource() == btnCircles){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.halftone.circles.jar");                  
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
	 		
	 		 
	 		else if(a_event.getSource() == btnGrayScaleQuantization){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.quantization.grayScaleQuantization.jar");                  
	                imagePlugin.process(image, image); 
	            } 
	            else if(a_event.getSource() == btnColorQuantization){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.quantization.colorQuantization.jar");                  
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
	            
	 		else if(a_event.getSource() == btnMedian){ 
	                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.statistical.median.jar");                  
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
	 		
	 		else if (a_event.getSource() == btnCrop)
	 		{
	 			crop(image, image, 60, 32, 182, 62);
	 		}
	 		else if (a_event.getSource() == guardar)
	 		{
	 			Guardar();	
	 		}
	 		else if (a_event.getSource() == guardarComo)
	 		{
	 			
	 		    guardarArchivo();
	 		    hilo.stop();
	 		}
	            image.update();
				imagePanel.setImage(image);
	           
	        } 
	    }
	    private File seleccionarArchivo() 
	    {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileFilter( new FileNameExtensionFilter( 
					"All images", "jpg", "png" ) );
			int returnVal = chooser.showOpenDialog(this);
			
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
				return chooser.getSelectedFile();
			}
			else 
				return null;
		}
	    private void guardarArchivo() 
	    {
	    	BufferedImage bImage = image.getBufferedImage();
	    	JFileChooser fileChooser = new JFileChooser();
	    	int saveValue = fileChooser.showSaveDialog(null);
	        if (saveValue == JFileChooser.APPROVE_OPTION) {
	            try {
	                ImageIO.write(bImage, "png", new File(fileChooser
	                        .getSelectedFile().getAbsolutePath()
	                        + fileChooser.getSelectedFile().getName() +".png" ));
	                JOptionPane.showMessageDialog(null, "¡Guardado!");
	               
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	       
		}
	    
	    public static void Guardar() 
	    {
	    	BufferedImage bImage = imagePanel.getImage().getBufferedImage();
	    	String crear = System.getProperty("user.home");
	    	String direct = "/NERIBO/imagenEditada.png";
	    	File directorio=new File(crear+direct ); 
	    	if (directorio.mkdirs() || directorio.exists())
	    	{
	    	
		    	
		    	try 
		    	{	
					ImageIO.write(bImage, "png", new File(crear+direct));
				} 
		    	catch (IOException e) 
		    	{
		
					e.printStackTrace();
				}
	    	}
	    
	    }
	    public void loadImage(BufferedImage image)
	    {
	    	this.image = new MarvinImage(image);
	    	
	    	backupImage  = this.image.clone();
	    	imagePanel = new MarvinImagePanel();
		    imagePanel.setImage(this.image);
		    imagePanel.getImage().resize(600, 600);
	    	
	    }
}
