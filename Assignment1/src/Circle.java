
public class Circle {
	Point center;
	double radius;
	public Circle() {
		center=new Point();//(0,0)
		radius=1;
	}
	public Circle(Point center,double radius) {
		this.center=center;//pointing at the same place in the memory
		this.radius=radius;
	}
	public Circle(Circle c) {
		this.radius=c.radius;
		this.center=new Point(c.center);
	}
	public void CheckPoint(Point p) {
		double dist=p.distance(center);
		if(dist>radius) {
			System.out.println(p+" is outside the circle");
		}else if(dist<radius) {
			System.out.println(p+" is inside the circle");
		}else {
			System.out.println(p+" is on the circle");
		}
	}
	public String toString() {
		return "Center: "+center+", Radius: "+radius;
	}
}
