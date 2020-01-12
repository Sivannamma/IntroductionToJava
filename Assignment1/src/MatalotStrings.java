
public class MatalotStrings {

	public static void main(String[] args) {

		// exercise 6- strings

		// 1:
		String user1 = MyConsole.readString("enter first string");
		String user2 = MyConsole.readString("enter second string");
		System.out.println("are the strings equals ? " + user1.contentEquals(user2) + "");

		// 2:
		boolean syFlag = true; // flag for symmetrical
		for (int i = 0; i < user1.length() / 2; i++)
			if (user1.charAt(i) != user1.charAt(user1.length() - i - 1))
				syFlag = false;
		System.out.println("is the string symmetrical? " + syFlag + "");

		// 3:
		String user1Vers = "";
		for (int i = user1.length() - 1; i >= 0; i--)
			user1Vers += user1.charAt(i);
		System.out.println("the string before the change: " + user1);
		System.out.println("the string after the change: " + user1Vers);

		// 4:
		int sum = 0;
		for (int i = 0; i < user1.length(); i++)
			if (user1.charAt(0) == user1.charAt(i))
				sum++;
		System.out.println("the first char: " + user1.charAt(0) + " contains in the string " + sum + " times");
		
		// 5:
		
		
		// 6:
		
		
		// 7:
		System.out.println(user1.toUpperCase().charAt(0)+user1.substring(1));
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
