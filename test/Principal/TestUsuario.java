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
	private static String contrase�a;


	@Before
	public void setUp() throws Exception
	{
		u1 = new Usuario();
		u2 = new Usuario();
		usuario = null;
		contrase�a = null;
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testComprobarContrasena() 
	{
		usuario = "Manoli";
		contrase�a = "contrausu";
		u1 = new Usuario (usuario, contrase�a);
		String contra = null;
		try
		{
			contra = u1.comprobarContrase�a(BaseDeDatos.getStatement());
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
		contrase�a = "pablito1234";
		u2 = new Usuario (usuario, contrase�a);
		u2.setContrase�a("pablito6789");
		String c = null;
		try
		{
			u2.actualizar(BaseDeDatos.getStatement());
			assertEquals ( c =u2.getContrase�a(), "pablito6789");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
