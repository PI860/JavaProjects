package ALGO.pp.aufgabenblaetter.blatt08;

/** JUnit test cases for class SearchTree
 * 
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JuTestSearchTree {
	// all three arrays contain the same values from -4 to 5:
	public final static double[] values1 = { -4, -3, -2, -1, 0, 1, 2, 3, 4, 5 };
	public final static double[] values2 = { 5, -1, -3, 1, -2, 0, 4, -4, 2, 3 };
	public final static double[] values3 = { 0, 1, 2, 3, 4, 5, -1, -2, -3, -4 };

	public final static double DELTA = 1e-10;

	/** test method to compute sum of leaf values */
	@Test
	public void testProdLeaves1() {
		SearchTree t1 = new SearchTree();

		// empty tree has product 1.0
		assertEquals(1.0, t1.prodLeaves(), DELTA);

		// tree consisting of one node has 1 leaf
		t1.insert(1.0);
		assertEquals(1.0, t1.prodLeaves(), DELTA);

		// build tree that is degenerated to a linear list
		for (int n = 2; n <= 10; n++) {
			t1.insert(n);
		}
		// degenerated tree has just one leave with value 10.0
		double n1 = t1.prodLeaves();
		assertEquals(10.0, n1, DELTA);
	}

	/** another test method to compute sum of leaf values */
	@Test
	public void testProdLeaves2() {
		// build complete tree of height 3 (with 4 leaves)
		// 5
		// / \
		// 3 7
		// / \ / \
		// 2 4 6 8
		SearchTree t2 = new SearchTree();
		t2.insert(5);
		t2.insert(3);
		t2.insert(7);

		t2.insert(2);
		t2.insert(4);
		t2.insert(6);
		t2.insert(8);

//		t2.print();
		double n2 = t2.prodLeaves();
		assertEquals(384.0, n2, DELTA);
	}

	/** more tests for prodLeaves() method */
	@Test
	public void testProdLeaves3() {
		// build tree with 2 leaves:
		//
		// 5
		// / \
		// 3 7
		// / /
		// 2 6
		//
		SearchTree t3 = new SearchTree();
		t3.insert(5);
		t3.insert(3);
		t3.insert(7);
		t3.insert(2);
		t3.insert(6);

//		t3.print();
		double n3 = t3.prodLeaves();
		assertEquals(12.0, n3, DELTA);
	}

	/** test method toSortedList() */
	@Test
	public void toSortedList() {

		SearchTree tree = new SearchTree();
		ArrayList<Double> list;

		// empty tree gives empty list
		list = tree.toSortedList();
		assertEquals(0, list.size());

		// insert 10 different values from -4 to 5
		for (double n : values3) {
			tree.insert(n);
		}

		// result should be sorted list of length 10
		list = tree.toSortedList();
		assertEquals(10, list.size());

		// check if list is sorted in ascending order
		for (int i = 0; i < 10; i++) {
			double wert = list.get(i);
			assertEquals(i - 4, wert, DELTA);
		}
	}

	/** test extractMin() method
	 *  Build three different trees each with values from -4 to 5
	 *  and then remove all values the with extractMin() */
	@Test
	public void testExtractMin_1() {
		// Build tree with integer values from -4 to 5.
		SearchTree tree1 = new SearchTree();
		for (double n : values1) {
			tree1.insert(n);
		}

		// build another tree with values form -4 to 5
		SearchTree tree2 = new SearchTree();
		for (double n : values2) {
			tree2.insert(n);
		}

		// build third tree with values form -4 to 5
		SearchTree tree3 = new SearchTree();
		for (double n : values3) {
			tree3.insert(n);
		}

		// remove all values with removeMax. Values expected from -4 to 5
		for (int expected = -4; expected <=5; expected++) {
			assertEquals(expected, tree1.extractMin(), DELTA);
			assertEquals(expected, tree2.extractMin(), DELTA);
			assertEquals(expected, tree3.extractMin(), DELTA);
		}

		// now the trees should be empty
		assertTrue(tree1.isEmpty());
		assertTrue(tree2.isEmpty());
		assertTrue(tree3.isEmpty());
	}

	/** test extractMin() method */
	@Test
	public void testExtractMin_2() {
		// Build tree with 10 values from -4 to 5
		SearchTree tree = new SearchTree();
		for (double n : values1) {
			tree.insert(n);
		}

		// extract 5 maximum values
		assertEquals(-4, tree.extractMin(), DELTA);
		assertEquals(-3, tree.extractMin(), DELTA);
		assertEquals(-2, tree.extractMin(), DELTA);
		assertEquals(-1, tree.extractMin(), DELTA);
		assertEquals(0, tree.extractMin(), DELTA);

		// reenter values from 0 to -4
		tree.insert(-2);
		tree.insert(0);
		tree.insert(-3);
		tree.insert(-4);
		tree.insert(-1);

		// remove all entries
		for (int n = -4; n <= 5; n++) {
			assertEquals(n, tree.extractMin(), DELTA);
		}

		assertTrue(tree.isEmpty());
	}

	/**
	 * check removeMax() for empty tree.
	 * RuntimeException expected
	 */
	@Test
	public void testExtractMin_empty() {
		SearchTree tree = new SearchTree();
		assertThrows(RuntimeException.class, () -> {
			tree.extractMin();
		});
	}

	/** test equals() method for search trees */
	@Test
	public void testEquals_1() {
		// Build two different trees with same value set
		SearchTree tree1 = new SearchTree();
		for (double n : values1) {
			tree1.insert(n);
		}

		SearchTree tree2 = new SearchTree();
		for (double n : values2) {
			tree2.insert(n);
		}

		SearchTree tree3 = new SearchTree();
		for (double n : values3) {
			tree3.insert(n);
		}

		assertTrue(tree1.equals(tree2));
		assertTrue(tree2.equals(tree1));

		assertTrue(tree1.equals(tree3));
		assertTrue(tree3.equals(tree1));

		assertTrue(tree2.equals(tree3));
		assertTrue(tree3.equals(tree2));

	}

	@Test
	public void testEquals_2() {
		// Build first tree with values -4 to 5
		SearchTree tree1 = new SearchTree();
		for (double n : values1) {
			tree1.insert(n);
		}

		// Build second tree with values -4 to 5
		SearchTree tree2 = new SearchTree();
		for (double n : values2) {
			tree2.insert(n);
		}

		assertTrue(tree1.equals(tree2));

		// add one more value to tree1
		tree1.insert(1.5);

		// now trees no longer contain the same set of values
		assertFalse(tree1.equals(tree2));
	}

	@Test
	public void testEquals_3() {
		// Build first tree with values -4 to 5
		SearchTree tree1 = new SearchTree();
		for (double n : values1) {
			tree1.insert(n);
		}

		// Build second tree with values -4 to 5
		SearchTree tree2 = new SearchTree();
		for (double n : values2) {
			tree2.insert(n);
		}

		assertTrue(tree1.equals(tree2));

		// add one more value to tree2
		tree2.insert(42);

		// now trees are not equal
		assertFalse(tree1.equals(tree2));
	}

}
