import java.util.Arrays;

public class Ex4 {

	public static String mostFrequentWord(String str) { // finding the frequent word
		if (str == "") // if the string is empty, return an empty string.
			return str; // which is the string itself.

		String strValue = ""; // making a string to insert the most times a string appears
		String[] part = splitString(str); // splitting the string
		int[] arrH = new int[part.length - 1]; // array to help count the amount a word appears
		int count = 0; // initializing

		// counts how many time word appears and insert to array help
		for (int indexH = 0; indexH < arrH.length && part[indexH] != null; indexH++) { // if a space is null dont
			// continue checking
			for (int i = 0; i < part.length && part[i] != null; i++) {
				if (part[indexH].contentEquals(part[i])) { // if a word equals to another count ++
					count++;
					arrH[indexH] = count;
				}
			}
			count = 0;
		}
		int max = 1;

		// searching in the array help which appears most
		for (int i = 0; i < arrH.length; i++) {
			if (arrH[i] > max) // if the arrH value greater, save the value of the word
				strValue = part[i];
			max = Math.max(arrH[i], max);
		}

		return strValue;
	}

	public static String[] splitString(String str) { // split function

		int count = 0, j = 0;
		boolean enter = true; // boolean for the spaces while loop

		for (int i = 0; i < str.length(); i++) { // loop to check how many space in array u need.
			if (str.charAt(i) == ' ')
				count++;
		}

		String[] arrS = new String[count + 1]; // creating the array for the split words

		while (str.length() != 0) {
			while (enter) { // while the is still spaces, continue to delete
				if (str.charAt(0) == ' ') {
					if (str.length() == 1)
						return arrS;
					else // if no more spaces, exit the mini while
						str = str.substring(1, str.length());
					count--; // minus because every time we delete a space, we want to know when its 0.
				} else
					break;
			}
			if (count == 0) { // if we deleted all the space, the last word goes into the array
				arrS[j] = str.substring(0, str.length());
				return arrS; // return because we finished the spaces
			} else { // else - insert to the array the word until the first space occurs
				arrS[j] = str.substring(0, str.indexOf(" "));
				str = str.substring(str.indexOf(" "), str.length());
			}
			j++; // to insert to the next space in the array
			enter = true;
		}
		return arrS;
	}

	public static int sumNumbersInText(String str) {
		return sumNumberHelper(str, 0, 0, 0);
	}

	public static int sumNumberHelper(String str, int sum, int sumHelp, int index) {
		if (str == null || index >= str.length()) // if its empty, or finished going over the string
			return sum + sumHelp;

		if (str.charAt(index) >= '0' && str.charAt(index) <= '9') // if its a number - calling again and if next a
																	// number
																	// too it *10
			return sumNumberHelper(str, sum, sumHelp * 10 + Integer.parseInt(str.charAt(index) + ""), ++index);
		else // if not a number, updating sum, and returning sumHelp to 0
			return sumNumberHelper(str, sum + sumHelp, 0, ++index);
	}

	public static int sumHelperArray(int[] arr, int sum, int i) { // sums up the numbers in the array
		if (i == arr.length)
			return sum;

		return sumHelperArray(arr, sum + arr[i], ++i);
	}

	public static void sortArraysBySum(int[][] arr) { // bubble sort
		int[] temp; // temp array to save the switch
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (sumHelperArray(arr[j], 0, 0) > sumHelperArray(arr[j + 1], 0, 0)) {// if arr[j]<[arr[j+1] we swap
																						// between their places
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		// part one
		String test = "sivani loves amirush    sivani loves        loves";
		System.out.println("the word that appears the most in the string is: " + mostFrequentWord(test));

		// part two
		String str = "12\12";
		System.out.println(sumNumbersInText(str));

		// part three
		int[][] arr = { { 1, 2, 2, 3 }, { 1, 5 }, { 1 }, };
		System.out.println(Arrays.deepToString(arr)); // prints before the change
		sortArraysBySum(arr);
		System.out.println(Arrays.deepToString(arr)); // prints after the change
	}
}
