class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None


class QueueLinkedList:
    """
    linked list implementation of queue
    - similar to doubly linked list
    """

    def __init__(self):
        self.front = None
        self.back = None

    def push(self, data):
        """
        push element to back of queue, O(1)
        """
        if not self.back:
            self.back = Node(data)
            self.front = self.back
        else:
            node = Node(data)
            self.back.next = node
            node.prev = self.back
            self.back = node

    def pop(self):
        """
        pop element from front of queue, O(1)
        """
        if not self.front:
            raise Exception("Cannot pop from empty queue")
        data = self.front.data
        self.front = self.front.next
        if not self.front:
            self.back = None
        else:
            self.front.prev = None
        return data

    def __str__(self):
        """
        string representation of queue
        """
        s = ""
        node = self.front
        while node is not None:
            s += str(node.data) + " "
            node = node.next
        return s


class QueueArrayList:
    """
    array list implementation of queue
    """

    def __init__(self):
        self.arr = []

    def push(self, data):
        self.arr.append(data)

    def pop(self):
        return self.arr.pop(0)

    def __str__(self):
        return str(self.arr)

    
if __name__ == "__main__":

    queue = QueueLinkedList()
    queue.push(5)
    queue.push(3)
    queue.push(7)
    print(str(queue)) # 5, 3, 7
    queue.pop()
    print(str(queue)) # 3, 7
    queue.pop()
    queue.pop()

    queue = QueueArrayList()
    queue.push(5)
    queue.push(3)
    queue.push(7)
    print(str(queue)) # 5, 3, 7
    queue.pop()
    print(str(queue)) # 3, 7
    queue.pop()
    queue.pop()