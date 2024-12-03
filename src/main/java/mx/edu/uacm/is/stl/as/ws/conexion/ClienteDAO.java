package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.SQLException;
import java.sql.Statement;

import mx.edu.uacm.is.stl.as.ws.modelo.Cliente;

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

public class ClienteDAO extends DataObject
{
    private Statement statement = null;

    public ClienteDAO() throws SQLException
    {
        super();
    }

    public void AgregarCliente(Cliente cliente) throws SQLException
    {
        statement = linkToDataBase.createStatement();

        String query = "INSERT INTO Cliente VALUES" + 
        
        "(" + 
        
            "'"+ cliente.getNombre() + "'"+ "," +
            "'"+ cliente.getPrimerApellido() + "'"+ "," +
            "'"+ cliente.getSegundoApellido() + "'"+ "," +
            "'"+ cliente.getFechaNacimientoString() + "'"+ "," +
            "'"+ cliente.getDireccion() + "'" + "," + 
            "'"+ cliente.getCurp() + "'"+
        ");";

        try
        {
            statement.executeUpdate(query);
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            statement.close();
        }
    }

    public void EliminarCliente(String curp) throws SQLException
    {
        statement = linkToDataBase.createStatement();

        String query = "DELETE FROM Cliente WHERE  curp = '" + curp + "');"; 

        try
        {
            statement.executeUpdate(query);
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            statement.close();
        }
    }

    public void ActualizarCliente(String curp) throws SQLException
    {
        statement = linkToDataBase.createStatement();

        String query = "DELETE FROM Cliente WHERE  curp = '" + curp + "');"; 

        try
        {
            statement.executeUpdate(query);
        } 
        catch (SQLException e) 
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            statement.close();
        }
    }
}