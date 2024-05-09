package Lab16;

public class CustomException {
    public static class IllegalNameException extends IllegalArgumentException {
        public IllegalNameException(String message) {
            super(message);
        }
    }
    public static class IllegalAgeException extends IllegalArgumentException {
        public IllegalAgeException(String message) {
            super(message);
        }
    }
    public static class IllegalSpeciesException extends IllegalArgumentException {
        public IllegalSpeciesException(String message) {
            super(message);
        }
    }
    public static class IllegalColorException extends IllegalArgumentException {
        public IllegalColorException(String message) {
            super(message);
        }
    }
    public static class IllegalBreedException extends IllegalArgumentException {
        public IllegalBreedException(String message) {
            super(message);
        }
    }

}

