package Principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Usuario 
{
	private static Connection con = null;
	private static ResultSet rs;
	private static String usuario;
	private static String contraseña;
	private static String correo;
	private static String cCorreo;

	public Usuario(String u, String c)
	{
		this.usuario = u;
		this.contraseña = c;
	}


	
	public String consultarCorreo( Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentSQL = "SELECT * FROM usuarios " +
				"WHERE (usuario = '" + usuario + "')";
		rs = con.createStatement().executeQuery(sentSQL);
		return rs.getString("correo");
			
	}
	public String comprobarContraseña( Statement stm) throws SQLException
	{
		con = BaseDeDatos.getConnection();
		String sentSQL = "SELECT * FROM usuarios " +
				"WHERE (usuario = '" + usuario + "')";
		rs = con.createStatement().executeQuery(sentSQL);
		return rs.getString("contraseña");
			
	}
	public boolean comprobarContra(Statement stm) throws SQLException 
	{
		rs = stm.executeQuery("SELECT * FROM usuarios");
		while(rs.next())
		{
			if (usuario.toUpperCase().equals(rs.getString(1).toUpperCase())  )
			{
				if (comprobarContraseña(BaseDeDatos.getStatement()).equals(contraseña))
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
				"'" + contraseña + "')";
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



	public static String getUsuario() {
		return usuario;
	}



	public static void setUsuario(String usuario) {
		Usuario.usuario = usuario;
	}



	public static String getContraseña() {
		return contraseña;
	}



	public static void setContraseña(String contraseña) {
		Usuario.contraseña = contraseña;
	}



	public static String getCorreo() {
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
