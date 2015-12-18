package neustadt.contacts;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ContactJFrame extends JFrame {

	private JList<String> list;

	public ContactJFrame() throws IOException {
		setTitle("Contact List");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		DefaultListModel<String> listModel = new DefaultListModel<String>();

		ContactThread thread = new ContactThread(listModel);
		thread.start();

		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					int index = list.locationToIndex(evt.getPoint());
					new ContactInfoJFrame(index, thread).setVisible(true);
					;
				}
			}
		});

		container.add(list, BorderLayout.CENTER);
	}

	public static void main(String[] args) throws IOException {
		new ContactJFrame().setVisible(true);
	}
}