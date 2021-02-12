#include "stack.h"
#include "node.h"

#include <exception>
#include <string>

template <class Type>
StackLinkedList<Type>::StackLinkedList() : top(nullptr)
{
}

template <class Type>
StackLinkedList<Type>::~StackLinkedList()
{
    Node<Type> *node = top;
    while (node)
    {
        Node<Type> *next = node->next;
        delete node;
        node = next;
    }
}

template <class Type>
void StackLinkedList<Type>::push(Type data)
{
    if (!top)
    {
        top = new Node<Type>(data);
    }
    else
    {
        Node<Type> *node = new Node<Type>(data);
        node->prev = top;
        top = node;
    }   
}

template <class Type>
Type StackLinkedList<Type>::pop()
{
    if (!top)
    {
        // "Cannot pop from empty stack"
        throw std::exception();
    }

    Type data = top->data;
    Node<Type> *prev = top->prev;
    delete top;
    top = prev;

    return data;
}

template <>
std::string StackLinkedList<int>::to_string() const
{
    std::string s;

    Node<int> *node = top;

    while (node)
    {
        s += std::to_string(node->data) + " ";
        node = node->prev;
    }

    return s;
}

template <>
std::string StackLinkedList<std::string>::to_string() const
{
    std::string s;

    Node<std::string> * node = top;

    while (node)
    {
        s += node->data + " ";
        node = node->prev;
    }

    return s;
}

template <class Type>
void StackArrayList<Type>::push(Type data)
{
    arr.insert(arr.begin(), data);
}

template <class Type>
Type StackArrayList<Type>::pop()
{
    if (arr.empty())
    {
        // "Cannot pop from empty stack"
        throw std::exception();
    }

    Type data = arr[0];

    arr.erase(arr.begin());

    return data;
}

template <>
std::string StackArrayList<int>::to_string() const
{
    std::string s;

    for (auto it : arr)
    {
        s += std::to_string(it) + " ";
    }

    return s;
}

template <>
std::string StackArrayList<std::string>::to_string() const
{
    std::string s;

    for (auto it : arr)
    {
        s += it + " ";
    }

    return s;
}

template class StackLinkedList<int>;
template class StackLinkedList<std::string>;

template class StackArrayList<int>;
template class StackArrayList<std::string>;