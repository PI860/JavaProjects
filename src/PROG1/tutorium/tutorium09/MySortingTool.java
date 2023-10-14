//package programming1lunde.tutorium.tutorium09;
//
//
//import programming1lunde.abgaben.uebungsblatt8.rl.util.painttool.AbstractController;
//import programming1lunde.abgaben.uebungsblatt8.rl.util.painttool.PaintTool;
//
//import java.util.Arrays;
//
///*
//Ziel: Wir wollen Sortieralgorithmen visualisieren
//- Wie können wir die Umschaltung zwischen PaintTool und
//Console realisieren?
//- Welche Klasse(n) und Methoden/Attribute werden benötigt?
//- Wie bekommen wir die Balken dargestellt (in Abhängigkeit von
//der Fenstergröße?
// */
//public class MySortingTool extends AbstractController {
//
//    private static final boolean GUI_ENABLED = true;
//    private static int MAX_VALUE = 100; // Größter erlaubter Wert der Zufallszahlen
//    private int[] initNumbers;
//    private PaintTool paintTool;
//    private int[] currData;
//    private int swaps;
//    private int comparisons;
//
//    @Override
//    public String getTitle() {
//        return super.getTitle();
//    }
//
//
//    @Override
//    public String[] getButtonNames() {
//        return new String[]{"100s"}; //... Sollte klar sein
//    }
//
//    @Override
//    public void onButtonPressed(PaintTool ptool, int button) {
//        this.paintTool = ptool;
//        if(button == 0) {
//            generateNumbers(100, true); //
//        }
//        //...
//        if(button == 4) {
//            generateNumbers(400, true);
//        }
//        if(button == 5) {
//            performExperiment(MyAlgorithms.SELECTIONSORT);
//        }
//        //...
//    }
//
//    // Diese Methode soll uns die Daten zum Sortieren erstellen
//    public void generateNumbers(int size, boolean sorted) {
//        initNumbers = new int[size];
//        if(sorted) {
//            for (int i = 0; i < size; i++) {
//                initNumbers[i] = (i+1) * MAX_VALUE / size;
//            }
//        } else {
//            // Array mit zufälligen Werten füllen. Zahlen dürfen nicht größer als MAX_VALUE sein!
//        }
//        update(initNumbers); // damit die initialen Daten angezeigt werden
//    }
//
//    public void performExperiment(MyAlgorithms algorithm) {
//        switch (algorithm) {
//            case BUBBLESORT:
//                bubblesort(initNumbers.clone());
//                break;
//            case SELECTIONSORT:
//                break;
//            case INSERTIONSORT:
//                break;
//        }
//    }
//
//    // diese Methode wird von jedem Sortieralgorithmus verwendet
//    private void swap(int[] data, int pos1, int pos2) {
//        // data an der Stelle pos1 und pos2 tauschen
//        // data wurde verändert -> update!
//        swaps++;
//        update(data);
//    }
//
//    private void update(int[] data) {
//        if(GUI_ENABLED) {
//            updateGUI(data);
//        } else {
//            // Ausgabe auf der Konsole!
//            // alle Werte von data ausgeben und mit currData vergleichen
//            // unterscheiden sich currdata und data an der Stelle i? -> ! ausgeben
//            // Vorsicht beim ersten Aufruf von update!
//        }
//        currData = data.clone();
//    }
//
//    private void updateGUI(int[] data) {
//        paintTool.clearCanvas();
//        int canvasWidth = paintTool.getCanvas().getWidth();
//        int canvasHeight = paintTool.getCanvas().getHeight();
//        // wir ziehen etwas von der Breite ab, damit wir links und rechts etwas Abstand gewinnen
//        int rectW = Math.max(1,(canvasWidth-10) / (data.length*2 - 1));
//        for(int i = 0; i < data.length; i++) {
//            System.out.println(data[i]);
//            int rectH = (canvasHeight-10) * data[i] / MAX_VALUE; // Höhe des Balkens abhängig von data[i]
//            // Zur Info: Der Punkt 0,0 ist links oben!
//            // Damit die Balken "unten" beginnen, müssen wir zuerst den y-wert "anpassen":
//            // Von der unteren Grenze (wo alle Balken beginnen sollen -> canvasHeight-5) einfach die Höhe der Balken
//            // abziehen -> canvasHeight-5-rectH
//            paintTool.addRectangle(5 + 2*i*rectW, canvasHeight-5-rectH, rectW, rectH, true);
//        }
//        paintTool.update(); // damit die hinzugefügten Rechtecke auch dargestellt werden.
//    }
//
//    private void bubblesort(int[] data) {
//    }
//
//    private void quicksort(int[] data) {
//
//    }
//
//    public static void main(String[] args) {
//        if(GUI_ENABLED) {
//            PaintTool paintTool1 = new PaintTool(new MySortingTool());
//            paintTool1.setAutoUpdate(false); // Flackern vermeiden!
//            paintTool1.setVisible(true);
//        } else {
//            MySortingTool mySortingTool = new MySortingTool();
//            mySortingTool.generateNumbers(400, false);
//            mySortingTool.performExperiment(MyAlgorithms.SELECTIONSORT);
//            mySortingTool.performExperiment(MyAlgorithms.BUBBLESORT);
//        }
//    }
//
//}
