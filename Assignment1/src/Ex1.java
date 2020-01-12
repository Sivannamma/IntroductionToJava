
public class Ex1 {

	public static void main(String[] args) {

		final double CONVERSION = 2.54; // making final number to use it as conversion
		double convertNum;
		int userNum1 = MyConsole.readInt("Enter an Inch length: "); // getting natural number from the user

		while (true) {
			if (userNum1 >= 0) // if number is >= then it prints, if not the user need to enter a positive
								// number again
			{
				convertNum = userNum1 * CONVERSION; // converting to centimeter
				System.out.println(convertNum + "cm = " + userNum1 + "''");
				break; // if the number was positive it stops the while
			} else {
				System.out.println("Type a Positive Number ");
				userNum1 = MyConsole.readInt("Enter an Inch length: "); // getting natural number from the user
			}
		}

		userNum1 = MyConsole.readInt("Enter a Centimeter length: "); // getting natural number from the user
		while (true) {
			if (userNum1 >= 0) // if number is >= then it prints, if not the user need to enter a positive
								// number again
			{
				convertNum = userNum1 / CONVERSION; // converting to inches
				System.out.println(userNum1 + "cm = " + convertNum + "''");
				break; // if the number was positive it stops the while
			}

			else {
				System.out.println("Type a Positive Number ");
				userNum1 = MyConsole.readInt("Enter an Centimeter length: "); // getting natural number from the user
			}
		}
		// end of exercise 1

		int userNum2 = MyConsole.readInt("Enter a number: ");
		int numForPrint = userNum2;
		int counter = 0;
		while (userNum2 != 0) {

			if (userNum2 % 10 == 8 || userNum2 % 10 == -8) // checks how many 8 in the number
				counter++; // if there is 8 increment by 1
			userNum2 = userNum2 / 10;

		}
		System.out.println("The sum of 8's in the number: " + numForPrint + " is: " + 8 * counter); // 8 multiply by the
																									// number of how
																									// many 8 there is

		// end of exercise 2

		int a = MyConsole.readInt("Enter a number, a");
		while (a <= 0) {
			a = MyConsole.readInt("Get a positive number and not equals to 0");
		}

		int b = MyConsole.readInt("Enter a number, b");

		int closestNumber = -1; // initializing closestNumber, does not matter what in it
		double minDistance = Double.MAX_VALUE; // got a max number to start comparing it to something

		System.out.print("The numbers that was randomly selected are : ");

		for (int i = 0; i < a; i++) // "for" for randomly getting "a" times numbers
		{
			int randomNum = (int) (Math.random() * 91 + 10); // getting a number from 10-100
			System.out.print(" ," + randomNum); // prints then numbers that we randomly got
			double sqrtNum = Math.sqrt(randomNum); // sqrted the number

			if (Math.abs(b - sqrtNum) < minDistance) // finding the minimum distance
			{
				minDistance = Math.abs(b - sqrtNum); // if its the minimum, it insert into the MinDistance
				closestNumber = randomNum;
			}

		}
		System.out.println("\nThe number " + closestNumber + "  was chosen, since sqrt( " + closestNumber + " )="
				+ Math.sqrt(closestNumber) + ", which is closest to " + b + "");
		// end of exercise 3

		int pascalLin = MyConsole.readInt("Enter a number");
		if (pascalLin < 0) {
			pascalLin = MyConsole.readInt("Enter a positive number");
		}

		else {
			for (int n = 0; n < pascalLin; n++) {

				for (int k = 0; k <= n; k++) {
					long x = 1, y = 1, z = 1; // i used "long" because factorial can become a big number

					for (int i = n; i > 0; i--) // x = n!
					{
						x = x * i;
					}

					for (int i = k; i > 0; i--) // y =k!
					{
						y = y * i;
					}

					for (int i = n - k; i > 0; i--) // z= (n-k)!
					{
						z = z * i;
					}

					long printPanscal = x / (y * z);

					System.out.print(printPanscal + " ");
				}
				System.out.println();

			}
		}

	}

}
