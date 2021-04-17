# practice7-solution - AVL trees

1. What is the minimal/maximal size of an  AVL tree of height 3 and height 4?

    *Answer*
    using N(h) = 1 + N(h - 1) + N(h - 2) with N(0) = 1 and N(1) = 2. then N(2) = 4.

    height 3:

    * minimal size is 7 since N(3) = 7.
    * maximal size is 1 + 2 + 4 + 8 = 15

    height 4:

    * minimal size is 12 since N(4) = 12.
    * maximal size is 1 + 2 + 4 + 8 + 16 = 31

2. Draw the AVL tree obtained by inserting the sequence [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15].

    *Answer*
    see https://www.cs.usfca.edu/~galles/visualization/AVLtree.html

![](https://user-images.githubusercontent.com/4649987/115127004-4caeb080-9fa1-11eb-8837-54e02c7d2170.PNG)

3. Is this statement True or False? Justify your answer. "Every AVL tree with n vertices has height at most log(n)".

    *Answer* 
    False. For example, below AVL tree satisfies AVL property and h = 3 is greater than log(7) = 2.8.

    ![](https://user-images.githubusercontent.com/4649987/115127055-88497a80-9fa1-11eb-824e-2ff5c73e05b0.PNG)

4. Is this statement True or False? Justify your answer. "Removal from an AVL tree always removes a leaf".

    *Answer*
    True. see http://www.cs.toronto.edu/~krueger/cscB63h/lectures/tut03.txt for additional info.

    There are three possible cases (just like for BSTs):
    * If x has no children (i.e., is a leaf), delete x.
    * If x has one child, let x' be the child of x.
        * Notice: x' cannot have a child, since subtrees of T can differ in height by at most one
        * replace the contents of x with the contents of x'
        * delete x' (a leaf) 
    * If x has two children, 
    * find x's successor z (which has no left child)
    * replace x's contents with z's contents, and 
    * delete z. [since z has at most one child, so we use case (1) or (2) to delete z]

5. Is this statement True of False? Justify your answer. "Insertion into an AVL tree always increases the number of leaves."

    *Answer*
    True. also, see this link for visualization of leaf nodes. https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/.

6. When a new element is added to an AVL tree as a leaf using the normal BST insertion, is it possible that more than one node becomes unbalanced?

    Answered in last lecture.

7. Adding a new element to an AVL tree, we may require rebalancing at most one vertex.

    TODO

8. If adding a vertex to an AVL tree requires a rebalancing of some nodes, then the height of the tree does not change.

    TODO

9. When removing a node from an AVL tree, we may require rebalancing at most one vertex.

    TODO

10. When removing a node from an AVL tree on n nodes, is it possible that O(log(n)) vertices need to be rebalanced?

    TODO

11. When removing a node from an AVL tree on n nodes, is it possible that O(n) vertices need to be rebalanced?

    TODO
