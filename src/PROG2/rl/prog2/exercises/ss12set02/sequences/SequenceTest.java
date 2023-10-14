package rl.prog2.exercises.ss12set02.sequences;

public class SequenceTest {

	public static void print(Sequence seq) {
		for (int i = 0; seq.hasNext() && i < 10; i++) {
			System.out.print(seq.nextElement());
			if (seq.hasNext())
				System.out.print(", ");
		}
		System.out.print(seq.hasNext() ? "..." : ".");
	}
	
	public static void println(Sequence seq) {
		print(seq);
		System.out.println();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		println(new Naturals());
		println(new Range(7, 14));
		println(new Evens(new Range(7, 14)));
		println(new ZapMultiples(new Range(7, 14), 3));
		//println(new ZapMultiples(new Evens(new Naturals()), 2)); // runs forever
		println(new ZapMultiples(new Evens(new Range(1, 200)), 2));
		println(new PrimeNumbers());

	}

}
