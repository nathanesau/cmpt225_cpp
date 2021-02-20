package example;

import java.util.ArrayList;
import java.util.List;

public class ComparableStack<T> implements Stack<T> {
    
    class Node {

        T data;

        Node next = null;

        Node prev = null;

        Node(T data) {
            this.data = data;
        }
    }

    Node top;

    @Override
    public void push(T data) throws Exception {
        Node node = new Node(data);
        if (top == null) {
            top = node;
        }
        else {
            node.next = top;
            top = node;
        }
    }

    @Override
    public T pop() throws Exception {
        if (top == null) {
            throw new Exception("Attempt to pop empty stack");
        }

        T data = top.data;
        top = top.next;

        return data;
    }

    @Override
    public T peek() throws Exception {
        if (top == null) {
            throw new Exception("Attempt to peek empty stack");
        }

        return top.data;
    }

    @Override
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        
        if (o == this) {
            return true;
        }

        if (!(o instanceof ComparableStack)) {
            return false;
        }

        ComparableStack<T> c = (ComparableStack<T>) o;

        Node node1 = this.top;
        Node node2 = c.top;

        while (node1 != null && node2 != null) {
            if (node1.data != node2.data) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return true;
    }
    
    @Override
    public String toString() {
        List<T> list = new ArrayList<T>();

        Node node = top;
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }

        return list.toString();
    }

}
