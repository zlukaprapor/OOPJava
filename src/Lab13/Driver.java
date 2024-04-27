package Lab13;

// Tkachenko Oleksii
// OOP Java
// Lab 13 Var18
// Кінцевий срок подання  29.04.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class serves as the driver program to demonstrate polymorphism
 * by creating instances of the Animal, Dog, and Cat classes and displaying their information.
 */
public class Driver {
    /**
     * Displays information about an Animal object.
     *
     * @param animal the Animal object to display information about
     */
    private static void display(Animal animal) {
        System.out.println(animal);
    }

    /**
     * The main method serves as the entry point of the program.
     *
     * @param args the command-line arguments (unused in this program)
     */
    public static void main(String[] args) {
        // Create an ArrayList to hold Animal objects
        ArrayList<Animal> animals = new ArrayList<>();

        // Add instances of Dog and Cat to the ArrayList
        animals.add(new Dog("Max", 3, "Dog", "Labrador"));
        animals.add(new Dog("Charlie", 5, "Dog", "Golden Retriever"));
        animals.add(new Dog("Bella", 2, "Dog", "German Shepherd"));
        animals.add(new Dog("Lucky", 4, "Dog", "Beagle"));
        animals.add(new Dog("Buddy", 1, "Dog", "Poodle"));
        animals.add(new Dog("Daisy", 6, "Dog", "Yorkshire Terrier"));
        animals.add(new Cat("Garfield", 5, "Cat", "Orange Tabby"));
        animals.add(new Cat("Felix", 3, "Cat", "Black and White"));
        animals.add(new Cat("Mittens", 1, "Cat", "Siamese"));
        animals.add(new Cat("Oliver", 4, "Cat", "Persian"));
        animals.add(new Cat("Sabrina", 2, "Cat", "Ragdoll"));
        animals.add(new Cat("Whiskers", 6, "Cat", "Gray"));

        // Display information about each animal in the ArrayList
        for (Animal animal : animals) {
            display(animal);
        }
        // Display information about sorted each animal in the ArrayList
        System.out.println("\nAnimals sorted by age:**");
        Collections.sort(animals);
        for (Animal animal : animals) {
            display(animal);
        }
    }
}
