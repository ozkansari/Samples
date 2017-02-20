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
public class DayOfTheProgrammerTest {

	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		 { "12.09.2016", true, 2016 },
        		 { "13.09.2017", false, 2017 },
        		 { "13.09.2018", false, 2018 },
        		 { "13.09.2019", false, 2019 },
        		 { "12.09.2020", true, 2020 },
        		 { "12.09.1700", true, 1700 }, // 1700-1917 Julian, %4==0 enough
        		 { "12.09.1800", true, 1800 }, // 1700-1917 Julian, %4==0 enough
        		 { "12.09.1900", true, 1900 }, // 1700-1917 Julian, %4==0 enough
        		 { "13.09.1917", false, 1917 },
        		 { "12.09.2000", true, 2000 },
        		 { "13.09.2700", false, 2700 },
        		 { "26.09.1918", false, 1918 } // Julian->Gregorian year
           });
    }

    private int year;

    private String day256;
    
    private boolean leapYear;

    public DayOfTheProgrammerTest(String day256, boolean leapYear, int year) {
    	this.day256= day256;
    	this.leapYear = leapYear;
    	this.year= year;
    }

    
	/**
	 * Test method for {@link hackerrank.week29.DayOfTheProgrammer#calculate(int)}.
	 */
	@Test
	public void testCalculate() {
		assertEquals("For " + year, day256, DayOfTheProgrammer.calculate(year));
	}
	
	/**
	 * Test method for {@link hackerrank.week29.DayOfTheProgrammer#checkIfLeapYear(int)}.
	 */
	@Test
	public void testCheckIfLeapYear() {
		assertEquals("For " + year, leapYear, DayOfTheProgrammer.checkIfLeapYear(year));
	}

}
