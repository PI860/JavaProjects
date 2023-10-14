package rl.prog2.exercises.ss12set04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Program starter. The list-like train methods are
 * tested and additionally the performance of two
 * list implementations is measured and compared.
 * @author Ruediger Lunde
 *
 */
public class Main {

	public static void startTrainTest() {
		Locomotive bigChief = new Locomotive(23, 5311);
		Train santaFe = new Train(bigChief);
		santaFe.add(0, new Car(12, 50));
		santaFe.add(1, new Car(15, 75));
		santaFe.add(2, new Car(20, 100));
		System.out.println("Santa Fe: " + santaFe);
		Locomotive steelHorse = new Locomotive(21, 5409);
		Train rioGrandeExpress = new Train(steelHorse);
		rioGrandeExpress.add(0, new Car(13, 60));
		rioGrandeExpress.add(1, new Car(18, 80));
		System.out.println("Rio Grande Express: " + rioGrandeExpress);
		rioGrandeExpress.relink(santaFe);
		System.out.println("Rio Grande Express V2: " + rioGrandeExpress);
		rioGrandeExpress.revert();
		System.out.println("Rio Grande Express V2: " + rioGrandeExpress);
	}
	
	public static void startPerformanceTest() {
		int n = 50000;
		long start, end;
		List<String> list;
		ArrayList<String> aList = new ArrayList<String>();
		LinkedList<String> lList = new LinkedList<String>();
		
		list = aList;
		start = System.currentTimeMillis();
		for (int i = 0; i < n; i++)
			list.add("x");
		end = System.currentTimeMillis();
		System.out.println("ArrayList - insert at the end: " + (end-start));
		
		list = lList;
		start = System.currentTimeMillis();
		for (int i = 0; i < n; i++)
			list.add("x");
		end = System.currentTimeMillis();
		System.out.println("LinkedList - insert at the end: " + (end-start));
		
		list = new ArrayList<String>();
		start = System.currentTimeMillis();
		for (int i = 0; i < n; i++)
			list.add(0, "x");
		end = System.currentTimeMillis();
		System.out.println("ArrayList - insert at the front: " + (end-start));
		
		list = new LinkedList<String>();
		start = System.currentTimeMillis();
		for (int i = 0; i < n; i++)
			list.add(0, "x");
		end = System.currentTimeMillis();
		System.out.println("LinkedList - insert at the front: " + (end-start));
		
		list = aList;
		start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++)
			list.get(i);
		end = System.currentTimeMillis();
		System.out.println("ArrayList - iterate by index: " + (end-start));
		
		list = lList;
		start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++)
			list.get(i);
		end = System.currentTimeMillis();
		System.out.println("LinkedList - iterate by index: " + (end-start));
		
		list = aList;
		start = System.currentTimeMillis();
		for (Iterator<String> it = list.iterator(); it.hasNext();)
			it.next();
		end = System.currentTimeMillis();
		System.out.println("ArrayList - iterate by iterator: " + (end-start));
		
		list = lList;
		start = System.currentTimeMillis();
		for (Iterator<String> it = list.iterator(); it.hasNext();)
			it.next();
		end = System.currentTimeMillis();
		System.out.println("LinkedList - iterate by iterator: " + (end-start));
	}
	
	/**
	 * Main method...
	 */
	public static void main(String[] args) {
		startTrainTest();
		startPerformanceTest();
	}

}
