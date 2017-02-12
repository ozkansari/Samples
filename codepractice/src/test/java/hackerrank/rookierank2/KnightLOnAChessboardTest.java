package hackerrank.rookierank2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnightLOnAChessboardTest {

	@Test
	public void testKnightL_n5() {
		int n = 5;
		assertEquals(4, KnightLOnAChessboard.knightL(1,1,n));
		assertEquals(4, KnightLOnAChessboard.knightL(1,2,n));
		assertEquals(2, KnightLOnAChessboard.knightL(1,3,n));
		assertEquals(8, KnightLOnAChessboard.knightL(1,4,n));
		assertEquals(4, KnightLOnAChessboard.knightL(2,1,n));
		assertEquals(2, KnightLOnAChessboard.knightL(2,2,n));
		assertEquals(4, KnightLOnAChessboard.knightL(2,3,n));
		assertEquals(4, KnightLOnAChessboard.knightL(2,4,n));
		assertEquals(2, KnightLOnAChessboard.knightL(3,1,n));
		assertEquals(4, KnightLOnAChessboard.knightL(3,2,n));
		assertEquals(-1, KnightLOnAChessboard.knightL(3,3,n));
		assertEquals(-1, KnightLOnAChessboard.knightL(3,4,n));
		assertEquals(8, KnightLOnAChessboard.knightL(4,1,n));
		assertEquals(4, KnightLOnAChessboard.knightL(4,2,n));
		assertEquals(-1, KnightLOnAChessboard.knightL(4,3,n));
		assertEquals(1, KnightLOnAChessboard.knightL(4,4,n));
		
	}

	/**
	 * 6 4 4 8 2 12
	 * 4 3 4 2 16 3
	 * 4 4 2 4 4 4
	 * 8 2 4 -1 -1 -1
	 * 2 16 4 -1 -1 -1
	 * 12 3 4 -1 -1 1
	 */
	@Test
	public void testKnightL_n7() {
		int n = 7;
		
		int [] results0 = {6, 4, 4, 8, 2, 12};
		int [] results1 = {4, 3, 4, 2, 16, 3};
		int [] results2 = {4, 4, 2, 4, 4, 4};
		int [] results3 = {8, 2, 4, -1, -1, -1};
		int [] results4 = {2, 16, 4, -1, -1, -1};
		int [] results5 = {12, 3, 4, -1, -1, 1};
		
		int results [][] = new int [6][6];
		results[0] = results0;
		results[1] = results1;
		results[2] = results2;
		results[3] = results3;
		results[4] = results4;
		results[5] = results5;
		
		for (int i = 1; i < n; i++) { 
			for (int j = 1; j < n; j++) {
				int actual = KnightLOnAChessboard.knightL(i,j,n);
				System.out.println(i + "," + j + ": " + actual);
				
				assertEquals(results[i-1][j-1], actual);
			}
		}
		
		
	}
}
