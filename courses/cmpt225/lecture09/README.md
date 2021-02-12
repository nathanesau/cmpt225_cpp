# Lecture09 code samples

We discussed following:

* linked list (singly linked list, doubly linked list)
* queue (array implementation, linked list implementation)
* stacks (array implementation, linked list implementation)

Note: Stack is LIFO, Queue is FIFO.

## Interface

Functions to be implemented for the data structures:

### Linked List

* Singly linked list: Contains only reference to head of list.
* Doubly linked list: Contains references to head of list and tail of list.

| Data Structure | Method | Description |
| -------------- | ------ | ----------- |
| Singly Linked List | push_front | Add element to front of list, O(1) |
| Singly Linked List | pop_front | Pop element from front of list, O(1) |
| Singly Linked List | push_back | Add element to back of list, O(N) |
| Singly Linked List | pop_back | Pop element from back of list, O(N) |
| Doubly Linked List | push_front | Add element to front of list, O(1) |
| Doubly Linked List | pop_front | Pop element from front of list, O(1) |
| Doubly Linked List | push_back | Add element to back of list, O(1) |
| Doubly Linked List | pop_back | Pop element from back of list, O(1) |

### Stack

* Stack: contains only reference to top of stack.

| Data Structure | Method | Description |
| ----- | ---- | --------------------------------- |
| Stack | push | Add element to top of stack, O(1) |
| Stack | pop | Pop element from top of stack, O(1) |

## Queue

* Queue: contains reference to front of list and back of list.

| Data Structure | Method | Description |
| -------------- | ------ | ----------- | 
| Queue | push | Push element to back of queue, O(1) |
| Queue | pop | Pop element from front of queue, O(1) |

## C++

```cpp/src/main.cpp`` output:

```bash
queue1 before pop: 5 10 
queue1 after pop: 10
queue2 before pop: 5 10
queue2 after pop: 10
list1 before pop_front: 10 5
list1 after pop_front: 5
list2 before pop_front: 10 5
list2 after pop_front: 5
stack1 before pop: 10 5
stack1 after pop: 5
stack2 before pop: 10 5
stack2 after pop: 5
```

## Java

sample output:

```bash
7 3 5 
3 5
5 3 7
5 3
7 3 5
3 5
5 3 7
5 3
5 3 7
3 7
[5, 3, 7]
[3, 7]
7 3 5 
3 5
[7, 3, 5]
[3, 5]
```

## Python

``python/list.py`` output:

```bash
7 3 5 
3 5 
5 3 7
5 3
7 3 5
3 5
5 3 7
5 3
```

``python/queue.py`` output:

```bash
5 3 7 
3 7 
[5, 3, 7]
[3, 7]
```

``python/stack.py`` output:

```bash
7 3 5 
3 5 
[7, 3, 5]
[3, 5]
```
