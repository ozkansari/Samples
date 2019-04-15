package practice;

import java.util.Arrays;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
class GCD {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public int generalizedGCD(int num, int[] arr) {
    // WRITE YOUR CODE HERE

    int min = Arrays.stream(arr).min().getAsInt();

    boolean match;
    for (int gcd = min; gcd > 0; gcd--) {
      match = true;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] % gcd != 0) {
          match = false;
          break;
        }
      }
      if (match) {
        return gcd;
      }
    }

    return 1;

  }
  // METHOD SIGNATURE ENDS
}
