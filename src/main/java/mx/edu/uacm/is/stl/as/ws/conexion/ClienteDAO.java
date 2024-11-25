package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.*;

import mx.edu.uacm.is.stl.as.ws.modelo.Cliente;
import mx.edu.uacm.is.stl.as.ws.modelo.ExceptionPoliza;


/**
*<h2>Clase ClienteDAO</h2>
*Clase que gestiona la creación, eliminación, actualización y busqueda de los clientes, 
*en la tabla "cliente" de la base de datos "polizas".<br><br>
*@Project Polizas de Seguro
*@Date 21/11/2024
*@Author José Carlos Ascencio Navarro
*@DesarrolladoEn UACM San Lorenzo Tezonco
*@version 1.1.1
**/


public class ClienteDAO {
	private ConexionDB conexionDB;
	private Connection conect;
	
	
	
	/**
	 * <p><b>ClienteDAO() : Constructor que crea un objeto ConexionDB para conectarse a una base de Datos</b></p>
	 */
	public ClienteDAO() {
		conexionDB=new ConexionDB();
	}
	
	
	/**
	 * <p><b>addCliente() : Metodo que crea un registro nuevo en la Base de Datos a partir de un Cliente</b></p>
	 * @param cliente : Recibe un objeto Cliente el cual sera guardado en la Base de Datos
	 * @return : Retorna False si fallo el registro del cliente en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 */
	public boolean addCliente(Cliente cliente) throws ExceptionPoliza {
		boolean exito=false;
		
		if(esObjetoVacio(cliente)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conect = conexionDB.getConexion();
			String statememtSQL = "INSERT INTO cliente VALUES(?,?,?,?,?,?)";

			PreparedStatement statememt;
			try {
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, cliente.getNombre());
				statememt.setString(2, cliente.getPrimerApellido());
				statememt.setString(3, cliente.getSegundoApellido());
				statememt.setString(4, cliente.getDireccion());
				statememt.setString(5, cliente.getCurp());
				statememt.setDate(6, cliente.getFechaNacimientoDate());
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
	
	
	/**
	 * <p><b>deleteCliente() : Metodo que elimina un registro existente de la Base de Datos a partir de un Cliente</b></p>
	 * @param cliente : Recibe un objeto Cliente el cual sera eliminado de la Base de Datos
	 * @return : Retorna False si fallo la eliminacion del registro en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 */
	public boolean deleteCliente(Cliente cliente) throws ExceptionPoliza {
		boolean exito =false;
		
		if(esObjetoVacio(cliente)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {		
			conect = conexionDB.getConexion();
			String statememtSQL = "DELETE FROM cliente WHERE curp =?";
	
			PreparedStatement statememt;
			try {
				statememt = conect.prepareStatement(statememtSQL);
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
	
	
	/**
	 * <p><b>updateCliente() : Metodo que actualiza un registro existente de la Base de Datos a partir de un Cliente.
	 * en caso de no tener exito en la actualizacion el metodo hace rollback.</b></p>
	 * @param cliente : Recibe un objeto Cliente el cual sera actualizado en la Base de Datos
	 * @return boolean : Retorna False si fallo la actualizacion del registro en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 *  o se haya pasado un objeto vacio.
	 * @throws SQLException : Lanza una excepcion SQL en caso de error.
	 */
	public boolean updateCliente(Cliente cliente) throws ExceptionPoliza, SQLException {
		boolean exito=false;
		
		if(esObjetoVacio(cliente)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conect = conexionDB.getConexion();
			String statememtSQL="";
			
			statememtSQL = "UPDATE cliente SET nombres=?, primer_apellido=?, segundo_apellido=?, direccion=?, fecha_nacimiento=? WHERE curp=?";	
			PreparedStatement statememt;
			try {
				conect.setAutoCommit(false);
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, cliente.getNombre());
				statememt.setString(2, cliente.getPrimerApellido());
				statememt.setString(3, cliente.getSegundoApellido());
				statememt.setString(4, cliente.getDireccion());
				statememt.setDate(5, cliente.getFechaNacimientoDate());
				statememt.setString(6, cliente.getCurp());
				statememt.executeUpdate();
				conect.commit();
				exito=true;
			} catch (SQLException e) {
				conect.rollback();
				e.printStackTrace();
			}finally {
				conexionDB.closeConexion();
			}			
		}
		return exito;
	}
	
	
	/**
	 * <p><b>getCliente() : Metodo que busca un registro existente de la Base de Datos a partir de un id, en este caso
	 * el curp del cliente.</b></p>
	 * @param id : Recibe una cadena de texto (curp) para buscar ese registro en la Base de Datos.
	 * @return cliente : Retorna un objeto Cliente que fue creado si se encontro en la Base de Datos.
	 */
	public Cliente getCliente(String id) {
		Cliente cliente=null;
		
		conect = conexionDB.getConexion();
		String statememtSQL="";
		ResultSet resultado;
		
		statememtSQL = "SELECT * FROM cliente WHERE curp=?";	
		PreparedStatement statememt;
		try {
			statememt = conect.prepareStatement(statememtSQL);
			statememt.setString(1, id);
			resultado=statememt.executeQuery();
			while(resultado.next()) {
				cliente=new Cliente();
				cliente.setNombre(resultado.getString("nombres"));
				cliente.setPrimerApellido(resultado.getString("primer_apellido"));
				cliente.setSegundoApellido(resultado.getString("segundo_apellido"));
				cliente.setDireccion(resultado.getString("direccion"));
				cliente.setCurp(resultado.getString("curp"));
				cliente.setFechaNacimientoDate(resultado.getDate("fecha_nacimiento"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conexionDB.closeConexion();
		}			
		return cliente;
	}
	
	
	
	/**
	 * <p><b>esObjetoVacio() : Metodo que verifica si un objeto es vacio.</b></p>
	 * @param obj : Recibe Objeto.
	 * @return boolean : Retorna true si el objeto es Vacio y False si el objeto no esta vacio.
	 */
	private boolean esObjetoVacio(Object obj) {
		boolean esVacio=false;
		if(obj.equals(null)) {
			esVacio=true;
		}
		return esVacio;
	}
	
}
