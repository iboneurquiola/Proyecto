package Principal;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Principal.BaseDeDatos;



public class TestBaseDeDatos 
{
private Principal.Usuario miusuario;
	
	
	@Before
	public void setUp() throws Exception 
	{

		String usuario = "asdfghj";
		String contraseña = "aaaa";
		miusuario = new Principal.Usuario( usuario, contraseña) ;
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testEscribirBD() throws SQLException 
	{
		
		BaseDeDatos.initBD("usuarios");
		BaseDeDatos.crearTablaBD();
		ArrayList<Principal.Usuario> lista1 = Principal.Usuario.listaUsuarios();
		miusuario.insertarUsuario(BaseDeDatos.getStatement());
		ArrayList<Principal.Usuario> lista2 = Principal.Usuario.listaUsuarios();
		assertEquals( lista1.size(), lista2.size() -1);		
	}
}
