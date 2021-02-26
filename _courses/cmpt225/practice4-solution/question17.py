"""
how many binary trees have preOrder traversal sequence
equal to [1, 2, 3, 4, ... n]?
"""
import math

def get_num_trees(n):
    return int(math.factorial(2*n) / (math.factorial(n+1) * math.factorial(n)))


if __name__ == "__main__":

    for n in range(1, 11, 1):
        print(f"n = {n}: {get_num_trees(n)}")
