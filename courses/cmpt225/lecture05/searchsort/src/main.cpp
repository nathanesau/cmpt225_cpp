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

void testSearchSorted()
{
    std::vector<int> intArray = getRandomIntArray(10);
    MergeSort<int>::mergeSort(intArray);

    std::cout << "sorted array:" << std::endl;
    for(int i = 0; i < 10; i++) {
        std::cout << intArray[i] << " ";
    }
    std::cout << std::endl;

    size_t index = SearchSorted<int>::findElement(intArray, intArray[2]);
    std::cout << "found element at index: " << index << std::endl;
}

void testSearchUnsorted()
{
    std::vector<int> intArray = getRandomIntArray(10);

    std::cout << "unsorted array:" << std::endl;
    for(int i = 0; i < 10; i++) {
        std::cout << intArray[i] << " ";
    }
    std::cout << std::endl;

    size_t index = SearchUnsorted<int>::findElement(intArray, intArray[2]);
    std::cout << "found element at index: " << index << std::endl;
}

int main()
{
    testMergeSort();
    testSearchSorted();
    testSearchUnsorted();

    return 0;
}