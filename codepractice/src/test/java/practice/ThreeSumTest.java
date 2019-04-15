package practice;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

public class ThreeSumTest {

  interface Solution {
    Collection<String> execute(int[] array, int sum);
  }
  
  private Collection<String> runTest(int[] array, int sum, Solution solution, String ... expected) {
    Collection<String> actual = executeSolution(array, sum, solution);
    assertThat(actual, hasItems(expected));
    assertEquals(actual.toString(), expected.length, actual.size());
    return actual;
  }
  
  private Collection<String> executeSolution(int[] array, int sum, Solution solution) {
    long startTime = Instant.now().toEpochMilli();
    Collection<String> actual = solution.execute(array, sum);
    long endTime = Instant.now().toEpochMilli();
    long timeElapsed = endTime - startTime;
    System.out.printf("Execution time in milliseconds: %d \n", timeElapsed);
    return actual;
  }
  
  @Test
  public void givenDifferentSortedPositiveNumbers() {
    
    int sum = 6;
    int [] realInput = {1,2,2,2,3};
    String [] expected = {ThreeSum.formatResult(new int []{1,2,3}) , ThreeSum.formatResult(new int []{2,2,2}) };
    
    test(sum, 3, realInput, expected);
  }
  
  @Test
  public void givenSortedWithSameAndNegativeNumbers() {
    
    int sum = 0;
    int [] realInput = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
    
    String [] expected = {
        ThreeSum.formatResult(new int []{-4,-2,6}) , 
        ThreeSum.formatResult(new int []{-4,0,4}) ,
        ThreeSum.formatResult(new int []{-4,1,3}) ,
        ThreeSum.formatResult(new int []{-4,2,2}) ,
        ThreeSum.formatResult(new int []{-2,-2,4}) ,
        ThreeSum.formatResult(new int []{-2,0,2}) ,
    };
    test(sum, 6, realInput, expected);
  }

  private void test(int sum, int max, int[] realInput, String[] expected) {
    
    System.out.println("Running .... ");
    List<Integer> otherNums = new Random().ints(1000, 1+sum+max*3, 100000).boxed().collect(Collectors.toList());
    otherNums.addAll(Arrays.stream(realInput).boxed().collect(Collectors.toList()));
    int[] array = otherNums.stream().mapToInt(i -> i).toArray();

    // When
    runTest(array, sum, ThreeSum::findBruteForce, expected);
    runTest(array, sum, ThreeSum::findFast, expected);
  }

}
