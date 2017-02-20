package hackerrank.unicodesprint2;

import hackerrank.SolutionHelper;

/**
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/breaking-best-and-worst-records
 * 
 * @author ozkansari
 *
 */
public class BreakingBestAndWorstRecords {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SolutionHelper.start();
		
		// GET INPUT
		// int n = getIn().nextInt();
		// String input = SolutionHelper.getIn().nextLine();

		int n = SolutionHelper.getIn().nextInt();
        int[] score = new int[n];
        for(int score_i=0; score_i < n; score_i++){
            score[score_i] = SolutionHelper.getIn().nextInt();
        }
		
		// DISPLAY OUTPUT
		SolutionHelper.getOut().print(calculate(n,score));
		
		SolutionHelper.end();
	}
	
	/**
	 * 
	 * @param n 1<= n <= 1000
	 * @param score 0 <= si <= 10^8
	 * @return
	 */
	private static String calculate(int n, int[] score) {
		int best = -1;
		int worst = -1;
		
		int maxSoFar = -1;
		int minSoFar = Integer.MAX_VALUE;
		for (int i = 0; i < score.length; i++) {
			int current = score[i];
			
			if (current>maxSoFar) {
				maxSoFar = current;
				best++;
			} 
			
			if (current<minSoFar) {
				minSoFar = current;
				worst++;
			}
		}
		return best + " " + worst;
	}
	
	
}

