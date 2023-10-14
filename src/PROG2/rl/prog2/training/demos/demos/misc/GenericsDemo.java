package rl.prog2.demos.misc;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Contains code examples which demonstrate how to use generics. It is not very
 * useful to run this program without code modifications.
 * 
 * @author Ruediger Lunde
 */
public class GenericsDemo {

	/** Demo starter. Code-level changes necessary before running it! */
	@SuppressWarnings({ "unused", "rawtypes" })
	public static void main(String[] args) {
		startIncompatibilityDemo();
		startArrayDemo(); // runtime error!

		MySortedList1<Person> pers;
		// MySortedList1<Student> stud1; // compile-time error!
		MySortedList2<Student> stud2;

		LimitationsDemo.start(); // runtime error!

		// by the way - explicit usage of raw types is ok but not recommended
		ArrayList list = new ArrayList();
		
		String winner = vote("a", "b", "a");
	}

	/** Simple method accepting a wildcard type. */
	static void print(Collection<?> elements) {
		System.out.print("[ ");
		for (Object e : elements)
			System.out.print(e.toString() + " ");
		System.out.print("]");
	}

	/** A generic method. */
	static <T> T vote(T x, T y, T z) {
		if (x.equals(y))
			return x;
		if (y.equals(z))
			return z;
		if (z.equals(x))
			return x;
		return null;
	}

	/** Demonstrates, why generic types are incompatible in general. */
	static void startIncompatibilityDemo() {
		// a person has a name
		// a student is a person who additionally has a student number
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Steinle, Anna", 4711));
		// now some operations are performed on students...

		print(students);
		// print(new ArrayList<Number>());

		{
			// ArrayList<Person> persons = persons; // error!
			// otherwise the compiler would have to accept this:
			// persons.add(0, new Person("Schmidt, Tobias"));
			// but now, the first element in students is a person without
			// student number...
		}
		{
			ArrayList<Person> persons = new ArrayList<Person>();
			persons.add(new Person("Schmidt, Tobias"));
			// students = persons; // error!
			// otherwise, the first element in students wouldn't have a student
			// number...
		}

		// if the compile is satisfied (no error), then
		// we expect the following code to run without error:
		if (!students.isEmpty()) {
			Student s = students.get(0);
			System.out.println(s.getStudentNumber());
		}
	}

	/**
	 * Demonstrates that arrays are not completely type-save. The method throws
	 * a runtime exception because of a leak within the compile-time type
	 * checking procedure.
	 */
	static void startArrayDemo() {
		Number[] nums = new Double[10];
		Integer[] ints = new Integer[10];
		nums[1] = new Double(42.0); // ok
		nums = ints;
		nums[2] = new Double(43.0); // compiler: ok,
									// at runtime: ArrayStoreException
	}

	/** Persons are comparable. */
	public static class Person implements Comparable<Person> {
		private String name;

		Person(String name) {
			this.name = name;
		}

		@Override
		public int compareTo(Person p) {
			return name.compareTo(p.name);
		}

		@Override
		public String toString() {
			return name;
		}
	}

	/**
	 * Students can be compared, but do not implement
	 * <code>Comparable&lt;Student&gt;</code>.
	 */
	public static class Student extends Person {
		Student(String name, int number) {
			super(name);
		}

		int getStudentNumber() {
			return 0;
		}
	}

	/** Suitable for persons but not for students. */
	public static class MySortedList1<E extends Comparable<E>> {
		// ...
	}

	// now, let's fix the problem:

	/** Suitable for persons AND students. */
	public static class MySortedList2<E extends Comparable<? super E>> {
		// ...
	}

	/** Demonstrates some limitations of type variables. */
	static class LimitationsDemo<T> {
		Object attr;

		// T[] a = new T[100]; // error: cannot create a generic array of T

		/** Accepts all types of objects. */
		@SuppressWarnings("unchecked")
		void set(Object x) {
			// if (x instanceof T) // error: cannot perform instanceof checks...
			{
				// …
			}
			attr = (T) x; // cast has no effect at runtime - no cast exception!
		}

		/**
		 * Returns all types of objects, not necessary compatible to the value
		 * of T
		 */
		@SuppressWarnings("unchecked")
		T get() {
			return (T) attr;
		}

		/** Ends abnormally with a runtime exception. */
		@SuppressWarnings("unused")
		static void start() {
			LimitationsDemo<String> demo = new LimitationsDemo<String>();
			demo.set("b");
			String str = demo.get();
			demo.set(3); // ok (!)
			System.out.println(demo.attr);
			str = demo.get(); // runtime error: ClassCastException
		}
	}
}
