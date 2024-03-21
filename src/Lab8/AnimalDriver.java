package Lab8;
// Tkachenko Oleksii
// OOP Java
// Lab 8 Var18
// Кінцевий срок подання  21.03.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

/**
 * The Animal class represents an animal with a name, age, and species.
 * It provides methods to access and modify these attributes, as well as
 * methods to compare animals for equality and retrieve the total number
 * of Animal objects created.
 * This class includes constructors to create Animal objects, getter and setter methods
 * for accessing and modifying the attributes of an animal, and static methods to
 * retrieve the total number of Animal objects created.
 * Additionally, it overrides the equals() and toString() methods for comparing
 * animals and generating string representations of Animal objects, respectively.
 */

public class AnimalDriver {
    public static void main(String[] args) {
        try {
            // Створюємо об'єкт класу Animal з відомими параметрами
            Animal dog = new Animal("Buddy", 5, "Dog");
            System.out.println("Animal 1: " + dog);

            // Створюємо копію об'єкта класу Animal
            Animal dogCopy = new Animal(dog);
            System.out.println("Animal 2 (copy): " + dogCopy);

            // Перевіряємо роботу методу equals()
            System.out.println("Are the animals equal? " + dog.equals(dogCopy));

            // Змінюємо дані першого об'єкта
            dog.setName("Max");
            dog.setAge(7);
            dog.setSpecies("Labrador");
            System.out.println("Animal 1 (updated): " + dog);

            // Перевіряємо знову роботу методу equals()
            System.out.println("Are the animals equal now? " + dog.equals(dogCopy));

            // Тестуємо статичний метод для підрахунку кількості створених об'єктів
            System.out.println("Number of animals created: " + Animal.getNumberOfAnimals());

            // Спроба створення об'єкта з недопустимими параметрами
            // Animal invalidAnimal = new Animal("", -1, ""); // Розкоментуйте для перевірки винятку
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }
}
