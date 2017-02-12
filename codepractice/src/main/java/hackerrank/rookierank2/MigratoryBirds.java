package hackerrank.rookierank2;

import java.util.Scanner;

/**
 * A flock of birds is flying across the continent. Each bird has a type, and
 * the different types are designated by the ID numbers 1, 2, 3, 4, 5.
 * 
 * Given an array of integers where each integer describes the type of a bird in
 * the flock, find and print the type number of the most common bird.
 * 
 * If two or more types of birds are equally common, choose the type with the
 * smallest ID number.
 */
public class MigratoryBirds {

	/**
	 * 
	 * 
	 */
	public static void main(String[] args) {

		// The first line contains an integer denoting (the number of birds).
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		// The second line contains space-separated integers
		// describing the respective type numbers of each bird in the flock.
		int[] counts = { 0, 0, 0, 0, 0 };
		for (int types_i = 0; types_i < n; types_i++) {
			int current = in.nextInt();
			counts[current - 1]++;
		}

		// your code goes here
		int max = -1;
		int maxIndex = -1;
		for (int i = counts.length - 1; i >= 0; i--) {
			// System.out.println( (i+1) + ": " + counts[i]+ " ");
			if (counts[i] >= max) {
				maxIndex = i;
				max = counts[i];
			}
		}

		System.out.print(maxIndex + 1);

	}
}
