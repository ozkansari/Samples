package hackerrank.week30;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w30/challenges/find-the-minimum-number
 *
 */
public class FindMinimumNumber {

	private static final String BASE = "int";
	private static final String PATTERN = "min(int, x)";

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        System.out.println(calculate(n));
        
        in.close();
    }

	/**
	 * 
	 * @param n [2,50] the number of integers to be compared
	 * @return min(int, int) for 2
	 */
	protected static String calculate(int n) {
		String result = BASE;
		for (int i = 2; i <= n; i++) {
			result = PATTERN.replace("x", result);
		}
		return result;
	}
}
