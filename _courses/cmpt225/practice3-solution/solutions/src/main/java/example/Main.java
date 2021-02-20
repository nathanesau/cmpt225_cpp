package example;

// compile with javac Main.java
// run with java Main
public class Main {
    
    static void testComparableStack() throws Exception {
        ComparableStack<Integer> comparableStack1 = new ComparableStack<Integer>();
        ComparableStack<Integer> comparableStack2 = new ComparableStack<Integer>();

        // 4, 3, 2, 1
        comparableStack1.push(1);
        comparableStack1.push(2);
        comparableStack1.push(3);
        comparableStack1.push(4);
        System.out.println(comparableStack1);

        // 4, 3, 2, 1
        comparableStack2.push(1);
        comparableStack2.push(2);
        comparableStack2.push(3);
        comparableStack2.push(4);
        System.out.println(comparableStack2);

        System.out.println(comparableStack1.equals(comparableStack2));

        System.out.println("");
    }

    static void testComparableQueue() throws Exception {
        ComparableQueue<Integer> comparableQueue1 = new ComparableQueue<Integer>();
        ComparableQueue<Integer> comparableQueue2 = new ComparableQueue<Integer>();

        // 1, 2, 3, 4
        comparableQueue1.enqueue(1);
        comparableQueue1.enqueue(2);
        comparableQueue1.enqueue(3);
        comparableQueue1.enqueue(4);
        System.out.println(comparableQueue1);

        // 1, 2, 3, 4
        comparableQueue2.enqueue(1);
        comparableQueue2.enqueue(2);
        comparableQueue2.enqueue(3);
        comparableQueue2.enqueue(4);
        System.out.println(comparableQueue2);

        System.out.println(comparableQueue1.equals(comparableQueue2));

        System.out.println("");
    }

    static void testCloneableStack() throws Exception {
        CloneableStack<Integer> cloneableStack = new CloneableStack<Integer>();

        // 4, 3, 2, 1
        cloneableStack.push(1);
        cloneableStack.push(2);
        cloneableStack.push(3);
        cloneableStack.push(4);
        System.out.println(cloneableStack);

        System.out.println(cloneableStack.clone());
        System.out.println(cloneableStack);

        System.out.println("");
    }

    static void testCloneableQueue() throws Exception {
        CloneableQueue<Integer> cloneableQueue = new CloneableQueue<Integer>();

        // 1, 2, 3, 4
        cloneableQueue.enqueue(1);
        cloneableQueue.enqueue(2);
        cloneableQueue.enqueue(3);
        cloneableQueue.enqueue(4);
        System.out.println(cloneableQueue);

        System.out.println(cloneableQueue.clone());
        System.out.println(cloneableQueue);

        System.out.println("");
    }

    static void testReversableQueue() throws Exception {
        ReversableQueue<Integer> reversableQueue = new ReversableQueue<Integer>();

        // 1, 2, 3, 4
        reversableQueue.enqueue(1);
        reversableQueue.enqueue(2);
        reversableQueue.enqueue(3);
        reversableQueue.enqueue(4);
        System.out.println(reversableQueue);

        // 4, 3, 2, 1
        reversableQueue.reverse();
        System.out.println(reversableQueue);

        System.out.println("");
    }

    static void testReversableStack() throws Exception {
        ReversableStack<Integer> reversableStack = new ReversableStack<Integer>();

        // 1, 2, 3, 4
        reversableStack.push(1);
        reversableStack.push(2);
        reversableStack.push(3);
        reversableStack.push(4);
        System.out.println(reversableStack);

        // 4, 3, 2, 1
        reversableStack.reverse();
        System.out.println(reversableStack);

        System.out.println("");
    }

    static void testQueueTwoStack() throws Exception {
        QueueTwoStack<Integer> queueTwoStack = new QueueTwoStack<Integer>();

        // 1, 2, 3, 4
        queueTwoStack.enqueue(1);
        queueTwoStack.enqueue(2);
        queueTwoStack.enqueue(3);
        queueTwoStack.enqueue(4);
        System.out.println(queueTwoStack);

        // 2, 3, 4
        queueTwoStack.dequeue();
        System.out.println(queueTwoStack);

        System.out.println("");
    }

    static void testReversableLinkedList() throws Exception {
        ReversableLinkedList<Integer> reversableList = new ReversableLinkedList<Integer>();
        
        // 5, 1, 2, 3, 4
        reversableList.addToTail(1);
        reversableList.addToTail(2);
        reversableList.addToTail(3);
        reversableList.addToTail(4);
        reversableList.addToFront(5);
        reversableList.addToFront(6);
        reversableList.removeFromFront();
        System.out.println(reversableList);

        // 4, 3, 2, 1, 5, 7
        reversableList.reverse();
        reversableList.addToFront(6);
        reversableList.addToTail(7);
        reversableList.removeFromFront();
        System.out.println(reversableList);

        System.out.println("");
    }

    static void testBoundedMemoryQueue() throws Exception {
        BoundedMemoryQueue<String> boundedQueue = new BoundedMemoryQueue<String>(3);

        // "a", "b", "c"
        boundedQueue.enqueue("a");
        boundedQueue.enqueue("b");
        boundedQueue.enqueue("c");
        System.out.println(boundedQueue);
        
        // "b", "c", "d"
        boundedQueue.enqueue("d");
        System.out.println(boundedQueue);
        
        System.out.println("");
    }

    public static void main(String[] args) throws Exception {

        testComparableStack();
        testComparableQueue();
        testCloneableStack();
        testCloneableQueue();
        testReversableQueue();
        testReversableStack();
        testQueueTwoStack();
        testReversableLinkedList();
        testBoundedMemoryQueue();
    }
}