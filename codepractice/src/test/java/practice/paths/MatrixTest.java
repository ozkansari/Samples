package practice.paths;

import static practice.paths.Matrix.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testCountPathsRecursive() {
		int [][] positions  = {
				{ O, O, O, O },
				{ O, O, X, O },
				{ X, O, X, O },
				{ O, O, O, O }
			};

		Matrix.printMatrix(positions);

		Matrix matrix = new Matrix(positions, 3, 3);

		// stores number of unique paths from source to destination
		int count = 0;
		String path = "";

		// start from source cell (0, 0)
		count = matrix.countPathsRecursive(0, 0, count, path);

		System.out.println("Total number of unique paths are " + count);
		
		assertEquals(4, count);
	}

}
