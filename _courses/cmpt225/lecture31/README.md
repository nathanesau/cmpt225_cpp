# Lecture 31 code samples

## Java

sample output:

```bash
n1 and n2 are in different sets
union(n1, n3)
union(n4, n5)
union(n2, n5)
n1 and n2 are in different sets
union(n1, n4)
n1 and n2 are in the same set  
```

## Python

sample output (union_find):

```bash
n1 and n2 are in different sets
n1 and n2 are in different sets
n1 and n2 are in the same set
```

sample output (mst):

```bash
# TODO
```

## Additional Information

* if a vertex has rank ``k``, at least ``2^k`` vertices in the subtree rooted at that vertex.
* if there are ``n`` vertices, then maximal depth is ``log(n)``. therefore, find and union run in ``O(log(n))`` time.
* common application is the minimum spanning tree problem.

## Minimum Spanning Tree Problem

given an undirected graph output the spanning tree of minimum cost.

```python
graph = {
    "a": {"b": 2, "e": 3, "c": 1},
    "b": {"a": 2, "d": 1},
    "c": {"a": 1, "d": 8, "f": 2, "h": 3},
    "d": {"b": 1, "c": 8, "e": 5, "g": 1, "h": 7},
    "e": {"a": 3, "d": 5},
    "f": {"c": 2, "g": 2},
    "g": {"d": 1, "f": 2},
    "h": {"c": 3, "d": 7}
}

mst = {
    ("a", "b", 2),
    ("b", "d", 1),
    ("d", "g", 1),
    ("a", "e", 3),
    ("a", "c", 1),
    ("c", "h", 3),
    ("c", "f", 2)
}
```

kruskal's algorithm.

1. set T = empty set

2. while |T| < |V|-1 do:

    a. pick an edge with minimum weight such that T doesn't contain a cycle
    b. add e to T

<!--
how to check if (u,v) closes a cycle in T?

- run BFS/DFS on T from u and check if v is reachable
-->

union find algorithm:

* first sort the edges by their costs.
* go over the edges in increasing order and for each edge see if it closes a cycle.
* check if an edge closes a cycle using union find.
* ``O(m*log(m))`` + ``O(m*log(n))`` for ``n`` vertices and ``m`` edges.
