package hackerrank.week29;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w29/challenges/almost-integer-rock-garden
 * 
 * @author ozkansari
 *
 */
public class AlmostIntegerRockGarden {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = 7; // in.nextInt();
        int y = 11; // in.nextInt();
        
        System.out.println(calculate(x,y));
    }

	/**
	 * 
	 * @param x first stone coord x -12<=x,y<=12
	 * @param y first stone coord y -12<=x,y<=12
	 * @return 11 lines, where each line contains two space-separated integers
	 *         describing the respective values of x and y for a stone's
	 *         location.
	 */
	private static String calculate(int x, int y) {
		StringBuilder sb = new StringBuilder();
		
		CoordinateCalculator calc = new CoordinateCalculator();
		
		return sb.toString();
	}
	
	private static class CoordinateCalculator {
		
		private double [][] possibleCoords;
		private static final double NOT_POSSIBLE = -1;
		
		public CoordinateCalculator(){
			possibleCoords = new double [25][25];
			// 3,4,5 triangle
			setPossibleCoord(3, 4, NOT_POSSIBLE);
			setPossibleCoord(-3, 4, NOT_POSSIBLE);
			setPossibleCoord(3, -4, NOT_POSSIBLE);
			setPossibleCoord(-3, -4, NOT_POSSIBLE);
			// 6,8,10 triangle
			setPossibleCoord(6, 8, NOT_POSSIBLE);
			setPossibleCoord(-6, 8, NOT_POSSIBLE);
			setPossibleCoord(6, -8, NOT_POSSIBLE);
			setPossibleCoord(-6, -8, NOT_POSSIBLE);
			// 9,12,15 triangle
			setPossibleCoord(9, 12, NOT_POSSIBLE);
			setPossibleCoord(-9, 12, NOT_POSSIBLE);
			setPossibleCoord(9, -12, NOT_POSSIBLE);
			setPossibleCoord(-9, -12, NOT_POSSIBLE);
			// 5,12,13 triangel
			setPossibleCoord(5, 12, NOT_POSSIBLE);
			setPossibleCoord(-5, 12, NOT_POSSIBLE);
			setPossibleCoord(5, -12, NOT_POSSIBLE);
			setPossibleCoord(-5, -12, NOT_POSSIBLE);
			
			calculateDistances();
		}
		
		public boolean isPossibleCoord(int x, int y) {
			if (x==0|| y==0) {
				return false;
			}
			return possibleCoords[x+12][y+12] != NOT_POSSIBLE;
		}
		
		private boolean setPossibleCoord(int x, int y, double value) {
			if(possibleCoords[x+12][y+12]==NOT_POSSIBLE) { // 16.97056274847714
				return false;
			} else {
				possibleCoords[x + 12][y + 12] = value;
				return true;
			}
		}
		
		private void calculateDistances(){
			for (int x = -12; x <= 12; x++) {
				for (int y = -12; y <= 12; y++) {
					double pow = Math.pow(x,2) + Math.pow(y,2);
					setPossibleCoord(x, y, Math.sqrt(pow) );
				}
			}
		}
		
		
	}
}
