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
	private static String correo;
	private static String cCorreo;

	@Before
	public void setUp() throws Exception
	{
		BaseDeDatos.initBD("usuarios");
		BaseDeDatos.crearTablaBD();
		
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testComprobarcontrasena() throws SQLException 
	{
		usuario = "Manoli";
		contrasena = "contrausu";
		u1 = new Usuario(usuario,contrasena);
		u1.insertarUsuario(BaseDeDatos.getStatement());
		
		String contrasenaDef = u1.consultarContrasena();
		assertEquals (contrasenaDef, contrasena);
	}
	
	@Test
	public void testActualizar() throws SQLException
	{
		usuario = "Pablito";
		contrasena = "pablito1234";
		u2 = new Usuario (usuario, contrasena);
		u2.insertarUsuario(BaseDeDatos.getStatement());
		correo = "pablo@gmail.com";
		cCorreo = "pablito12345678";
		u2.setCorreo(correo);
		u2.setcCorreo(cCorreo);
		u2.actualizar(BaseDeDatos.getStatement());
		
		String c = u2.consultarCorreo();
		String cC = u2.consultarContra(BaseDeDatos.getStatement());
		assertEquals ( c, "pablo@gmail.com");
		assertEquals ( cC, "pablito12345678");
	}

}
