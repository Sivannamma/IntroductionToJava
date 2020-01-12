
public class Balloon {
	double x;
	double y;
	double r;

	public Balloon(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public Balloon(Balloon other) {
		this(other.x, other.y, other.r);
	}

	public double volume() {
		double v = (4 / 3) * (Math.PI) * r * r * r;
		return v;
	}

	public boolean isIn(double x, double y) {
		double dis = Math.sqrt(((this.x - x) * (this.x - x)) + ((this.y - y) * (this.y - y)));
		if (r > dis)
			return true;
		return false;
	}

	public void setRadius(double r) {
		this.r = r;
	}

	public double getRadius() {
		return this.r;
	}

	public String toString() {
		String str = "(" + x + ", " + y + ")" + " radius is: " + r;
		return str;
	}
}