package function;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;

import windowBuilder.Window;

public class Main extends APIBeans
{
	public Main() {}
	
	private static String URL = "https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=4&sort=price&type=e10&apikey=";
	private static String apiKey = "";
	private static String urlAndKey = URL+apiKey;
	private static Window frame;
	
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
			     
			    System.out.println(listToArray(list).toString());

			
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, exception.getMessage(),"Exception caught", JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println("Trying to connect...\n" + checkHttpRequest());
		System.out.println(gettingData("price"));
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		
		//TODO Implement time logging
		// setInterval research


		System.in.read();

	}
	
	static String[][] listToArray(ArrayList<String> list) 
	{
	     
	    int size = list.size();
	    String[][] tab2d = new String[10][10];
	     
	    for(int i = 0; i < size; i++)
	    {
	        for(int j = 0; j < size; j++)
	        {
	        }
	    }
	     
	    return tab2d;
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

	
	static List<String[][]> gettingData(String getData)
	{
		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		List<String[][]> table = null;
		
		try 
		{
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			table = new ArrayList<String[][]>();
			while((line = reader.readLine()) != null)
			{
				if(line.contains("name"))
				{
					responseContent.append(line + "\n");
				}
				else if(line.contains(getData))
				{
					responseContent.append(line + "\n");
					//table.add(line);
				}
			}
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return table;
	}
}	
