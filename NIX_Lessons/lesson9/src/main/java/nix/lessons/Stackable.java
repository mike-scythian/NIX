package nix.lessons;

public interface Stackable <T>{

    boolean isEmpty();
    boolean isFull();
    boolean add(T element) ;
    T getElement();
    T showTop();
}
