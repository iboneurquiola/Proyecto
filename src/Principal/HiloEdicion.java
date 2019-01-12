package Principal;

public class HiloEdicion extends Thread
{
	
	@Override
	public void run() 
	{
		VentanaEditor.Guardar();
		try {
			 Thread.sleep(1000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}
	
}
