package programming1lunde.prog1demos.inheritance;

public class Counter {
	protected int count;
	
	// default constructor is sufficient
	
	public void step() { count++; }
	public int read() { return count; }
	public void reset() { count = 0; }
}
