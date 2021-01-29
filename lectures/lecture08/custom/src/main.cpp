// very simple linkedlist implementation
#include <iostream>
#include <memory>

template <class Type>
struct Node1
{
    Type data;
    Node1 *next = nullptr;

    Node1(Type data, Node1* next = nullptr) : data(data), next(next)
    {
    }
};

template <class Type>
struct Node2
{
    Type data;
    std::unique_ptr<Node2> next; 

    Node2(Type data, Node2 *next = nullptr) : data(data), next(next)
    {
    }
};

void test_node2() {
    // inserting nodes to head
    auto head = new Node2<int>(3, nullptr);

    auto next = new Node2<int>(5, std::move(head));
    head = next;
}

void test_node1() {
    // inserting nodes to tail
    auto head = new Node1<int>(3);
    head->next = new Node1<int>(5);
    head->next->next = new Node1<int>(7);

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

int main()
{
    test_node1();
    test_node2();
}