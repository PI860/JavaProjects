package rl.prog2.exercises.ss12set03.tsp;

/**
 * Special location list implementation which caches tour length computations.
 * @author Ruediger Lunde
 *
 */
public class Tour extends LocationList {

	private double[] distances;
	private Metric metric;

	public Tour(int capacity, Metric metric) {
		super(capacity);
		distances = new double[capacity];
		this.metric = metric;
	}

	public void add(Location loc) {
		super.add(loc);
		int size = size();
		if (size > 1) {
			Location last = get(size() - 1);
			distances[size() - 2] = metric.getDistance(get(size() - 2), last);
			distances[size() - 1] = metric.getDistance(last, get(0));
		} else {
			distances[0] = 0.0;
		}
	}
	
	public double getTourLength() {
		double result = 0;
		for (int i = size()-1; i >= 0; i--)
			result += distances[i];
		return result;
	}
	
	public Tour clone() {
		Tour result = (Tour) super.clone();
		result.distances = result.distances.clone();
		return result;
	}
}
