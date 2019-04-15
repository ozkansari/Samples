package practice.eighthouses;

//IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.nio.CharBuffer;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;
//SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//DEFINE ANY CLASS AND METHOD NEEDED
//CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {

  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public List<Integer> cellCompete(int[] states, int days) {

    int[] newStates= Arrays.copyOf(states, states.length);
    
    while(days>0) {

      // Check states and prepare next states
      for (int stateIdx = 0; stateIdx < states.length; stateIdx++) {
        int leftHouse = stateIdx==0 ? 0 : states[stateIdx-1];
        int rightHouse = stateIdx==states.length-1 ? 0 : states[stateIdx+1];
        int newVal = leftHouse == rightHouse ? 0 : 1;
        newStates[stateIdx] = newVal;
      }

      states= Arrays.copyOf(newStates, states.length);
      
      days--;
    }
    
    return Arrays.stream(newStates)
        .boxed()
        .collect(Collectors.toList());
    // WRITE YOUR CODE HERE
  }
  // METHOD SIGNATURE ENDS

}