package PROG1.abgaben.uebungsblatt2;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet02 {
    public static void main (String[] args) {
        // Aufgabe 2 (Einlesen einer Zahl von der Konsole über die Hilfsklasse Terminal):
        int num = Terminal.readInt("Provide a number");

        System.out.println("Sum:          " + computeSum(num));

        //A3 a) Rückgabe aus Methode printSequence1 von result1 (= Elemente der Folge n^2):
        System.out.print("Sequence 1:   ");
        printSequence1(num);

        //A3 b) Rückgabe aus Methode printSequence2 von result2 (= Elemente der Folge (n+1)*(-1)):
        System.out.print("Sequence 2:   ");
        printSequence2(num);

        //A3 c) Rückgabe aus Methode printSequence3 von result3 (= einzelne Elemente der Gauß-Summe: Summe von 1 bis n über k = (n*(n+1))/2):
        System.out.print("Sequence 3:   ");
        printSequence3(num);
        // Alternative Variante zur Berechnung von A3 c):
        //printSequence3Altern(num);

        //A4 Rückgabe aus Methode printTriangle der Dreieckszahlen:
        System.out.println("Sequence 4:");
        printTriangle(num);
    }
    public static int computeSum (int number) {
        int result = 0;
        int i= 1;
        while(i<= number) {
        result = result + i;
        i= i+ 1;
        }
        return result;
    }

    // Aufgabe 3 (Ausgabe der ersten Elemente von Folgen):
    // a)
    public static void printSequence1 (int number1) {
        // Initiiere Laufvariable j (hätte auch i bleiben können, da dies eine neue Methode ist; der Übersichtlichkeit halber wurden hier neue Variablen j,number1 und result1 genommen):
        int j = 0;
         while (j < number1) {
             int result1 = j*j;
             System.out.print(result1 + " ");
             j++;
         }
        // Zeilenumbruch, ansonsten wird Sequence2 direkt dahinter ausgegeben und nicht in einer neuen Zeile:
        System.out.println();

    }

    // Aufgabe 3:
    // b)
    public static void  printSequence2 (int number2) {
        // Initiiere Laufvariable j:
        int j = 1;
        while (j <= number2) {
            // Wenn die Laufvariable j gerade ist (also durch 2 teilbar, d.h. Modulorest = 0), dann soll der Wert immer negiert werden:
            if (j % 2 == 0) {
                int result2 = (-1)*j;
                System.out.print(result2 + " ");
            // Wenn die Laufvariable j aber ungerade ist, dann soll sie einfach fortgeführt werden:
            } else {
                System.out.print(j + " ");
            }
            j++;
        }
        System.out.println();
    }

    // Aufgabe 3:
    // c)
    public static void  printSequence3 (int number3) {
        //Initiiere Laufvariable k:
        int k = 1;

        while (k <= number3) {
            int result3 = (k*(k+1))/2;
            System.out.print(result3 + " ");
            k++;
        }
        System.out.println();
    }

    /*Alternative Version von Aufgabe 3c):
    public static void printSequence3Altern(int number3) {
        int curSum = 0;
        for (int i = 1; i <= number3; i++){
            curSum += i;
            System.out.print(curSum + " ");
        }
        System.out.println();
    }

     */

    // Aufgabe 4 (Visualisierung von Dreieckszahlen):
    public static void printTriangle (int triNum) {
        // Initiiere Laufvariable row (Zeile):
        int row = 0;

        //Solange die Zeilenanzahl echt kleiner der eingegebenen Zahl ist, soll Folgendes passieren:
        while (row < triNum) {
            // Initiiere Laufvariable col (für column = Spalte):
            int col = 0;

            //Solange die Spaltenanzahl echt kleiner der eingegebenen Zahl ist, soll Folgendes passieren:
            while (col < triNum) {
                if (col >= triNum - (row + 1)) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
                col++;
            }
            System.out.println();
            row++;
        }
        /*
         * Bsp. und Erläuterung zum if-else-statement für triNum = 5:
         *  r/c 0 1 2 3 4   row     col                                                                                                 Für das konkrete Beispiel triNum = 5
         *    0         .   0       triNum - (row + 1)                                                                                  (5-1=4)
         *    1       . .   1       triNum - (row + 1) & triNum - (row)                                                                 (5-2=3 & 5-1=4)
         *    2     . . .   2       triNum - (row + 1) & triNum - (row) & triNum - (row -1)                                             (5-3=2 & 5-2=3 & 5-1=4)
         *    3   . . . .   3       triNum - (row + 1) & triNum - (row) & triNum - (row -1) & triNum - (row - 2)                        (5-4=1 & 5-3=2 & 5-2=3 & 5-1=4)
         *    4 . . . . .   4       triNum - (row + 1) & triNum - (row) & triNum - (row -1) & triNum - (row - 2) & triNum - (row -3)    (5-5=0 & 5-4=1 & 5-3=2 & 5-2=3 & 5-1=4)
         *  -> Folgerung: für alle Spalten >= triNum - (row + 1) soll ein "." ausgegeben werden (wichtig: >=, da bei = nur die Stellen für triNum - (row+1) ausgegeben werden würden, also so:
         *  r/c 0 1 2 3 4
         *    0         .
         *    1       .
         *    2     .
         *    3   .
         *    4 .
         */
    }
}
