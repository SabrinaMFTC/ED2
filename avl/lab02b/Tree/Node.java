/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/

package Tree;

public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private int data;
    private int balanceFactor;

    public Node(int data, Node left, Node right, Node parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.balanceFactor = getBalanceFactor();
    }

    public Node(int data) { this(data, null, null, null); this.balanceFactor = getBalanceFactor(); }

    public Node() { this(0, null, null, null); this.balanceFactor = getBalanceFactor(); }

    public Node getLeft() { return left; }

    public Node getRight() { return right; }

    public Node getParent() { return parent; }

    public int getData() { return data; }

    public int getBalanceFactor() {
        updateBalanceFactor();
        return balanceFactor;
    }

    public void setLeft(Node left) { this.left = left; }

    public void setRight(Node right) { this.right = right; }

    public void setParent(Node parent) { this.parent = parent; }

    public void setData(int data) { this.data = data; }

    private void updateBalanceFactor() {
        int rightHeight = -1;
        int leftHeight = -1;

        if (getRight() != null) rightHeight = getRight().getHeight();
        if (getLeft() != null) leftHeight = getLeft().getHeight();

        balanceFactor = rightHeight - leftHeight;
    }

    public boolean isRoot() { return parent == null; }

    public boolean isLeaf() { return (left == null && right == null); }

    public int getDegree() {
        if (left == null && right == null) return 0;
        else if (left != null && right != null) return 2;
        else return 1;
    }

    public int getLevel() {
        if (isRoot()) return 0;
        return getLevel(this);
    }

    private int getLevel(Node node) {
        if (node == null) return -1;
        return getLevel(node.getParent()) + 1;
    }

    public int getHeight() {
        if (isLeaf()) return 0;
        return getHeight(this);
    }

    private int getHeight(Node node) {
        if (node == null) return -1;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Data: " + data + "\n");
        if (getParent() != null) sb.append("Parent: " + getParent().getData() + "\n");
        if (getLeft() != null) sb.append("Left Child: " + getLeft().getData() + "\n");
        if (getRight() != null) sb.append("Right Child: " + getRight().getData() + "\n");

        sb.append("Is root? " + isRoot() + "\n")
          .append("Is leaf? " + isLeaf() + "\n")
          .append("Degree: " + getDegree() + "\n")
          .append("Level: " + getLevel() + "\n")
          .append("Height: " + getHeight() + "\n")
          .append("Balance Factor: " + getBalanceFactor());

        return sb.toString();
    }
}
