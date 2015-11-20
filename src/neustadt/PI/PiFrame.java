package neustadt.PI;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PiFrame extends JFrame{

	public PiFrame(){
		setTitle("Pi");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel();
		Container contentPane = getContentPane();
		contentPane.add(label);
		label.setText("Calculation in Progress...");
		
		PiCalculationThread thread = new PiCalculationThread(label);
		thread.start();
	}
	
	public static void main(String[] args){
		new PiFrame().setVisible(true);
	}
}