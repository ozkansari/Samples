package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

import static leetcode.KthMissingPositiveNumber.*;

public class KthMissingPositiveNumberTest {

	private Solution fixture = new Solution2();
	
	@Test
	public void test1() {
		
		// Given
		int k = 5;
		int [] arr = { 2,3,4,7,11 };
		
		// When
		int actual = fixture.findKthPositive(arr, k);
		
		// Then
		assertEquals(9, actual);
	}
	
	@Test
	public void test2() {
		
		// Given
		int k = 2;
		int [] arr = { 1,2,3,4 };
		
		// When
		int actual = fixture.findKthPositive(arr, k);
		
		// Then
		assertEquals(6, actual);
	}
	
	@Test
	public void test3() {

		// Given
		int k = 16;
		int [] arr = { 8,17,23,34,37,42};
		
		// When
		int actual = fixture.findKthPositive(arr, k);
		
		// Then
		assertEquals(18, actual);
	}
	

}
