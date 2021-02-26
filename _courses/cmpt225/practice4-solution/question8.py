"""
write an algorithm that gets a binary tree, a number k
and returns all values in level k. what is the running time of your algorithm?
"""
from binary_tree import build_tree7


def get_level(bt, k):
    """
    assume root is level 0
    - O(N) solution (in worst case we look at entire tree)
    """
    q = [(bt.root, 0)]
    max_depth = 0
    arr = []
    while q:
        node, depth = q.pop(0)
        max_depth = max(depth, max_depth)
        if max_depth > k:
            return arr
        if depth == k:
            arr.append(node.data)
        if node.left is not None:
            q.append((node.left, depth+1))
        if node.right is not None:
            q.append((node.right, depth+1))
    return arr

if __name__ == "__main__":

    # test tree 7
    tree = build_tree7()
    print(tree)
    print(get_level(tree, 2))
    
