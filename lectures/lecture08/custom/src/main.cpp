// very simple linkedlist implementation
#include <iostream>

template <class Type>
struct Node
{
    Type data;
    Node *next = nullptr;

    Node(Type data) : data(data)
    {
    }
};

int main()
{
    // inserting nodes to tail
    auto head = new Node<int>(3);
    head->next = new Node<int>(5);
    head->next->next = new Node<int>(7);

    // remove node from tail
    delete head->next->next;
    head->next->next = nullptr;

    // remove node from head
    auto node = head->next;
    delete head;
    head = node;

    // printing list
    node = head;
    while (node)
    {
        std::cout << node->data << " ";
        node = node->next;
    }
    std::cout << std::endl;
}