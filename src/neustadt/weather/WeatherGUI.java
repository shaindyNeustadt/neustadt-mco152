package neustadt.weather;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WeatherGUI extends JFrame {
	private JLabel zip;
	private JTextField zipcode;
	private JLabel temperature;
	private JLabel image1;
	private JButton button;
	private JLabel description;

	public WeatherGUI() throws IOException {
		setTitle("Current Weather");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		zip = new JLabel("ZIPCODE");
		zipcode = new JTextField();
		temperature = new JLabel("");
		button = new JButton("Get Current Weather");
		image1 = new JLabel();

		description = new JLabel();

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					WeatherRequest request = new WeatherRequest(zipcode
							.getText());
					CurrentWeather currWeather = request.getCurrentWeather();
					
					temperature.setText(String.valueOf(currWeather.getTemp())
							+ "° F");
					
					StringBuilder builder = new StringBuilder();
					builder.append("http://openweathermap.org/img/w/");
					builder.append(currWeather.getIcon());
					builder.append(".png");
					
					URL url = new URL(builder.toString());
					BufferedImage image = ImageIO.read(url);
					image1.setIcon(new ImageIcon(image));
					
					description.setText(currWeather.getDescription());
					
				} catch (IOException | NullPointerException e) {
					temperature.setText("Invalid zipcode");
					image1.setIcon(null);
					description.setText("");
				}
			}
		});
		
		container.add(button);
		container.add(zip);
		container.add(zipcode);
		container.add(temperature);
		container.add(image1);
		container.add(description);
	}
}