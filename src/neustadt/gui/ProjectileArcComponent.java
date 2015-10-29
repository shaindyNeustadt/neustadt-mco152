package neustadt.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

import neustadt.physics.Projectile;

public class ProjectileArcComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		Projectile projectile = new Projectile(31, 20, 0);
		double x = 0;
		double y = getHeight();

		for (int i = 0; i <= 20; i++) {
			double oldx = x;
			double oldy = y;
			projectile.setTime(i);
			x = projectile.getX();
			y = getHeight() - projectile.getY();

			g2.draw(new Line2D.Double(oldx, oldy, x, y));
		}
	}
}