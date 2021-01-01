package practice;
import java.util.Arrays;

class MissingInteger {
	
	/**
	 * Find the smallest positive integer that does not occur in a given sequence
	 * 
	 * O(n) or O(n*logn)
	 * 
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
		Arrays.parallelSort(A);
		
		if (A[A.length-1] <= 0) {
			return 1;
		}
		
		int expected = 1;
		for (int i = 0; i < A.length; i++) {
			
			// Ignore negatives and zero, because we need to find smallest missing positive number
			if (A[i] <= 0) {
				continue;
			}

			// Find missing positive integer
			if (A[i] != expected) {
				return expected;
			}
			
			// Check for same numbers
			if(i+1 < A.length && A[i+1] != A[i]) {
				expected++;
			}
		}
		return expected + 1;
	}
}
