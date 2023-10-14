package programming1lunde.prog1demos.demos.rl.prog1.demos.inheritance;

public class StaticAttBindingDemo {

	static class Base {
		int data = 1;
	}
	
	static class Derived extends Base {
		int data = 2;
	}
	
	static class DerivedAgain extends Derived {
		// inherits data from Derived
	}
	
	public static void main(String[] args) {
		Base x = new Derived();
		System.out.println(x.data); // prints 1 (!)
		DerivedAgain y = new DerivedAgain();
		System.out.println(y.data); // prints 2
	}

}
