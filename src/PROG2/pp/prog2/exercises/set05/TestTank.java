package pp.prog2.exercises.set05;

import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

//Aufgabe 3:

public class TestTank {
    public static void main(String[] args) throws CloneNotSupportedException {

        //Initialisiere einzelne Tanks:
        SimpleTank tank1 = new CylindricalTank(4,7);
        SimpleTank tank2 = new SphericalTank(2.5);
        SimpleTank tank3 = new CubiodTank(3,2,6);

        Iterator<Tank> iteratorTank1 = tank1.iterator();

        System.out.println("Given tanks:");
        System.out.println(tank1.toString());
        System.out.println(tank2.toString());
        System.out.println(tank3.toString());

        System.out.println();


        //Initialisiere compositeTank:
        CompositeTank cTank = new CompositeTank();
        cTank.add(tank1);
        cTank.add(tank2);
        cTank.add(tank3);

        //Test Iterator:
        System.out.println("Test iterator:");
        Iterator<Tank> iteratorcTank = cTank.iterator();
        while (iteratorcTank.hasNext()){
            System.out.println(iteratorcTank.next().toString());
        }

        System.out.println();

        //Clone test mit Simple Tank (tank1):
        SimpleTank clonedSimpleTank = (SimpleTank) tank1.clone();
        System.out.println("clonedSimpleTank:");
        System.out.println(clonedSimpleTank.toString());

        System.out.println();

        //compositeTank
        CompositeTank clonedTank = new CompositeTank();
        clonedTank = (CompositeTank) cTank.clone();
        System.out.println("clonedTank:");
        System.out.println(clonedTank);
    }
}
