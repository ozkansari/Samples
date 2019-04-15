package practice;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

public class TwoSumTest {

  interface Solution {
    List<String> execute(int[] array, int sum);
  }
  
  private List<String> runTest(int[] array, int sum, Solution solution, String ... expected) {
    List<String> actual = executeSolution(array, sum, solution);
    assertThat(actual, hasItems(expected));
    assertEquals(actual.toString(), expected.length, actual.size());
    return actual;
  }
  
  private List<String> executeSolution(int[] array, int sum, Solution solution) {
    long startTime = Instant.now().toEpochMilli();
    List<String> actual = solution.execute(array, sum);
    long endTime = Instant.now().toEpochMilli();
    long timeElapsed = endTime - startTime;
    System.out.printf("Execution time in milliseconds: %d \n", timeElapsed);
    return actual;
  }
  
  @Test
  public void givenDifferentSortedPositiveNumbers() {
    
    int sum = 4;
    int [] realInput = {1,2,2,3};
    String [] expected = { "1 , 3", "3 , 1", "2 , 2" };
    
    List<Integer> otherNums = new Random().ints(100000, sum+1, 100000).boxed().collect(Collectors.toList());
    otherNums.addAll(Arrays.stream(realInput).boxed().collect(Collectors.toList()));
    int[] array = otherNums.stream().mapToInt(i -> i).toArray();

    // When
    runTest(array, sum, TwoSum::findBruteForce, expected);
    runTest(array, sum, TwoSum::findFast, expected);
    runTest(array, sum, TwoSum::findOptimized, expected);
  }


}
