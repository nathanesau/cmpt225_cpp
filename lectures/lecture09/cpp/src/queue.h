#pragma once

#include <string>
#include <vector>

// forward declarations
template <class Type>
struct Node;

/**
 * @brief linked list implementation of queue
 * - similar to doubly linked list
 * 
 * @tparam Type data type for queue.
 */
template <class Type>
class QueueLinkedList
{
    Node<Type> *front;

    Node<Type> *back;

public:
    QueueLinkedList();

    ~QueueLinkedList();

    /**
     * @brief push element to back of queue, O(1).
     * 
     * @param data the element to add.
     */
    void push(Type data);

    /**
     * @brief pop element from front of queue, O(1).
     * 
     * @return Type the element at front of queue.
     */
    Type pop();

    /**
     * @brief string representation of queue
     * 
     * @return std::string queue as a string.
     */
    std::string to_string() const;
};

/**
 * @brief array list implementation of queue
 * 
 * @tparam Type data type for queue.
 */
template <class Type>
class QueueArrayList
{
    std::vector<Type> arr;

public:
    QueueArrayList() = default;

    ~QueueArrayList() = default;

    void push(Type data);

    Type pop();

    std::string to_string() const;
};
