package pp.prog2.exercises.set02.sequences;

/**
 * @author Paulina Pyczot
 * @date 27.03.2023
 **/

// Aufgabe 3:
public class SequenceTest {
    public static void main(String[] args){
        System.out.println("Naturals");
        println(new Naturals());
        System.out.println("Range 7-14");
        println(new Range(7,14));
        System.out.println("Evens in Range 7-14");
        println(new Evens(new Range(7,14)));

        System.out.println("ZapMultiples of 3 in Range 7-14");
        println(new ZapMultiples(new Range(7,14),3));

        //println(new ZapMultiples(new Evens(new Naturals()),2));
    }
    public static void println(Sequence sequence){// Sequence verwenden damit es für alle funktioniert
        for (int i = 0; i<=9; i++){
            if(sequence.hasNext()){
                Integer element = sequence.nextElement();
                if(element != null){
                    System.out.print(element + ", ");
                }
            }
        }
        System.out.println("\n");
    }
}
