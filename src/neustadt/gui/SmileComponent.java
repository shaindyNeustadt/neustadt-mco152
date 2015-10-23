package neustadt.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileComponent extends JComponent{

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.yellow);
		g.fillOval(150, 50, 500, 500);
		g.setColor(Color.blue);
		g.fillOval(250, 150, 100, 100);
		g.setColor(Color.white);
		g.fillOval(305, 205, 25, 25);
		g.setColor(Color.blue);
		g.fillOval(450, 150, 100, 100);
		g.setColor(Color.white);
		g.fillOval(505, 205, 25, 25);
		g.setColor(Color.red);
		g.drawLine(250, 400, 350, 450);
		g.drawLine(350, 450, 450, 450);
		g.drawLine(450, 450, 550, 400);
				
	}
	
	
}
