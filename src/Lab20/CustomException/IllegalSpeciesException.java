package Lab20.CustomException;

/**
 * The IllegalSpeciesException class represents an exception that is thrown when an invalid species is provided.
 * This is a subclass of IllegalArgumentException.
 */
public class IllegalSpeciesException extends IllegalArgumentException {
    /**
     * Constructs a new IllegalSpeciesException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalSpeciesException(String message) {
        super(message);
    }
}
