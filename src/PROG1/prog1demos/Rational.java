package PROG1.prog1demos;
/**
 * Incomplete implementation of rational numbers.
 * @author Ruediger Lunde
 */
public class Rational {

	/** Numerator (Zaehler). */
	private int num;
	/** Denominator (Nenner). */
	private int denom;
	
	/** Creates a rational number with denominator 1. */
	public Rational(int n) {
		this(n, 1);
	}
	
	/**
	 * Creates a new rational number. The representation
	 * is automatically reduced and an exception is thrown
	 * if the denominator is zero.
	 */
	public Rational(int num, int denom) {
		this.num = num;
		this.denom = denom;
		if (denom == 0)
			throw new ArithmeticException("/ by zero");
		reduce();
	}
	
	/** Multiplies this number with the specified one. */
	public Rational multiply(Rational r) {
		return new Rational(num * r.num, denom * r.denom);
	}
	
	/**
	 * Makes sure that the denominator is positive and divides
	 * numerator and denominator by their greatest common divisor.
	 */
	private void reduce() {
		if (denom < 0) {
			denom = -denom;
			num = -num;
		}
		// compute gcd using Euclid's algorithm:
		int m = Math.abs(num);
		int n = denom;
		int r = m%n;
		while (r > 0) {
			m = n;
			n = r;
			r = m%n;
		}
		if (n > 0) {
			num /= n;
			denom /= n;
		}
//      // quick and dirty:		
//		for (int i = 2; i < Math.min(denom, num); i++)
//			if (denom % i == 0 && num % i == 0) {
//				denom /= i;
//				num /= i;
//				i = 1;
//			}
	}
	
	/**
	 * Returns a String representation of the rational number.
	 * Useful for printing and debugging.
	 */
	public String toString() {
		return num + "/" + denom;
	}
	
	/**
	 * For testing...
	 */
	public static void main(String[] args) {
		Rational r = new Rational(3, 6);
		Rational s = new Rational(2, -5);
		System.out.println("r*s: " + r.multiply(s));
		System.out.println("r  : " + r);
		System.out.println("s  : " + s);
	}
}
