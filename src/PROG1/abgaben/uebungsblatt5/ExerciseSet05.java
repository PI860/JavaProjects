package PROG1.abgaben.uebungsblatt5;

import PROG1.Terminal;

/**
 * @author Paulina Pyczot
 **/

public class ExerciseSet05 {
    public static void main(String[] args) {

        int num0 = 1;

        int i = 2; // Debugger: Testvariable für R^2-Koordinaten im Array und für Drehwinkel
        double[] newVecTest = new double[i]; // Debugger: Testarray
        double[] newVecTest2 = new double[i]; // Debugger: Testarray für Plus und Minus
        double num5 = 0; // Debugger: Testvariable für Multiplikationsfaktor

        for (int j = 0; num0 != 0 ; j++) {
            num0 = Terminal.readInt("Choose menu: \n1: Interest rate \n2: Grade calculator \n3: Vector test \n4: Molehill Simulation \n0: Esc \nType in the number of the menu of your choice");
            System.out.println();
            switch (num0) {
                case 1:
                    // Aufgabe 1 (zum Warmwerden):
                    System.out.println("**** 1: Interest rate ****");
                    double num1 = Terminal.readDouble("Provide initial capital [in €]");
                    double num2 = Terminal.readDouble("Provide interest rate [in %]");
                    int num3 = Terminal.readInt("Provide investment period [in years]");
                    zinsrechnung(num1, num2, num3);
                    // wenn System.out.println(zinsrechnung(num1, num2, num3)); dann würde noch zusätzlich 0.0 ausgegeben werden für das return statement!
                    break;
                case 2:
                    // Aufgabe 2:
                    System.out.println("**** 2: Grade calculator ****");
                    int num4 = 0;
                    klausurnoten(num4);
                    break;
                case 3:
                    // Aufgabe 3 (Vektorrechnung):
                    System.out.println("**** 3: Vector test ****");
                    double vec1x = Terminal.readDouble("Provide x-coordinate of the first vector");
                    double vec1y = Terminal.readDouble("Provide y-coordinate of the first vector");
                    double vec2x = Terminal.readDouble("Provide x-coordinate of the second vector");
                    double vec2y = Terminal.readDouble("Provide y-coordinate of the second vector");
                    int deg = Terminal.readInt("Provide a degree");
                    double factor = Terminal.readDouble("Provide a factor to multiply with");

                    newVecTest[0] = vec1x;
                    newVecTest[1] = vec1y;
                    newVecTest2[0] = vec2x;
                    newVecTest2[1] = vec2y;

                    System.out.printf("Vektor 1: (%.1f",newVecTest[0]);
                    System.out.printf("|%.1f",newVecTest[1]);
                    System.out.printf(")\n");
                    System.out.printf("Vektor 2: (%.1f",newVecTest2[0]);
                    System.out.printf("|%.1f",newVecTest2[1]);
                    System.out.printf(")");
                    System.out.println();

                    for (int l = 0; l < newVecTest.length-1; l++) {
                        double[] diff = minus(newVecTest, newVecTest2);
                        System.out.println("Test Minus: " + diff[0] + "," + diff[1]);
                        double [] result = rotate2d(newVecTest, deg);
                        System.out.println("Test Rotation with Vector 1: " + result[0] + "," + result[1]);
                        result = mult(newVecTest, factor);
                        System.out.println("Test Multiplication with Vector 1: " + result[0] + "," + result[1]);
                        result = plus(newVecTest, newVecTest2);
                        System.out.println("Test Plus: " + result[0] + "," + result[1]);
                    }

                    System.out.println("Prediction of the next 100 molehill positions with the given vectors:");
                    molehillPredictor(newVecTest,newVecTest2);
                    break;
                case 4:
                    // Aufgabe 4 (Maulwurfshügel):
                    System.out.println("**** 4: Molehill Simulation ****");
                    System.out.println("Prediction of the next 100 molehill positions:");
                    molehillSimulator(i);
                case 0:
                    break;
            }
            System.out.println();
        }
    }

