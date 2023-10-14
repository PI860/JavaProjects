package rl.prog2.exercises.ss12set02.sequences;

public class Naturals implements Sequence {

	int next = 1;
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public int nextElement() {
		return next++;
	}

}
