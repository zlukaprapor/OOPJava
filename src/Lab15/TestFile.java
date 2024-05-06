/**
 * TestFile class reads information from a file and creates Animal objects based on that information.
 * It demonstrates file reading and exception handling.
 */

package Lab15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestFile {

    /**
     * Reads information from a file and creates Animal objects based on that information.
     * Prints error messages if there are any issues with reading or creating objects.
     *
     * @param args the command-line arguments (unused in this program)
     */
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("animals.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) { // Assuming each line has 4 parts: name, age, species, breed
                    try {
                        // Create animal object based on the information read from the file
                        Animal animal;
                        if (parts[2].equals("Dog")) {
                            animal = new Dog(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                        } else if (parts[2].equals("Cat")) {
                            animal = new Cat(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3]);
                        } else {
                            System.out.println("Unknown species: " + parts[2]);
                            continue; // Skip this line and continue to the next one
                        }
                        animals.add(animal);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error creating animal: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Display information about each animal in the ArrayList
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
