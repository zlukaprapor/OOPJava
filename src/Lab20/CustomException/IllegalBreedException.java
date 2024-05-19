package Lab20.CustomException;

/**
 * The IllegalBreedException class represents an exception that is thrown when an invalid breed is provided.
 * This is a subclass of IllegalArgumentException.
 */
public  class IllegalBreedException extends IllegalArgumentException {
    /**
     * Constructs a new IllegalBreedException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalBreedException(String message) {
        super(message);
    }
}
