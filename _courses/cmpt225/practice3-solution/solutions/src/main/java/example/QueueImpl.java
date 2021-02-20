package example;

import java.util.List;
import java.util.ArrayList;

public class QueueImpl<T> implements Queue<T> {

    List<T> arr = new ArrayList<T>();

    public QueueImpl() {

    }

    @Override
    public void enqueue(T data) {
        arr.add(data);
    }

    @Override
    public T dequeue() {
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
