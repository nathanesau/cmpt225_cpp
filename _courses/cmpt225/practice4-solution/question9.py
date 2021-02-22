"""
draw all trees whose preOrder traversal is [1, 2, 3, 4]
"""
import math
from binary_tree import Node, BinaryTree, pre_order, in_order, post_order, get_tree_with_links


# TODO fix this to generate pre-order
# currently it is generating inorder
def generate_trees(n):
    def _generate_roots(start, end):
        if start > end:
            return [None]
        
        roots = []
        for i in range(start, end+1):
            ltrees = _generate_roots(start, i-1)
            rtrees = _generate_roots(i+1, end)
            for lnode in ltrees:
                for rnode in rtrees:
                    root = Node(i)
                    root.left = lnode
                    root.right = rnode
                    roots.append(root)
        
        return roots

    roots = _generate_roots(1, n)
    trees = [BinaryTree(root) for root in roots]
    return [get_tree_with_links(tree) for tree in trees]


for tree in generate_trees(4):
    print(f"pre_order: {pre_order(tree)}")
    print(f"in_order: {in_order(tree)}")
    print(f"post_order: {post_order(tree)}")
    print(f"{tree}\n")
