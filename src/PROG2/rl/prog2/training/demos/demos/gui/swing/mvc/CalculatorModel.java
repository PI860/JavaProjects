package rl.prog2.demos.gui.swing.mvc;

import java.util.Observable;
import java.util.Stack;

/**
 * Implementation of a simple RPN calculator API which is suitable to be used as
 * model for a pocket calculator application. In this case, the view of the
 * application registers at the model as observer and is then informed about
 * every state change.
 * 
 * @author Ruediger Lunde
 */
public class CalculatorModel extends Observable {
	/**
	 * Stack with values. In arithmetic operations the two values on top are
	 * replaced by the result of the operation.
	 */
	private Stack<Double> values = new Stack<>();
	/**
	 * By default, 10 is used as radix and double values for computation. If
	 * other radix values are used, all stack values are casted to integer.
	 */
	private int radix = 10;

	/**
	 * Returns the currently used radix (used for conversions between text and
	 * binary representation of numbers).
	 */
	public int getRadix() {
		return radix;
	}

	/**
	 * Sets the radix (used for conversions between text and binary
	 * representation of numbers).
	 */
	public void setRadix(int radix) {
		if (this.radix != radix) {
			this.radix = radix;
			setChanged();
			notifyObservers();
		}
	}

	/** Clears the stack and informs all registered observers. */
	public void clear() {
		values.clear();
		setChanged();
		notifyObservers();
	}

	/** Returns the top element of the stack if any, otherwise not-a-number. */
	public double getCurrValue() {
		if (!values.isEmpty())
			return values.peek();
		else
			return Double.NaN;
	}

	/**
	 * Returns the second-highest element of the stack if any, otherwise
	 * not-a-number.
	 */
	public double getPrevValue() {
		if (values.size() > 1)
			return values.get(values.size() - 2);
		else
			return Double.NaN;
	}

	/**
	 * Pushes another value onto the stack and informs all observers about the
	 * change.
	 */
	public void enter(double value) {
		values.push(value);
		setChanged();
		notifyObservers();
	}

	/**
	 * Replaces the current top element and informs all registered observers
	 * about the change.
	 */
	public void updateCurrent(double value) {
		if (!values.isEmpty())
			values.pop();
		values.push(value);
		setChanged();
		notifyObservers();
	}

	/**
	 * Replaces the two top elements by their sum and informs all registered
	 * observers.
	 */
	public void add() {
		values.push(values.pop() + values.pop());
		setChanged();
		notifyObservers();
	}

	/**
	 * Replaces the two top elements by their difference and informs all
	 * registered observers.
	 */
	public void subtract() {
		values.push(-values.pop() + values.pop());
		setChanged();
		notifyObservers();
	}

	/**
	 * Replaces the two top elements by their product and informs all registered
	 * observers.
	 */
	public void multiply() {
		values.push(values.pop() * values.pop());
		setChanged();
		notifyObservers();
	}

	/**
	 * Replaces the two top elements by their quotient and informs all
	 * registered observers.
	 */
	public void divide() {
		values.push(1 / values.pop() * values.pop());
		setChanged();
		notifyObservers();
	}

	/**
	 * Translates a String representation of a value into a double number. The
	 * result depends on the selected radix.
	 */
	public double parse(String value) {
		if (radix == 10)
			return Double.parseDouble(value);
		else
			return Integer.parseInt(value, radix);
	}

	/**
	 * Translates a double representation of a value into a String. The result
	 * depends on the selected radix.
	 */
	public String format(double value) {
		if (radix == 10)
			return Double.toString(value);
		else
			return Integer.toString((int) value, radix);
	}
}
