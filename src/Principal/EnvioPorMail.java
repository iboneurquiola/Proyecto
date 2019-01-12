package Principal;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import marvin.image.MarvinImage;

public class EnvioPorMail extends JFrame
{
	CustomTextField destinatario, asunto, cuerpo;
	JButton boton1;
	JLabel imagen;
	private Usuario u;
	private MarvinImage image;
	private File outputfile;
	
	public EnvioPorMail(Usuario u, MarvinImage img) throws IOException
	{
		this.image = img;
		BufferedImage bI = image.getBufferedImage();
		outputfile = new File("image.png");
		ImageIO.write(bI, "png", outputfile);
		this.u = u;
		JFrame frame = new JFrame();
		JPanel f;
		frame.setTitle("Envio por correo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 400);
		f = new JPanel();
		f.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setLayout(null);
	
		frame.setContentPane(f);
		
		destinatario = new CustomTextField (0);
		destinatario.setPlaceholder("DESTINATARIO");
		destinatario.setBounds(100, 100, 300, 30);
		f.add(destinatario);
		
		asunto = new CustomTextField (0);
		asunto.setPlaceholder("ASUNTO");
		asunto.setBounds(100, 140, 300, 30);
		f.add(asunto);
		
		cuerpo = new CustomTextField(5);
		cuerpo.setPlaceholder("CUERPO");
		cuerpo.setBounds(100, 180, 300, 100);
		f.add(cuerpo);
				
		boton1 = new JButton("Enviar");
		boton1.setBounds(100, 300, 200, 30);
		f.add(boton1);
		
		imagen = new JLabel(" ");
		imagen.setBounds(500, 150, 150, 150);
	    ImageIcon gc = new ImageIcon(getClass().getResource("/images/email.png"));
	    Icon iconoEmail = new ImageIcon(gc.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
	    imagen.setIcon(iconoEmail);
	    
	    f.add(imagen);
	
		frame.setVisible(true);
		
		boton1.addActionListener (new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			
				
				if(destinatario.getText().toUpperCase().equals("destinatario") || asunto.getText().toUpperCase().equals("asunto"))
				{
					JOptionPane.showMessageDialog(null, "Uno de los campos está vacío, ¡rellénelo!");
				}
				else
				{
					
					String d = destinatario.getText();
					String a = asunto.getText();
					String c = cuerpo.getText();
					String correo = null;
					try 
					{
						correo = u.consultarCorreo();
						System.out.println(correo);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String contra = null;
					try {
						contra = u.consultarContra(BaseDeDatos.getStatement());
						System.out.println(contra);
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
					
					Enviar.enviarConGMail(correo, contra, d, a, c, outputfile);
					
					JOptionPane.showMessageDialog(null, "¡Enviado!");
					int opcion = JOptionPane.showConfirmDialog(f, "¿Quieres volver a editar una foto?");
					if(opcion == 0)
					{
						VentanaPrincipal f = new VentanaPrincipal(u);
						frame.dispose();
					}
					else
					{
						System.exit(0);
					}
					
					
				}
			}	
		});	
		
		
    }
		
}
	
	
	
	
	

