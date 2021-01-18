#include <iostream>
#include <random>
#include <vector>
#include "MergeSort.h"
#include "SearchSorted.h"
#include "SearchUnsorted.h"

std::vector<int> getRandomIntArray(int size)
{
    std::vector<int> randArray(size);

    for(int i = 0; i < size; i++) {
        randArray[i] = std::rand() % 1000;
    }

    return randArray;
}

void testMergeSort()
{
    std::vector<int> intArray = getRandomIntArray(10);

    std::cout << "unsorted array:" << std::endl;
    for(int i = 0; i < 10; i++) {
        std::cout << intArray[i] << " ";
    }
    std::cout << std::endl;

    MergeSort<int>::mergeSort(intArray);

    std::cout << "sorted array:" << std::endl;
    for(int i = 0; i < 10; i++) {
        std::cout << intArray[i] << " ";
    }
    std::cout << std::endl;
}

int main()
{
    testMergeSort();

    return 0;
}