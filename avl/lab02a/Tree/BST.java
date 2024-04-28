/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/

package Tree;

public class BST extends BinaryTree {

    public BST() { super(null); }
    public BST(Node root) { super(root); }

    public Node search(int data) {
        if (isEmpty()) return null;
        return search(root, data);
    }

    private Node search(Node node, int data) {
        if (node == null || node.getData() == data) return node;
        else if (node.getData() < data) return search(node.getRight(), data);
        else return search(node.getLeft(), data);
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
    }

    public void remove(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty.");
            return;
        }
        Node node = search(data);

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
    }

    public Node findMin() {
        if (isEmpty()) return null;
        return findMin(root, root);
    }

    private Node findMin(Node node, Node min) {
        if (node == null) return min;
        if (node.getData() < min.getData()) min = node;
        return findMin(node.getLeft(), min);
    }

    public Node findMax() {
        if (isEmpty()) return null;
        return findMax(root, root);
    }

    private Node findMax(Node node, Node max) {
        if (node == null) return max;
        if (node.getData() > max.getData()) max = node;
        return findMax(node.getRight(), max);
    }

    public Node findPredecessor(int data) {
        Node node = search(data);
        if (node == null) return null;

        // If node is the min value of the tree there is no predecessor
        if (data == findMin().getData()) return null;

        // If node does not have left subtree
        if (node.getLeft() == null) {
            // If parent's data is smaller than data, predecessor is node's parent
            if (node.getParent().getData() < data) return node.getParent();
            // If parent's data is bigger than data, go up in the tree
            else {
                while (node.getParent() != null) {
                    if (node.getParent().getData() < data) return node.getParent();
                    else node = node.getParent();
                }
                // If node doesn't have predecessor
                return null;
            }

        // If node has left subtree
        } else return findPredecessor(node.getLeft());
    }

    private Node findPredecessor(Node node) {
        if (node.getRight() == null) return node;
        return findPredecessor(node.getRight());
    }

    public Node findSuccessor(int data) {
        Node node = search(data);
        if (node == null) return null;

        // If node is the max value of the tree there is no successor
        if (data == findMax().getData()) return null;

        // If node does not have right subtree
        if (node.getRight() == null) {
            // If parent's data is bigger than data, successor is node's parent
            if (node.getParent().getData() > data) return node.getParent();
            // If parent's data is smaller than data, go up in the tree
            else {
                while (node.getParent() != null) {
                    if (node.getParent().getData() > data) return node.getParent();
                    else node = node.getParent();
                }
                // If node doesn't have successor
                return null;
            }

        // If node has right subtree
        } else return findSuccessor(node.getRight());
    }

    private Node findSuccessor(Node node) {
        if (node.getLeft() == null) return node;
        return findSuccessor(node.getLeft());
    }

    public void clear() {
        if (isEmpty()) {
            System.out.println("Tree is empty.");
            return;
        }
        clear(root);
        setRoot(null);
    }

    private void clear(Node node) {
        if (node == null) return;
        clear(node.getLeft());
        clear(node.getRight());
        node.setLeft(null);
        node.setRight(null);
        // preOrderTraversal();
    }
}
