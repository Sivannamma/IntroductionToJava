
public class HugeNumber {
	String value = "";
	int numLength;
	int[] arr;

	public HugeNumber() { // default constructor
		arr = new int[10];
	}

	public HugeNumber(long num) { // constructor to initialize array
		int length = 0;
		long numBeforeChange = num;

		if (num < 0) {// setting +/-
			value = "-";
			num = Math.abs(num);
		} else
			value = "+";

		do { // counting how many space i need in the array
			length++;
			numBeforeChange = numBeforeChange / 10;
		} while (numBeforeChange != 0);

		arr = new int[length];

		for (int i = arr.length - 1; i >= 0; i--) { // initializing the arrays spots to the long num
			arr[i] = (int) (num % 10);
			num = num / 10;
		}

		numLength = length; // setting objects number length

	}

	public HugeNumber(HugeNumber other) { // copy constructor
		value = other.value;
		numLength = other.numLength;
		arr = other.arr;
	}

	public void add(HugeNumber num) { // sums up- two objects

		int max = Math.max(arr.length, num.arr.length);
		int[] arrSum = new int[max + 1];
		int length1 = arr.length - 1;
		int length2 = num.arr.length - 1;
		boolean flag = true;

		if ((value == "+" && num.value == "+") || (value == "-" && num.value == "-")) {
			// checking which array is longer ( number long) not array length, and if
			// someone is the longer, i copy the values into the array help

			// if they r both same, doesn't need to copy because they'll both be summed up
			// eventually.
			if (numLength > num.numLength) {
				for (int j = arrSum.length - 1; j >= 0 && flag == true; j--) {
					arrSum[j] = arr[length1];
					length1--;
					if (length1 < 0)
						flag = false;
				}
				flag = true;
			}

			else {
				for (int j = arrSum.length - 1; j >= 0 && flag == true; j--) {
					arrSum[j] = num.arr[length2];
					length2--;
					if (length2 < 0)
						flag = false;
				}
				flag = true;
			}

			// returning them to be that because i want to use this variables again
			length1 = arr.length - 1;
			length2 = num.arr.length - 1;

			if ((value == "+" && num.value == "+") || (value == "-" && num.value == "-")) {
				for (int i = arrSum.length - 1; i >= 0 && flag == true; i--) { // summing up to the array
					arrSum[i] = arr[length1] + num.arr[length2];
					length1--;
					length2--;
					if (length1 < 0 || length2 < 0)
						flag = false;
				}
				arr = arrSum; // changing the address to the array help
				value = num.value;
			}

			// making the array to be one digit in a spot after i summed it up above
			for (int i = arrSum.length - 1; i >= 0; i--) {
				if (arrSum[i] > 9) {
					arrSum[i] = arrSum[i] - 10;
					arrSum[i - 1]++;
				}
			}
			if (arrSum[0] == 0)
				numLength = arr.length - 1;
			else
				numLength = arr.length;
		}

		// -->

		if ((value == "+" && num.value == "-") || (value == "-" && num.value == "+")) {
			// checking which array is longer ( number long) not array length, and if
			// someone is the longer, i copy the values into the array help

			// if they r both same, doesn't need to copy because they'll both be summed up
			// eventually.
			if (numLength > num.numLength) {
				for (int j = arrSum.length - 1; j >= 0 && flag == true; j--) {
					arrSum[j] = arr[length1];
					length1--;
					if (length1 < 0)
						flag = false;
				}
				flag = true;
			}

			else {
				for (int j = arrSum.length - 1; j >= 0 && flag == true; j--) {
					arrSum[j] = num.arr[length2];
					length2--;
					if (length2 < 0)
						flag = false;
				}
				flag = true;
			}

			// -->

			if (value == "+" && num.value == "-") {
				if (numLength > num.numLength) {

					length1 = arr.length - 1;
					length2 = num.arr.length - 1;

					for (int i = arrSum.length - 1; i >= 0 && flag == true; i--) { // summing up to the array
						arrSum[i] = arr[length1] - num.arr[length2];
						length1--;
						length2--;
						if (length1 < 0 || length2 < 0)
							flag = false;
					}

					// making the array to be one digit in a spot after i summed it up above
					for (int i = arrSum.length - 1; i >= 0; i--) {
						if (arrSum[i] < 0) {
							arrSum[i] = arrSum[i] + 10;
							if (i != 0)
								arrSum[i - 1]--;
						}
					}

					if (arrSum[0] < 0) {
						value = "-";
						arrSum[0] = Math.abs(arr[0]);
					} else
						value = "+";

					numLength = arrSum.length;
					if (arrSum[0] == 0) {
						int j = 0;
						while (arrSum[j] == 0 && j < arrSum.length - 1) {
							numLength--;
							j++;
						}

					} else
						numLength = arrSum.length;
					arr = arrSum; // changing the adress
				}

				// -->

				else // (numLength <= num.numLength)
				{

					length1 = arr.length - 1;
					length2 = num.arr.length - 1;

					for (int i = arrSum.length - 1; i >= 0 && flag == true; i--) { // summing up to the array
						arrSum[i] = num.arr[length2] - arr[length1];
						length1--;
						length2--;
						if (length1 < 0 || length2 < 0)
							flag = false;
					}

					// making the array to be one digit in a spot after i summed it up above
					for (int i = arrSum.length - 1; i >= 0; i--) {
						if (arrSum[i] < 0) {
							arrSum[i] = arrSum[i] + 10;
							if (i != 0)
								arrSum[i - 1]--;
						}
					}

					numLength = arrSum.length;
					value = "-";
					if (arrSum[0] == 0) {
						int j = 0;
						while (arrSum[j] == 0 && j < arrSum.length - 1) {
							numLength--;
							j++;
						}

					} else
						numLength = arrSum.length;

					arr = arrSum; // changing the address to the array help
				}
			}

			// -->

			else // (value == "-" && num.value == "+")
			{
				if (numLength >= num.numLength) {

					length1 = arr.length - 1;
					length2 = num.arr.length - 1;

					for (int i = arrSum.length - 1; i >= 0 && flag == true; i--) { // summing up to the array
						arrSum[i] = num.arr[length2] - arr[length1];
						length1--;
						length2--;
						if (length1 < 0 || length2 < 0)
							flag = false;
					}

					// making the array to be one digit in a spot after i summed it up above
					for (int i = arrSum.length - 1; i >= 0; i--) {
						if (arrSum[i] < 0) {
							arrSum[i] = arr[i] + 10;
							if (i != 0)
								arrSum[i - 1]--;
						}
					}
					numLength = arrSum.length;
					value = "-";
					if (arrSum[0] == 0) {
						int j = 0;
						while (arrSum[j] == 0 && j < arrSum.length - 1) {
							numLength--;
							j++;
						}

					} else
						numLength = arrSum.length;
					arr = arrSum; // chaning the adress
				}

				// -->

				else // (numLength < num.numLength)
				{

					length1 = arr.length - 1;
					length2 = num.arr.length - 1;

					for (int i = arrSum.length - 1; i >= 0 && flag == true; i--) { // summing up to the array
						arrSum[i] = num.arr[length2] - arr[length1];
						length1--;
						length2--;
						if (length1 < 0 || length2 < 0)
							flag = false;
					}

					// making the array to be one digit in a spot after i summed it up above
					for (int i = arrSum.length - 1; i >= 0; i--) {
						if (arrSum[i] < 0) {
							arrSum[i] = arrSum[i] + 10;
							if (i != 0)
								arrSum[i - 1]--;
						}
					}
					value = "+";
					if (arrSum[0] == 0)
						numLength = arrSum.length - 1;
					else
						numLength = arrSum.length;

					arr = arrSum; // changing the address to the array help
				}
			}
		}
	}

