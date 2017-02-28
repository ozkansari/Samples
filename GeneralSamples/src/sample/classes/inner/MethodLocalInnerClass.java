package sample.classes.inner;

/**
 * When an inner class is defined inside the method of Outer Class it becomes
 * Method local inner class.
 * 
 * Note: 
 * 	1-) Method local inner class can be instantiated within the method
 * 		where it is defined and no where else. 
 * 	2-) Method local inner class can not use the variable defined in method 
 * 		where it id defined still it can use the instance variable. 
 * 	3-) If method local variable is “Final” method local inner class can use 
 * 		it.(* Now variable is Final)
 * 
 */
public class MethodLocalInnerClass {
	
	// Method inner class can access this
	private int i = 9;

	// Creating instance of inner class and calling inner class function
	public void innerMethod() {
		
		// inner class declarataion inside method
		class InnerClass {
			public void getValue() {
				// accessing private variable from outer class
				System.out.println("value of i -" + i);
			}
		}
		
		// inner class instance creation
		InnerClass i1 = new InnerClass();
		
		i1.getValue();
	}
}
