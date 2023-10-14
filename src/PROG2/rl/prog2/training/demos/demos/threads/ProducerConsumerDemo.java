package rl.prog2.demos.threads;

import java.util.ArrayDeque;

/**
 * Demonstrates synchronization with <code>wait()</code> and <code>notify()</code>.
 * 
 * @author Ruediger Lunde
 */
public class ProducerConsumerDemo {

	static class Depot<P> {
		private ArrayDeque<P> products = new ArrayDeque<>();

		public synchronized void add(P product) {
			products.add(product);
			notify();
		}

		public synchronized P remove() {
			while (products.isEmpty()) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			return products.remove();
		}
	}
	
	static Depot<String> depot = new Depot<>();
	
	static class Producer extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++)
				depot.add("Product " + i);
		}
	}
	
	static class Consumer extends Thread {
		@Override
		public void run() {
			for (int i = 1; i <= 100; i++)
				System.out.println(depot.remove());
		}
	}
	
	public static void main(String[] args) {
		Producer p = new Producer();
		Consumer c = new Consumer();
		c.start();
		p.start();
	}
}
