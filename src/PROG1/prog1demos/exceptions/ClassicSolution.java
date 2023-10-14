package PROG1.prog1demos.exceptions;

public class ClassicSolution {

	public static class A {
		private B b;

		public void m1() {
			// ...
			int state = b.m2();
			if (state == 1) {
				// handle failure 1
			} else if (state == 2) {
				// handle failure 2
			}
		}
	}
	
	public static class B {
		private C c;

		public int m2() {
			int result = 0;
			// ...
			result = c.m3();
			if (result != 0)
				return result;
			// ...
			return result;
		}
	}
	
	public static class C {
		boolean disaster; // dummy
		public int m3() {
			// ...
			if (disaster)
				return 1;
			// ...
			return 0;
		}
	}
}
