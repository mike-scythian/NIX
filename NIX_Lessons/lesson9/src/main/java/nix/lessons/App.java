package nix.lessons;

public class App 
{
    public static void main( String[] args )
    {
        Stackable stack = new MyStack<Integer>(3);

        System.out.println(stack.isEmpty());
        if(stack.getElement() != null)
            System.out.println(stack.getElement());
        stack.add(25);
        stack.add(-25);
        stack.add(100);
        System.out.println(stack.showTop());

        System.out.println(stack.add(5));
    }
}
