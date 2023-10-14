package programming1lunde.prog1demos.inheritance;

public class LtdCounter extends Counter {
	private final int limit;
	
	public LtdCounter(int limit) {
		super();
		this.limit = limit;
	}
	
	public int getLimit() { return limit; }
	
	public void step() { // overrides the inherited version
		if (count < limit)
			super.step();
	}
	
	public static void main(String[] args) {
		Counter c = new LtdCounter(5);
		for (int i = 0; i < 10; i++) {
			c.step(); // calls redefined version
			System.out.print(c.read() + " ");
		}
	}
}
