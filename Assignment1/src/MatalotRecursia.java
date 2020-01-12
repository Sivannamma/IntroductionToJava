
public class MatalotRecursia {

	public static int factorial(int fact) {
		if (fact == 0)
			return 1;
		return factorial(fact - 1) * fact;
	}

	public static int numSum(int num) {
		if (num == 0)
			return 0;
		return numSum(num - 1) + num;
	}

	public static void printLine(int num) {
		if (num == 0)
			return;
		else
			System.out.print("*");
		printLine(num - 1);
	}

	public static void printTriangle(int num) { // base is first with printline recursia
		if (num == 0)
			return;
		printLine(num);
		System.out.println();
		printTriangle(num - 1);
	}

	public static void printTriangle2(int num) { // base is first with for loop
		if (num == 0)
			return;
		for (int i = 0; i < num; i++)
			System.out.print("*");

		System.out.println("");
		printTriangle2(num - 1);
	}

	public static void printTriangleTop(int num, int i) { // top of the triangle is first

		if (num == i)
			return;

		for (int z = 0; z <= i; z++)
			System.out.print("*");

		System.out.println("");
		printTriangleTop(num, ++i);
	}

	public static int fibonacci(int num) {
		if (num == 1 || num == 2)
			return 1;

		return fibonacci(num - 1) + fibonacci(num - 2);
	}

	public static int reversNum(int num) {
		int reversNum = 0;
		while (num != 0) {
			reversNum = reversNum * 10 + num % 10;
			num = num / 10;
		}
		return reversNum;
	}

	public static void main(String[] args) {

		int user1 = MyConsole.readInt("enter a number");

		System.out.println("the factorial of: " + user1 + " is: " + factorial(user1)); // 1:

		System.out.println("the sum of the numbers in: " + user1 + " is: " + numSum(user1)); // 2:
		printLine(user1); // 3:

		printTriangle(user1); // 4:
		printTriangle2(user1); // 4:

		int i = 0; // 5:
		printTriangleTop(user1, i);

		System.out.println("the " + user1 + " number in fibonnaci is: " + fibonacci(user1)); // 6:

		System.out.println("the number before the reverse is: " + user1); // 7:
		System.out.println("the number after the reverse is: " + reversNum(user1));

	}

}
