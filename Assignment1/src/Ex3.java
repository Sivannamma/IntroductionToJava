
public class Ex3 {

	public static char[][] createWordSearch(int n, int m) { // function 1 to create an array with lower case letters

		if (n < 0 || m < 0) // conditions to input
			return null;

		char[][] arr = new char[n][m];
		for (int row = 0; row < n; row++) // goes over the rows
			for (int column = 0; column < m; column++) // goes over the columns
				arr[row][column] = (char) ((Math.random() * 26) + 97); // getting random number between 97-122 which are
																		// the lower case numbers
		return arr;
	}

	public static void arrayPrint(char arr[][]) { // printing an array

		if (arr == null) // if its null, it means the conditions of m/n aren't good (below 0)
			return;

		for (int row = 0; row < arr.length; row++) { // goes over the rows
			for (int column = 0; column < arr[row].length; column++) // goes over the columns
				System.out.print(arr[row][column] + " ");

			System.out.println();
		}
	}

	public static int wordHelpRow(String str, char arr[][]) { // help function to check the rows
		// this function return int so it can help me with other questions

		int count = 0;
		for (int row = 0; row < arr.length; row++) {
			for (int column = 0; column < arr[row].length - str.length() + 1; column++)
				if (str.charAt(0) == arr[row][column]) {

					for (int rowN = 0; rowN < str.length(); rowN++) {
						if (str.charAt(rowN) != arr[row][column + rowN])
							break;
						if (rowN == str.length() - 1)
							count++;
					}
				}
		}

		return count;
	}

	public static int wordHelpColumn(String str, char arr[][]) { // help function to check the column
		// this function return int so it can help me with other questions

		int count = 0;
		for (int row = 0; row < arr.length - str.length() + 1; row++) {
			for (int column = 0; column < arr[row].length; column++)
				if (str.charAt(0) == arr[row][column]) {

					for (int rowN = 0; rowN < str.length(); rowN++) {
						if (str.charAt(rowN) != arr[row + rowN][column])
							break;
						if (rowN == str.length() - 1)
							count++;
					}
				}
		}

		return count;
	}

	public static int wordHelpDiagonalLeft(String str, char arr[][]) { // help function to check the first side
		// this function return int so it can help me with other questions

		int count1 = 0; // diagonal
		int temp1, temp2;
		for (int row = 0; row < arr.length - str.length() + 1; row++) { // goes over the rows
			for (int column = 0; column < arr[row].length - str.length() + 1; column++) { // goes over the column
				temp1 = column; // saving temp
				temp2 = row; // saving temp
				if (str.charAt(0) == arr[row][column]) { // if u find one-enter to continue the word
					for (int count = 0; count < str.length(); count++) {
						if (str.charAt(count) != arr[row][column])
							break;
						else {
							row++; // +1 so it check the next char in the diagonal
							column++; // +1 so it check the next char in the diagonal
						}
						if (count == str.length() - 1) // if u check the whole word and not break, it contains
							count1++;
					}
				}
				column = temp1; // Initializing back to temp to keep searching from last point
				row = temp2; // Initializing back to temp to keep searching from last point
			}
		}

		return count1;
	}

	public static int wordHelpDiagonalRight(String str, char arr[][]) { // help function to check the second side
		// this function return int so it can help me with other questions
		int count1 = 0;
		int temp1, temp2;
		for (int row = 0; row < arr.length - str.length() + 1; row++) { // goes over the rows
			for (int column = arr[row].length - 1, i = 0; i < arr[row].length - str.length() + 1; i++, column--) { // goes
																													// over
																													// the
																													// column
				temp1 = column; // saving temp
				temp2 = row; // saving temp
				if (str.charAt(0) == arr[row][column]) { // if u find one-enter to continue the word
					for (int count = 0; count < str.length(); count++) {
						if (str.charAt(count) != arr[row][column])
							break;
						else {
							row++; // +1 so it check the next char in the diagonal
							column--; // -1 because we start from the end and one step before
						}
						if (count == str.length() - 1) // if u check the whole word and not break, it contains
							count1++;
					}
				}
				column = temp1; // Initializing back to temp to keep searching from last point
				row = temp2; // Initializing back to temp to keep searching from last point
			}
		}

		return count1;
	}

	public static boolean findWord(String str, char arr[][]) { // the main function that we call

		if (arr == null) // conditions to the input
			return false; // there isnt an array to check if the word is in it

		String strVers = stringVers(str); // the verse string, in order to check it too

// checking if str is contain in one of the row/column/diagonals 
		if (wordHelpRow(str, arr) + wordHelpColumn(str, arr) + wordHelpDiagonalLeft(str, arr)
				+ wordHelpDiagonalRight(str, arr) > 0) // if its greater than 0, means it contains
			return true;

// checking if str reveres (strVers) is contain in one of the row/column/diagonals 
		if (wordHelpRow(strVers, arr) + wordHelpColumn(strVers, arr) + wordHelpDiagonalLeft(strVers, arr)
				+ wordHelpDiagonalRight(strVers, arr) > 0) // if its greater than 0, means it contains
			return true;

		return false;
	}

