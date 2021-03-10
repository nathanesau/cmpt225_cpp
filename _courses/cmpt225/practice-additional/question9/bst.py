class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None


def print_tree(root, data="data", left="left", right="right"):
    # https://stackoverflow.com/questions/34012886/print-binary-tree-level-by-level-in-python
    def disp(root, data="data", left="left", right="right"):
        if getattr(root, right) is None and getattr(root, left) is None:
            li = '%s' % getattr(root, data)
            width = len(li)
            height = 1
            middle = width // 2
            return [li], width, height, middle
        if getattr(root, right) is None:
            lis, n, p, x = disp(getattr(root, left))
            s = '%s' % getattr(root, data)
            u = len(s)
            first_li = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_li = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lis = [li + u * ' ' for li in lis]
            return [first_li, second_li] + shifted_lis, n + u, p + 2, n + u // 2
        if getattr(root, left) is None:
            lis, n, p, x = disp(getattr(root, right))
            s = '%s' % getattr(root, data)
            u = len(s)
            first_li = s + x * '_' + (n - x) * ' '
            second_li = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lis = [u * ' ' + li for li in lis]
            return [first_li, second_li] + shifted_lis, n + u, p + 2, u // 2
        left, n, p, x = disp(getattr(root, left))
        right, m, q, y = disp(getattr(root, right))
        s = '%s' % getattr(root, data)
        u = len(s)
        first_li = (x + 1) * ' ' + (n - x - 1) * \
            '_' + s + y * '_' + (m - y) * ' '
        second_li = x * ' ' + '/' + \
            (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lis = zip(left, right)
        lis = [first_li, second_li] + [a + u * ' ' + b for a, b in zipped_lis]
        return lis, n + m + u, max(p, q) + 2, n + u // 2
    lis, *_ = disp(root, data, left, right)
    for li in lis:
        print(li)


def print_sorted(root):
    if root is None:
        return
    print_sorted(root.left)
    print(root.data)
    print_sorted(root.right)


def add_item(root, data):
    """
    write a function that adds a given element to a binary search tree
    - assume root is not None
    """
    if root is None:
        raise Exception("root shouldn't be None")

    if data < root.data:
        if root.left is None:
            root.left = Node(data, parent=root)
            return
        add_item(root.left, data)
    else:
        if root.right is None:
            root.right = Node(data, parent=root)
            return
        add_item(root.right, data)


def remove_item(root, data):
    """
    write a function that removes a given element from a BST

    - case 1: what if we remove an element that is not in the tree?
    - case 2: what if we remove an element that has no children?
    - case 3: what if we remove an element that has one child?
    - case 4: what if we remove an element that has two children?

    return True if item was removed, False otherwise
    """
    def _find(root, data):
        if root is None: return None
        if root.data == data: return root
        elif root.data > data: return _find(root.left, data)
        else: return _find(root.right, data)

    def _find_min(root):
        current = root
        while current.left is not None: current = current.left
        return current

    item = _find(root, data)
    if item is None:
        # case 1: what if we remove an element that is not in the tree
        return False
    if item.left is None and item.right is None:
        # case 2: what if we remove an element that has no children
        if item.parent.left == item: item.parent.left = None
        elif item.parent.right == item: item.parent.right = None
        return True
    if item.left is None or item.right is None:
        # case 3: what if we remove an element that has one child
        if item.left is not None:
            if item.parent.left == item: item.parent.left = item.left
            elif item.parent.right == item: item.parent.right = item.left
        elif item.right is not None:
            if item.parent.left == item: item.parent.left = item.right
            elif item.parent.right == item: item.parent.right = item.right
        return True
    # case 4: what if we remove an element that has two children (use min-value in right child as successor)
    successor = _find_min(item.right)
    if successor.parent.left == successor: successor.parent.left = None
    elif successor.parent.right == successor: successor.parent.right = None
    item.data = successor.data
    return True


if __name__ == "__main__":

    root = Node(10)
    root.left = Node(5, parent=root)
    root.left.left = Node(1, parent=root.left)
    root.left.right = Node(7, parent=root.left)
    root.right = Node(21, parent=root)
    root.right.left = Node(16, parent=root.right)
    root.right.right = Node(25, parent=root.right)
    #add_item(root, 6)

    print("\nprint_sorted")
    print_sorted(root)

    print("\nprint tree")
    print_tree(root)

    remove_item(root, 21)

    print("\nprint tree")
    print_tree(root)