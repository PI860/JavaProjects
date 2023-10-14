package rl.prog2.demos.gui.swing.mvc;

import java.util.Locale;

/**
 * Provides a starter for the RPN Calculator application. The application
 * consists of three major components:
 * <ul>
 * <li>A model, maintaining the value stack and defining the arithmetic
 * operation on the contained values,</li>
 * <li>a view, defining the visual representation of the application based on
 * standard Swing components, and</li>
 * <li>a Controller which is responsible for controlling activities in response
 * to user events.</li>
 * 
 * @author Ruediger Lunde
 * 
 */
public class RPNCalculator {

	/** Starts the application. */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US); // application language is English!

		CalculatorModel model = new CalculatorModel();
		CalculatorController controller = new CalculatorController(model);
		CalculatorView view = new CalculatorView(model, controller);
		model.addObserver(view);

		view.setVisible(true);
	}
}
