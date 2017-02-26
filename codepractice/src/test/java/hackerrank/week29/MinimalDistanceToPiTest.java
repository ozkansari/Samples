/**
 * 
 */
package hackerrank.week29;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author ozkansari
 *
 */
@RunWith(Parameterized.class)
public class MinimalDistanceToPiTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ "22/7", 7, 10 },
        		{ "22/7", 1, 10 }
           });
    }

    private String expected;
    private long min;
    private long max;

    public MinimalDistanceToPiTest(String expected, long min, long max) {
    	this.expected= expected;
    	this.min = min;
    	this.max= max;
    }

    
	/**
	 * Test method for {@link hackerrank.week29.MinimalDistanceToPi#calculate(long,long)}.
	 */
	@Test
	public void testCalculate() {
		assertEquals("For " + min + " " + max, expected , MinimalDistanceToPi.calculate(min,max));
	}
	
}
