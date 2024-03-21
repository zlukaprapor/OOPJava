package Lab6;

/**
 * The AnimalDriver class serves as a driver to test the functionality of the Animal class.
 */
public class AnimalDriver {

    public static void main(String[] args) {
        // Creating an Animal object using the constructor
        Animal myAnimal = new Animal("Murka", 3, "Cat");

        // Displaying information about the animal before modification
        System.out.println("Before modification:");
        displayAnimalInfo(myAnimal);

        // Modifying the attributes of the animal using setter methods
        myAnimal.setName("Tuzik");
        myAnimal.setAge(4);
        myAnimal.setSpecies("Dog");

        // Displaying information about the animal after modification
        System.out.println("\nAfter modification:");
        displayAnimalInfo(myAnimal);
    }

    /**
     * Displays information about the given animal.
     *
     * @param animal The animal whose information needs to be displayed.
     */
    private static void displayAnimalInfo(Animal animal) {
        System.out.println("Name: " + animal.getName());
        System.out.println("Age: " + animal.getAge());
        System.out.println("Species: " + animal.getSpecies());
        System.out.println();
    }
}
