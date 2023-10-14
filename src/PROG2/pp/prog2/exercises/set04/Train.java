package pp.prog2.exercises.set04;

/**
 * @author Paulina Pyczot
 * @date 10.04.2023
 **/

// Aufgabe 1
public class Train {
    private Locomotive locomotive;
    private String name;

    // Konstruktor:
    public Train(Locomotive locomotive,String name) {
        this.locomotive = locomotive;
        this.name = name;
    }

    // Prüft, ob der Zug über mehr als nur eine Lokomotive verfügt:
    public boolean hasCars() {
        if(locomotive.getFirst() !=null){
            return true;
        }
        else{
            return false;
        }
    }

    // Hängt in den Zug einen gegebenen Wagen an der spezifizierten Index-Position ein:
    public void add(int index, Car car) {
        Car first = locomotive.getFirst();
        if(index == 0){
            locomotive.setFirst(car);
            car.setNext(first);
        }
        else{
            Car curr = first;
            for(int i = 0; i<index-1;i++){
                if(i==(index-2))
                    curr = curr.getNext();
            }
            curr.setNext(car);
        }
    }

    // Liefert die gesamte Passagierkapazität des Zuges:
    public int getPassengers() {
        int result = 0;
        Car curr = locomotive.getFirst();
        while (curr != null) {
            result = result + curr.getPassengerCapacity();
            curr = curr.getNext();
        }
        return result;
    }

    // Liefert die Länge des Zugs in Metern:
    public int getLength(){
        int result = 0;
        Car curr = locomotive.getFirst();
        while (curr != null) {
            result = result + curr.getLength();
            curr = curr.getNext();
        }
        return result;
    }

    // Hängt den ersten Wagen aus dem Zug aus und liefert den ausgehängten Wagen
    // als Ergebnis zurück. Die restlichen Wagen bleiben am Zug. Falls es keinen
    // Wagen gibt, wird null zurückgegeben:
    public Car removeFirst(){
        Car first = locomotive.getFirst();
        if(first == null)
            return null;
        locomotive.setFirst(first.getNext());
        first.setNext(null);
        return first;
    }

    // Akzeptiert als Parameter einen anderen Zug und hängt alle Wagen des anderen
    // Zuges in diesen Zug um. Im anderen Zug bleibt nur die Lokomotive zurück.
    // Nutzen Sie für diese Methode geschickt die vorher definierten. Die Methode soll
    // möglichst effizient sein:
    public void relink(Train train){
        Car first = train.getLocomotive().getFirst();
        Car last = this.locomotive.getFirst();
        while (true){
            if(last.getNext() == null){
                break;
            }
            else{
                last = last.getNext();
            }
        }
        last.setNext(first);
        while(train.removeFirst() != null){
        }
    }

    // Dreht die Abfolge der Wagen in diesem Zug um, das heißt, der vorher letzte
    // Wagen wird zum ersten, und umgekehrt. Auch diese Aufgabe lässt sich effizient
    // ohne Zwischenspeicherung des Zuges lösen:
    public void revert(){
        if(locomotive.getFirst() != null && locomotive.getFirst().getNext() != null) {
            Car last = locomotive.getFirst();
            while (last.getNext() != null){
                last = last.getNext();
            }
            Car first = removeFirst();
            last.setNext(first);
            Car nextToLast = last.getNext();
            while(locomotive.getFirst()!=last){
                first = removeFirst();
                last.setNext(first);
                first.setNext(nextToLast);
                nextToLast = last.getNext();
            }
        }
    }
    @Override
    // Liefert eine Beschreibung, aus der alle wichtigen Zugdaten hervorgehen:
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Train     : " + name +"\nLocomotice: " + locomotive.getName());
        Car curr = locomotive.getFirst();
        while(curr != null){
            result.append("\n"+ curr.toString());
            curr = curr.getNext();
        }
        return result.toString();
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }
}
