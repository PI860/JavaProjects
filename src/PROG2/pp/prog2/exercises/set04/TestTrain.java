package pp.prog2.exercises.set04;

/**
 * @author Paulina Pyczot
 * @date 10.04.2023
 **/

public class TestTrain {
    public static void main(String[] args) {
        //1.
        Locomotive bigChief = new Locomotive(23, 5311, "Big Chief");

        //2.
        Train santaFe = new Train(bigChief, "Santa Fe");

        //3.
        santaFe.add(0, new Car(12, 50));
        santaFe.add(1, new Car(15, 75));
        santaFe.add(2, new Car(20, 100));

        //4.
        Locomotive steelHorse = new Locomotive(21, 5409, "SteelHorse");

        //5.
        Train rioGrandeExpress = new Train(steelHorse, "Rio Grande Express");

        //6.
        rioGrandeExpress.add(0, new Car(13, 60));
        rioGrandeExpress.add(1,new Car(18,80));

        //7.
        System.out.println("Relink");
        rioGrandeExpress.relink(santaFe);
        System.out.println(rioGrandeExpress.toString());
        System.out.println(santaFe.toString());

        //8.
        System.out.println("Before revert: ");
        System.out.println(rioGrandeExpress.toString());
        rioGrandeExpress.revert();
        System.out.println("After revert:");
        System.out.println(rioGrandeExpress.toString());

    }
}
