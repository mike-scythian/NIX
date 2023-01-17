package nix.lessons;

import nix.lessons.exceptions.StackIsEmptyException;
import nix.lessons.exceptions.StackOverFlowException;

import java.lang.reflect.Array;
import java.util.Optional;

public class MyStack<T> implements Stackable {

    private int size;
    private T[] stack;
    private int top;

    public MyStack() {

        this.size = 10;
        this.stack = (T[]) Array.newInstance(Object.class, size);
        this.top = -1;
    }

    public MyStack(int n) {

        this.size = n;
        this.stack = (T[]) Array.newInstance(Object.class, size);
        this.top = -1;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public boolean isFull() {
        return top == stack.length - 1;
    }

    public boolean add(Object element) {
        try {
            if (this.isFull())
                throw new StackOverFlowException();
            top++;
            this.stack[top] = (T) element;
            return true;
        } catch (StackOverFlowException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean addElement(Object element) throws StackOverFlowException {
        if (this.isFull())
            throw new StackOverFlowException();
        top++;
        this.stack[top] = (T) element;
        return true;

    }

    public T get() {
        try {
            if (this.isEmpty())
                throw new StackIsEmptyException();
            return stack[top--];
        } catch (StackIsEmptyException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public T getElement() throws StackIsEmptyException {
        if (this.isEmpty())
            throw new StackIsEmptyException();
        return stack[top--];
    }

    public Optional<T> getOptional() {

        try {
            if (this.isEmpty())
                throw new StackIsEmptyException();
            return Optional.of(stack[top--]);
        } catch (StackIsEmptyException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    public T showTop() {
        return stack[top];
    }
}
