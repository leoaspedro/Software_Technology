package FIFO;

public class GenericNode<T> {
    T val;
    GenericNode<T> next;

    public GenericNode(T element){
        this.val = element;
    }
}