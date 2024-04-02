package Lab9;

// Tkachenko Oleksii
// OOP Java
// Lab 9 Var18
// Кінцевий срок подання  04.04.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

/**
 * The PersonDriver class is a driver program to demonstrate the functionality of the Person class.
 * It creates instances of the Animal class to represent pets and instances of the Person class to represent people.
 * It then modifies the data of a person and their pet, demonstrating the usage of setters.
 * Additionally, it catches and handles IllegalArgumentExceptions that may occur during object creation.
 * This class includes a main method to execute the demonstration.
 */
public class PersonDriver {
    /**
     * The main method creates instances of the Animal and Person classes, modifies their data,
     * and prints out the updated information. It catches and handles IllegalArgumentExceptions
     * that may occur during object creation.
     *
     * @param args the command line arguments (unused)
     */
    public static void main(String[] args) {
        try {
            // Створюємо об'єкт класу Animal для домашнього улюбленця
            Animal dog = new Animal("Buddy", 5, "Dog");

            // Створюємо об'єкт класу Person з відомими параметрами
            Person person = new Person("John", 30, dog);
            System.out.println("Person: " + person);

            // Змінюємо дані особи та її домашнього улюбленця
            person.setName("Jane");
            person.setAge(35);
            Animal newPet = new Animal("Max", 3, "Cat");
            person.setPet(newPet);
            System.out.println("Updated Person: " + person);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }
}
