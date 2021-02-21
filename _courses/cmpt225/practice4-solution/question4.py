"""
write an algorithm that given two binary trees
checks if they are equal
"""
from binary_tree import build_tree1, build_tree2, build_tree3


def are_equal(bt1, bt2):
    """
    use level-order traversal here (other traversals will work too)
    """
    def _compare(node1, node2):
        return node1.data == node2.data

    q1, q2 = [bt1.root], [bt2.root]
    while q1 and q2:
        node1, node2 = q1.pop(0), q2.pop(0)
        if not _compare(node1, node2): return False
        if node1.left is not None: q1.append(node1.left)
        if node1.right is not None: q1.append(node1.right)
        if node2.left is not None: q2.append(node2.left)
        if node2.right is not None: q2.append(node2.right)
    
    return len(q1) == 0 and len(q2) == 0


if __name__ == "__main__":

    # test tree1
    tree1 = build_tree1()
    print(are_equal(tree1, tree1))

    # test tree2
    tree2 = build_tree2()
    print(are_equal(tree2, tree2))

    # test tree3
    tree3 = build_tree3()
    print(are_equal(tree3, tree3))
