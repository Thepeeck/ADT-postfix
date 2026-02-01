import java.util.ArrayList;

/**
 * Implementacion de Stack usando ArrayList
 * @param <E> tipo de elementos
 */
public class VectorStack<E> implements IStack<E> {
    
    private ArrayList<E> elements;
    
    public VectorStack() {
        elements = new ArrayList<>();
    }
    
    @Override
    public void push(E element) {
        elements.add(element);
    }
    
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacio");
        }
        return elements.remove(elements.size() - 1);
    }
    
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack vacio");
        }
        return elements.get(elements.size() - 1);
    }
    
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    @Override
    public int size() {
        return elements.size();
    }
    
    @Override
    public void clear() {
        elements.clear();
    }
}
