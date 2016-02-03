package neustadt.nypl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SearchThread extends Thread {

	private JTextField searchItem;
	private DefaultListModel<String> listModel;
	private NYPLAPI nyplAPI;
	private JList<String> list;

	public SearchThread(JTextField searchItem,
			DefaultListModel<String> listModel, JList<String> list) {
		this.searchItem = searchItem;
		this.listModel = listModel;
		this.list = list;
	}

	public void run() {
		try {
			URL url = new URL("http://api.repo.nypl.org/api/v1/items/search?q=" + searchItem.getText()
					+ "&publicDomainOnly=true");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestProperty("Authorization", "Token token=\"7su7zvgpuzzs6tc7\"");

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new GsonBuilder().create();
			nyplAPI = gson.fromJson(reader, NYPLAPI.class);

			for (Result r : nyplAPI.getResults()) {
				listModel.addElement(r.toString());
			}
			list.setModel(listModel);
			
		} catch (IOException ex) {
		}
	}

	public URL getAPIItemURL(int index) {
		return nyplAPI.getResult(index).getApiItemURL();
	}

	}
