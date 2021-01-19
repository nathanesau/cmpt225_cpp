#include <algorithm>
#include <iostream>
#include <vector>

#include "ComparableClass.h"

int main()
{
    std::vector<ComparableClass> clist = {
        ComparableClass(0, "ABC"),
        ComparableClass(1, "ABC"),
        ComparableClass(2, "ABC"),
        ComparableClass(1, "XYZ"),
        ComparableClass(2, "ABC")
    };

    std::cout << "unsorted list:" << std::endl;
    for(size_t i = 0; i < clist.size(); i++) {
        std::cout << clist[i].toString() << std::endl;
    }
    std::cout << std::endl;

    // another way to do this would be to pass comparator function to std::sort
    std::sort(clist.begin(), clist.end());

    std::cout << "sorted list:" << std::endl;
    for(size_t i = 0; i < clist.size(); i++) {
        std::cout << clist[i].toString() << std::endl;
    }
    std::cout << std::endl;

    return 0;
}