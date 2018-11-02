package hackerrank.warmup.staircase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 * 
 * @author ozkansari
 *
 */
public class Solution {

	private static final char SPACE_SYMBOL = ' ';
	private static final char STAIRCASE_SYMBOL = '#';
	
    // Complete the staircase function below.
    static void staircase(int n) {

    	for (int i = 1; i <= n; i++) {
    		
			String spaceFormat = "%"+(n-i)+"s"; // %3s for n=4,i=1
			if (n-i!=0) {
				System.out.print( String.format(spaceFormat, SPACE_SYMBOL));
			}
			
			String stairCaseFormat = "%"+(i)+"s"; // %1s for i=1
			System.out.println(String.format(stairCaseFormat, STAIRCASE_SYMBOL).replace(' ', STAIRCASE_SYMBOL));
		}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
