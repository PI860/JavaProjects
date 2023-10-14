package rl.prog2.exercises.ss12set02.sequences;

public abstract class Filter implements Sequence {

	private Sequence seq;
	private boolean hasNext;
	private int next;
	
	public Filter(Sequence seq) {
		this.seq = seq;
	}
	
	@Override
	public boolean hasNext() {
		return hasNext;
	}

	@Override
	public int nextElement() {
		int result = next;
		computeNext();
		return result;
	}
	
	protected abstract boolean testPassCondition(int element);
	
	protected void computeNext() {
		hasNext = false;
		if (seq.hasNext()) {
			do {
				next = seq.nextElement();
				if (testPassCondition(next))
					hasNext = true;
			} while (!hasNext && seq.hasNext());
		}
	}
}
