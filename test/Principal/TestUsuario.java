package Principal;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUsuario 
{
	Usuario u1;
	Usuario u2;
	private static String usuario;
	private static String contrasena;


	@Before
	public void setUp() throws Exception
	{
		u1 = new Usuario();
		u2 = new Usuario();
		usuario = null;
		contrasena = null;
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testComprobarcontraseñañañana() 
	{
		usuario = "Manoli";
		contrasena = "contrausu";
		u1 = new Usuario (usuario, contrasena);
		boolean contra = (Boolean) null;
		try
		{
			contra = u1.comprobarContrasena();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		assertEquals (contra, "contrausu");
	}
	
	@Test
	public void testActualizar()
	{
		usuario = "Pablito";
		contrasena = "pablito1234";
		u2 = new Usuario (usuario, contrasena);
		u2.setContrasena("pablito6789");
		String c = null;
		try
		{
			u2.actualizar(BaseDeDatos.getStatement());
			assertEquals ( c =u2.getContrasena(), "pablito6789");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
