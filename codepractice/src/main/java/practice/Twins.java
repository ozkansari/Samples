package practice;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Twins {
    
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static boolean[] twins(String[] a, String[] b) {
        boolean[] result = new boolean[a.length];

        int minIndex = Math.min(a.length, b.length);

        for (int i = 0; i < minIndex; i++) {
            String aHashed = calculateHash(a[i].toCharArray());
            String bHashed = calculateHash(b[i].toCharArray());
            result[i] = aHashed.equals(bHashed);
        }

        return result;
    }

    
    /**
     * Calculate hash values of string by storing 
     * the count of even and odd for each character of a string.
     * @param charsOfArray
     * @return
     */
    private static String calculateHash(char[] charsOfArray) {
        
        // Calculate how many times a char occurs in odd and even indexes
        int [] bucketOdd = new int[26];
        int [] bucketEven = new int[26];
        for (int j = 0; j < charsOfArray.length; j++) {
            if (j%2 != 0) {
                bucketOdd[charsOfArray[j] - 'a']++;
            } else {
                bucketEven[charsOfArray[j] - 'a']++;
            }
        }
        
        // Create hash from odd/even count values
        StringBuilder db = new StringBuilder();
        for (int j = 0; j < bucketOdd.length; j++) {
            db.append(bucketOdd[j]);
            db.append('.');
            db.append(bucketEven[j]);
        }
        return db.toString();
    }

    /*-
     * SOLUTION NOTE
     * 
     * To check if strings  are convertible to each other,
     * - First I tried summing int values of each char. 
     * It's good to falsify the check but does not guarantee twin check.
     *  
     * - Then I tried storing even/odd info of each char in the string. 
     * But this works only a letter exist once in string.
     * 
     * - Finally i decided to store hash values of string an compare them.
     */

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        /*
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine().trim());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }
        
        int m = Integer.parseInt(in.nextLine().trim());
        String[] b = new String[m];
        for(int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }
     */   
        
        String[] a = {"cdab", "dcba", "cdab", "aaab", "cadb"};
        String[] b = {"abcd", "abcd", "dcba", "abaa", "dbca"};
        
        // call twins function
        boolean[] results = twins(a, b);
        
        for(int i = 0; i < results.length; i++) {
            System.out.println(results[i]? "Yes" : "No");
        }
        
    }
}
