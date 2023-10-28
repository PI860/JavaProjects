package ALGO.pp.aufgabenblaetter.blatt02;

import java.util.Set;
import java.util.TreeSet;

public class Aufg2_1_Brackets {

	/** generates all correctly nested sequences of round brackets
	 *  that can be build from n pair of brackets.*/
	public static Set<String> nestedBrackets(int n) {
		//TODO
		//TODO
		//TODO
		//TODO
		return null; 		//TODO

	}
	
	
	public static void main(String[] args) {
		Set<String> res = nestedBrackets(3);
		int count = 0;
		for (String s : res) {
			count++;
			System.out.println(count + ": " + s);
		}

	}
}
