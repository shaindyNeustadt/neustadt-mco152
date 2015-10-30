package neustadt.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class SmileComponent extends JComponent{
	private int height = 0;
	@Override
	protected void paintComponent(Graphics g){
	
	
		super.paintComponent(g);
		
		MouseInfo m = null;
		
		
		int x1 = m.getPointerInfo().getLocation().x;
		int x2 = m.getPointerInfo().getLocation().x;
		int y = m.getPointerInfo().getLocation().y;
		
	
		if(y <= 165){
			y = 165;
		}
		else if(y >= 210){
			y = 210;
		}
		
		if(x1 <= 250){
			x1 = 250;
			x2 = 450;
		}
		
		else if(x1 >= 250 && x1 < 525){
			x1 = 275;
			x2 = 475;
		}
		else if(x1 >= 525){
			x1 = 325;
			x2 = 525;
		}
		g.setColor(Color.yellow);
		g.fillOval(150, 50, 500, 500);
		g.setColor(Color.blue);
		g.fillOval(250, 150, 100, 100);
		g.setColor(Color.white);
		//g.fillOval(305, 205, 25, 25);
		g.fillOval(x1, y, 25, 25);
		g.setColor(Color.blue);
		g.fillOval(450, 150, 100, 100);
		g.setColor(Color.white);
		g.fillOval(x2, y, 25, 25);
		//g.fillOval(505, 205, 25, 25);
		g.setColor(Color.red);
		g.fillArc(250, 200, 300, 300, 180, 180);
		
		
		g.setColor(Color.black);
		g.fillOval(250, 150, 100, height);
		g.fillOval(450, 150, 100, height);
		
		if(height <= 100){
		height++;
		try {
			Thread.sleep(16);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				}
		
		if(height == 101) {
			while(height >= 0){
		height--;
				}
		}
				
		
		super.repaint();
				
	}
	
	
}
