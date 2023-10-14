package rl.prog2.exercises.ss12set04;

/**
 * Represents a train. A train consists of exactly one locomotive to
 * which cars can be attached.
 * @author Ruediger Lunde
 */
public class Train {
	private Locomotive locomotive;

	public Train(Locomotive l) {
		locomotive = l;
	}

	public boolean hasCars() {
		return locomotive.getFirst() != null;
	}
	
	public void add(int index, Car car) {
		if (index == 0) {
			car.setNext(locomotive.getFirst());
			locomotive.setFirst(car);
		} else {
			Car curr = locomotive.getFirst();
			for (int i = 1; i < index; i++)
				curr = curr.getNext();
			car.setNext(curr.getNext());
			curr.setNext(car);
		}
	}

	public int getPassengers() {
		int result = 0;
		for (Car curr = locomotive.getFirst(); curr != null; curr = curr
				.getNext())
			result += curr.getCapacity();
		return result;
	}

	public int getLength() {
		int result = locomotive.getLength();
		for (Car curr = locomotive.getFirst(); curr != null; curr = curr
				.getNext())
			result += curr.getLength();
		return result;
	}

	public Car removeFirst() {
		Car result = locomotive.getFirst();
		locomotive.setFirst(result.getNext());
		result.setNext(null);
		return result;
	}

	public void relink(Train train) {
		while (train.hasCars())
			add(0, train.removeFirst());
	}

	public void revert() {
		Car curr = locomotive.getFirst();
		Car next = null;
		locomotive.setFirst(null);
		while (curr != null) {
			next = curr.getNext();
			add(0, curr);
			curr = next;
		}	
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("L(" + locomotive.getLength() + ", "
				+ locomotive.getType() + ")");
		for (Car curr = locomotive.getFirst(); curr != null; curr = curr
				.getNext())
			result.append(" C(" + curr.getLength() + ", " + curr.getCapacity()
					+ ")");
		return result.toString();
	}
}
