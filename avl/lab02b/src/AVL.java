/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/
public class AVL extends BST {

    public AVL() { super(null); }
    public AVL(Node root) { super(root); }

    public Node rotateLeft(Node node1) {
        Node node2 = node1.getRight();
        Node node2Left = node2.getLeft();

        if (node1.isRoot()) {
            setRoot(node2);
            node2.setParent(null);
        } else {
            node1.getParent().setRight(node2);
            node2.setParent(node1.getParent());
        }

        node1.setParent(node2);
        node2.setLeft(node1);

        node1.setRight(node2Left);
        if (node2Left != null) node2Left.setParent(node1);

        return node2;
    }

    public Node rotateRight(Node node3) {
        Node node2 = node3.getLeft();
        Node node2Right = node2.getRight();

        if (node3.isRoot()) {
            setRoot(node2);
            node2.setParent(null);
        } else {
            node3.getParent().setLeft(node2);
            node2.setParent(node3.getParent());
        }

        node3.setParent(node2);
        node2.setRight(node3);

        node3.setLeft(node2Right);
        if (node2Right != null) node2Right.setParent(node3);

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

    public void insert(int data) {
        if (isEmpty()) {
            Node root = new Node(data);
            setRoot(root);
            return;
        }
        insert(root, data);
    }

    private void insert(Node aux, int data) {
        if (search(data) != null) throw new RuntimeException();
        if (aux == null) return;

        Node node = new Node(data);

        if (aux.getData() < data) {
            if (aux.getRight() == null) {
                aux.setRight(node);
                node.setParent(aux);
            } else insert(aux.getRight(), data);
        }
        else if (aux.getData() > data) {
            if (aux.getLeft() == null) {
                aux.setLeft(node);
                node.setParent(aux);
            } else insert(aux.getLeft(), data);
        }
        balanceTree(node);
    }

    public void remove(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty.");
            return;
        }
        Node node = search(data);
        Node parent = node.getParent();

        if (node.isLeaf()) {
            if (node.isRoot()) setRoot(null);
            else {
                if (node.getParent().getData() > node.getData()) node.getParent().setLeft(null);
                else node.getParent().setRight(null);
                node.setParent(null);
            }
        }
        else {
            if (node.getLeft() != null) {
                Node predecessor = findPredecessor(data);
                node.setData(predecessor.getData());

                if (predecessor.isLeaf()) {
                    if (predecessor.getParent().getData() >= predecessor.getData()) predecessor.getParent().setLeft(null);
                    else predecessor.getParent().setRight(null);
                } else {
                    node.setLeft(predecessor.getLeft());
                    predecessor.getLeft().setParent(node);
                    predecessor.setLeft(null);
                }
                predecessor.setParent(null);
            } else {
                Node successor = findSuccessor(data);
                node.setData(successor.getData());

                if (successor.isLeaf()) {
                    if (successor.getParent().getData() <= successor.getData()) successor.getParent().setRight(null);
                    else successor.getParent().setLeft(null);
                } else {
                    node.setRight(successor.getRight());
                    successor.getRight().setParent(node);
                    successor.setRight(null);
                }
                successor.setParent(null);
            }
        }
        balanceTree(parent);
    }

    public void balanceTree(Node node) {
        while (node != null) {
            int bf = node.getBalanceFactor();

            if (bf > 1) {
                if (node.getRight().getBalanceFactor() < 0) {
                    System.out.println("Node " + node.getData() + " (BF = " + node.getBalanceFactor() + "): Rotation RL");
                    rotateRightLeft(node);
                } else {
                    System.out.println("Node " + node.getData() + " (BF = " + node.getBalanceFactor() + "): Rotation LL");
                    rotateLeft(node);
                }
            } else if (bf < -1) {
                if (node.getLeft().getBalanceFactor() > 0) {
                    System.out.println("Node " + node.getData() + " (BF = " + node.getBalanceFactor() + "): Rotation LR");
                    rotateLeftRight(node);
                } else {
                    System.out.println("Node " + node.getData() + " (BF = " + node.getBalanceFactor() + "): Rotation RR");
                    rotateRight(node);
                }
            }
            node = node.getParent();
        }
    }
}
