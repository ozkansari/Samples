package hackerrank.warmup.plusminus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 * 
 * @author ozkansari
 *
 */
public class Solution {

    /**
     * Given an array of integers, calculate the fractions of its elements that are positive, negative, and are zeros. 
     * Print the decimal value (scaled to six decimal places) of each fraction on a new line
     * 
     * @param arr
     */
    static void plusMinus(int[] arr) {

    	int countPositive = 0;
    	int countNegative = 0;
    	int countZeros = 0;
    	
    	int totalCount = arr.length;
    	for (int n : arr) {
			if (n > 0) {
				countPositive++;
			} else if (n < 0) {
				countNegative++;
			} else if (n == 0) {
				countZeros++;
			}
		}
    	
    	/*
    	DecimalFormat df = new DecimalFormat("#.######");
    	df.setRoundingMode(RoundingMode.CEILING);
    	System.out.println(df.format((double)countPositive/totalCount));
    	System.out.println(df.format((double)countNegative/totalCount));
    	System.out.println(df.format((double)countZeros/totalCount));
    	*/
    	
    	System.out.println(String.format("%.6g",(double)countPositive/totalCount));
    	System.out.println(String.format("%.6g",(double)countNegative/totalCount));
    	System.out.println(String.format("%.6g",(double)countZeros/totalCount));

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}

