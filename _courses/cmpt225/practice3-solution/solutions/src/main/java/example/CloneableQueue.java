package example;

import java.util.ArrayList;
import java.util.List;

public class CloneableQueue<T> implements Queue<T> {
    
    class Node {

        T data;

        Node next = null;

        Node prev = null;

        Node(T data) {
            this.data = data;
        }
    }

    Node front;

    Node back;

    @Override
    public void enqueue(T data) throws Exception {
        Node node = new Node(data);
        if (front == null) {
            front = node;
            back = node;
        }
        else {
            node.prev = back;
            back.next = node;
            back = node;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (front == null) {
            throw new Exception("Attempt to dequeue empty queue");
        }

        T data = front.data;
        front = front.next;

        if (front == null) {
            back = null;
        }
        else {
            front.prev = null;
        }

        return data;
    }

    @Override
    public T peek() throws Exception {
        if (front == null) {
            return null;
        }

        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public CloneableQueue<T> clone() {
        
        CloneableQueue<T> clonedQueue = new CloneableQueue<T>();

        try {
            Node node = front;
            while (node != null) {
                clonedQueue.enqueue(node.data);
                node = node.next;
            }
        }
        catch (Exception e) {
            System.err.println("clone queue failed");
        }

        return clonedQueue;
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<T>();
        Node curr = front;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }

        return list.toString();
    }

}
