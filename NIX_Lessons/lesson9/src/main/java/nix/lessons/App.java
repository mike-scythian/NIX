package nix.lessons;

public class App {
    public static void main(String[] args) {
        Stackable stack = new MyStack<Integer>(3);

        System.out.println(stack.isEmpty());
        if (stack.get() != null)
            System.out.println(stack.get());
        stack.add(25);
        stack.add(-25);
        stack.add(100);
        System.out.println(stack.showTop());

        System.out.println(stack.add(5));

        MyStack<String> stringStack = new MyStack<>(5);

        System.out.println(stringStack.getOptional().orElse("Empty"));

        stringStack.add("One");
        stringStack.add("Two");
        stringStack.add("Three");

        System.out.println(stringStack.getOptional().orElse("Empty"));
    }
}
