package hackerrank.warmup.sherlockAndQueries;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author ozkans
 *
 * Sherlock and Queries: https://www.hackerrank.com/challenges/sherlock-and-queries
 * 
 */
public class Solution {

	/**
	 * 0: no debug, 1: random, 2: file
	 */
	private static int DEBUG_MODE = 1;
	
	private static Scanner in = null;
	
	private static PrintWriter out = null;
	
	private static long startTime;
	
	private static long endTime;
	
	/**
	 * @param a array A, 1 ≤ A[i] ≤ 10^5
	 * 
	 * @param b array B, 1 ≤ B[i] ≤ N ≤ 10^5
	 * 
	 * @param c array C, 1 ≤ C[i] ≤ 10^5
	 * 
	 * @param n length of a, 1 ≤ N ≤ 10^5
	 * 
	 * @param m length of B and C,  1 ≤ M ≤ 10^5
	 * 
	 * @return resulted a
	 * 
	 */
	private int[] calculate(int[] a, int[] b, int[] c, int n, int m) {

		Map<String, Integer> multiplicationCache = new HashMap<String, Integer>();
		
		int max =  1000000007; // (int) (Math.pow(10, 9)+7)
		
		int cacheCount = 0;
		
		// for i = 1 to M do
		for (int i = 0; i < m; i++) {
			
			// for j = 1 to N do
			for (int j = 0; j < n; j++) {
				
				// if j % B[i] == 0 then
		        if( b[i] != 0 && (j+1) % b[i] == 0 ) {
		        	
		        	String key = String.valueOf(i).concat(String.valueOf(a[j]));
					if(multiplicationCache.containsKey( key )) {
						a[j] = multiplicationCache.get(key).intValue();
						cacheCount++;
		        	} else {
			        	// a[j] = a[j] * c[i]
						a[j] = (int) (( (long)(a[j]) * (long)(c[i]) ) % max);
						multiplicationCache.put(key, a[j]);
		        	}
		        }
			}
		}
		
		if (DEBUG_MODE>0) {
			out.println(cacheCount);
		}
		
		return a;
	}
	
	/**
	 * NOTE: Max int 10^9+7
	 * @param args
	 */
	public static void main(String[] args) {

		start();
		
		// 1 ≤ N ≤ 10^5
		int n = in.nextInt();
		
		// 1 ≤ M ≤ 10^5
		int m = in.nextInt();
	
		// The next line contains N integers, the elements of array A.
		// 1 ≤ A[i] ≤ 10^5
		int [] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		// The next line contains M integers, the elements of array B.
		// 1 ≤ B[i] ≤ N ≤ 10^5
		int [] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
		
		// The next line contains M integers, the elements of array C.
		// C[i] ≤ 10^5
		int [] c = new int[m];
		for (int i = 0; i < m; i++) {
			c[i] = in.nextInt();	
		}
		
		// FIND SOLUTION
		int[] resultA = new Solution().calculate(a, b, c, n, m);
		
		// DISPLAY OUTPUT
		// Print N integers, the elements of array A after performing the program modulo (10^9+7).
		for (int i = 0; i < n; i++) {
			out.print(resultA[i]);
			if (i != n - 1)
				out.print(" ");
		}
		
		end();
	}

	/**
	 * Should be called at start
	 */
	private static void start() {
		initInput();
		initOutput();
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * Should be called at the end
	 */
	private static void end() {
		endTime = System.currentTimeMillis();
		if (DEBUG_MODE>0) {
			out.println("");
			out.println(endTime - startTime + " ms");
		}
		in.close();
		out.close();
	}

	/**
	 * Utility function to initialize input
	 */
	private static void initInput() {
		
		if (DEBUG_MODE>0) {
			
			// From input file
			if(DEBUG_MODE==2) {
				try {
					in = new Scanner( new BufferedReader( new FileReader("input.txt") ) );
				} catch (FileNotFoundException e) {
					DEBUG_MODE=1;
				}
			}
			
			// Random
			if(DEBUG_MODE==1) {
				int n = 100000, m = 99999;
				Random gen = new Random();
				StringBuilder sb = new StringBuilder();
				sb.append(n + " ");
				sb.append(m + " ");
				for (int i = 0; i < n; i++) {
					sb.append(gen.nextInt(200000) + " ");
				}
				for (int i = 0; i < m; i++) {
					sb.append(gen.nextInt(200000) + " ");
				}
				for (int i = 0; i < m; i++) {
					sb.append(gen.nextInt(200000) + " ");
				}
				in = new Scanner(new ByteArrayInputStream(sb.toString().getBytes()));
			}

		} else {
			in = new Scanner(System.in);
		}
	}
	
	/**
	 * Utility function to initialize output
	 */
	private static void initOutput() {
		if (DEBUG_MODE>0) {
			try {
				out = new PrintWriter("output.txt", "UTF-8");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {
			out = new PrintWriter(System.out);
		}
	}
	
}
