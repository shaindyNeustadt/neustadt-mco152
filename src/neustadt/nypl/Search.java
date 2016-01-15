package neustadt.nypl;

public class Search {
	private Response response;

	public Response getResponse() {
		return response;
	}

	public Result[] getResults() {
		return response.getResult();
	}

	public Result getResult(int index) {
		return response.getResult(index);
	}
}
