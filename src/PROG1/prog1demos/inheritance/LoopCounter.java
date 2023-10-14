package programming1lunde.prog1demos.inheritance;

public class LoopCounter extends LtdCounter {
	
	public LoopCounter(int limit) {
		super(limit);
	}
	
	public void step() {
		if (count == getLimit())
			count = 0;
		else
			count++;
	}
}
