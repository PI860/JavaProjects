package programming1lunde.prog1demos.inheritance.abstractcounter;

public abstract class Counter {
	protected int count;
	public abstract void step();
	public int read() { return count; }
	public void reset() { count = 0; }
}

