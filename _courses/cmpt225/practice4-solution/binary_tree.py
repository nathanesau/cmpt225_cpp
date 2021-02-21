class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self, root):
        self.root = root

    def __str__(self):
        """
        algorithm:
        - get row for each node [1, 2, 2, 3, 3]
        - get col for each node [3, 2, 4, 1, 3]
        - get adj_row for each node [1, 3, 3, 5, 5]
        - get adj_col for each node [5, 3, 7, 1, 5]
        - fill max(adj_row) * max(adj_col) grid

        requires one vertical and one level order traversal for the tree
        """
        def _get_rows():
            rows = {}
            # level_order traversal
            q = [(self.root, 1)]
            while q:
                node, depth = q.pop(0)
                rows[node] = depth
                if node.left is not None:
                    q.append((node.left, depth+1))
                if node.right is not None:
                    q.append((node.right, depth+1))
            return rows

        def _get_cols():
            cols = {}

            def _find_min_max(node, hd, min_hd, max_hd):
                if node is None: return
                min_hd[0] = min(min_hd[0], hd)
                max_hd[0] = max(max_hd[0], hd)
                _find_min_max(node.left, hd-1, min_hd, max_hd)
                _find_min_max(node.right, hd+1, min_hd, max_hd)

            def _get_line(node, line_no, hd):
                if node is None: return
                if hd == line_no: cols[node] = line_no
                _get_line(node.left, line_no, hd-1)
                _get_line(node.right, line_no, hd+1)
    
            min_hd, max_hd = [0], [0]
            _find_min_max(self.root, 0, min_hd, max_hd)
            for line_no in range(min_hd[0], max_hd[0]+1):
                _get_line(self.root, line_no, 0)

            return cols
        
        def _pad(data, width):
            diff = width - 2 - len(data)
            return '[' + diff//2 * ' ' + data + (diff - diff//2) * ' ' + ']'

        rows = _get_rows()
        cols = _get_cols()
        col_offset = abs(min(cols.values())) + 1
        for k in cols.keys(): cols[k] = cols[k] + col_offset
        width = len(max([str(x.data) for x in rows.keys()], key=len)) + 2
        for k in rows.keys(): rows[k] = rows[k] + (rows[k] - 1)
        for k in cols.keys(): cols[k] = cols[k] + (cols[k] - 1) * width
        arr = [['.' for _ in range(max(cols.values()) + width - 1)] for _ in range(max(rows.values()))]

        for k, rv in rows.items():
            cv = cols[k]
            arr[rv-1][(cv-1):(cv+width-1)] = _pad(str(k.data), width)
            if k.parent is not None:
                prv = rows[k.parent]
                pcv = cols[k.parent]
                if pcv > cv: arr[prv][pcv-2] = '/'
                else: arr[prv][pcv-2+width+1] = '\\'

        return '\n'.join([''.join(row) for row in arr])


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


def vertical_order(tree):
    """
    return array containing vertical-order traversal for binary tree
    """
    arr = []

    def _find_min_max(node, hd, min_hd, max_hd):
        if node is None:
            return
        
        min_hd[0] = min(min_hd[0], hd)
        max_hd[0] = max(max_hd[0], hd)

        _find_min_max(node.left, hd-1, min_hd, max_hd)
        _find_min_max(node.right, hd+1, min_hd, max_hd)

    def _get_line(node, line_no, hd, line):
        if node is None:
            return

        if hd == line_no:
            line.append(node.data)

        _get_line(node.left, line_no, hd-1, line)
        _get_line(node.right, line_no, hd+1, line)
    
    min_hd, max_hd = [0], [0]
    _find_min_max(tree.root, 0, min_hd, max_hd)

    for line_no in range(min_hd[0], max_hd[0]+1):

        line = []
        _get_line(tree.root, line_no, 0, line)

        arr += line
    
    return arr


def max_depth(root):
    """
    return the max depth of the root
    - here depth of root is 1
    """
    if root is None:
        return 0
    ldepth = max_depth(root.left)
    rdepth = max_depth(root.right)
    return max(ldepth + 1, rdepth + 1)


def tree_summary(tree):
    print("__str__")
    print(f"{tree}\n")
    print("in_order")
    print(f"{in_order(tree)}\n")
    print("pre_order")
    print(f"{pre_order(tree)}\n")
    print("post_order")
    print(f"{post_order(tree)}\n")
    print("level_order")
    print(f"{level_order(tree)}\n")
    print("vertical_order")
    print(f"{vertical_order(tree)}\n")
    print("max_depth")
    print(f"{max_depth(tree.root)}\n")


def build_tree1():
    """
    from lecture slides (lecture 15, slide 3)
    """
    root = Node(2)
    root.left = Node(7, parent=root)
    root.right = Node(5, parent=root)
    root.left.left = Node(2, parent=root.left)
    root.left.right = Node(6, parent=root.left)
    root.right.right = Node(9, parent=root.right)
    root.left.right.left = Node(5, parent=root.left.right)
    root.left.right.right = Node(11, parent=root.left.right)
    root.right.right.left = Node(4, parent=root.right.right)
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
    """
    root = Node(1)
    root.left = Node(2, parent=root)
    root.right = Node(3, parent=root)
    root.left.left = Node(4, parent=root.left)
    root.left.right = Node(5, parent=root.left)
    tree = BinaryTree(root)
    return tree


def build_tree4():
    """
    from https://www.geeksforgeeks.org/print-binary-tree-vertical-order
    """
    root = Node(1)
    root.left = Node(2, parent=root)
    root.right = Node(3, parent=root)
    root.left.left = Node(4, parent=root.left)
    root.right.left = Node(5, parent=root.right)
    root.right.left = Node(6, parent=root.right)
    root.right.right = Node(7, parent=root.right)
    root.right.left.right = Node(8, parent=root.right.left)
    root.right.right.right = Node(9, parent=root.right.right)
    tree = BinaryTree(root)
    return tree


def build_tree5():
    """
    use common names from https://www.ssa.gov/oact/babynames
    """
    root = Node("Liam")
    root.left = Node("Benjamin", parent=root)
    root.left.left = Node("Mason", parent=root.left)
    root.left.right = Node("William", parent=root.left)
    root.right = Node("Olivia", parent=root)
    root.right.left = Node("Charlotte", parent=root.right)
    root.right.right = Node("Ava", parent=root.right)
    tree = BinaryTree(root)
    return tree


def test_tree(tree):
    tree_summary(tree)
    assert pre_order_iterative(tree) == pre_order(tree)


if __name__ == "__main__":

    test_tree(build_tree1())
    test_tree(build_tree2())
    test_tree(build_tree3())
    test_tree(build_tree4())
    test_tree(build_tree5())
