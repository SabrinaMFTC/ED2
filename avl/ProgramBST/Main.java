/* Sabrina Midori F. T. de Carvalho 10410220
   Data Structure II - 04G11
   Teacher Andre Kishimoto
   References:
   https://profkishimoto.github.io/edii04g11-2024-1/conteudo/semana-8/Árvore%20AVL.pdf
   https://www.cs.usfca.edu/~galles/visualization/AVLtree.html
*/

package ProgramBST;

import Tree.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BST bst = new BST();
        int option;

        do {
            showMenu();
            option = readOption(s);

            switch (option) {
                // Insert a node
                case 1 -> {
                    // Original tree: 30 - 15 - 38 - 10 - 20 - 51 - 08 - 16 - 27
                    System.out.print("Enter the data to add to the tree: ");
                    int data = s.nextInt();
                    System.out.println("Inserting value " + data + "...");
                    // Try to insert 20 (repeated value)
                    try {
                        bst.insert(data);
                    } catch (RuntimeException e) {
                       System.out.println(e);
                    }
                    System.out.println("Tree:");
                    bst.inOrderTraversal();
                }
                // Remove a node
                case 2 -> {
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty. Please insert a node before.");
                        continue;
                    }
                    System.out.print("Node to be removed from the tree: ");
                    int data = s.nextInt();
                    System.out.println("Removing value " + data + "...");
                    // Try to remove 51, 38, 10, 30 and 1000 (doesn't exist)
                    try {
                        bst.remove(data);
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    System.out.println("In Order:");
                    bst.inOrderTraversal();
                    System.out.println("Pre Order:");
                    bst.preOrderTraversal();
                    System.out.println("Post Order:");
                    bst.postOrderTraversal();
                }
                // Show node information
                case 3 -> {
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty. Please insert a node before.");
                        continue;
                    }
                    System.out.print("Node Data: ");
                    int data = s.nextInt();
                    System.out.println(bst.search(data));
                    try {
                        System.out.println("Predecessor: " + bst.findPredecessor(data).getData());
                    } catch (RuntimeException e) {
                        System.out.println("Node doesn't have predecessor.");
                    }
                    try {
                        System.out.println("Successor: " + bst.findSuccessor(data).getData());
                    } catch (RuntimeException e) {
                        System.out.println("Node doesn't have successor.");
                    }
                }
                // Show Minimum and Maximum Value
                case 4 -> {
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty. Please insert a node before.");
                        continue;
                    }
                    System.out.println("Minimum value in the tree: " + bst.findMin().getData());
                    System.out.println("Maximum value in the tree: " + bst.findMax().getData());
                }
                // Clear tree
                case 5 -> {
                    System.out.println("Clearing tree...");
                    bst.clear();
                }
                // Exit
                case 6 -> {
                    System.out.println("Ending program...");
                    s.close();
                }
            }
        } while (option != 6);
    }

    public static int readOption (Scanner s){
        int option;
        String input;

        do {
            input = s.nextLine();
            try {
                option = Integer.parseInt(input);
                if (option < 1 || option > 6)
                    System.out.print("Value must be between 1-7. Please try again.\nOption: ");
            } catch (NumberFormatException e) {
                option = 0;
            }
        } while (option < 1 || option > 6);
        return option;
    }

    public static void showMenu() {
        System.out.print("""
                ==========================================================
                                Binary Search Tree Program
                ==========================================================
                1. Insert Node
                2. Remove Node
                3. Show Node Information
                4. Show Min/Max Values
                5. Balance Tree
                6. Clear Tree
                7. Exit
                Option:\s""");
    }
}
