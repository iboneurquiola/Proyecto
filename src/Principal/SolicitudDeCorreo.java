package Principal;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SolicitudDeCorreo extends JFrame
{
	JFrame frame;
	private Statement stm;
	private String user;
	private Usuario u; 
	
	public SolicitudDeCorreo(Usuario u)
	{
		this.u = u;
		frame = new JFrame();
		JPanel f;
		frame.setTitle("Registro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 400, 400);
		f = new JPanel();
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setLayout(null);
	
		frame.setContentPane(f);
		
		JLabel lblUsuario = new JLabel("Email:" );
		lblUsuario.setBounds(20, 100, 100, 30);
		f.add(lblUsuario);	
		
		JTextField usuario = new JTextField (20);
		usuario.setBounds(100, 100, 200, 30);
		f.add(usuario);
			
		JLabel lblContrasena = new JLabel("Contrasena:" );
		lblContrasena.setBounds(20, 140, 100, 30);
		f.add(lblContrasena);	
		
		JPasswordField contrasena = new JPasswordField (20);
		contrasena.setBounds(100, 140, 200, 30);
		f.add(contrasena);
				
		JButton boton1 = new JButton("Registrar");
		boton1.setBounds(150, 300, 200, 30);
		f.add(boton1);
	
		frame.setVisible(true);
		
		boton1.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				
				if(usuario == null || contrasena == null)
				{
					JOptionPane.showMessageDialog(null, "Uno de los campos está vacío, ¡rellénelo!");
				}
				else
				{
					
					String correo = usuario.getText();
					String contr = contrasena.getText();
					String patron1 = ".*@gmail\\.com";   // Patron de la ER
					
					Pattern pat1 = Pattern.compile( patron1 );  // Se compila		
					
					if (pat1.matcher(correo).matches())
					{
						JOptionPane.showMessageDialog(null, "¡Bienvenido!");
						try 
						{
							u.setCorreo(correo);
							u.setcCorreo(contr);
							u.actualizar(BaseDeDatos.getStatement());
					
						} 
						catch (SQLException e1) {
							
							e1.printStackTrace();
						}
						VentanaPrincipal v = new VentanaPrincipal(u);
						frame.dispose();
					}
						
					else 
					{
						JOptionPane.showMessageDialog(null, "El correo debe terminar @gmail.com");
					}
					
					
					
					
					
					
					
				}
			}	
		});	
		
	
    }
}
