package conexion;

import java.sql.*;

import modelo.Cliente;
import modelo.ExceptionPoliza;


/**
*<h2>Clase ClienteDAO</h2>
*Clase que gestiona la creación, eliminación, actualización y busqueda de los clientes, 
*en la tabla "cliente" de la base de datos "polizas".<br><br>
*@Project Polizas de Seguro
*@Date 21/11/2024
*@Author Jos� Carlos Ascencio Navarro
*@DesarrolladoEn UACM San Lorenzo Tezonco
*@version 1.0.0
**/


public class ClienteDAO {
	private ConexionBD conexionDB;
	private Connection conexion;
	
	public ClienteDAO() {
		conexionDB=new ConexionBD();
	}
	
	public boolean newCliente(Cliente cliente) throws ExceptionPoliza {
		boolean exito=false;
		
		if(esObjetoVacio(cliente)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conexion = conexionDB.getConexion();
			String statememtSQL = "INSERT INTO cliente VALUES(?,?,?,?,?,?)";

			PreparedStatement statememt;
			try {
				statememt = conexion.prepareStatement(statememtSQL);
				statememt.setString(1, cliente.getNombre());
				statememt.setString(2, cliente.getPrimerApellido());
				statememt.setString(3, cliente.getSegundoApellido());
				statememt.setString(4, cliente.getDireccion());
				statememt.setString(5, cliente.getCurp());
				statememt.setDate(6, cliente.getFechaNacimiento());
				statememt.executeUpdate();
				exito=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conexionDB.closeConexion();
			}
		}
		return exito;
	}
	
	public boolean deleteCliente(Cliente cliente) throws ExceptionPoliza {
		boolean exito =false;
		
		if(esObjetoVacio(cliente)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {		
			conexion = conexionDB.getConexion();
			String statememtSQL = "DELETE FROM cliente WHERE curp =?";
	
			PreparedStatement statememt;
			try {
				statememt = conexion.prepareStatement(statememtSQL);
				statememt.setString(1, cliente.getCurp());
				statememt.executeUpdate();
				exito=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conexionDB.closeConexion();
			}
		}
		return exito;
	}
	
	public boolean updateCliente(Cliente cliente) {
		boolean exito=false;
		
		
		
		return exito;
	}
	
	public Cliente getCliente(String id) {
		Cliente cliente=new Cliente();
		
		
		
		return cliente;
	}
	
	private boolean esObjetoVacio(Object obj) {
		boolean esVacio=false;
		if(obj.equals(null)) {
			esVacio=true;
		}
		return esVacio;
	}
	
}
