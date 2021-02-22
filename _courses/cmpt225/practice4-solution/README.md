# practice4-solution

implement the following functions in java:

1. write an algorithm that gets a binary tree of ints and returns the smallest number in the tree. [question1.py](question1.py)

2. write an algorithm that gets a binary trees of ints and returns the sum of all numbers in the tree. [question2.py](question2.py)

3. write an algorithm that gets a node in a binary tree, and returns its depth (distance from the root) in O(depth) time. [question3.py](question3.py)

4. write an algorithm that given two binary trees checks if they are equal. [question4.py](question4.py)

5. write an algorithm that gets a tree and computes its size using iterative implementation. [question5.py](question5.py)

6. write an algorithm that gets a tree and computes its depth using iterative implementation. [question6.py](question6.py)

7. write an algorithm that gets two nodes in a binary tree and computes the distance between them. the algorithm must run in time O(height of the tree). [question7.py](question7.py)

* note this can be inefficient if u and v are very deep in the tree, but the distance between them is small. write an algorithm that computes the distance between two nodes, u and v in time O(dist(u, v)).

8. write an algorithm that gets a binary tree, a number k and returns all values in level k. what is the running time of your algorithm? [question8.py](question8.py) TODO (easy)

9. draw all trees whose preOrder traversal is [1, 2, 3, 4].[question9.py](question9.py)TODO (hard)

10. draw all trees whose inOrder traversal is [1, 2, 3, 4]. [question10.py](question10.py)

11. draw all trees whose postOrder traversal is [1, 2, 3, 4]. [question11.py](question11.py) TODO (hard)

12. write an algorithm that gets an array of numbers and returns a binary tree whose inOrder traversal is this sequence. [question12.py](question12.py)

13. prove that if we know preOrder and inOrder traversal of a binary tree, then we can reconstruct the tree in a unique way. write an algorithm that reconstructs the tree from its preOrder and inOrder. [question13.py](question13.py) TODO (hard)

* answer the same question when given postOrder and inOrder.
* answer the same question when given preOrder and postOrder.

14. write an algorithm that gets two binary trees and checks if they have the same inOrder traversal. Write is as efficient as possible. for example, if the inOrders differ in the second position, then the algorithm will not explore the trees entirely, but will stop after only a small number of nodes in each of the trees. [question14.py](question14.py) TODO (easy)

15. write an algorithm that gets an array of numbers and returns all binary trees whose inOrder traversals are this sequence. [question15.py](question15.py) modification of question 10 (hard)

16. write an algorith that gets an array of numbers and returns all binary trees whose preOrder traversals are this sequence. [question16.py](question16.py) modifidication of question 9 (hard)

17. how many binary trees have preOrder traversal sequence equal to [1, 2, 3, 4, ... n]? [question17.py](question17.py) TODO (easy)

18. how many binary trees have inOrder traversal sequence equal to [1, 2, 3, 4, ... n]? [question18.py](question18.py) TODO (easy)

19. define a class BTNodeInt that supports the following operations: [question19.py](question19.py) TODO (medium)

* getData/ setData
* getLeftChild/ setLeftChild
* getRightChild/ setRightChild
* getParent/ setParent
* int size - returns the size of the subtree rooted at this. the running time must be O(1).
* int sum - returns the sum of all nodes in the subtree rooted at this. the running time must be O(1).
* note: the setters are allowed to run in time O(log(size of the tree)).
* now suppose we want to add also the method depth() that returns the depth of the node (relatively to the root of the entire tree) in O(1). Propose a method to support this operation. What will be the running time of the setters.

## additional information

``draw_tree`` information.

```python
"""
            1
          /   \
         2     3
        / \
       4   5

    or equivalently
    
    [
        ['.', '.', '.', '.', '1', '.', '.'],
        ['.', '.', '.', '/', '.', '\', '.'],
        ['.', '.',' 2', '.', '.', '.', '3'],
        ['.', '/', '.', '\', '.', '.', '.'],
        ['4', '.', '.', '.', '5', '.', '.']
    ]

    print('\n'.join([''.join(row) for row in arr]))
"""
```

[total number of binary trees](https://stackoverflow.com/questions/3042412/with-n-no-of-nodes-how-many-different-binary-and-binary-search-trees-possib) information.

$t(n) = \frac{2n!}{(n+1)!n!}$

* $t(0) = 1$
* $t(1) = 1$


[total number of binary search trees](https://stackoverflow.com/questions/3042412/with-n-no-of-nodes-how-many-different-binary-and-binary-search-trees-possib) information.

$t(n) = \sum_{i=1}^{n} t(i-1) t(n-i)$

* $t(0) = 1$
* $t(1) = 1$
* $t(2) = 2$
* $t(3) = 5$
* $t(4) = 14$

The general algorithm for generating these trees is below. It's an important one to know.

```python
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
```