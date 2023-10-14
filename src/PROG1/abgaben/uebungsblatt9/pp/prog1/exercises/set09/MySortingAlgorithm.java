package PROG1.abgaben.uebungsblatt9.pp.prog1.exercises.set09;

/**
 * @author Paulina Pyczot
 * @date 06.12.2022
 * Aufgabe 1
 **/



public class MySortingAlgorithm {

    // Array, welches sortiert werden soll:
    public static int[] insertData = new int[] {1,2,7,9,8246,53,4};

    // Main-Methode zum Testen:
    public static void main(String[] args) {
       printArray(insertData);
    }

    // Insertionsort:
    public static int[] insertionsort(int[] data) {
        // Variable i markiert den Anfang des unsortierten Bereichs:
        for (int i = 1; i < data.length; i++) {
            int insertVal = data[i];
            int insertPos = i;
            while (insertPos > 0 && data[insertPos - 1] > insertVal) {
                data[insertPos] = data[insertPos - 1];
                insertPos--;
            }
            data[insertPos] = insertVal;
        }

        return data;
    }

    // Ausgabe des sortierten Arrays:
    public static int printArray(int[] getData) {
        insertionsort(insertData);
        for (int i = 0; i < insertData.length; i++) {
            System.out.print(insertData[i] + "|");
        }
        return 0;
    }
}
