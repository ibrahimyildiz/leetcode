pub fn sum_subarray_mins(arr: Vec<i32>) -> i32 {
    const MOD: i32 = 1_000_000_007;
    let n = arr.len();

    let mut result = 0;
    let mut stack: Vec<usize> = Vec::new();
    let mut left: Vec<usize> = vec![0; n];
    let mut right: Vec<usize> = vec![0; n];

    // Calculate the number of elements greater than the current element on the left
    for i in 0..n {
        while let Some(&top) = stack.last() {
            if arr[i] < arr[top] {
                stack.pop();
            } else {
                break;
            }
        }
        left[i] = stack.last().map_or(i + 1, |top| i - top);
        stack.push(i);
    }

    stack.clear();

    // Calculate the number of elements greater than the current element on the right
    for i in (0..n).rev() {
        while let Some(&top) = stack.last() {
            if arr[i] <= arr[top] {
                stack.pop();
            } else {
                break;
            }
        }
        right[i] = stack.last().map_or(n - i, |top| top - i);
        stack.push(i);
    }

    // Calculate the contribution of each element to the final result, considering modulo
    for i in 0..n {
        result = (result + (arr[i] as i64 * left[i] as i64 * right[i] as i64 % MOD as i64)) % MOD as i64;
    }

    result as i32
}

fn main() {
    let arr = vec![3, 1, 2, 4];
    println!("{}", sum_subarray_mins(arr)); // Output: 17
}