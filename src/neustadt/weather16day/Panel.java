package neustadt.weather16day;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private WeatherJPanel[] panels;

	public Panel() {
		setLayout(new GridLayout(0, 16));
		panels = new WeatherJPanel[16];
		for (int i = 0; i < 16; i++) {
			panels[i] = new WeatherJPanel();
			add(panels[i]);
		}
	}

	public WeatherJPanel[] getPanels() {
		return panels;
	}
}