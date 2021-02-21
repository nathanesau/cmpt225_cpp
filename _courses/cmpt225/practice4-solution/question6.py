"""
write an algorithm that gets a tree and computes its
depth using iterative implementation.
"""

"""
write an algorithm that gets a tree and computes its size
using iterative implementation.
"""
from binary_tree import build_tree1, build_tree2, build_tree3


def get_depth(bt):
    """
    use level-order iterative algorithm
    """
    max_depth = 0

    q = [(bt.root, 1)]
    while q:
        node, depth = q.pop(0)
        max_depth = max(depth, max_depth)
        if node.left is not None:
            q.append((node.left, depth + 1))
        if node.right is not None:
            q.append((node.right, depth + 1))

    return max_depth


if __name__ == "__main__":

    # test tree1
    tree1 = build_tree1()
    print(get_depth(tree1))

    # test tree2
    tree2 = build_tree2()
    print(get_depth(tree2))

    # test tree3
    tree3 = build_tree3()
    print(get_depth(tree3))
