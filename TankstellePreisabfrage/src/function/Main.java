package function;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
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
			frame = new Window();
			frame.setVisible(true);
			
			  ArrayList<String> list = new ArrayList<String>();
			    list.add("Test");
			    list.add("Test2");
			    list.add("Test3");
			    //System.out.println(listToArray(list).toString());
				
				Calendar cal = Calendar.getInstance();
				System.out.println(cal.getTime());
			
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, exception.getMessage(),"Exception caught", JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println("Trying to connect...\n" + checkHttpRequest());
		
		
		listToArray();
		
		//TODO Implement time logging
		// setInterval research
		parse();

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

	static String checkHttpRequest() throws IOException
	{
		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;

		URL url = new URL("https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=4&sort=price&type=e10&apikey=00000000-0000-0000-0000-000000000002");
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

	//TODO Muss hier irgendwie String[][] für die Tabelle füllen
	static void parse()
	{
		
		StringBuilder responseContent = new StringBuilder();
		BufferedReader reader;
		String line;
		
		try 
		{
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null)
			{
					responseContent.append(line);
			}
			JSONArray jsonArr = null;
			try {jsonArr = new JSONArray(responseContent.toString());}
			catch(Exception exception) {exception.printStackTrace();}
			String name = "";
			for(int i = 0; i < jsonArr.length(); i++)
			{
				JSONObject jsonObj = null;
				try {jsonObj = (JSONObject) jsonArr.get(i);}
				catch(Exception exception) {exception.printStackTrace();}
				
				try {name = (String) jsonObj.get("name");}
				catch(Exception exception) {exception.printStackTrace();}
				System.out.println(responseContent);
				System.out.println(name);	
				System.out.println(jsonArr.length());	
			}	
				   	
//				   	System.out.println(json.length());
//				   	String[][] array = new String[json.length()][5];
//				   	
//				   	for (int i=0; i < json.length(); i++) 
//				   	{                           
//				   	    JSONObject obj = json.getJSONObject(i);
//				   	    array[i][0] = obj.getString("name");
//				   	    array[i][1] = obj.getString("street");
//				   	    array[i][2] = obj.getString("place");
//				   	    array[i][3] = obj.getString("price");
//				   	    array[i][4] = obj.getString("isOpen");
//								
//					reader.close();
					
				
		   	
		   	//System.out.println(array);	   	 
				}
			
		
					//table.add(line);
				
		catch (IOException e)
		{
			e.printStackTrace();
		}
	    JSONObject jo = new JSONObject(responseContent);
					JSONObject jo_root = jo.getJSONObject("root");
					parse();
	}
}