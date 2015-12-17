package neustadt.weather16day;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CurrentWeatherThread extends Thread {
	private JTextField city;
	private WeatherJPanel[] panels;

	public CurrentWeatherThread(JTextField city, WeatherJPanel[] panels) {
		this.city = city;
		this.panels = panels;
	}

	public void run() {
		try {
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/forecast/daily?q="
							+ city.getText()
							+ ",us&appid=bfe3377fe84c32565da01db51fc8f33c&units=imperial&cnt=16");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new GsonBuilder().create();
			WeatherList wlist = gson.fromJson(reader, WeatherList.class);
			List[] list = wlist.getList();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
						
			for (int count = 0; count < list.length; count++) {
				url = new URL("http://openweathermap.org/img/w/"
						+ list[count].getIcon() + ".png");
				BufferedImage image = ImageIO.read(url);
				
				panels[count].setDate(formatter.format(new Date(list[count].getDate())).toString());
				panels[count].setTemp(String.valueOf(list[count].getTemp())
						+ "° F");
				panels[count].setIcon(new ImageIcon(image));
				panels[count].setDescription(list[count].getDescription());
			}

		} catch (IOException | NullPointerException e) {
			panels[0] = new WeatherJPanel();
		}
	}

}