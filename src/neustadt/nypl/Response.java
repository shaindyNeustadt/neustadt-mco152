package neustadt.nypl;

import java.net.URL;

public class Response {
	private String numResults;
	private Result[] result;
	private Capture[] capture;

	public String getNumResults() {
		return numResults;
	}

	public Result[] getResult() {
		return result;
	}

	public Result getResult(int index) {
		return result[index];
	}

	public String getCaptureURL(int index) {
		return capture[index].getImageLink();
	}

	public Capture[] getCapture() {
		return capture;
	}
}
