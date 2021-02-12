package example;

public class QueueLinkedList<T> {
    
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

    Node front;

    Node back;

    QueueLinkedList() {
        this.front = null;
        this.back = null;
    }

    /**
     * push element to back of queue, O(1).
     * @param data the element to add.
     */
    void push(T data) {
        if (back == null) {
            back = new Node(data);
            front = back;
        }
        else {
            Node node = new Node(data);
            back.next = node;
            node.prev = back;
            back = node;
        }
    }

    /**
     * pop element from front of queue, O(1).
     * @return T the element at front of queue.
     */
    T pop() throws Exception {
        if (front == null) {
            throw new Exception("Cannot pop from empty queu");
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
    public String toString() {
        String s = "";
        Node node = front;
        while (node != null) {
            s += node.data + " ";
            node = node.next;
        }
        return s;
    }

}
