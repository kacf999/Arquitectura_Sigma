package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataObject 
{
      protected Connection linkToDataBase;
      protected ResultSet resultSet;

      public DataObject() throws SQLException
      {
            linkToDataBase = DataBaseLink.GetConnection();
            
            System.out.println
            (
                  linkToDataBase.isValid(1000) ? "\n\tEMPLOYEE DAO" 
                  + " CONEXION EXITOSA": " FALLO LA CONEXION"
            );
      }
}