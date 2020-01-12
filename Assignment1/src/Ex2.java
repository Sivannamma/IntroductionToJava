
public class Ex2 {

	public static void main(String[] args) {

		int manueNum = Integer.parseInt(args[0]);
		boolean menueFlag = true;
		boolean Enter = false;

		while (menueFlag) {

			if (Enter) {
				manueNum = MyConsole.readInt("Enter a number to choose a program to perform:\n" + "1- Adding matrices\n"
						+ "2- The light bulbs problem\n" + "3- 'n-queens'\n" + "4- Matrix containing other matrix\n"
						+ "0- Exit the program \n");
			}

			Enter = true;

			switch (manueNum) {

			case 1: // Adding matrices

				int m = MyConsole.readInt("Enter matrice width size ");
				int n = MyConsole.readInt("Enter matrice length size");

				if (m <= 0 || n <= 0) // checking that the numbers are positive numbers
				{
					System.out.println("You entered a number that is not in the range\n ");
					break;
				}

				int[][] arrA = new int[n][m];
				int[][] arrB = new int[n][m];
				int[][] arrAB = new int[n][m];

				for (int row = 0; row < n; row++) // goes over the lines
				{
					for (int column = 0; column < m; column++) // goes over the column
					{
						arrA[row][column] = (int) (Math.random() * 51);
						arrB[row][column] = (int) (Math.random() * 51);
						arrAB[row][column] = arrA[row][column] + arrB[row][column];
					}
				}
				// printing matrice A

				System.out.println("matrice A: ");
				for (int row = 0; row < n; row++) // goes over the lines
				{
					for (int column = 0; column < m; column++) // goes over the column
					{
						System.out.print(arrA[row][column] + " ");
					}
					System.out.println("");
				}
				// printing matrice B

				System.out.println("matrice B: ");
				for (int row = 0; row < n; row++) // goes over the lines
				{
					for (int column = 0; column < m; column++) // goes over the column
					{
						System.out.print(arrB[row][column] + " ");
					}
					System.out.println("");
				}

				// printing matrice A+B

				System.out.println("matrice A+B: ");
				for (int row = 0; row < n; row++) // goes over the lines
				{
					for (int column = 0; column < m; column++) // goes over the column
					{
						System.out.print(arrAB[row][column] + " ");
					}
					System.out.println("");
				}
				break;

			case 2: // The light bulbs problem

				int bulbs = MyConsole.readInt("enter a number of bulbs");
				int peopleNum = MyConsole.readInt("enter a number of people");
				boolean[] arrBulbs = new boolean[bulbs]; // creating an array of the switches

				if (bulbs <= 0 || peopleNum <= 0) { // checking if the user entered positive numbers
					if (bulbs <= 0)
						System.out.println("You entered a number of bulbs that is not in the range\n");
					if (peopleNum <= 0)
						System.out.println("You entered a number of people that is not in the range\n");
					break;
				}
				for (int i = 0; i < bulbs; i++) {
					arrBulbs[i] = false;
				}
				for (int people = 1; people <= peopleNum; people++) { // runs over the num of people
					for (int i = 1; i <= bulbs; i++) { // runs over the bulbs number
						if (i % people == 0) { // checking the condition
							if (arrBulbs[i - 1] == true) // if bulb is already on- turn it off
								arrBulbs[i - 1] = false;
							else // if its off- turn in on
								arrBulbs[i - 1] = true;
						}
					}
				}

				// printing the bulbs that are turned on
				for (int i = 0; i < bulbs; i++) {
					if (arrBulbs[i] == true)
						System.out.print((i + 1) + " ");
				}

				break;

			case 3: // 'n-queens'

				boolean matFlag = true; // making a flag in order to see if there is two queen in the same row/column
				int nSize = MyConsole.readInt("Enter the matrix size");
				int queensNum = MyConsole.readInt("Enter number of queens");
				int[][] arrBoard = new int[nSize][nSize];
				int column, row;
				int sumRow = 0, sumColumn = 0, sumDiagonal1 = 0, sumDiagonal2 = 0, sumDiagonal3 = 0, sumDiagonal4 = 0;

				if (nSize <= 0 || queensNum <= 0 || queensNum > nSize * nSize) { // checking if the numbers r in the
																					// needed range
					if (nSize <= 0)
						System.out.println("You entered a size that is not in the range\n");

					if (queensNum <= 0)
						System.out.println("You entered queens number that is not in the range\n");

					if (queensNum > nSize * nSize) // if queens bigger than all board space, there wouldnt be enough
						// space to fit all the queens
						System.out.println("You need to enter queens number below: " + nSize * nSize + "\n");
					break;
				}

				for (int i = 0; i < queensNum; i++) // to place the queens randomly in the board
				{
					do {
						column = (int) (Math.random() * (nSize));
						row = (int) (Math.random() * (nSize));
					} while (arrBoard[row][column] == 1);

					arrBoard[row][column] = 1;
				}

				// printing the matrice (board game)

				System.out.println("The board game with the queens is:\n ");
				for (int boardR = 0; boardR < nSize; boardR++) // goes over the lines
				{
					for (int boardC = 0; boardC < nSize; boardC++) // goes over the column
					{
						System.out.print(arrBoard[boardR][boardC] + " ");
					}
					System.out.println("");
				}
				// checking for threats : (columns & rows)
				for (row = 0; row < nSize && matFlag == true; row++) // if the flag is flase we dont need to continue
				// the loops
				{
					for (column = 0; column < nSize; column++) {
						if (arrBoard[row][column] == 1)
							sumRow++;
					}

					for (column = 0; column < nSize; column++) {
						if (arrBoard[column][row] == 1)
							sumColumn++;
					}

					for (column = row; column < nSize; column++) // checking for threats : (diagonals one side)
					{
						if (arrBoard[column - row][column] == 1)
							sumDiagonal1++;
					}

					for (column = row; column < nSize; column++) // checking for threats : (diagonals one side)
					{
						if (arrBoard[column][column - row] == 1)
							sumDiagonal2++;
					}

					for (column = 0; column <= row; column++) // checking for threats : (diagonals second side)
					{
						if (arrBoard[column][row - column] == 1)
							sumDiagonal3++;
					}

					for (column = row; column <= nSize - 1; column++) // checking for threats : (diagonals second side)
					{
						if (arrBoard[column][nSize - column + row - 1] == 1)
							sumDiagonal4++;
					}

					if (sumRow > 1 || sumColumn > 1 || sumDiagonal1 > 1 || sumDiagonal2 > 1 || sumDiagonal3 > 1
							|| sumDiagonal4 > 1)
						matFlag = false;

					sumRow = 0;
					sumColumn = 0;
					sumDiagonal1 = 0;
					sumDiagonal2 = 0;
					sumDiagonal3 = 0;
					sumDiagonal4 = 0;
				}

				if (matFlag == false)
					System.out.println("is there a threat? yes!");
				else
					System.out.println("is there a threat? no!");
				break;

			case 4: // Matrix containing other matrix

				int[][] arrMat = new int[10][10];
				int[][] arrUser = new int[2][3];

				// loop to insert random numbers into the 10X10 array + printing them

				System.out.println("The random matrix:");
				for (int arrR = 0; arrR < 10; arrR++) // arrR- row of the arrMat
				{
					for (int arrC = 0; arrC < 10; arrC++) // arrC- column of the arrMat
					{
						arrMat[arrR][arrC] = (int) (Math.random() * 20 + 1);
						System.out.print(" \t" + arrMat[arrR][arrC]);
					}
					System.out.println();
				}

				// loop to insert number from the user to the 2X3 loop

				int i = 1; // for printing to the user in which number he is entering
				for (int arrR = 0; arrR < 2; arrR++) // arrR- row of arrUser
				{
					for (int arrC = 0; arrC < 3; arrC++) // arrC- column of arrUser
					{
						arrUser[arrR][arrC] = MyConsole.readInt("enter the " + i + " number into the matrix");

						while (arrUser[arrR][arrC] > 20 || arrUser[arrR][arrC] <= 0) // checking that the number is in
							// the range
							arrUser[arrR][arrC] = MyConsole.readInt("re-enter a number from 1-20");
						i++;
					}
				}

				// printing the user matrix

				System.out.println("The matrix you entered:");
				for (int arrR = 0; arrR < 2; arrR++) // arrR- row of arrUser
				{
					for (int arrC = 0; arrC < 3; arrC++) // arrC- column of arrUser
					{
						System.out.print(" \t" + arrUser[arrR][arrC]);

					}

					System.out.println();
				}

				// checking if the user matrix contains in the random matrix

				boolean matFlagC = false;
				int sumLine1 = 0, sumLine2 = 0;
				for (int arrR = 0; arrR < 10 && matFlagC == false; arrR++) // arrR- row of the arrMat
				{
					for (int arrC = 0; arrC < 10 && matFlagC == false; arrC++) // arrC- column of the arrMat
					{
						if (arrMat[arrR][arrC] == arrUser[0][0] && arrR < 9 && arrC < 8) { // searching for the first
							// time
							// the number matches
							for (int j = 0; j < 3; j++, arrC++) { // continue to check to the next number
								if (arrMat[arrR][arrC] == arrUser[0][j]) // first row
									sumLine1++; // sums it up if the number match for the 1row
								if (arrMat[arrR + 1][arrC] == arrUser[1][j]) // second row
									sumLine2++; // sums it up if the number match for the 2row
							}
							if (sumLine1 == 3 && sumLine2 == 3) // if equals to 3 it means the arrays matches
								matFlagC = true; // if it match, we flag so no need to continue the loops
							else { // if not equals, initialize back to zero to start counting again
								sumLine1 = 0;
								sumLine2 = 0;
							}
						}
					}
				}
				if (sumLine1 == 3 && sumLine2 == 3)
					System.out.println("the random matrix contains the user matrix");
				else
					System.out.println("the random matrix does not contain the user matrix");

				break;

			default: // Exit the program
				System.out.println("bye-bye");
				menueFlag = false;
			}
		}
	}
}
