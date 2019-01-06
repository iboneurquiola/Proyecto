package Principal;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Identificacion extends JFrame
{
	JPanel panelDcho = new JPanel();
	JLabel lblImagen;
	JTextField usuario;
	JPasswordField contrasena;
	Fondo f ;
	JFrame frame;
	
	
	public Identificacion() 
    {
		frame = new JFrame();
	
		frame.setTitle("NERIBO PHOTO EDITOR - Identificación");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		f = new Fondo();
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setLayout(null);
	
		frame.setContentPane(f);
		
		JLabel lblUsuario = new JLabel("Usuario:" );
		lblUsuario.setBounds(20, 100, 300, 30);
		lblUsuario.setForeground(Color.WHITE);
		f.add(lblUsuario);	
		
		usuario = new JTextField (20);
		usuario.setBounds(100, 100, 300, 30);
		f.add(usuario);
		
		JLabel lblContraseña = new JLabel("Contraseña:" );
		lblContraseña.setBounds(20, 140, 300, 30);
		lblContraseña.setForeground(Color.WHITE);
		f.add(lblContraseña);	
		
		contrasena = new JPasswordField (20);
		contrasena.setToolTipText("Contraseña");
		contrasena.setBounds(100, 140, 300, 30);
		f.add(contrasena);
				
		JButton boton1 = new JButton("Entrar");
		boton1.setBounds(150, 180, 200, 30);
		f.add(boton1);
		f.setCursor(new Cursor(Cursor.TEXT_CURSOR));
	
		frame.setVisible(true);
		
		boton1.addActionListener (new ActionListener()
		{
			boolean cargarDeBD;
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				
				if(usuario.getText().toUpperCase().equals("USUARIO") || contrasena.getText().toUpperCase().equals("CONTRASENA"))
				{
					JOptionPane.showMessageDialog(null, "Introduce los datos!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Datos introducidos!");
					String user = usuario.getText();
					String password = contrasena.getText();
					
					
					Usuario u = new Usuario(user,password);
					if (cargarDeBD) 
					{
//						u.cargarDeTabla( BaseDeDatos.getStatement(), user );
						VentanaPrincipal f = new VentanaPrincipal();
					}
					
					else 
					{
						SolicitudDeCorreo sc = new SolicitudDeCorreo(user,password);
		
					}
				frame.dispose();	
				}
			
			}	
		});	
		

    }

	
	

}
