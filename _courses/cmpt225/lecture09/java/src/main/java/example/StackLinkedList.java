package example;

public class StackLinkedList<T> {
 
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

    Node top;

    StackLinkedList() {
        this.top = null;
    }

    /**
     * push element to top of stack, O(1).
     * @param data the element to add.
     */
    void push(T data) {
        if (top == null) {
            top = new Node(data);
        }
        else {
            Node node = new Node(data);
            node.prev = top;
            top = node;
        }
    }

    /**
     * pop element from top of stack, O(1).
     * @return T the element at top of stack.
     */
    T pop() throws Exception {
        if (top == null) {
            throw new Exception("Cannot pop from empty stack");
        }

        T data = top.data;
        top = top.prev;
        return data;
    }

    @Override
    public String toString() {
        String s = "";
        Node node = top;
        while (node != null) {
            s += node.data + " ";
            node = node.prev;
        }
        return s;
    }

}
