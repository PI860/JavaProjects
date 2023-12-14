package ALGO.pp.aufgabenblaetter.blatt08;

import java.util.ArrayList;

/**
 * Implementation of binary search trees with double values as payload
 * 
 */
public class SearchTree {

	/** node of a search tree */
	private class TreeNode {
		public TreeNode left;
		public TreeNode right;
		public double value;

		/**
		 * initializes node with value and references to left and right subtree
		 */
		public TreeNode(double v, TreeNode l, TreeNode r) {
			value = v;
			left = l;
			right = r;
		}

		/** initializes a neaf node with given value */
		public TreeNode(double value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	private TreeNode root;

	/** initializes empty tree */
	public SearchTree() {
		root = null;
	}

	
	//////////////////////////////////////////////////////////////////////////
	// TODO
	//////////////////////////////////////////////////////////////////////////
	

	/** Computes the product of all leave values of the tree */
	public double prodLeaves() {
		return prodLeaves(root);
	}

	private double prodLeaves(TreeNode node) {
		if (node == null) {
			return 1.0; // Leerer Baum hat ein Produkt von 1.0
		} else if (node.left == null && node.right == null) {
			return node.value; // Blattknoten haben Wert als Produkt
		} else {
			// Rekursiv das Produkt der linken und rechten Teilbäume berechnen
			return prodLeaves(node.left) * prodLeaves(node.right);
		}
	}

	/**
	 * Removes the minimum value from the tree and returns it. Throws RuntimeException if tree is empty.
	 */
	public double extractMin() {
		if (isEmpty()) {
			throw new RuntimeException("Tree is empty");
		}

		TreeNode minNode = extractMin(root);
		return minNode.value;
	}

	private TreeNode extractMin(TreeNode node) {
		if (node.left == null) {
			// Der kleinste Wert wurde gefunden
			root = node.right; // Aktualisiere root, um den Wert zu entfernen
			return node;
		} else {
			// Rekursiv zum kleinsten Wert im linken Teilbaum gehen
			TreeNode minLeft = extractMin(node.left);
			node.left = root; // Aktualisiere left, um die Änderungen zu reflektieren
			return minLeft;
		}
	}

	/**
	 * Returns a sorted list of all values stored in the tree
	 */
	public ArrayList<Double> toSortedList() {
		ArrayList<Double> sortedList = new ArrayList<>();
		toSortedList(root, sortedList);
		return sortedList;
	}

	private void toSortedList(TreeNode node, ArrayList<Double> sortedList) {
		if (node != null) {
			// In-Order Traversal, um die Werte sortiert zu sammeln
			toSortedList(node.left, sortedList);
			sortedList.add(node.value);
			toSortedList(node.right, sortedList);
		}
	}

	/** Checks if both trees contain the same set of values */
	public boolean equals(SearchTree other) {
		// Vergleiche die sortierten Listen der beiden Bäume
		ArrayList<Double> sortedList1 = this.toSortedList();
		ArrayList<Double> sortedList2 = other.toSortedList();

		return sortedList1.equals(sortedList2);
	}
	
    //////////////////////////////////////////////////////////////////////////
	
	/**
	 * Insert value v into the tree (recursively)
	 */
	public boolean insert(double v) {
		if (root == null) {
			// tree was empty, new leaf as root node
			root = new TreeNode(v);
			return true; // value successfully inserted
		} else {
			// insert value v recursively into non-empty tree
			return insertRec(root, v);
		}
	}

	/**
	 * recursively insert value v into the (sub-)tree starting with root r. It is
	 * assumed that the tree is not empty.
	 */
	private boolean insertRec(TreeNode r, double v) {
		if (v < r.value) {
			// value belongs to left subtree
			if (r.left == null) {
				// no left subtree, add new leaf als left subtree
				r.left = new TreeNode(v);
				return true;
			} else {
				// insert recursively into (non-empty) left subtree
				return insertRec(r.left, v);
			}
		} else if (v > r.value) {
			// value belongs to right subtree
			if (r.right == null) {
				// no right subtree, add new leaf als left subtree
				r.right = new TreeNode(v);
				return true;
			} else {
				// insert recursively into (non-empty) right subtree
				return insertRec(r.right, v);
			}
		} else { // (v == r.value)
			return false; // value already contained in the tree
		}
	}

	/**
	 * Search for value v in tree
	 * 
	 * @return node that contains v if value is contained in tree, otherwise null.
	 */
	public TreeNode searchNode(double v) {
		return searchNodeRek(root, v);
	}

	public TreeNode searchNodeRek(TreeNode r, double v) {
		if (r == null)
			return null;
		else {
			if (v < r.value)
				return searchNodeRek(r.left, v); // continue search in left subtree
			else if (v > r.value)
				return searchNodeRek(r.right, v); // continue search in right subtree
			else
				// v == r.value // value found
				return r;
		}
	}

	/** checks if tree is empty */
	public boolean isEmpty() {
		return (root == null);
	}

	/** computes height of tree */
	public int height() {
		return height(root);
	}

	private int height(TreeNode r) {
		if (r == null)
			return 0;
		else
			return 1 + Math.max(height(r.left), height(r.right));
	}

	/**
	 * prints the tree structure to the console
	 */
	public void print() {
		if (root != null) {
			print(root.left, "    ", true);
			System.out.println("+---" + root.value);
			print(root.right, "    ", false);
		} else {
			System.out.println("(empty tree)");
		}
	}

	/** auxiliary method for printing the tree to the console */
	private void print(TreeNode r, String prefix, boolean links) {
		if (r != null) {
			if (links)
				print(r.left, prefix + "    ", links);
			else
				print(r.left, prefix + "|   ", !links);

			System.out.println(prefix + "+---" + r.value);

			if (links)
				print(r.right, prefix + "|   ", !links);
			else
				print(r.right, prefix + "    ", links);

		}
	}

	
	/** Computes the number of entries */
	public int size() {
		return size(root);
	}

	private int size(TreeNode t) {
		if (t == null) {
			return 0;
		} else {
			return 1 + size(t.left) + size(t.right);
		}
	}



}
