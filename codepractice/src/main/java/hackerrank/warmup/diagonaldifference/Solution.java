package hackerrank.warmup.diagonaldifference;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * @author ozkans
 * 
 * Diagonal Difference: https://www.hackerrank.com/challenges/diagonal-difference/problem
 *
 */
public class Solution {

    /**
     * Calculate the absolute difference between the sums of its diagonals : |right-left|
     * 
     * @param squareMatrix square matrix: an array of integers. -100 < aij < 100
     * @return absolute difference between the sums of the diagonals of the square matrix
     */
    static int diagonalDifference(int[][] squareMatrix) {

        int rightsum = 0;
        int leftsum = 0;
        int len = squareMatrix.length;
        for (int i = 0; i < len; i++) {
            rightsum += squareMatrix[i][i]; // 0,0 1,1 2,2
            leftsum += squareMatrix[i][len-i-1]; // 0,2 1,1 2,0
        }
        return Math.abs(rightsum-leftsum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // the number of rows and columns in the matrix
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

