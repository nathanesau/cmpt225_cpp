class Node:
    def __init__(self, data):
        self.data = data
        self.parent = None
        self.rank = 0


def make_set(data):
    """
    creates a new node containing data
    """
    return Node(data)


def find(node):
    """
    gets the top-level root of node
    """
    if node.parent is None:
        return node
    return find(node.parent)


def union(u, v):
    """
    connect shallower set to root of other set
    """
    ru = find(u)
    rv = find(v)
    if ru.rank > rv.rank:
        rv.parent = ru
    elif ru.rank < rv.rank:
        ru.parent = rv
    else:
        ru.parent = rv
        rv.rank += 1


if __name__ == "__main__":
    n1 = make_set(1)
    n2 = make_set(2)
    n3 = make_set(3)
    n4 = make_set(4)
    n5 = make_set(5)

    if find(n1) == find(n2):
        print("n1 and n2 are in the same set")
    else:
        print("n1 and n2 are in different sets")

    # connect n1 and n3
    # 
    # 3 
    # |
    # 1
    union(n1, n3)

    # connect n4 and n5
    #
    # 5
    # |
    # 4
    union(n4, n5)

    # connect n2 and n5
    # 
    #   5
    #  / \ 
    # 2   4
    union(n2, n5)

    if find(n1) == find(n2):
        print("n1 and n2 are in the same set")
    else:
        print("n1 and n2 are in different sets")

    # connect n1 and n4
    #
    #     5
    #   / | \
    #  3  2  4
    #  |
    #  1
    union(n1, n4)

    if find(n1) == find(n2):
        print("n1 and n2 are in the same set")
    else:
        print("n1 and n4 are in different sets")
