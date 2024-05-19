package Lab19.CustomException;

/**
 * The IllegalNameException class represents an exception that is thrown when an invalid name is provided.
 * This is a subclass of IllegalArgumentException.
 */
public class IllegalNameException extends IllegalArgumentException {
    /**
     * Constructs a new IllegalNameException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalNameException(String message) {
        super(message);
    }
}
