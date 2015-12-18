package neustadt.contacts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ContactInfoJFrame extends JFrame {
	private JLabel name;
	private JLabel email;
	private JLabel address1;
	private JLabel address2;
	private JLabel address3;
	private JLabel address4;

	public ContactInfoJFrame(int index, ContactThread thread) {
		setTitle("Contact");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new GridLayout(6, 0));

		User[] users = thread.getUsers();

		name = new JLabel(users[index].getName());
		email = new JLabel(users[index].getEmail());
		address1 = new JLabel(users[index].getSuite());
		address2 = new JLabel(users[index].getStreet());
		address3 = new JLabel(users[index].getCity());
		address4 = new JLabel(users[index].getZipcode());

		container.add(name);
		container.add(email);
		container.add(address1);
		container.add(address2);
		container.add(address3);
		container.add(address4);
	}
}