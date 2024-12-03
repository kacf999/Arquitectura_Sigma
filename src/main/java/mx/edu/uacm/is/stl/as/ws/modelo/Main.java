package mx.edu.uacm.is.stl.as.ws.modelo;

import java.sql.SQLException;
import java.text.ParseException;

import mx.edu.uacm.is.stl.as.ws.conexion.ClienteDAO;

public class Main 
{
	public static void main(String[] args) throws SQLException, ParseException 
	{
		ClienteDAO clienteDAO=new ClienteDAO();
		
		Cliente cliente = new Cliente(
		
			"Edgar", 
			"Flores", 
			"Hernandez", 
			"09/06/1991", 
			"""
				"cedro manzana 3 lote 10 2da 
				Ampliacion Santiago Acahualtepec, 
				Iztapalapa CDMX CP. 09609"
			""",
			"HEFE910609HDFRLD00"
		);

		clienteDAO.AgregarCliente(cliente);
	}
}
