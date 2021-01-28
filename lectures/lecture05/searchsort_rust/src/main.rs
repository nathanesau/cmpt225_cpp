fn search_sorted(arr: &Vec<i32>, element: i32) -> usize {
    let mut left: usize = 0;
    let mut right: usize = arr.len() - 1;
    let mut mid: usize = (left + right) / 2;

    while arr[mid] != element && left < right {
        if arr[mid] > element {
            right = mid - 1;
        } else {
            left = mid + 1;
        }

        mid = (left + right) / 2;
    }

    if arr[mid] == element {
        mid
    } else {
        arr.len()
    }
}

fn search_unsorted(arr: &Vec<i32>, element: i32) -> usize {
    for index in 0 .. arr.len() - 1 {
        if arr[index] == element {
            return index;
        }
    }
    
    return arr.len();
}

fn merge_sort(arr: &mut Vec<i32>, start: usize, end: usize) {
    if end > start {
        let mid = (start + end) / 2;
        merge_sort(arr, start, mid);
        merge_sort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
}

fn merge(arr: &mut Vec<i32>, start: usize, mid: usize, end: usize) {
    let mut tmp = vec![];

    let mut step1 = start;
    let mut step2 = mid + 1;

    while step1 <= mid || step2 <= end {
        if step1 > mid {
            tmp.push(arr[step2]);
            step2 += 1;
        }
        else if step2 > end {
            tmp.push(arr[step1]);
            step1 += 1;
        }
        else if arr[step1] < arr[step2] {
            tmp.push(arr[step1]);
            step1 += 1;
        }
        else if arr[step1] >= arr[step2] {
            tmp.push(arr[step2]);
            step2 += 1;
        }
    }

    for index in start ..= end {
        arr[index] = tmp[index - start];
    }
}

fn main() {
    let arr = vec![1, 3, 5, 7, 9];
    let index = search_sorted(&arr, 5);
    println!("found at index {}", index);

    let arr = vec![5, 1, 3, 9, 7];
    let index = search_unsorted(&arr, 9);
    println!("found at index {}", index);

    let mut arr = vec![5, 1, 3, 9, 7];
    let arr_len = arr.len();
    println!("unsorted array {:?}", arr);
    merge_sort(&mut arr, 0, arr_len - 1);
    print!("sorted array {:?}", arr);
}
