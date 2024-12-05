package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.edu.uacm.is.stl.as.ws.modelo.ExceptionPoliza;
import mx.edu.uacm.is.stl.as.ws.modelo.Poliza;


/**
*<h2>Clase PolizaDAO</h2>
*Clase que gestiona la creación, eliminación, actualización y busqueda de las Polizas, 
*en la tabla "poliza" de la base de datos "polizas".<br><br>
*@Project Polizas de Seguro
*@Date 26/11/2024
*@Author José Carlos Ascencio Navarro
*@DesarrolladoEn UACM San Lorenzo Tezonco
*@version 1.0.0
**/



public class PolizaDAO {
	private ConexionDB conexionDB;
	private Connection conect;
		
	
	/**
	 * <p><b>PolizaDAO() : Constructor que crea un objeto ConexionDB para conectarse a una base de Datos</b></p>
	 */
	public PolizaDAO() {
		conexionDB=new ConexionDB();
	}
	
	
	/**
	 * <p><b>addPoliza() : Metodo que crea un registro nuevo en la Base de Datos "polizas" a partir de un objeto Poliza</b></p>
	 * @param poliza : Recibe un objeto Poliza el cual sera guardado en la Base de Datos en la tabla poliza
	 * @return : Retorna False si fallo el registro de la Poliza en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 */
	public boolean addPoliza(Poliza poliza) throws ExceptionPoliza {
		boolean exito=false;
		
		if(isEmpty(poliza)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conect = conexionDB.getConexion();
			String statememtSQL = "INSERT INTO poliza VALUES(?,?,?,?,?)";

			PreparedStatement statememt;
			try {
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, poliza.getClave().toString());
				statememt.setInt(2, poliza.getTipo());
				statememt.setDouble(3, poliza.getMonto());    
				statememt.setString(4, poliza.getDescripcion());
				statememt.setString(5, poliza.get);
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
	 * <p><b>deletePoliza() : Metodo que elimina un registro existente en la tabla "poliza" de la Base de Datos "polizas"
	 *  a partir de un objeto Poliza</b></p>
	 * @param poliza : Recibe un objeto Poliza, la cual sera eliminada de la Base de Datos
	 * @return : Retorna False si fallo la eliminacion del registro en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 */
	public boolean deletePoliza(Poliza poliza) throws ExceptionPoliza {
		boolean exito =false;
		
		if(isEmpty(poliza)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {		
			conect = conexionDB.getConexion();
			String statememtSQL = "DELETE FROM poliza WHERE clave =?";
	
			PreparedStatement statememt;
			try {
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, poliza.getClave().toString());
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
	 * <p><b>updatePoliza() : Metodo que actualiza un registro existente en la tabla "poliza" de la 
	 * Base de Datos "polizas" a partir de un objeto Poliza.</b></p>
	 * <p><b>aEn caso de no tener exito en la actualizacion el metodo hace rollback.</b></p>
	 * @param poliza : Recibe un objeto Poliza el cual sera actualizado en la Base de Datos.
	 * @return boolean : Retorna False si fallo la actualizacion del registro en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 *  o se haya pasado un objeto vacio.
	 * @throws SQLException : Lanza una excepcion SQL en caso de error.
	 */
	public boolean updatePoliza(Poliza poliza) throws ExceptionPoliza, SQLException {
		boolean exito=false;
		
		if(isEmpty(poliza)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conect = conexionDB.getConexion();
			String statememtSQL="";
			
			statememtSQL = "UPDATE poliza SET tipo=?, monto=?, descripcion=?, curp_cliente=? WHERE clave=?";	
			PreparedStatement statememt;
			try {
				conect.setAutoCommit(false);
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setInt(1, poliza.getTipo());
				statememt.setFloat(2, poliza.getMonto());
				statememt.setString(3, poliza.getDescripcion());
//				statememt.setDate(4, poliza.get());
				statememt.setString(5, poliza.getClave().toString());
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
	 * <p><b>getPoliza() : Metodo que busca un registro existente de la tabla "poliza" de la 
	 * Base de Datos "polizas" a partir de un id, en este caso la clave de la Poliza.</b></p>
	 * @param id : Recibe una cadena de texto (clave de la poliza) para buscar ese registro en la Base de Datos.
	 * @return Poliza : Retorna un objeto Poliza que se crea si se encontro el registro en la Base de Datos.
	 */
	public Poliza getPoliza(String id) {
		Poliza poliza=null;
		
		conect = conexionDB.getConexion();
		String statememtSQL="";
		ResultSet resultado;
		
		statememtSQL = "SELECT * FROM poliza WHERE clave=?";	
		PreparedStatement statememt;
		try {
			statememt = conect.prepareStatement(statememtSQL);
			statememt.setString(1, id);
			resultado=statememt.executeQuery();
			while(resultado.next()) {
				poliza=new Poliza();
//				poliza.setClave(resultado.getString("clave"));
				poliza.setTipo(resultado.getInt("tipo"));
				poliza.setMonto(resultado.getFloat("monto"));
				poliza.setDescripcion(resultado.getString("descripcion"));
//				poliza.setCurp(resultado.getString("curp"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conexionDB.closeConexion();
		}			
		return poliza;
	}
	
	
	
	/**
	 * <p><b>isEmpty() : Metodo que verifica si un objeto es vacio.</b></p>
	 * @param obj : Recibe Objeto.
	 * @return boolean : Retorna true si el objeto es Vacio y False si el objeto no esta vacio.
	 */
	private boolean isEmpty(Object obj) {
		boolean empty=false;
		if(obj.equals(null)) {
			empty=true;
		}
		return empty;
	}
	
}
