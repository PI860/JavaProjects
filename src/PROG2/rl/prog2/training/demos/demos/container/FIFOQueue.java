package rl.prog2.demos.container;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demonstrates how a <code>LinkedList</code> can be used as first-in-first-out
 * queue.
 * 
 * @author Ruediger Lunde
 * 
 */
public class FIFOQueue {

	/** Starts the demo. */
	public static void main(String[] args) {
		// the LinkedList class implements the Queue interface
		Queue<Integer> queue = new LinkedList<Integer>();

		// insert elements into the queue (at the end)
		queue.add(1);
		queue.add(2);
		queue.add(3);

		// extracts the elements (at the front)
		// input order is preserved
		while (!queue.isEmpty()) {
			int element = queue.remove();
			System.out.println(element);
		}
	}
}
