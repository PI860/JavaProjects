package programming1lunde.myprogrammsvorlesung.project24_Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Paulina Pyczot
 * @date 12.01.2023
 **/

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in); //nutzbar für alle Methoden, benötigt für readInt-Methode
    public int readInt (String prompt) {
        while (true) {
            try {
                System.out.println(prompt + ": ");
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(ex.getClass().getSimpleName());
                //System.out.println(ex.getClass().getName()); //gibt Name der Exception an
                //System.out.println(ex.getMessage()); //gibt aus: null, wenn Text keine Zahl war
                //System.out.println("This was not a number.");
                scanner.nextLine();
            }
        }

    }
    public static void doSomethingDifficult() throws MyException /*throws Exception*/ {
        System.out.println("starting 1");
        if (true) //disaster
            //throw new Exception("Something went wrong..."); //funktioniert nur, wenn "throws Exception" oben in void-Methode gegeben
            //throw new RuntimeException("Something went wrong..."); //funktioniert auch ohne "throws Exception"
            throw new MyException("My Exception is..."); //printStackTrace kommt in der falschen Reihenfolge raus (zuerst finishing main, dann Exception - eigentlich findet es andersrum statt; solange finishing main ausgeführt wird, ist alles richtig gelaufen (da finishing main Ende vom Code darstellt))
        System.out.println("finishing 1");

    }

    public static void doSomething() throws MyException{
        System.out.println("starting 2");
        //doSomething();
        doSomethingDifficult(); // benötigt "throws MyExcpetion" in void-Methode
        System.out.println("finishing 2");

    }
    public static void main(String[] args) /*throws MyException*/{
        int i = new InputUtil().readInt("Please provide a number");
        System.out.println("starting main");
        //doSomethingDifficult();
        try {
            doSomething(); //benötigt "throws MyException", ist aber quick and dirty und nicht schön, deshalb Lösung mit try
        } catch (MyException ex) { //speziellere Exception VOR der allgemeingültigeren definieren
            System.out.println("Handling MyE");
            ex.printStackTrace(); //exception-Handler, ohne ist verpöhnt
        } /*catch (Error err) {
            System.out.println("huch!"); //Error-Message stoppt den ErrorStackTrace (gibt ganz viele Fehlermeldungen aus), nicht zur Nachahmung empfohlen
        }*/catch (Exception ex) {
            System.out.println("Handling Ex");
            ex.printStackTrace();
        }
        System.out.println("finishing main");
        /**
         * Ausgabe:
         * starting main
         * starting 1
         * Exception in thread "main" java.lang.RuntimeException: Something went wrong...
         * 	at programming1lunde.myprogrammsvorlesung.project24_Exceptions.InputUtil.doSomethingDifficult(InputUtil.java:13)
         * 	at programming1lunde.myprogrammsvorlesung.project24_Exceptions.InputUtil.main(InputUtil.java:21)
         */
    }

    public static class MyException extends Exception /*Throwable*/ { //Throwable wäre möglich, macht aber keinen Sinn
        //Konstruktor mit Message:
        public MyException (String msg) {
            super(msg);
        }
        //2. Konstruktor mit Message & Cause:
        public MyException (String msg, Throwable cause) {
            super(msg, cause);
        }

    }
}
