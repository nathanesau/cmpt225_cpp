# practice3-solution - Stacks and Queues

assume queue has following methods: ``enqueue``, ``dequeue``, ``peek``, ``isEmpty``

assume stack has following methods: ``push``, ``pop``, ``peek``, ``isEmpty``

1. write the equals() method for a stack class. [ComparableStack.java](solutions/src/main/java/example/ComparableStack.java)

* the method gets a stack and check if they have the same elements in the same order.
* in the end both stacks must be in the same state as in the beginning.

2. write the equals() method for a queue class. [ComparableQueue.java](solutions/src/main/java/example/ComparableQueue.java)

* the method gets a queue and checks if they have the same elements in the same order.
* in the end both queues must be in the same state as in the beginning.

3. write a method clone() for a stack class. [CloneableStack.java](solutions/src/main/java/example/CloneableStack.java)

* the method creates a copy with the same elements in the same order.
* in the end the stack must be in the same state as the beginning.
* you may use only the stack api and not assume any implementation details.

4. write a method clone() for a queue class. [CloneableQueue.java](solutions/src/main/java/example/CloneableQueue.java)

* the method creates a copy with the same elements in the same order.
* in the end the queue must be in the same state as the beginning.
* you may only use the queue api but not assume any implementation details.

5. write a method reverse() for a queue class. [ReversableQueue.java](solutions/src/main/java/example/ReversableQueue.java)

* the method gets a queue and reverses the order of the elements in the queue.

6. write a method reverse() for a stack class. [ReversableStack.java](solutions/src/main/java/example/ReversableStack.java)

* the method gets a stack and reverses the order of the elements in the stack.

7. implement the class Queue using two stack. [QueueTwoStack.java](solutions/src/main/java/example/QueueTwoStack.java)

* other than the two stack, O(1) additional memory.

8. implement the class LinkedList that represents a singly linked list with pointer to tail such that the class also supports the reverse operator. [ReversableLinkedList.java](solutions/src/main/java/example/ReversableLinkedList.java)

* specifically you need to implement the following operations:
    * addToFront
    * addToTail
    * removeFromFront
    * reverse

* all operations, including reverse(), must run in O(1) time.

9. implement the class BoundedMemoryQueue. [BoundedMemoryQueue.java](solutions/src/main/java/example/BoundedMemoryQueue.java)

* the constructor gets a parameter ``size`` as an argument and the queue remembers only the last ``size`` elements added to the queue.
* more specifically, the behavior of the class is the same as Queue with one exception in the enqueue(element) method.
    * if the queue contains less than ``size`` elements, then the new elements is added to the tail of the queue.
    * otherwise, the queue removes the element from the head of the queue and adds the new element to the tail.