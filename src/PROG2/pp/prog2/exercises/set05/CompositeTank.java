package pp.prog2.exercises.set05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Paulina Pyczot
 * @date 17.04.2023
 **/

public class CompositeTank implements Tank {

    private ArrayList<Tank> tankList;

    public CompositeTank() {
        tankList = new ArrayList<>();
    }

    public void add(Tank part){
        tankList.add(part);
    }

    @Override
    public double getSurface() {
        double result = 0;
        for (Tank tank : tankList){
            result = result + tank.getSurface();
        }
        return result;
    }

    @Override
    public double getVolume() {
        double result = 0;
        for (Tank tank : tankList){
            result = result + tank.getVolume();
        }
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object result = super.clone();
        CompositeTank tmp = new CompositeTank();
        for (Tank tank : tankList){
            SimpleTank simpleTank = (SimpleTank) tank;
            tmp.add((Tank)simpleTank.clone());
        }
        result = tmp;
        return result;
    }

    //Aufgabe 1:
    @Override
    public String toString() {
        return "CompositeTank\n" +
                tankList +
                "\nArea: " + Math.round(getSurface()) +
                "\nVolume: " + Math.round(getVolume()) +
                '}';
    }

    @Override
    public Iterator<Tank> iterator() {
        return tankList.iterator();
    }
}
