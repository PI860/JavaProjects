package rl.prog2.demos.gui.fx.dice.mvc.controller;

/**
 * Defines the protocol for the communication between view and controller of the
 * dice simulator. Here, abstract commands are sufficient. Often, also handlers
 * for mouse- and other events are included.
 * 
 * @author Ruediger Lunde
 *
 */
public interface DiceSimulatorController {
	void execute(DiceSimulatorCmd cmd, Object source);
}
