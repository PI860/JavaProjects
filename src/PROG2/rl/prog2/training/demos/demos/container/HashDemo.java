package rl.prog2.demos.container;

import java.util.HashSet;

public class HashDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> lovedMuppets = new HashSet<String>();
		lovedMuppets.add("bert");
		lovedMuppets.add("ernie");
		lovedMuppets.add("kermit");
		System.out.println(lovedMuppets.contains("bert")); // true
		lovedMuppets.remove("bert");
		System.out.println(lovedMuppets.contains("bert")); // false
		System.out.println(lovedMuppets.size()); // 2
	}
}
