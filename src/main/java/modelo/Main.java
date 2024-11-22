package modelo;

import java.sql.SQLException;
import java.text.ParseException;

import conexion.ClienteDAO;

public class Main {

	public static void main(String[] args) throws SQLException, ExceptionPoliza, ParseException {
		ClienteDAO clienteDAO=new ClienteDAO();
		Cliente c1=new Cliente("Armando", "Hoyos", "Eloigameno", "1999-12-28","Siempre Viva", "AENCE654848E");
		Cliente c2=new Cliente("Pedro", "Picapiedra", "Troncoso", "2005-05-31","Caverna 55", "PEPT");
		Cliente c3=new Cliente("Lola", "Trailera", "Saavedra", "2000-01-15","Siempre Viva", "LOLTE654848E");
		
//		clienteDAO.addCliente(c1);
//		clienteDAO.addCliente(c2);
//		clienteDAO.addCliente(c3);
		
		 if(clienteDAO.updateCliente(c1)) {
			 System.out.println("Se actualizo correctamente");
		 }else {
			 System.out.println("No se pudo actualizar");
		 }
		
		
//		  if(clienteDAO.deleteCliente(c1)) {
//		  System.out.println("Se borro el cliente de la base de datos"); }else {
//		  System.out.println("No se pudo borrar el cliente: "+c1.getCurp()); }
		 
	}

}
