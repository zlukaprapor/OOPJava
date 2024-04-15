package Lab11;
// Tkachenko Oleksii
// OOP Java
// Lab 11 Var18
// Кінцевий срок подання  16.04.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

/**
 * This class demonstrates inheritance by creating objects of the Animal and Dog classes.
 * It showcases the functionality of inheritance, constructors, getters, setters, toString(), and equals() methods.
 */
public class DogDriver {
    /**
     * The main method serves as the entry point of the program.
     * It creates instances of the Animal and Dog classes and demonstrates their usage.
     *
     * @param args the command-line arguments (unused in this program)
     */
    public static void main(String[] args) {
        Animal animal1 = new Animal("Rex", 5, "Dog");
        Dog dog1 = new Dog("Max", 3, "Dog", "Labrador");

        System.out.println(animal1);
        System.out.println(dog1);

        // Test equality
        Animal animal2 = new Animal("Rex", 5, "Dog");
        Dog dog2 = new Dog("Max", 3, "Dog", "Labrador");
        System.out.println("Are animal1 and animal2 equal? " + animal1.equals(animal2));
        System.out.println("Are dog1 and dog2 equal? " + dog1.equals(dog2));
    }
}
