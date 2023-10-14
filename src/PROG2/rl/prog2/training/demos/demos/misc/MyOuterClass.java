package rl.prog2.demos.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Simple program which demonstrates the use of inner classes. Read the code -
 * running the program is not really interesting!
 * 
 * @author Ruediger Lunde
 * 
 */
public class MyOuterClass {
	int x;
	int y;

	public class MyInnerClass {
		int x; // overrides the outer x

		// ...

		/** Demonstrates how to access overridden variables. */
		void startAccessDemo() {
			this.x = 0; // access inner x
			x = 0; // same as above
			MyOuterClass.this.x = 0; // access outer x
			MyOuterClass.this.y = 0; // access outer y
			y = 0; // same as above
			// this.y = 0; // error
		}
	}

	/**
	 * Demonstrates that variables can only be accessed in local classes if they
	 * are declared final.
	 */
	public void startLocalClassDemo(final int x, int y) {
		@SuppressWarnings("unused")
		class MyLocalClass {
			MyLocalClass() {
				int sum = x; // ok - x is final
				// sum += y; // error
			}
		}
	}

	/** Demonstrates how to create an inner class from "inside" */
	@SuppressWarnings("unused")
	void createInner() {
		// no problem - a this reference exists in this context
		MyInnerClass inner = new MyInnerClass();
	}

	/**
	 * Demonstrates how to create an inner class from "outside" and starts a
	 * comparator demo.
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// to create the outer class is as easy as usual
		MyOuterClass outer = new MyOuterClass();
		// now we create an inner class from "outside"
		// (no this reference available here)
		MyInnerClass inner = outer.new MyInnerClass();

		startComparatorDemo();
	}

	/**
	 * Demonstrates how a local class can be used to create a special
	 * comparator.
	 */
	public static void startComparatorDemo() {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Random r = new Random();
		for (int i = 0; i < 10; i++)
			numbers.add(r.nextInt(100));

		// sort numbers in descendant order
		Collections.sort(numbers, new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return -i1.compareTo(i2);
			}
		});

		for (int num : numbers)
			System.out.print(num + " ");
	}
}
