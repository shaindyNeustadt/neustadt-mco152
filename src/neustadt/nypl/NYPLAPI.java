package neustadt.nypl;

public class NYPLAPI {

	private Search nyplAPI;

	public Response getResponse() {
		return nyplAPI.getResponse();
	}

	public Result[] getResults() {
		return nyplAPI.getResults();
	}

	public Result getResult(int index) {
		return nyplAPI.getResult(index);
	}
}
