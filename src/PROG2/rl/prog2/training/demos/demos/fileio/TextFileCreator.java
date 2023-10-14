package rl.prog2.demos.fileio;

import java.io.FileWriter;
import java.io.IOException;

public class TextFileCreator {

	/** Creates a text file. */
	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("duda.txt");
			writer.write("Hallo, du da!");
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
