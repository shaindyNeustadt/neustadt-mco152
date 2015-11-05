package neustadt.ConnectFour;

public class Player {
	private String name;
	private char color;

	public Player(String name, char color) {
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return this.name;
	}

	public char getColor() {
		return this.color;
	}
}