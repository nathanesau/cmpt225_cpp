"""
BuildHeap in O(n) time

Goal:
Given an array, turn it into a heap in O(n) time. Sorting won't work since that is O(n*log(n))

Algorithm:
1. Treat the array as a complete binary tree
2. For each vertex v starting from the bottom
    2.1 Apply heapify (v)

Example:
[9,4,2,1,7,8,5,3,10,6]

for n/2 vertices heapify runs for 1 steps
for n/4 vertices heapify runs for 2 steps
for n/8 vertices heaify runs for 3 steps
for n/16 vertices heapify runs for 4 steps
...
for 2 vertices heapify runs for log(n)-1 steps
for 1 vertices heapify runs for log(n) steps

running time 
 = 1*(n/2) + 2*(n/4) + 3*(n/8) + ... + log(n)*(n/n)
 = n * (1/2 + 2/4 + 3/8 + ...)
<= n * (1 + 1/2 + 1/4 + ...)
"""

# TODO implement