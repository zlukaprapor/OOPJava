package Lab15;

import java.util.Objects;

public class Animal {
    private String name;
    private int age;
    private String species;

    /**
     * Constructs an Animal object with the specified name, age, and species.
     *
     * @param name    the name of the animal
     * @param age     the age of the animal (must be a positive integer)
     * @param species the species of the animal
     * @throws IllegalArgumentException if name is null or empty, age is not a positive integer,
     *                                  or species is null or empty
     */
    public Animal(String name, int age, String species) {
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
     * Constructs a copy of the given Animal object.
     *
     * @param other the Animal object to copy
     */
    public Animal(Animal other) {
        if (other == null) {
            throw new IllegalArgumentException("Animal to copy cannot be null.");
        }

        this.name = other.name;
        this.age = other.age;
        this.species = other.species;
    }

    /**
     * Returns the name of the animal.
     *
     * @return the name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the animal.
     *
     * @param name the new name of the animal
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }

        this.name = name;
    }

    /**
     * Returns the age of the animal.
     *
     * @return the age of the animal
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the animal.
     *
     * @param age the new age of the animal (must be a positive integer)
     * @throws IllegalArgumentException if age is not a positive integer
     */
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }

        this.age = age;
    }

    /**
     * Returns the species of the animal.
     *
     * @return the species of the animal
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Sets the species of the animal.
     *
     * @param species the new species of the animal
     * @throws IllegalArgumentException if species is null or empty
     */
    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            throw new IllegalArgumentException("Species cannot be empty or null.");
        }

        this.species = species;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two animals are considered equal if they have the same name, age, and species.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Animal other = (Animal) obj;
        return age == other.age
                && Objects.equals(name, other.name)
                && Objects.equals(species, other.species);
    }

    /**
     * Returns a string representation of the animal.
     *
     * @return a string representation of the animal
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Species: " + species;
    }
}