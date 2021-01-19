#pragma once

#include <vector>

template <class Type>
class SearchSorted
{
public:
    static size_t findElement(const std::vector<Type> &a, Type element)
    {
        size_t left = 0;
        size_t right = a.size() - 1;
        size_t mid = (left + right) / 2;

        while (a[mid] != element && left < right)
        {
            if (a[mid] > element)
            {
                right = mid - 1;
            }
            else // a[mid] < element
            {
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        if (a[mid] == element)
        {
            return mid;
        }

        return -1;
    }
};
