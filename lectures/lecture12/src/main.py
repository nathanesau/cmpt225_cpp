import math


def ndigits(n):
    return int(math.log10(n)) + 1


def nsplit(n, m):
    h = int(n / (10 ** m))
    l = n - h * (10 ** m)
    return h, l


def karatsuba(n1, n2):
    if n1 < 10 or n2 < 10:
        return n1 * n2
    m = math.ceil(min(ndigits(n1), ndigits(n2)) / 2)
    h1, l1 = nsplit(n1, m)
    h2, l2 = nsplit(n2, m)
    z0 = karatsuba(l1, l2)
    z1 = karatsuba(l1 + h1, l2 + h2)
    z2 = karatsuba(h1, h2)
    return z2 * (10 ** (2*m)) + (z1 - z2 - z0) * (10 ** m) + z0


if __name__ == "__main__":
    print("calculating 12345 * 6789...")
    print(f"expected result: {83810205}")
    print(f"actual result: {karatsuba(12345, 6789)}")
