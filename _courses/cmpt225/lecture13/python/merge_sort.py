def merge(arr, left_idx, right_idx, mid_idx):
    a = arr[left_idx:(mid_idx + 1)]
    b = arr[(mid_idx + 1):(right_idx + 1)]
    a_idx = 0
    b_idx = 0
    sorted_idx = left_idx

    while a_idx < len(a) and b_idx < len(b):
        if a[a_idx] <= b[b_idx]:
            arr[sorted_idx] = a[a_idx]
            a_idx += 1
        else:
            arr[sorted_idx] = b[b_idx]
            b_idx += 1

        sorted_idx += 1

    while a_idx < len(a):
        arr[sorted_idx] = a[a_idx]
        a_idx += 1
        sorted_idx += 1

    while b_idx < len(b):
        arr[sorted_idx] = b[b_idx]
        b_idx += 1
        sorted_idx += 1


def merge_sort(arr, left_idx, right_idx):
    print(f"merge_sort ({left_idx}, {right_idx})")
    if left_idx >= right_idx:
        return

    mid_idx = (left_idx + right_idx) // 2
    merge_sort(arr, left_idx, mid_idx)
    merge_sort(arr, mid_idx + 1, right_idx)
    merge(arr, left_idx, right_idx, mid_idx)


# for reference
def merge_sort_iterative(arr, left_idx, right_idx):

    s = [(left_idx, right_idx)]
    q = []  # for ``merge```

    while s:

        left_idx, right_idx = s.pop(0)
        if left_idx >= right_idx:  # do not push to stack
            continue

        mid_idx = (left_idx + right_idx) // 2
        s.insert(0, (mid_idx + 1, right_idx))
        s.insert(0, (left_idx, mid_idx))
        q.append((left_idx, right_idx, mid_idx))

    while q:
        
        left_idx, right_idx, mid_idx = q.pop()
        merge(arr, left_idx, right_idx, mid_idx)


if __name__ == "__main__":

    # test merge_sort
    arr = [1,6,2,10,-1,9,5,12,5,8,9,-2,-1]
    print(arr)
    merge_sort(arr, 0, len(arr) - 1)
    print(arr)

    # test merge_sort_iterative
    arr = [1,6,2,10,-1,9,5,12,5,8,9,-2,-1]
    print(arr)
    merge_sort_iterative(arr, 0, len(arr) - 1)
    print(arr)