package neustadt.weather;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherRequest {

	URL url = new URL("http://openweathermap.com");
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
	InputStream in = connection.getInputStream();
	BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	
	String s;
	while ((s = reader.readLine()) != null) {
		System.out.println(s);
	}
}
}
