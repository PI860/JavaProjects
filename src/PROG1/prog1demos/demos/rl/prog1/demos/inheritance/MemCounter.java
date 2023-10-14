package programming1lunde.prog1demos.demos.rl.prog1.demos.inheritance;

public class MemCounter extends Counter {
	private int memory;
	
	public void mark() { memory = count; }
	public void recall() { count = memory; }
	
	
	public static void main(String[] args) {
		MemCounter c = new MemCounter();
		c.step(); // inherited from Counter
		c.mark(); //
		c.reset(); // inherited from Counter
		c.recall();
	}
}
