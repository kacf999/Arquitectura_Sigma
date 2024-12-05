package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import mx.edu.uacm.is.stl.as.ws.modelo.Beneficiario;
import mx.edu.uacm.is.stl.as.ws.modelo.ExceptionPoliza;

import java.sql.Date;


/**
*<h2>Clase BeneficiarioDAO</h2>
*Clase que gestiona la creación, eliminación, actualización y busqueda de los Beneficiarios, 
*en la tabla "beneficiario_poliza" de la base de datos "polizas".<br><br>
*@Project Polizas de Seguro
*@Date 24/11/2024
*@Author José Carlos Ascencio Navarro
*@DesarrolladoEn UACM San Lorenzo Tezonco
*@version 1.0.0
**/


public class BeneficiarioDAO {
	private ConexionDB conexionDB;
	private Connection conect;
	private static String statementID="nombres =? AND primer_apellido=? AND segundo_apellido=? AND fecha_nacimiento=? AND clave_poliza=?";
	
	/**
	 * <p><b>BeneficiarioDAO() : Constructor que crea un objeto ConexionDB para conectarse a una base de Datos</b></p>
	 */
	public BeneficiarioDAO() {
		conexionDB=new ConexionDB();
	}
	
	
	/**
	 * <p><b>addBeneficiario() : Metodo que crea un registro nuevo en la tabla "beneficiario_poliza" de la
	 *  Base de Datos "polizas" a partir de un objeto Beneficiario</b></p>
	 * @param beneficiario : Recibe un objeto Beneficiario el cual sera guardado en la Base de Datos "poliza" en la tabla beneficiario_poliza
	 * @return : Retorna False si fallo el registro del Beneficiario en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 */
	public boolean addBeneficiario(Beneficiario beneficiario) throws ExceptionPoliza {
		boolean exito=false;
		
		if(isEmpty(beneficiario)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conect = conexionDB.getConexion();
			String statememtSQL = "INSERT INTO beneficiario_poliza VALUES(?,?,?,?,?,?)";

			PreparedStatement statememt;
			try {
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, beneficiario.getNombre());
				statememt.setString(2, beneficiario.getPrimerApellido());
				statememt.setString(3, beneficiario.getSegundoApellido());
				statememt.setDate(4, beneficiario.getFechaNacimientoDate());
				statememt.setString(5, beneficiario.getClave_poliza());
				statememt.setInt(6, beneficiario.getPorcentaje());
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
	 * <p><b>deleteBeneficiario() : Metodo que elimina un registro existente de la Base de Datos
	 *  a partir de un objeto Beneficiario</b></p>
	 * @param beneficiario : Recibe un objeto Beneficiario el cual sera eliminado de la Base de Datos
	 * @return : Retorna False si fallo la eliminacion del registro en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 */
	public boolean deleteBeneficiario(Beneficiario beneficiario) throws ExceptionPoliza {
		boolean exito =false;
		
		if(isEmpty(beneficiario)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {		
			conect = conexionDB.getConexion();
			String statememtSQL = "DELETE FROM beneficiario_poliza WHERE "+ statementID+" porcentaje=?";
	
			PreparedStatement statememt;
			try {
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, beneficiario.getNombre());
				statememt.setString(2, beneficiario.getPrimerApellido());
				statememt.setString(3, beneficiario.getSegundoApellido());
				statememt.setDate(4, beneficiario.getFechaNacimientoDate());
//				statememt.setString(5, beneficiario.ge());
				statememt.setInt(6, beneficiario.getPorcentaje());
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
	 * <p><b>updateBeneficiario() : Metodo que actualiza un registro existente de la Base de Datos a partir de un Beneficiario.
	 * En caso de no tener exito en la actualizacion el metodo hace rollback.</b></p>
	 * @param beneficiario : Recibe un objeto Beneficiario el cual sera actualizado en la Base de Datos
	 * @return boolean : Retorna False si fallo la actualizacion del registro en la Base de Datos y True si tuvo exito
	 * @throws ExceptionPoliza : Lanza una excepcion en caso de que no se logre conectar con la Base de Datos
	 *  o se haya pasado un objeto vacio.
	 * @throws SQLException : Lanza una excepcion SQL en caso de error.
	 */
	public boolean updateBeneficiario(Beneficiario beneficiario) throws ExceptionPoliza, SQLException {
		boolean exito=false;
		
		if(isEmpty(beneficiario)) {
			conexionDB.closeConexion();
			throw new ExceptionPoliza(204);
		}else {
			conect = conexionDB.getConexion();
			String statememtSQL="";
			
			statememtSQL = "UPDATE beneficiario_poliza SET nombres=?, primer_apellido=?, segundo_apellido=?,  fecha_nacimiento=?, clave_poliza=?, porcentaje=?  WHERE "+statementID;	
			PreparedStatement statememt;
			try {
				conect.setAutoCommit(false);
				statememt = conect.prepareStatement(statememtSQL);
				statememt.setString(1, beneficiario.getNombre());
				statememt.setString(2, beneficiario.getPrimerApellido());
				statememt.setString(3, beneficiario.getSegundoApellido());
				statememt.setDate(4, beneficiario.getFechaNacimientoDate());
//				statememt.setString(5, beneficiario.get());
				statememt.setInt(6, beneficiario.getPorcentaje());
				statememt.setString(7, beneficiario.getNombre());
				statememt.setString(8, beneficiario.getPrimerApellido());
				statememt.setString(9, beneficiario.getSegundoApellido());
				statememt.setDate(10, beneficiario.getFechaNacimientoDate());
//				statememt.setString(11, beneficiario.get());
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
	 * <p><b>getBeneficiario() : Metodo que busca un registro existente de la Base de Datos a partir de una clave compuesta.</b></p>
	 * @param nombre : Recibe una cadena de texto (nombre(s) del Beneficiario) que forma parte de la clave compuesta en la Base de Datos.
	 * @param primerApellido : Recibe una cadena de texto (Primer Apellido) que forma parte de la clave compuesta en la Base de Datos
	 * @param segundoApellido : Recibe una cadena de texto (Segundo Apellido) que forma parte de la clave compuesta en la Base de Datos
	 * @param fechaNacimiento : Recibe una fecha de tipo Date (Fecha de Nacimiento) que forma parte de la clave compuesta en la Base de Datos
	 * @param clavePoliza : Recibe una cadena de texto de Tipo UUID (Clave de Poliza) que forma parte de la clave compuesta en la Base de Datos
	 * @return beneficiario : Retorna un objeto Beneficiario que fue creado si se encontro en la Base de Datos.
	 */
//	public Beneficiario getBeneficiario(String nombre, String primerApellido, String segundoApellido, Date fechaNacimiento, UUID clavePoliza) {
//		Beneficiario beneficiario=null;
//		
//		conect = conexionDB.getConexion();
//		String statememtSQL="";
//		ResultSet resultado;
//		
//		statememtSQL = "SELECT * FROM beneficiario_poliza WHERE "+statementID;	
//		PreparedStatement statememt;
//		try {
//			statememt = conect.prepareStatement(statememtSQL);
//			statememt.setString(1, nombre);
//			statememt.setString(2, primerApellido);
//			statememt.setString(3, segundoApellido);
//			statememt.setDate(4, fechaNacimiento);
//			statememt.setString(5, clavePoliza.toString());
//			
//			
//			resultado=statememt.executeQuery();
//			while(resultado.next()) {
//				beneficiario=new Beneficiario();
//				beneficiario.setNombre(resultado.getString("nombres"));
//				beneficiario.setPrimerApellido(resultado.getString("primer_apellido"));
//				beneficiario.setSegundoApellido(resultado.getString("segundo_apellido"));
//				beneficiario.setFechaNacimientoDate(resultado.getDate("fecha_nacimiento"));
////				beneficiario.set(resultado.getString("curp"));
//				beneficiario.setPorcentaje(resultado.getInt("porcentaje"));	
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			conexionDB.closeConexion();
//		}			
//		return beneficiario;
//	}
//	
	
	
	/**
	 * <p><b>esObjetoVacio() : Metodo que verifica si un objeto es vacio.</b></p>
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
