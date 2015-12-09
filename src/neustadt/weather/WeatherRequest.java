package neustadt.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WeatherRequest {
	private CurrentWeather currWeather;
	
	public WeatherRequest(String zipcode) throws IOException {
		StringBuilder builder = new StringBuilder();
		builder.append("http://api.openweathermap.org/data/2.5/weather?zip=");
		builder.append(zipcode);
		builder.append(",us&appid=bfe3377fe84c32565da01db51fc8f33c&units=imperial");
		
		URL url = new URL(builder.toString());
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		Gson gson = new GsonBuilder().create();
		this.currWeather = gson.fromJson(reader, CurrentWeather.class);
	}

	public CurrentWeather getCurrentWeather(){
		return currWeather;
	}
	
	}