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
public class BigSortingTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		 { "31415926535897932384626433832795,1,3,10,3,5", "1\n3\n3\n5\n10\n31415926535897932384626433832795\n" },
        		 { "31415926535897932384626433832795,31415926535897932384626433832796,1,3,10,3,5", "1\n3\n3\n5\n10\n31415926535897932384626433832795\n31415926535897932384626433832796\n" },
        		 { "3141592653589793238462643383279500000000000000000000000000000000000000000000000000000000000000,1", "1\n3141592653589793238462643383279500000000000000000000000000000000000000000000000000000000000000\n" }
           });
    }

    private String [] unsorted;
    
    private String expected;

    public BigSortingTest(String unsorted, String expected) {
    	this.unsorted= unsorted.split(",");
    	this.expected = expected;
    }

    
	/**
	 * Test method for {@link hackerrank.week29.BigSorting#calculate(String [])}.
	 */
	@Test
	public void testCalculate() {
		assertEquals("For " + Arrays.asList(unsorted), expected, BigSorting.calculate(unsorted));
	}
	
}
