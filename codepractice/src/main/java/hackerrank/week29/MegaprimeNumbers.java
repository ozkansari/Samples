package hackerrank.week29;

import hackerrank.SolutionHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w29/challenges/megaprime-numbers
 * 
 * We call a number megaprime if it is prime and all of its individual digits are prime. 
 * E.g. 53
 * 
 * @author ozkansari
 *
 */
public class MegaprimeNumbers {

    public static void main(String[] args) {

        SolutionHelper.start();

		// GET INPUT
		// Scanner in = new Scanner(System.in);
		Scanner in = SolutionHelper.getIn();

		// long first = in.nextLong();
		long first = 1L;
		System.out.println("first: " + first);
        // long last = in.nextLong();
        long last = 1000000L;
        System.out.println("last: " + last);
        
		SolutionHelper.getOut().println(calculate(first,last));

		SolutionHelper.end();
    }
    
	/**
     * 
     * @param first 1 <= first <= last <= 10^15 , last - first <= 10^9
     * @param last 1 <= first <= last <= 10^15 , last - first <= 10^9
     * @return
     */
	protected static int calculate(long first, long last) {
		PrimeChecker primeChecker = new PrimeChecker(first, last);
		return primeChecker.findMegaPrimes();
	}
	
    private static class PrimeChecker {
    	
    	long last;
    	long first;
    	
    	// will contain true or false
    	private Map<Long, Boolean> primes;
    	
    	public PrimeChecker(long first, long last) {
    		primes=new HashMap<Long, Boolean>();
    		this.first = first;
    		this.last = last;
    	}
    	
    	private int findMegaPrimes() {

    		// primes.put(0L, false);
    		// primes.put(1L, false);
  
    		int megaCounter = 0;
    	    for (long i=2;i<=last;i++) {
    	    	
    	        // if the number is prime,
    	        // then go through all its multiples and make their values false.
    	        if(isPrime(i)) {
					for (long j = 2; i * j <= last; j++) {
    	                primes.put(i*j, false);
    	            }
					
					if (i >= first) {
						
						String currentNum = String.valueOf(i);
						if (currentNum.matches("^[2357]+$")) {
							megaCounter++;
						}
					}
					
    	        }
    	    }
    	    return megaCounter;
    	}

    	public boolean isPrime(long n) {
    	    return primes.get(n) == null; // If not set to false, it is assumed to be prime
    	}
    	
    	public static boolean isPrime(int n) {
    	    return !new String(new char[n]).matches(".?|(..+?)\\1+");
    	}

    }

    
}

