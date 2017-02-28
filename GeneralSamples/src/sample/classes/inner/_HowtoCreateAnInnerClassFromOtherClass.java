package sample.classes.inner;

public class _HowtoCreateAnInnerClassFromOtherClass {

	public static void main(String[] args) {
		
		// We instantiate the outer class, in order to be able to instantiate/access
		// the inner class.
		OuterWithInnerClass outer = new OuterWithInnerClass("Outer Class");
		outer.outerClassPrint();

		// 1st way of accessing the inner class: we instantiate it inside the outer class,
		// and we access it by using a method of the outer class.
		outer.createAndAccessInnerClass();
		
		// 2nd way of accessing the inner class: We instantiate it OUTSIDE of the main
		// class, and we access its methods ourselves. Since it is an inner class however,
		// we need to make it clear that it is considered a member of the outer class,
		// and this is why we use OuterClass.InnerClass in the declaration.
		OuterWithInnerClass.InnerClass inner = outer.new InnerClass();
		inner.printOuterClassName();

		
		// Static Inner Class example: We instantiate only the inner class,
		// and from there we use it as any other top-level class.
		OuterWithStaticInner.InnerStaticClass staticInner = new OuterWithStaticInner.InnerStaticClass();
		staticInner.printStaticInnerClass();

		
	}
	
	

}
