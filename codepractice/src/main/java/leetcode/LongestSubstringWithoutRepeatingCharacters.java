package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	/** Runtime: 167 ms, Memory Usage: 114 MB */
	public int lengthOfLongestSubstring(String s) {

		int maxLength = 0;
		
		Set<Character> tempCharCache = new HashSet<>();
		
		int startIdx = 0;
		int currentIdx = 0;
		int currentLength = 0;
		while (startIdx < s.length()) {
			
			char ch = s.charAt(currentIdx);
			if(tempCharCache.contains(ch)) {
				maxLength = Math.max(maxLength, currentLength);
				
				currentLength = 0;
				tempCharCache.clear();
				startIdx++;
				currentIdx = startIdx;
				continue;
			}
			
			tempCharCache.add(ch);
			currentLength++;
			currentIdx++;
			
			if (currentIdx==s.length()) {
				return Math.max(maxLength, currentLength);
			}
		}
		
		return maxLength;
	}

}
