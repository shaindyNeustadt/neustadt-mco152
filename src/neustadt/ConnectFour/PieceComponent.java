package neustadt.ConnectFour;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class PieceComponent extends JComponent {
	private Color color;
	private ConnectFour cf;
	public PieceComponent(ConnectFour cf){
		this.cf = cf;
		this.color = Color.WHITE;
	}
	
	public void setShapeColor(Color color)
    {
      this.color = color; 
    }
	
	private Graphics g;
	@Override
	protected void paintComponent(Graphics g) {
		this.g = g;
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval((getWidth() - 70)/2, (getHeight() - 70)/2, 70, 70);
		
		
		//cf.nextTurn();				
		
		
	//while(!cf.isOver() && !cf.won()){
		
	/*	for(int i = 0; i < cf.getBoard().length; i ++){
			for(int j = 0; j < cf.getBoard()[i].length; j++ ){
				if( cf.getBoard()[i][j] == 'y'){
					g.setColor(color);
					//g.fillOval((getWidth() - 70)/2, (getHeight() - 70)/2, 70, 70);
					//super.repaint();
				}
						}
		}*/
		super.repaint();
		//	cf.nextTurn();
		}
	
public void paintComponent1(String red, PieceComponent pc){
		super.paintComponent(g);
		System.out.println("Reached paintComponent1 method");
		g.setColor(Color.RED);
		g.fillOval((getWidth() - 70)/2, (getHeight() - 70)/2, 70, 70);
		super.repaint();
	}
	
}
