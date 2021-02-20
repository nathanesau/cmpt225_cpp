package example;

import java.util.ArrayList;
import java.util.List;

public class ComparableQueue<T> implements Queue<T> {
    
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

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        
        if (o == this) {
            return true;
        }

        if (!(o instanceof ComparableQueue)) {
            return false;
        }

        ComparableQueue<T> c = (ComparableQueue<T>) o;

        Node node1 = this.front;
        Node node2 = c.front;

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
        Node curr = front;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }

        return list.toString();
    }

}
