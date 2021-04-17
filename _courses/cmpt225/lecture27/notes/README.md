# AVL tree notes

Balanced tree:

    1
  /  \
  2  3  

Non-balanced tree:

    1
   /
  2
 /
3

AVL is a balancing algorithm.

* Balanced will have O(log(n)).

Level 0: 1 node.            2^0
Level 1: 2 nodes.           2^1
Level 2: 4 nodes.           2^2
...
Level 100: 2^100 nodes.     2^100

N = 2^100
height <= 200


AVL property. 

| height(v.left) - height(v.right) | <= 1

AVL output example:

[<__main__.Node object at 0x000001ABC699CAC8>, <__main__.Node object at 0x000001ABC699CC48>]
 5
/ \
1 3
   \
   6
    \
    7
 3
/ \
0 2
   \
   1
    \
    0