// java -jar target/example-1.0-SNAPSHOT.jar
package example;

public class App {

	public static void testSinglyLinkedList() throws Exception {
		SinglyLinkedList<Integer> linked_list = new SinglyLinkedList<Integer>();
    	linked_list.push_front(5);
    	linked_list.push_front(3);
    	linked_list.push_front(7);
		System.out.println(linked_list.toString()); // 7, 3, 5
    	linked_list.pop_front();
		System.out.println(linked_list.toString()); // 3, 5

		linked_list = new SinglyLinkedList<Integer>();
		linked_list.push_back(5);
		linked_list.push_back(3);
		linked_list.push_back(7);
		System.out.println(linked_list.toString()); // 5, 3, 7
		linked_list.pop_back();
		System.out.println(linked_list.toString()); // 5, 3
	}

	public static void testDoublyLinkedList() throws Exception {
		DoublyLinkedList<Integer> linked_list = new DoublyLinkedList<Integer>();
    	linked_list.push_front(5);
    	linked_list.push_front(3);
    	linked_list.push_front(7);
		System.out.println(linked_list.toString()); // 7, 3, 5
    	linked_list.pop_front();
		System.out.println(linked_list.toString()); // 3, 5

		linked_list = new DoublyLinkedList<Integer>();
		linked_list.push_back(5);
		linked_list.push_back(3);
		linked_list.push_back(7);
		System.out.println(linked_list.toString()); // 5, 3, 7
		linked_list.pop_back();
		System.out.println(linked_list.toString()); // 5, 3
	}

	public static void testQueueLinkedList() throws Exception {
		QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>();
		queue.push(5);
		queue.push(3);
		queue.push(7);
		System.out.println(queue.toString()); // 5, 3, 7
		queue.pop();
		System.out.println(queue.toString()); // 3, 7
		queue.pop();
		queue.pop();
	}

	public static void testQueueArrayList() throws Exception {
		QueueArrayList<Integer> queue = new QueueArrayList<Integer>();
		queue.push(5);
		queue.push(3);
		queue.push(7);
		System.out.println(queue.toString()); // 5, 3, 7
		queue.pop();
		System.out.println(queue.toString()); // 3, 7
		queue.pop();
		queue.pop();
	}

	public static void testStackLinkedList() throws Exception {
		StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(7);
		System.out.println(stack.toString()); // 7, 3, 5
		stack.pop();
		System.out.println(stack.toString()); // 3, 5
		stack.pop();
		stack.pop();
	}

	public static void testStackArrayList() throws Exception {
		StackArrayList<Integer> stack = new StackArrayList<Integer>();
		stack.push(5);
		stack.push(3);
		stack.push(7);
		System.out.println(stack.toString()); // 7, 3, 5
		stack.pop();
		System.out.println(stack.toString()); // 3, 5
		stack.pop();
		stack.pop();
	}

	public static void main(String[] args) throws Exception {
		
		testSinglyLinkedList();
		testDoublyLinkedList();
		testQueueLinkedList();
		testQueueArrayList();
		testStackLinkedList();
		testStackArrayList();
	}
}
