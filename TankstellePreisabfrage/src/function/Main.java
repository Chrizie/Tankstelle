package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import windowBuilder.Window;

public class Main extends SucheDB
{
	
	static final String tankerkoenigApiUrl = "https://creativecommons.tankerkoenig.de/json/list.php?lat=%1$f&lng=%2$f&rad=%3$d&sort=price&type=%4$s&apikey=%5$s";
	static final String defaultApiKey = "00000000-0000-0000-0000-000000000002";

	public Main(String stadt, double lat, double lng) 
	{
		super(stadt, lat, lng);
	}
	
//	private static String URL = "https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=4&sort=price&type=e10&apikey=";
	private static Window frame;
	
	static StringBuffer responseContent;
	private static HttpURLConnection connection;

	public static void main(String[] args) throws IOException
	{
		try
		{
			Main main = new Main("",0,0);
			main.getData();
			frame = new Window();
			frame.setVisible(true);
			
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, exception.getMessage(),"Exception caught in Main", JOptionPane.ERROR_MESSAGE);
		}
		
		//System.out.println("Trying to connect...\n" + checkHttpRequest());
		
		
		//TODO Implement time logging
		// setInterval research
		

		System.in.read();
		
		

	}
	

	static  String checkHttpRequest() throws IOException
	{
		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		// URL url = new URL("https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=5&sort=price&type=e10&apikey=00000000-0000-0000-0000-000000000002");
		URL url = new URL(String.format(tankerkoenigApiUrl, 50.027, 9.023, 5, "e10", defaultApiKey));
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		if(connection.getResponseMessage().equals("OK"))
		{
			return "connection successful";
		}
		else
		{
			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line + "\n");
			}
			reader.close();
			
			JOptionPane.showMessageDialog(null, connection.getErrorStream(),"Exception caught", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			return "Problems connecting\n***********Error message*********** \n" + connection.getErrorStream();
		}
	}
	
	public void setData(String sprit, String radius)
	{
		setGasType(sprit);
		setRadius(radius);
		System.out.println(getGasType());
		System.out.println(getRadius());
	}
	
	public InputStream getData() throws IOException
	{
	
		if(getGasType() == null && getRadius() == null)
		{
			setGasType("e10");
			setRadius("5");
			System.out.println("Is Null");
		}

		System.out.println(getGasType());
		System.out.println(getRadius());
		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		URL url = new URL(String.format(tankerkoenigApiUrl, 50.026755, 9.022983, Integer.parseInt(getRadius()), getGasType(), defaultApiKey));		
		System.out.println("URL: "+url);
		connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setConnectTimeout(5000);
		connection.setReadTimeout(5000);

		if(connection.getResponseMessage().equals("OK"))
		{
			return connection.getInputStream();
		}
		else
		{
			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line + "\n");
			}
			reader.close();
			
			JOptionPane.showMessageDialog(null, connection.getErrorStream(),"Exception caught", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
			return connection.getErrorStream();
		}
	}

	
	
	public String[][] parse()
	{
		
		StringBuilder responseContent = new StringBuilder();
		BufferedReader reader;
		String[][] array = null;
		String line;
		
	
		try 
		{
			System.out.println(getData());
			reader = new BufferedReader(new InputStreamReader(getData()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line + "\n");
			}
			
			String stringResponseContent = responseContent.toString();
			int myInt;
			myInt = stringResponseContent.indexOf("[");
			System.out.println(myInt);
			stringResponseContent = stringResponseContent.substring(myInt);
			
			JSONArray jsonArr = new JSONArray(stringResponseContent);
			array = new String[jsonArr.length()][5];
				   	System.out.println(jsonArr.length());
				   	
				   	for (int i=0; i < jsonArr.length(); i++) 
				   	{        
				   		System.out.println(Arrays.deepToString(array));
				   	    JSONObject obj = jsonArr.getJSONObject(i);
				   	    array[i][0] = obj.getString("name");
				   	    array[i][1] = obj.getString("street");
				   	    array[i][2] = obj.getString("place");
				   	    array[i][3] = String.valueOf(obj.getDouble("price"));
				   	    array[i][4] = String.valueOf(obj.getBoolean("isOpen"));
				   	}
		}
			
		
					//table.add(line);
				
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return array;
	}
	
}