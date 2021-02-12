class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None


class StackLinkedList:
    """
    linked list implementation of stack
    - similar to singly linked list
    """

    def __init__(self):
        self.top = None

    def push(self, data):
        """
        add element to top of stack, O(1)
        """
        if not self.top:
            self.top = Node(data)
        else:
            node = Node(data)
            node.prev = self.top
            self.top = node
    
    def pop(self):
        """
        pop element from top of stack, O(1)
        """
        if not self.top:
            raise Exception("Cannot pop from empty stack")
        data = self.top.data
        self.top = self.top.prev
        return data

    def __str__(self):
        """
        string representation of stack
        """
        s = ""
        node = self.top
        while node is not None:
            s += str(node.data) + " "
            node = node.prev
        return s


class StackArrayList:
    """
    array list implementation of stack
    """

    def __init__(self):
        self.arr = []

    def push(self, data):
        self.arr.insert(0, data)

    def pop(self):
        return self.arr.pop(0)

    def __str__(self):
        return str(self.arr)


if __name__ == "__main__":

    stack = StackLinkedList()
    stack.push(5)
    stack.push(3)
    stack.push(7)
    print(str(stack))  # 7, 3, 5
    stack.pop()
    print(str(stack))  # 3, 5

    stack = StackArrayList()
    stack.push(5)
    stack.push(3)
    stack.push(7)
    print(str(stack))  # 7, 3, 5
    stack.pop()
    print(str(stack))  # 3, 5
