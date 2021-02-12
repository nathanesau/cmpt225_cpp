package example;

/**
 * singly linked list (generic)
 */
public class SinglyLinkedList<T> {
    
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

    SinglyLinkedList() {
        head = null;
    }

    /**
     * add element to front of list O(1).
     * @param data the element to add to the list.
     */
    void push_front(T data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node node = new Node(data);
            node.next = head;
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
        return data;
    }

    /**
     * add element to back of list, O(N).
     * 
     * @param data the element to add to the list.
     */
    void push_back(T data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(data);
        }
    }

    /**
     * pop element from back of list, O(N).
     * 
     * @return Type the element at the back of the list.
     */
    T pop_back() throws Exception {
        if (head == null) {
            throw new Exception("Cannot pop from empty list");
        }
        else if (head.next == null) {
            T data = head.data;
            head = null;
            return data;
        }
        else {
            Node node = head;
            while (node.next.next != null) {
                node = node.next;
            }
            T data = node.next.data;
            node.next = null;
            return data;
        }
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
