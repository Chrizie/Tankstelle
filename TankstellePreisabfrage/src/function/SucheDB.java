package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SucheDB extends APIBeans
{
	private String stadt = "";
	private double lat = 0;
	private double lng = 0;
	
	public SucheDB(String stadt, double lat, double lng)
	{
		this.stadt = stadt;
		this.lat = lat;
		this.lng = lng;
	}
	
	public ArrayList<SucheDB> getLatLngFromDB() throws Exception
	{
		Connection connection = null; 
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		ArrayList<SucheDB> stadtLatLng = new ArrayList<SucheDB>();
		int rc = 1;
		final String sql = "SELECT * from location;";
		
		try 
		{
			connection = DBConnection.connect();
			prepStatement = connection.prepareStatement(sql);
			resultSet = prepStatement.executeQuery();
	       
			while(resultSet.next())
			{
				setStadt(resultSet.getString("stadt"));
				setLat(resultSet.getDouble("lat"));
				setLng(resultSet.getDouble("lng"));
				stadtLatLng.add(new SucheDB(getStadt(), getLat(), getLng()));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			connection.close();
			prepStatement.close();
			resultSet.close();
		}
		return stadtLatLng; 
	}
	
	
	public ArrayList<SucheDB> getLatLngFromDBByTown(String town) throws Exception
	{
		Connection connection = null; 
		PreparedStatement prepStatement = null;
		ResultSet resultSet = null;
		ArrayList<SucheDB> latLng = new ArrayList<SucheDB>();
		final String sql = "SELECT * FROM location WHERE stadt = '"+town+"';";
		
		try 
		{
			connection = DBConnection.connect();
			prepStatement = connection.prepareStatement(sql);
			resultSet = prepStatement.executeQuery();
			
			while(resultSet.next())
			{
				setStadt(resultSet.getString("stadt"));
				setLat(resultSet.getDouble("lat"));
				setLng(resultSet.getDouble("lng"));
				latLng.add(new SucheDB(getStadt(), getLat(), getLng()));
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			connection.close();
			prepStatement.close();
			resultSet.close();
		}
		return latLng; 
	}
	
	public String toString()
	{
	    return(this.stadt);
	}
}
