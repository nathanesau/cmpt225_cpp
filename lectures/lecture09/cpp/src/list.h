#pragma once

#include <string>

// forward declarations
template <class Type>
struct Node;

/**
 * @brief singly linked list (generic)
 * 
 * @tparam Type data type for linked list.
 */
template <class Type>
class SinglyLinkedList
{
    Node<Type> *head;

public:
    SinglyLinkedList();

    ~SinglyLinkedList();

    /**
     * @brief add element to front of list, O(1).
     * 
     * @param data the element to add to the list.
     */
    void push_front(Type data);

    /**
     * @brief pop element from front of list, O(1).
     * 
     * @return Type the element at the front of the list.
     */
    Type pop_front();

    /**
     * @brief add element to back of list, O(N).
     * 
     * @param data the element to add to the list.
     */
    void push_back(Type data);

    /**
     * @brief pop element from back of list, O(N).
     * 
     * @return Type the element at the back of the list.
     */
    Type pop_back();

    /**
     * @brief string representation of list
     * 
     * @return std::string list as a string.
     */
    std::string to_string() const;
};

/**
 * @brief doubled linked list (generic)
 * 
 * @tparam Type data type for linked list.
 */
template <class Type>
class DoublyLinkedList
{
    Node<Type> *head;

    Node<Type> *tail;

public:
    DoublyLinkedList();

    ~DoublyLinkedList();

    /**
     * @brief add element to front of list, O(1).
     * 
     * @param data the element to add to the list.
     */
    void push_front(Type data);

    /**
     * @brief pop element from front of list, O(1).
     * 
     * @return Type the element at the front of the list.
     */
    Type pop_front();

    /**
     * @brief add element to back of list, O(1).
     * 
     * @param data the element to add to the list.
     */
    void push_back(Type data);

    /**
     * @brief pop element from back of list, O(1).
     * 
     * @return Type the element at the back of the list.
     */
    Type pop_back();

    /**
     * @brief string representation of list
     * 
     * @return std::string list as a string.
     */
    std::string to_string() const;
};