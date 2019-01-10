package Principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;



public class VentanaPrincipal extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Fondo f;
	
	
	
	public VentanaPrincipal(Usuario u) 
    {
	
    	frame = new JFrame();
		
		frame.setTitle("NERIBO PHOTO EDITOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		f = new Fondo();
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setLayout(null);
		frame.add(f);

		
		JLabel lblIntroduccion = new JLabel("Bienvenidos a Neribo Photo Editor" );
		lblIntroduccion.setBounds(25, 30, 227, 14);
		lblIntroduccion.setForeground(Color.WHITE);
		f.add(lblIntroduccion);
		JLabel lblIntroduccion2 = new JLabel("Tiene dos opciones:");
		lblIntroduccion2.setBounds(25, 70, 227, 14);
		lblIntroduccion2.setForeground(Color.WHITE);
		f.add(lblIntroduccion2);
		
				
		JButton boton1 = new JButton();
	  
	    boton1.setBounds(20, 100, 200, 55);
	    ImageIcon gc = new ImageIcon(getClass().getResource("/images/editor.png"));
	    Icon iconoEditor = new ImageIcon(gc.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_DEFAULT));
	    boton1.setIcon(iconoEditor);
		
	    JButton boton2 = new JButton();
		boton2.setBounds(20, 160, 200, 55);
		
	    ImageIcon a = new ImageIcon(getClass().getResource("/images/collage.png"));
	    Icon iconoCollage = new ImageIcon(a.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_DEFAULT));
	    boton2.setIcon(iconoCollage);
		
		f.add(boton1);
		f.add(boton2);
	
		
		boton1.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				VentanaEditor editor = new VentanaEditor(null, u);
				
			}	
		});	
		
		boton2.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
				VentanaCollage collage = new VentanaCollage(u);
			}	
		});	
		frame.setVisible(true);
    }
	
  
}
