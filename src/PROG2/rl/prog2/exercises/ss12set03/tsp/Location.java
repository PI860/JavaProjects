package rl.prog2.exercises.ss12set03.tsp;

/**
 * Locations are characterized by a name and two Cartesian coordinates.
 * @author Ruediger Lunde
 */
public class Location {
	private String name;
	private double x;
	private double y;
	
	public Location(String name, double x, double y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getName() { return name; }
	public double getX() { return x; }
	public double getY() { return y; }
}
