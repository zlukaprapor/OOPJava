package Lab7;
// Tkachenko Oleksii
// OOP Java
// Lab 7 Var18
// Кінцевий срок подання  14.03.2024
// Використано часу- 60 хв
// Це моя власна робота. Не було використано жодної несанкціонованої допомоги


public class Animal {
    // Attributes of the Animal class
    private String name;
    private int age;
    private String species;

    /**
     * Constructs an Animal object with the specified name, age, and species.
     *
     * @param name    The name of the animal.
     * @param age     The age of the animal.
     * @param species The species of the animal.
     * @throws IllegalArgumentException if name is null or empty,
     * age is not a positive integer, or species is null or empty.
     */
    public Animal(String name, int age, String species){
        //IllegalArgumentException - це тип винятку в Java,
        // який виникає, коли метод отримує недопустимі аргументи.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be empty or null.");
        }
        this.name = name;
        this.age = age;
        this.species = species;
    }
    /**
     * Gets the name of the animal.
     *
     * @return The name of the animal.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the animal.
     *
     * @param name The new name to set for the animal.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Gets the age of the animal.
     *
     * @return The age of the animal.
     */
    public int getAge() {
        return age;
    }
    /**
     * Sets the age of the animal.
     *
     * @param age The new age to set for the animal.
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * Gets the species of the animal.
     *
     * @return The species of the animal.
     */
    public String getSpecies() {
        return species;
    }
    /**
     * Sets the species of the animal.
     *
     * @param species The new species to set for the animal.
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Returns a string representation of the Animal object.
     * The string representation includes the name, age, and species of the animal.
     *
     * @return A string containing the name, age, and species of the animal.
     */
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Species: " + species;
    }

}
