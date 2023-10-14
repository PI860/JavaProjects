package PROG1.tutorium.tutorium02;

import PROG1.Terminal;

public class tutorium2Tmp {
    public static void main(String[] args) {
        /**
         * Definition der main-Methode
         * public: es gibt auch noch private und ... , wird wichtig für Vererbung
         * static: muss kein Objekt beinhalten
         * void: es gibt keinen Rückgabewert
         * main:
         * String[] args:
         */

        //erzeugt nach der Ausgabe einen Zeilenumbruch:
        System.out.println("Hallo \n \t Welt");

        /**
         * \n = neue Zeile
         * \t = Tabulator
         */

        //erzeugt nach der Ausgabe keinen Zeilenumbruch:
        System.out.print("Hallo Welt 2");

        //1. Möglichkeit der Eingabe über Scanner

        //2. Möglichkeit der Eingabe über Terminal Klasse:
        //Terminal Klasse musste erst vorher aus Moodle Kurs importiert werden!
        Terminal.readDouble("Bitte eine Zahl eingeben");

        double number = Terminal.readDouble("Bitte eine Zahl eingeben");

        if(number > 0) {
            System.out.println("Zahl ist positiv");
        } else {
            System.out.println("Zahl ist negativ");
        }

        /**
         * Wenn das if statement z.B. 10 Mal wiederholt werden soll, bietet es sich an, eine while- oder for-Schleife einzubauen
         */

        while (number < 10) {
            if(number > 0) {
                System.out.println("Zahl ist positiv");
            } else {
                System.out.println("Zahl ist negativ");
            }
            //letzte Anweisung, was nach dem kompletten Anweisungsblock passieren soll:
            number++;
        }

        String test0;
        /**
         * Integer gibt es auch in groß als komplexen Datentyp
         */
        Integer test1;


        //damit die Methoden weiter unten auch aufgerufen werden, müssen sie in der main Methode auch aufgerufen werden, das geht so:
        eineMethode();

        int param1 = 100;
        eineMethode1(param1);
        System.out.println(param1);

    }

    public static int  eineMethode() {
        /**
         * wenn in der Methode ein Datentyp (z.B. int, double) definiert wird, dann gibt der Compiler einen Fehler aus, wenn als nächstes "void" kommt
         * Jeder Datentyp braucht unbedingt einen Rückgabetypen
         * Wenn eine Methode was zurückgibt, dann braucht sie auf jeden Fall ein return statement!
         */

        int test = 100;
        if (test >0) {
        }
        return 0;
    }

    public static void eineMethode1 (int param1) {
        param1 = 10000;

    }

}
