package neustadt.reference;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import neustadt.weather16day.CurrentWeatherThread;
import neustadt.weather16day.Panel;
import neustadt.weather16day.WeatherGUI;

public class SampleJFrame extends JFrame{
	private JTextField cityName;
	private JButton button;
	private Panel panel;
	
	public SampleJFrame() throws IOException {
		setTitle("TITLE");
		setSize(1400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		cityName = new JTextField("Enter City Name");
		button = new JButton("Get Weather Forecast");
		panel = new Panel();
				
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				CurrentWeatherThread thread = new CurrentWeatherThread(cityName, panel.getPanels());
				thread.start();
			}
		});

		container.add(button, BorderLayout.NORTH);
		container.add(cityName, BorderLayout.SOUTH);
		container.add(panel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) throws IOException{
		new WeatherGUI().setVisible(true);
	}
}

