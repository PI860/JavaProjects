package ALGO.pp.aufgabenblaetter.blatt04;

/**
 * Defines a list of tasks with priority
 * 
 */
public class TaskList {

	/** List of tasks */
	private Task[] list;

	/** Number of task in the list */
	private int count = 0;

	/** generates an empty list with the given capacity
	 * 
	 */
	public TaskList(int capacity) {
		list = new Task[capacity];
	}

	
	/**
	 * Adds another task to the end of the list
	 * 
	 * @param t a task
	 */
	public void add(Task t) {
		list[count] = t;
		count++;
	}

	
	/** returns the number of tasks in the list */
	public int size() {
		return count;
	}

	/**
	 * Returns the age group of the person standing at position i in the row.
	 * Position numbers start with index 0.
	 * 
	 * @param index
	 *            position within the row
	 * @return age group of person standing at position index
	 */
	public Priority getPriority(int index) {
		return list[index].getPriority();
	}


	/**
	 * Exchanges tasks at position i and j  in the list (where i < count and j < count)
	 */
	public void swap(int i, int j) {
		Task tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}

	/**
	 * Prints all tasks in the list
	 */
	public void print() {
		System.out.println("List of " + count + " tasks:");
		for (int i = 0; i < count; i++) {
			System.out.println(list[i]);
		}
	}



	/**
	 * Checks whether the tasks in the list are correctly sorted according to priority (highest priority first).
	 */
	public boolean isOrdered() {
		for (int pos = 0; pos < count - 1; pos++) {
			Priority p1 = list[pos].getPriority();
			Priority p2 = list[pos+1].getPriority();
			
			if (p1.ordinal() > p2.ordinal()) {
				return false;
			}
		}
		return true;
	}

}
