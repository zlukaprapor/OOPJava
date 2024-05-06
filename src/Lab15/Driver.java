package Lab15;

// Tkachenko Oleksii
// OOP Java
// Lab 15 Var18
// Кінцевий срок подання  6.05.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

import Lab12.Animal;
import Lab12.Cat;
import Lab12.Dog;

import java.util.ArrayList;

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
    private static void display(Lab12.Animal animal) {
        System.out.println(animal);
    }

    /**
     * The main method serves as the entry point of the program.
     *
     * @param args the command-line arguments (unused in this program)
     */
    public static void main(String[] args) {
        // Create an ArrayList to hold Animal objects
        ArrayList<Lab12.Animal> animals = new ArrayList<>();

        // Add instances of Dog and Cat to the ArrayList
        animals.add(new Dog("Max", 3, "Dog", "Labrador"));
        animals.add(new Cat("Whiskers", 2, "Cat", "Gray"));

        // Display information about each animal in the ArrayList
        for (Animal animal : animals) {
            display(animal);
        }
    }
}
