package Lab6;
// Tkachenko Oleksii
// OOP Java
// Lab 6 Var18
// Кінцевий срок подання  07.03.2024
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
     */
    public Animal(String name, int age, String species){
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
}
