# Binary Search Trees

1. Create a Binary Search Tree from the following list of insertions: [4, 6, 2, 3, 1, 5, 8] [question1/bst.png](question1/bst.PNG)

2. Create a Binary Search Tree from the following list of insertions: [4, 2, 6, 1, 3, 5, 6] [question2/bst.png](question2/bst.PNG)

3. Create a Binary Search Tree from the following list of insertions [1, 2, 3, 4, 5, 6, 7] [question3/bst.png](question3/bst.PNG)

4. Create a Binary Search Tree from the following list of insertions [1, 2, 3, 7, 6, 5, 4] [question4/bst.png](question4/bst.PNG)

5. Create a Binary Search Tree from the following list of insertions [4, 3, 2, 1, 5, 6, 7] [question5/bst.png](question5/bst.PNG)

6. Create a Binary Search Tree from the following list of insertions [4, 1, 2, 3, 5, 6, 7] [question6/bst.png](question6/bst.PNG)

7. Create a Binary Search Tree from following list of insertions [1, 7, 2, 6, 3, 5, 4] [question7/bst.png](question7/bst.PNG)

8. What are all the sequences that give a tree of full depth? for the values [1, 2, ..., n]. Write an algorithm that outputs all the sequences. [question8/bst.py](question8/bst.py)

    * First number must be either 1 or n
    * Next number must be min or max of remaining numbers

9. Write a function that adds or removes a given element to a binary search tree. [question9/bst.py](question9/bst.py)

## Additional Information

### Remove node from BST

Remove node with no children:

```python
class Node:
    def __init__(self, data, parent=None);
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None

def remove_node(root, node):
    if root == node:
        root = None
    else:
        if none.parent.left == node:
            node.parent.left = None
        else:
            node.parent.right = None

# example
node = Node(4)
node.left = Node(2, parent=node)
node.right = Node(6, parent=node)
node.left.left = Node(1, parent=node)
node.left.right = Node(3, parent=node)
node.right.left = Node(5, parent=node)
node.right.right = Node(7, parent=node)

remove_node(root, node.left.right)
```

Remove node with one child:

```python
class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None

def remove_node(root, node):
    child = node.left is node.left is not None else node.right
    if root == node:
        root = child
    else:
        if node.parent.left == node:
            node.parent.left = child
        else:
            node.parent.right = child

# example
node = Node(4)
node.left = Node(3, parent=node)
node.right = Node(5, parent=node)
node.left.left = Node(2, parent=node.left)
node.right.right = Node(6, parent=node.right)
node.left.left.left = Node(1, parent=node.left.left)
node.right.right.right = Node(7, parent=node.right.right)

remove_node(root, node.left)
remove_node(root, node.right.right)
```

Remove node with two children:

```python
class Node:
    def __init__(self, data, parent=None):
        self.data = data
        self.parent = parent
        self.left = None
        self.right = None
    
def remove_node(root, node):
    # next = find successor of node in the tree
    # hext has <= 1 child
    node.data = next.data
    remove_node(root, next)
    # putting the predecessor in the root also works

# example
node = Node(4)
node.left = Node(2, parent=node)
node.right = Node(6, parent=node)
node.left.left = Node(1, parent=node)
node.left.right = Node(3, parent=node)
node.right.left = Node(5, parent=node)
node.right.right = Node(7, parent=node)

# in this example, the successor of 4 is 5
```

### Running time of operations

What is the running time of findElement? O(depth of tree)

What is the running time of addElement? O(depth of tree)

What is the running time of removeElement? O(depth of tree)

Conclusion: we want the tree to be balanced, i.e. have no long strings.