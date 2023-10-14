package rl.prog2.exercises.ss12set03.tsp;

/**
 * Provides a metric implementation for locations with Cartesian coordinates.
 * @author Ruediger Lunde
 *
 */
public class EuclideanMetric implements Metric {
	
	public double getDistance(Location loc1, Location loc2) {
		double dx = loc2.getX() - loc1.getX();
		double dy = loc2.getY() - loc1.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}

}
