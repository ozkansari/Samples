package practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ThreeSum {

  static final String SEPERATOR = " , ";

  public static Collection<String> findBruteForce(int[] array, int sum) {
    
    Set<String> resultSet = new HashSet<>();
    
    for (int n1 = 0; n1 < array.length; n1++) {
      for (int n2 = n1 + 1; n2 < array.length; n2++) {
        for (int n3 = n2 + 1; n3 < array.length; n3++) {
          if (array[n1] + array[n2] + array[n3] == sum) {
            resultSet.add(formatResult(array[n1], array[n2] , array[n3]));
          }
        }
      }
    }
    
    return resultSet;
  }

  public static Collection<String> findFast(int[] array, int sum) {
    
    Set<String> resultSet = new HashSet<>();
    
    Map<Integer,Integer> arrayValueCount = new HashMap<Integer,Integer>();
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      int count = arrayValueCount.getOrDefault(num, 0)+1;
      arrayValueCount.put(num, count );
    }
    
    Map<Integer,Integer> sumofothersToNum1 = new HashMap<Integer,Integer>();
    for (int i = 0; i < array.length; i++) {
        int num1 = array[i];
        int sumofothers = sum-num1;
        sumofothersToNum1.put(sumofothers, num1); // key: sumofothers & value: num1
    }
    
    for(Entry<Integer,Integer> entry: sumofothersToNum1.entrySet()) {
      for (int i = 0; i < array.length; i++) {
        int num1 = entry.getValue(); // value of map -> num1
        int num2 = array[i];
        if (num1 == num2 && arrayValueCount.getOrDefault(num2,0) < 2 ) {
          continue;
        }
        int num3 = entry.getKey() - num2; // key of map -> sumofothers
        
        if (arrayValueCount.getOrDefault(num3,0) >= findCount(num3, num1, num2)) {
          
          // In order not to add same numbers again and again
          int [] resultArray = {num1,num2,num3};
          Arrays.sort(resultArray);
          
          resultSet.add(formatResult(resultArray));
        }
        
      }
    }
    
    return resultSet;
  }
  
  private static int findCount(int refNum, int ... others) {
    int count = 1;
    for (int o : others) {
      count = refNum==o ? count+1 : count;
    }
    return count;
  }

  public static String formatResult(int ...nums) {
    return String.format("%2$d%1$s%3$d%1$s%4$d", SEPERATOR, nums[0], nums[1], nums[2]);
  }
}
