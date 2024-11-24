package conexion;

import java.sql.*;

public class ConexionDB {
	private Connection conexion;
	private String url;
	private String usuario;
	private String pass;
	private String db;
	
	public ConexionDB() {
		db="polizas";
		url="jdbc:postgresql://127.0.0.1:5432/"+db;
		usuario="postgres";
		pass="postgres1004";		
	}

	public Connection getConexion() {
		try {
			conexion = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;		
	}
	
	
	public void closeConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
