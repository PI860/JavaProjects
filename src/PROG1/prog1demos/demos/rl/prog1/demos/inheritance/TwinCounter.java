package programming1lunde.prog1demos.demos.rl.prog1.demos.inheritance;

public class TwinCounter implements Cloneable {
	//private Counter first = new Counter();
	//private Counter second = new Counter();
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		TwinCounter result = (TwinCounter) super.clone();
		//result.first = result.first.clone();
		//result.second = result.first.clone();
		return result;
	}
	
	
	
	
}
