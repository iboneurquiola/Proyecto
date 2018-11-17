package Principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCollage 
{
	public VentanaCollage()
	{
		JFrame frame = new JFrame();
		frame.setTitle("NERIBO PHOTO EDITOR - Collage");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1000, 700);
		
		JPanel panelIzdo = new JPanel(new BorderLayout());
		frame.getContentPane().add(panelIzdo, BorderLayout.WEST);
	
		JPanel panelDcho = new JPanel(new BorderLayout());
		frame.getContentPane().add(panelDcho, BorderLayout.EAST);

		JPanel IzdoArriba = new JPanel ();
		JPanel IzdoAbajo = new JPanel (new BorderLayout());
		
		panelIzdo.add(IzdoArriba, BorderLayout.NORTH);
		panelIzdo.add(IzdoAbajo, BorderLayout.SOUTH);
		
		JButton seleccionar = new JButton ("Seleccionar foto");
		//Ajustar el botón en el centro del panel
		seleccionar.setBounds(300, 300, 100, 100);
		IzdoArriba.add(seleccionar);
		
		JPanel panelSur = new JPanel (new FlowLayout());
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		JButton guardar = new JButton ("Guardar");
		JButton deshacer = new JButton("Deshacer");
		JButton compartir = new JButton ("Compartir");
		
		panelSur.add(guardar);
		panelSur.add(deshacer);
		panelSur.add(compartir);
		
		frame.setVisible(true);
		
	}

}
