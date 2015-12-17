package neustadt.reference;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import neustadt.weather16day.WeatherList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SampleThread extends Thread {
	private JTextField textField;

	public SampleThread(JTextField textView) {
		this.textField = textField;
	}

	public void run() {
		try {
			URL url = new URL("");
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new GsonBuilder().create();
			WeatherList wlist = gson.fromJson(reader, WeatherList.class);

			// url = new URL("http://openweathermap.org/img/w/" +
			// textField.getIcon() + ".png");
			BufferedImage image = ImageIO.read(url);

			// setters

		} catch (IOException | NullPointerException e) {
			// display error or nothing
		}
	}
}
