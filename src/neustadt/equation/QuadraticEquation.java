package neustadt.equation;

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation(double a, double b, double c) {
		if (a == 0)
			throw new InvalidRootException();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getPositiveX() {
		if (b * b - (4 * a * c) < 0)
			throw new InvalidRootException();
		double x = (-b + Math.sqrt(b * b - (4 * a * c))) / (2 * a);
		return x;
	}

	public double getNegativeX() {
		if (b * b - (4 * a * c) < 0)
			throw new InvalidRootException();
		double x = (-b - Math.sqrt(b * b - (4 * a * c))) / (2 * a);
		return x;
	}
}