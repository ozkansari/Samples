package practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissingIntegerTest {

	@Test
	public void testSolutionWithOnlyPositives() {
		int A [] = { 1, 3, 6, 4, 1, 2 };
		
		int result = new MissingInteger().solution(A);
		
		assertEquals(5, result);
	}
	
	@Test
	public void testSolutionWithZeroAndPositives() {
		int A [] = { 0, 1, 2, 3 };
		
		int result = new MissingInteger().solution(A);
		
		assertEquals(4, result);
	}
	
	@Test
	public void testSolutionWithOnlyNegatives() {
		int A [] = { -1, -3, -20 };
		
		int result = new MissingInteger().solution(A);
		
		assertEquals(1, result);
	}
	
	@Test
	public void testSolutionWithNegatives() {
		int A [] = { -7, -12132323, -1, 3, 6, 4, 1, 2 };
		
		int result = new MissingInteger().solution(A);
		
		assertEquals(5, result);
	}

}
