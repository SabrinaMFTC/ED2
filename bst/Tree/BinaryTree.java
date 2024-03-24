/* Sabrina Midori F. T. de Carvalho      RA 10410220
   Estrutura de Dados II - Prof. Andre Kishimoto
   Turma 04G11 - Atividade 01D (Arvore Binaria de Busca)
   Referencias: materiais de aula
*/

package Tree;

public class BinaryTree<T> {

    protected Node<T> root;

    public BinaryTree() { this(null); }

    public BinaryTree(Node<T> root) { this.root = null; }

    public Node<T> getRoot() { return root; }

    public void setRoot(Node<T> root) { this.root = root; }

    public boolean isEmpty() { return root == null; }

    public int getDegree() {
        if (isEmpty()) return 0;

        Node<T> node = root;

        while (node != null) {
            Node<T> nodeL = node.getLeft();
            Node<T> nodeR = node.getRight();

            if (nodeL != null && nodeR != null) return 2;
            else if (nodeL == null) node = node.getRight();
            else node = node.getLeft();
        }
        return 1;
    }

    public int getHeight() {
        if (isEmpty()) return -1;
        return getHeight(root);
    }

    private int getHeight(Node<T> node) {
        if (node == null) return -1;
        int leftHeight = getHeight(node.getLeft());
        int rightHeight = getHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void inOrderTraversal() {
        if (isEmpty()) return;
        inOrderTraversal(root);
        System.out.println();
    }
    // E R D
    private void inOrderTraversal(Node<T> node) {
        if (node == null) return;
        inOrderTraversal(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderTraversal(node.getRight());
    }

    public void preOrderTraversal() {
        if (isEmpty()) return;
        preOrderTraversal(root);
        System.out.println();
    }
    //  R E D
    private void preOrderTraversal(Node<T> node) {
        if (node == null) return;
        System.out.print(node.getData() + " ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void postOrderTraversal() {
        if (isEmpty()) return;
        postOrderTraversal(root);
        System.out.println();
    }
    // E D R
    private void postOrderTraversal(Node<T> node) {
        if (node == null) return;
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getData() + " ");
    }
}
