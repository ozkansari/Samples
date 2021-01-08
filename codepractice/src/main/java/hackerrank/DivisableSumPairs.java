package hackerrank;

public class DivisableSumPairs {

	protected static interface DivisableSumPairsSolution {
		/**
		 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
		 * 
		 * @param n
		 * @param k
		 * @param ar
		 * @return
		 */
		int divisibleSumPairs(int n, int k, int[] ar);
	}
	
	protected static class DivisableSumPairsNaiveSolution implements DivisableSumPairsSolution {

		@Override
		public int divisibleSumPairs(int n, int k, int[] ar) {
			int pairCount = 0;
			for (int numIdx1 = 0; numIdx1 < ar.length; numIdx1++) {
				for (int numIdx2 = numIdx1+1; numIdx2 < ar.length; numIdx2++) {
					int sumPair = ar[numIdx1] + ar[numIdx2];
					if(sumPair%k == 0) {
						pairCount++;
					}
				}
			}
			return pairCount;
		}
		
	}
}
