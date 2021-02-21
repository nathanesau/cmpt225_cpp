# practice4-solution

implement the following functions in java:

1. write an algorithm that gets a binary tree of ints and returns the smallest number in the tree.

2. write an algorithm that gets a binary trees of ints and returns the sum of all numbers in the tree.

3. write an algorithm that gets a node in a binary tree, and returns its depth (distance from the root) in O(depth) time.

4. write an algorithm that given two binary trees checks if they are equal.

5. write an algorithm that gets a tree and computes its size using iterative implementation.

6. write an algorithm that gets a tree and computes its depth using iterative implementation.

7. write an algorithm that gets two nodes in a binary tree and computes the dinstance between them. the algorithm must run in time O(height of the tree).

* note this can be inefficient if u and v are very deep in the tree, but the distance between them is all. write an algorithm that computes the distance between two nodes, u and v in time O(dist(u, v)).

8. write an algorithm that gets a binary tree, a number k and returns all values in level k. what is the running time of your algorithm.

9. draw all trees whose preOrder traversal is [1, 2, 3, 4].

10. draw all trees whose inOrder traversal is [1, 2, 3, 4].

11. draw all trees whose postOrder traversal is [1, 2, 3, 4].

12. write an algorithm that gets an array of numbers and returns a binary tree whose inOrder traversal is this sequence.

13. provide that if we know preOrder and inOrder traversal of a binary tree, then we can reconstruct the tree in a unique way. write an algorithm that reconstructs the tree from its preOrder and inOrder.

* answer the same question when given postOrder and inOrder.
* answer the same question when given preOrder and postOrder.

14. write an algorithm that gets two binary trees and checks if they have the same inOrder traversal. Write is as efficient as possible. for example, if the inOrders differ in the second position, then the algorithm will not explore the trees entirely, but will stop after only a small number of nodes in each of the trees.

15. write an algorithm that gets an array of numbers and returns all binary trees whose inOrder traversals are this sequence.

16. write an algorith that gets an array of numbers and returns all binary trees whose preOrder traversals are this sequence.

17. how many binary trees have preOrder traversal sequence equal to [1, 2, 3, 4, ... n]?

18. how many binary trees have inOrder traversal sequence equal to [1, 2, 3, 4, ... n] ?

19. define a class BTNodeInt that supports the following operations:

* getData/ setData
* getLeftChild/ setLeftChild
* getRightChild/ setRightChild
* getParent/ getParent
* int size - returns the size of the subtree rooted at this. the running time must be O(1).
* int sum - returns the sum of all nodes in the subtree rooted at this. the running time must be O(1).
* note: the setters are allowed to run in time O(log(size of the tree)).
* now suppose we want to add also the method depth() that returns the depth of the node (relatively to the root of the entire tree) in O(1). Propose a method to support this operation. What will be the running time of the setters.