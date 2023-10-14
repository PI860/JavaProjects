package PROG1.prog1demos.exceptions;


public class SolutionWithException {
	
	public static class A {
		private B b;

		public void m1() {
			try {
				// ...
				b.m2();
				// ...
			} catch (Except1 e) {
				// handle failure 1
			} catch (Except2 e) {
				// handle failure 2
			}
		}
	}
	
	public static class B {
		private C c;

		public void m2() {
			// ...
			c.m3();
			// ...
		}
	}
	
	public static class C {
		boolean disaster; // dummy
		public void m3() {
			// ...
			if (disaster)
				throw new Except1();
			// ...
		}
	}
	
	@SuppressWarnings("serial")
	public static class Except1 extends RuntimeException {
	}
	@SuppressWarnings("serial")
	public static class Except2 extends RuntimeException {
	}
	
	public static void main(String[] args) {
		System.out.println(3 / 0);
	}
}
