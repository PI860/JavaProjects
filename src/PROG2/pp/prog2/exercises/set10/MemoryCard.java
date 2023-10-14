package pp.prog2.exercises.set10;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.Objects;

/**
 * @author Paulina Pyczot
 * @date 22.05.2023
 **/

// Aufgabe 4:
public class MemoryCard {

    public BooleanProperty isFaceUp = new SimpleBooleanProperty(false);
    private IntegerProperty owner = new SimpleIntegerProperty(0);
    private String title;
    private String imageName;


    public MemoryCard(String title, String imageName) {
        this.title = title;
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void turn(){
        isFaceUp.setValue(!isFaceUp.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryCard that = (MemoryCard) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public BooleanProperty stateProperty(){
        return  isFaceUp;
    }

    public String getTitle() {// for test
        return title;
    }

    public int getOwner() {
        return owner.get();
    }

    public IntegerProperty ownerProperty() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner.set(owner);
    }
}
