package Lab7;
// Tkachenko Oleksii
// OOP Java
// Lab 7 Var18
// Кінцевий срок подання  14.03.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The ArrayAnimal class interacts with the user to gather information about animals,
 * creates an ArrayList of Animal objects, populates them with the provided information,
 * and then displays the details of each animal.
 * <p>
 * <p>
 * <p>
 * The Animal class represents an animal with attributes such as name, age, and species.
 * It includes a constructor to initialize these attributes and getter and setter methods
 * for accessing and modifying the values.
 */
public class ArrayAnimal {
    /**
     * The main method prompts the user to input the number of animals, their details,
     * creates Animal objects, adds them to an ArrayList, and then displays information
     * about each animal.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Animal> animals = new ArrayList<>();

        System.out.println("Enter the number of animals:");
        int numOfAnimals = scanner.nextInt();
        while (numOfAnimals <= 0) {
            System.out.println("Number of animals cannot be negative or null. Please enter again!");
            System.out.println("Enter the number of animals:");
            numOfAnimals = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        }


        for (int i = 0; i < numOfAnimals; i++) {
            System.out.println("Enter details for animal " + (i + 1) + ":");

            System.out.println("Name:");
            String name = scanner.nextLine().trim();

            while (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter again!");
                System.out.println("Name:");
                name = scanner.nextLine().trim();
            }

            System.out.println("Age:");
            int age = scanner.nextInt();
            while (age <= 0) {
                System.out.println("Age cannot be negative or null. Enter correct age!");
                System.out.println("Age:");
                age = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            }

            System.out.println("Species:");
            String species = scanner.nextLine().trim();
            while (species.isEmpty()) {
                System.out.println("Species cannot be empty. Please enter again!");
                System.out.println("Species:");
                species = scanner.nextLine().trim();
            }
            Animal animal = new Animal(name, age, species);
            animals.add(animal);
        }

        System.out.println("Details of animals:");
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
//  Murka
//  Cat
//  Tuzik
//  Dog



