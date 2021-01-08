package leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {

	private LongestSubstringWithoutRepeatingCharacters fixture = new LongestSubstringWithoutRepeatingCharacters();
	
	@Test
	public final void test1() {
		String s = "abcabcbb";
		int actual = fixture.lengthOfLongestSubstring(s);
		assertEquals(3, actual);
	}
	
	@Test
	public final void test2() {
		String s = " ";
		int actual = fixture.lengthOfLongestSubstring(s);
		assertEquals(1, actual);
	}

}
