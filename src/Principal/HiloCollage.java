package Principal;

public class HiloCollage extends Thread
{
	
	@Override
	public void run() 
	{
		EditarCollage.Guardar();
		try {
			 Thread.sleep(1000);
		}	
		catch (InterruptedException e) 
		{
			 e.printStackTrace();
		}
	}
	
}
