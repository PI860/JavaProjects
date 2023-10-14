package pp.prog2.training.treeSet;

/**
 * @author Paulina Pyczot
 * @date 12.04.2023
 **/

public class StringTreeSet /*implements Collection<String>*/ {
    private StringTreeSetNode root;
    public boolean add(String key) {
        StringTreeSetNode newNode = new StringTreeSetNode(key);
        if(root == null ) {
            root = newNode;
            return true;
        } else {
            return add(newNode,root);
        }
    }

    private boolean add(StringTreeSetNode newNode, StringTreeSetNode curr) {
        int compResult = newNode.getKey().compareTo(curr.getKey());
        if (compResult < 0) {
            if (curr.getLeft() == null) {
                curr.setLeft(newNode);
                return true;
            } else {
                return add(newNode, curr.getLeft());
            }
        } else if (compResult > 0) {
            if (curr.getRight() == null) {
                curr.setRight(newNode);
                return true;
            }
            else {
                return add(newNode, curr.getLeft());
            }
        }   else {
            return false;
        }
    }

    public boolean contains(String key) {
        StringTreeSetNode curr = root;
        while (curr != null) {
            int compResult = key.compareTo(curr.getKey());
            if (compResult < 0) {
                curr = curr.getLeft();
            } else if (compResult > 0) {
                curr = curr.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size(root);
    }

    private int size(StringTreeSetNode curr) {
        if (curr == null) {
            return 0;
        } else {
            return 1 + size(curr.getLeft()) + size(curr.getRight());
        }
    }

    public static void main(String[] args) {
        StringTreeSet set = new StringTreeSet();
        /**
         * Baumaufbau:
         *       Charlie
         *      /      \
         * Alpha        Xray
         *     \
         *      Bravo
         */
        set.add("Charlie");
        set.add("Alpha");
        set.add("Xray");
        set.add("Bravo");
        System.out.println(set.contains("Bravo")); // true
        System.out.println(set.contains("B")); // false
        System.out.println(set.size()); //4
    }

}
