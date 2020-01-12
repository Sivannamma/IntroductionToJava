
public class PointObjective {
	private double x;
	private double y;

	public PointObjective(double x, double y) { // constructor
		this.x = x;
		this.y = y;
	}

	public PointObjective() { // constructor
		this(0, 0);
	}

	public PointObjective(PointObjective other) { // copy constructor
		x = other.x;
		y = other.y;
	}

	public double GetX(double x) { // getters x
		return x;
	}

	public double GetY(double y) { // getters y
		return y;
	}

	public void setX(double x) { // setters x
		this.x = x;
	}

	public void setY(double y) { // setters y
		this.y = y;
	}

	public String toString() { // print- to string
		return "( " + x + ", " + y + " )";
	}

	public double distance(PointObjective other) { // distance between two points
		double disX, disY;
		disX = other.x - x;
		disY = other.y - y;
		return Math.sqrt(disX * disX + disY * disY);
	}

}
