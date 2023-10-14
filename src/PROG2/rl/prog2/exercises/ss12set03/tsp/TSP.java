package rl.prog2.exercises.ss12set03.tsp;

/**
 * Simple implementation of the Traveling Salesman Problem.
 * 
 * @author Ruediger Lunde
 * 
 */
public class TSP {

	/** Contains locations to be visited. */
	private LocationList map;
	/** Contains the metric to be used for distance computations. */
	private Metric metric;
	/** Maintains the last generated tour. */
	private LocationList solution;
	/**
	 * Maintains the length of the last generated tour. This reduces the number
	 * of tour length computations to one per tour candidate.
	 */
	private double solutionTourLength;
	/** Maintains computation time for the last tour generation process. */
	private long computationTime;

	/** Standard constructor. */
	public TSP() {
		map = new LocationList(1);
		metric = new EuclideanMetric();
	}

	public void createTestMapHoles1() {
		map = new LocationList(10);
		map.add(new Location("A", 1, 1));
		map.add(new Location("B", 1, 2));
		map.add(new Location("C", 2, 1));
		map.add(new Location("D", 2, 2));
		map.add(new Location("E", 3, 1));
		map.add(new Location("F", 3, 2));
	}

	public void createTestMapHoles2() {
		map = new LocationList(20);
		map.add(new Location("A", 1, 1));
		map.add(new Location("B", 1, 2));
		map.add(new Location("C", 1, 3));
		map.add(new Location("D", 1, 4));
		map.add(new Location("E", 2, 2));
		map.add(new Location("F", 2, 3));
		map.add(new Location("G", 4, 1));
		map.add(new Location("H", 4, 4));
		map.add(new Location("I", 4, 5));
		map.add(new Location("J", 4, 6));
		map.add(new Location("K", 4, 7));
	}

	public void createTestMapHoles3() {
		createTestMapHoles2();
		map.add(new Location("L", 5, 1));
		map.add(new Location("M", 5, 4));
		map.add(new Location("N", 5, 5));
		map.add(new Location("O", 5, 6));
	}

	public void createTestMapUlm() {
		map = new LocationList(10);
		map.add(new Location("Ulm", 0, 0));
		map.add(new Location("Heidenheim", 12, 31));
		map.add(new Location("Augsburg", 64, -1));
		map.add(new Location("Stuttgart", 60, 40));
		map.add(new Location("Friedrichshafen", -40, -83));
		map.add(new Location("Ingolstadt", 107, 40));
		map.add(new Location("Muenchen", 115, -32));
	}

	public double computeTourLength(LocationList tour) {
		double result = 0;
		for (int i = 1; i < tour.size(); i++)
			result += metric.getDistance(tour.get(i - 1), tour.get(i));
		if (!tour.isEmpty())
			result += metric
					.getDistance(tour.get(tour.size() - 1), tour.get(0));
		return result;
	}

	/**
	 * Simple, but fast greedy algorithm. The used heuristic cannot guarantee an
	 * optimal result, but it works quite well as can be seen in example runs.
	 */
	public void computeGoodSolution() {
		long t = System.currentTimeMillis();
		LocationList tour = new LocationList(map.size());
		if (map.size() > 0)
			tour.add(map.get(0));
		while (tour.size() < map.size())
			addBestPathExtension(tour);
		solution = tour;
		solutionTourLength = computeTourLength(solution);
		computationTime = System.currentTimeMillis() - t;
	}

	private void addBestPathExtension(LocationList tour) {
		Location curr = tour.get(tour.size() - 1);
		Location next = null;
		double nextDist = Double.MAX_VALUE;
		for (int i = 0; i < map.size(); i++) {
			Location loc = map.get(i);
			if (!tour.contains(loc)) {
				double d = metric.getDistance(curr, loc);
				if (d < nextDist) {
					next = loc;
					nextDist = metric.getDistance(curr, loc);
				}
			}
		}
		tour.add(next);
	}

	/**
	 * Enumerates all complete tours and returns the best one. Works only for
	 * small maps!
	 */
	void computeBestSolution() {
		long t = System.currentTimeMillis();
		solution = null;
		solutionTourLength = Double.MAX_VALUE;
		if (!map.isEmpty()) {
			LocationList candidate = new LocationList(map.size());
			candidate.add(map.get(0));
			checkAllExtensions(candidate);
		}
		computationTime = System.currentTimeMillis() - t;
	}

	private void checkAllExtensions(LocationList candidate) {
		if (candidate.size() == map.size()) {
			double tourLength = computeTourLength(candidate);
			if (tourLength < solutionTourLength) {
				solution = candidate.clone();
				solutionTourLength = tourLength;
			}
		} else {
			for (int i = 0; i < map.size(); i++) {
				Location next = map.get(i);
				if (!candidate.contains(next)) {
					candidate.add(next);
					checkAllExtensions(candidate);
					candidate.removeLast();
				}
			}
		}
	}

	/**
	 * Improved version. Stops to extend tours when the current length is
	 * greater then the best currently known solution.
	 */
	void computeBestSolutionOpt(boolean withDistCache) {
		long t = System.currentTimeMillis();
		solution = null;
		solutionTourLength = Double.MAX_VALUE;
		if (!map.isEmpty()) {
			LocationList candidate;
			if (withDistCache)
				candidate = new Tour(map.size(), metric);
			else
				candidate = new LocationList(map.size());

			candidate.add(map.get(0));
			checkAllExtensionsOpt(candidate, withDistCache);
		}
		computationTime = System.currentTimeMillis() - t;
	}

	private void checkAllExtensionsOpt(LocationList candidate,
			boolean withDistCache) {
		double tourLength;
		if (withDistCache)
			tourLength = ((Tour) candidate).getTourLength();
		else
			tourLength = computeTourLength(candidate);
		// tours which are longer than the shortest currently known solution are
		// uninteresting - no further investigation necessary!
		if (tourLength < solutionTourLength) {
			if (candidate.size() == map.size()) {
				solution = candidate.clone();
				solutionTourLength = tourLength;
				// System.out.println("found: " + tourLength);
			} else {
				for (int i = 0; i < map.size(); i++) {
					Location next = map.get(i);
					if (!candidate.contains(next)) {
						candidate.add(next);
						checkAllExtensionsOpt(candidate, withDistCache);
						candidate.removeLast();
					}
				}
			}
		}
	}

	public void printResults(String description) {
		System.out.println(description);
		System.out.println("Solution: " + solution);
		System.out.println("Length: " + solutionTourLength);
		System.out.println("Time: " + computationTime / 1000.0);
	}

	/**
	 * Simple test program.
	 */
	public static void main(String[] args) {
		TSP tsp = new TSP();
		tsp.createTestMapHoles2();
		// tsp.createTestMapUlm();
		tsp.computeGoodSolution();
		tsp.printResults("Greedy");
		tsp.computeBestSolutionOpt(true);
		tsp.printResults("Systematic search with sub tree cutting and distance caching");
		tsp.computeBestSolutionOpt(false);
		tsp.printResults("Systematic search with sub tree cutting");
		tsp.computeBestSolution();
		tsp.printResults("Systematic search");
	}
}
