#include "Bicycle.h"

#include <iostream>
#include <vector>

int main()
{
    Bicycle b(20, 20, "blue");
    for (int i = 0; i < 10; i++) {
        b = Bicycle(20, 20, "blue");
    }

    std::cout << "created bicycles: " << b.getNumberOfCreatedBicycles() << std::endl;

    std::vector<Bicycle> blist;
    for (int i = 0; i < 10; i++) {
        blist.push_back(Bicycle(20, 20, "blue"));
    }

    std::cout << "created bicycles: " << b.getNumberOfCreatedBicycles() << std::endl;

    return 0;
}