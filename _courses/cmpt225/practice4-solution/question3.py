"""
write an algorithm that gets a node in a binary tree
and returns its depth (distance from the root) in O(depth) time.
"""
from binary_tree import build_tree1, build_tree2, build_tree3


def get_depth(root):
    node = root
    depth = 0
    while node is not None:
        node = node.parent
        depth += 1
    return depth


if __name__ == "__main__":
    
    # test tree1
    tree1 = build_tree1()
    print(get_depth(tree1.root))

    # test tree2
    tree2 = build_tree2()
    print(get_depth(tree2))

    # test tree3
    tree3 = build_tree3()
    print(get_depth(tree3))
