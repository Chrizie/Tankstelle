package function;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import netscape.javascript.JSObject;
import windowBuilder.Window;

public class Main extends APIBeans
{
	public Main() {}
	
	private static String URL = "https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=4&sort=price&type=e10&apikey=";
	private static String apiKey = "";
	private static String urlAndKey = URL+apiKey;
	private static Window frame;
	
	static StringBuffer responseContent;
	private static HttpURLConnection connection;

	public static void main(String[] args) throws IOException
	{
		try
		{
			Main main = new Main();
			main.getData();
			frame = new Window();
			frame.setVisible(true);
			
			
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.getTime());
			
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, exception.getMessage(),"Exception caught in Main", JOptionPane.ERROR_MESSAGE);
		}
		
		//System.out.println("Trying to connect...\n" + main.checkHttpRequest());
		
		
		//TODO Implement time logging
		// setInterval research
		

		System.in.read();
		
		

	}
	
	static void listToArray() 
	{
	   List<String> test1 = new ArrayList<>();
	   
	   test1.add("test1");
	   test1.add("test1");
	   test1.add("test1");
	   List<ArrayList<String>> test2 = new ArrayList<>();
	   
	   
	   
	     
	}

	public String checkHttpRequest() throws IOException
	{
		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		URL url = new URL("https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=5&sort=price&type=e10&apikey=00000000-0000-0000-0000-000000000002");
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
	
	public InputStream getData() throws IOException
	{
		if(getRadius() == null && getGasType() == null)
		{
			setGasType("e10");
			setRadius("5");
		}
		System.out.println(getGasType());
		System.out.println(getRadius());
		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		StringBuilder urlData = new StringBuilder();
		String lat = "50.02675533406389";
		String lng = "9.022982602772519";
		String rad = getRadius();
		String sort = "price";
		String type = getGasType();
		String key = "00000000-0000-0000-0000-000000000002";
		urlData.append("https://creativecommons.tankerkoenig.de/json/list.php?");
		urlData.append("lat="+lat+"&");
		urlData.append("lng="+lng+"&");
		urlData.append("rad="+rad+"&");
		urlData.append("sort="+sort+"&");
		urlData.append("type="+type+"&");
		urlData.append("apikey="+key);
		System.out.println(urlData.toString());
		URL url = new URL(urlData.toString());
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

	
	public void windowValues()
	{
		Window window = new Window();

	}
	
	
	//TODO Muss hier irgendwie String[][] für die Tabelle füllen
	public String[][] parse()
	{
		
		StringBuilder responseContent = new StringBuilder();
		BufferedReader reader;
		String[][] array = null;
		String line;
		
	
		try 
		{
			System.out.println(connection.getInputStream());
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