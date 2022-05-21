package function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	public static Connection connect() throws Exception 
	{
	    Connection connection = null;
	    
	    try
	    {
	        String url = "jdbc:sqlite:C:\\Users\\Chris\\git\\Tankstelle\\TankstellePreisabfrage\\SqliteDB\\location.db";
	        connection = DriverManager.getConnection(url);
	        
	        System.out.println("Connection to SQLite has been established.");
	    }
	    catch(Exception exception)
	    {
	        if (connection != null) 
            {
            	connection.close();
            }	
	    }
		return connection;
	}
}
