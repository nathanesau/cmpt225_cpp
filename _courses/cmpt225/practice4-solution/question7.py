"""
write an algorithm that gets two nodes in a binary tree
and computes the distance between them. the algorithm
must run in time O(height of the tree).
"""
from binary_tree import build_tree6


def get_distance(root1, root2):
    if root1 == root2:
        return 0

    dist = 0
    node1, node2 = root1, root2
    visited = set([node1, node2])
    while node1.parent is not None or node2.parent is not None:

        if node2.parent is not None and node2.parent in visited:
            node2 = node2.parent
            dist += 1
            break
            
        if node1.parent is not None:
            node1 = node1.parent
            dist += 1
            if node1 in visited:
                break
            else:
                visited.add(node1)
        if node2.parent is not None:
            node2 = node2.parent
            dist += 1
            if node2 in visited:
                break
            else:
                visited.add(node2)    

    return dist


if __name__ == "__main__":

    # test tree6
    tree6 = build_tree6()    
    print(f"dist(4,5): {get_distance(tree6.root.left.left, tree6.root.left.right)}")
    print(f"dist(4,6): {get_distance(tree6.root.left.left, tree6.root.right.left)}")
    print(f"dist(3,4): {get_distance(tree6.root.right, tree6.root.left.left)}")
    print(f"dist(2,4): {get_distance(tree6.root.left, tree6.root.left.left)}")
    print(f"dist(8,5): {get_distance(tree6.root.right.left.right, tree6.root.left.right)}")