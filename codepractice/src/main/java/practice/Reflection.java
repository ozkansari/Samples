package practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflection {

  public Reflection() {
    
  }
  
  public Reflection(String str) {
    System.out.println(str);
  }
  
  public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Class classObject = new Reflection().getClass();

    // most appropriate way to get public constructor of a class which takes a String as a parameter
    
    Constructor constructor1 = classObject.getConstructor(String.class);
    constructor1.newInstance("constructor1");
    
    Constructor constructor2 = classObject.getConstructor(new Class[]{String.class});
    constructor2.newInstance("constructor2");
  }
}
