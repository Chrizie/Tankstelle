import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class Main
{
	//Tankstellen in Mainhausen mit einem Radius von 4km (Calpram-Mainflingen ausgehend) mit der suche nach e10 Preisen
	// API-Key von https://creativecommons.tankerkoenig.de
	private static String URL = "https://creativecommons.tankerkoenig.de/json/list.php?lat=50.02675533406389&lng=9.022982602772519&rad=4&sort=price&type=e10&apikey=";
	private static String apiKey = "";
	private static String urlAndKey = URL+apiKey;

	private static HttpURLConnection connection;

	public static void main(String[] args) throws IOException
	{
		System.out.println("Trying to connect...");
		System.out.println(httpRequest());
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		
		//TODO Implement time logging
		// setInterval research


		System.in.read();

	}

	static String httpRequest() throws IOException
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
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line + "\n");
			}
			responseContent = new StringBuffer();
			reader.close();

			return "connection successful \n" + responseContent.toString();
		}
		else
		{
			reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			while((line = reader.readLine()) != null)
			{
				responseContent.append(line + "\n");
			}
			reader.close();

			return "Problems connecting\n***********Error message*********** \n" + connection.getErrorStream();
		}
	}

	static void gettingData()
	{

	}
}
