package hackerrank.wsprint3;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/womens-codesprint-3/challenges/the-
 * birthday-bar
 *
 */
public class BirthdayChocolate {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(); // 1 <= n <= 100
		int[] squares = new int[n];
		for (int squares_i = 0; squares_i < n; squares_i++) {
			squares[squares_i] = in.nextInt();
		}
		
		// Lily only wants to give Ron a piece of chocolate 
		// if it contains "ronBirthMonth" consecutive squares whose integers sum to "ronBirthDay".
		int d = in.nextInt(); // 1 <= d <= 31
		int m = in.nextInt(); // 1 <= m <= 12

		System.out.println(calculate(d, m, squares));
		
		in.close();
	}

	/**
	 * 
	 * @param ronBirthDay 1 <= d <= 31
	 * @param ronBirthMonth 1 <= m <= 12
	 * @param squares 1 <= squares.length <= 100
	 * @return
	 */
	protected static int calculate(int ronBirthDay, int ronBirthMonth,
			int[] squares) {
		int count = 0;
		for (int i = ronBirthMonth-1; i < squares.length; i++) {
			
			int currentSum = 0;
			for (int j = i-(ronBirthMonth-1); j <= i; j++) {
				currentSum += squares[j];
			}
			
			if( currentSum == ronBirthDay ) {
				count++;
			}
			
		}
		return count;
	}

}
