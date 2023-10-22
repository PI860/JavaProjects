package lektion04;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Subset {

	public static void main(String[] args) {
		testSubsets();
	}
	
	/** Menge aller Teilmengen der Werte aus dem Array arr bestimmen */
	public static <E>  Set<Set<E>> allSubsets(E[] arr) {
		return allSubsets(arr, arr.length-1);
	}
	
	/** berechne Menge aller Teilmengen der Werte im Teilfeld arr[0..maxIndex] */
	private static <E>  Set<Set<E>> allSubsets(E[] arr, int maxIndex) {
		Set<Set<E>> resultSet = new HashSet<Set<E>>(); 
		
		if (maxIndex >= 0) {
			// Wähle letztes Element im gegebenen Feldbereich
			E selected = arr[maxIndex];

			// Bilde alle Teilmengen ohne das letzte Element
			Set<Set<E>> resultSet1 = allSubsets(arr, maxIndex - 1);
			// nimm jede dieser Mengen zum Ergebnis hinzu
			resultSet.addAll(resultSet1);
			
			for (Set<E> set1 : resultSet1) {
				// Erzeuge Kopie der Menge aus resultSet1 und nimm gewähltes Element zur Kopie dazu 
				Set<E> set2 = new HashSet<E>(set1);
				set2.add(selected);
				// füge erweiterte Kopie zum Ergebnis hinzu
				resultSet.add(set2);
			}
		} else {
			// Leere Menge hat nur leere Menge als einzige Teilmenge
			Set<E> emptySet = new HashSet<>();
			resultSet.add(emptySet);	
		}
		return resultSet;
	}
	
	
	public static void testSubsets() {
		Integer[] arr1 = {1,2,3,4,5};
		System.out.println(Arrays.toString(arr1));

		
		Set<Set<Integer>> subsets1 = allSubsets(arr1);
			
		System.out.println("all subsets:");
		
		for (Set<Integer> set : subsets1) {
			System.out.println(set);
		}

	}
		
	
	

}
