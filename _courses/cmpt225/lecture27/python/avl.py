class Node:  # AVLNode
    def __init__(self, data, parent = None, height = 0, balance = 0):
        self.data = data
        self.parent = parent
        self.height = height
        self.balance = balance
        self.left = None
        self.right = None

def print_tree(root, data="data", left="left", right="right"):
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
        first_li = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_li = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lis = zip(left, right)
        lis = [first_li, second_li] + [a + u * ' ' + b for a, b in zipped_lis]
        return lis, n + m + u, max(p, q) + 2, n + u // 2
    lis, *_ = disp(root, data, left, right)
    for li in lis: print(li)

def print_tree_heights(root, height="height", left="left", right="right"):
    def disp(root, height="height", left="left", right="right"):
        if getattr(root, right) is None and getattr(root, left) is None:
            li = '%s' % getattr(root, height)
            width = len(li)
            height = 1
            middle = width // 2
            return [li], width, height, middle
        if getattr(root, right) is None:
            lis, n, p, x = disp(getattr(root, left))
            s = '%s' % getattr(root, height)
            u = len(s)
            first_li = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_li = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lis = [li + u * ' ' for li in lis]
            return [first_li, second_li] + shifted_lis, n + u, p + 2, n + u // 2
        if getattr(root, left) is None:
            lis, n, p, x = disp(getattr(root, right))
            s = '%s' % getattr(root, height)
            u = len(s)
            first_li = s + x * '_' + (n - x) * ' '
            second_li = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lis = [u * ' ' + li for li in lis]
            return [first_li, second_li] + shifted_lis, n + u, p + 2, u // 2
        left, n, p, x = disp(getattr(root, left))
        right, m, q, y = disp(getattr(root, right))
        s = '%s' % getattr(root, height)
        u = len(s)
        first_li = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_li = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lis = zip(left, right)
        lis = [first_li, second_li] + [a + u * ' ' + b for a, b in zipped_lis]
        return lis, n + m + u, max(p, q) + 2, n + u // 2
    lis, *_ = disp(root, height, left, right)
    for li in lis: print(li)

def insert(root, data):
    """
    algorithm:
    insert new node as leaf of BST
    """
    node = root
    # has a child
    while True:
        if data > node.data:  # go right
            if node.right:
                node = node.right
            else:
                node.right = Node(data, node)
                bottom = node.right
                break
        else:
            if node.left:
                node = node.left
            else:
                node.left = Node(data, node)
                bottom = node.left
                break
    
    # update height
    unbalanced = []
    node = bottom
    while node is not None:
        node = node.parent
        if node:
            node.height += 1
            lheight = node.left.height if node.left else -1
            rheight = node.right.height if node.right else -1
            node.balance = abs(lheight - rheight)
            if node.balance > 1:
                unbalanced.append(node)
                # AT THIS POINT, WE SHOULD ROTATE
                # ROTATE ONCE
                # ROTATE THE CHILD NODE WITH MAXIMUM HEIGHT
                # CODE HERE MAY NOT BE QUITE RIGHT
                if node.left:
                    items = [node.left, node.left.left if node.left.left else node.left.right]
                    top = items[0] if items[0].data > items[1].data and items[0].data < node.data or \
                        items[0].data < items[1].data and items[0].data > node.data else items[1]
                    other = items[1] if items[0].data > items[1].data and items[0].data < node.data or \
                        items[0].data < items[1].data and items[0].data > node.data else items[0]
                    tmp = node.data
                    node.data = top.data  # 8->9
                    top.data = tmp  # 9->8
                    node.left = None # remove 8's children
                    node.right = None
                    # TODO additional swaps needed
                else:
                    items = [node, node.right, node.right.left if node.right.left else node.right.right]
                    top = items[0] if items[0].data > items[1].data and items[0].data < node.data or \
                        items[0].data < items[1].data and items[0].data > node.data else items[1]
                    node.data = top.data # 8->9
                    top.data = tmp # 9->8
                    node.left = None  # remove 8's children
                    node.right = None
                    # TODO additional swaps needed

    # rotate the unbalanced nodes in ``unbalanced``
    print(unbalanced)

root = Node(5, None, 2, 1)
root.left = Node(1, root, 0)
root.right = Node(3, root, 1, 1)
root.right.right = Node(6, root.right, 0, 0)
insert(root, 7)
print_tree(root)
print_tree_heights(root)