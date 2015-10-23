package ACM;

public class RascalTriangle {

	public static void main(String[] args) {

		System.out.println(r(4, 3));
	}

	public static int r(int n, int m) {
		if (n < 0 || m < 0 || m > n) {
			return 0;
		} else if (m == 0 || n == m) {
			return 1;
		}
		return (r(n - 1, m - 1) * r(n - 1, m) + 1) / (r(n - 2, m - 1));
	}
}