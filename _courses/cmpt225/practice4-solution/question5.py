"""
write an algorithm that gets a tree and computes its size
using iterative implementation.
"""
from binary_tree import build_tree1, build_tree2, build_tree3


def get_size(bt):
    """
    use level-order iterative algorithm
    """
    count = 0

    q = [bt.root]
    while q:
        node = q.pop(0)
        count += 1
        if node.left is not None:
            q.append(node.left)
        if node.right is not None:
            q.append(node.right)

    return count


if __name__ == "__main__":

    # test tree1
    tree1 = build_tree1()
    print(get_size(tree1))

    # test tree2
    tree2 = build_tree2()
    print(get_size(tree2))

    # test tree3
    tree3 = build_tree3()
    print(get_size(tree3))
