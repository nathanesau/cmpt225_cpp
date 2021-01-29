fn is_pow_2(x: i32) -> bool {
    if x == 1 {
        return true;
    }
    
    if x % 2 == 1 {
        return false;
    }

    return is_pow_2(x / 2);
}

fn main() {
    let vec: Vec<i32> = vec![1, 2, 2, 4, 3, 8, 4, 16, 5, 32];

    // filter powers of two which are greater than 10
    let filtered_vec = vec.iter().filter(|&item| {
        *item > 10 && is_pow_2(*item)
    }).collect::<Vec<&i32>>();

    println!("filtered_vec: {:?}", filtered_vec);
}
