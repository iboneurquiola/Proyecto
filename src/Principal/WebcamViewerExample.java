package Principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.github.sarxos.webcam.WebcamResolution;

public class WebcamViewerExample extends JFrame implements ActionListener , Runnable, WebcamListener, WindowListener, UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {
	 
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private WebcamPicker picker = null;
    private JButton boton = new JButton("Tomar foto");
 
    @Override
    public void run() {
 
        Webcam.addDiscoveryListener(this);
 
        setTitle("Java Webcam Capture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
 
        addWindowListener(this);
 
        picker = new WebcamPicker();
        picker.addItemListener(this);
 
        webcam = picker.getSelectedWebcam();
 
        if (webcam == null) {
            System.out.println("No webcams found...");
            System.exit(1);
        }
 
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.addWebcamListener(WebcamViewerExample.this);
 
        panel = new WebcamPanel(webcam, false);
         panel.setFPSDisplayed(true);
 
        add(picker, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
         
        boton.addActionListener(this);
 
        pack();
        setVisible(true);
 
        Thread t = new Thread() {
 
            @Override
            public void run() {
                panel.start();
            }
        };
        t.setName("example-starter");
        t.setDaemon(true);
        t.setUncaughtExceptionHandler(this);
        t.start();
    }
 
    @Override
    public void webcamOpen(WebcamEvent we) {
     
    }
 
    @Override
    public void webcamClosed(WebcamEvent we) {
      
    }
 
    @Override
    public void webcamDisposed(WebcamEvent we) {
      
    }
 
   
    @Override
    public void windowActivated(WindowEvent e) {
    }
 
    @Override
    public void windowClosed(WindowEvent e) {
        webcam.close();
    }
 
    @Override
    public void windowClosing(WindowEvent e) {
    }
 
    @Override
    public void windowOpened(WindowEvent e) {
    }
 
    @Override
    public void windowDeactivated(WindowEvent e) {
    }
 
    @Override
    public void windowDeiconified(WindowEvent e) {
      
        panel.resume();
    }
 
    @Override
    public void windowIconified(WindowEvent e) {
       
        panel.pause();
    }
 
    @Override
    public void uncaughtException(Thread t, Throwable e) {
       
    }
 
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != webcam) {
            if (webcam != null) {
 
                panel.stop();
 
                remove(panel);
 
                webcam.removeWebcamListener(this);
                webcam.close();
 
                webcam = (Webcam) e.getItem();
                webcam.setViewSize(WebcamResolution.VGA.getSize());
                webcam.addWebcamListener(this);
 
                System.out.println("selected " + webcam.getName());
 
                panel = new WebcamPanel(webcam, false);
                panel.setFPSDisplayed(true);
 
                add(panel, BorderLayout.CENTER);
                pack();
 
                Thread t = new Thread() {
 
                    @Override
                    public void run() {
                        panel.start();
                    }
                };
                t.setName("example-stoper");
                t.setDaemon(true);
                t.setUncaughtExceptionHandler(this);
                t.start();
            }
        }
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void webcamFound(WebcamDiscoveryEvent event) {
        if (picker != null) {
            picker.addItem(event.getWebcam());
        }
    }
 
    @Override
    public void webcamGone(WebcamDiscoveryEvent event) {
        if (picker != null) {
            picker.removeItem(event.getWebcam());
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
         
        if(e.getSource() == boton)
        {
          
            image = webcam.getImage();
             
            try {
                // save image to PNG file
                ImageIO.write(image, "JPG", new File("test.jpg"));
                VentanaEditor f = new VentanaEditor("test.jpg");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
         
    }

	@Override
	public void webcamImageObtained(WebcamEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
