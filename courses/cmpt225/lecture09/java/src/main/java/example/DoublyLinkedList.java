package example;

/**
 * doubled linked list (generic)
 */
public class DoublyLinkedList<T> {
    
    class Node {
        T data;
        Node next;
        Node prev;
        
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    Node tail;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * add element to front of list, O(1)
     * 
     * @param data the element to add to the list.
     */
    void push_front(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        }
        else {
            Node node = new Node(data);
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    /**
     * pop element from front of list, O(1).
     * 
     * @return Type the element at the front of the list.
     */
    T pop_front() throws Exception {
        if (head == null) {
            throw new Exception("Cannot pop from empty list");
        }

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

    /**
     * add element to back of list, O(1).
     * 
     * @param data the element to add to the list.
     */
    void push_back(T data) {
        if (tail == null) {
            tail = new Node(data);
            head = tail;
        }
        else {
            Node node = new Node(data);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    /**
     * pop element from back of list, O(1)
     * 
     * @return Type the element at the back of the list.
     */
    T pop_back() throws Exception {
        if (tail == null) {
            throw new Exception("Cannot pop from empty list");
        }

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

    @Override
    public String toString() {
        String s = "";
        Node node = head;
        while (node != null) {
            s += node.data + " ";
            node = node.next;
        }
        return s;
    }

}
