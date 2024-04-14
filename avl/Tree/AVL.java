/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/

package Tree;

public class AVL extends BST {

    public AVL() { super(null); }
    public AVL(Node root) { super(root); }

    public Node rotateLeft(Node node1) {
        Node node2 = node1.getRight();

        if (node1.isRoot()) {
            setRoot(node2);
            node2.setParent(null);
        }
        node1.setParent(node2);
        node1.setRight(node2.getLeft());
        if (node2.getLeft() != null) node2.getLeft().setParent(node1);
        node2.setLeft(node1);

        return node2;
    }

    public Node rotateRight(Node node3) {
        Node node2 = node3.getLeft();

        if (node3.isRoot()) {
            setRoot(node2);
            node2.setParent(null);
        }
        node3.setParent(node2);
        node3.setLeft(node2.getRight());
        if (node2.getRight() != null) node2.getRight().setParent(node3);

        node2.setRight(node3);

        return node2;
    }

    public Node rotateLeftRight(Node node3) {
        Node node1 = node3.getLeft();
        Node node2 = node1.getRight();

        node3.setLeft(node2);
        node1.setParent(node2);
        node1.setRight(node2.getLeft());
        if (node2.getLeft() != null) node2.getLeft().setParent(node1);
        node2.setLeft(node1);

        rotateRight(node3);
        return node2;
    }

    public Node rotateRightLeft(Node node1) {
        Node node3 = node1.getRight();
        Node node2 = node3.getLeft();

        node1.setRight(node2);
        node3.setParent(node2);

        node3.setLeft(node2.getRight());
        if (node2.getRight() != null) node2.getRight().setParent(node3);
        node2.setRight(node3);

        rotateLeft(node1);
        return node2;
    }
}
