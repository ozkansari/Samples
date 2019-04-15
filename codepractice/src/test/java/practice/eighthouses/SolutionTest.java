package practice.eighthouses;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class SolutionTest {

  private Solution fixture = new Solution();
  
  @Test
  public void testCellCompete1() {
    
    int[] states = {1,0,0,0,0,1,0,0};
    int[] expectedArr = {0,1,0,0,1,0,1,0};
    int days = 1;
    
    control(states, expectedArr, days);
    
  }
  
  @Test
  public void testCellCompete2() {
    
    int[] states  = {1,1,1,0,1,1,1,1};
    int[] expectedArr = {0,0,0,0,0,1,1,0};
    int days = 2;
    
    control(states, expectedArr, days);
    
  }

  /**
   * @param states
   * @param expectedArr
   * @param days
   */
  private void control(int[] states, int[] expectedArr, int days) {
    List<Integer> result = fixture.cellCompete(states, days );
    
    int[] actualArr = result.stream().mapToInt(e->e.intValue()).toArray();
    
    assertArrayEquals(expectedArr, actualArr);
  }

}
