package sample.classes.inner;

public class OuterWithStaticInner {

	// By defining the inner class as static, we can access its methods
    // without outer class instantiation.
    public static class InnerStaticClass {
        
        public void printStaticInnerClass() {
            System.out.println("A new static inner class!");
        }
    }
}
