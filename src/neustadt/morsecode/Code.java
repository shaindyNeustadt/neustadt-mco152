package neustadt.morsecode;

public enum Code {

	a(".-"), b("-..."), c("-.-."), d("-.."), e("."), f("..-."), g("--."), h(
			"...."), i(".."), j(".---"), k("-.-"), l(".-.."), m("--"), n("-."), o(
			"---"), p(".--."), q("--.-"), r(".-."), s("..."), t("-"), u("..-"), v(
			"...-"), w(".--"), x("-..-"), y("-.--"), z("--..");

	private String codeValue;

	private Code(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeValue() {
		return this.codeValue;
	}
}
