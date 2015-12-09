package neustadt.weather;

public class CurrentWeather {

	private Weather[] weather;
	private Main main;

	public double getTemp() {
		return main.getTemp();
	}

	public String getIcon() {
		return weather[0].getIcon();
	}

	public String getDescription() {
		return weather[0].getDescription();
	}

}