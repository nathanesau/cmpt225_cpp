"""
for heap, the tree is always full
it is convenient to represent is using an array

store size of the tree
BFS traversal of the heap

[1,4,2,9,6,3,10,8,10,7]

A: array[0]             root of array
A: array[2i+1]          left child of array[i]
A: array[2i+2]          right child of array[i]
A: array[(j+1)/2-1]     parent of array[j]
"""
class Heap:
    def __init__(self, arr):
        self.arr = arr
        # index of last non-leaf node
        last = len(arr) // 2 - 1
        # heapify each node
        for i in range(last, -1, -1):
            self.heapify(i)
    
    def heapify(self, i):
        if i < len(self.arr):
            left = 2*i + 1
            right = 2*i + 2
            j = i
            if left < len(self.arr) and self.arr[left] < self.arr[j]:
                j = left
            if right < len(self.arr) and self.arr[right] < self.arr[j]:
                j = right
            if j != i:
                self.arr[i], self.arr[j] = self.arr[j], self.arr[i]
                self.heapify(j)
    
    def add(self, data):
        self.arr.append(data)
        # propagate up
        i = len(self.arr) - 1
        while i > 0 and self.arr[i] < self.arr[(i+1)//2-1]:
            self.arr[i], self.arr[(i+1)//2-1] = self.arr[(i+1)//2-1], self.arr[i]

    def remove_min(self):
        data = self.arr[0]
        self.arr[0] = self.arr[-1]
        del self.arr[-1]
        if self.arr:
            self.heapify(0)
        return data

    def get_min(self):
        return self.arr[0]

    def __str__(self):
        return str(self.arr)


if __name__ == "__main__":

    h1 = Heap([9,3,6,8,2,4,1])
    print(h1.get_min())
