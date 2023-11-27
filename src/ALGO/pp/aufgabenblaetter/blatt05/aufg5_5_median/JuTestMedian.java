package ALGO.pp.aufgabenblaetter.blatt05.aufg5_5_median;

//import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;

public class JuTestMedian {

	final static double DELTA = 0.0;

	@Test
	public void testMedian1() {
		double[] a1 = { 3, 1, 2, 4, 8, 27, 5 };
		assertEquals(4, Median.median(a1), DELTA);
	}

	@Test
	public void testMedian2() {
		double[] a2 = { 5, 1, 2, 1, 3, 99, 10000 };
		assertEquals(3, Median.median(a2), DELTA);
	}

	@Test
	public void testMedian3() {
		double[] a3 = { 1, 2, 3, 4, 50 };
		assertEquals(3, Median.median(a3), DELTA);
	}

	@Test
	public void testMedian4() {
		double[] a4 = { 1, 2, 3, 4, 5, 60 };
		assertEquals(4, Median.median(a4), DELTA);
	}

	@Test
	public void testMedian5() {
		double[] a5 = { 3, 4, 5, 60, 2, 1 };
		assertEquals(4, Median.median(a5), DELTA);
	}

}
