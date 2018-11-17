package Principal;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;



public class VentanaPrincipal extends JFrame
{

	JLabel lblImagen;
	
	
	public VentanaPrincipal() 
    {
    	JFrame frame = new JFrame();
		JPanel f;
		frame.setTitle("NERIBO PHOTO EDITOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 300);
		f = new JPanel();
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(f);

		
		
		JLabel lblIntroduccion = new JLabel("Bienvenidos a Neribo Photo Editor");
		lblIntroduccion.setBounds(20, 30, 227, 14);
		f.add(lblIntroduccion);
		JLabel lblIntroduccion2 = new JLabel("Nuestra editor tiene dos opciones:");
		lblIntroduccion2.setBounds(20, 50, 227, 14);
		f.add(lblIntroduccion2);
		
				
		JButton boton1 = new JButton("Editar foto");
		boton1.setBounds(20, 150, 300, 30);
		JButton boton2 = new JButton("Hacer un collage");
		boton2.setBounds(20, 200, 300,30);
		f.add(boton1);
		f.add(boton2);
		
		
		 MarvinImage image = MarvinImageIO.loadImage("src\\Principal\\img\\logo.png");

	     MarvinImagePanel imagePanel = new MarvinImagePanel();
	     
		 
	     imagePanel.setImage(image); 
	     imagePanel.getImage().resize(300, 200);

	     imagePanel.setBounds(360, 10, 300, 200);	
	     
	     f.add(imagePanel);
	     

		
		frame.setVisible(true);
		
		boton1.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				VentanaEditor editor = new VentanaEditor();
			}	
		});	
		
		boton2.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				VentanaCollage collage = new VentanaCollage();
			}	
		});	
    }
	
	private ImageIcon ajustarImagen (String ico)
	{
		ImageIcon IconAux = new ImageIcon(ico);
		Image Icon = IconAux.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon imagen = new ImageIcon (Icon );
		return imagen;
	}
	

}
