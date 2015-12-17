package neustadt.weather16day;

public class List {
	private Long dt;
	private Weather[] weather;
	private Temp temp;

	public double getTemp() {
		return temp.getDay();
	}
	
	public Long getDate(){
		return dt*1000;
	}
	public String getIcon() {
		return weather[0].getIcon();
	}

	public String getDescription() {
		return weather[0].getDescription();
	}

}