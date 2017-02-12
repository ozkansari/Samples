package hackerrank.warmup.solveme;

import java.util.Scanner;

public class Solution {

	private static int solveMeFirst(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		
		// Get input
		Scanner in = new Scanner(System.in);
		int input1 = in.nextInt();
		int input2 = in.nextInt();
		in.close();
		
		// Calculate result
		int sum = solveMeFirst(input1, input2);
		
		// Display result
		System.out.println(sum);
	}
}


