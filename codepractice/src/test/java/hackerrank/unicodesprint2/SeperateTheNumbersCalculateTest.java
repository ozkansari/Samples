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
public class SeperateTheNumbersCalculateTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		 { "YES 123456789101112", "123456789101112123456789101113" }, 
        		 { "YES 1000000000000000", "10000000000000001000000000000001" }, 
        		 { "YES 99", "99100" }, 
            	 { "NO", "010203" }, 
            	 { "YES 9", "91011" }, 
                 { "YES 12", "12131415" }, 
                 { "YES 123", "123124125126" }, 
                 { "YES 1234", "12341235" }, 
                 { "YES 10099", "1009910100" }, 
                 { "NO", "60931" }, 
                 { "YES 1", "1234" }, 
                 { "NO", "101103" },
                 { "NO", "13" }, 
                 { "NO", "1" }, 
                 { "NO", "2" }, 
           });
    }

    private String input;

    private String expected;

    public SeperateTheNumbersCalculateTest(String expected, String actual) {
    	this.expected= expected;
    	this.input= actual;
    }


	@Test
	public void testCalculate() {
		
		String message = "For input: " + input;
		assertEquals(message, expected, SeperateTheNumbers.calculate(input));
	}

}
