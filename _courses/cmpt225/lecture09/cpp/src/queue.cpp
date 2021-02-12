#include "queue.h"
#include "node.h"

#include <exception>
#include <string>

template <class Type>
QueueLinkedList<Type>::QueueLinkedList() : front(nullptr), back(nullptr)
{
}

template <class Type>
QueueLinkedList<Type>::~QueueLinkedList()
{
    Node<Type> *node = front;
    while (node)
    {
        Node<Type> *next = node->next;
        delete node;
        node = next;
    }
}

template <class Type>
void QueueLinkedList<Type>::push(Type data)
{
    if (!back)
    {
        back = new Node<Type>(data);
        front = back;
    }
    else
    {
        Node<Type> *node = new Node<Type>(data);
        back->next = node;
        node->prev = back;
        back = node;
    }
}

template <class Type>
Type QueueLinkedList<Type>::pop()
{
    if (!front)
    {
        // "Cannot pop from empty queue"
        throw std::exception();
    }

    Type data = front->data;
    Node<Type> *next = front->next;
    delete front;
    front = next;

    if (!front)
    {
        back = nullptr;
    }
    else
    {
        front->prev = nullptr;
    }

    return data;
}

template <>
std::string QueueLinkedList<int>::to_string() const
{
    std::string s;

    Node<int> *node = front;

    while (node)
    {
        s += std::to_string(node->data) + " ";
        node = node->next;
    }

    return s;
}

template <>
std::string QueueLinkedList<std::string>::to_string() const
{
    std::string s;

    Node<std::string> *node = front;

    while (node)
    {
        s += node->data + " ";
        node = node->next;
    }

    return s;
}

template <class Type>
void QueueArrayList<Type>::push(Type data)
{
    arr.push_back(data);
}

template <class Type>
Type QueueArrayList<Type>::pop()
{
    if (arr.empty())
    {
        // "Cannot pop from empty queue"
        throw std::exception();
    }

    Type data = arr[0];

    arr.erase(arr.begin());

    return data;
}

template <>
std::string QueueArrayList<int>::to_string() const
{
    std::string s;

    for (auto it : arr)
    {
        s += std::to_string(it) + " ";
    }

    return s;
}

template <>
std::string QueueArrayList<std::string>::to_string() const
{
    std::string s;

    for (auto it : arr)
    {
        s += it + " ";
    }

    return s;
}

template class QueueLinkedList<int>;
template class QueueLinkedList<std::string>;

template class QueueArrayList<int>;
template class QueueArrayList<std::string>;