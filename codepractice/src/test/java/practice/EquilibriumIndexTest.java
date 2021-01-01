package practice;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EquilibriumIndexTest {

	@Test
	public void testForMultipleOutput() {
		int[] A = new int[8];
		A[0] = -1;
		A[1] = 3;
		A[2] = -4;
		A[3] = 5;
		A[4] = 1;
		A[5] = -6;
		A[6] = 2;
		A[7] = 1;

		int result = new EquilibriumIndex().solution(A, A.length);

		assertTrue(result == 1 || result == 3 || result == 7);
	}
	
	@Test
	public void testForZeroSum1() {
		int[] A = new int[3];
		A[0] = 1;
		A[1] = 2;
		A[2] = -2;

		int result = new EquilibriumIndex().solution(A, A.length);

		assertTrue(result == 0);
	}
	
	@Test
	public void testForZeroSum2() {
		int[] A = new int[4];
		A[0] = 1;
		A[1] = Integer.MAX_VALUE;
		A[2] = Integer.MIN_VALUE;
		A[3] = 1;

		int result = new EquilibriumIndex().solution(A, A.length);

		assertTrue(result == 0);
	}
	
	@Test
	public void testForNoOutput() {
		int[] A = new int[8];
		A[0] = 1;
		A[1] = 2;
		A[2] = 3;
		A[3] = 4;
		A[4] = 5;
		A[5] = 6;
		A[6] = 7;
		A[7] = 9;

		int result = new EquilibriumIndex().solution(A, A.length);

		assertTrue(result == -1);
	}
	
	@Test
	public void testForBigNumbers() {
		int[] A = new int[3];
		A[0] = Integer.MAX_VALUE;
		A[1] = 3;
		A[2] = Integer.MAX_VALUE;

		int result = new EquilibriumIndex().solution(A, A.length);

		assertTrue(result == 1);
	}

}
