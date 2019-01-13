package Principal;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestContraseña 
{
	Usuario u1;


	@Before
	public void setUp() throws Exception
	{
		BaseDeDatos.initBD("usuarios");
		BaseDeDatos.crearTablaBD();
		u1 = new Usuario("Manoli","contrausu");
		u1.insertarUsuario(BaseDeDatos.getStatement());
		
		
	}

	@After
	public void tearDown() throws Exception
	{
		u1.eliminar(BaseDeDatos.getStatement());

		BaseDeDatos.close();
	}

	@Test
	public void testComprobarcontrasena() throws SQLException 
	{
		
		
		String contrasenaDef = u1.consultarContrasena();
		assertEquals (contrasenaDef, "contrausu");
	}
}
	