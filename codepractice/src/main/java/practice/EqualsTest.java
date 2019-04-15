package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EqualsTest {

  public static void main(String[] args) {
    Object obj1 = new Object();
    Object obj2 = new Object();
    System.out.println(obj1 == obj2);
    System.out.println(obj1.equals(obj2));
    obj1 = obj2;
    System.out.println(obj1.equals(obj2));
    
    Set set = new HashSet(Arrays.asList(1,2,2,3,3,5));
    System.out.println(set.size());
  }

}
