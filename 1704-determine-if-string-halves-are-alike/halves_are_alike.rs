pub fn halves_are_alike(s: String) -> bool {
    fn count_vowels(s: &str) -> usize {
        let vowels: Vec<char> = vec!['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
        s.chars().filter(|&c| vowels.contains(&c)).count()
    }

    let half_length = s.len() / 2;
    let first_half = &s[..half_length];
    let second_half = &s[half_length..];

    count_vowels(first_half) == count_vowels(second_half) 
}

// Example usage:
fn main() {
    let input_string = "AbCdEfGh";
    let result = halves_are_alike(input_string);
    println!("{}", result); // Output: true
}