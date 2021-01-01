package practice;

import java.math.BigInteger;

public class EquilibriumIndex {

	/**
	 * Find an index in an array such that its prefix sum equals its suffix sum.
	 * 
	 * An array A consisting of N integers is given. An equilibrium index of this
	 * array is any integer P such that 0 <= P < N and the sum of elements of lower
	 * indices is equal to the sum of elements of higher indices, i.e.
	 * 
	 * @param A
	 * @param N
	 * @return
	 */
	int solution(int A[], int N) {
		
		if (N == 0) {
			return -1;
		}
		
		if (N == 1) {
			return 0;
		}
		
		for (int eqIdx = 0; eqIdx < A.length; eqIdx++) {
			
			BigInteger lesserSum = BigInteger.ZERO; 
			for (int lesserIdx = 0; lesserIdx < eqIdx; lesserIdx++) {
				lesserSum = lesserSum.add( BigInteger.valueOf( A[lesserIdx] ) );
			}
			
			BigInteger greaterSum = BigInteger.ZERO; 
			for (int greaterIdx = eqIdx+1; greaterIdx < A.length; greaterIdx++) {
				greaterSum = greaterSum.add( BigInteger.valueOf( A[greaterIdx] ) );
			}
			
			if (lesserSum.equals(greaterSum)) {
				return eqIdx;
			}
		}
		return -1;
	}
}
