package example;

import java.util.List;
import java.util.ArrayList;

public class StackImpl<T> implements Stack<T> {
    
    List<T> arr = new ArrayList<T>();

    public StackImpl() {

    }

    @Override
    public void push(T data) {
        arr.add(0, data);
    }

    @Override
    public T pop() { 
        if (!arr.isEmpty()) {
            return arr.remove(0);
        }

        return null;
    }

    @Override
    public T peek() {
        if (!arr.isEmpty()) {
            return arr.get(0);
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        return arr.toString();
    }

}
