import java.sql.SQLException;

import Principal.Identificacion;

public class clsMain {

	public static void main(String[] args) throws SQLException
	{
		
		Principal.BaseDeDatos.initBD("usuarios" );
	
		Principal.BaseDeDatos.crearTablaBD();
		Identificacion f = new Identificacion();
	
		
	}

}
