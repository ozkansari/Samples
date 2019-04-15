package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * Given an array of integers, return all two pairs such that they add up to a specific sum
 *
 */
public class TwoSum {

  public static List<String> findBruteForce(int[] array, int sum) {
    
    List<String> resultList = new ArrayList<>();
    
    for (int n1 = 0; n1 < array.length; n1++) {
      for (int n2 = n1 + 1; n2 < array.length; n2++) {
        if (array[n1] + array[n2] == sum) {
          
          resultList.add(array[n1] + " , " + array[n2]);
          if (array[n1] != array[n2]) {
            resultList.add(array[n2] + " , " + array[n1]);
          }
          
        }

      }
    }
    
    return resultList;
  }

  public static List<String> findFast(int[] array, int sum) {

    List<String> resultList = new ArrayList<>();
    
    Map<Integer,Integer> arrayValueCount = new HashMap<Integer,Integer>();
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      int count = arrayValueCount.getOrDefault(num, 0)+1;
      arrayValueCount.put(num, count );
    }
    
    Map<Integer,Integer> pairs = new HashMap<Integer,Integer>();
    for (int i = 0; i < array.length; i++) {
        int num1 = array[i];
        int num2 = sum-num1;
        int numCount = num1!=num2 ? 1 : 2;
        if (arrayValueCount.getOrDefault(num2, 0) >= numCount) {
          pairs.put(num1, num2); // we need num2 for num1
        }
    }
    
    for (Entry<Integer,Integer> entry : pairs.entrySet()) {
      Integer num1 = entry.getKey();
      Integer num2 = entry.getValue();
      resultList.add(num1 + " , " + num2 );
    }
    
    return resultList;
  }
  
  /**
   * Supports both positive and negative numbers
   * 
   * @param array
   * @param sum
   * @return
   */
  public static List<String> findOptimized(final int[] array, int sum) {
    int[] sorted =  Arrays.stream(array).sorted().toArray();
    int minAbs = Math.abs(sorted[0]);
    int[] filtered =  Arrays.stream(sorted).filter(x -> x < minAbs+sum).toArray();
    return findFast(filtered, sum);
  }

}
