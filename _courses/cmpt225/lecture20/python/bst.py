class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def print_sorted(root):
    """
    write a function that prisn the values in a BST in non-decreasing order
    """
    if root is None:
        return
    print_sorted(root.left)
    print(root.data)
    print_sorted(root.right)


def find(root, data):
    """
    write a function that finds a given item in a BST (or returns None)

    * running time: O(depth of the tree)
    * therefore, we want the depth of the tree to be as small as possible
        - i.e., a balanced BST with depth O(log(n))
    """
    if root is None:
        return None

    if root.data == data:
        return root
    elif root.data > data:
        return find(root.left, data)
    else: # root.data < data:
        return find(root.right, data)


def find_iterative(root, data):
    """
    write an iterative function that finds a given item in a BST (or returns None)
    """
    node = root
    while node is not None and node.data != data:
        if node.data > data:
            node = node.left
        else:
            node = node.right
    return node


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

    print("\nfind")
    node = find(root, 7)
    print(node.data)

    print("\nfind_iterative")
    node = find_iterative(root, 7)
    print(node.data)

    print("\nadd_item")
    node = 