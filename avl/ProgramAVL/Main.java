/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/

package ProgramAVL;

import Tree.*;

public class Main {

    public static void main(String[] args) {

        AVL avl = new AVL();
        Node newRoot;

        System.out.println("""
        ================================================
                    First Test: keys 1, 2, 3
        ================================================
        """);
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        newRoot = avl.rotateLeft(avl.getRoot());
        System.out.println("*** After rotating left ***\n");
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        System.out.print("Pre Order: ");
        avl.preOrderTraversal();
        System.out.println();
        avl.clear();

        System.out.println("""
        ================================================
                   Second Test: keys 3, 2, 1
        ================================================
        """);
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        newRoot = avl.rotateRight(avl.getRoot());
        System.out.println("*** After rotating right ***\n");
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        System.out.print("Pre Order: ");
        avl.preOrderTraversal();
        System.out.println();
        avl.clear();

        System.out.println("""
        ================================================
                    Third Test: keys 3, 1, 2
        ================================================
        """);
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        newRoot = avl.rotateLeftRight(avl.getRoot());
        System.out.println("*** After rotating left right ***\n");
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        System.out.print("Pre Order: ");
        avl.preOrderTraversal();
        System.out.println();
        avl.clear();

        System.out.println("""
        ================================================
                    Fourth Test: keys 1, 3, 2
        ================================================
        """);
        avl.insert(1);
        avl.insert(3);
        avl.insert(2);
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        newRoot = avl.rotateRightLeft(avl.getRoot());
        System.out.println("*** After rotating right left ***\n");
        System.out.println(avl.search(1));
        System.out.println(avl.search(2));
        System.out.println(avl.search(3));
        System.out.print("Pre Order: ");
        avl.preOrderTraversal();
        System.out.println();
    }
}
