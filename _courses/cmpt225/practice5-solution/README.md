# practice5-solution

1. start with the array A = [7,1,4,2,9,3,4,10,5,8]

a. apply buildHeap(A) [question1/part_a.png](question1/part_a.PNG)
b. add 6 to the heap[question1/part_b.png](question1/part_b.PNG)
c. remove min from heap [question1/part_c.png](question1/part_c.PNG)
d. remove min from the heap again [question1/part_d.png](question1/part_d.PNG)

2. apply buildHeap on the array [n, n-1, n-2, n-3, ..., 2, 1]. no discernible pattern.

3. apply buildHeap on the array [1, 2, 3, 4, ..., n-1, n]. [1,2,3,...]

4. modify min-heap of ints so that it also supports getAverage in O(1) time

5. modify min-heap of ints so that it also supports getMax in O(1) time

6. write a data structure that supports the following operations:

a. addElement(int elt) - in O(log(n)) time
b. getMin()/ getMax() - in O(1) time
c. removeMin()/ removeMax() - in O(log(n)) time
d. getSize()/ isEmpty() - in O(1) time

7. suppose the in-order traversal of a min-heap is [4,3,5,2,9,1,5,4,7]. can we recover the min-heap uniquely?

8. suppose the pre-order traversal of a min-heap is [1,2,3,4,5]. can we recover the min-heap uniquely?

9. if in buildheap we iterate from top down, will we get a heap in the end?