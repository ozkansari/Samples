package hackerrank.rookierank2;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifferenceInAnArray {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		// your code goes here

		Arrays.sort(a); // nlogn
		int min = 0;
		for (int i = 1; i < n; i++) { // n

			int abs = Math.abs(a[i] - a[i - 1]);

			if (i == 1) {
				min = abs;
				continue;
			}

			if (abs < 1) {
				min = 0;
				break;
			}

			if (abs < min) {
				min = abs;
			}
		}

		System.out.println(min);
	}
}
