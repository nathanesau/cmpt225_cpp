package example;

import java.util.ArrayList;
import java.util.List;

public class QueueArrayList<T> {
    
    List<T> arr = new ArrayList<T>();

    QueueArrayList() {

    }

    void push(T data) {
        arr.add(data);
    }

    T pop() {
        return arr.remove(0);
    }

    @Override
    public String toString() {
        return arr.toString();
    }

}
