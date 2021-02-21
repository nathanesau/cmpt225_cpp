"""
write an algorithm that gets a binary tree of ints
and returns the smallest number in the tree
"""
from binary_tree import in_order, build_tree1, build_tree2, build_tree3


def get_min(bt):
    return min(in_order(bt))


if __name__ == "__main__":

    # test tree1
    tree1 = build_tree1()
    print(get_min(tree1))

    # test tree2
    tree2 = build_tree2()
    print(get_min(tree2))

    # test tree3
    tree3 = build_tree3()
    print(get_min(tree3))
