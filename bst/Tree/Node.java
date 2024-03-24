/* Sabrina Midori F. T. de Carvalho      RA 10410220
   Estrutura de Dados II - Prof. Andre Kishimoto
   Turma 04G11 - Atividade 01D (Arvore Binaria de Busca)
   Referencias: materiais de aula
*/

package Tree;

public class Node<T> {

    private T data;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    public Node() { this(null); }

    public Node(T data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
    }

    public T getData() { return data; }
    public Node<T> getParent() { return parent; }
    public Node<T> getLeft() { return left; }
    public Node<T> getRight() { return right; }

    public void setData(T data) { this.data = data; }
    public void setParent(Node<T> parent) { this.parent = parent; }
    public void setLeft(Node <T> left) { this.left = left; }
    public void setRight(Node <T> right) { this.right = right; }

    public boolean isRoot() { return getParent() == null; }

    public boolean isLeaf() { return getLeft() == null && getRight() == null; }

    public int getDegree() {
        int degree = 0;
        if (getLeft() != null) ++degree;
        if (getRight() != null) ++ degree;
        return degree;
    }

    public int getLevel() {
        if (isRoot()) return 0;
        return getLevel(this);
    }

    private int getLevel(Node<T> node) {
        if (node == null) return -1;
        return getLevel(node.getParent()) + 1;
    }

    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(Node<T> node) {
        if (node == null) return -1;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (getParent() != null) sb.append("Parent: " + getParent().getData() + "\n");
        if (getLeft() != null) sb.append("Left Child: " + getLeft().getData() + "\n");
        if (getRight() != null) sb.append("Right Child: " + getRight().getData() + "\n");

        sb.append("Data: " + data + "\n")
          .append("Is root? " + isRoot() + "\n")
          .append("Is leaf? " + isLeaf() + "\n")
          .append("Degree: " + getDegree() + "\n")
          .append("Level: " + getLevel() + "\n")
          .append("Height: " + getHeight());

        return sb.toString();
    }
}
