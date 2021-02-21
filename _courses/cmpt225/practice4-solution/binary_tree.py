class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self, root):
        self.root = root


def in_order(tree):
    """
    return array containing in-order traveral for binary tree
    - left, root, right
    (category: depth first traversal)
    """
    arr = []

    def _visit(node):
        arr.append(node.data)

    def _in_order(node):
        if node is None:
            return
        _in_order(node.left)
        _visit(node)
        _in_order(node.right)

    _in_order(tree.root)

    return arr


def pre_order(tree):
    """
    return array containing pre-order traversal for binary tree
    - root, left, right
    (category: depth first traversal)
    """
    arr = []

    def _visit(node):
        arr.append(node.data)

    def _pre_order(node):
        if node is None:
            return
        _visit(node)
        _pre_order(node.left)
        _pre_order(node.right)

    _pre_order(tree.root)

    return arr


def pre_order_iterative(tree):
    """
    (same as ``in_order`` but iterative)
    return array containing pre-order traversal for binary tree
    - root, left, right
    (category: depth first traversal)
    """
    arr = []

    def _visit(node):
        arr.append(node.data)

    s = [tree.root]
    while s:
        node = s.pop(0)
        _visit(node)
        if node.right is not None:
            s.insert(0, node.right)
        if node.left is not None:
            s.insert(0, node.left)

    return arr


def post_order(tree):
    """
    return array containing post-order traversal for binary tree
    - left, right, root
    (category: depth first traversal)
    """
    arr = []

    def _visit(node):
        arr.append(node.data)

    def _post_order(node):
        if node is None:
            return
        _post_order(node.left)
        _post_order(node.right)
        _visit(node)

    _post_order(tree.root)

    return arr


def level_order(tree):
    """
    return array containing level-order traversal for binary tree
    (category: breadth first traversal)
    """
    arr = []

    def _visit(node):
        arr.append(node.data)

    q = [tree.root]
    while q:
        node = q.pop(0)
        _visit(node)
        if node.left is not None:
            q.append(node.left)
        if node.right is not None:
            q.append(node.right)

    return arr


def build_tree1():
    """
    from lecture slides (lecture 15, slide 3)
    """
    root = Node(2)
    root.left = Node(7)
    root.right = Node(5)
    root.left.left = Node(2)
    root.left.right = Node(6)
    root.right.right = Node(9)
    root.left.right.left = Node(5)
    root.left.right.right = Node(11)
    root.right.right.left = Node(4)
    tree = BinaryTree(root)
    return tree


def build_tree2():
    """
    from https://www.cdn.geeksforgeeks.org/wp-content/uploads/Preorder-from-Inorder-and-Postorder-traversals.jpg
    """
    root = Node(25)
    root.left = Node(15, parent=root)
    root.right = Node(50, parent=root)
    root.left.left = Node(10, parent=root.left)
    root.left.right = Node(22, parent=root.left)
    root.left.left.left = Node(4, parent=root.left.left)
    root.left.left.right = Node(12, parent=root.left.left)
    root.left.right.left = Node(18, parent=root.left.right)
    root.left.right.right = Node(24, parent=root.left.right)
    root.right.left = Node(35, parent=root.right)
    root.right.right = Node(70, parent=root.right)
    root.right.left.left = Node(31, parent=root.right.left)
    root.right.left.right = Node(44, parent=root.right.left)
    root.right.right.left = Node(66, parent=root.right.right)
    root.right.right.right = Node(90, parent=root.right.right)
    tree2 = BinaryTree(root)
    return tree2


def build_tree3():
    """
    from https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder
    - in_order = [4, 2, 5, 1, 3]
    - pre_order = [1, 2, 4, 5, 3]
    - post_order = [4, 5, 2, 3, 1]
    - level_order = [1, 2, 3, 4, 5]
    """
    root = Node(1)
    root.left = Node(2, parent=root)
    root.right = Node(3, parent=root)
    root.left.left = Node(4, parent=root.left)
    root.left.right = Node(5, parent=root.left)
    tree = BinaryTree(root)
    return tree


if __name__ == "__main__":

    # test tree3
    tree3 = build_tree3()
    print(in_order(tree3))
    print(pre_order(tree3))
    print(post_order(tree3))
    print(level_order(tree3))
    assert pre_order_iterative(tree3) == pre_order(tree3)
