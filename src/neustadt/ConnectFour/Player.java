package neustadt.ConnectFour;

import java.awt.Color;

public class Player {

	private int number;
	private Color color;

	Player(int number, Color color) {
		this.number = number;
		this.color = color;
	}

	public int getNumber() {
		return number;
	}

	public Color getColor() {
		return color;
	}
}
