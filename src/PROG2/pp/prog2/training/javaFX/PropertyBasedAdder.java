package pp.prog2.training.javaFX;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 * @author Paulina Pyczot
 * @date 10.05.2023
 **/

public class PropertyBasedAdder {

    // New version:
    private DoubleProperty x = new SimpleDoubleProperty();
    private DoubleProperty y = new SimpleDoubleProperty();
    private DoubleProperty z = new SimpleDoubleProperty(); // Z = x+y

    //Getter + Setter:
    public void setX(double x) {
        this.x.set(x);
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public void setZ(double z) {
        this.z.set(z);
    }

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public double getZ() {
        return z.get();
    }

    public DoubleProperty zProperty() {
        return z;
    }

    public PropertyBasedAdder() {
        //z.bind(x.add(y)); // schlechte Variante
        z.bind(Bindings.add(x,y)); // schönere Variante
        z.addListener((obs, oldValue, newValue)
        -> System.out.println("New value2: " + newValue)); // -> = Lambda-Ausdruck
    }

    public static void main(String[] args) {
        PropertyBasedAdder adder = new PropertyBasedAdder();
        adder.setX(20);
        adder.setY(5);
        System.out.println("Z: " + adder.getZ());

    }

    // Old version:
    public static void main2(String[] args) {
        DoubleProperty d1 = new SimpleDoubleProperty();
        DoubleProperty d2 = new SimpleDoubleProperty();

        System.out.println(d1.get()); // Wert ausgeben lassen mit get
        //d1.set(5); // Wert ändern mit set

//        d1.addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
//                System.out.println("New value: " + newValue);
//            }
//        });

        d2.bind(d1); //d1 wird an d2 gebunden
        d1.addListener((observableValue, oldValue, newValue)
                -> System.out.println("New value1: " + newValue));
        d1.set(5);
        System.out.println(d2.get()); // Wert von d2 wird durch das bind oben auf denselben Wert wie in d1 gesetzt
    }
}
