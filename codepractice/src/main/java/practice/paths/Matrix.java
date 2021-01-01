package practice.paths;

// https://www.techiedelight.com/find-total-number-unique-paths-maze-source-destination/
// @see MatrixTest
public class Matrix {
		
	/**
	 * Available/Open position
	 */
	protected static final int AVAILABLE = 0, O = AVAILABLE;
	
	/**
	 * Closed/Blocked position
	 */
	protected static final int BLOCKED = 1, X = BLOCKED;

	/**
	 * Visited
	 */
	protected static final int VISITED = 2;
	
	/**
	 * Positions in the matrix
	 */
	private int positions[][];

	private int destinationX;
	
	private int destinationY;
	
	public Matrix(int[][] positions, int destinationX, int destinationY) {
		this.positions = positions;
		this.destinationX = destinationX;
		this.destinationY = destinationY;
	}


	/**
	 * 
	 * @param x
	 * @param y
	 * @param count
	 * @param path 
	 * @return
	 */
	protected int countPathsRecursive(int x, int y, int count, String path) {
		
		// Recursion base case :
		// if destination is found, increment the path count and return
		if (x == destinationX && y == destinationY) {
			count++;
			path += String.format("[%d,%d]", x, y);
			System.out.println(path);
			return count;
		}
		
		
		int initialValue = positions[x][y];
		
		// if current cell is a valid and open cell
		if (isValidCell(x, y) && positions[x][y] == AVAILABLE) {
			
			positions[x][y] = VISITED;
			path += String.format("[%d,%d]", x, y);
			
			// go down (x, y) --> (x + 1, y)
			if (x + 1 < positions.length && !isVisited(x + 1,y))
				count = countPathsRecursive(x + 1, y, count, path);

			// go up (x, y) --> (x - 1, y)
			if (x - 1 >= 0 && !isVisited(x-1, y))
				count = countPathsRecursive(x - 1, y, count, path);

			// go right (x, y) --> (x, y + 1)
			if (y + 1 < positions[x].length && !isVisited(x,y + 1))
				count = countPathsRecursive(x, y + 1, count, path);

			// go left (x, y) --> (x, y - 1)
			if (y - 1 >= 0 && !isVisited(x,y - 1))
				count = countPathsRecursive(x, y - 1, count, path);
		}
		
		// backtrack from current cell and remove it from current path
		positions[x][y] = initialValue;
		
		return count;
	}

	/**
	 * Check if cell (x, y) is valid or not
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isValidCell(int x, int y) {
		if (x < 0 || y < 0 || x >= positions.length || y >= positions[x].length) {
			return false;
		}
		return true;
	}

	private boolean isVisited(int x, int y) {
		return positions[x][y] == VISITED;
	}

	public static void printMatrix(int [][] matrixPositions) {
		System.out.println("---------");
		for (int x = 0; x < matrixPositions.length; x++) {
			for (int y = 0; y < matrixPositions[x].length; y++) {
				System.out.printf("%d,", matrixPositions[x][y]);
			}
			System.out.println("");
		}
		System.out.println("---------");
	}
	
}
