package Lab19.CustomException;

/**
 * The IllegalAgeException class represents an exception that is thrown when an invalid age is provided.
 * This is a subclass of IllegalArgumentException.
 */
public class IllegalAgeException extends IllegalArgumentException {
    /**
     * Constructs a new IllegalAgeException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalAgeException(String message) {
        super(message);
    }
}
