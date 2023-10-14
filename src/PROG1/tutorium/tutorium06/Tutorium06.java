package PROG1.tutorium.tutorium06;

public class Tutorium06 {
    public static void main(String[] args) {
        boolean result = a() || b();
        double[] array = {1,2,3,4,5};
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        for(double e : array) {
            System.out.println(e);
        }

        double[][] bigArray = new double[10][];
        for(int i = 0; i < bigArray.length; i++) {
            bigArray[i] = array.clone();
        }
        for(double[] e :bigArray) {
            int idx = 0;
            for(double el : e) {
                if(idx == e.length-1) {
                    // last element
                }
                idx++;
            }
        }
    }

    public static boolean a() {
        System.out.printf("A");
        return true;
    }

    public static boolean b() {
        System.out.printf("B");
        return true;
    }
}
