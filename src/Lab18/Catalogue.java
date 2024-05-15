package Lab18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        // Implementation to read information from the file and populate the catalogue
        // This method can be added based on the requirements of your program
    }
}
