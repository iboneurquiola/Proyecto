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

	Usuario u2;

	private static String correo;
	private static String cCorreo;

	@Before
	public void setUp() throws Exception
	{
		BaseDeDatos.initBD("usuarios");
		BaseDeDatos.crearTablaBD();
		u2 = new Usuario ("Pablito", "pablito1234");
		correo = "pablo@gmail.com";
		cCorreo = "pablito12345678";
		u2.setCorreo(correo);
		u2.setcCorreo(cCorreo);
		
		
	}

	@After
	public void tearDown() throws Exception
	{

		u2.eliminar(BaseDeDatos.getStatement());
		BaseDeDatos.close();
	}

	
	@Test
	public void testCorreo() throws SQLException
	{
		
		u2.insertarUsuario(BaseDeDatos.getStatement());
		
		u2.actualizar(BaseDeDatos.getStatement());
		
		String c = u2.consultarCorreo();
		assertEquals ( c, "pablo@gmail.com");
	
	}
	@Test
	public void testContra() throws SQLException
	{
		u2.insertarUsuario(BaseDeDatos.getStatement());
		
		u2.actualizar(BaseDeDatos.getStatement());
		
		String cC = u2.consultarContra(BaseDeDatos.getStatement());
		assertEquals ( cC,"pablito12345678");
	}
}
