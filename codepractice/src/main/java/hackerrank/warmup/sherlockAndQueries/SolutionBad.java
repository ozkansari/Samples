package hackerrank.warmup.sherlockAndQueries;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author ozkans
 *
 * Sherlock and Queries: https://www.hackerrank.com/challenges/sherlock-and-queries
 * 
 */
public class SolutionBad {

	private static final BigInteger MAX_INT = new BigInteger("1000000007");
	
	private static final boolean DEBUG = true;
	
	private static Scanner in = null;
	
	private static PrintWriter out = null;
	
	/**
	 * @param a array A, 1 ≤ A[i] ≤ 10^5
	 * @param b array B, 1 ≤ B[i] ≤ N ≤ 10^5
	 * @param c array C, 1 ≤ C[i] ≤ 10^5
	 * @param n length of a, 1 ≤ N ≤ 10^5
	 * @param m length of B and C,  1 ≤ M ≤ 10^5
	 * 
	 * @return resulted a
	 * 
	 */
	private BigInteger[] calculate(BigInteger[] a, int[] b, BigInteger[] c, int n, int m) {

		// for i = 1 to M do
		for (int i = 0; i < m; i++) {
			
			// for j = 1 to N do
			for (int j = 0; j < n; j++) {
				
				// if j % B[i] == 0 then
		        if( b[i] != 0 && (j+1) % b[i] == 0 ) {
		        	
		        	// a[j] = a[j] * c[i]
		        	// a = (a * c) % max  = ( ( a % max ) * ( c % max ) ) % max
					a[j] = a[j].mod(MAX_INT).multiply( (c[i].mod(MAX_INT) ) ).mod(MAX_INT);
					
		        }
			}
		}
		
		return a;
	}
	
	/**
	 * NOTE: Max int 10^9+7
	 * @param args
	 */
	public static void main(String[] args) {
		
		// DEBUG START ---------------
		long startTime = System.currentTimeMillis();
		initInput();
		initOuput();

		// 1 ≤ N ≤ 10^5
		int n = in.nextInt();
		
		// 1 ≤ M ≤ 10^5
		int m = in.nextInt();
	
		// The next line contains N integers, the elements of array A.
		// 1 ≤ A[i] ≤ 10^5
		BigInteger [] a = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextBigInteger();
		}
		
		// The next line contains M integers, the elements of array B.
		// 1 ≤ B[i] ≤ N ≤ 10^5
		int [] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}
		
		// The next line contains M integers, the elements of array C.
		// C[i] ≤ 10^5
		BigInteger [] c = new BigInteger[m];
		for (int i = 0; i < m; i++) {
			c[i] = in.nextBigInteger();	
		}
		
		// FIND SOLUTION
		BigInteger[] resultA = new SolutionBad().calculate(a, b, c, n, m);
		
		// DISPLAY OUTPUT
		// Print N integers, the elements of array A after performing the program modulo (10^9+7).
		for (int i = 0; i < n; i++) {
			out.print(resultA[i]);
			if (i != n - 1)
				out.print(" ");
			out.flush();
		}
				
		// DEBUG END -------------------
		if (DEBUG) {
			long endTime = System.currentTimeMillis();
			out.println("");
			out.println(endTime - startTime + " ms");
		}
		
		out.close();
	}

	/**
	 * Utility function to initialize input
	 */
	private static void initInput() {
		if (DEBUG) {
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
		} else {
			in = new Scanner(System.in);
		}
	}
	
	/**
	 * Utility function to initialize output
	 */
	private static void initOuput() {
		if (DEBUG) {
			try {
				out = new PrintWriter("sherlockAndQueriesOutput.txt", "UTF-8");
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
