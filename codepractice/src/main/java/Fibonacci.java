
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
	
  private static Map<Integer,Long> fibonacciCache = new HashMap<>();
  
  private static long calc_fib(int n) {
    if (n <= 1) {
      return n;
    }

    Long cachedValue = fibonacciCache.get(n);
    if (cachedValue != null) {
		return cachedValue.longValue();
	}
    
    long result = calc_fib(n - 1) + calc_fib(n - 2);
    
    fibonacciCache.put(n,result);
    
	return result;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
