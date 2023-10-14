package PROG1.myprogrammsvorlesung;

/**
 * @author Paulina Pyczot
 **/

public class project14_TrainingArrayTest {
    public static void main(String[] args) {

        int[] stockIndexDev = {2700, 2801, 2750, 2000}; // früher: int[] stockIndexDev = new int[] {2700, 2801, 2750, 2000};
        int[] result = findBiggestDrop(1,2,3); // Rückgabewert
        System.out.println("Position: " + result[0] + " drop by: " + result[1]);
    }

    // Beispielübungen sind in Javadoc mit Sternchen dokumentiert
    // Returns 2 values: index position and drop value
    // Index -1 indicates no drop
    public static int[] findBiggestDrop (int... stockIndexDevelopment) { // mit ... bleibt Arrayvarialbe genauso wie int[]
        int position = -1;
        int drop = 0; // oder was Negatives

        for (int i = 1; i < stockIndexDevelopment.length ; i++) { //length - 1 um nicht aus dem Array zu fallen, wenn i bei 0 anfängt
            // i ist z.B. Anzahl der Tage
            int diff = stockIndexDevelopment[i] -stockIndexDevelopment[i-1];
            if (/*diff < 0 &&*/ -diff > drop) {
                position = i;
                drop = -diff;
            }

        }

        return new int[] {position, drop}; // Array-return-Fehler wegbekommen durch return null;
    }
}
