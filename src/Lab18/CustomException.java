package Lab18;

public class CustomException {

    /**
     * The IllegalNameException class represents an exception that is thrown when an invalid name is provided.
     * This is a subclass of IllegalArgumentException.
     */
    public static class IllegalNameException extends IllegalArgumentException {
        /**
         * Constructs a new IllegalNameException with the specified detail message.
         *
         * @param message the detail message
         */
        public IllegalNameException(String message) {
            super(message);
        }
    }

    /**
     * The IllegalAgeException class represents an exception that is thrown when an invalid age is provided.
     * This is a subclass of IllegalArgumentException.
     */
    public static class IllegalAgeException extends IllegalArgumentException {
        /**
         * Constructs a new IllegalAgeException with the specified detail message.
         *
         * @param message the detail message
         */
        public IllegalAgeException(String message) {
            super(message);
        }
    }

    /**
     * The IllegalSpeciesException class represents an exception that is thrown when an invalid species is provided.
     * This is a subclass of IllegalArgumentException.
     */
    public static class IllegalSpeciesException extends IllegalArgumentException {
        /**
         * Constructs a new IllegalSpeciesException with the specified detail message.
         *
         * @param message the detail message
         */
        public IllegalSpeciesException(String message) {
            super(message);
        }
    }

    /**
     * The IllegalColorException class represents an exception that is thrown when an invalid color is provided.
     * This is a subclass of IllegalArgumentException.
     */
    public static class IllegalColorException extends IllegalArgumentException {
        /**
         * Constructs a new IllegalColorException with the specified detail message.
         *
         * @param message the detail message
         */
        public IllegalColorException(String message) {
            super(message);
        }
    }

    /**
     * The IllegalBreedException class represents an exception that is thrown when an invalid breed is provided.
     * This is a subclass of IllegalArgumentException.
     */
    public static class IllegalBreedException extends IllegalArgumentException {
        /**
         * Constructs a new IllegalBreedException with the specified detail message.
         *
         * @param message the detail message
         */
        public IllegalBreedException(String message) {
            super(message);
        }
    }

}

