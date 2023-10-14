package rl.prog2.demos.gui.fx.dice.mvc.model;

import java.util.Random;

public class Die {
	private static Random rand = new Random();
	private int faceCount;
	private int faceValue;
	private boolean isPutAside;
	
	public Die() {
		this(6);
	}
	
	public Die(int faceCount) {
		this.faceCount = faceCount;
		faceValue = 1;
	}
	
	public boolean isPutAside() {
		return isPutAside;
	}
	
	public void putAside(boolean val) {
		isPutAside = val;
	}
	
	
	public int getFaceValue() {
		return faceValue;
	}
	
	public void throwDie() {
		faceValue = rand.nextInt(faceCount) + 1;
	}
}
