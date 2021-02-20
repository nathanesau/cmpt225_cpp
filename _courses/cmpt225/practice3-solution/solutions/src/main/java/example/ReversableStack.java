package example;

import java.util.ArrayList;
import java.util.List;

public class ReversableStack<T> implements Stack<T> {

    class Node {

        T data;

        Node next = null;

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

    public void reverse() throws Exception { // O(N)

        Node bottom = null;
        while (!isEmpty()) {

            Node node = new Node(pop());
            if (bottom == null) {
                bottom = node;
            }
            else {
                node.next = bottom;
                bottom = node;
            }
        }

        top = bottom;
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
