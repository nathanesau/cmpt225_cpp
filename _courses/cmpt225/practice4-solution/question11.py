"""
draw all trees whose postOrder traversal is [1, 2, 3, 4].
"""
import math
from binary_tree import Node, BinaryTree, pre_order, in_order, post_order, get_tree_with_links, \
    in_order_nodes, post_order_nodes


def transform_inorder_postorder(tree):
    in_nodes = in_order_nodes(tree)
    post_nodes = post_order_nodes(tree)

    if in_nodes == post_nodes:  # no transform needed
        return tree
    
    in_data = [node.data for node in in_nodes]
    post_data = [node.data for node in post_nodes]

    # NOTE: do not modify the structure of the tree
    for i in range(len(post_nodes)):
        if in_data[i] == post_data[i]:  # no transform needed
            continue
        post_node = post_nodes[i]
        post_node.data = in_data[i]

    return tree


# generate all such in_order trees and transfer them to pre_order trees
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
    return [transform_inorder_postorder(get_tree_with_links(tree)) for tree in trees]


if __name__ == "__main__":
    trees = generate_trees(4)
    for tree in trees:
        print(f"pre_order: {pre_order(tree)}")
        print(f"in_order: {in_order(tree)}")
        print(f"post_order: {post_order(tree)}")
        print(f"{tree}\n")
