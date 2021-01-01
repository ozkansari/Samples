package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckArrayFormationThroughConcatenation {
	
	protected static interface Solution {

		/**
		 * You are given an array of distinct integers arr and an array of integer
		 * arrays pieces, where the integers in pieces are distinct. Your goal is to
		 * form arr by concatenating the arrays in pieces in any order. However, you are
		 * not allowed to reorder the integers in each array pieces[i].
		 * 
		 * @param arr
		 * @param pieces
		 * @return true if it is possible to form the array arr from pieces. Otherwise,
		 *         return false.
		 */
		boolean canFormArray(int[] arr, int[][] pieces);
	}

	/**
	 * Runtime: 10 ms Memory Usage: 38.5 MB
	 */
	protected static class Solution1 implements Solution {
	
	    public boolean canFormArray(int[] arr, int[][] pieces) {
	        
	        String targetFormation = Arrays.stream(arr)
	            .mapToObj(String::valueOf)
	            .collect(Collectors.joining("_"))
	            .concat("_");
	        
	        for(int [] p : pieces) {
	            
	            String pieceFormation = Arrays.stream(p)
	                .mapToObj(String::valueOf)
	                .collect(Collectors.joining("_"))
	                .concat("_");
	            if(!targetFormation.contains(pieceFormation)) {
	                return false;
	            }
	            
	        }
	        
	        return true;
	    }
	}

	/**
	 * Runtime: 1 ms Memory Usage: 38.2 MB
	 */
	protected static class Solution2 implements Solution {
		
	    private static final String SEPERATOR = "_";

		public boolean canFormArray(int[] arr, int[][] pieces) {
	        
	        String targetFormation = arrayToStr(arr);
	        
	        for(int [] p : pieces) {
	            
	            String pieceFormation = arrayToStr(p);
	            if(!targetFormation.contains(pieceFormation)) {
	                return false;
	            }
	            
	        }
	        
	        return true;
	    }

		private String arrayToStr(int[] arr) {
			StringBuilder sb = new StringBuilder();
			for (int record : arr) {
				sb.append(record);
				sb.append(SEPERATOR);
			}
			return sb.toString();
		}
	}

}