    // Aufgabe 1 (zum Warmwerden):
    public static double zinsrechnung (double kapital, double zinssatz, int anlagedauer) {
        for (int i = 1; i <= anlagedauer; i++) {
            double kapitalJahre = kapital * (1+(zinssatz/100));
            System.out.printf("Capital in € after " + i + " years: %.2f%n", kapitalJahre);
            kapital = kapitalJahre;
        }
        System.out.println();
        return 0;
    }

    // Aufgabe 2:
    public static double klausurnoten (int anzahlNoten) {
        anzahlNoten = Terminal.readInt("Provide amount of numbers to be analyzed");
        anzahlNoten = anzahlNoten + 1;
        double[] notenArray = new double [anzahlNoten];

        for (int i = 0; i < notenArray.length-1; i++) { // statt anzahlNoten geht ab hier dann auch notenArray.length, gibt beides die Größe des Arrays an
            double klausurnoten1 = Terminal.readDouble("Provide grade");
            notenArray[i] = klausurnoten1;
        }

        for (int j = 0; j < notenArray.length-1; j++) {
            System.out.print(notenArray[j] + " | ");
        }

        System.out.println();

        // Vergleich mehrerer Werte im Array auf min und max
        int i = 0;
        double min = notenArray[0];
        double max = notenArray[0];

        for (int j = 0; j < anzahlNoten; j++) {
            if (notenArray[j] > notenArray[i]) { //j=0,1,2,3,4,... werden immer mit i = 0 verglichen; notenArray[j]=0 ist dann der erste Wert, der in dem Array gespeichert ist, usw.
                min = notenArray[i];
            } else {
                i = j;
            }
        }
        System.out.println("MIN: " + min);

        for (int j = 0; j < anzahlNoten; j++) {
            if (notenArray[j] < notenArray[i]) { //j=0,1,2,3,4,... werden immer mit i = 0 verglichen; notenArray[j]=0 ist dann der erste Wert, der in dem Array gespeichert ist, usw.
                max = notenArray[i];
            }
            else {
                i = j; // wenn notenArray[j] größer ist als notenArray[i], dann wird der Initialwert von i(war 0) auf den Wert von j gesetzt, das ist dann das neue aktuelle Minimum bis zum nächsten Schleifendurchlauf
            }
        }
        System.out.println("MAX: " + max);

        double sum = 0;
        for (int j = 0; j < anzahlNoten; j++) {
            sum += notenArray[j];
            i++;
        }

        System.out.println("SUM: " + sum);
        double average = sum / anzahlNoten;

        System.out.printf("AVERAGE: %.2f", average);
        System.out.println();
        return 0;
    }

    // Aufgabe 3 (Vektorrechnung):
    /**
     * Multiplies the elements of <code>vec</code> with scalar
     * factor and returns the result. <code>vec</code> is not
     * changed by this operation!
     */
    public static double[] mult (double[] vec, double factor) {
        double[] result = new double[vec.length]; //neuer Vektor mit derselben Länge wie vec, um die Werte von vec nicht zu überschreiben

        /*
        Tests:
        vec[0] = 5; // Debugger: Test x-Koordinate bei 5
        vec[1] = 2; // Debugger: Test y-Koordinate bei 2
        factor = 3; // Debugger: Test Skalarprodukt sollte Vektor [15,6] ergeben
         */

        for (int i = 0; i < vec.length; i++) {
            result[i] = vec[i] * factor;
        }
        return result; // Debugger: result: [15.0, 6.0], also korrekt!
    }

    /**
     * Adds the vectors <code>vec1</code> and <code>vec2</code>
     * and returns the result. Input vectors are not changed.
     */
    public static double[] plus(double[] vec1, double[] vec2) {
        double[] result = new double[vec1.length]; //neuer Vektor mit derselben Länge wie vec, um die Werte von vec nicht zu überschreiben

        /*
        Tests:
        vec1[0] = 5; // Debugger: Test x-Koordinate bei 5
        vec1[1] = 2; // Debugger: Test y-Koordinate bei 2
        vec2[0] = 7; // Debugger: Test x-Koordinate bei 7
        vec2[1] = 19; // Debugger: Test y-Koordinate bei 19
         */

        for (int i = 0; i < vec1.length; i++) {
            if (vec1.length == vec2.length) {
                result[i] = vec1[i] + vec2[i];
            } else {
                //System.out.println("Please provide the same vector length for both of the vectors!");
                break;
            }
        }
        return result; // Debugger: result: [12.0, 21.0], also korrekt!
    }


