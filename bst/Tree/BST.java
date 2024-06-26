/* Sabrina Midori F. T. de Carvalho      RA 10410220
   Estrutura de Dados II - Prof. Andre Kishimoto
   Turma 04G11 - Atividade 01D (Arvore Binaria de Busca)
   Referencias: materiais de aula
*/

package Tree;

public class BST<T extends Comparable<T>> extends BinaryTree<T> {

    public BST() { super(null); }

    public BST(Node<T> root) { super(root); }

    public Node<T> search(T data) {
        if (isEmpty()) return null;
        return search(super.getRoot(), data);
    }

    private Node<T> search(Node<T> node, T data) {
        if (node == null || data.compareTo(node.getData()) == 0) return node;
        else if (data.compareTo(node.getData()) < 0 ) { return search(node.getLeft(), data); }
        else return search(node.getRight(), data);
    }

    public void insert(T data) {
        if (search(data) != null) {
            throw new RuntimeException("Data already exists in the tree.");
        }
        else if (isEmpty()) { super.setRoot(new Node<>(data)); }
        else insert(super.getRoot(), data);
    }

    private void insert(Node<T> node, T data) {
        Node<T> child = new Node<>(data);

        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                child.setParent(node);
                node.setLeft(child);
            } else insert(node.getLeft(), data);
        } else {
            if (node.getRight() == null) {
                child.setParent(node);
                node.setRight(child);
            } else insert(node.getRight(), data);
        }
    }

    public void remove(T data) {
        if (isEmpty() || search(data) == null) throw new RuntimeException("Data doesn't exist in the tree.");
        remove(search(data), data);
    }

    private void remove(Node<T> node, T data) {

        if (node.isRoot()) {
            Node<T> predecessor = findPredecessor(data);
            setRoot(predecessor);
            predecessor.getParent().setRight(null);
            predecessor.setLeft(node.getLeft());
            predecessor.setRight(node.getRight());
            predecessor.setParent(null);
            node.setLeft(null);
            node.setRight(null);
        } else if (node.isLeaf()) {
            if (data.compareTo(node.getParent().getData()) < 0) node.getParent().setLeft(null);
            else node.getParent().setRight(null);

        } else if (node.getLeft() == null) {
            if (data.compareTo(node.getParent().getData()) < 0) node.getParent().setLeft(node.getRight());
            else node.getParent().setRight(node.getRight());

        } else if (node.getRight() == null) {
            if (data.compareTo(node.getParent().getData()) < 0) node.getParent().setLeft(node.getLeft());
            else node.getParent().setRight(node.getLeft());
        }
    }

    public Node<T> findMin() {
        if (isEmpty()) return null;
        return findMin(super.getRoot());
    }

    private Node<T> findMin(Node<T> node) {
        if (node.getLeft() == null) return node;
        return findMin(node.getLeft());
    }

    public Node<T> findMax() {
        if (isEmpty()) return null;
        return findMax(super.getRoot());
    }

    private Node<T> findMax(Node<T> node) {
        if (node.getRight() == null) return node;
        return findMax(node.getRight());
    }

    public Node<T> findPredecessor(T data) {
        Node<T> node = search(data);
        if (node == null) return null;

        // If node is the min value of the tree there is no predecessor
        if (data.compareTo(findMin().getData()) == 0) return null;

        // If node does not have left subtree
        if (node.getLeft() == null) {
            // If parent's data is smaller than data, predecessor is node's parent
            if (data.compareTo(node.getParent().getData()) > 0) return node.getParent();
            // If parent's data is bigger than data, go up in the tree
            else {
                while (node.getParent() != null) {
                    if (data.compareTo(node.getParent().getData()) > 0) return node.getParent();
                    else node = node.getParent();
                }
                // If node doesn't have predecessor
                return null;
            }

        // If node has left subtree
        } else return findPredecessor(node.getLeft());
    }

    private Node<T> findPredecessor(Node<T> node) {
        if (node.getRight() == null) return node;
        return findPredecessor(node.getRight());
    }

    public Node<T> findSuccessor(T data) {
        Node<T> node = search(data);
        if (node == null) return null;

        // If node is the max value of the tree there is no successor
        if (data.compareTo(findMax().getData()) == 0) return null;

        // If node does not have right subtree
        if (node.getRight() == null) {
            // If parent's data is bigger than data, successor is node's parent
            if (data.compareTo(node.getParent().getData()) < 0) return node.getParent();
            // If parent's data is smaller than data, go up in the tree
            else {
                while (node.getParent() != null) {
                    if (data.compareTo(node.getParent().getData()) < 0) return node.getParent();
                    else node = node.getParent();
                }
                // If node doesn't have successor
                return null;
            }

        // If node has right subtree
        } else return findSuccessor(node.getRight());
    }

    private Node<T> findSuccessor(Node<T> node) {
        if (node.getLeft() == null) return node;
        return findSuccessor(node.getLeft());
    }

    public void clear() {
        if (isEmpty()) return;
        clear(super.getRoot());
        root = null;
    }

    private void clear(Node<T> node) {
        if (node == null) return;
        clear(node.getLeft());
        clear(node.getRight());
        node.setLeft(null);
        node.setRight(null);
        //preOrderTraversal();
    }

}
