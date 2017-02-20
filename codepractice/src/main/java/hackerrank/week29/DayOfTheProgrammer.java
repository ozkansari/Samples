package hackerrank.week29;

import java.util.Scanner;

import hackerrank.SolutionHelper;

/**
 * https://www.hackerrank.com/contests/w29/challenges/day-of-the-programmer
 * 
 * From 1700  to 1917, Russia's official calendar was the Julian calendar.
 * In 1919, they transitioned to the Gregorian calendar system.
 * The transition from the Julian to Gregorian calendar system occurred in 1918, 
 * when the next day after January 31 was February 14.
 * This means that in 1918: February 14 th was 32nd day of the year in Russia.
 * 
 * In Julian & Gregorian calendar February is the only month with a variable amount of days; 
 * it has 29 days during a leap year.
 * 
 * @author ozkansari
 *
 */
public class DayOfTheProgrammer {

	public static void main(String[] args) {

		SolutionHelper.start();

		// GET INPUT
		// Scanner in = new Scanner(System.in);
		Scanner in = SolutionHelper.getIn();

		int y = in.nextInt(); 

		SolutionHelper.getOut().println(calculate(y));

		SolutionHelper.end();
	}

	/**
	 * Calculates the date of the 256th day of that year according 
	 * to the official Russian calendar during that year.
	 * 
	 * @param year 1700 <= year <= 2700
	 * 
	 * @return the full date of Day of the Programmer during year in the format dd.mm.yyyy
	 */
	protected static String calculate(int year) {
		
		// Not leap year and special gregorian transition year
		if (year == 1918) {
			return "26.09.1918";
		}
		
		int days = NORMAL_DAYS_UNTIL_SEPTEMBER;
		if (checkIfLeapYear(year)) {
			days++;
		}
		int septemberDay = PROGRAMMER_DAY-days;
		
		return septemberDay + "." + SEPTEMBER_MONTHNO + "." + year;
	}

	/**
	 * 
	 * @param year
	 * @return
	 */
	protected static boolean checkIfLeapYear(int year) {

		boolean divisibleBy4 = year % 4 == 0;
		
		// From 1700  to 1917, Russia's official calendar was the Julian calendar
		if (year>= 1700 && year<=1917) {
			// In the Julian calendar, leap years are divisible by 4
			return divisibleBy4; 
		} 
		// From 1918 Russia uses gregorian calendar
		else {
			boolean divisibleBy400 = year%400==0;
			boolean notDivisibleBy100 = year%100 != 0;
			boolean divisibleBy4AndNot100 = divisibleBy4 && notDivisibleBy100;
			return divisibleBy400 || divisibleBy4AndNot100;
		}
	}
	

	/**
	 * September is the 9th month
	 */
	private static final String SEPTEMBER_MONTHNO = "09";

	/**
	 * 31+28+31+30+31+30+31+31=243 days in total 8 months
	 */
	private static final int NORMAL_DAYS_UNTIL_SEPTEMBER = 243;
	
	/**
	 * 256th day is the programmer's day
	 */
	private static final int PROGRAMMER_DAY = 256;

	/**
	 * Days in a month
	 */
	private static final int [] NORMAL_MONTH_DAYS = 
		{
			31, // January 
			28, // February
			31, // March
			30, // April
			31, // May
			30, // June
			31, // July
			31, // August
			30, // September
			31, // October
			30, // November
			31, // December
		};
	
	
	
}
