package example;

import java.util.ArrayList;
import java.util.List;

public class CloneableStack<T> implements Stack<T> {
    
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

    @Override
    public CloneableStack<T> clone() {
        
        CloneableStack<T> reversedStack = new CloneableStack<T>();
        CloneableStack<T> clonedStack = new CloneableStack<T>();

        try {
            Node node = top;
            while (node != null) {
                reversedStack.push(node.data);
                node = node.next;
            }

            while (!reversedStack.isEmpty()) {
                clonedStack.push(reversedStack.pop());
            }
        }
        catch (Exception e) {
            System.err.println("clone queue failed");
        }

        return clonedStack;
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
