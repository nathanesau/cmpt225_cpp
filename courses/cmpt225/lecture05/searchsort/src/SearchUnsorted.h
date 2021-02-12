#pragma once

template <class Type>
class SearchUnsorted
{
public:
    static size_t findElement(const std::vector<Type> &a, Type element)
    {
        for (size_t i = 0; i < a.size(); i++) {
            if (a[i] == element) {
                return i;
            }
        }
        return -1;
    }
};