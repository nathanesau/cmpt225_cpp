"""
write an algorithm that outputs all sequences that give
full tree depth from 1..n
"""
import copy


def get_all_sequences(n):
    def _new_b(b, val):
        new_b = copy.deepcopy(b)
        if val < new_b.data:
            new_b.left = Node(val)
            new_b.left.parent = new_b
            new_b = new_b.left
        else:
            new_b.right = Node(val)
            new_b.right.parent = new_b
            new_b = new_b.right
        return new_b

    def _new_arr(arr, val):
        new_arr = copy.deepcopy(arr)
        new_arr.remove(val)
        return new_arr

    n1 = Node(1)
    n2 = Node(n)
    seql = [{"b": n1, "arr": [
        i+1 for i in range(1, n)]}, {"b": n2, "arr": [i+1 for i in range(n-1)]}]

    for _ in range(n-1):
        new_seql = []
        for seq in seql:
            if len(seq["arr"]) > 1:
                b1 = _new_b(seq["b"], min(seq["arr"]))
                b2 = _new_b(seq["b"], max(seq["arr"]))
                arr1 = _new_arr(seq["arr"], min(seq["arr"]))
                arr2 = _new_arr(seq["arr"], max(seq["arr"]))
                new_seql += [{"b": b1, "arr": arr1}, {"b": b2, "arr": arr2}]
            else:
                b1 = _new_b(seq["b"], min(seq["arr"]))
                arr1 = _new_arr(seq["arr"], min(seq["arr"]))
                new_seql += [{"b": b1, "arr": arr1}]
        seql = new_seql

    rootl = []
    for seq in seql:
        node = seq["b"]
        while node.parent != None:
            node = node.parent
        rootl.append(node)

    return rootl


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


class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None


if __name__ == "__main__":

    # 1..7
    rootl = get_all_sequences(7)

    for i, root in enumerate(rootl):
        print(f"==========\ni: {i+1}\n==========")
        print_tree(root)
