package PROG1.tutorium.tutorium05;

/**
 * @author phoenig
 * Time: 20:24
 */
public class ExerciseSet05Copy {
    public static void main(String[] args) {

    }

    /**
     * Multiplies the elements of <code>vec</code> with scalar
     * factor and returns the result. <code>vec</code> is not
     * changed by this operation!
     */
    public static double[] mult(double[] vec, double factor) {
        double[] result = new double[vec.length];
        for(int i = 0; i < vec.length; i++) {
            result[i] = vec[i] * factor;
        }
        return result;
    }

    /**
     * Rotates the two dimensional vector <code>vec</code> by
     * <code>deg</code> degrees and returns the result.
     */
    public static double[] rotate2d(double vec[], int deg) {
        //Nicht vergessen: Winkel ins Bogenmaß umrechnen!
        //res[0] = cos(angle) * v[0] - sin(angle) * v[1]
        //res[1] = sin(angle) * v[0] + cos(angle) * v[1]
        return null;
    }

    public static void molehilSimulation() {
        double[] nextPos = {1,0};
        double[] prevPos = {0,0};
        for (int i = 0; i < 100; i++) {
            //...
            nextPos = computeNextMolehilPos(nextPos, prevPos);
            //...
        }
    }
    // sollte folgende Ausgabe erzeugen:
// 2,0 0,1; 3,0 0,3; 3,9 0,5; 4,8 0,8; 5,7 1,2; 6,5 1,7; 7,2 2,2; 7,9 2,8; 8,6 3,5; 9,2 4,2; 9,7 4,9;
    // 10,1 5,7; 10,5 6,5; 10,8 7,3; 11,0 8,1; 11,2 9,0; 11,2 9,8; 11,2 10,6; 11,2 11,5; 11,0 12,3; 10,8 13,0;
    // 10,5 13,8; 10,2 14,5; 9,8 15,2; 9,4 15,8; 8,9 16,4; 8,3 17,0; 7,8 17,4; 7,1 17,9; 6,5 18,2; 5,8 18,6; 5,2 18,8;
    // 4,5 19,0; 3,8 19,1; 3,1 19,2; 2,4 19,2; 1,7 19,1; 1,0 19,0; 0,4 18,8; -0,3 18,6; -0,9 18,3; -1,4 18,0; -2,0 17,6;
    // -2,5 17,2; -2,9 16,7; -3,3 16,3; -3,7 15,8; -4,0 15,2; -4,2 14,7; -4,5 14,1; -4,6 13,5; -4,7 12,9; -4,8 12,3;
    // -4,8 11,8; -4,7 11,2; -4,6 10,6; -4,5 10,1; -4,3 9,6; -4,0 9,1; -3,8 8,6; -3,5 8,1; -3,1 7,7; -2,7 7,4; -2,3 7,0;
    // -1,9 6,7; -1,5 6,5; -1,0 6,3; -0,5 6,1; -0,0 5,9; 0,4 5,9; 0,9 5,8; 1,4 5,8; 1,9 5,9; 2,4 5,9; 2,8 6,1; 3,3 6,2;
    // 3,7 6,4; 4,1 6,6; 4,4 6,9; 4,8 7,2; 5,1 7,5; 5,4 7,8; 5,6 8,2; 5,8 8,6; 6,0 9,0; 6,2 9,4; 6,3 9,8; 6,3 10,2;
    // 6,4 10,6; 6,4 11,0; 6,3 11,4; 6,3 11,8; 6,2 12,1; 6,0 12,5; 5,9 12,9; 5,7 13,2; 5,5 13,5; 5,2 13,8; 5,0 14,0;
    // 4,7 14,3;


    private static double[] computeNextMolehilPos(double[] nextPos, double[] prevPos) {
        /*
            Pseudocode:
            movement = nextPos - prevPos
            result = rotate2d(movement,5)
            result = mult(result,0.99)
            result = movement + posCurr
            return result

         */
        return null;
    }


}
