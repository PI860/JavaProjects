package rl.prog2.exercises.ss12set03.tsp;

/**
 * Defines an common interface for different metric implementations.
 * @author Ruediger Lunde
 */
public interface Metric {
	double getDistance(Location loc1, Location loc2);
}
