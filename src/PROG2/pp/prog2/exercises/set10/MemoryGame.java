package pp.prog2.exercises.set10;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Paulina Pyczot
 * @date 22.05.2023
 **/

// Aufgabe 1 + 4:
public class MemoryGame {
    private List<MemoryCard> cards = new ArrayList<>();
    private MemoryCard firstCard;
    private IntegerProperty currPlayerProperty = new SimpleIntegerProperty(1); // 1 = red; 2 = blue


    public MemoryGame() {
        String cat1 = getClass().getResource("graphics/cat1.jpg").toExternalForm();
        cards.add(new MemoryCard("cat1" , cat1));
        cards.add(new MemoryCard("cat1" , cat1));

        String cat2 = getClass().getResource("graphics/cat2.jpg").toExternalForm();
        cards.add(new MemoryCard("cat2" , cat2));
        cards.add(new MemoryCard("cat2" , cat2));

        String cat3 = getClass().getResource("graphics/cat3.jpg").toExternalForm();
        cards.add(new MemoryCard("cat3" , cat3));
        cards.add(new MemoryCard("cat3" , cat3));

        String cat4 = getClass().getResource("graphics/cat4.jpg").toExternalForm();
        cards.add(new MemoryCard("cat4" , cat4));
        cards.add(new MemoryCard("cat4" , cat4));

        String cat5 = getClass().getResource("graphics/cat5.jpg").toExternalForm();
        cards.add(new MemoryCard("cat5" , cat5));
        cards.add(new MemoryCard("cat5" , cat5));

        String cat6 = getClass().getResource("graphics/cat6.jpg").toExternalForm();
        cards.add(new MemoryCard("cat6" , cat6));
        cards.add(new MemoryCard("cat6" , cat6));
    }

    public MemoryCard getCard(int index){
        return cards.get(index);
    }

    public void newGame (){
        Collections.shuffle(cards);
        currPlayerProperty.setValue(1);
        firstCard = null;
        for(MemoryCard card : cards){
            card.setOwner(0);
            card.isFaceUp.setValue(false);
        }
    }

    public IntegerProperty getCurrPlayerProperty(){
        return currPlayerProperty;
    }

    public void turnCard(int index){
        MemoryCard currCard = cards.get(index);
        System.out.println(index +" " + cards.get(index).getTitle());

        if(firstCard == null){
            firstCard = currCard;
            currCard.stateProperty().setValue(true);
        }
        else{
            currCard.stateProperty().setValue(true);
            if(currCard.equals(firstCard)){
                currCard.setOwner(currPlayerProperty.getValue());
                firstCard.setOwner(currPlayerProperty.getValue());
            }else {
                if (currPlayerProperty.getValue() == 1) {
                    currPlayerProperty.setValue(2);
                } else {
                    currPlayerProperty.setValue(1);
                }
                firstCard.stateProperty().setValue(false);
                currCard.stateProperty().setValue(false);
            }
            firstCard = null;
        }
    }
}
