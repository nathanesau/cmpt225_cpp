class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None  # only used for DoublyLinkedList


class SinglyLinkedList:
    """
    singly linked list (generic)
    """

    def __init__(self):
        self.head = None

    def push_front(self, data):
        """
        add element to front of list, O(1)
        """
        if not self.head:
            self.head = Node(data)
        else:
            node = Node(data)
            node.next = self.head
            self.head = node

    def pop_front(self):
        """
        pop element from front of list, O(1)
        """
        if not self.head:
            raise Exception("Cannot pop from empty list")
        data = self.head.data
        self.head = self.head.next
        return data

    def push_back(self, data):
        """
        add element to back of list, O(N)
        """
        if not self.head:
            self.head = Node(data)
        else:
            node = self.head
            while node.next is not None:
                node = node.next
            node.next = Node(data)

    def pop_back(self):
        """
        pop element from back of list, O(N)
        """
        if not self.head:
            raise Exception("Cannot pop from empty list")
        elif not self.head.next:
            data = self.head.data
            self.head = None
            return data
        else:
            node = self.head
            while node.next.next is not None:
                node = node.next
            data = node.next.data
            node.next = None
            return data

    def __str__(self):
        """
        string representation of list
        """
        s = ""
        node = self.head
        while node is not None:
            s += str(node.data) + " "
            node = node.next
        return s


class DoublyLinkedList:
    """
    doubly linked list (generic)
    """

    def __init__(self):
        self.head = None
        self.tail = None

    def push_front(self, data):
        """
        add element to front of list, O(1)
        """
        if not self.head:
            self.head = Node(data)
            self.tail = self.head
        else:
            node = Node(data)
            node.next = self.head
            self.head.prev = node
            self.head = node

    def pop_front(self):
        """
        pop element from front of list, O(1)
        """
        if not self.head:
            raise Exception("Cannot pop from empty list")
        data = self.head.data
        self.head = self.head.next
        if not self.head:
            self.tail = None
        else:
            self.head.prev = None
        return data

    def push_back(self, data):
        """
        add element to back of list, O(1)
        """
        if not self.tail:
            self.tail = Node(data)
            self.head = self.tail
        else:
            node = Node(data)
            self.tail.next = node
            node.prev = self.tail
            self.tail = node

    def pop_back(self):
        """
        pop element from back of list, O(1)
        """
        if not self.tail:
            raise Exception("Cannot pop from empty list")
        data = self.tail.data
        self.tail = self.tail.prev
        if not self.tail:
            self.head = None
        else:
            self.tail.next = None
        return data

    def __str__(self):
        """
        string representation of list
        """
        s = ""
        node = self.head
        while node is not None:
            s += str(node.data) + " "
            node = node.next
        return s


if __name__ == "__main__":

    linked_list = SinglyLinkedList()
    linked_list.push_front(5)
    linked_list.push_front(3)
    linked_list.push_front(7)
    print(str(linked_list))  # 7, 3, 5
    linked_list.pop_front()
    print(str(linked_list))  # 3, 5

    linked_list = SinglyLinkedList()
    linked_list.push_back(5)
    linked_list.push_back(3)
    linked_list.push_back(7)
    print(str(linked_list))  # 5, 3, 7
    linked_list.pop_back()
    print(str(linked_list))  # 5, 3

    linked_list = DoublyLinkedList()
    linked_list.push_front(5)
    linked_list.push_front(3)
    linked_list.push_front(7)
    print(str(linked_list))  # 7, 3, 5
    linked_list.pop_front()
    print(str(linked_list))  # 3, 5
    linked_list.pop_front()
    linked_list.pop_front()

    linked_list = DoublyLinkedList()
    linked_list.push_back(5)
    linked_list.push_back(3)
    linked_list.push_back(7)
    print(str(linked_list))  # 5, 3, 7
    linked_list.pop_back()
    print(str(linked_list))  # 5, 3
    linked_list.pop_back()
    linked_list.pop_back()
