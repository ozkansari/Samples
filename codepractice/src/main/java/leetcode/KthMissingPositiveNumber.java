package leetcode;

public class KthMissingPositiveNumber {

	protected static interface Solution {
		
		/**
		 * Given an array arr of positive integers sorted in a strictly increasing
		 * order, and an integer k.
		 * 
		 * Find the kth positive integer that is missing from this array.
		 * 
		 * @param arr
		 * @param k
		 * @return
		 */
		int findKthPositive(int[] arr, int k);
	}
	
	/**
	 * Runtime: 0 ms Memory Usage: 38.6 MB
	 */
	protected static class Solution1 implements Solution {
		
	    public int findKthPositive(int[] arr, int k) {
	        
	        if( k < arr[0] ) {
	            return k;
	        }
	        
	        int missingVal = arr[0] - 1;
	        int missingCount = arr[0] - 1;
	        
	        for(int i=1; i<arr.length && missingCount<k; i++) {
	            
	            int diff = arr[i] - arr[i-1];
	            if(diff != 1) {
	                
	                if(diff <= k - missingCount) {
	                    missingCount = missingCount + diff - 1;
	                    missingVal = arr[i]-1;
	                } else {
	                    missingVal = arr[i-1] + k - missingCount;
	                    missingCount = k;
	                }
	                
	                
	            }
	        }
	        
	        if(k>missingCount) {
	            return arr[arr.length-1] + (k-missingCount);
	        }
	        
	        return missingVal;
	        
	    }
	}
	
	/**
	 * Runtime: 0 ms Memory Usage: 38.8 MB
	 */
	protected static class Solution2 implements Solution {

		@Override
		public int findKthPositive(int[] arr, int k) {
			
			int missingVal = 1;
			
			for (int num = missingVal, idx=0; k>0; num++) {
				
				if (idx < arr.length && arr[idx] == num ) {
					idx++;
					continue;
				}
				
				k--;
				missingVal = num;
				
			}
			
			
			return missingVal;
		}
		
	}
}
