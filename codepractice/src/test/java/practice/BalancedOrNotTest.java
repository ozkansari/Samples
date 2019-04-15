package practice;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Similar problems: 
//  https://www.hackerrank.com/challenges/balanced-brackets/problem
//  https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem?h_r=internal-search
//  https://www.geeksforgeeks.org/balanced-expression-replacement/
//  https://www.geeksforgeeks.org/minimum-number-of-bracket-reversals-needed-to-make-an-expression-balanced/
//  https://rosettacode.org/wiki/Balanced_brackets#Java_2

public class BalancedOrNotTest {

	// RULE: To balance a string, we can replace only > end character with <> at most maxReplacement times
	
	@Test
	public void test1() {
		String[] expressions = {"<>>", "<>>>", "<>>>", "<>><<>", "<>>>>"};
		int[] maxReplacements = {1, 2, 1, 5, 2};
		int [] result = BalancedOrNot.balancedOrNot(expressions, maxReplacements );
		assertEquals(5, result.length);
		assertEquals(1, result[0]);
		assertEquals(1, result[1]);
		assertEquals(0, result[2]);
		assertEquals(0, result[3]);
		assertEquals(0, result[4]);
	}
	
	@Test
	public void test2() {
		String[] expressions = {">>><", ">>>><", "><<>"};
		int[] maxReplacements = {2, 2, 2};
		int [] result = BalancedOrNot.balancedOrNot(expressions, maxReplacements );
		assertEquals(3, result.length);
		assertEquals(0, result[0]);
		assertEquals(0, result[1]);
		assertEquals(0, result[2]);
	}
	
	@Test
    public void test3() {
        String[] expressions = {"<<>>"};
        int[] maxReplacements = {2};
        int [] result = BalancedOrNot.balancedOrNot(expressions, maxReplacements );
        assertEquals(1, result.length);
        assertEquals(1, result[0]);
    }
	
	@Test
	  public void testBalancedOrNot_OK() {
	    assertArrayEquals("Question text samples (0)", new int[]{1, 1, 1, 0, 0, 0},
	        BalancedOrNot.balancedOrNot(new String[]{"<<>>", "<>", "<><>", ">>", "<<>", "><><"},
	            new int[]{0, 0, 0, 0, 0, 0}));
	    assertArrayEquals("Question text samples (1)", new int[]{1, 1, 1, 1, 0, 0},
	        BalancedOrNot.balancedOrNot(new String[]{"<<>>", "<>", "<><>", ">>", "<<>", "><><"},
	            new int[]{0, 0, 0, 2, 2, 2}));
	    assertArrayEquals("Sample (0)", new int[]{1, 0},
	        BalancedOrNot.balancedOrNot(new String[]{"<>>>", "<>>>>"}, new int[]{2, 2}));
	    assertArrayEquals("Sample (1)", new int[]{1, 0},
	        BalancedOrNot.balancedOrNot(new String[]{"<>", "<>><"}, new int[]{1, 0}));
	  }

	
}
