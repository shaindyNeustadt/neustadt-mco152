package neustadt.weather;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CurrentWeatherThread extends Thread {
	private JTextField zipcode;
	private JLabel temp;
	private JLabel icon;
	private JLabel description;

	public CurrentWeatherThread(JTextField zipcode, JLabel temp, JLabel icon, JLabel description) {
		this.zipcode = zipcode;
		this.temp = temp;
		this.icon = icon;
		this.description = description;
	}

	public void run() {
		try {
			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?zip=" + zipcode.getText()
					+ ",us&appid=bfe3377fe84c32565da01db51fc8f33c&units=imperial");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new GsonBuilder().create();
			CurrentWeather currWeather = gson.fromJson(reader, CurrentWeather.class);

			url = new URL("http://openweathermap.org/img/w/" + currWeather.getIcon() + ".png");
			BufferedImage image = ImageIO.read(url);

			temp.setText(String.valueOf(currWeather.getTemp()) + "° F");
			icon.setIcon(new ImageIcon(image));
			description.setText(currWeather.getDescription());

		} catch (IOException | NullPointerException e) {
			temp.setText("Invalid zipcode");
			icon.setIcon(null);
			description.setText("");
		}
	}

}
