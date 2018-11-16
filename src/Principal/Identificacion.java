package Principal;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;


public class Identificacion extends JFrame
{
	JPanel panelDcho = new JPanel();
	JLabel lblImagen;
	CustomTextField usuario;
	CustomPasswordField contraseña;
	
	public Identificacion() 
    {
    	JFrame frame = new JFrame();
		JPanel f;
		frame.setTitle("NERIBO PHOTO EDITOR - Identificación");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 300);
		f = new JPanel();
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setLayout(null);
	
		frame.setContentPane(f);
		
			
		
		usuario = new CustomTextField (0);
		usuario.setPlaceholder("Usuario");
		usuario.setBounds(100, 100, 300, 30);
		f.add(usuario);
		
		contraseña = new CustomPasswordField (0);
		contraseña.setPlaceholder("Contraseña");
		contraseña.setBounds(100, 140, 300, 30);
		f.add(contraseña);
				
		JButton boton1 = new JButton("Entrar");
		boton1.setBounds(150, 180, 200, 30);
		f.add(boton1);
		
	
		frame.setVisible(true);
		
		boton1.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				
				if(usuario.getText().toUpperCase().equals("USUARIO") || contraseña.getText().toUpperCase().equals("CONTRASEÑA"))
				{
					JOptionPane.showMessageDialog(null, "Introduce los datos!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Datos introducidos!");
					String user = usuario.getText();
					String password = contraseña.getText();
			
//					VentanaPrincipal f = new VentanaPrincipal();
					
				}
			}	
		});	
		
		
    }
	
	
	

}
