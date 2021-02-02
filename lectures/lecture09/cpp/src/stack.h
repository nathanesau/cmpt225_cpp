#pragma once

#include <string>
#include <vector>

// forward declarations
#include <vector>

template <class Type>
struct Node;

template <class Type>
class StackLinkedList
{
    Node<Type> *top;

public:
    StackLinkedList();

    ~StackLinkedList();

    /**
     * @brief push element to top of stack, O(1).
     * 
     * @param data the element to add.
     */
    void push(Type data);

    /**
     * @brief pop element from top of stack, O(1).
     * 
     * @return Type the element at top of stack.
     */
    Type pop();

    /**
     * @brief string representation of stack
     * 
     * @return std::string stack as a string.
     */
    std::string to_string() const;
};

/**
 * @brief array list implementation of stack
 * 
 * @tparam Type data type for stack.
 */
template <class Type>
class StackArrayList
{
    std::vector<Type> arr;

public:
    StackArrayList() = default;

    ~StackArrayList() = default;

    void push(Type data);

    Type pop();

    std::string to_string() const;
};
