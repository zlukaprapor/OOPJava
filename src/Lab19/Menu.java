package Lab19;

import java.io.IOException;
import java.util.Scanner;
/**
 * The Menu class provides a menu-driven interface for interacting with a catalogue of Animal objects.
 * It allows users to add new items to the catalogue and save the catalogue to a file upon exit.
 */
public class Menu {
    private Catalogue catalogue;

    /**
     * Constructs a Menu object with the specified catalogue.
     *
     * @param catalogue the catalogue to interact with
     */
    public Menu(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    /**
     * Displays the menu options and handles user input.
     */
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        // Displaying information about elements read from the file
        System.out.println("\nItems loaded from file:");
        for (Animal item : catalogue.getItems()) {
            System.out.println(item);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new item to catalogue");
            System.out.println("2. Exit");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItemToCatalogue();
                    break;
                case 2:
                    saveAndExit();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prompts the user for information about a new item and adds it to the catalogue.
     */
    private void addItemToCatalogue() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adding a new item to catalogue:");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();

        System.out.print("Enter species: ");
        String species = scanner.next();

        Animal item;
        if (species.equalsIgnoreCase("dog")) {
            System.out.print("Enter breed: ");
            String breed = scanner.next();
            item = new Dog(name, age, species, breed);
        } else if (species.equalsIgnoreCase("cat")) {
            System.out.print("Enter color: ");
            String color = scanner.next();
            item = new Cat(name, age, species, color);
        } else {
            System.out.println("Unknown species. Item not added.");
            return;
        }

        catalogue.addNewItem(item);
        System.out.println("Item added to catalogue.");
    }

    /**
     * Saves information about items in the catalogue to a text file and exits the program.
     */
    private void saveAndExit() {
        try {
            catalogue.saveInfoToFile("catalogue.txt");
            System.out.println("Catalogue saved to file. Exiting program.");
        } catch (IOException e) {
            System.out.println("Error saving catalogue to file: " + e.getMessage());
        }
    }
}

