#include "MyLinkedList.h"

#include <iostream>

int main()
{
    MyLinkedList<int> list;
    list.addToTail(5);
    list.addToTail(7);
    list.addToHead(3);
    list.removeFromHead();
    list.removeFromTail();

    // now list should only have a 5
    std::cout << list.to_string() << std::endl;

    return 0;
}