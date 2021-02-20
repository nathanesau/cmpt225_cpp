package example;

public class QueueTwoStack<T> implements Queue<T> {

    Stack<T> stack1 = new StackImpl<T>();

    Stack<T> stack2 = new StackImpl<T>();

    @Override
    public void enqueue(T data) throws Exception { // O(N)

        // we need to add the new element at the bottom of stack1
        // first copy reversed stack1 to stack2 (empty stack1)
        // then insert new element into stack1
        // then add back elements to stack1

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    @Override
    public T dequeue() throws Exception { // O(1)
        if (stack1.isEmpty()) {
            throw new Exception("Attempt to dequeue empty queue");
        }
        
        return stack1.pop();
    }

    @Override
    public T peek() throws Exception {
        if (stack1.isEmpty()) {
            throw new Exception("Attempt to peek empty queue");
        }

        return stack1.peek();
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

}
