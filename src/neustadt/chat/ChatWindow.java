package neustadt.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.eclipse.jetty.server.Server;

public class ChatWindow extends JFrame {
	private JTextArea textArea;
	private JTextField textField;
	private JButton button;

	public ChatWindow() {
		setTitle("Chat Window");
		setSize(600, 600);
		setDefaultCloseOperation(ChatWindow.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout());

		JLabel label = new JLabel("COMPUTER SCIENCE CHAT!");
				
		textArea = new JTextArea();
		textField = new JTextField();
		button = new JButton("SEND");

		JScrollPane pane = new JScrollPane(textArea);
		pane.setPreferredSize(new Dimension());
				
		Server server = new Server(8080);
		server.setHandler(new ChatHandler(textArea));
		try {
			server.start();
		} catch (Exception e) {
			e.printStackTrace();
		}

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				try {
					textArea.append("SHAINDY: " + textField.getText() + "\n");

					//Chaya Sara: "http://192.168.117.168:8080"
					URL url = new URL("http://192.168.117.111:8080");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.setDoOutput(true);
					OutputStream out = connection.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.print(textField.getText());
					writer.flush();
					textField.setText("");
					textField.grabFocus();
					connection.getInputStream();

				} catch (IOException e) {
					textArea.append("Chaya Sara is ignoring you!\n");
				}
			}
		});

		
		panel.add(textField, BorderLayout.CENTER);
		panel.add(button, BorderLayout.EAST);
		
		container.add(pane, BorderLayout.CENTER);
		container.add(panel, BorderLayout.SOUTH);
		container.add(label, BorderLayout.NORTH);
	}

	public static void main(String[] args) throws Exception {
		new ChatWindow().setVisible(true);
	}
}