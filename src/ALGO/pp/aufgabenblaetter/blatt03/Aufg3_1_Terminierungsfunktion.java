package ALGO.pp.aufgabenblaetter.blatt03;

/**
 * @author Paulina Pyczot
 * @date 06.11.2023
 **/

public class Aufg3_1_Terminierungsfunktion {
    public static void main(String[] args) {
        int[] array = {4,5,7,1,2,8};
        System.out.println(binarySearch(array,4));
    }

    public static boolean binarySearch(int[] list, int value) {
        int from = 0;
        int to = list.length - 1;
        while (from <= to) {
            int mid = (from + to) / 2;
            if (value < list[mid])
                to = mid - 1;
            else if (value > list[mid])
                from = mid + 1;
            else
                return true;
        }
        return false;
    }

}
