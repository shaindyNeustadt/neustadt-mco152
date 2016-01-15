package neustadt.nypl;

import java.net.URL;

public class Result {
	private String title;
	private URL apiItemURL;

	public String getTitle() {
		return title;
	}

	public URL getApiItemURL() {
		return apiItemURL;
	}

	@Override
	public String toString() {
		if (title.length() > 30) {
			return title.substring(0, 30);
		}
		return title;
	}

}
