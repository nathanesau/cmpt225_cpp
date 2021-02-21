"""
write an algorithm that gets a binary tree of ints and
returns the sum of all numbers in the tree.
"""
from binary_tree import in_order, build_tree1, build_tree2, build_tree3


def get_sum(bt):
    return sum(in_order(bt))


if __name__ == "__main__":

    # test tree1
    tree1 = build_tree1()
    print(get_sum(tree1))

    # test tree2
    tree2 = build_tree2()
    print(get_sum(tree2))

    # test tree3
    tree3 = build_tree3()
    print(get_sum(tree3))

