package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class BaseDeDatos {

	private static Connection connection ;
	private static Statement statement ;

	
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    connection = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
			statement = connection.createStatement();
			statement.setQueryTimeout(30); 
		    return connection;
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog( null, "Error de conexion!! No se ha podido conectar con " + nombreBD , "ERROR", JOptionPane.ERROR_MESSAGE );
			
			return null;
		}
	}

	public static void close() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	public static Statement getStatement() {
		return statement;
	}

	
	public static void crearTablaBD() throws SQLException {
		PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS usuarios(usuario VARCHAR(20) NOT NULL PRIMARY KEY,contrasena varchar(225) ,correo varchar(225),cCorreo varchar(225))");
		ps.executeUpdate();
	
	}

}
