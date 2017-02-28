package sample.classes.inner;

public class AnonymousInnerClassCreation {

	public static void main(String[] args) {
		
		// Instead of using the interface by implementing it in another class,
		// we create an anonymous inner class here and use it without a problem.
		AnonymousClassInterface anonymous = new AnonymousClassInterface() {
			@Override
			public void printAnonymousClass() {
				System.out.println("A new anonymous inner class!");
			}
		};
		anonymous.printAnonymousClass();

		
	}
	
	// An interface which usually needs to be implemented by another class.
	// In this case however, we are going to use it to create an anonymous inner
	// class.
	public interface AnonymousClassInterface {
		public void printAnonymousClass();
	}
}
