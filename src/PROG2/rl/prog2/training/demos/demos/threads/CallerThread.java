package rl.prog2.demos.threads;

/**
 * Demonstrates how to create and start threads.
 * 
 * @author Ruediger Lunde
 */
public class CallerThread extends Thread {
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("Hi, this is " + getName() + "! (call " + i + ")");
			Thread.yield();
		}
	}

	/** Creates two caller threads and starts them. */
	public static void main(String[] args) {
		CallerThread peter = new CallerThread();
		peter.setName("Peter");
		//peter.setDaemon(true);
		CallerThread sylvia = new CallerThread();
		//sylvia.setDaemon(true);
		sylvia.setName("Sylvia");
		peter.start();
		sylvia.start();
		// new Thread().start(); // does nothing!
//		Runnable task = new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 1; i <= 10; i++)
//					System.out.println("Hi there!");
//			}
//		};
//		new Thread(task).start();
	}

	void doFirst() {
	}

	void doSecond() {
	}

	void doSomething() {
		doFirst();
		try {
			Thread.sleep(1000); // nothing to do right now...
		} catch (InterruptedException e) {
			e.printStackTrace(); // oops, someone has woken me up!
		}
		doSecond();
	}
}
