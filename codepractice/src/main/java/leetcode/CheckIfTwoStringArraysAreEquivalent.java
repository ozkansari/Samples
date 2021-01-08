package leetcode;

public class CheckIfTwoStringArraysAreEquivalent {

	protected static interface SolutionForCheckIfTwoStringArraysAreEquivalent {
		
		/**
		 * Given two string arrays word1 and word2. A string is represented by an array
		 * if the array elements concatenated in order forms the string.
		 * 
		 * @see https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3597/
		 * 
		 * @param word1
		 * @param word2
		 * 
		 * @return true if the two arrays represent the same string, and false
		 *         otherwise.
		 */
		boolean arrayStringsAreEqual(String[] word1, String[] word2);
	}
	
	protected static class Solution1 implements SolutionForCheckIfTwoStringArraysAreEquivalent {
		
		/* Runtime: 3 ms, Memory Usage: 38.4 MB */
	    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
	        
	        int idx1 = 0, char1 = 0;
	        int idx2 = 0, char2 = 0;
	        
	        while(idx1 < word1.length && idx2 < word2.length){
	            
	            if( word1[idx1].charAt(char1) != word2[idx2].charAt(char2) ) {
	                return false;
	            }
	            
	            char1++;
	            char2++;
	            
	            if(char1 >= word1[idx1].length()){
	                char1 = 0;
	                idx1++;
	            }
	            
	            if(char2 >= word2[idx2].length()){
	                char2 = 0;
	                idx2++;
	            }
	        }
	        
	        return idx1 == word1.length  && idx2 == word2.length;      
	    }
	}
	
	protected static class Solution2 implements SolutionForCheckIfTwoStringArraysAreEquivalent {

		/* Runtime: 1 ms, Memory Usage: 38.9 MB */
		@Override
		public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		
			StringBuilder sb1 = new StringBuilder();
			for (String w1 : word1) {
				sb1.append(w1);
			}
			
			StringBuilder sb2 = new StringBuilder();
			for (String w2 : word2) {
				sb2.append(w2);
			}
			
			return sb1.compareTo(sb2) == 0;
		}
		
	}
}
