/**
 * Stack Interface - ADT
 * @param <E> tipo de elementos
 */
public interface IStack<E> {
    void push(E element);
    E pop();
    E peek();
    boolean isEmpty();
    int size();
    void clear();
}
