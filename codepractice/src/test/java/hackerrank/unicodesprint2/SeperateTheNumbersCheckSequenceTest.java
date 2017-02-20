package hackerrank.unicodesprint2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import hackerrank.unicodesprint2.SeperateTheNumbers;

@RunWith(Parameterized.class)
public class SeperateTheNumbersCheckSequenceTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        	{ false, "123456789", "10" },
        	{ false, "110099", "100100" },
        	{ false, "99", "00" }, 
        	{ true, "9", "10" }, 
        	{ true, "99999", "100000" }, 
        	{ true, "10099", "10100" },
            { false, "99", "10" }, 
	        { false, "101", "103" }, 
            { true, "123456789101112", "123456789101113" }, 
            { true, "1234", "1235" }
        });
    }

    private boolean expected;
    private String prev;
    private String cur;

    public SeperateTheNumbersCheckSequenceTest(boolean expected, String prev, String cur) {
    	this.expected= expected;
    	this.prev= prev;
    	this.cur= cur;
    }

	@Test
	public void testCheckSequence() {
		String message = "For prev: " + prev + ", cur: " + cur;
		assertEquals(message, expected, SeperateTheNumbers.checkSequence(prev, cur));
	}
	
}
