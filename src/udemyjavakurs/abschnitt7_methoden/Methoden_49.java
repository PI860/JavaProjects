package udemyjavakurs.abschnitt7_methoden;

public class Methoden_49 {
    public static void main(String[] args) {

        // <Modifikator Rückgabedatentyp Methodenname (Datentyp Parameter 1, Datentyp Parameter 2)>
        // public = Modifikator
        // void = leer
        // return = Rückgabe (innerhalb der geschweiften Klammern in public static void x { ... }
        // Ein Modifikator gibt den Sichtbereich der Methode an
        // Mögliche Sichtbereiche: public, private und protected


        ausgabe();
        summe();
    }

        public static void ausgabe (){
            System.out.println("Ich bin eine Methode!");
        }

        public static void  summe (){
            int a,b, summe;
            a = 5;
            b = 5;

            summe = a + b;
            System.out.println(summe);
        }
}
