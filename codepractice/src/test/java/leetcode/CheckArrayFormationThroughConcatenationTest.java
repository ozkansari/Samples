package leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import leetcode.CheckArrayFormationThroughConcatenation.Solution;

public class CheckArrayFormationThroughConcatenationTest {

	private Solution fixture = new CheckArrayFormationThroughConcatenation.Solution2();

	@Test
	public void testCanFormArray1() {
		int[] arr = { 12 };
		int[][] pieces = { { 1 } };
		boolean actual = fixture.canFormArray(arr, pieces);
		assertEquals(false, actual);
	}

	@Test
	public void testCanFormArray2() {
		int[] arr = { 85 };
		int[][] pieces = { { 85 } };
		boolean actual = fixture.canFormArray(arr, pieces);
		assertEquals(true, actual);
	}

	@Test
	public void testCanFormArray3() {
		int[] arr = { 15, 88 };
		int[][] pieces = { { 88 }, { 15 } };
		boolean actual = fixture.canFormArray(arr, pieces);
		assertEquals(true, actual);
	}

	@Test
	public void testCanFormArray4() {
		int[] arr = { 91, 4, 64, 78 };
		int[][] pieces = { { 78 }, { 4, 64 }, { 91 } };
		boolean actual = fixture.canFormArray(arr, pieces);
		assertEquals(true, actual);
	}

}
