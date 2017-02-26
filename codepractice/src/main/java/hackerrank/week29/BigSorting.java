package hackerrank.week29;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w29/challenges/big-sorting
 * 
 * @author e048482
 *
 */
public class BigSorting {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
			unsorted[unsorted_i] = in.next();
		}
		System.out.println(calculate(unsorted));
	}

	/**
	 * 
	 * @param unsorted string array containing very huge numbers
	 * @return numbers sorted and printed each line
	 */
	protected static String calculate(String[] unsorted) {

		StringBuilder sb = new StringBuilder();

		List<String> list = Arrays.asList(unsorted);

		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if (o1 instanceof String && o2 instanceof String) {
					String s_1 = (String) o1;
					String s_2 = (String) o2;

					if (s_1.length() > s_2.length()) {
						return 1;
					} else if (s_1.length() < s_2.length()) {
						return -1;
					} else {
						return s_1.compareTo(s_2);
					}

				}
				return 0;
			}
		});

		for (String numStr : list) {
			sb.append(numStr);
			sb.append("\n");
		}

		return sb.toString();
	}

}
