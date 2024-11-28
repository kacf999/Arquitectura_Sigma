package modelo;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import conexion.ClienteDAO;

public class Main {

	public static void main(String[] args) throws SQLException, ExceptionPoliza, ParseException {
		ClienteDAO clienteDAO=new ClienteDAO();
//		Cliente c1=new Cliente("Armando", "Hoyos", "Eloigameno", "2005/12/28","Siempre Viva", "AENCE654848E");
//		Cliente c2=new Cliente("Pedro", "Picapiedra", "Troncoso", "0500/05/31","Caverna 55", "PEPT");
//		Cliente c4=new Cliente("Vilma", "Picapiedra", "Troncoso", "0500/10/28","Caverna 55", "AENCE6548E");
//		Cliente c3=new Cliente("Lola", "Trailera", "Saavedra", "2000/01/15","Siempre Viva", "LOLTE654848E");
//		
//		if(clienteDAO.updateCliente(c1)) {
//			System.out.println("Exito");
//		}else {
//			System.out.println("NO Exito");
//		}
//
//		if(clienteDAO.updateCliente(c2)) {
//			System.out.println("Exito");
//		}else {
//			System.out.println("NO Exito");
//		}
//		
//		if(clienteDAO.updateCliente(c4)) {
//			System.out.println("Exito");
//		}else {
//			System.out.println("NO Exito");
//		}
			
//		c1.setFechaNacimientoString("1998/09/10");
		
		
//		System.out.println(c1.getCurp());
//		System.out.println(c1.getDireccion());
//		System.out.println(c1.getNombre());
//		System.out.println(c1.getPrimerApellido());
//		System.out.println(c1.getSegundoApellido());
//		System.out.println(c1.getFechaNacimientoDate());

		
		
		Cliente cB=clienteDAO.getCliente("AENCE6548E");
		
		System.out.println(cB.getCurp());
		System.out.println(cB.getDireccion());
		System.out.println(cB.getNombre());
		System.out.println(cB.getPrimerApellido());
		System.out.println(cB.getSegundoApellido());
		System.out.println(cB.getFechaNacimientoDate());

		
		

//		clienteDAO.addCliente(c1);
//		clienteDAO.addCliente(c2);
//		clienteDAO.addCliente(c3);
		
//		 if(clienteDAO.updateCliente(c1)) {
//			 System.out.println("Se actualizo correctamente");
//		 }else {
//			 System.out.println("No se pudo actualizar");
//		 }
//		
		
//		  if(clienteDAO.deleteCliente(c1)) {
//		  System.out.println("Se borro el cliente de la base de datos"); }else {
//		  System.out.println("No se pudo borrar el cliente: "+c1.getCurp()); }
		 
	}

}
