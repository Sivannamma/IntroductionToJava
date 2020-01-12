
public class Point {
	private double x, y;
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point() {
		x=y=0;//this.x=this.y=0;
	}

	public Point(Point p) {
		x=p.x;
		y=p.y;
	}
	public double distance(Point p) {
		double dx,dy;
		dx=p.x-x;
		dy=p.y-y;
		return (Math.sqrt(dx*dx+dy*dy));
	}
	public String toString() {
		return "( "+x+", "+y+" )";
	}
}
