def halves_are_alike(self, s: str) -> bool:
    def count_vowels(s):
        vowels = set('aeiouAEIOU')
        return sum(1 for char in s if char in vowels)

    half_length = len(s) // 2
    first_half = s[:half_length]
    second_half = s[half_length:]

    return count_vowels(first_half) == count_vowels(second_half)

# Example usage:
input_string = "AbCdEfGh"
result = halves_are_alike(input_string)
print(result)  # Output: True
