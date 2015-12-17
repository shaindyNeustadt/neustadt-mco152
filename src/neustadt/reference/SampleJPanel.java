package neustadt.reference;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SampleJPanel extends JPanel{

	private JLabel date;
	private JLabel temperature;
	private JLabel icon;
	private JLabel description;

	public SampleJPanel() {
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
}