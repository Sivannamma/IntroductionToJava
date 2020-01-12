
public class PointObjectiveMain {

	public static void main(String[] args) {
		PointObjective point1 = new PointObjective();
		PointObjective point2 = point1; // point two gets the address of point 1

		point1.setX(10);
		point1.setY(5);

		PointObjective point3 = new PointObjective(point1); // point three uses copy constructor to get point one x,y

		System.out.println("point 1" + point1);
		System.out.println("point 2" + point2);
		System.out.println("point 3" + point3);

		point1.setX(30);
		point1.setY(15);

		System.out.println("point 1" + point1);
		System.out.println("point 2" + point2);
		System.out.println("point 3" + point3); // notice that this one stays the same, because only copy it before
												// changed
		
		System.out.println("the distance between point1 and point2 is "+point1.distance(point2));
		System.out.println("the distance between point1 and point3 is "+point1.distance(point3));

	}

}
