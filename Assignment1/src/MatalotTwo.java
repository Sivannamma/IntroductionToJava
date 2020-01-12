
public class MatalotTwo {
	public static double ArraySum(int[] arr) {
		int sumArr = 0;
		for (int i = 0; i < arr.length; i++)
			sumArr += arr[i];

		return sumArr;
	}

	public static double ArrayAveg(int[] arr) {
		int avegArr = 0;
		for (int i = 0; i < arr.length; i++)
			avegArr += arr[i];

		return avegArr / arr.length;
	}

	public static double ArrayStdev(int[] arr) {
		double stNum = 0;
		for (int i = 0; i < arr.length; i++) {
			int[] arrH = new int[i + 1];
			for (int j = 0; j < arrH.length; j++) {
				arrH[j] = arr[i];
				stNum = stNum + ((arrH[i] - ArrayAveg(arrH)) * (arrH[i] - ArrayAveg(arrH)));
			}
		}
		return Math.sqrt(stNum) * 1 / arr.length;
	}

	public static boolean Palindrom(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != arr[arr.length - i - 1])
				return false;
		}
		return true;
	}

	public static void Reverse(int[] arr) {
		int transferH;
		for (int i = 0; i < arr.length / 2; i++) {
			transferH = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = transferH;
		}
	}

	public static void PrintArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void EvenOddSort(int[] arr) {
		int[] arrH = new int[arr.length];
		int j = 0; // index of the new array
		
		for (int i = 0; i < arr.length; i++) { 
			if (arr[i] % 2 == 0) { //checks if its even
				arrH[j] = arr[i];
				j++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) { 
			if (arr[i] % 2 != 0) { // checks if its odd
				arrH[j] = arr[i];
				j++;
			}
		}
		
		for (int i = 0; i < arr.length; i++) // insert the help array into the array that have been sent
			arr[i] = arrH[i];
	}

	public static void main(String[] args) {

		// functions

		int n = MyConsole.readInt("enter the length of the array");
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = MyConsole.readInt("enter a number");

		System.out.println("the sum of the numbers in the array is:" + ArraySum(arr));
		System.out.println("the average of the numbers in the array is:" + ArrayAveg(arr));
		System.out.println("the Stdev of the numbers in the array is:" + ArrayStdev(arr));
		System.out.println("the array is palindrom? " + Palindrom(arr) + "");
		
		System.out.println("the array before the change:"); 
		PrintArray(arr);
		System.out.println("the array after the change:");
		Reverse(arr);
		PrintArray(arr);

		System.out.println("the array before the change:");
		PrintArray(arr);
		System.out.println("the array after the change:");
		EvenOddSort(arr);
		PrintArray(arr);

	}
}
