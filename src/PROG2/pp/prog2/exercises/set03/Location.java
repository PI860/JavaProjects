package pp.prog2.exercises.set03;

/**
 * @author Paulina Pyczot
 * @date 04.04.2023
 **/

public class Location {
    private String name;
    private int x;
    private int y;

    public Location(String name, int xCord, int yCord) {
        this.name = name;
        this.x = xCord;
        this.y = yCord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" +
                name +
                " x:" + x +
                " y:" + y +
                ")\n";
    }
}
