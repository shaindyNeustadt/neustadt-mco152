package neustadt.weather16day;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherJPanel extends JPanel {
	private JLabel date;
	private JLabel temperature;
	private JLabel icon;
	private JLabel description;

	public WeatherJPanel() {
		setLayout(new GridLayout(4,0));
		
		date = new JLabel();
		temperature = new JLabel();
		icon = new JLabel();
		description = new JLabel();
		
		add(date);
		add(temperature);
		add(icon);
		add(description);
	}

	public void setTemp(String tempString) {
		temperature.setText(tempString);
	}

	public void setIcon(ImageIcon image) {
		icon.setIcon(image);
	}

	public void setDescription(String desc) {
		description.setText(desc);
	}
	public void setDate(String date){
	    this.date.setText(date);;
	}
}