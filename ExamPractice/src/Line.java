
public class Line {
	int x1;
	int x2;
	int y1;
	int y2;

	public Line(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public Line(Line other) {
		this(other.x1, other.x2, other.y1, other.y2);
	}

	public double length() {
		double disX = Math.pow((x1 - x2), 2);
		double disY = Math.pow((y1 - y2), 2);
		return Math.sqrt(disX + disY);
	}
	
	public boolean on(int x, int y) {
		if(((x1<x && x<x2) || (x2<x && x<x1)) || ((y1<y && y<y2) || (y2<y && y<y1)))
			return true;
		return false;
	}
}
