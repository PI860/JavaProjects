package rl.prog2.demos.container;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Demonstrates how to use a <code>HashMap</code>.
 * @author Ruediger Lunde
 *
 */
public class HashMapDemo {

	/** Starts the demo. */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// create a hash table with String-keys and Integer-values
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		map.put("Bach, Sebastian", 16850321); // add some entries
		map.put("Lionheart, Richard", 0);
		map.put("Newton, Isaac", 16430104);
		map.put("Lionheart, Richard", 1); // overwrite value for L.
		map.put("Lionheart, Richard", 11570000); // overwrite it again

		int phone = map.get("Lionheart, Richard"); // phone = 11570000
		// check, whether an entry for Bach exists
		if (map.containsKey("Bach, Sebastian"))
		  System.out.println(map.get("Bach, Sebastian")); // print number 
		else
		  System.out.println("not found"); // print error message

		map.remove("Bach, Sebastian"); // remove the entry for Bach
		
		
		
		Set<String> names = map.keySet();
		for (String name : names)
			System.out.println(name);
		// Newton, Isaac
		// Lionheart, Richard
		
		Collection<Integer> numbers = map.values();
		for (Integer n : numbers)
			System.out.println(n);
		// 16430104
		// 11570000
		
		for (Map.Entry<String, Integer> e : map.entrySet())
			System.out.printf("%s: %s%n", e.getKey(), e.getValue());
		// Newton, Isaac: 16430104
		// Lionheart, Richard: 11570000
		
		names.remove("Newton, Isaac");
		names.add("abc");
		System.out.println(map.get("Newton, Isaac"));
		// null
	}

}
