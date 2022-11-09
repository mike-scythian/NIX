package nix.lessons.exceptions;

public class StackOverFlowException extends Exception{

    public StackOverFlowException (){

        super("Stack is full.");
    }

    @Override
    public String getMessage() {
        return "StackOverFlowException -- Error! Stack is full.";
    }
}
