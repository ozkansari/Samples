package practice;

public class GcdOfTwoNumbers {

  public static void main(String[] args) {
    calculate(81, 153);
    calculate(72, 120);
  }

  /**
   * @param number1
   * @param number2
   */
  private static void calculate(int number1, int number2) {
    System.out.println("---------------------------------------");
    System.out.println("For " + number1 + " & " + number2);
    System.out.println("---------------------------------------");
    System.out.println("GCD: " + findGCD(number1, number2));
    System.out.println("GCD: " + findGCDRecursive(number1, number2));
    int lcmFromGcd = (number1*number2) / findGCD(number1, number2);
    System.out.println("LCM: " + lcmFromGcd );
    System.out.println("---------------------------------------");
  }

  /**
   * In this method, smaller integer is subtracted from the larger integer, and
   * the result is assigned to the variable holding larger integer. This process
   * is continued until n1 and n2 are equal.
   * 
   * For example, 12 = 4*3 and 20=4*5. SO, 20-12=8 and 12-8=4.
   * 
   * @param n1
   * @param n2
   * @return
   */
  private static int findGCD(int n1, int n2) {
    // Support negative integers
    n1 = ( n1 > 0) ? n1 : -n1;
    n2 = ( n2 > 0) ? n2 : -n2;
    while (n1 != n2) {
      if (n1 > n2)
        n1 -= n2;
      else
        n2 -= n1;
    }
    return n1;
  }

  private static int findGCDRecursive(int a, int b) {
    if (a == b) {
      return a;
    } else if (a > b) {
      return findGCDRecursive(a - b, a);
    } else {
      return findGCDRecursive(a, b - a);
    }
  }

}
