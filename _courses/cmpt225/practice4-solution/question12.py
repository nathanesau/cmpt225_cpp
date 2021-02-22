"""
write an algorithm that gets an array of numbers and
returns a binary tree whose inOrder traversal is this sequence.
"""
from binary_tree import Node, BinaryTree, get_tree_with_links


# TODO review this algorithmn
def construct_tree(arr):
    pre_index = [0]

    def _construct_tree(arr, low, high, size):
        if pre_index[0] >= size or low > high:
            return None

        root = Node(arr[pre_index[0]])
        pre_index[0] += 1

        if low == high:
            return root

        for i in range(low, high+1):
            if arr[i] > root.data:
                break
                
        root.left = _construct_tree(arr, pre_index[0], i-1, size)
        root.right = _construct_tree(arr, i, high, size)

        return root

    n = len(arr)
    root = _construct_tree(arr, 0, n-1, n)
    return get_tree_with_links(BinaryTree(root))
    

if __name__ == "__main__":

    arr = [10, 5, 1, 7, 40, 50]
    tree = construct_tree(arr)
    print(tree)
