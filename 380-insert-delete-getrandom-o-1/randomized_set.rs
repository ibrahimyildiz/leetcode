use std::{collections::{HashMap, HashSet}, hash::Hash};
use rand::seq::{SliceRandom, index};

struct RandomizedSet {
    map: HashMap<i32, usize>,
    array: Vec<i32>,
}

impl RandomizedSet{
    fn new() -> Self {
        RandomizedSet{
            map: HashMap::new(),
            array: Vec::new(),
        }
    }

    fn insert(&mut self, val: i32) -> bool {
        if self.map.contains_key(&val) {
            return false;
        }

        self.map.insert(val, self.array.len());
        self.array.push(val);
        true
    }

    fn remove(&mut self, val: i32) -> bool {
        if let Some(&index) = self.map.get(&val) {
            let last_value = *self.array.last().unwrap();

            self.array[index] = last_value;
            self.map.insert(last_value, index);

            self.array.pop();
            self.map.remove(&val);

            true
        } else {
            false
        }
    }

    fn get_random(&self) -> i32 {
        let mut rng = rand::thread_rng();
        *self.array.choose(&mut rng).unwrap()
    }
}

fn main() {
    // Example usage:
    let mut randomized_set = RandomizedSet::new();
    println!("{}", randomized_set.insert(1)); // true
    println!("{}", randomized_set.remove(2)); // false
    println!("{}", randomized_set.insert(2)); // true
    println!("{}", randomized_set.get_random()); // Either 1 or 2
    println!("{}", randomized_set.remove(1)); // true
    println!("{}", randomized_set.insert(2)); // false
    println!("{}", randomized_set.get_random()); // 2
}

/*
do not forget to add the rand crate to your dependencies in the Cargo.toml file:

[dependencies]
rand = "0.8"
*/