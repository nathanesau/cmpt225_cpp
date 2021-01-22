#include <iostream>

#include "Singleton.h"

int main()
{
    Singleton s1 = Singleton::getInstance();
    Singleton s2 = Singleton::getInstance();

    std::cout << "the objects are equal: " << std::endl;
    std::cout << "s1.val: " << s1.getVal() << std::endl;
    std::cout << "s2.val: " << s2.getVal() << std::endl;

    return 0;
}