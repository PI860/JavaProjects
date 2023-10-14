package PROG1.prog1demos;

/**
 * Enumeration which represents the days of a week.
 * @author Ruediger Lunde
 */
public enum Day {
	MON, TUE, WED, THU, FRI, SAT, SUN;
	
	public boolean isWeekend() {
		return this == SAT || this == SUN;
	}
	
	public static void main(String[] args) {
		Day today = Day.MON;
		// if (today == Sex.FEMALE) {} // error!
		switch (today) { // now we can even use switch!
		case SAT:
		case SUN:
			System.out.println(":-)"); break;
		case MON:
			System.out.println(":-("); break;
		default:
			System.out.println("well...");
		}
	
		for (Day d : Day.values())
			System.out.println(d.name() + ": " + d.ordinal());
	}
	
	enum Sex { FEMALE, MALE }
}
