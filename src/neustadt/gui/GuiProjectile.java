package neustadt.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import neustadt.physics.Projectile;

public class GuiProjectile extends JFrame {
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JLabel label4;
	private final JTextField text1;
	private final JTextField text2;
	private final JTextField text3;
	private final JButton button;

	public GuiProjectile() {
		setTitle("PROJECTILE");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// sizes as small as possible
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

		label1 = new JLabel("ANGLE");
		label2 = new JLabel("VELOCITY");
		label3 = new JLabel("TIME");
		label4 = new JLabel();

		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		button = new JButton("CALCULATE");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				Double angle = Double.parseDouble(text1.getText());
				Double velocity = Double.parseDouble(text2.getText());
				Double time = Double.parseDouble(text3.getText());

				Projectile projectile = new Projectile(angle, velocity, time);

				label4.setText(projectile.getX() + " , " + projectile.getY());

			}

		});
		add(label1);
		add(text1);
		add(label2);
		add(text2);
		add(label3);
		add(text3);
		add(button);
		add(label4);
	}
}