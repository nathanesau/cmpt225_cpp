package example;

import java.util.ArrayList;
import java.util.List;

/**
 * implement the class BoundedMemoryQueue
 * 
 * the constructor gets a parameter ``size`` as an argument and the queue only
 * remembers the last ``size`` elements added to the queue
 */
public class BoundedMemoryQueue<T> implements Queue<T> {
    
    class Node {

        T data;

        Node next = null;

        Node prev = null;

        Node(T data) {
            this.data = data;
        }
    }

    // size of queue
    final int size;

    // current size of queue
    int curr_size = 0;

    Node head = null;

    Node tail = null;

    public BoundedMemoryQueue(int size) {
        this.size = size;
    }

    @Override
    public void enqueue(T data) throws Exception {
        if (curr_size >= size) {
            // remove head of queue
            dequeue();
            enqueue(data);
        }
        else {
            Node node = new Node(data);
            if (head == null) {
                head = node;
                tail = node;
            }
            else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            curr_size += 1;
        }
    }

    @Override
    public T dequeue() throws Exception {
        if (head == null) {
            throw new Exception("Attempt to dequeue empty queue");
        }

        T data = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        else {
            head.prev = null;
        }

        curr_size -= 1;

        return data;
    }

    @Override
    public T peek() {
        if (head == null) {
            return null;
        }

        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<T>();
        Node curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }

        return list.toString();
    }

}
