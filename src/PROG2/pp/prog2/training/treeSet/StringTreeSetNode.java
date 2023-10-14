package pp.prog2.training.treeSet;

/**
 * @author Paulina Pyczot
 * @date 12.04.2023
 **/

public class StringTreeSetNode {
    private final String key;
    private StringTreeSetNode left;
    private StringTreeSetNode right;

    public StringTreeSetNode(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public StringTreeSetNode getLeft() {
        return left;
    }
    public void setLeft(StringTreeSetNode left) {
        this.left = left;
    }
    public StringTreeSetNode getRight() {
        return right;
    }
    public void setRight(StringTreeSetNode right) {
        this.right = right;
    }
}
