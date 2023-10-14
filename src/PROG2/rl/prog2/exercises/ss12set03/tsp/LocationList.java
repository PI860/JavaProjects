package rl.prog2.exercises.ss12set03.tsp;

/**
 * List of locations. It is used to represent maps as well as tours.
 * 
 * @author Ruediger Lunde
 */
public class LocationList implements Cloneable {
	private Location[] locations;
	private int size;

	public LocationList(int capacity) {
		size = 0;
		locations = new Location[capacity];
	}

	public Location get(int i) {
		return locations[i];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/* Checks whether the provided location is already part of the list. */
	public boolean contains(Location loc) {
		for (int i = 0; i < size; i++)
			if (locations[i] == loc)
				return true;
		return false;
	}

	public void add(Location loc) {
		if (size == locations.length)
			throw new RuntimeException(
					"Cannot add location because the list is full.");
		else
			locations[size++] = loc;
	}

	public void removeLast() {
		if (size == 0)
			throw new RuntimeException(
					"Cannot remove location because the list is empty.");
		else
			locations[--size] = null;
	}

	/** Deep copy needed! */
	public LocationList clone() {
		LocationList result;
		try {
			result = (LocationList) super.clone();
			result.locations = result.locations.clone();
		} catch (CloneNotSupportedException e) {
			// we throw a RuntimeException, so there is no need to be declare
			// it. Anyway, this will never happen!
			throw new UnsupportedOperationException("Object cannot be cloned.",
					e);
		}
		return result;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("[ ");
		for (int i = 0; i < size; i++) {
			Location loc = locations[i];
			result.append(loc.getName() + " ");
		}
		result.append("]");
		return result.toString();
	}
}
