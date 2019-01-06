package Principal;

import java.io.File;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;




public class Usuario implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String contrasena;
	private String email;
	private String contrasenaEmail;

	public Usuario(String user, String password) 
	{
		this.usuario = user;
		this.contrasena = password;
	}

	public Usuario(File file) {
		// TODO Auto-generated constructor stub
	}

	public boolean anyadirFilaATabla( Statement st ) {
			// Adicional uno
			if (chequearYaEnTabla(st)) 
			{  
				return modificarFilaEnTabla(st);
			}
		
			try {
				String sentSQL = "insert into fichero_foto values(" +
						"'" + usuario + "', " +
						"'" + contrasena + "', " ;
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que a�adir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		public String conseguirEmail(String usuario) throws SQLException
		{
			String sentSQL = "select email from fichero_foto " + "where (usuario = '" + usuario + "')";
			return sentSQL;
			
		}
		public String conseguirContraseña(String usuario) throws SQLException
		{
			return usuario;
//			String sentSQL = "select contrasenaEmail from fichero_foto " + "where (usuario = '" + usuario + "')";
//			ResultSet rs = st.executeQuery( sentSQL );
//			if (rs.next()) {  // Normalmente se recorre con un while, pero aqu� solo hay que ver si ya existe
//				FicheroMultimedia fm = new FicheroMultimedia( new File(nombreFichero) );
//				fm.erroneo = rs.getBoolean( "error" );
//				fm.titulo = rs.getString( "titulo" );
//			return sentSQL;
			
		}
		public boolean chequearYaEnTabla( Statement st ) {
			try {
				String sentSQL = "select email, contrasenaEmail from fichero_foto " +
						"where (usuario = '" + email + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				ResultSet rs = st.executeQuery( sentSQL );
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqu� solo hay que ver si ya existe
					rs.close();
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		
		public boolean modificarFilaEnTabla( Statement st ) {
			try
			{
				String sentSQL = "update fichero_foto set " +
						"titulo = '" + "')";
				System.out.println( sentSQL );  
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que modificar 1, error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

	
		public String getContrasenaEmail() {
			return contrasenaEmail;
		}

		public void setContrasenaEmail(String contrasenaEmail) {
			this.contrasenaEmail = contrasenaEmail;
		}

		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public static Usuario cargarDeTabla( Statement st, String usuario ) {
			try {
				String sentSQL = "select * from fichero_foto " +
						"where (usuario = '" + usuario + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				ResultSet rs = st.executeQuery( sentSQL );
				if (rs.next()) {  // Normalmente se recorre con un while, pero aqu� solo hay que ver si ya existe
					Usuario fm = new Usuario( new File(usuario) );
					fm.contrasena = rs.getString( "contraseña" );
					fm.usuario = rs.getString( "usuario" );
				
					rs.close();
					return fm;
				}
				// else No hay ninguno en la tabla
				return null;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;  // Error
			}
		}
		
		
	}
