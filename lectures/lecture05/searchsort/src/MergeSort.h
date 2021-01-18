#pragma once

#include <vector>

template <class Type>
class MergeSort
{
public:
    static void mergeSort(std::vector<Type> &a)
    {
        mergeSort(a, 0, (int) a.size() - 1);
    }

private:
    static void mergeSort(std::vector<Type> &a, int start, int end)
    {
        if (end > start)
        {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);
            mergeSort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    static void merge(std::vector<Type> &a, int start, int mid, int end)
    {
        std::vector<Type> tmp;

        // merge a[start..mid] and a[mid+1..end] into tmp
        int step1 = start;
        int step2 = mid + 1;
        while (step1 <= mid || step2 <= end)
        {
            if (step1 > mid)
            {
                tmp.push_back(a[step2++]);
            }
            else if (step2 > end)
            {
                tmp.push_back(a[step1++]);
            }
            else if (a[step1] < a[step2])
            {
                tmp.push_back(a[step1++]);
            }
            else if (a[step1] >= a[step2])
            {
                tmp.push_back(a[step2++]);
            }
        }

        for (int i = start; i <= end; i++)
        {
            a[i] = tmp[i - start];
        }
    }
};