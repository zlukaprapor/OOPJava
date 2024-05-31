package Lab20;

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
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add a new item to catalogue");
                System.out.println("2. Search for an item");
                System.out.println("3. Update an item");
                System.out.println("4. Delete an item");
                System.out.println("5. Display item information");
                System.out.println("6. Display all items");
                System.out.println("7. Exit");

                System.out.print("Select an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addItemToCatalogue(scanner);
                        break;
                    case 2:
                        searchForItem(scanner);
                        break;
                    case 3:
                        updateItem(scanner);
                        break;
                    case 4:
                        deleteItem(scanner);
                        break;
                    case 5:
                        displayItemInfo(scanner);
                        break;
                    case 6:
                        displayAllItems();
                        break;
                    case 7:
                        saveAndExit();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    /**
     * Prompts the user for information about a new item and adds it to the catalogue.
     */
    private void addItemToCatalogue(Scanner scanner) {
        System.out.println("Adding a new item to catalogue:");

        System.out.print("Enter name: ");
        String name = scanner.next();

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
     * Prompts the user for the ID of an item to search for and displays the item if found.
     */
    private void searchForItem(Scanner scanner) {
        System.out.print("Enter item ID to search: ");
        int id = scanner.nextInt();

        Animal item = catalogue.searchItem(id);
        if (item != null) {
            System.out.println("Item found: " + item);
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Prompts the user for the ID of an item and new information to update the item.
     */
    private void updateItem(Scanner scanner) {
        System.out.print("Enter item ID to update: ");
        int id = scanner.nextInt();

        Animal currentItem = catalogue.searchItem(id);
        if (currentItem != null) {
            System.out.println("Enter updated information:");

            System.out.print("Enter name: ");
            String name = scanner.next();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();

            System.out.print("Enter species: ");
            String species = scanner.next();

            Animal updatedItem;
            if (species.equalsIgnoreCase("dog")) {
                System.out.print("Enter breed: ");
                String breed = scanner.next();
                updatedItem = new Dog(name, age, species, breed);
            } else if (species.equalsIgnoreCase("cat")) {
                System.out.print("Enter color: ");
                String color = scanner.next();
                updatedItem = new Cat(name, age, species, color);
            } else {
                System.out.println("Unknown species. Item not updated.");
                return;
            }

            catalogue.updateItem(id, updatedItem);
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Prompts the user for the ID of an item to delete and deletes it from the catalogue.
     */
    private void deleteItem(Scanner scanner) {
        System.out.print("Enter item ID to delete: ");
        int id = scanner.nextInt();

        catalogue.deleteItem(id);
    }

    /**
     * Prompts the user for the ID of an item and displays information about the item.
     */
    private void displayItemInfo(Scanner scanner) {
        System.out.print("Enter item ID to display: ");
        int id = scanner.nextInt();

        Animal item = catalogue.searchItem(id);
        if (item != null) {
            System.out.println("Item information: " + item);
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Displays information about all items in the catalogue.
     */
    private void displayAllItems() {
        System.out.println("Displaying all items:");
        catalogue.displayAllItems();
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

