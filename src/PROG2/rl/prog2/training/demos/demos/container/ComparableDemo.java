package rl.prog2.demos.container;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * Demonstrates how to use the Comparable interface and the Comparator class.
 * 
 * @author Ruediger Lunde
 * 
 */
public class ComparableDemo {

	/**
	 * Sorts a list using the <code>Collections.sort(...)</code> method and
	 * organizes a <code>TreeSet</code>.
	 */
	public static void main(String[] args) {
		List<Person> scientists = new LinkedList<Person>();
		scientists.add(new Person("Galileo", "Galilei", 1564));
		scientists.add(new Person("Isaac", "Newton", 1642));
		scientists.add(new Person("Albert", "Einstein", 1879));
		// use the compareTo method to establish the default order:
		Collections.sort(scientists);
		for (Person p : scientists)
			System.out.println(p.forename + " " + p.surname + " (" + p.birth
					+ ")");
		System.out.println();
		// use a comparator to establish a special order:
		Collections.sort(scientists, new BirthComparator());
		for (Person p : scientists)
			System.out.println(p.forename + " " + p.surname + " (" + p.birth
					+ ")");
		System.out.println();

		TreeSet<Person> scientists2 = new TreeSet<Person>();
		scientists2.add(new Person("Galileo", "Galilei", 1564));
		scientists2.add(new Person("Isaac", "Newton", 1642));
		scientists2.add(new Person("Albert", "Einstein", 1879));
		// note: persons are printed in default order - why?
		for (Person p : scientists2)
			System.out.println(p.forename + " " + p.surname + " (" + p.birth
					+ ")");

	}

	public static class Person implements Comparable<Person> {
		String forename;
		String surname;
		int birth;

		Person(String fname, String sname, int birth) {
			forename = fname;
			surname = sname;
			this.birth = birth;
		}

		@Override
		public int compareTo(Person p) {
			// String implements Comparable<String>
			int result = surname.compareTo(p.surname);
			if (result == 0)
				result = forename.compareTo(p.forename);
			return result;
		}
	}

	public static class BirthComparator implements Comparator<Person> {
		public int compare(Person p0, Person p1) {
			if (p0.birth < p1.birth)
				return -1;
			else if (p0.birth > p1.birth)
				return 1;
			else
				return 0;
		}
	}
}
