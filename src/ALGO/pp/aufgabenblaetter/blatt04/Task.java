package ALGO.pp.aufgabenblaetter.blatt04;

/** Description of a task with priority */
public class Task {
	private Priority prio;
	private String description;
	
	public Task(Priority prio, String description) {
		this.prio = prio;
		this.description = description;
	}
	
	public String toString() {
		return description + " (" + prio + ")";
	}

	public Priority getPriority() {
		return prio;
	}

	public String getDescription() {
		return description;
	}
	
	
}