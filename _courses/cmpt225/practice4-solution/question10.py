"""
draw all trees whose inOrder traversal is [1, 2, 3, 4].
"""
import math
from binary_tree import Node, BinaryTree, in_order, pre_order, post_order, get_tree_with_links


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



if __name__ == "__main__":    
    trees = generate_trees(4)
    for tree in trees:
        print(f"in_order: {in_order(tree)}")
        print(f"pre_order: {pre_order(tree)}")
        print(f"post_order: {post_order(tree)}")
        print(f"{tree}\n")

    # count all trees
    print(f"in_order trees: {len(trees)}")
