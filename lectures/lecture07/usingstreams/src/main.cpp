#include <iostream>
#include <vector>
#include <ranges>

std::vector<int> createVector()
{
    // table of powers of two
    std::vector<int> vectorInts = {
        1, 2,
        2, 4,
        3, 8,
        4, 16,
        5, 32,
        6, 64,
        7, 128,
        8, 256,
        9, 512,
        10, 1024};

    return vectorInts;
}

bool isPow2(int n)
{ 
    if (n == 1)
    {
        return true;
    }

    if (n % 2 == 1)
    {
        return false;
    }

    return isPow2(n / 2);
}

int main()
{
    std::vector<int> v = createVector();

    std::cout << "Print using raw loop: " << std::endl;
    for (size_t i = 0; i < v.size(); i++) {
        std::cout << v[i] << std::endl;
    }

    std::cout << "Print using iterators: " << std::endl;
    for (auto it : v) {
        std::cout << it << std::endl;
    }

    std::cout << "Filter powers of two that are greater than 10: " << std::endl;
    for (auto it : v | std::views::filter([](int a) { return a > 10 && isPow2(a); })) {
        std::cout << it << std::endl;
    }

    return 0;
}