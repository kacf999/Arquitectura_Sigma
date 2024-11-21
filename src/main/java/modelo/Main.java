package modelo;

import java.sql.Date;
import java.sql.SQLException;

import conexion.ClienteDAO;

public class Main {

	public static void main(String[] args) throws SQLException, ExceptionPoliza {
		ClienteDAO clienteDAO=new ClienteDAO();
		@SuppressWarnings("deprecation")
		Date fechaNacimiento=new Date(1999,12,28);
		Cliente c1=new Cliente("Armando", "Reyes", "Saavedra", fechaNacimiento,"Siempre Viva", "AENCE654848E");
		
		//clienteDAO.newCliente(c1);
		
		if(clienteDAO.deleteCliente(c1)) {
			System.out.println("Se borro el cliente de la base de datos");
		}else {
			System.out.println("No se pudo borrar el cliente: "+c1.getCurp());
		}
		
	}

}