	public void add(long num) { // sums up- object and a number
		HugeNumber longNum = new HugeNumber(num);
		add(longNum);
	}

	public void mult(HugeNumber num) { // multiplying- two objects
		int length = num.numLength + numLength;
		int[] multArr = new int[length];

		// multiplying the numbers into the array
		if (numLength > num.numLength)
			for (int k = arr.length - 1; k >= 0; k--) {
				for (int r = num.arr.length - 1; r >= 0; r--) {
					if (length != 0) {
						multArr[length - 1] += arr[k] * num.arr[r];
						length--;
					}
				}
				if (num.arr.length != 1)
					length = length + 1;
			}
		/////////////
		else {

			for (int r = num.arr.length - 1; r >= 0; r--) {
				for (int t = arr.length - 1; t >= 0; t--) {

					if (length != 0) {
						multArr[length - 1] += arr[t] * num.arr[r];
						length--;
					}
				}
				if (arr.length != 1)
					length = length + 1;
			}
		}
		int temp;
		// making the array to be one digit in a spot after i summed it up above
		for (int i = multArr.length - 1; i >= 0; i--) {
			if (multArr[i] > 9) {
				temp = multArr[i];
				multArr[i] = multArr[i] % 10;
				if (i != 0)
					multArr[i - 1] += temp / 10;
			}
		}
		arr = multArr; // changing the address to the array help

		// choosing what value goes into the array after the multiplying
		if (value == "-" && num.value == "-")
			value = "+";
		else if ((value == "-" && num.value == "+") || (value == "+" && num.value == "-"))
			value = "-";
		else if (value == "+" && num.value == "+")
			value = "+";

		int i = 0;
		while (multArr[i] == 0 && i < multArr.length - 1 && multArr.length != 1)
			i++;
		numLength = multArr.length - i;

	}

	public static boolean isBigger(HugeNumber n1, HugeNumber n2) { // which one is greater

		if (n1.value == "-" && n2.value == "+")// if one is + and one is - ;
			return false;

		if (n1.value == "+" && n2.value == "-")// if one is + and one is - ;
			return true;

		if (n1.value == "+" && n2.value == "+") { // if both are +
			if (n1.numLength > n2.numLength) // if one num length is greater than the other, that one is bigger
				return true;
			if (n1.numLength < n2.numLength)
				return false;
		}

		if (n1.value == "-" && n2.value == "-") { // if both are -
			if (n1.numLength < n2.numLength) // if one num length is greater, the *other* num is bigger
				return true;
			if (n1.numLength > n2.numLength)
				return false;
		}
		// if we reached so far, it means they're both same +/-, and same length
		int i = 0, j = 0;
		if (n2.arr.length > n2.numLength) {
			j = (n2.arr.length) - (n2.numLength); // making j be the number that the actual num starts of
		}
		if (n1.arr.length > n1.numLength) {
			i = (n1.arr.length) - (n1.numLength); // making i be the number that the actual num starts of
		}

		for (int t = 0; t < n1.numLength; t++) {
			if (n1.arr[i] > n2.arr[j]) {
				if (n1.value == "+")
					return true;
				else
					return false;
			}

			if (n1.arr[i] < n2.arr[j]) {
				if (n2.value == "+")
					return false;
				else
					return true;
			}
			i++;
			j++;
		}

		return true; // default return

	}

	public String toString() { // to string
		int i = 0;
		String toString = "";
		if (arr.length > numLength) {
			i = arr.length - numLength;
		}
		for (int j = i; j < arr.length; j++)
			toString += "" + arr[j];

		return value + toString;
	}

}
