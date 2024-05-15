// Tkachenko Oleksii
// OOP Java
// Lab 18 Var18
// Кінцевий срок подання 24.05.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

/**
 * TestFile class demonstrates the functionality of reading information from a file
 * and managing a catalogue of Animal objects through a menu-driven interface.
 * It loads information from a file into the catalogue at the start of the program,
 * displays a menu for user interaction, and saves the updated catalogue back to the file upon exit.
 */
package Lab18;

import java.io.IOException;

public class TestFile {

    /**
     * The main method of the TestFile class.
     * It initializes a catalogue, loads information from a file into the catalogue,
     * displays a menu for user interaction, and saves the updated catalogue back to the file upon exit.
     *
     * @param args the command-line arguments (unused)
     */
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();
        Menu menu = new Menu(catalogue);

        // Loading information from file at the start of the program
        try {
            catalogue.readInfoFromFile("catalogue.txt");
            System.out.println("Catalogue loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading catalogue from file: " + e.getMessage());
        }

        // Displaying the menu for user interaction
        menu.displayMenu();
    }
}