	public static String stringVers(String srt) { // function to reveres the string\
		String strVers = "";
		for (int i = srt.length() - 1; i >= 0; i--)
			strVers += srt.charAt(i);
		return strVers;
	}

	public static boolean symmetrical(String str) { // checking if the function is symmetrical

		for (int i = 0; i < str.length() / 2; i++)
			if (str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		return true;
	}

	public static int countWord(String str, char arr[][]) { // counts how many times word appears

		if (arr == null) // conditions to input
			return 0; // Can't count a word if there isn't an array to count for

		int count = 0;
		String strVers = stringVers(str); // the verse string, in order to check it too

		if (!findWord(str, arr)) // if the function didn't find a word, no need to count, 0 times
			return 0;
		if (str.length() == 1) // if its a word with one char, i can go over one part on the matrix
			return wordHelpRow(str, arr);

		count = wordHelpRow(str, arr) + wordHelpColumn(str, arr) + wordHelpDiagonalLeft(str, arr)
				+ wordHelpDiagonalRight(str, arr); // counting how many regular str

		count += wordHelpRow(strVers, arr) + wordHelpColumn(strVers, arr) + wordHelpDiagonalLeft(strVers, arr)
				+ wordHelpDiagonalRight(strVers, arr); // counting how many strVers

		if (symmetrical(str)) // if its symmetrical its going to count it double time, so count/2
			return count / 2;
		else
			return count;
	}

	public static char[][] initGame(int heigth, int weidth, int mines) {

		if (heigth < 0 || weidth < 0 || mines < 0) // conditions of input
			return null;

		char[][] arrGame = new char[heigth][weidth];

		if (mines > weidth * heigth) {
			for (int row = 0; row < arrGame.length; row++) {
				for (int column = 0; column < arrGame[row].length; column++) {
					arrGame[row][column] = '*';
				}
			}
			arrayPrint(arrGame); // printing the array
			return arrGame;
		}

		sendMine(arrGame, mines); // sending to place mines inside
		insertV(arrGame); // insert the '-' value
		placingThreats(arrGame);

		arrayPrint(arrGame); // printing the array

		return arrGame;
	}

	public static void placeMine(char[][] arrGame) {
		int row, column;
		do {
			row = (int) (Math.random() * (arrGame.length));
			column = (int) (Math.random() * (arrGame[row].length));
		} while (arrGame[row][column] == '*'); // if it already has a mine there, continue to get a new spot

		arrGame[row][column] = '*';
	}

	public static void sendMine(char[][] arrGame, int mines) {

		for (int i = 0; i < mines; i++) // calling the function mines times to place them
			placeMine(arrGame);
	}

	public static void insertV(char[][] arrGame) { // function to insert "-" where there isnt mine
		for (int row = 0; row < arrGame.length; row++) {
			for (int column = 0; column < arrGame[row].length; column++) {
				if (arrGame[row][column] != '*')
					arrGame[row][column] = '-';
			}
		}
	}

	public static char placingThreatsHelp(char[][] arrGame, int row, int column) {
		int count = 0;
		if (row > 0 && arrGame[row - 1][column] == '*') // above
			count++;

		if (row < arrGame.length - 1 && arrGame[row + 1][column] == '*') // below
			count++;

		if (column < arrGame[0].length - 1 && arrGame[row][column + 1] == '*') // right
			count++;

		if (column > 0 && arrGame[row][column - 1] == '*') // left
			count++;

		if (column > 0 && row > 0 && arrGame[row - 1][column - 1] == '*') // diagonal left looking up
			count++;

		if (column < arrGame[0].length - 1 && row < arrGame.length - 1 && arrGame[row + 1][column + 1] == '*') // diagonal
																												// left
																												// looking
																												// down
			count++;

		if (column < arrGame[0].length - 1 && row > 0 && arrGame[row - 1][column + 1] == '*') // diagonal right looking
																								// up
			count++;

		if (column > 0 && row < arrGame.length - 1 && arrGame[row + 1][column - 1] == '*') // diagonal right looking
																							// down
			count++;

		if (count == 0)
			return '-';
		else
			return (count + "").charAt(0);
	}

	public static void placingThreats(char[][] arrGame) {

		for (int row = 0; row < arrGame.length; row++) {
			for (int column = 0; column < arrGame[row].length; column++) {
				if (arrGame[row][column] == '-') {
					arrGame[row][column] = placingThreatsHelp(arrGame, row, column);

				}
			}
		}

	}

	public static void main(String[] args) {

		// question one :

		// numbers for the matrix
		int n = MyConsole.readInt("enter rows number");
		int m = MyConsole.readInt("enter column number");

		char[][] arr = createWordSearch(n, m); // calling the function to insert chars into the array

		arrayPrint(arr); // printing the array

		String str = MyConsole.readString("enter a string");

		System.out.println(findWord(str, arr)); // prints if a word contains
		System.out.println(countWord(str, arr)); // prints how many times word appears

		// question two :

		int heigth = MyConsole.readInt("enter heigth number");
		int weidth = MyConsole.readInt("enter weidth number");
		int mines = MyConsole.readInt("enter mines number");

		initGame(heigth, weidth, mines);

	}
}
