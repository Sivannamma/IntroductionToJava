import java.util.Arrays;

public class Matalot {

	public static void main(String[] args) {

		// question one - exercise 2

		double userNum1 = MyConsole.readDouble("enter a number a:");
		double userNum2 = MyConsole.readDouble("enter a number b:");

		if (userNum1 != 0) {
			double x = userNum2 / userNum1;
			System.out.println(" ax=b, x=" + x);
		}

		else
			System.out.println("there is no solution to the equation");

		// question two - exercise 2

		int userNum3 = MyConsole.readInt("Enter a number");
		int sumOfNumber = 0;

		while (userNum3 != 0) {
			sumOfNumber += userNum3 % 10;
			userNum3 = userNum3 / 10;
		}

		System.out.println(" The sum of the numbers is:" + sumOfNumber);

		// question three - exercise 2

		int userNum4 = MyConsole.readInt("Enter a number");
		int count = 0;

		if (userNum4 == 0)
			count = 1;

		while (userNum4 != 0) {
			userNum4 = userNum4 / 10;
			count++;
		}

		System.out.println("The amount of numbers in the number is:" + count);

		// question four - exercise 2

		int userNum5 = MyConsole.readInt("Enter a number");
		int count2 = 0;

		if (userNum5 == 0)
			count2 = 1;

		while (userNum5 != 0) {
			if (userNum5 % 10 == 0)
				count2++;
			userNum5 = userNum5 / 10;
		}
		System.out.println(" the number of times 0 appears in the number is:" + count2);

		// question five - exercise 2

		int userNum6 = MyConsole.readInt("Enter a number");
		long sumFactorial = 1;

		for (int i = 1; i <= userNum6; i++)
			sumFactorial = sumFactorial * i;

		System.out.println("The factorial result is: " + sumFactorial);

		// question six - exercise 2

		int userNum7 = MyConsole.readInt("Enter a number (m)");
		int userNum8 = MyConsole.readInt("Enter a number (n)");
		int powerCount = 1;

		for (int i = 1; i <= userNum8; i++)
			powerCount = powerCount * userNum7;
		System.out.println("The power result is: " + powerCount);

		// question seven - exercise 2

		// didn't do it yet!

		// question eight & nine - exercise 2

		int userNum9 = MyConsole.readInt("Enter a number");
		int userNum10 = MyConsole.readInt("Enter a number");
		int userNum11 = MyConsole.readInt("Enter a number");

		int minNum = Math.min(userNum9, userNum10);
		minNum = Math.min(minNum, userNum11);

		int maxNum = Math.max(userNum9, userNum10);
		maxNum = Math.max(userNum11, maxNum);

		System.out.println("the minimum number is: " + minNum);
		System.out.println("the maximum number is: " + maxNum);

		// question one+ three i did above in the previous questions - exercise 3

		// question two - exercise 3

		int userNum13 = MyConsole.readInt("Enter a number");

		for (int i = 0; i < userNum13; i++) {
			for (int z = 0; z <= i; z++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// question four - exercise 3

		int userNum14 = MyConsole.readInt("Enter a number");
		int a1 = 0, a2 = 1;
		int sum = 0;
		for (int i = 1; i <= userNum14; i++) {
			System.out.print(a1 + " + ");
			sum = a1 + a2;
			a1 = a2;
			a2 = sum;

		}
		System.out.println("\nthe fibonacci number of the n place is:" + (a2 - a1));

		// question five - exercise 3

		int userNum15 = MyConsole.readInt("Enter a number");
		int max15 = 0; // initializing
		if (userNum15 == 0)
			System.out.println("there isnt numbers to compate to since u gave 0 options of numers");
		else {
			for (int i = 0; i < userNum15; i++) {
				int random15 = MyConsole.readInt("Enter a number");
				if (i == 0)
					max15 = random15;
				max15 = Math.max(max15, random15);
			}
			System.out.println("the max number is: " + max15);
		}

		// question six - exercise 3

		int userNum16 = MyConsole.readInt("Enter a number");
		int sum1 = 0;

		for (int i = 2; i < userNum16; i++) {
			if (userNum16 % i == 0)
				sum1 += i;
		}

		if (sum1 + 1 == userNum16)
			System.out.println("the number is a perfect number");
		else
			System.out.println("the number isn't a perfect number");

		// question seven - exercise 3

		// question one- exercise 4

		int saveBeforeSwitch;
		int n = MyConsole.readInt("enter an array length");
		int[] arraySwitch = new int[n];

		for (int i = 0; i < n; i++) // putting numbers into the array arraySwitch[i]
			arraySwitch[i] = MyConsole.readInt("enter a number");

		for (int i = 0; i < n; i++) // printing the array before the switch
			System.out.print(arraySwitch[i]);

		System.out.println(); // one line down to separate the array prints

		for (int rowFirst = 0; rowFirst < (n - 1) / 2; rowFirst++) {
			saveBeforeSwitch = arraySwitch[rowFirst];
			arraySwitch[rowFirst] = arraySwitch[n - 1 - rowFirst];
			arraySwitch[n - 1 - rowFirst] = saveBeforeSwitch;
		}

		for (int i = 0; i < n; i++) // printing the array after the switch
			System.out.print(arraySwitch[i]);

		// making an array to its transpose one

		int[][] arrayA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 } };
		int[][] arrayAT = new int[3][4];
		int[][] arrayR = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // 3X3

		for (int w = 0; w < arrayR.length; w++) // printing the 3X3 array before the change
			System.out.println(Arrays.toString(arrayR[w]));

		for (int k = 0; k < arrayR.length; k++) { // the 3X3 loop
			for (int j = 0; j < k; j++) {
				int switchSave = arrayR[k][j];
				arrayR[k][j] = arrayR[j][k];
				arrayR[j][k] = switchSave;
			}
		}

		System.out.println("");

		for (int w = 0; w < arrayR.length; w++) // printing the 3X3 array after the change
			System.out.println(Arrays.toString(arrayR[w]));

		System.out.println("");

		for (int i = 0; i < arrayA.length; i++) // printing the array before the transpose
			System.out.println(Arrays.toString(arrayA[i]));

		System.out.println("");

		for (int s = 0; s < arrayA.length; s++) { // the transpose loop
			for (int j = 0; j < arrayA[s].length; j++) {
				arrayAT[j][s] = arrayA[s][j];
			}
		}

		for (int b = 0; b < arrayAT.length; b++) // printing the array after the transpose
			System.out.println(Arrays.toString(arrayAT[b]));

		// for save

//		int count = 0, countIndex = 0;
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) != ' ') {
//				count++;
//				for (int j = i; j < str.length(); j++) {
//					if (str.charAt(j) == ' ')
//						break;
//					else
//						countIndex++;
//				}
//				i += countIndex;
//				countIndex = 0;
//			}
//		}

	}
}
