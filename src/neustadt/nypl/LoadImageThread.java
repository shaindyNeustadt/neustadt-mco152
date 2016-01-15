package neustadt.nypl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LoadImageThread extends Thread {

	private int index;
	private SearchThread searchThread;
	private JLabel image;
	private NYPLAPI nyplAPI;
	private JLabel number;
	private JButton prev;
	private JButton next;
	private int numResults;

	public LoadImageThread(int index, SearchThread searchThread, JLabel image, JLabel number, JButton prev, JButton next) {
		this.index = index;
		this.searchThread = searchThread;
		this.image = image;
		this.number = number;
		this.prev = prev;
		this.next = next;
	}

	public void run() {
		try {
			URL url = searchThread.getAPIItemURL(index);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestProperty("Authorization", "Token token=\"7su7zvgpuzzs6tc7\"");

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new GsonBuilder().create();

			nyplAPI = gson.fromJson(reader, NYPLAPI.class);

			URL imageUrl = new URL(nyplAPI.getResponse().getCaptureURL(0));

			BufferedImage bufferedImage = ImageIO.read(imageUrl);

			image.setIcon(new ImageIcon(bufferedImage));
			numResults = Integer.parseInt(nyplAPI.getResponse().getNumResults());
			number.setText((index + 1) + "/" + numResults);

			if(index == 0){
				next.setEnabled(true);
				prev.setEnabled(false);
			}
			else if(index == numResults -1){
				prev.setEnabled(true);
				next.setEnabled(false);
			}
			else{
				prev.setEnabled(true);
				next.setEnabled(true);
			}
			
			
		} catch (IOException ex) {
		}
	}
}