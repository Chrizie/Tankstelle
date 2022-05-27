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
	        String url = "jdbc:sqlite:SqliteDB\\location.db";
	        connection = DriverManager.getConnection(url);
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
