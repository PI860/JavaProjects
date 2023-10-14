package rl.prog2.exercises.ss12set02.sequences;

public class Evens extends Filter {

	public Evens(Sequence seq) {
		super(seq);
		computeNext();
	}

	@Override
	protected boolean testPassCondition(int element) {
		return element % 2 == 0;
	}

}
