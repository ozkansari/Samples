package hackerrank.rookierank2;

import java.util.Scanner;

public class HackerRankInAString {
	private static final String TEST_STRING = "hackerrank";

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();

			// your code goes here

			System.out.println(checkString(s));
		}

		in.close();
	}

	protected static String checkString(String s) {

		int checkCharIndex = 0;
		char checkChar = TEST_STRING.charAt(checkCharIndex);

		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);

			if (currentChar == checkChar) {

				if (checkCharIndex == TEST_STRING.length() - 1) {
					return "YES";
				}

				checkCharIndex++;
				checkChar = TEST_STRING.charAt(checkCharIndex);
			}

		}

		return "NO";
	}
}
