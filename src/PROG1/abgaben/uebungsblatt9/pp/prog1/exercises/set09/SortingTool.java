package PROG1.abgaben.uebungsblatt9.pp.prog1.exercises.set09;

/**
 * @author Paulina Pyczot
 * @date 06.12.2022
 * Aufgabe 2 Methoden
 **/

public class SortingTool {

    // Ermittlung der Arraylänge laut Eintrag in SortingToolTest und Erstellen von Zufallszahlen:
    public void setInitData(int arrayLength, boolean test) {
        // Test mit Beispieldaten aus Übungsblatt 9, A3:
        //int[] insertData3 = {46,22,48,16,7,100,95,72,15,44};
        int[] insertData3 = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            insertData3[i] = (int) (Math.random()*100);
        }
        if (test) {
            System.out.println("Unsorted:");
            for (int i = 0; i < insertData3.length; i++) {
                System.out.print(insertData3[i] + "|");
            }
        } else {
            printArray(insertData3);
        }
    }

    // Variable zur Aufzählung der Vergleiche:
    public int comparisons = 0;
    public int comparisons1 = 0;
    public int comparisons2 = 0;
    // Variable zur Aufzählung der Tausche:
    public int swaps = 0;
    public int swaps1 = 0;
    public int swaps2 = 0;

    // Sortieralgorithmen aus der Vorlesung:
    // Bubblesort:
    public void bubblesort(int[] data) {
        // Variable i markiert das Ende des noch unsortierten Bereichs.
        for(int i = data.length-1; i > 0; i--) {
            // Innerhalb des unsortierten Bereichs werden alle Nachbarn jeweils 1x miteinander verglichen …
            for(int k = 0; k < i; k++) {
                // … und falls sinnvoll vertauscht.
                if(data[k] > data[k+1]) {
                    // “Blasen steigen auf”
                    int tmp= data[k];
                    data[k] = data[k+1];
                    data[k+1] = tmp;
                    // benötigt ungefähr n2/4 Austauschoperationen:
                    swaps += 1;
                }
                // benötigt ungefähr n2/2 Vergleiche:
                comparisons += 1;
            }
        }
    }
    // Selectionsort:
    public void selectionsort(int[] data) {
        // Variable i markiert den Anfang des unsortierten Bereichs.
        for(int i = 0; i < data.length-1; i++) {
            // Minimum der Werte von i bis size-1 bestimmen
            int minPos= i;
            for(int j = i + 1; j < data.length; j++) {
                if(data[j] < data[minPos])
                    minPos= j;
                // benötigt ungefähr n2/2 Vergleiche:
                comparisons1 += 1;
            }
            // Element i mit Minimum vertauschen (swap)
            int tmp= data[i];
            data[i] = data[minPos];
            data[minPos] = tmp;
            // benötigt ungefähr n Austauschoperationen:
            swaps1 += 1;
        }
    }
    // Insertionsort:
    public void insertionsort(int[] dataInsertion) {
        // Variable i markiert den Anfang des unsortierten Bereichs:
        for (int i = 1; i < dataInsertion.length; i++) {
            int insertVal = dataInsertion[i];
            int insertPos = i;
            // benötigt durchschnittl. ungefähr n2/4 Vergleiche:
            comparisons2 += 1;
            while (insertPos > 0 && dataInsertion[insertPos - 1] > insertVal) {
                dataInsertion[insertPos] = dataInsertion[insertPos - 1];
                comparisons2 += 1;
                insertPos--;
                // benötigt ungefähr n2/8 Austauschoperationen bzw. n2/4 Zuweisungen:
            }
            comparisons2 += 1;
            swaps2 += 1;
            dataInsertion[insertPos] = insertVal;
            updateInsertion = dataInsertion.clone();
        }
    }
    public int[] updateInsertion;


    // Ausgabe des sortierten Arrays:
    public int printArray(int[] data) {
        System.out.println("Bubblesort:");
        bubblesort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "|");
        }
        System.out.println();
        System.out.println("Swaps:" + swaps);
        System.out.println("Comparisons: " + comparisons);

        System.out.println();
        System.out.println("Selectionsort:");
        selectionsort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "|");
        }
        System.out.println();
        System.out.println("Swaps:" + swaps1);
        System.out.println("Comparisons: " + comparisons1);

        System.out.println();
        System.out.println("Insertionsort:");
        insertionsort(data);
        for (int i = 0; i < updateInsertion.length; i++) {
            System.out.print(updateInsertion[i] + "|");
        }
        System.out.println();
        System.out.println("Swaps:" + swaps2);
        System.out.println("Comparisons: " + comparisons2);
        return 0;
    }

//    // Ausgabe des sortierten Arrays:
//    public int printArrayBubblesort(int[] data) {
//        System.out.println("Bubblesort:");
//        bubblesort(data);
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i] + "|");
//        }
//        System.out.println();
//        System.out.println("Swaps:" + swaps);
//        System.out.println("Comparisons: " + comparisons);
//        return 0;
//    }
//
//    // Ausgabe des sortierten Arrays:
//    public int printArraySelectionsort(int[] data) {
//        System.out.println("Selectionsort:");
//        selectionsort(data);
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i] + "|");
//        }
//        System.out.println();
//        System.out.println("Swaps:" + swaps1);
//        System.out.println("Comparisons: " + comparisons1);
//        return 0;
//    }
//
//    // Ausgabe des sortierten Arrays:
//    public int printArrayInsertionsort(int[] data) {
//        System.out.println("Insertionsort:");
//        insertionsort(data);
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i] + "|");
//        }
//        System.out.println();
//        System.out.println("Swaps:" + swaps2);
//        System.out.println("Comparisons: " + comparisons2);
//        return 0;
//    }
}
