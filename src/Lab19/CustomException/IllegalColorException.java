package Lab19.CustomException;

/**
 * The IllegalColorException class represents an exception that is thrown when an invalid color is provided.
 * This is a subclass of IllegalArgumentException.
 */
public class IllegalColorException extends IllegalArgumentException {
    /**
     * Constructs a new IllegalColorException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalColorException(String message) {
        super(message);
    }
}
