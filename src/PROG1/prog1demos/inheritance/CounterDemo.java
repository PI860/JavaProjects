package programming1lunde.prog1demos.inheritance;

public class CounterDemo {
	public static void printCounterState(Counter counter) {
		System.out.print("counter state: " + counter.read());
		if (counter instanceof LtdCounter) {
			LtdCounter lc = (LtdCounter) counter;
			if (counter.read() == lc.getLimit())
				System.out.print(" (limit reached)");
		}
		System.out.println();
	}
	
	public static void printCounterState1(Counter counter) {
		System.out.print("counter state: " + counter.read());
		if (counter instanceof LtdCounter) {
			if (counter.read() == ((LtdCounter) counter).getLimit())
				System.out.print(" (limit reached)");
		}
		System.out.println();
	}
	
	// overloading does not work... why?
	public static void printCounterState2(Counter counter) {
		System.out.println("counter state: " + counter.read());
	}
	
	public static void printCounterState2(LtdCounter counter) {
		System.out.print("counter state: " + counter.read());
		if (counter.read() == counter.getLimit())
			System.out.print(" (limit reached)");
		System.out.println();
	}
	
	public static void main(String[] args) {
		Counter counter = new LoopCounter(2);
		for (int i = 0; i < 5; i++) {
			counter.step();
			printCounterState(counter);
		}
		System.out.println();
		counter = new MemCounter();
		for (int i = 0; i < 5; i++) {
			counter.step();
			printCounterState(counter);
		}
	}
}
