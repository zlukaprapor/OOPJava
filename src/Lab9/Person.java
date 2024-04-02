package Lab9;
//Для демонстрації принципу агрегації, я створю новий клас Person,
//який агрегує об'єкти класу Animal. У цьому випадку, клас Person
//буде основним класом, який містить об'єкт класу Animal.
//Цей клас містить поля для імені та віку особи, а також поле для
// домашнього улюбленця (pet) типу Animal. Конструктор, гетери, сетери
// та метод toString() визначені відповідно до вимог.
// Тепер, клас Animal не є статичним членом,
// але є об'єктом, який агрегується класом Person.
public class Person {
    private String name;
    private int age;
    private Animal pet;

    /**
     * Constructs a Person object with the specified name, age, and pet.
     *
     * @param name the name of the person
     * @param age  the age of the person (must be a positive integer)
     * @param pet  the pet of the person
     * @throws IllegalArgumentException if name is null or empty, age is not a positive integer,
     *                                  or pet is null
     */
    public Person(String name, int age, Animal pet) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null.");
        }
        this.name = name;
        this.age = age;
        this.pet = pet;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the new name of the person
     * @throws IllegalArgumentException if name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }
        this.name = name;
    }

    /**
     * Returns the age of the person.
     *
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age the new age of the person (must be a positive integer)
     * @throws IllegalArgumentException if age is not a positive integer
     */
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
        this.age = age;
    }

    /**
     * Returns the pet of the person.
     *
     * @return the pet of the person
     */
    public Animal getPet() {
        return pet;
    }

    /**
     * Sets the pet of the person.
     *
     * @param pet the new pet of the person
     * @throws IllegalArgumentException if pet is null
     */
    public void setPet(Animal pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null.");
        }
        this.pet = pet;
    }

    /**
     * Returns a string representation of the person.
     *
     * @return a string representation of the person
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Pet: " + pet;
    }
}

