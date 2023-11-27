package ALGO.pp.aufgabenblaetter.blatt05.aufg5_6_sort;

/**
 * Implementations of sorting algorithms
 *
 */
public class Sort {

	/**
	 * Insertionsort
	 */
	public static void insertionsort(double[] arr) {
		int j = 1;
		// loop invariant: subarray arr[0 .. j] is already sorted
		while (j < arr.length) {
			// Insert next value arr[j] at the correct position
			// into the sorted subarray a[ 0.. j-1]

			double value = arr[j]; // value to be inserted

			// find correct position to insert the value
			int insertPos = j;
			while (insertPos > 0 && arr[insertPos - 1] > value) {
				arr[insertPos] = arr[insertPos - 1];
				insertPos--;
			}

			// insert value
			arr[insertPos] = value;

			j++;
		}
	}

	/**
	 * Selectionsort
	 */
	static void selectionsort(double[] a) {
		// invariant: a[0 .. i-1] is sorted and contains the i smallest values of the
		// array
		for (int i = 0; i < a.length - 1; i++) {
			// determine smallest value in unsorted area a[i .. a.length - 1]
			int minIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[minIndex])
					minIndex = j;
			}
			// extend sorted area, swapping values at position i and minIndex
			double tmp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = tmp;
		}
	}

	/**
	 * Bubblesort
	 */
	public static void bubblesort(double[] a) {
		int n = a.length;
		boolean swapped;
		do {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (a[i] > a[i + 1]) {
					// swap neighboring values a[i] and a[i+1] that
					// are in the wrong order.
					double temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
	}

	/**
	 * Quicksort (Version according to books of Saake/Sattler or
	 * Cormen/Leiserson/Rivest/Stein)
	 * 
	 * @param arr array to be sorted
	 */
	public static void quicksort(double[] arr) {
		quicksort(arr, 0, arr.length - 1);
	}

	/**
	 * sort sub-array a[left .. right]
	 */
	private final static void quicksort(double[] a, int low, int high) {
		if (low < high) {
			// more than one element to be sorted
			// division into two parts required

			// "divide" - partition into two parts
			int border = partition(a, low, high);

			// "conquer" - sort both parts recursively
			quicksort(a, low, border - 1);
			quicksort(a, border + 1, high);
		}
	}

	private final static int partition(double[] a, int low, int high) {
		// select element in the middle as pivot element
		int mid = (low + high) / 2;
		double pivot = a[mid];
		// pivot value is temporarily stored at the right end of the area
		swap(a, mid, high);

		// rearrange values and determine final position for the pivot element

		int pivotPos = low;
		// Invariant: all element left of pivotPos are less than pivot and
		// all elements in a[pivotPos .. i-1] are greater or equal to pivot
		for (int i = low; i < high; i++) {
			if (a[i] <= pivot) {
				swap(a, pivotPos, i);
				pivotPos++;
			}
		}

		// place pivot value between both parts with the lower and the higher values
		swap(a, pivotPos, high);
		// return position of the pivot element
		return pivotPos;
	}

	/** Swaps a[i] and a[j] */
	private static void swap(double[] a, int i1, int i2) {
		double tmp = a[i1];
		a[i1] = a[i2];
		a[i2] = tmp;
	}

	/**
	 * Heapsort
	 * 
	 */
	public static void heapsort(double[] a) {
		// transform array into a max-heap
		maxHeapify(a);

		// remove largest elements from the heap and build sorted
		// area with the largest elements at the end of the heap
		for (int i = a.length - 1; i > 0; i--) {
			// remove largest element from the root and put it
			// to the sorted area at the end
			swap(a, i, 0);

			// reestablish heap property for root element a[0]
			siftDown(a, 0, i);
		}
	}

	/**
	 * Transform contents of an array into a max-heap
	 */
	private static void maxHeapify(double[] a) {
		// Sift down all elements of the array, from the middle to the beginning
		// so the heap property is established bottom-up
		for (int i = (a.length / 2) - 1; i >= 0; i--) {
			siftDown(a, i, a.length);
		}
	}

	/**
	 * Integrate a[i] into the heap area a[i+1..m] Precondition: all elements of
	 * a[i+1 .. m] already fulfill the heap property Postcondition: all elements of
	 * a[i .. m] fulfill the heap property
	 */
	private static void siftDown(double[] a, int i, int m) {
		int k = i;
		while (k <= (m / 2) - 1) {
			// there exists at least one child
			int leftChild = 2 * k + 1;
			int rightChild = leftChild + 1;

			// determine index of the child with maximum value
			int maxChild = leftChild;
			// is there a right child and has it a greater value?
			if (rightChild <= m - 1 && a[leftChild] < a[rightChild]) {
				maxChild = rightChild;
			}

			// if the value of the greater child is greater than the value of the
			// current element, the current element is swapped down one level
			if (a[k] < a[maxChild]) {
				swap(a, k, maxChild);
				k = maxChild; // use the new position for the next iteration
			} else
				break;
		}
	}

	/**
	 * 2-way Mergesort
	 */
	public static void mergesort(double[] arr) {
		mergesort(arr, 0, arr.length - 1);
	}

	/**
	 * sort subarray arr[low .. high]
	 */
	private static void mergesort(double[] arr, int low, int high) {
		if (high - low > 0) {
			// More than one element to be sorted
			// split into two parts
			int mid = (low + high) / 2;

			// recursively sort left and right part
			mergesort(arr, low, mid);
			mergesort(arr, mid + 1, high);

			// merge sorted subsequences of the left and right part
			merge(arr, low, mid, high);
		}
	}

	/**
	 * merges sorted subsequences a[left .. mid] and a[mid+1 .. right] into one
	 * sorted sequence a[left .. right]
	 */
	private static void merge(double[] a, int left, int mid, int right) {
		// build a copy of the left half
		double[] tmpLeft = new double[mid - left + 1];
		for (int i = 0; i < tmpLeft.length; i++) {
			tmpLeft[i] = a[left + i];
		}

		// merge sorted sequences of the left half contained in tmpLeft and
		// right half contained in a[mid+1.. right] to a sorted sequence
		// in a[left .. right]

		int indexLeft = 0;
		int indexRight = mid + 1;
		int indexResult = left;

		while (indexLeft < tmpLeft.length && indexRight <= right) {
			// both left and right subsequences contain elements
			// take the smaller front element of both as next element of the result
			if (tmpLeft[indexLeft] <= a[indexRight]) {
				a[indexResult] = tmpLeft[indexLeft];
				indexLeft++;
			} else {
				a[indexResult] = a[indexRight];
				indexRight++;
			}
			indexResult++;
		}

		// if the left subsequence still contains element (and the right subsequence is
		// now empty)
		// then transfer all element of the left subsequence to the result
		while (indexLeft < tmpLeft.length) {
			a[indexResult] = tmpLeft[indexLeft];
			indexResult++;
			indexLeft++;
		}

		// if the right subsequence still contains element (and the left subsequence is
		// now empty)
		// there remains nothing to do, the elements are already at the correct position
	}

	/**
	 * generates an array filled with random values
	 * 
	 * @param length length of the array to be generated and filled
	 * @return array containing random values
	 */
	public static double[] generateTestData(int length) {
		double[] values = new double[length];

		for (int i = 0; i < values.length; i++) {
			values[i] = Math.random();
		}
		return values;

	}

}
