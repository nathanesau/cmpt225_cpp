"""
draw all trees whose inOrder traversal is [1, 2, 3, 4].
"""
from binary_tree import Node, BinaryTree, in_order
import math


def get_num_trees(arr):
    n = len(arr)
    return int(math.factorial(2*n) / (math.factorial(n+1) * math.factorial(n)))


def get_inorder_trees(arr):

    def _get_roots(arr, start, end):
        roots = []
        if start > end:
            roots.append(None)
            return roots
        
        for i in range(start, end+1):
            lroots = _get_roots(arr, start, i-1)
            rroots = _get_roots(arr, i+1, end)

            for j in lroots:
                for k in rroots:
                    node = Node(arr[i])
                    node.left = j
                    node.right = k
                    roots.append(node)

        return roots

    return [BinaryTree(root) for root in _get_roots(arr, 0, len(arr) - 1)]

if __name__ == "__main__":    
    trees = get_inorder_trees([1,2,3,4])
    for tree in trees:
        print(f"in_order: {in_order(tree)}")
        print(f"{tree}\n")
    
    # closed form formula
    print(f"num_trees: {get_num_trees([1,2,3,4])}")

    # count all trees
    print(f"in_order trees: {len(trees)}")
