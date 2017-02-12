package hackerrank.warmup.finddigits;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author ozkans
 *
 * Find Digits: https://www.hackerrank.com/challenges/find-digits
 *
 */
public class Solution {

	/**
	 * Main method to run solution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// GET INPUT
		Scanner in = new Scanner(System.in);
			
		// T :number of test cases , 1 <= T <= 15 
		int t = in.nextInt();
				
		// input T lines (each containing N)
		BigInteger [] numbers = new BigInteger[t];
		for (int i = 0; i < t; i++) {
			numbers[i] = in.nextBigInteger();
		}
		
		// Find solution
		int [] results = new Solution().calculate(t, numbers);
		
		// DISPLAY OUTPUT
		// For each test case print the number of positions in N 
		// where digits in that number exactly divides the number N in separate line.
		for (int i = 0; i < t; i++) {
			System.out.println(results[i]);
		}
	}

	/**
	 * You are given a number N, 0 < N < 10^10
	 * you need to print the number of positions where digits exactly divides N.
	 * 
	 * Note: Same digits repeated twice, should be counted twice.
	 * 
	 * @param t number of test cases , 1 <= T <= 15 
	 * @param numbers t numbers each containing N
	 * @return the result for each N: the number of positions where digits exactly divides N.
	 */
	private int[] calculate(int t, BigInteger [] numbers) {

		// check each N and store the results
		int [] results = new int[t];
		for (int i = 0; i < t; i++) {
			
			results[i] = 0;
			
			// check each digit
			String currentNum = numbers[i].toString();
			for (int digitIndex = 0; digitIndex < currentNum.length(); digitIndex++) {
				
				int currentBit = Character.getNumericValue( currentNum.charAt(digitIndex) );
				if (currentBit != 0) {
					results[i] += numbers[i].remainder(new BigInteger(String.valueOf( currentBit)) )==BigInteger.ZERO ? 1 : 0;
				}
				
			}
		}

		return results;
	}

}
