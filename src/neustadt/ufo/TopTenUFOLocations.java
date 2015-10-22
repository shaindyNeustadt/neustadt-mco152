package neustadt.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.google.gson.Gson;

public class TopTenUFOLocations {

	public static void main(String[] args) throws IOException {
		try {
			final BufferedReader in = new BufferedReader(new FileReader(
					"./ufo_awesome.json"));

			final Gson gson = new Gson();
			HashMap<String, Integer> locationSighted = new HashMap<String, Integer>();

			final UFOSightingList list = gson.fromJson(in,
					UFOSightingList.class);

			for (UFOSighting ufo : list) {
				String location = ufo.getLocation();

				if (locationSighted.containsKey(location)) {
					locationSighted.put(location,
							locationSighted.get(location) + 1);
				} else {
					locationSighted.put(location, 1);
				}
			}

			ArrayList<String> s = new ArrayList<String>(
					locationSighted.keySet());
			Collections.sort(s, new Comparator<String>() {
				public int compare(String a, String b) {
					return locationSighted.get(b).compareTo(
							locationSighted.get(a));
				}
			});

			for (int i = 0; i < 10; i++) {
				System.out.println(s.get(i) + " - "
						+ locationSighted.get(s.get(i)) + " sightings.");
			}

			in.close();
		} catch (IOException ex) {
			System.out.println("IOException Exiting application.");
			System.exit(1);
		}
	}
}