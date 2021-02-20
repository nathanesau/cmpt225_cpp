package example;

public interface Queue<T> {
    
    void enqueue(T data) throws Exception;

    T dequeue() throws Exception;

    T peek() throws Exception;

    boolean isEmpty();

}
