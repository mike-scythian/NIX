package nix.lessons.exceptions;

public class StackIsEmptyException extends Exception {

    public StackIsEmptyException() {

        super("Stack is empty.");
    }

    @Override
    public String getMessage() {
        return "StackIsEmptyException -- Error! Stack is empty.";
    }
}
