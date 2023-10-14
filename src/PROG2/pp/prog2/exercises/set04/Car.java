package pp.prog2.exercises.set04;

/**
 * @author Paulina Pyczot
 * @date 10.04.2023
 **/

// Aufgabe 1:

public class Car {
    private int length;
    private int passengerCapacity;
    private Car next;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public Car(int length, int passengerCapacity) {
        this.length = length;
        this.passengerCapacity = passengerCapacity;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Car{" +
                "length=" + length +
                ", passengerCapacity=" + passengerCapacity +
                '}';
    }
}
