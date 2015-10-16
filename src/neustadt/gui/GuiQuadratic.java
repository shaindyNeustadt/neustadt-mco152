package neustadt.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import neustadt.equation.QuadraticEquation;

public class GuiQuadratic extends JFrame{
	private final JLabel label;
	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	private final JTextField textField;
	private final JTextField textField1;
	private final JTextField textField2;
	private final JButton button;
	
	public GuiQuadratic(){
		setTitle("Quadratic Equation");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sizes as small as possible
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
				
		button = new JButton("CALCULATE");
		label = new JLabel("A");
		label1 = new JLabel("B");
		label2 = new JLabel("C");
		label3 = new JLabel("X");
		
		textField = new JTextField();
		textField1 = new JTextField();
		textField2 = new JTextField();
		
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event) {
				QuadraticEquation qe = new QuadraticEquation(Double.parseDouble(textField.getText()), Double.parseDouble(textField1.getText()), Double.parseDouble(textField2.getText()));
				String Xvalue = qe.getPositiveX() + ", " + qe.getNegativeX();
				label3.setText(Xvalue);
			}
		});
		add(label);
		add(textField);
		add(label1);
		add(textField1);
		add(label2);
		add(textField2);
		add(button);
		add(label3);
	}

}
