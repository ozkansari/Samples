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
public class MegaprimeNumbersTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		 { 8, 1, 100 }
           });
    }

    private long expected;
    private long first;
    private long last;

    public MegaprimeNumbersTest(long expected, long first, long last) {
    	this.expected= expected;
    	this.first = first;
    	this.last= last;
    }

    
	/**
	 * Test method for {@link hackerrank.week29.MegaprimeNumbers#calculate(long,long)}.
	 */
	@Test
	public void testCalculate() {
		assertEquals("For " + first + " " + last, expected , MegaprimeNumbers.calculate(first,last));
	}
	
}
