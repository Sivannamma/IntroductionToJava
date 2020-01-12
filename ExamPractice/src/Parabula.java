
public class Parabula {
	private double a;
	private double b;
	private double c;

	public Parabula(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Parabula(Parabula other) {
		this(other.a, other.b, other.c);
	}

	public double function(double x) {
		double y = this.a * x * x + this.b * x + this.c;
		return y;
	}

	public boolean isAbove(double x, double y) {
		if (y > function(x))
			return true;
		return false;
	}

	public void setterA(double a) { // set
		this.a = a;
	}

	public void setterB(double b) { // set
		this.b = b;
	}

	public void setterC(double c) { // set
		this.c = c;
	}

	public double getterA() { // get
		return this.a;
	}

	public double getterB() { // get
		return this.b;
	}

	public double getterC() { // get
		return this.c;
	}

	public String toString() {
		String str = a + "x^2 +" + b + "x +" + c;
		return str;
	}
}
