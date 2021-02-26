"""
define a class BTNodeInt that supports the following operations
- getData/ setData
- getLeftChild/ setLeftChild
- getRightChild/ setRightChild
- getParent/ setParent
- size
- sum
"""
from binary_tree import BinaryTree

class BTNodeInt:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None

    def get_data(self):
        return self.data

    def set_data(self, data):
        self.data = data

    def get_left_child(self):
        return self.left

    def set_left_child(self, left):
        self.left = left

    def get_right_child(self):
        return self.right

    def set_right_child(self, right):
        self.right = right

    def get_parent(self):
        return self.parent

    def set_parent(self, parent):
        self.parent = parent

    def get_size(self):
        def _pre_order(node, count):
            if node is None:
                return
            count[0] += 1
            _pre_order(node.left, count)
            _pre_order(node.right, count)

        node = self
        count = [0]
        _pre_order(node, count)
        return count[0]

    
    def get_sum(self):
        def _pre_order(node, total):
            if node is None:
                return
            total[0] += node.data
            _pre_order(node.left, total)
            _pre_order(node.right, total)

        node = self
        total = [0]
        _pre_order(node, total)
        return total[0]


if __name__ == "__main__":

    # custom tree
    root = BTNodeInt(1)
    root.left = BTNodeInt(5, parent=root)
    root.right = BTNodeInt(4, parent=root)
    root.left.left = BTNodeInt(3, parent=root.left)
    root.left.right = BTNodeInt(2, parent=root.left)
    root.left.right.left = BTNodeInt(9, parent=root.left.right)
    root.right.right = BTNodeInt(8, parent=root.right)
    tree = BinaryTree(root)
    print(tree)
    print(f"size: {tree.root.get_size()}")
    print(f"sum: {tree.root.get_sum()}")
