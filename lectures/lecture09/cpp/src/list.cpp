#include "list.h"
#include "node.h"

#include <exception>
#include <string>

template <class Type>
SinglyLinkedList<Type>::SinglyLinkedList() : head(nullptr)
{
}

template <class Type>
SinglyLinkedList<Type>::~SinglyLinkedList()
{
    Node<Type> *node = head;
    while (node) {
        Node<Type> *next = node->next;
        delete node;
        node = next;
    }
}

template <class Type>
void SinglyLinkedList<Type>::push_front(Type data)
{
    if (!head)
    {
        head = new Node<Type>(data);
    }
    else
    {
        Node<Type> *node = new Node<Type>(data);
        node->next = head;
        head = node;
    }
}

template <class Type>
Type SinglyLinkedList<Type>::pop_front()
{
    if (!head)
    {
        throw std::exception("Cannot pop from empty list");
    }

    Type data = head->data;
    Node<Type> *next = head->next;
    delete head;
    head = next;

    return data;
}

template <class Type>
void SinglyLinkedList<Type>::push_back(Type data)
{
    if (!head)
    {
        head = new Node<Type>(data);
    }
    else
    {
        Node<Type> *node = head;
        while (node->next) {
            node = node->next;
        }
        node->next = new Node<Type>(data);
    }
}

template <class Type>
Type SinglyLinkedList<Type>::pop_back()
{
    if (!head)
    {
        throw std::exception("Cannot pop from empty list");
    }
    else if (!head->next)
    {
        Type data = head->data;
        delete head;
        head = nullptr;
        return data;
    }
    else
    {
        Node<Type> *node = head;
        while (node->next->next)
        {
            node = node->next;
        }
        Type data = node->next->data;
        delete node->next;
        node->next = nullptr;
        return data;
    }
}

std::string SinglyLinkedList<int>::to_string() const
{
    std::string s;

    Node<int> *node = head;

    while (node)
    {
        s += std::to_string(node->data) + " ";
        node = node->next;
    }

    return s;
}

std::string SinglyLinkedList<std::string>::to_string() const
{
    std::string s;

    Node<std::string> *node = head;

    while (node)
    {
        s += node->data + " ";
        node = node->next;
    }

    return s;
}

template <class Type>
DoublyLinkedList<Type>::DoublyLinkedList() : head(nullptr)
{
}

template <class Type>
DoublyLinkedList<Type>::~DoublyLinkedList()
{
    Node<Type> *node = head;
    while (node) {
        Node<Type> *next = node->next;
        delete node;
        node = next;
    }
}

template <class Type>
void DoublyLinkedList<Type>::push_front(Type data)
{
    if (!head)
    {
        head = new Node<Type>(data);
        tail = head;
    }
    else
    {
        Node<Type> *node = new Node<Type>(data);
        node->next = head;
        head->prev = node;
        head = node;
    }
}

template <class Type>
Type DoublyLinkedList<Type>::pop_front()
{
    if (!head)
    {
        throw std::exception("Cannot pop from empty list");
    }

    Type data = head->data;
    Node<Type> *next = head->next;
    delete head;
    head = next;

    if (!head)
    {
        tail = nullptr;
    }
    else
    {
        head->prev = nullptr;
    }

    return data;
}

template <class Type>
void DoublyLinkedList<Type>::push_back(Type data)
{
    if (!tail)
    {
        tail = new Node<Type>(data);
        head = tail;
    }
    else
    {
        Node<Type> *node = new Node<Type>(data);
        tail->next = node;
        node->prev = tail;
        tail = node;
    }
}

template <class Type>
Type DoublyLinkedList<Type>::pop_back()
{
    if (!tail)
    {
        throw std::exception("Cannot pop from empty list");
    }

    Type data = tail->data;
    Node<Type> *prev = tail->prev;
    delete tail;
    tail = tail->prev;

    if (!tail)
    {
        head = nullptr;
    }
    else
    {
        tail->next = nullptr;
    }

    return data; 
}

std::string DoublyLinkedList<int>::to_string() const
{
    std::string s;

    Node<int> *node = head;

    while (node)
    {
        s += std::to_string(node->data) + " ";
        node = node->next;
    }

    return s;
}

std::string DoublyLinkedList<std::string>::to_string() const
{
    std::string s;

    Node<std::string> *node = head;

    while (node)
    {
        s += node->data + " ";
        node = node->next;
    }

    return s;
}

template class SinglyLinkedList<int>;
template class SinglyLinkedList<std::string>;

template class DoublyLinkedList<int>;
template class DoublyLinkedList<std::string>;
