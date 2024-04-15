package Lab10;

// Tkachenko Oleksii
// OOP Java
// Lab 10 Var18
// Кінцевий срок подання  16.04.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги

/**
 * The AnimalWrapperDriver class demonstrates the usage of the AnimalWrapper class.
 * It creates an Animal object, wraps it using the AnimalWrapper class, and demonstrates
 * accessing the attributes of the wrapped animal.
 */
public class AnimalWrapperDriver {
    /**
     * The main method serves as the entry point of the program.
     * It creates an Animal object, wraps it using the AnimalWrapper class, and prints
     * information about the wrapped animal.
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Створення об'єкта класу Animal
        Animal animal = new Animal("Leo", 3, "Lion");

        // Створення об'єкта класу AnimalWrapper і передача туди об'єкта класу Animal
        AnimalWrapper animalWrapper = new AnimalWrapper(animal);

        // Виведення інформації про тварину з використанням об'єкта класу AnimalWrapper
        System.out.println("Animal Info:");
        System.out.println(animalWrapper);

        // Створення копії об'єкта класу AnimalWrapper з використанням конструктора копіювання
        AnimalWrapper copiedAnimalWrapper = new AnimalWrapper(animalWrapper);

        // Виведення інформації про копію тварини
        System.out.println("Copied Animal Info:");
        System.out.println(copiedAnimalWrapper);
    }
}
