package Lab17;

// Tkachenko Oleksii
// OOP Java
// Lab 17 Var18
// Кінцевий срок подання  14.05.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class serves as the driver program to demonstrate abstract
 * by creating instances of the Animal, Dog, and Cat classes and displaying their information.
 */
public class Driver {

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

        // Display original list
        System.out.println("Original list of animals:");
        for (Animal animal : animals) {
            display(animal);
        }

        // Call displaySortedList method
        displaySortedList(animals);

        // Display original list again
        System.out.println("\nOriginal list of animals after sorting:");
        for (Animal animal : animals) {
            display(animal);
        }
    }

    /**
     * Displays the sorted list of animals.
     *
     * @param animals an ArrayList containing instances of Animal or its subclasses
     */
    private static void displaySortedList(ArrayList<? extends Animal> animals) {
        // Create a copy of the original list
        ArrayList<Animal> copy = new ArrayList<>(animals);
        // Sort the copied list
        Collections.sort(copy);
        // Display the sorted list
        System.out.println("\nAnimals sorted by age:");
        for (Animal animal : copy) {
            display(animal);
        }
    }

    /**
     * Displays information about a single animal.
     *
     * @param animal the animal to display information about
     */
    private static void display(Animal animal) {
        System.out.println(animal);
    }

}