    /**
     * Subtracts <code>vec2</code> from <code>vec1</code> and
     * returns the result. Input vectors are not changed.
     */
    public static double[] minus(double[] vec1, double[] vec2) {
        double[] result = new double[vec1.length]; //neuer Vektor mit derselben Länge wie vec, um die Werte von vec nicht zu überschreiben

         /*
         Tests:
         vec1[0] = 5; // Debugger: Test x-Koordinate bei 5
         vec1[1] = 2; // Debugger: Test y-Koordinate bei 2
         vec2[0] = 7; // Debugger: Test x-Koordinate bei 7
         vec2[1] = 19; // Debugger: Test y-Koordinate bei 19
          */

        for (int i = 0; i < vec1.length; i++) {
            if (vec1.length == vec2.length) {
                result[i] = vec1[i] - vec2[i];;
            } else {
                //System.out.println("Please provide the same vector length for both of the vectors!");
                break;
            }
        }
        // Debugger: result: [12.0, 21.0], also korrekt!
        return result; // Debugger: result [2.0, 17.0], also korrekt!
    }

    /**
     * Rotates the two dimensional vector <code>vec</code> by
     * <code>deg</code> degrees and returns the result.
     */
    public static double[] rotate2d(double vec[], int deg) {
        double[] result = new double[vec.length]; //neuer Vektor mit derselben Länge wie vec, um die Werte von vec nicht zu überschreiben

        /*
        Tests:
        deg = 90; // Debugger: Test mit 90°-Drehung
        vec[0] = 5; // Debugger: Test x-Koordinate bei 5
        vec[1] = 2; // Debugger: Test y-Koordinate bei 2
         */

        double rad = deg * (Math.PI/180);

        for (int i = 0; i < vec.length; i++) {
            result[0] = Math.cos(rad) * vec[0] - Math.sin(rad) * vec[1]; // neue x-Koordinate vom Klon von vec, also von result; Vorzeichen von sin getauscht wegen Ursprung links oben
            result[1] = Math.sin(rad) * vec[0] + Math.cos(rad) * vec[1]; // neue y-Koordinate; Vorzeichen von sin getauscht wegen Ursprung links oben
            // result[1] = Math.sin(rad); // Debugger: Test sin(90°) = 1, korrekt
        }
        return result; //Debugger: result [-1.99, 5.0]
    }

    /**
     * Returns the Euclidean norm of the vector
     * <code>vec</code>.
     */
    public static double vlength(double[] vec) {
        double result = 0; //neuer Vektor mit derselben Länge wie vec, um die Werte von vec nicht zu überschreiben

        /*
        Tests:
        vec[0] = 5; // Debugger: Test x-Koordinate bei 5
        vec[1] = 2; // Debugger: Test y-Koordinate bei 2
         */

        for (int i = 0; i < vec.length; i++) {
            result = Math.sqrt(Math.pow(vec[0],2)+Math.pow(vec[1],2));
        }
        return result; // Debugger: result: 5.38516, also korrekt!
    }

    // Aufgabe 4 (Maulwurfshügel):
    public static double[] molehillPredictor (double[] alterHaufen, double[] neuerHaufen) {

        double[] diff = {0,0};
        double[] result = {0,0};

        for (int i = 0; i < 100; i++) {
            diff = minus(neuerHaufen, alterHaufen);
            result = rotate2d(diff, 5);
            result = mult(result, 0.99);
            result = plus(result, neuerHaufen);
            alterHaufen = neuerHaufen;
            neuerHaufen = result;
            System.out.printf("(%.1f",neuerHaufen[0]);
            System.out.printf("|%.1f",neuerHaufen[1]);
            System.out.printf(");");
        }
        System.out.println();
        return result;
    }
    //System.out.printf("Capital after " + i + " years: %.2f%n", kapitalJahre);

    public static int molehillSimulator (int anzahlDurchläufe) {

        double[] alterHaufen = {0,0};
        double[] neuerHaufen = {1,0};

        molehillPredictor(alterHaufen,neuerHaufen);
        System.out.println();
        return 0;
    }
}
