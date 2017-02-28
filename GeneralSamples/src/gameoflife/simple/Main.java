/**
 * 
 */
package gameoflife.simple;

import org.apache.log4j.BasicConfigurator;

/**
 * @author e048482
 *
 */
public class Main {

	private static final int[][] gol = {{0,0,0,0,0},
			{0,1,1,1,0},
			{0,0,1,1,0},
			{0,1,0,1,0},
			{0,0,0,0,0}};
	
	private static final int[][] endOfLife = {{1,1,1,1,1},
		{1,1,1,1,1},
		{1,1,1,1,1},
		{1,1,1,1,1},
		{1,1,1,1,1}};

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Configure logger
        BasicConfigurator.configure();
        
		
		int[][] currentState = endOfLife;
		print(currentState);
		for (int i=0;i<10;i++) {
			currentState = GameOfLife.simulate(currentState);
			print(currentState);
		}
		
	}
	
	public static void print(int[][] array) {
		System.out.println("-Print Array-");
		for (int[] is : array) {
			System.out.print("| ");
			for (int i : is) {
				System.out.print(i == 0 ? "  " : (char)223 + " ");
			}
			System.out.println("|");
		}
		System.out.println("-------------");
	}

}
