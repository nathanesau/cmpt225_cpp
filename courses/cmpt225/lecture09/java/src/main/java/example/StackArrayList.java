package example;

import java.util.ArrayList;
import java.util.List;

public class StackArrayList<T> {
    
    List<T> arr = new ArrayList<T>();

    StackArrayList() {

    }

    void push(T data) {
        arr.add(0, data);
    }

    T pop() {
        return arr.remove(0);
    }

    @Override
    public String toString() {
        return arr.toString();
    }

}
