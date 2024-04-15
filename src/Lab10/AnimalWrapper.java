package Lab10;

public class AnimalWrapper {
    private final Animal animal;

    /**
     * Constructs an AnimalWrapper object with the specified Animal object.
     *
     * @param animal the Animal object to wrap
     */
    public AnimalWrapper(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Animal cannot be null.");
        }

        this.animal = new Animal(animal); // Використовуємо конструктор копіювання
    }
    /**
     * Copy constructor.
     *
     * @param other the AnimalWrapper object to copy
     */
    public AnimalWrapper(AnimalWrapper other) {
        if (other == null) {
            throw new IllegalArgumentException("AnimalWrapper to copy cannot be null.");
        }
        this.animal = new Animal(other.animal); // Використовуємо конструктор копіювання з Animal
    }
    /**
     * Returns the name of the wrapped animal.
     *
     * @return the name of the animal
     */
    public String getName() {
        return animal.getName();
    }

    /**
     * Returns the age of the wrapped animal.
     *
     * @return the age of the animal
     */
    public int getAge() {
        return animal.getAge();
    }

    /**
     * Returns the species of the wrapped animal.
     *
     * @return the species of the animal
     */
    public String getSpecies() {
        return animal.getSpecies();
    }

    /**
     * Returns a string representation of the wrapped animal.
     *
     * @return a string representation of the animal
     */
    @Override
    public String toString() {
        return animal.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
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

        AnimalWrapper other = (AnimalWrapper) obj;
        return animal.equals(other.animal);
    }
}
