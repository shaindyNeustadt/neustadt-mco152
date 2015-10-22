package neustadt.gui;

import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import neustadt.equation.PythagoreanTheorem;
import neustadt.equation.QuadraticEquation;

public class GuiPythagorean extends JFrame{
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JTextField text1;
	private final JTextField text2;
	private final JTextField text3;
	private final JButton button;
	
	public GuiPythagorean(){
		setTitle("Pythagorean Theorem");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sizes as small as possible
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		label1 = new JLabel("TIME");
		label2 = new JLabel("B");
		label3 = new JLabel("c");
				
		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		button = new JButton("Calculate");
		
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event) {
				PythagoreanTheorem pt = new PythagoreanTheorem();
				Double a = Double.parseDouble(text1.getText());
				Double b = Double.parseDouble(text2.getText());
				String c = text3.getText();
				if(a != null && b != null){
				pt.setAB(a, b);
				text3.setText("= " + pt.getC());
				
				}
			}
			
		});
		add(label1);
		add(text1);
		add(label2);
		add(text2);
		add(label3);
		add(text3);
		add(button);
	}
}
