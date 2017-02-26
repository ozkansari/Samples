package hackerrank.week29;

import hackerrank.SolutionHelper;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w29/challenges/a-circle-and-a-square
 * 
 * @author ozkansari
 *
 */
public class CircleAndSquare {

	/**
	 * 20 16 9 6 5 // Circle
	 * 
	 * 16 14 8 14
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		SolutionHelper.start();

		// GET INPUT
		// Scanner in = new Scanner(System.in);
		Scanner in = SolutionHelper.getIn();

		int w = in.nextInt();
		int h = in.nextInt();

		int circleX = in.nextInt();
		int circleY = in.nextInt();
		int r = in.nextInt();

		int x1 = in.nextInt();
		int y1 = in.nextInt();

		int x3 = in.nextInt();
		int y3 = in.nextInt();
		// your code goes here

		SolutionHelper.getOut().println(
				"w: " + w + ", h: " + h + ", circleX: " + circleX
						+ ", circleY: " + circleY + ", r: " + r + ", x1: " + x1
						+ ", y1: " + y1 + ", x3: " + x3 + ", y3: " + y3);

		SolutionHelper.getOut().println(
				calculate(w, h, circleX, circleY, r, x1, y1, x3, y3));

		SolutionHelper.end();

	}

	/**
	 * Print canvasHeight lines where each line contains canvasWidth characters. 
	 * Each character must be either a . (to denote a white pixel) 
	 * 	or a # (to denote a black pixel). 
	 * The first pixel of the first line of output corresponds to the top-left corner of the canvas.
	 * 
	 * @param canvasWidth canvas width 10 <= w <= 100
	 * @param canvasHeight canvas height 10 <= h <= 100
	 * @param circleCenterX circle center x -100 <= w <= 200
	 * @param circleCenterY circle center y -100 <= w <= 200
	 * @param r 0 <= w <= 100
	 * @param squareX1 -100 <= w <= 200
	 * @param squareY1 -100 <= w <= 200
	 * @param squareX3 -100 <= w <= 200
	 * @param squareY3 -100 <= w <= 200
	 * @return
	 */
	private static String calculate(int canvasWidth, int canvasHeight,
			int circleCenterX, int circleCenterY, int r, int squareX1,
			int squareY1, int squareX3, int squareY3) {
		StringBuilder sb = new StringBuilder();

		SquareChecker squareChecker = new SquareChecker(squareX1, squareY1,
				squareX3, squareY3);

		int x, y; // Coord inside the canvas

		for (int h = 0; h < canvasHeight; h++) {
			for (int w = 0; w < canvasWidth; w++) {

				x = h - (circleCenterY - r) - r;
				y = w - (circleCenterX - r) - r;
				boolean insideCircle = r != 0 && (x * x + y * y <= r * r);

				boolean insideSquare = squareChecker.isInsideSquare(w, h);

				if (insideCircle || insideSquare) {
					sb.append("#");
				} else {
					sb.append(".");
				}
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	/**
	 * Check if a given coordinate is inside the square or not
	 */
	private static class SquareChecker {

		int squareX1, squareY1;
		int squareX2, squareY2;
		int squareX3, squareY3;
		int squareX4, squareY4;

		/**
		 * @param squareX1
		 * @param squareY1
		 * @param squareX3
		 * @param squareY3
		 */
		public SquareChecker(int squareX1, int squareY1, int squareX3,
				int squareY3) {

			this.squareX1 = squareX1;
			this.squareY1 = squareY1;
            this.squareX3 = squareX3;
			this.squareY3 = squareY3;
            
			// Center point
			int sqCenterX = (squareX1 + squareX3) / 2;
			int sqCenterY = (squareY1 + squareY3) / 2;
			// Half-diagonal
			int sqDiagX = (squareX1 - squareX3) / 2;
			int sqDiagY = (squareY1 - squareY3) / 2;
			// Third corner
			squareX2 = sqCenterX - sqDiagY;
			squareY2 = sqCenterY + sqDiagX;
			// Fourth corner
			squareX4 = sqCenterX + sqDiagY;
			squareY4 = sqCenterY - sqDiagX;
		}

		/**
		 * 
		 * @param pX given coordinate X
		 * @param pY given coordinate Y
		 * @return if a given coordinate is inside the square or not
		 */
		public boolean isInsideSquare(int pX, int pY) {
			
			boolean corner = (pX == squareX1 && pY == squareY1)
					|| (pX == squareX2 && pY == squareY2)
					|| (pX == squareX3 && pY == squareY3)
					|| (pX == squareX4 && pY == squareY4);
			if (corner) {
				return true;
			}
			
            Vector x1x2 = new Vector(squareX1, squareY1, squareX2, squareY2);
			Vector x1p = new Vector(squareX1, squareY1, pX, pY);
			Vector x2x3 = new Vector(squareX2, squareY2, squareX3, squareY3);
			Vector x2p = new Vector(squareX2, squareY2, pX, pY);
			int linex1x2_x1p = line(x1x2, x1p);
			int linex1x2_x1x2 = line(x1x2, x1x2);
			int linex2x3_x2p = line(x2x3, x2p);
			int linex2x3_x2x3 = line(x2x3, x2x3);
			return 0 <= linex1x2_x1p && linex1x2_x1p <= linex1x2_x1x2 && 0 <= linex2x3_x2p
					&& linex2x3_x2p <= linex2x3_x2x3;
 
		}
	}

	private static class Vector {
		int x;int y;
		public Vector(int p1x, int p1y, int p2x, int p2y) {
			this.x = p2x-p1x; this.y = p2y-p1y;
		}
	}

	private static int line(Vector u, Vector v) {
		return u.x * v.x + u.y * v.y;
	}

}
