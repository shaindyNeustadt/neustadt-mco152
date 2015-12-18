package neustadt.contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import javax.swing.DefaultListModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ContactThread extends Thread {
	private DefaultListModel<String> list;
	private User[] users;

	public ContactThread(DefaultListModel<String> list) {
		this.list = list;
	}

	public ContactThread() {
	}

	public void run() {
		try {
			URL url = new URL("http://jsonplaceholder.typicode.com/users");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			Gson gson = new GsonBuilder().create();
			users = gson.fromJson(reader, User[].class);

			Arrays.sort(users);

			for (User u : users) {
				list.addElement(u.getName());
			}
		} catch (IOException e) {
		}
	}

	public User[] getUsers() {
		return this.users;
	}

}