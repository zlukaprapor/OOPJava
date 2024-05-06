package Lab15;

import java.util.Objects;

public class Dog extends Animal {
    private String breed;

    /**
     * Constructs a Dog object with the specified name, age, species, and breed.
     *
     * @param name    the name of the dog
     * @param age     the age of the dog (must be a positive integer)
     * @param species the species of the dog
     * @param breed   the breed of the dog
     * @throws IllegalArgumentException if name is null or empty, age is not a positive integer,
     *                                  species is null or empty, or breed is null or empty
     */
    public Dog(String name, int age, String species, String breed) {
        super(name, age, species);
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be empty or null.");
        }

        this.breed = breed;
    }

    /**
     * Constructs a copy of the given Dog object.
     *
     * @param other the Dog object to copy
     */
    public Dog(Dog other) {
        super(other); // Викликає конструктор батьківського класу (Animal) з іншим об'єктом типу Dog
        this.breed = other.breed;
    }

    /**
     * Returns the breed of the dog.
     *
     * @return the breed of the dog
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets the breed of the dog.
     *
     * @param breed the new breed of the dog
     * @throws IllegalArgumentException if breed is null or empty
     */
    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new IllegalArgumentException("Breed cannot be empty or null.");
        }

        this.breed = breed;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Two dogs are considered equal if they have the same name, age, species, and breed.
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Dog)) {
            return false;
        }

        Dog other = (Dog) obj;
        return super.equals(obj) && Objects.equals(breed, other.breed);
    }

    /**
     * Returns a string representation of the dog.
     *
     * @return a string representation of the dog
     */
    @Override
    public String toString() {
        return super.toString() + ", Breed: " + breed;
    }
}