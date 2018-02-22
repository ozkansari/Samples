package hackerrank.week30;

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
public class FindMinimumNumberTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		 { 2, "min(int, int)" },
        		 { 3, "min(int, min(int, int))" },
        		 { 4, "min(int, min(int, min(int, int)))" },
        		 { 5, "min(int, min(int, min(int, min(int, int))))" }
           });
    }

    private String expected;
    private int n;

    public FindMinimumNumberTest(int n, String expected) {
    	this.expected= expected;
    	this.n = n;
    }
    

	@Test
	public void testCalculate() {
		assertEquals("For " + n, expected , FindMinimumNumber.calculate(n));
	}
}
