package PROG1.abgaben.uebungsblatt9.pp.prog1.exercises.set09;

import PROG1.rl.util.painttool.AbstractController;
import PROG1.rl.util.painttool.PaintTool;

/**
 * @author Paulina Pyczot
 * @date 06.12.2022
 * Aufgabe 4 Controller und Main-Methode
 **/

/**
 * MySortingToolController interacts with the GUI and is the main class
 */
public class MySortingToolController extends AbstractController {

    private static final boolean GUI_ENABLED = true;
    private static int MAX_VALUE = 120; // Größter erlaubter Wert der Zufallszahlen
    private int[] initNumbers /*= {46, 22, 48, 16, 7, 100, 95, 72, 15, 44}*/;
    private PaintTool paintTool;
    private int[] currData;
    //Variablen zur Aufzählung der Vergleiche:
    public int comparisons = 0;
    public int comparisons1 = 0;
    public int comparisons2 = 0;
    // Variable zur Aufzählung der Tausche:
    public int swaps = 0;
    public int swaps1 = 0;
    public int swaps2 = 0;

    @Override
    public String getTitle() {
        return "SortingTool";
    }

    @Override
    public String[] getButtonNames() {
        return new String[]{"Init 10","Init 100","Init 200","Init 400","Sort1","Sort2","Sort3"};
    }

    @Override
    public void onButtonPressed(PaintTool ptool, int button) {
        this.paintTool = ptool;
        if(button == 0) { //Init 10
            generateNumbers(10, true); //
        }
        if(button == 1) { //Init 100
            generateNumbers(100, true); //
        }
        if(button == 2) { //Init 200
            generateNumbers(200, true); //
        }
        if(button == 3) { //Init 400
            generateNumbers(400, true); //
        }
        if(button == 4) { //Sort1
            performExperiment(MyAlgorithms.BUBBLESORT);
        }
        if(button == 5) { //Sort 2
            performExperiment(MyAlgorithms.SELECTIONSORT);
        }
        if(button == 6) { //Sort 3
            performExperiment(MyAlgorithms.INSERTIONSORT);
        }
    }

    // Diese Methode soll uns die Daten zum Sortieren erstellen
    public void generateNumbers(int size, boolean unsorted) {
        initNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            initNumbers[i] = (int) (Math.random()*100);
        }
        if (unsorted) {
            System.out.println("Unsorted:");
            for (int i = 0; i < initNumbers.length; i++) {
                System.out.print(initNumbers[i] + "|");
            }
        } else {
            printArraySelectionsort(initNumbers);
        }
        update(initNumbers); // damit die initialen Daten angezeigt werden
    }

    public void performExperiment(MyAlgorithms algorithm) {
        switch (algorithm) {
            case BUBBLESORT:
                printArrayBubblesort(initNumbers);
                break;
            case SELECTIONSORT:
                printArraySelectionsort(initNumbers);
                break;
            case INSERTIONSORT:
                printArrayInsertionsort(initNumbers);
                break;
        }
    }

    private void update(int[] data) {
        if(GUI_ENABLED) {
            updateGUI(data);
        } else {
            // Ausgabe auf der Konsole!
            // alle Werte von data ausgeben und mit currData vergleichen
            // unterscheiden sich currdata und data an der Stelle i? -> ! ausgeben
            // Vorsicht beim ersten Aufruf von update!
        }
        currData = data.clone();
    }

    private void updateGUI(int[] data) {
        paintTool.clearCanvas();
        int canvasWidth = paintTool.getCanvas().getWidth();
        int canvasHeight = paintTool.getCanvas().getHeight();
        // wir ziehen etwas von der Breite ab, damit wir links und rechts etwas Abstand gewinnen
        int rectW = Math.max(1,(canvasWidth-10) / (data.length*2 - 1));
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
            int rectH = (canvasHeight-10) * data[i] / MAX_VALUE; // Höhe des Balkens abhängig von data[i]
            // Zur Info: Der Punkt 0,0 ist links oben!
            // Damit die Balken "unten" beginnen, müssen wir zuerst den y-wert "anpassen":
            // Von der unteren Grenze (wo alle Balken beginnen sollen -> canvasHeight-5) einfach die Höhe der Balken
            // abziehen -> canvasHeight-5-rectH
            paintTool.addRectangle(5 + 2*i*rectW, canvasHeight-5-rectH, rectW, rectH, true);
        }
        paintTool.update(); // damit die hinzugefügten Rechtecke auch dargestellt werden.
    }

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
        }
    }

    // Ausgabe des sortierten Arrays:
    public int printArrayBubblesort(int[] data) {
        System.out.println("Bubblesort:");
        bubblesort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "|");
        }
        System.out.println();
        System.out.println("Swaps:" + swaps);
        System.out.println("Comparisons: " + comparisons);
        update(initNumbers);
        paintTool.addText(20, 20, "Bubblesort: Swaps: " + swaps + ", Comparisons: " + comparisons);
        swaps = 0;
        comparisons = 0;
        return 0;
    }

    // Ausgabe des sortierten Arrays:
    public int printArraySelectionsort(int[] data) {
        System.out.println("Selectionsort:");
        selectionsort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "|");
        }
        System.out.println();
        System.out.println("Swaps:" + swaps1);
        System.out.println("Comparisons: " + comparisons1);
        update(initNumbers);
        paintTool.addText(20, 20, "Selectionsort: Swaps: " + swaps1 + ", Comparisons: " + comparisons1);
        swaps1 = 0;
        comparisons1 = 0;
        return 0;
    }

    // Ausgabe des sortierten Arrays:
    public int printArrayInsertionsort(int[] data) {
        System.out.println("Insertionsort:");
        insertionsort(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "|");
        }
        System.out.println();
        System.out.println("Swaps:" + swaps2);
        System.out.println("Comparisons: " + comparisons2);
        update(initNumbers);
        paintTool.addText(20, 20, "Insertionsort: Swaps: " + swaps2 + ", Comparisons: " + comparisons2);
        swaps2 = 0;
        comparisons2 = 0;
        return 0;
    }

    public static void main(String[] args) {
        if(GUI_ENABLED) {
            PaintTool paintTool1 = new PaintTool(new MySortingToolController());
            paintTool1.setAutoUpdate(false); // Flackern vermeiden!
            paintTool1.setVisible(true);
        } else {
            MySortingToolController mySortingTool = new MySortingToolController();
            mySortingTool.generateNumbers(400, true);
            mySortingTool.performExperiment(MyAlgorithms.BUBBLESORT);
            mySortingTool.performExperiment(MyAlgorithms.SELECTIONSORT);
            mySortingTool.performExperiment(MyAlgorithms.INSERTIONSORT);
        }
    }

}
