package Principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Usuario 
{
	private static Connection con = null;
	private static ResultSet rs;
	private static String usuario;
	private static String contrase�a;
	private static String correo;
	private static String cCorreo;

	public Usuario(String u, String c)
	{
		this.usuario = u;
		this.contrase�a = c;
	}
	public Usuario()
	{
		this.usuario = null;
		this.contrase�a = null;
	}

	
	public String consultarCorreo( Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentSQL = "SELECT * FROM usuarios " +
				"WHERE (usuario = '" + usuario + "')";
		rs = con.createStatement().executeQuery(sentSQL);
		return rs.getString("correo");
			
	}
	public String comprobarContrase�a( Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentSQL = "SELECT * FROM usuarios " +
				"WHERE (usuario = '" + usuario + "')";
		rs = con.createStatement().executeQuery(sentSQL);
		return rs.getString("contraseña");
			
	}
	public static ArrayList <Usuario> listaUsuarios( ) throws SQLException
	{
		ArrayList<Usuario> usuarios = new ArrayList <Usuario>();
		con = BaseDeDatos.getConnection();
		String sentSQL = "SELECT * FROM usuarios ";
		rs = con.createStatement().executeQuery(sentSQL);
		
		while(rs.next())
		{
			Usuario u = new Usuario();
			u.setUsuario(rs.getString(1).toString());
			u.setContrase�a(rs.getString(2).toString());
			usuarios.add(u);
		}
		return usuarios;
			
	}
	public boolean comprobarContra(Statement stm) throws SQLException 
	{
		rs = stm.executeQuery("SELECT * FROM usuarios");
		while(rs.next())
		{
			if (usuario.toUpperCase().equals(rs.getString(1).toUpperCase())  )
			{
				if (comprobarContrase�a(BaseDeDatos.getStatement()).equals(contrase�a))
				{
					return true;
				}
			}	
		}
	
		return false;
		
	}
	public String consultarContra(Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentSQL = "SELECT * FROM usuarios " +
				"WHERE (usuario = '" + usuario + "')";
		rs = con.createStatement().executeQuery(sentSQL);
		
		return rs.getString("cCorreo");
	}
	public void actualizar(Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentencia = "UPDATE usuarios SET " +
				"correo ='"+ correo + "'," +
				"cCorreo = '" + cCorreo + "'" +
				"WHERE (usuario ='" + usuario+"')";
		con.createStatement().executeUpdate(sentencia);
		 
	}
	
	public void insertarUsuario(Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentencia = "INSERT INTO usuarios (usuario, contraseña)  VALUES ("+
				"'" + usuario + "',"+
				"'" + contrase�a + "')";
		con.createStatement().executeUpdate(sentencia);
	}
	
	
	public boolean comprobar(Statement stm) throws SQLException
	{
		rs = stm.executeQuery("SELECT * FROM usuarios");
		while(rs.next())
		{
			if (usuario.toUpperCase().equals(rs.getString(1).toUpperCase())  )
			{
				return true;
			}	
		}
		return false;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		Usuario.usuario = usuario;
	}



	public static String getContrase�a() {
		return contrase�a;
	}



	public void setContrase�a(String contrase�a) {
		Usuario.contrase�a = contrase�a;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		Usuario.correo = correo;
	}



	public static String getcCorreo() {
		return cCorreo;
	}



	public void setcCorreo(String cCorreo) {
		Usuario.cCorreo = cCorreo;
	}
	
	}
