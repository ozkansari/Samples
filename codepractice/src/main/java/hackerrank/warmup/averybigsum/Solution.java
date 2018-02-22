package hackerrank.warmup.averybigsum;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 * 
 * @author ozkansari
 *
 */
public class Solution {

    static long aVeryBigSum(int countInput, long[] arrayNumbers) {
        long sum = 0;
        for (long number : arrayNumbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            int countInput = in.nextInt();
            long[] arrayNumbers = new long[countInput];
            for(int numIndex = 0; numIndex < countInput; numIndex++){
                arrayNumbers[numIndex] = in.nextLong();
            }
            long result = aVeryBigSum(countInput, arrayNumbers);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

