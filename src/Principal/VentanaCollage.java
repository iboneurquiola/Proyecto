package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import marvin.image.MarvinImage;

public class VentanaCollage extends JFrame
{ 
    

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelCentral; 
    private JButton dosxuno, unoxdos, dosxdos, tresxuno;
    private Usuario u;
     
    public VentanaCollage(Usuario u)  
    { 
    	
    	setTitle("Collage");
    	setSize(500,400);
		this.u=u;
    	ButtonHandler buttonHandler = new ButtonHandler(); 
    
		dosxuno = new JButton();
        dosxuno.setBounds(100, 100, 200, 200);
        ImageIcon r = new ImageIcon(getClass().getResource("/images/dosxuno.png"));
        Icon iconodosxuno = new ImageIcon(r.getImage().getScaledInstance(dosxuno.getWidth(), dosxuno.getHeight(), Image.SCALE_DEFAULT));
        dosxuno.setIcon(iconodosxuno);
        dosxuno.addActionListener(buttonHandler); 
        
        unoxdos = new JButton();
        unoxdos.setBounds(350, 100, 200, 200);
        ImageIcon g = new ImageIcon(getClass().getResource("/images/unoxdos.png"));
        Icon iconounoxdos = new ImageIcon(g.getImage().getScaledInstance(unoxdos.getWidth(), unoxdos.getHeight(), Image.SCALE_DEFAULT));
        unoxdos.setIcon(iconounoxdos);
        
        dosxdos = new JButton();
        dosxdos.setBounds(100, 350, 200, 200);
        ImageIcon s = new ImageIcon(getClass().getResource("/images/dosxdos.png"));
        Icon iconoSeleccionar = new ImageIcon(s.getImage().getScaledInstance(dosxdos.getWidth(), dosxdos.getHeight(), Image.SCALE_DEFAULT));
        dosxdos.setIcon(iconoSeleccionar);
        
        tresxuno = new JButton();
        tresxuno.setBounds(350, 350, 200, 200);
        ImageIcon gc = new ImageIcon(getClass().getResource("/images/tresxuno.png"));
        Icon iconotresxuno = new ImageIcon(gc.getImage().getScaledInstance(tresxuno.getWidth(), tresxuno.getHeight(), Image.SCALE_DEFAULT));
        tresxuno.setIcon(iconotresxuno);
      
        
        unoxdos.addActionListener(buttonHandler);
        tresxuno.addActionListener(buttonHandler);
        dosxdos.addActionListener(buttonHandler); 
        
        
       
        panelCentral = new JPanel(); 
        panelCentral.setLayout(null);
        
        panelCentral.add(dosxuno);
        panelCentral.add(dosxdos);
        panelCentral.add(unoxdos);
        panelCentral.add(tresxuno);
        
        JLabel lblIntroduccion = new JLabel("Escoga uno de los formatos para tu collage" );
		lblIntroduccion.setBounds(175, 30, 400, 14);
		panelCentral.add(lblIntroduccion);
        
        
        add(panelCentral);
            
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setVisible(true);     
    } 
   
   
    private File[] SeleccionarArchivos()
    {
    	JFileChooser dialog = new JFileChooser();
    	 dialog.setMultiSelectionEnabled(true);
    	 dialog.showOpenDialog(null);

    	 File[] archivos = dialog.getSelectedFiles();
    	 
		return archivos;
    }
    private class ButtonHandler implements ActionListener
    { 
        public void actionPerformed(ActionEvent a_event){ 
            
            if(a_event.getSource() == unoxdos)
            { 
            	File[] archivos = SeleccionarArchivos();
            	if (archivos.length !=2)
            	{
            		JOptionPane.showMessageDialog(null, "Selecciona DOS archivos");
            		archivos = SeleccionarArchivos();
            	}
            	
            	BufferedImage img1;
            	BufferedImage img2;
            	BufferedImage iFinal;
            	
            	try 
            	{
            		
            		img1 = ImageIO.read(archivos[0]);
            		BufferedImage newImg1 =resize(img1,200,400);
            		img2 = ImageIO.read(archivos[1]);
            		BufferedImage newImg2 =resize(img2,200,400);
					UnoXDos collage1 = new UnoXDos(newImg1, newImg2);
					iFinal = collage1.HacerCollage();
					
					EditarCollage e = new EditarCollage(iFinal, u);
					
				
				} 
            	catch (IOException e) {
					
					e.printStackTrace();
				}
           	      
           	  
            } 
            else if(a_event.getSource() == dosxdos)
            { 
            	File[] archivos = SeleccionarArchivos();
            	if (archivos.length !=4)
            	{
            		JOptionPane.showMessageDialog(null, "Selecciona CUATRO archivos");
            		archivos = SeleccionarArchivos();
            	}
            	BufferedImage img1;
            	BufferedImage img2;
            	BufferedImage img3;
            	BufferedImage img4;
            	BufferedImage iFinal;
            	
            	try 
            	{
            		img1 = ImageIO.read(archivos[0]);
            		BufferedImage newImg1 =resize(img1,200,200);
            		img2 = ImageIO.read(archivos[1]);
            		BufferedImage newImg2 =resize(img2,200,200);
            		img3 = ImageIO.read(archivos[2]);
            		BufferedImage newImg3 =resize(img3,200,200);
            		img4 = ImageIO.read(archivos[3]);
            		BufferedImage newImg4 =resize(img4,200,200);
					DosXDos collage1 = new DosXDos(newImg1, newImg2, newImg3, newImg4);
					iFinal = collage1.HacerCollage();
					
					EditarCollage e = new EditarCollage(iFinal, u);
					
				
				} 
            	catch (IOException e) {
					
					e.printStackTrace();
				}
            } 
		  	else if(a_event.getSource() == dosxuno)
		    { 
		  		File[] archivos = SeleccionarArchivos();
		  		
		  		if (archivos.length !=2)
            	{
            		JOptionPane.showMessageDialog(null, "Selecciona DOS archivos");
            		
            		archivos = SeleccionarArchivos();
            	}
		  		
            	BufferedImage img1;
            	BufferedImage img2;
            	BufferedImage iFinal;
            	
            	try 
            	{
            		img1 = ImageIO.read(archivos[0]);
            		BufferedImage newImg1 =resize(img1,400,200);
            		img2 = ImageIO.read(archivos[1]);
            		BufferedImage newImg2 = resize(img2,400,200);
					DosXUno collage1 = new DosXUno(newImg1, newImg2);
					iFinal = collage1.CopiarImg1();
				
					EditarCollage e = new EditarCollage(iFinal, u);
					
				
				} 
            	catch (IOException e) {
					
					e.printStackTrace();
				}
		    }
		  	else if(a_event.getSource() == tresxuno)
		    { 
		  		File[] archivos = SeleccionarArchivos();
		  		if (archivos.length !=3)
            	{
            		JOptionPane.showMessageDialog(null, "Selecciona TRES archivos");
            		archivos = SeleccionarArchivos();
            	}
            	BufferedImage img1;
            	BufferedImage img2;
            	BufferedImage img3;
            	BufferedImage iFinal;
            	
            	try 
            	{
            		img1 = ImageIO.read(archivos[0]);
            		BufferedImage newImg1 =resize(img1,400,133);
            		img2 = ImageIO.read(archivos[1]);
            		BufferedImage newImg2 =resize(img2,400,133);
            		img3 = ImageIO.read(archivos[2]);
            		BufferedImage newImg3 =resize(img3,400,133);
					TresXUno collage1 = new TresXUno(newImg1, newImg2, newImg3);
					iFinal = collage1.HacerCollage();
					
					EditarCollage e = new EditarCollage(iFinal, u);
					
				
				} 
            	catch (IOException e) {
					
					e.printStackTrace();
				} 
		    }
		  	
        }
        
  
}
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {  
        int w = img.getWidth();  
        int h = img.getHeight();  
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());  
        Graphics2D g = dimg.createGraphics();  
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);  
        g.dispose();  
        return dimg;  
    }  
}
