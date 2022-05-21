package function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SucheDB 
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
		ArrayList<SucheDB> stadtLatLng = null;
		int rc = 1;
		final String sql = "SELECT * from location;";
		
		try 
		{
			connection = DBConnection.connect();
			prepStatement = connection.prepareStatement(sql);
			resultSet = prepStatement.executeQuery();
	       
			while(resultSet.next())
			{
				stadtLatLng = new ArrayList<SucheDB>();
				stadtLatLng.add(new SucheDB(resultSet.getString("stadt"), resultSet.getDouble("lat"), resultSet.getDouble("lng")));
				System.out.println(stadtLatLng.toString());
				//TODO falscher output
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
}
