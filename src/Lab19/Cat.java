package Lab19;

import Lab19.CustomException.IllegalColorException;
import java.util.Objects;
public class Cat extends Animal {
    private String color;

    /**
     * Constructs a Cat object with the specified name, age, species, and color.
     *
     * @param name    the name of the cat
     * @param age     the age of the cat (must be a positive integer)
     * @param species the species of the cat
     * @param color   the color of the cat
     * @throws IllegalArgumentException if any of the parameters is invalid
     */
    public Cat(String name, int age, String species, String color) {
        super(name, age, species);
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalColorException("Color cannot be empty or null.");
        }

        this.color = color;
    }

    /**
     * Constructs a copy of the given Cat object.
     *
     * @param other the Cat object to copy
     */
    public Cat(Cat other) {
        super(other);
        this.color = other.color;
    }

    /**
     * Gets the color of the cat.
     *
     * @return the color of the cat
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color of the cat.
     *
     * @param color the new color of the cat
     * @throws IllegalColorException if the color is empty or null
     */
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalColorException("Color cannot be empty or null.");
        }

        this.color = color;
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
        if (!(obj instanceof Cat)) {
            return false;
        }

        Cat other = (Cat) obj;
        return super.equals(obj) && Objects.equals(color, other.color);
    }

    /**
     * Returns a string representation of the cat.
     *
     * @return a string representation of the cat
     */
    @Override
    public String toString() {
        return super.toString() + ", Color: " + color;
    }
}