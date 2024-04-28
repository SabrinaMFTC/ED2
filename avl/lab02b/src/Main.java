/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/
public class Main {

    public static void main(String[] args) {

        // a) Inserir, nessa ordem, os nós com chaves 1, 2 e 3.
        // Rotation LL
        System.out.println("a) Inserting nodes with keys 1, 2, 3...");
        AVL A = new AVL();
        A.insert(1);
        A.insert(2);
        A.insert(3);
        System.out.print("Balanced Tree: ");
        A.preOrderTraversal();  // 2 1 3
        System.out.println();

        // b) Inserir, nessa ordem, os nós com chaves 3, 2 e 1.
        // Rotation RR
        System.out.println("b) Inserting nodes with keys 3, 2, 1...");
        AVL B = new AVL();
        B.insert(3);
        B.insert(2);
        B.insert(1);
        System.out.print("Balanced Tree: ");
        B.preOrderTraversal();  // 2 1 3
        System.out.println();

        // c) Inserir, nessa ordem, os nós com chaves 3, 1 e 2.
        // Rotation LR
        System.out.println("c) Inserting nodes with keys 3, 1, 2...");
        AVL C = new AVL();
        C.insert(3);
        C.insert(1);
        C.insert(2);
        System.out.print("Balanced Tree: ");
        C.preOrderTraversal();  // 2 1 3
        System.out.println();

        // d) Inserir, nessa ordem, os nós com chaves 1, 3 e 2.
        // Rotation RL
        System.out.println("d) Inserting nodes with keys 1, 3, 2...");
        AVL D = new AVL();
        D.insert(1);
        D.insert(3);
        D.insert(2);
        System.out.print("Balanced Tree: ");
        D.preOrderTraversal();  // 2 1 3
        System.out.println();

        // e) Inserir, nessa ordem, os nós com chaves 5, 4, 3, 1, 2, 6, 7, 9 e 8.
        System.out.println("e) Inserting nodes with keys 5, 4, 3, 1, 2, 6, 7, 9, 8...");
        AVL E = new AVL();
        E.insert(5);
        E.insert(4);
        E.insert(3); // --> Rotation RR
        E.insert(1);
        E.insert(2); // --> Rotation LR
        E.insert(6);
        E.insert(7); // --> Rotation LL
        E.insert(9);
        E.insert(8); // --> Rotation RL
        System.out.print("Balanced Tree: ");
        E.preOrderTraversal();  // 4 2 1 3 6 5 8 7 9
        System.out.println();

        // f) Remover o nó 4 da árvore do item (e).
        System.out.println("f) Removing node with key 4...");
        E.remove(4);
        System.out.print("Balanced Tree: ");
        E.preOrderTraversal();  // 3 2 1 6 5 8 7 9
        System.out.println();

        // g) Remover o nó 5 da árvore do item (f).
        System.out.println("g) Removing node with key 5...");
        E.remove(5);
        System.out.print("Balanced Tree: ");
        E.preOrderTraversal();  // 3 2 1 8 6 7 9
        System.out.println();

        // h) Remover o nó 1 da árvore do item (g).
        System.out.println("h) Removing node with key 1...");
        E.remove(1);
        System.out.print("Balanced Tree: ");
        E.preOrderTraversal();  // 6 3 2 8 7 9
    }
}
