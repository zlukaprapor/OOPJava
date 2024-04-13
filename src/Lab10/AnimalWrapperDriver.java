package Lab10;

public class AnimalWrapperDriver {
    public static void main(String[] args) {
        // Створення об'єкта класу Animal
        Animal animal = new Animal("Leo", 3, "Lion");

        // Створення об'єкта класу AnimalWrapper і передача туди об'єкта класу Animal
        AnimalWrapper animalWrapper = new AnimalWrapper(animal);

        // Виведення інформації про тварину з використанням об'єкта класу AnimalWrapper
        System.out.println("Animal Info:");
        System.out.println(animalWrapper);
    }
}
