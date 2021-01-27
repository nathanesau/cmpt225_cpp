// i am not really a fan of this implementation
// i think much simpler implementations are possible
#pragma once

#include <exception>
#include <string>

template <class Type>
struct MyLinkedListNode
{
    Type data;
    MyLinkedListNode *next = nullptr;

    MyLinkedListNode(Type data) : data(data)
    {
    }
};

/**
 * @brief A linked list implementation.
 * 
 * @tparam Type ex. int, float, etc.
 * 
 * Other possible methods (not implemented):
 *  - Type get(int index)
 *  - Type set(int index, Type element)
 *  - int length()
 *  - bool isEmpty()
 *  - bool contains(Type element)
 *  - void removeAllOccurences(Type element)
 */
template <class Type>
class MyLinkedList
{
    MyLinkedListNode<Type> *head = nullptr;
    int length = 0;

public:
    MyLinkedList()
    {
    }

    ~MyLinkedList()
    {
        while (head)
        {
            removeFromHead();
        }
    }

    /**
     * @brief Returns the string representation of the list.
     * 
     * @return std::string The string representation of the list.
     */
    std::string to_string() const
    {
        std::string s = "";

        MyLinkedListNode<Type> *node = head;

        while (node)
        {
            s += std::to_string(node->data) + " ";
            node = node->next;
        }

        return s;
    }

    /**
     * @brief Adds a new element to the head of the list.
     * 
     * @param element The data associated with the new element.
     */
    void addToHead(Type element)
    {
        MyLinkedListNode<Type> *newNode = new MyLinkedListNode<Type>(element);
        newNode->next = head;
        head = newNode;
        length++;
    }

    /**
     * @brief Adds a new element to the tail of the list.
     * 
     * @param element The data associated with the new element.
     */
    void addToTail(Type element)
    {
        MyLinkedListNode<Type> *newNode = new MyLinkedListNode<Type>(element);

        if (!head)
        {
            head = newNode;
            length++;
        }
        else
        {
            MyLinkedListNode<Type> *node = head;

            while (node->next)
            {
                node = node->next;
            }

            node->next = newNode;
            length++;
        }
    }

    /**
     * @brief Removes the first element of list.
     * 
     * @return The data associated with the removed element.
     */
    Type removeFromHead()
    {
        if (!head)
        {
            throw std::exception("My linked list is empty");
        }

        Type ret = head->data;

        MyLinkedListNode<Type> *nextNode = head->next;
        delete head;
        head = nextNode;
        length--;

        return ret;
    }

    /**
     * @brief Remove the last element of list.
     * 
     * @return The data associated with the removed element.
     */
    Type removeFromTail()
    {
        if (!head)
        {
            throw std::exception("My linked list is empty");
        }

        if (!head->next)
        {
            Type ret = head->data;

            delete head;
            head = nullptr;
            length--;

            return ret;
        }

        MyLinkedListNode<Type> *prev_node = nullptr;
        MyLinkedListNode<Type> *node = head;

        while (node->next)
        {
            prev_node = node;
            node = node->next;
        }

        Type ret = node->data;

        delete node;
        prev_node->next = nullptr;
        length--;

        return ret;
    }
};