package mx.edu.uacm.is.stl.as.ws.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseLink 
{
      private static Properties properties = new Properties();
      public static Connection theLinkToConnection;

      public static Connection GetConnection()
      {
            properties.setProperty("user", "root");
            properties.setProperty("password", "123456");
            properties.setProperty("url", "jdbc:mysql://localhost:3306/seguros_parq_origen");

            try
            {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  theLinkToConnection = DriverManager.getConnection
                  (
                        properties.getProperty("url"),
                        properties.getProperty("user"),
                        properties.getProperty("password")
                  );
            } 
            catch (Exception e)
            {     
                  System.out.println(e.getMessage());
            }

            return theLinkToConnection;
      }
}
