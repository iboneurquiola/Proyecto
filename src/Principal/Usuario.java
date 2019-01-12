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
	private static String contraseña;
	private static String correo;
	private static String cCorreo;

	public Usuario(String u, String c)
	{
		this.usuario = u;
		this.contraseña = c;
	}
	public Usuario()
	{
		this.usuario = null;
		this.contraseña = null;
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
		return rs.getString("contraseÃ±a");
			
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
			u.setContraseña(rs.getString(2).toString());
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
		String sentencia = "INSERT INTO usuarios (usuario, contraseÃ±a)  VALUES ("+
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



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		Usuario.usuario = usuario;
	}



	public static String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		Usuario.contraseña = contraseña;
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
