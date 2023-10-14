package pp.prog2.exercises.set03;

/**
 * @author Paulina Pyczot
 * @date 04.04.2023
 **/
public class TSP {

    // Aufgabe 3:
    public Trip generateCircuitBoard1() {
        Trip circuitBoard1 = new Trip("Circuit Board 1:", 6);
        circuitBoard1.add(1, 1, 0, "A");
        circuitBoard1.add(1, 2, 1, "B");
        circuitBoard1.add(2, 1, 2, "C");
        circuitBoard1.add(2, 2, 3, "D");
        circuitBoard1.add(3, 1, 4, "E");
        circuitBoard1.add(3, 2, 5, "F");
        System.out.println(circuitBoard1.toString());
        return circuitBoard1;
    }

    public Trip generateCircuitBoard2() {
        Trip circuitBoard2 = new Trip("Circuit Board 2:", 11);
        circuitBoard2.add(1, 1, 0, "A");
        circuitBoard2.add(1, 2, 1, "B");
        circuitBoard2.add(1, 3, 2, "C");
        circuitBoard2.add(1, 4, 3, "D");
        circuitBoard2.add(2, 2, 4, "E");
        circuitBoard2.add(2, 3, 5, "F");
        circuitBoard2.add(4, 1, 6, "G");
        circuitBoard2.add(4, 4, 7, "H");
        circuitBoard2.add(4, 5, 8, "I");
        circuitBoard2.add(4, 6, 9, "J");
        circuitBoard2.add(4, 7, 10, "K");
        System.out.println(circuitBoard2.toString());
        return circuitBoard2;
    }

    public Trip generateCircuitBoard3() {
        Trip circuitBoard3 = new Trip("Circuit Board 3:", 15);
        circuitBoard3.add(1, 1, 0, "A");
        circuitBoard3.add(1, 2, 1, "B");
        circuitBoard3.add(1, 3, 2, "C");
        circuitBoard3.add(1, 4, 3, "D");
        circuitBoard3.add(2, 2, 4, "E");
        circuitBoard3.add(2, 3, 5, "F");
        circuitBoard3.add(4, 1, 6, "G");
        circuitBoard3.add(4, 4, 7, "H");
        circuitBoard3.add(4, 5, 8, "I");
        circuitBoard3.add(4, 6, 9, "J");
        circuitBoard3.add(4, 7, 10, "K");
        circuitBoard3.add(5, 1, 11, "L");
        circuitBoard3.add(5, 4, 12, "M");
        circuitBoard3.add(5, 5, 13, "N");
        circuitBoard3.add(5, 6, 14, "O");
        System.out.println(circuitBoard3.toString());
        return circuitBoard3;
    }

    // Aufgabe 4:
    public double cost(Location start, Location destination) {
        double result = 0;
        double deltaX = destination.getX() - start.getX();
        double deltaY = destination.getY() - start.getY();
        // Euklidische Metrik:
        result = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        return result;
    }

    // Aufgabe 5:
    public double greedy(Trip circuitBoard) {

        double result = 0;
        int size = circuitBoard.getSize();
        Trip greedy = new Trip("Greedy:", size + 1);
        greedy.add(circuitBoard.get(0), 0);//set start point
        int indexnearest;
        double distance;
        for (int j = 0; j < size; j++) {
            distance = 0;
            indexnearest = 0;
            for (int i = 1; i < size; i++) {
                if (greedy.get(j).getName() != circuitBoard.get(i).getName()){
                    if (!greedy.contains(circuitBoard.get(i).getName())) {
                        if (distance == 0) {
                            distance = cost(greedy.get(j), circuitBoard.get(i));
                            indexnearest = i;
                        } else if (distance > cost(greedy.get(j), circuitBoard.get(i))) {
                            indexnearest = i;
                        }
                    }
                }
            }
            result = result + cost(greedy.get(j), circuitBoard.get(indexnearest));
            greedy.add(circuitBoard.get(indexnearest), j+1);
        }
        greedy.add(circuitBoard.get(0), size);
        System.out.println(greedy.toString());
        return result;
    }


}
