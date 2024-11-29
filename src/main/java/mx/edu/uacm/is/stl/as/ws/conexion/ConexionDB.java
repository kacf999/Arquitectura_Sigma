package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.*;

public class ConexionDB {
	private Connection conexion;
	private String url;
	private String usuario;
	private String pass;
	private String db;
	
	public ConexionDB() {
		db="seguros_parq_origen";
		url="jdbc:postgresql://127.0.0.1:5432/"+db;
		usuario="postgres";
		pass="uacm123";		
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
