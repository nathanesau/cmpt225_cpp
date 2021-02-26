"""
write an algorithm that gets an array of numbers and returns all
binary trees whose preOrder traversal are this sequence.
"""

"""
draw all trees whose preOrder traversal is [1, 2, 3, 4]
"""
import math
from binary_tree import Node, BinaryTree, pre_order, in_order, post_order, get_tree_with_links, \
    in_order_nodes, pre_order_nodes


def transform_inorder_preorder(tree):
    in_nodes = in_order_nodes(tree)
    pre_nodes = pre_order_nodes(tree)

    if in_nodes == pre_nodes:  # no transform needed
        return tree
    
    in_data = [node.data for node in in_nodes]
    pre_data = [node.data for node in pre_nodes]

    # NOTE: do not modify the structure of the tree
    for i in range(len(pre_nodes)):
        if in_data[i] == pre_data[i]:  # no transform needed
            continue
        pre_node = pre_nodes[i]
        pre_node.data = in_data[i]

    return tree


# generate all such in_order trees and transfer them to pre_order trees
def generate_trees(arr):
    def _generate_roots(start, end):
        if start > end:
            return [None]
        
        roots = []
        for i in range(start, end+1):
            ltrees = _generate_roots(start, i-1)
            rtrees = _generate_roots(i+1, end)
            for lnode in ltrees:
                for rnode in rtrees:
                    root = Node(arr[i-1])
                    root.left = lnode
                    root.right = rnode
                    roots.append(root)
        
        return roots

    roots = _generate_roots(1, len(arr))
    trees = [BinaryTree(root) for root in roots]
    return [transform_inorder_preorder(get_tree_with_links(tree)) for tree in trees]


if __name__ == "__main__":
    trees = generate_trees([4,2,3,1])
    for tree in trees:
        print(f"pre_order: {pre_order(tree)}")
        print(f"in_order: {in_order(tree)}")
        print(f"post_order: {post_order(tree)}")
        print(f"{tree}\n")
