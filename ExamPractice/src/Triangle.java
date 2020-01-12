
public class Triangle {
	double a;
	double b;

	public Triangle(double a, double b) {
		this.a = a;
		this.b = b;
	}

	public double s() {
		double s = (a * b) / 2;
		return s;
	}

	public static boolean isEquals(Triangle one, Triangle two) {
		if ((one.a == two.a || one.a == two.b) && (one.b == two.a || one.b == two.b))
			return true;
		return false;
	}

}