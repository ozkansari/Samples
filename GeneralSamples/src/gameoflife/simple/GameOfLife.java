package gameoflife.simple;

import org.apache.log4j.Logger;

public class GameOfLife {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = Logger.getLogger(GameOfLife.class);
	
	public static int[][] simulate(int[][] gol) {
		LOGGER.debug("Simulating......");
		int[][] golNext = new int[gol.length][gol[0].length];
		for (int i = 0; i < gol.length; i++) {
			for (int j = 0; j < gol[i].length; j++) {
				golNext[i][j] = newState(gol, i, j);
			}
		}
		return golNext;
	}

	public static int newState(int[][] gol, int i, int j) {
		int neighborhoodCount = 0;
		
		for(int n = -1; n < 2; n++) {
			for (int m = -1; m < 2; m++) {
				if(n == 0 && m == 0) {
					// dont check itself
					continue;
				}
				if (i+n < 0 || j+m < 0) {
					continue;
				}
				if (i+n >= gol.length || j+m >= gol[j].length) {
					continue;
				}
				neighborhoodCount += gol[i+n][j+m];
			}
		}
		
		if (neighborhoodCount < 2) {
			return 0;
		} 
		if (neighborhoodCount > 3) {
			return 0;
		}
		if (neighborhoodCount == 3) {
			return 1;
		}
		return gol[i][j];
	}
}
