/* Sabrina Midori F. T. de Carvalho      RA 10410220
   Estrutura de Dados II - Prof. Andre Kishimoto
   Turma 04G11 - Atividade 01D (Arvore Binaria de Busca)
   Referencias: materiais de aula
*/

package Default;

import Tree.*;
import java.util.Scanner;

public class ProgramBST {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BST<String> bst = new BST<>();
        int option;

        do {
            showMenu();
            option = readOption(s);

            switch (option) {
                // Insert a node
                case 1 -> {
                    // Original tree: 30 - 15 - 38 - 10 - 20 - 51 - 08 - 16 - 27
                    System.out.print("Enter the data to add to the tree: ");
                    String data = s.nextLine();
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
                    String data = s.nextLine();
                    System.out.println("Removing value " + data + "...");
                    // Try to remove 51, 38, 10, 30 and 1000 (doesn't exist)
                    try {
                        bst.remove(data);
                    } catch (RuntimeException e) {
                        System.out.println(e);
                    }
                    bst.inOrderTraversal();
                }
                // Show node information
                case 3 -> {
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty. Please insert a node before.");
                        continue;
                    }
                    System.out.print("Node Data: ");
                    String data = s.nextLine();
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
                    System.out.println("Minimum value in the tree: " + bst.findMin().getData());
                    System.out.println("Maximum value in the tree: " + bst.findMax().getData());
                }
                // Clear tree
                case 5 -> {
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty. Nothing to clear.");
                        continue;
                    }
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
                    System.out.print("Value must be between 1-6. Please try again.\nOption: ");
            } catch (NumberFormatException e) {
                System.out.print("Value must be a number.\nOption: ");
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
                5. Clear Tree
                6. Exit
                Option:\s""");
    }
}
