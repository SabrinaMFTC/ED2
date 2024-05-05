/*  Authors:
 *  Joao Pedro Rodrigues Vieira        RA 10403595
 *  Sabrina Midori F. T. de Carvalho   RA 10410220
 *  Teacher Andre Kishimoto
 *  Course: Data Structures II         Class 04G11
 *  References:
 */

import java.util.Scanner;

public class Program {
    
    public static void main(String[] args) {
       
        Scanner s = new Scanner(System.in);

        int opt = readOption(s);

        switch(opt) {
            // Load data from a file
            case 1 -> {
                // TODO: check if file is valid and load data if it is
            }

            // Search a key or a scope
            case 2 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // Insert a key or scope
            case 3 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // Change a key from the tree
            case 4 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // Remove a key from the tree
            case 5 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // Save data in a file
            case 6 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // Show BST's content and properties
            case 7 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // Show AVL
            case 8 -> {
                // Verify if file content was loaded into memory
                if (loadedFile) {
                
                } else System.out.println("File not loaded. Please, provide a valid file and select option 1 to load the file's contents into memory.");
            }

            // End program
            case 9 -> {
                s.close();
                System.out.println("Ending Program. . .\nEND");
            }
        }
    }

    public static int readOption(Scanner s) {
        int opt = 0;
        do {
            try {
                opt = s.nextInt();
                if (opt < 1 || opt > 9) System.out.println("Option must be a number between 1-9.");
            } catch (NumberFormatException e) {
                System.out.println(e);
                continue;
            }
        } while (opt < 1 || opt > 9);

        return opt;
    }


}


