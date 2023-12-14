package ALGO.pp.aufgabenblaetter.blatt08;

public class SearchTreeDemo {

	public static void main(String[] args) {
		demo1();
		
		System.out.println();

		demo2();
	}

	
    
    /** build tree containing 15 values */
    public static void demo1() {
    	System.out.println("Demo1: tree1:");

    	//final double[] werte = {4,2,12,1,7,11,5,8,15, 9,13, 14,3,10,6,};

		//A8.3:
		//final double[] werte = {6,11,7,18,2,17,12,4,9,1,20,5,3};

		//A8.1:
		final double[] werte = {3,6,1,0.1,12,4.1,3,0.2,4.2,2};
 
    	SearchTree tree1 = new SearchTree();
    		
    	for (double n : werte) {
    		tree1.insert(n);
    	}
    	
    	tree1.print();
        System.out.println("- tree1.height(): " + tree1.height());
        System.out.println("- tree1.prodLeaves(): " + tree1.prodLeaves());
     	System.out.print("- all values sorted: ");
    	for (double n : tree1.toSortedList()) {
    		System.out.print(n + ", ");
    	}
    	System.out.println();
   
    }


    /** Builds a search tree containing 100 randomly chosen values */
    public static void demo2() {
    	System.out.println("Demo 2:");

    	SearchTree tree2 = new SearchTree();
        //insert n random values between -5 and +5 into the tree
        for (int i = 0; i < 100; i++) {
            double v = Math.random() * 10 - 5.0;
            tree2.insert(v);   
        }    

        tree2.print();
        System.out.println("- height(): " + tree2.height());
        System.out.println("- prodLeaves(): " + tree2.prodLeaves());
    	System.out.println("- all values sorted: ");
    	for (double v : tree2.toSortedList()) {
    		System.out.println("\t" + v);
    	}
    	System.out.println();

    	// remove minimum value
    	double min = tree2.extractMin();
        System.out.println("- extractMin: " + min);
    	System.out.println();
        tree2.print();
  
    }
}
