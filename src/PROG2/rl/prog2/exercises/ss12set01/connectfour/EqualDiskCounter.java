package rl.prog2.exercises.ss12set01.connectfour;

/**
 * Helper class for finding win situations.
 * 
 * @author Ruediger Lunde
 */
public class EqualDiskCounter {
	int counter;
	Disk lastDisk;

	/**
	 * Sets the counter to zero. Call this method before starting the analysis
	 * of a new line.
	 */
	public void startLine() {
		counter = 0;
	}

	/**
	 * Updates the counter based on the next disk in line. Disk colors are
	 * compared by == (fast), so never use different string representation for
	 * the same color.
	 * 
	 * @return true if 4 or more adjacent disks of the same color were found.
	 */
	public boolean analyzeNext(Disk disk) {
		if (disk == null)
			counter = 0;
		else if (counter == 0 || lastDisk.getColor() != disk.getColor())
			counter = 1;
		else
			counter++;
		lastDisk = disk;
		return counter >= 4;
	}
	
	public Disk getLastAnalyzedDisk() {
		return lastDisk;
	}
}
