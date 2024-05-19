package Lab20;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Catalogue class represents a collection of Animal items.
 * It provides methods for adding new items to the catalogue and saving the catalogue to a text file.
 */
public class Catalogue {
    private List<Animal> items;

    /**
     * Constructs a Catalogue object with an empty collection of items.
     */
    public Catalogue() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds a new item to the catalogue.
     *
     * @param item the item to add
     */
    public void addNewItem(Animal item) {
        items.add(item);
    }

    /**
     * Searches for an item in the catalogue by its ID.
     *
     * @param id the ID of the item to search for
     * @return the item if found, otherwise null
     */
    public Animal searchItem(int id) {
        if (id >= 0 && id < items.size()) {
            return items.get(id);
        }
        return null;
    }

    /**
     * Displays information about all items in the catalogue.
     */
    public void displayAllItems() {
        for (int id = 0; id < items.size(); id++) {
            System.out.println("Item ID: " + id + " - " + items.get(id));
        }
    }

    /**
     * Saves information about items in the catalogue to a text file.
     *
     * @param fileName the name of the file to save the information to
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveInfoToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Animal item : items) {
                writer.write(item.getClass().getSimpleName()); // Write the class name
                writer.newLine();

                // Write attributes
                writer.write("name=" + item.getName());
                writer.newLine();
                writer.write("age=" + item.getAge());
                writer.newLine();
                writer.write("species=" + item.getSpecies());
                writer.newLine();

                if (item instanceof Dog) {
                    writer.write("breed=" + ((Dog) item).getBreed());
                    writer.newLine();
                } else if (item instanceof Cat) {
                    writer.write("color=" + ((Cat) item).getColor());
                    writer.newLine();
                }

                writer.newLine(); // Add a blank line between items
            }
        }
    }

    /**
     * Reads information from a text file and populates the catalogue.
     *
     * @param fileName the name of the file to read the information from
     * @throws IOException if an I/O error occurs while reading from the file
     */
    public void readInfoFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Read class name
                String className = line.trim();

                // Read attributes
                String name = reader.readLine().split("=")[1];
                int age = Integer.parseInt(reader.readLine().split("=")[1]);
                String species = reader.readLine().split("=")[1];

                // Create Animal object based on class name
                Animal item;
                if (className.equalsIgnoreCase("Dog")) {
                    String breed = reader.readLine().split("=")[1];
                    item = new Dog(name, age, species, breed);
                } else if (className.equalsIgnoreCase("Cat")) {
                    String color = reader.readLine().split("=")[1];
                    item = new Cat(name, age, species, color);
                } else {
                    // Handle unknown class
                    System.out.println("Unknown class: " + className);
                    continue; // Skip this item
                }
                addNewItem(item);// Add item to catalogue
                reader.readLine();// Skip blank line between items
            }
        }
    }
}
