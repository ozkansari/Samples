

import java.util.*;
import java.io.*;

public class MaxPairwiseProduct {
    static long getMaxPairwiseProduct1(int[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product, Long.valueOf(numbers[first]) * Long.valueOf( numbers[second]));
            }
        }

        return max_product; 
    }
    
    static long getMaxPairwiseProduct2(int[] numbers) {
    	
    	if(numbers.length < 2) {
    		return -1;
    	}
    	Arrays.parallelSort(numbers);
    	return Long.valueOf(numbers[numbers.length-1]) * Long.valueOf( numbers[numbers.length-2]);
    }
    
    static long getMaxPairwiseProduct3(int[] numbers) {
        long biggestNum1 = 0;
        long biggestNum2 = 0;

        for (int i = 0; i < numbers.length; ++i) {
        	if (numbers[i] > biggestNum1) {
        		long temp = biggestNum1;
        		biggestNum1 = numbers[i];
        		if (temp > biggestNum2) {
    				biggestNum2 = temp;
    			}
			} else if (numbers[i] > biggestNum2) {
				biggestNum2 = numbers[i];
			}
        }

        return biggestNum1 * biggestNum2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct3(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                    InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
