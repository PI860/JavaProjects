package PROG1.prog1demos.demos.rl.prog1.demos;

/**
 * Represents the days of a week without using enumerations.
 * @author Ruediger Lunde
 */
public class Day1 {
	public final static Day1 MON = new Day1("MON", 0);
	public final static Day1 TUE = new Day1("TUE", 1);
	public final static Day1 WED = new Day1("WED", 2);
	public final static Day1 THU = new Day1("THU", 3);
	public final static Day1 FRI = new Day1("FRI", 4);
	public final static Day1 SAT = new Day1("SAT", 5);
	public final static Day1 SUN = new Day1("SUN", 6);
	private final String name;
	private final int ordinal;
	
	private Day1(String name, int ordinal) {
		this.name = name;
		this.ordinal = ordinal;
	}
	
	public String name() {
		return name;
	}
	
	public int ordinal() {
		return ordinal;
	}
	
	public boolean isWeekend() {
		return this == SAT || this == SUN;
	}
	
	public static Day1[] values() {
		return new Day1[] { MON, TUE, THU, FRI, SAT, SUN };
	}
	
	public static void main(String[] args) {
		Day1 today = Day1.MON;
		if (today.isWeekend())
			System.out.println(":-)");
		else if (today == Day1.MON)
			System.out.println(":-(");
		else
			System.out.println("well...");
		for (Day1 d : Day1.values())
			System.out.println(d.name() + ": " + d.ordinal());
	}
}
