package example;

public interface Stack<T> {

    void push(T data) throws Exception;
    
    T pop() throws Exception;

    T peek() throws Exception;

    boolean isEmpty();

}
