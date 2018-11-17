package Principal;

import java.io.File;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class Foto implements Serializable
{
	private File f;
	private String titulo;
	private String usuario;
	private String contraseña;
	private String email;
	private Date fechaEdicion;
	
	
	public Foto(File f, String titulo)
	{
		this.f = f;
		this.titulo = titulo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
		public boolean anyadirFilaATabla( Statement st ) {
			// Adicional uno
			if (chequearYaEnTabla(st)) {  // Si está ya en la tabla
				return modificarFilaEnTabla(st);
			}
			// Inserción normal
			try {
				String sentSQL = "insert into fichero_foto values(" +
						"'" + f.getAbsolutePath() + "', " +
						"'" + titulo + "', " ;
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que añadir 1 - error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		public boolean chequearYaEnTabla( Statement st ) {
			try {
				String sentSQL = "select * from fichero_foto " +
						"where (fichero = '" + f.getAbsolutePath() + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				ResultSet rs = st.executeQuery( sentSQL );
				if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
					rs.close();
					return true;
				}
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		/** Modifica los datos de un fichero multimedia en la tabla FICHERO_MULTIMEDIA de BD, 
		 * que debe estar abierta y tener el formato y los nombres de campos apropiados:
		 * (fichero string, error boolean, titulo string, cantante string, comentarios string)
		 * Usa la sentencia UPDATE de SQL.
		 * @param st	Sentencia ya abierta de Base de Datos (con la estructura de tabla correspondiente al usuario)
		 * @return	true si la modificación es correcta, false en caso contrario
		 */
		public boolean modificarFilaEnTabla( Statement st ) {
			try {
				String sentSQL = "update fichero_foto set " +
						"titulo = '" + titulo + "', " +
						"where (fichero = '" + f.getAbsolutePath() + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				int val = st.executeUpdate( sentSQL );
				if (val!=1) return false;  // Se tiene que modificar 1, error si no
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}

		// Paso adicional 2
		
		/** Carga un fichero multimedia de la tabla FICHERO_MULTIMEDIA de BD,
		 * buscando la trayectoria completa del disco como información clave.
		 * @param st	Sentencia ya abierta de base de datos
		 */
		public void cargarDeTabla( Statement st ) {
			try {
				String sentSQL = "select * from fichero_multimedia " +
						"where (fichero = '" + this.f.getAbsolutePath() + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				ResultSet rs = st.executeQuery( sentSQL );
				if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
					this.titulo = rs.getString( "titulo" );
					rs.close();
				}
				// else No hay ninguno en la tabla
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Métodos añadidos para operaciones futuras
		
		/** Crea un fichero multimedia, cargándolo de la tabla FICHERO_MULTIMEDIA de BD,
		 * buscando la trayectoria completa del disco como información clave.
		 * @param st	Sentencia ya abierta de base de datos
		 * @param nombreFichero	Path completo absoluto del fichero
		 * @return	nuevo objeto cargado de la tabla, null si hay error
		 */
		public static Foto cargarDeTabla( Statement st, String nombreFichero ) {
			try {
				String sentSQL = "select * from fichero_multimedia " +
						"where (fichero = '" + nombreFichero + "')";
				System.out.println( sentSQL );  // (Quitar) para ver lo que se hace
				ResultSet rs = st.executeQuery( sentSQL );
				if (rs.next()) {  // Normalmente se recorre con un while, pero aquí solo hay que ver si ya existe
					Foto fm = new Foto( new File(nombreFichero), nombreFichero );
					
					fm.titulo = rs.getString( "titulo" );
				
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
		
		

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public Date getFechaEdicion() {
			return fechaEdicion;
		}

		public void setFechaEdicion(Date fechaEdicion) {
			this.fechaEdicion = fechaEdicion;
		}
		
		
		
		
	}
