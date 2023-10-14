package rl.prog2.exercises.ss12set02.sequences;

public class ZapMultiples extends Filter {

	private int base;
	
	public ZapMultiples(Sequence seq, int base) {
		super(seq);
		this.base = base;
		computeNext();
	}

	@Override
	protected boolean testPassCondition(int element) {
		return element % base != 0;
	}
}
