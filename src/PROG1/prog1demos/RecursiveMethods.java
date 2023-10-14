package PROG1.prog1demos;

public class RecursiveMethods {

	static void callMe() {
		System.out.println("Hi, it's me!");
		System.out.println("What will happen, if I call myself...");
		callMe();
	}
	
	static long factorial1(long num) {
		long result = 1;
		while (num > 1)
			result *= num--;
		return result;
	}

	static long factorial2(long num) {
		if (num <= 1)
			return 1;
		else
			return num * factorial2(num - 1);
	}

	public static void startPerformanceMeasurement() {
		int num = 25, mcount = 1000;
		long t1, t2, t3, tIt = 0, tRec = 0;
		long resultIt = 0, resultRec = 0;
		for (int i = 0; i < mcount; i++) {
			t1 = System.nanoTime();
			resultIt = factorial1(num);
			t2 = System.nanoTime();
			resultRec = factorial2(num);
			t3 = System.nanoTime();
			tIt += t2 - t1;
			tRec += t3 - t2;
		}
		System.out.printf("Iterative: %d! = %d (%d nsec)\n",
				num, resultIt, tIt / mcount);
		System.out.printf("Recursive: %d! = %d (%d nsec)\n",
				num, resultRec, tRec / mcount);
		System.out.printf("Overhead per recursive call: %d nsec\n",
				(tRec - tIt) / mcount / num);
	}
	
	static int fib(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n-1) + fib(n-2);
	}
	
	static int fibIt(int n) {
		if (n <= 0)
			return 0;
		else {
			int fN = 1, fNminus1 = 0, fNminus2;
			for (int i = 2; i <= n; i++) {
				fNminus2 = fNminus1;
				fNminus1 = fN;
				fN = fNminus1 + fNminus2;
			}
			return fN;
		}
	}
	
	public static void startFibTest() {
		int num = 40, mcount = 10;
		long t1, t2, t3, tIt = 0, tRec = 0;
		long resultIt = 0, resultRec = 0;
		for (int i = 0; i < mcount; i++) {
			t1 = System.nanoTime();
			resultRec = fib(num);
			t2 = System.nanoTime();
			resultIt = fibIt(num);
			t3 = System.nanoTime();
			tRec += t2 - t1;
			tIt += t3 - t2;
		}
		System.out.printf("Recursive: fib(%d) = %d (%d msec)\n",
				num, resultRec, tRec / mcount / 1000);
		System.out.printf("Iterative: fib(%d) = %d (%d msec)\n",
				num, resultIt, tIt / mcount / 1000);
	}
	
	
	
	
	
	static void swap(int[] data, int pos1, int pos2) {
		int tmp = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = tmp;
	}

	// call this function with start = 0! 
	static void computePermutations(int[] data, int start) {
	    if (start == data.length - 1) {
			// permutation generated; print it!
			for (int datum : data)
				System.out.print(datum + " ");
			System.out.println();
	    } else {
	        for (int i = start; i < data.length; i++) {
	            swap(data, start, i);
	            computePermutations(data, start + 1);
	            swap(data, i, start);
	        }
	    }
	}

	static void computePermutations2(int[] data, int num) {
		if (num > data.length) {
			for (int datum : data)
				System.out.print(datum + " ");
			System.out.println();
		} else {
			for (int i = 0; i < data.length; i++) {
				if (data[i] == 0) {
					data[i] = num;
					computePermutations2(data, num+1);
					data[i] = 0;
				}
			}
		}
	}
	
	static boolean contains(int[] data, int num) {
		for (int n : data)
			if (n == num)
				return true;
		return false;
	}
	
	static void computePermutations3(int[] data, int index) {
		if (index == data.length) {
			for (int datum : data)
				System.out.print(datum + " ");
			System.out.println();
		} else {
			for (int num = 1; num <= data.length; num++) {
				if (!contains(data, num)) {
					data[index] = num;
					computePermutations3(data, index + 1);
				}
				data[index] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		//callMe();
//		startPerformanceMeasurement();
//		System.out.println(fib(12));
//		startFibTest();
		computePermutations(new int[]{1, 2, 3, 4}, 0);
//		computePermutations2(new int[4], 1);
//		computePermutations3(new int[4], 0);
	}
}
