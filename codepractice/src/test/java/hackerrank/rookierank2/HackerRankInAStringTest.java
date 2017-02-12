package hackerrank.rookierank2;

import static org.junit.Assert.*;

import org.junit.Test;

import hackerrank.rookierank2.HackerRankInAString;

public class HackerRankInAStringTest {

	@Test
	public void testCheckString1() {
		assertEquals("YES", HackerRankInAString.checkString("hereiamstackerrank"));
	}
	
	@Test
	public void testCheckString2() {
		assertEquals("NO", HackerRankInAString.checkString("hackerworld"));
	}
	
	@Test
	public void testCheckString3() {
		assertEquals("YES", HackerRankInAString.checkString("hereiamstackerrankasdasdad"));
	}

}
