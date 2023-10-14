package PROG1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This utility class provides basic read and write functionality for
 * command line applications. No instantiation is needed because all methods
 * are static.
 * @author R. Lunde
 */
public abstract class Terminal {

    private static BufferedReader reader;

    private static BufferedReader getReader() {
        if (reader == null) {
            InputStreamReader r = new InputStreamReader(System.in);
            reader  = new BufferedReader(r);
        }
        return reader;
    }

    /** Writes the prompt string and reads a string terminated by new line. */
    public static String readString(String prompt) {
        if (!prompt.equals(""))
            System.out.print(prompt + ": ");
        try {
            return getReader().readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int readInt(String prompt) {
        int result = 0;
        try {
            result = Integer.parseInt(readString(prompt));
        } catch (Exception e) {
            write("Please provide an integer number!");
            result = readInt(prompt);
        }
        return result;
    }

    public static double readDouble(String prompt) {
        double result = 0.0;
        try {
            result = Double.parseDouble(readString(prompt));
        } catch (Exception e) {
            write("Please provide a floating point number!");
            result = readDouble(prompt);
        }
        return result;
    }

    // Neue Methode von P. Pyczot:
    public static long readLong(String prompt) {
        long result = 0;
        try {
            result = Long.parseLong(readString(prompt));
        } catch (Exception e) {
            write("Please provide a double number!");
            result = readLong(prompt);
        }
        return result;
    }

    public static char readChar() {
        int result = 0;
        try {
            result = getReader().read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (char) result;
    }

    public static void write(String s) {
        System.out.println(s);
    }

    public static void write(int s) {
        System.out.println(s);
    }

    public static void write(double s) {
        System.out.println(s);
    }
}