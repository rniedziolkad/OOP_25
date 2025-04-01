public class AmbiguousPersonException extends Exception {
    public AmbiguousPersonException(String fullName) {
        super(fullName+" already exists");
    }
}
