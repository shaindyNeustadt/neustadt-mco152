package neustadt.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class ProjectileArcJFrame extends JFrame {

	public static void main(String[] args) {
		new ProjectileArcJFrame().setVisible(true);
	}

	public ProjectileArcJFrame() {
		setTitle("Projectile Arc");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final BorderLayout layout = new BorderLayout();
		final Container container = getContentPane();
		container.setLayout(layout);
		container.add(new ProjectileArcComponent(), BorderLayout.CENTER);

	}

}