package pp.prog2.exercises.set03;

/**
 * @author Paulina Pyczot
 * @date 04.04.2023
 **/
public class Trip {
    private String name;

    public int getSize() {
        return size;
    }

    private int size;
    private Location[] locations;
    public Trip(String name, int size) {
        this.name = name;
        this.size = size;
        locations = new Location[size];
    }
    public void add(int xCord, int yCord, int index, String name){
        if (locations[index]== null) {
            locations[index] = new Location(name, xCord, yCord);
        }
    }
    public void add(Location location,int index){
        if (locations[index]== null) {
            locations[index] = location;
        }
    }
    public boolean contains(String name){
        for(Location location : locations){
            if(location!= null && location.getName()==name){
                return true;
            }
        }
        return false;
    }
    public Location get(int index){
        return locations[index];
    }

    // Aufgabe 3:
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name + "\n");
        for(Location location : locations){
            if(location != null)
            result.append(location.toString());
        }
        return result.toString();
    }
}
