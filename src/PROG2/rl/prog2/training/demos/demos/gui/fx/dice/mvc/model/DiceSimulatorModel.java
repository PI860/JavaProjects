package rl.prog2.demos.gui.fx.dice.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Model of the dice simulator. It defines the state of the simulator and
 * operations to change the state.
 * 
 * @author Rüdiger Lunde
 *
 */
public class DiceSimulatorModel extends Observable {

	/** Number of dice for next throw. */
	private int dieCount; // no properties to avoid JavaFX dependency
	/** Number of faces to be used in all dice for next throw. */
	private int faceCount;
	/** Collection of dices representing the result of the last die actions. */
	private List<Die> dice;

	public DiceSimulatorModel() {

		dieCount = 1;
		faceCount = 6;
		dice = new ArrayList<Die>();
	}

	// getter and setter...
	
	public int getDieCount() {
		return dieCount;
	}

	public void setDieCount(int dieCount) {
		if (dieCount != this.dieCount) {
			this.dieCount = dieCount;
			dice.clear();
			setChanged();
			notifyObservers();
		}
	}

	public int getFaceCount() {
		return faceCount;
	}

	public void setFaceCount(int faceCount) {
		if (faceCount != this.faceCount) {
			this.faceCount = faceCount;
			dice.clear();
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Returns the current dice state and should only be called for read access.
	 */
	public List<Die> getDice() {
		return dice;
	}

	public void putAside(int dieIndex, boolean state) {
		if (dice.get(dieIndex).isPutAside() != state) {
			dice.get(dieIndex).putAside(state);
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Removes all the dice.
	 */
	public void clearDice() {
		if (!dice.isEmpty()) {
			dice.clear();
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Performs a throw. The result depends on the specified die and face counts
	 * as well as the current put-aside status.
	 */
	public void throwDice() {
		if (dice.isEmpty()) {
			for (int i = 0; i < dieCount; i++) {
				Die die = new Die(faceCount);
				dice.add(die);
			}
		}
		for (Die die : dice) {
			if (!die.isPutAside())
				die.throwDie();
		}
		setChanged();
		notifyObservers();
	}
}