package hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hackerrank.DivisableSumPairs.DivisableSumPairsNaiveSolution;
import hackerrank.DivisableSumPairs.DivisableSumPairsSolution;

public class DivisableSumPairsTest {

	DivisableSumPairsSolution fixture = new DivisableSumPairsNaiveSolution();
	
	@Test
	public final void test1() {
		
		int k = 3;
		int[] ar = {1, 3, 2, 6, 1, 2};
		int n = ar.length;

		int actual = fixture.divisibleSumPairs(n , k, ar);
		
		assertEquals(5, actual);
	}
	

}
