package neustadt.gui;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class JFrameDemo extends JFrame{
	
	private final JLabel label;
	private final JTextField textField;
	private final JButton button;
	
	public JFrameDemo(){
		setTitle("JFrameDemo");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//sizes as small as possible
		Container container = getContentPane();
		setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
				
		button = new JButton("BUTTON 1");
		label = new JLabel("Here is some text.....................");
		textField = new JTextField();
		
		button.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("Wow I've added an ActionListener");
			}
		});
		add(button);
		add(textField);
		add(label);
	}
}