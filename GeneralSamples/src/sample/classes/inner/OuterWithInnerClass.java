package sample.classes.inner;

/**
 * This is an outer class which contains a member class in it.
 * 
 * Following properties can be noted about Inner classes:
 * 
 * 	1-) The outer class (the class containing the inner class) can instantiate as
 * 		many number of inner class objects as it wishes, inside it’s code. 
 * 	2-) If the inner class is public & the containing class as well, then code in some other 
 * 		unrelated class can as well create an instance of the inner class.
 *  3-) No inner class objects are automatically instantiated with an outer class object.
 *  4-) If the inner class is static, then static inner class can be instantiated without an 
 *  	outer class instance, otherwise, the inner class object must be associated with an 
 *  	instance of the outer class.
 *  5-) Inner class code has free access to all elements of the outer class object that contains 
 *  	it, by name (no matter what the access level of the elements is), if the inner class has 
 *  	a varible with same name then the outer class’s variable can be access like this:
 *  	<OuterClassName>.this.<variableName>
 *  6-) The outer class can call even the private methods of the inner class.
 *
 *	For more information: 
 *		- http://viralpatel.net/blogs/inner-classes-in-java/ 
 *		- https://examples.javacodegeeks.com/core-java/java-nested-inner-class-example/
 *		- http://javabeginnerstutorial.com/core-java-tutorial/inner-class/
 */
public class OuterWithInnerClass {

	// Inner class can access this
    private String name;
    
    public OuterWithInnerClass(String name) {
        this.name = name;
    }
    
    // Inner class can access this
    public void outerClassPrint() {
        System.out.println("A new outer class, with name: " + name);
    }
    
    
    // Here we create an inner class. Since the inner class is considered a member 
    // of the outer class, it can be instantiated in the useual way.
    public void createAndAccessInnerClass() {
        InnerClass inner = new InnerClass();
        inner.printOuterClassName();
    }
    
    // The inner class declaration and implementation.
    // As stated in the article, it has access of all the outer class members
    // even the private ones.
    public class InnerClass {
        
        // Case in point: we access and print the name of the outer class
        // which is private.
        public void printOuterClassName() {
            System.out.println("Accessing outer class with name: " + name);
        }
    }
}
