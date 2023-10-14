package rl.prog2.demos.container;

import java.util.Arrays;

public class MyArrayList implements Cloneable {
	private Object[] elements; // array length == current capacity
	private int size; // number of indices used right now
	
	public MyArrayList() {
		this(10);
	}
	
	public MyArrayList(int initialCapacity) {
		elements = new Object[initialCapacity];
		size = 0;
	}
	
	public Object get(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException("Index " + index + " too high.");
		return elements[index];
	}
	
	public void set(int index, Object value) {
		if (index >= size)
			throw new IndexOutOfBoundsException("Index " + index + " too high.");
		elements[index] = value;
	}
	
	public int size() {
		return size;
	}

	public void add(Object value) {
		if (size == elements.length)
			elements = Arrays.copyOf(elements, size*2);
		elements[size++] = value;
	}
	
	public Object remove(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException("Index " + index + " too high.");
		Object result = elements[index];
		for (int i = index+1; i < size; i++)
			elements[i-1] = elements[i];
		size--;
		if (2*Math.max(size*2, 10) < elements.length)
			elements = Arrays.copyOf(elements, elements.length / 2);
		return result;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer("[ ");
		for (int i = 0; i < size; i++)
			result.append(get(i) + " ");
		result.append("]");
		return result.toString();
	}
	
	@Override
	public MyArrayList clone() {
		MyArrayList result = null;
		try {
			result = (MyArrayList) super.clone();
			result.elements = Arrays.copyOf(elements, elements.length);
		} catch (CloneNotSupportedException e) {
			// replace by a RuntimeException (will in fact never be called!)
			throw new UnsupportedOperationException(e);
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		MyArrayList list = new MyArrayList(2);
		//ArrayList<Object> c = new ArrayList<Object>();
		
		// add numbers
		for (int i = 0; i < 202; i++)
			list.add(i);
		System.out.println("original: " + list);
		
		MyArrayList copy = list.clone();
		for (int i = 0; i < 100; i++)
			list.remove(0);
		System.out.println("removed : " + list);
		System.out.println("old copy: " + copy);
		
		//startTypeSavetyDemo();		
	}
	
	@SuppressWarnings("unused")
	private static void startTypeSavetyDemo() {
		MyArrayList c = new MyArrayList();
		c.add(new Integer(42));
		c.add(new Bird());
		int num = ((Integer) c.get(0)).intValue();
		Fish fish = (Fish) c.get(1); // Oops!
		
		System.out.println(num);
		System.out.println(fish);
	}
	
	public static class Fish {}
	public static class Bird {}
}

