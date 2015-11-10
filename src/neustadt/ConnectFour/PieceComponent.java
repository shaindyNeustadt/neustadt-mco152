package neustadt.ConnectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class PieceComponent extends JComponent {
	private Color color;
	
	public PieceComponent(){
		this.color = Color.WHITE;
	}
	
	public void setColor(Color color)
    {
      this.color = color; 
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval((getWidth() - 70)/2, (getHeight() - 70)/2, 70, 70);
	
		super.repaint();
		
		}
	
}
