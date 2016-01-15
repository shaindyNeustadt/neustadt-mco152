package neustadt.nypl;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import neustadt.contacts.ContactInfoJFrame;
import neustadt.weather16day.CurrentWeatherThread;

public class SearchJFrame extends JFrame {

	public static void main(String[] args) throws IOException {
		new SearchJFrame().setVisible(true);
	}

	private JTextField searchItem;
	private JButton button;
	private JLabel image;
	private SearchThread searchThread;
	private JButton prev;
	private JButton next;
	private JLabel number;
	private int index;
	private int count;
	private LoadImageThread loadImage;

	public SearchJFrame() {

		setTitle("NYPL SEARCH");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		index = 0;
		count = 0;
		image = new JLabel();
		searchItem = new JTextField();
		button = new JButton("Search");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(button, BorderLayout.EAST);
		panel.add(searchItem, BorderLayout.CENTER);

		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		JPanel innerPanel = new JPanel();
		prev = new JButton("Previous");
		next = new JButton("Next");
		number = new JLabel("");
		innerPanel.setLayout(new BorderLayout());
		innerPanel.add(prev, BorderLayout.WEST);
		innerPanel.add(number, BorderLayout.CENTER);
		innerPanel.add(next, BorderLayout.EAST);
		panelCenter.add(innerPanel, BorderLayout.NORTH);

		JScrollPane pane = new JScrollPane(image);
		pane.setPreferredSize(new Dimension());

		panelCenter.add(pane, BorderLayout.CENTER);

		prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				index -= 1;
				loadImage = new LoadImageThread(index, searchThread, image, number, prev, next);
				loadImage.start();
			}
		});

		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				index += 1;
				loadImage = new LoadImageThread(index, searchThread, image, number, prev, next);
				loadImage.start();
			}
		});

		this.getRootPane().setDefaultButton(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				DefaultListModel<Result> listModel = new DefaultListModel<Result>();
				searchThread = new SearchThread(searchItem, listModel);
				searchThread.start();

				JList<Result> list = new JList<Result>(listModel);
				container.add(list, BorderLayout.WEST);

				list.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						JList list = (JList) evt.getSource();
						index = list.locationToIndex(evt.getPoint());
						loadImage = new LoadImageThread(index, searchThread, image, number, prev, next);
						loadImage.start();
						}
				});
			}
		});

		container.add(panel, BorderLayout.NORTH);

		container.add(panelCenter, BorderLayout.CENTER);
	}

}
