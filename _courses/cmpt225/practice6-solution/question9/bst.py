class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def print_sorted(root):
    if root is None:
        return
    print_sorted(root.left)
    print(root.data)
    print_sorted(root.right)


def add_item(root, data):
    """
    write a function that adds a given element to a binary search tree
    """
    # TODO
    pass


def remove_item(root, data):
    """
    write a function that removes a given element from a BAST

    - what if we want to remove an element that is not in the tree?
    - what if we remove an element that has no children?
    - what if we remove an element that has two children? 
    """
    # TODO
    pass


if __name__ == "__main__":

    root = Node(10)
    root.left = Node(5)
    root.left.left = Node(1)
    root.left.right = Node(7)
    root.right = Node(21)
    root.right.left = Node(16)
    root.right.right = Node(25)

    print("\nprint_sorted")
    print_sorted(root)
