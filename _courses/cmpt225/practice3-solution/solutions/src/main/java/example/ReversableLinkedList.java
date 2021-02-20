package example;

import java.util.ArrayList;
import java.util.List;

/**
 * implement the class LinkedList that represents a singly linked list with
 * pointer to tail such that the class also supports the reverse operator.
 * 
 * NOTE: the only way to ensure all operations run in O(1) time is to have a
 * pointer to the head as well.
 */
public class ReversableLinkedList<T> {
    
    class Node {

        T data;

        Node prev = null;

        Node next = null;

        Node(T data) {
            this.data = data;
        }
    }

    enum Direction {
        FORWARD,
        BACKWARD
    };

    Node head;

    Node tail;

    Direction direction;

    public ReversableLinkedList() {
        this.head = null;
        this.tail = null;
        this.direction = Direction.FORWARD;
    }

    public void addToFront(T data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        if (direction == Direction.FORWARD) {
            head.prev = node;
            node.next = head;
            head = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void addToTail(T data) {
        Node node = new Node(data);

        if (tail == null) {
            tail = node;
            head = node;
            return;
        }

        if (direction == Direction.FORWARD) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public T removeFromFront() throws Exception {
        if (head == null) {
            throw new Exception("Attempt to removeFromFront empty list");
        }

        if (direction == Direction.FORWARD) {
            T data = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }
            else {
                head.prev = null;
            }

            return data;
        }
        else {
            T data = tail.data;
            tail = tail.prev;

            if (tail == null) {
                head = null;
            }
            else {
                tail.next = null;
            }

            return data;
        }
    }

    public void reverse() {
        direction = (direction == Direction.FORWARD) ? Direction.BACKWARD : Direction.FORWARD;
    }

    @Override
    public String toString() {
        List<T> list = new ArrayList<T>();
        
        if (direction == Direction.FORWARD) {
            Node node = head;
            while (node != null) {
                list.add(node.data);
                node = node.next;
            }
        }
        else {
            Node node = tail;
            while (node != null) {
                list.add(node.data);
                node = node.prev;
            }
        }

        return list.toString();
    }

}
