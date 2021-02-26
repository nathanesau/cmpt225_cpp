"""
write an algorithm that gets two binary trees
and checks if they have the same inOrder traversal.
"""
from binary_tree import in_order, build_tree7


def are_equal_in_order(tree1, tree2):
    in_order1 = in_order(tree1)
    in_order2 = in_order(tree2)
    return in_order1 == in_order2


if __name__ == "__main__":

    # test tree7
    tree7 = build_tree7()
    print(are_equal_in_order(tree7, tree7))
